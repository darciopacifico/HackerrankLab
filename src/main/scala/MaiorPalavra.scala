/**
 * Created by darcio on 9/3/16.
 */
object MaiorPalavra {

  def main(args: Array[String]) {

    val str =
      """Essa primeira parte da demo da BGS, que também foi mostrada da E3 em junho, é um tutorial de como
        | ser o Batman - do momento em que se veste a roupa até a hora em que se atira o batarang. Colocar o
        |  capuz do Homem-Morcego e enxergar o cinto de utilidades na cintura são só alguns dos momentos de
        |  exaltação da experiência. Ver as próprias mãos se mexerem digitalmente (remasteri e poder acender uma lanterna
        |  para explorar a Bat-caverna também fazem parte da imersão - com certeza uma das melhores da feira.""".stripMargin

    println(
      getMaiorPalavra(str)
    )
  }

  def getMaiorPalavra(str: String): String = {
    str.split(" ").toList.sortBy(_.length).last
  }
}
