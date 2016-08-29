import org.scalatest.{Matchers, FlatSpec}

/**
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
class RegexEstimatorTest extends FlatSpec with Matchers{


  "The Regex Estimator " should "parse correctly " in {
    {
      val regex = RegexEstimator.combinatoryRegex("(a|b)",0)
      println(regex)
    }
    {
      val regex = RegexEstimator.combinatoryRegex("*",0)
      println(regex)
    }
    {
      val regex = RegexEstimator.combinatoryRegex("((ab)|(ba))",0)
      println(regex)
    }
    {
      val regex = RegexEstimator.combinatoryRegex("((a|b)*)",0)
      println(regex)
    }
    {
      val regex = RegexEstimator.combinatoryRegex("((a|bb)*)",0)
      println(regex)
    }
    {
      val regex = RegexEstimator.combinatoryRegex("((a*)(b(a*)))*",0)
      println("")
    }


  }


}
