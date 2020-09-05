
/**
 *
 * Created by darcio on 8/17/16.
 */
object BattleshipHitsSunks {

  def main(args: Array[String]) {

    println(solutionRecursive(8, "1A 8B,1D 2E", "1A 2A 3A 4A 5A 6A 7A 8A 1B 2B 3B 4B 5B 6B 7B 8B 1D 1E 2D 2E"))
    println(solutionRecursive(8, "1A 8B,1D 2E", "1D 1E 2D 2E"))
    println(solutionRecursive(8, "1A 8B,1D 2E", "1A 2A 3A 4A 5A 6A 7A 8A 1B 2B 3B 4B 5B 6B 7B 8B 1D 1E 2D"))
    println(solutionRecursive(8, "1A 8B,1D 2E", "1H 8H"))
    println(solutionRecursive(8, "1A 8B,1D 2E", "1A 8A"))
    println(solutionRecursive(8, "1A 8B,1D 2E", "1A 2E"))

  }

  def solutionRecursive(n: Int, s: String, t: String): String = {
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
