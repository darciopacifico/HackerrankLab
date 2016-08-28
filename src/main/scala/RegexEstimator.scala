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
        println(callRegex(args(0)))

      }
    }
    readInputsAndCallRegex(nTests - 1)
  }



  /*
  3
  ((ab)|(ba))     2     = 2
  Or(1, Literal(1), Literal(1) )

  ((a|b)*)        5     = 32
  Or(*,Literal(1),Literal(1))


  ((a|bb)*)        5     = 32
  Or(*,Literal(1),Literal(1))

  ((a*)(b(a*)))   100   = 100
  And(1, Literal(*), And(Literal(1),Literal(*) ))

  */

  def callRegex(txt: String): Regex =
    callRegex(
      Regex(List(), List(), false, false),
      txt.toList,
      "",
      List())


  def callRegex(regex: Regex, txt: List[Char], cmd: String, regexStack: List[Regex]): Regex = {

    txt match {
      case '(' :: cs =>
        callRegex(
          Regex(List(), List(), false, false),
          cs, cmd, regex :: regexStack)

      case '|' :: cs =>
        //store commeand into regex
        val newParentStack: List[Regex] = regexStack

        callRegex(regex.copy(cmds = regex.cmds:::List(cmd), isOr = true), cs, "", newParentStack )

      case ')' :: cs =>
        //include the command (aa, bb, etc)
        val regexChild = if(cmd.nonEmpty) regex.copy(cmds = regex.cmds:::List(cmd)) else regex

        val parentRegex = regexStack.head

        val newParentRegex = parentRegex.copy(childRegex = parentRegex.childRegex ::: List(regexChild))

        callRegex(newParentRegex, cs, "", regexStack.tail)

      case '*' :: cs =>
        callRegex(regex.copy(many = true), cs, cmd, regexStack)

      case c :: cs =>
        callRegex(regex, cs, cmd + c, regexStack)

      case Nil =>
        regex
    }
  }

  case class Regex(cmds: List[String], childRegex: List[Regex], isOr: Boolean, many: Boolean)

}
