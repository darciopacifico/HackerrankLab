import java.util.Scanner

import scala.collection.immutable.Stack

object RegexEstimator {

  def main(args: Array[String]) {
    val sc = new Scanner(System.in)
    val nTests = sc.nextInt()

    def readInputsAndCallRegex(lineRemain: Int): Unit = {
      if (lineRemain > 0) {
        val str = sc.nextLine()
        val args: Array[String] = str.split(" ")
        println(combinatoryRegex(args(0), args(1).toLong))

      }
    }
    readInputsAndCallRegex(nTests - 1)
  }

  /*
  ((ab)|(ba))     2     = 2
  ((a|b)*)        5     = 32
  ((a*)(b(a*)))   100   = 100
  */

  //def parseRegex(txt:String): Regex =parseRegex(txt.toList, "", List(Regex("",Nil,false,false)))
  def parseRegex(txt: String): Regex = parseRegex(txt.toList, List(Regex()))


  def combinatoryRegex(txt: String, chars: Long): Long = {
    val regex: Regex = parseRegex(txt)



    0l

  }


  def parseRegex(txtRegex: List[Char], regexParStack: List[Regex]): Regex = {
    txtRegex match {
      case '(' :: cs =>
        val nr = Regex()
        parseRegex(cs, nr :: regexParStack)

      case '|' :: cs =>

        val hc: Regex = regexParStack.head
        val tc: List[Regex] = regexParStack.tail

        if (tc.nonEmpty) {
          val hp = tc.head
          val tp = tc.tail
          parseRegex(cs, Regex() :: hp.copy(isOr = true, childRegex = hp.childRegex ::: List(hc)) :: tp)
        } else {
          parseRegex(cs, hc.copy(isOr = true) :: tc)
        }

      case ')' :: cs =>
        val hc = regexParStack.head
        val tc = regexParStack.tail

        if (tc.nonEmpty) {
          val hp = tc.head
          val tp = tc.tail

          parseRegex(cs, hp.copy(childRegex = hp.childRegex ::: List(hc)) :: tp)

        } else {
          parseRegex(cs, List(hc))
        }

      case '*' :: cs =>
        val h = regexParStack.head
        parseRegex(cs, h.copy(isMany = true) :: regexParStack.tail)

      case c :: cs =>
        val h = regexParStack.head
        parseRegex(cs, h.copy(cmd = h.cmd + c) :: regexParStack.tail)

      case Nil =>
        regexParStack.head
    }
  }
}


case class Regex(cmd: String, childRegex: List[Regex], isOr: Boolean, isMany: Boolean) {

  def countCombos(chars: Long, agg: Long): Long = {
    0l
  }
}

case object Regex {
  def apply(): Regex = Regex("", Nil, false, false)
}
