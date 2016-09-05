
/**
 *
 * Created by darcio on 8/17/16.
 */
object BattleshipHitsSunks {

  def main(args: Array[String]) {
    println(solution(4, "1B 2C,2D 4D", "2B 2D 3D 4D 4A 1B 1C 2C"))
  }

  def solution(n: Int, s: String, t: String): String = {
    def max(c1: Char, c2: Char): Char = Math.max(c1, c2).toChar
    def min(c1: Char, c2: Char): Char = Math.min(c1, c2).toChar

    val strShips = s.split(",")
    val setShoots = t.split(" ").toSet

    val (tHits, tSunks) = strShips.foldLeft((0, 0)) { (count: (Int, Int), strShip: String) =>

      val cornerA :: cornerB :: _ = strShip.split(" ").toList

      val x1 :: y1 :: _ = cornerA.toList
      val x2 :: y2 :: _ = cornerB.toList

      val totalCoordShip: Set[String] =
        (for {x <- min(x1, x2) to max(x1, x2)
              y <- min(y1, y2) to max(y1, y2)} yield x + "" + y).toSet

      if (totalCoordShip.forall { c => setShoots.contains(c) }) {
        val (hits, sunk) = count
        (hits, sunk + 1)
      } else if (totalCoordShip.exists { c => setShoots.contains(c) }) {
        val (hits, sunk) = count
        (hits + 1, sunk)
      } else count
    }

    tHits + "," + tSunks
  }
}
