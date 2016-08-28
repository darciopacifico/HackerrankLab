import java.util.Scanner

object CountStringRegexAB_2 {

  def main(args: Array[String]) {
    val sc = new Scanner(System.in)
    val nTests = sc.nextInt()

    def readInputsAndCallRegex(lineRemain: Int): Unit = {
      if (lineRemain > 0) {
        val str = sc.nextLine()
        val args: Array[String] = str.split(" ")
        println(parseRegex(args(0).toList, args(1).toInt, "", 0))

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

  def parseRegex(chars: List[Char], qtdChars: Int, v:String, p: Long): Long = {
    0l

  }

}
