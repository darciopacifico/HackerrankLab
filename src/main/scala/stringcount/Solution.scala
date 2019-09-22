package stringcount

import java.io.PrintWriter

object Solution {

  /*
/*

((ab)|(ba)) 2
((a|b)*) 5
((a*)(b(a*))) 100

     * Complete the countStrings function below.
     */

   * Complete the countStrings function below.
   */
  def countStrings(r: String, l: Int): Int = {
    1
  }


  case class Node(val value: String)

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val t = stdin.readLine.trim.toInt

    for (tItr <- 1 to t) {
      val rl = stdin.readLine.split(" ")

      val r = rl(0)

      val l = rl(1).trim.toInt

      val result = countStrings(r, l)

      printWriter.println(result)
    }

    printWriter.close()
  }
}
