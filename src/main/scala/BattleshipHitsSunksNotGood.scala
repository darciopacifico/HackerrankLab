import scala.collection.immutable.IndexedSeq

/**
 *
 * Created by darcio on 8/17/16.
 */
object BattleshipHitsSunksNotGood {
  def main(args: Array[String]) {
    println(

      solution(4, "1B 2C,2D 4D", "2B 2D 3D 4D 4A 1B 1C 2C")
    )
  }

  def solution(n: Int, s: String, t: String): String = {

    val strShips = s.split(",")
    val strShoot = t.split(" ").toSet

    val coordShip: List[List[(Int, Int)]] = strShips.map {
      _.split(" ").toList.map { s =>
        s.toList match {
          case a :: b :: cs => (new Integer("" + a).toInt, b.toInt - 64)
        }
      }
    }.toList


    val totalCoord = coordShip.map { (s: List[(Int, Int)]) =>
      val ((x1, y1)) :: ((x2, y2)) :: _ = s

      val minX = Math.min(x1, x2)
      val maxX = Math.max(x1, x2)

      val minY = Math.min(y1, y2)
      val maxY = Math.max(y1, y2)

      for {x <- minX to maxX
           y <- minY to maxY} yield ("" + x) + (y + 64).asInstanceOf[Char]

    }


    val sunK = totalCoord.map { (nc: IndexedSeq[String]) =>
      if (nc.toSet.forall(ccc => strShoot.contains(ccc))) {
        1
      } else {
        0
      }
    }

    val hit = totalCoord.map { (nc: IndexedSeq[String]) =>
      if (nc.toSet.forall(ccc => strShoot.contains(ccc))) {
        0
      } else {
        if (nc.toSet.exists(ccc => strShoot.contains(ccc))) {
          1
        } else {
          0
        }
      }
    }

    hit.sum + "," + sunK.sum

  }

}
