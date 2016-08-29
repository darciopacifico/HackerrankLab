
import org.scalatest.{Matchers, FlatSpec}

/**
 * Created by darcio on 8/28/16.
 */
class CombosTest extends FlatSpec with Matchers {
  /*
    "Combo test " should "estimate  when has chars enough " in {
      val regex = Regex("ab", Nil, false, true)
      assert(regex.countCombos(5) == List(
        (1, 5),
        (1, 3),
        (1, 1)))
    }

    it should "estimate when regex is greater than free chars" in {
      val regex = Regex("abcdefg", Nil, false, true)
      assert(regex.countCombos(5) == List((1, 5)))
    }

    it should "estimate when free chars are zero" in {
      val regex = Regex("abcdefg", Nil, false, true)
      assert(regex.countCombos(0) == List((1, 0)))
    }

    it should "estimate when free chars are zero on many=false regex node " in {
      val regex = Regex("abcdefg", Nil, false, false)
      assert(regex.countCombos(0) == Nil)
    }

    it should "estimate when regex is greater than free chars and many=false" in {
      //this nil list should mark this attempt as a fail
      val regex = Regex("abcdefg", Nil, false, false)
      assert(regex.countCombos(5) == Nil)
    }



    it should "estimate when are nested Regex " in {
  //this nil list should mark this attempt as a fail
  val regex =
    Regex("",List(
    Regex("ab", Nil, false, false),
    Regex("ba", Nil, false, false)
    ),true,false)

    assert(regex.countCombos(2) == 2)
  }
  */



  it should "estimate when are nested Regex for 5 chars " in {
    //this nil list should mark this attempt as a fail
    val regex = Regex("", List(
      Regex("b", Nil, false, false),
      Regex("a", Nil, false, false)
    ), true, true)

    assert(regex.countCombos(5) == 32)
  }


}
