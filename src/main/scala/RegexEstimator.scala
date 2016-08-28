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
  3
  ((ab)|(ba))     2     = 2
  (  1 + 1  )^1
              0 ou 1

  ((a|bb)*)



  ((a|b)*)        5     = 32
   ( 2 )^5
  2*2*2*2*2

  ((a*)(b(a*)))   100   = 100

  100 () * 1 *1


  */

  def combinatoryRegex(txt: String, chars: Long): Long = {
    val regex: Regex = parseRegex(txt.toList, "", List())

    def combinatoryRegex(regex: Regex, chars: Long, agg: Long): Long = {

      val Regex(cmds,childRegex,isOr,isMany) = regex



      0l

    }

    combinatoryRegex(regex, chars, 0)
  }


  def parseRegex(txtRegex: List[Char], cmd: String, regexParStack: List[Regex]): Regex = {

    //append command to current regex
    def appendCommand(regex: Regex): Regex = if (cmd.nonEmpty) regex.copy(cmds = regex.cmds ::: List(cmd)) else regex


    txtRegex match {
      case '(' :: cs =>
        val regex = Regex(List(), List(), false, false)

        if (cmd.nonEmpty) {
          val h = regexParStack.head
          val t = regexParStack.tail
          parseRegex(cs, "", regex :: h.copy(cmds = h.cmds ::: List(cmd)) :: t)

        } else {
          parseRegex(cs, "", regex :: regexParStack)
        }

      case '|' :: cs =>

        val regex = regexParStack.head.copy(isOr = true)
        val parentTail = regexParStack.tail

        parseRegex(cs, "", appendCommand(regex) :: parentTail)

      case ')' :: cs =>
        val regex = regexParStack.head
        val regexStack = regexParStack.tail

        if (regexStack.nonEmpty) {
          //nest into the parent
          val parentRegex = regexStack.head
          val newParentRegex = parentRegex.copy(childRegex = parentRegex.childRegex ::: List(appendCommand(regex)))
          parseRegex(cs, "", newParentRegex :: regexStack.tail)

        } else {
          parseRegex(cs, "", appendCommand(regex) :: regexStack)
        }


      case '*' :: cs =>
        val regex = regexParStack.head
        val regexStack = regexParStack.tail
        parseRegex(cs, cmd, regex.copy(isMany = true) :: regexStack)

      case c :: cs =>
        val regex = regexParStack.head
        val regexStack = regexParStack.tail
        parseRegex(cs, cmd + c, regex :: regexStack)

      case Nil =>
        val regex = regexParStack.head
        val regexStack = regexParStack.tail

        assert(regexStack == Nil)

        regex
    }
  }

  case class Regex(cmds: List[String], childRegex: List[Regex], isOr: Boolean, isMany: Boolean)

}
