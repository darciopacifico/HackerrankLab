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

  "the regex " should "become a or state machine " in {





  }

}
