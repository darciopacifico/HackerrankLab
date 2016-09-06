

object RegexEstimator {

  class State(var name: String, var outs: Set[Transition], val isFim: Boolean = false)

  object Transition {
    def apply(isEpsilom: Boolean) = new Transition(isEpsilom, "", null, false)
  }

  class Transition(val isEpsilon: Boolean, var str: String, var out: State, var isStar: Boolean) {
    def nonEmpty: Boolean = str != null && str.nonEmpty

    def +(c: Char): Transition = {
      str = str + c
      this
    }

    def getParts(): (List[Transition], Boolean) = {
      def getParts(regex: List[Char], part: Transition, par: Integer, parts: List[Transition], isOr: Boolean): (List[Transition], Boolean) = {
        //if (part.str.isEmpty && parts.isEmpty && par == 0)
        //println("Regex: " + new String(regex.toArray))

        regex match {
          case '(' :: cs =>
            if (par == 0)
              getParts(cs, Transition(false), par + 1, parts, isOr)
            else
              getParts(cs, part + '(', par + 1, parts, isOr)

          case ')' :: cs =>
            val nPar = par - 1
            if (nPar == 0)
              getParts(cs, Transition(false), nPar, (if (part.nonEmpty) List(part) else Nil) ::: parts, isOr)
            else if (nPar > 0)
              getParts(cs, part + ')', nPar, parts, isOr)
            else
              throw new IllegalArgumentException("Unbalanced regex expression!")

          case '|' :: cs =>
            if (par == 0)
              getParts(cs, Transition(false), par, (if (part.nonEmpty) List(part) else Nil) ::: parts, true)
            else
              getParts(cs, part + '|', par, parts, isOr)

          case '*' :: cs =>
            if (par == 0) {
              val newParts = (if (part.nonEmpty) List(part) else Nil) ::: parts
              newParts.head.isStar = true
              getParts(cs, Transition(false), par, newParts, isOr)
            } else
              getParts(cs, part + '*', par, parts, isOr)

          case c :: cs =>
            getParts(cs, part + c, par, parts, isOr)

          case Nil =>
            ((if (part.nonEmpty) List(part) else Nil) ::: parts, isOr)
        }
      }

      if (str.exists(Set('(', ')', '|', '*').contains)) {
        getParts(str.toList, Transition(false), 0, Nil, isOr = false)
      } else {
        (Nil, false)
      }

    }
  }


  def main(args: Array[String]) {
    def assemblyAnd(a: State, b: State, parts: List[Transition]): Unit = {
      def assemblyAnd(aa: State, ts: List[Transition], bb: State): Unit =
        ts match {
          case headTrans :: Nil =>
            assemblyNFA(aa, headTrans, bb)
          case heatTrans :: tailTrans =>
            val interState = new State("interState", Set())
            assemblyNFA(aa, heatTrans, interState)
            assemblyAnd(interState, tailTrans, bb)
          case Nil =>
          //wat??
        }

      val (a2: State, b2: State) = generateEpsilons(a, b)
      assemblyAnd(a2, parts.reverse, b2)
    }


    def assemblyStar(a: State, b: State, part: Transition): Unit = {
      //            a           t            b
      //   a--t1-->a2           t            b2-->t2-->b
      //   a--t1-->a2-->t3--a3  t  b3-->t3-->b2---->t2---->b

      val a2 = new State("", Set())
      val b2 = new State("", Set())

      val e1 = new Transition(true, "", null, false)
      val e2 = new Transition(true, "", null, false)
      val e3 = new Transition(true, "", null, false)
      val e4 = new Transition(true, "", null, false)

      a2.outs = a.outs
      b2.outs = Set(e4,e3)
      a.outs = Set(e1, e2)
      b.outs = b.outs

      e1.out = a2
      e2.out = b
      e3.out = a2
      e4.out = b

      part.isStar = false
      part.out = null
      assemblyNFA(a2, part, b2)
    }

    def assemblyStarErr(a: State, b: State, part: Transition): Unit = {
      //            a           t            b
      //   a--t1-->a2           t            b2-->t2-->b
      //   a--t1-->a2-->t3--a3  t  b3-->t3-->b2---->t2---->b

      val (a2: State, b2: State) = generateEpsilons(a, b)
      val (a3: State, b3: State) = generateEpsilons(a2, b2)

      val epsilonMany1 = new Transition(true, "Epsilon * <", a3, false)
      b2.outs = b2.outs + epsilonMany1

      val epsilonMany2 = new Transition(true, "Epsilon * >", b2, false)
      a2.outs = a2.outs + epsilonMany2

      part.isStar = false
      assemblyNFA(a3, part, b3)
    }

    def assemblySingle(a: State, b: State, part: Transition): Unit = {
      val (a2: State, b2: State) = generateEpsilons(a, b)
      assemblyNFA(a2, part, b2)
    }
    def assemblyOr(a: State, b: State, parts: List[Transition]): Unit = {
      parts.foreach { t =>
        val (a2: State, b2: State) = generateEpsilons(a, b)
        assemblyNFA(a2, t, b2)
      }
    }
    def assemblyNFA(a: State, transition: Transition, b: State): Unit = {
      val (parts, isOr) = transition.getParts()

      if (parts.isEmpty) {
        a.outs = Set(transition)
        transition.out = b
      } else if (transition.isStar)
        assemblyStar(a, b, transition)
      else {
        if (parts.size > 1) {
          if (isOr)
            assemblyOr(a, b, parts)
          else
            assemblyAnd(a, b, parts)
        } else {
          assemblySingle(a, b, parts.head)
        }
      }
    }

    /*
    ((ab)|(ba)) 2
    ((a|b)*) 5
    ((a*)(b(a*))) 100
    */


    def estimateRegex(start: State, qtdChars: Integer): BigInt = {

      var count: BigInt = 0

      def estimateRegex(state: State, qtdChars: Integer, string: StringBuffer): Unit = {

        if (state.isFim) {
          if (qtdChars == 0)
            count = count + 1
        } else if (qtdChars >= 0) {
          state.outs.foreach { t =>
            if (t.isEpsilon) {
              estimateRegex(t.out, qtdChars, string)
            } else {
              estimateRegex(t.out, qtdChars - t.str.length, string)
            }
          }
        }

      }

      estimateRegex(start, qtdChars, new StringBuffer())

      count
    }


    def countPossibilities(regex: String, qtdChars: Integer): BigInt = {
      val start = new State("inicio", Set())

      assemblyNFA(start, new Transition(false, regex, null, false), new State("fim", Set(), true))

      estimateRegex(start, qtdChars)
    }

    println(countPossibilities("((ab)|(ba))", 2))
    println(countPossibilities("((a|b)*)", 5))
    println(countPossibilities("((a*)(b(a*)))", 100))
    println(countPossibilities("((b(a*)))", 100))

  }

  def generateEpsilons(a: State, b: State): (State, State) = {
    val (a2, b2, _, _) = generateEpsilonsT(a, b)
    (a2, b2)
  }

  def generateEpsilonsT(a: State, b: State): (State, State, Transition, Transition) = {
    //            a        t        b
    //   a--t1-->a2        t        b2---->t2---->b
    val t1 = new Transition(true, "dummyEpsilon1", null, false)
    val t2 = new Transition(true, "dummyEpsilon2", null, false)
    val a2 = new State("dummyStateA2", Set())
    val b2 = new State("dummyStateA2", Set())

    a.outs = a.outs + t1
    t1.out = a2
    //a2.outs = Set(t)
    //t.out = b2
    b2.outs = Set(t2)
    t2.out = b
    (a2, b2, t1, t2)
  }
}























