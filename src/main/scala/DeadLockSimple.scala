import scala.collection.immutable.IndexedSeq
import scala.concurrent.{Await, Future}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._

object DeadLockSimple {

  case class Account(id: Int, var amount: Double)

  def main(args: Array[String]) {
    val anaAccount = Account(1, 10000)
    val bobAccount = Account(1, 5000)

    //at some time both futures will be wait by each other.
    //the order of locking will lead to an dead lock situation
    val fs: IndexedSeq[Future[Double]] = (0 to 100000).map { _ =>
      Future {transfer(anaAccount, bobAccount, 3)}
      Future {transfer(bobAccount, anaAccount, 3)}
    }

    fs.foreach { f => Await.ready(f, 3 second) }

    println(anaAccount.amount)
    println(bobAccount.amount)
  }

  def transfer(from: Account, to: Account, value: Double): Double = {
    from.synchronized {
      to.synchronized {
        from.amount = from.amount - value;
        to.amount = to.amount + value;
      }
    }
    value
  }
}
