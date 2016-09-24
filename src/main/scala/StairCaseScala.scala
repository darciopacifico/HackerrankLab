

/**
 * Created by darcio on 8/17/16.
 */
object StairCaseScala {

  def main(args: Array[String]) {

    StairCase(6)

  }

  def StairCase(n: Int):Unit = {
    StairCase(n-1, 1)
  }


  def StairCase(spaces: Int, cerq: Int): Unit = {

    if(spaces>=0){

      print(" "*spaces)
      println("#"*cerq)


      StairCase(spaces-1,cerq+1)
    }


  }


}
