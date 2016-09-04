

object RegexEstimator {

  sealed trait TType

  case object STAR extends TType

  case object OR extends TType

  case object AND extends TType

  case object SINGLE extends TType


  object Transition {
    def apply() = new Transition("", null, false)
  }

  class Transition(var str: String, var saida: State, var isMany: Boolean) {
    def nonEmpty: Boolean = str != null && str.nonEmpty

    def +(c: Char): Transition = {
      str = str + c
      this
    }

    def getType(): (List[Transition], TType) = {

      def getParts(regex: List[Char], part: Transition, par: Integer, parts: List[Transition], isOr: Boolean): (List[Transition], Boolean) = {

        if (part.str.isEmpty && parts.isEmpty && par == 0)
          println("Regex: " + new String(regex.toArray))

        regex match {
          case '(' :: cs =>
            if (par == 0)
              getParts(cs, Transition(), par + 1, parts, isOr)
            else
              getParts(cs, part + '(', par + 1, parts, isOr)

          case ')' :: cs =>
            val nPar = par - 1
            if (nPar == 0)
              getParts(cs, Transition(), nPar, (if (part.nonEmpty) List(part) else Nil) ::: parts, isOr)
            else if (nPar > 0)
              getParts(cs, part + ')', nPar, parts, isOr)
            else
              throw new IllegalArgumentException("Unbalanced regex expression!")

          case '|' :: cs =>
            if (par == 0)
              getParts(cs, Transition(), par, (if (part.nonEmpty) List(part) else Nil) ::: parts, true)
            else
              getParts(cs, part + '|', par, parts, isOr)

          case '*' :: cs =>
            if (par == 0) {

              val newParts = (if (part.nonEmpty) List(part) else Nil) ::: parts
              newParts.head.isMany = true
              getParts(cs, Transition(), par, newParts, isOr)

            } else
              getParts(cs, part + '*', par, parts, isOr)

          case c :: cs =>
            getParts(cs, part + c, par, parts, isOr)

          case Nil =>

            ((if (part.nonEmpty) List(part) else Nil) ::: parts, isOr)
        }
      }

      val (parts: List[Transition], isOr: Boolean) =
        if (isNotSingle(str)) {
          getParts(str.toList, new Transition("", null, false), 0, Nil, isOr = false)
        } else {
          (new Transition(str, null, false) :: Nil, false)
        }

      val ttype =
        if (parts.length > 1)
          if (isOr)
            OR
          else
            AND
        else if (parts.length == 1)
          if (parts.head.isMany)
            STAR
          else
            SINGLE
        else
          throw new IllegalArgumentException("Error trying to breakdown into parts! parts.size=0 !!")

      (parts, ttype)

    }
  }

  class State(var saidas: Set[Transition])

  def main(args: Array[String]) {
    // ((a*)(b(a*)))
    // a*(b)
    // ((a|b)*)
    // (a|b)*
    // (a)*
    // a*
    // (a*)
    // (((a*)))


    val start: State = parseRegex("a|(bc)*")
    println(start)
    /*

        val a = new State(Set())
        val b = new State(Set())
        val t = new Transition("zzz", null, false)
        val f = new Transition("fim", null, false)


        a.saidas = Set(t)
        t.saida = b
        b.saidas = Set(f)

        parseRegexStar(a, t, b)

        println(a)
    */


  }

  def parseRegex(regex: String): State = {
    val end = new State(Set())
    val transition = new Transition(regex, null, false)
    val start = new State(Set())
    parseRegex(start, transition, end)
  }

  def parseRegex(start: State, origTr: Transition, end: State): State = {


    origTr.getType() match {

      case (trs: List[Transition], STAR) =>
        parseRegexStar(start, trs.head, end)

      case (trs, OR) =>
        parseRegexOr(start, trs, end)

      case (trs, AND) =>
        parseRegexAnd(start, trs, end)

      case (trs, SINGLE) =>
        parseRegexSingle(start, trs.head, end)

    }
    start
  }

  def parseRegexStar(a: State, transition: Transition, b: State): Unit = {

    val a2 = new State(Set())
    val b2 = new State(Set())

    val e1 = new Transition("", null, false)
    val e2 = new Transition("", null, false)
    val e3 = new Transition("", null, false)
    val e4 = new Transition("", null, false)

    a2.saidas = Set(transition)
    transition.saida = b2

    a.saidas = Set(e1, e2)
    b2.saidas = Set(e4)
    b.saidas = b.saidas ++ Set(e3) // todo concat??

    e1.saida = a2
    e2.saida = b
    e3.saida = a2
    e4.saida = b

    parseRegex(a2, transition, b2)
  }

  def parseRegexOr(start: State, transitions: List[Transition], end: State) = {

    transitions.foreach { t =>
      parseRegex(start,t,end)
      start.saidas = start.saidas + t
      t.saida=end

    }


  }

  def parseRegexAnd(start: State, transitions: List[Transition], end: State): Unit = {

    transitions match {

      case t :: ts =>

        if (ts.nonEmpty) {
          val interState = new State(Set())
          parseRegex(start, t, interState)
          parseRegexAnd(interState, ts, end)

        } else {
          parseRegex(start, t, end)
        }

      case Nil =>
        println("empty transition")
    }


  }

  def parseRegexSingle(start: State, transition: Transition, end: State): Unit = {

    if (isNotSingle(transition)) {
      parseRegex(start, transition, end)

    } else {
      //start.saidas = Set(transition)
      //transition.saida = end

    }


  }

  def isNotSingle(transition: Transition): Boolean = {
    val str: String = transition.str
    isNotSingle(str)
  }

  def isNotSingle(str: String): Boolean = {
    str.contains('*') ||
      str.contains('(') ||
      str.contains(')') ||
      str.contains('|')
  }
}