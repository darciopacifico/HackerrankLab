/**
 * Created by darcio on 9/2/16.
 */
object MostPopularNumber {

  def main(args: Array[String]) {

    def MostPopularNumber (arr: Array[Int], qtt:Int): Int ={

      val mapNumbers = scala.collection.mutable.Map[Integer,Integer]() withDefaultValue 0

      arr.foreach{ n => mapNumbers(n) += 1}

      val (number,_) = mapNumbers.toList.sortWith{

        case ((n1,q1),(n2,q2))=> if(q1>q2)
          true
        else if (q1<q2)
          false
        else
          n1<n2
      }.head

      number
    }

    println (MostPopularNumber(Array(
      9,9,9,9,9,
      3,3,3,3,3,3,
      2,2,2,2,2,
      1,1,1
    ),3))


    println (MostPopularNumber(Array(
      66
    ),3))
  }

}
