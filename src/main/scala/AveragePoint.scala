/**
 * Created by darcio on 9/2/16.
 */
object AveragePoint {


  def main(args: Array[String]) {


    def averagePoint(points: (Double, Double)*): (Double, Double) = {
      val (sX,sY)= points.foldLeft((0.0, 0.0)) { case ((x1,y1), (x2,y2)) => (x1+x2,y1+y2)}
      (sX/points.size,sY/points.size)
    }

    println(averagePoint((2,2),(2,2),(2,2)))


  }

}
