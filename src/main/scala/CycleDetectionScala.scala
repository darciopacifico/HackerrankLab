import scala.annotation.tailrec

/**
 * Created by darcio on 8/29/16.
 */
object CycleDetectionScala {

  class Node(var parent: Option[Node])

  def isCyclic(node: Node): Boolean = {

    @tailrec
    def isCyclic(n1: Option[Node], n2: Option[Node]): Boolean =
      (n1, n2) match {
        case (null, _) => false
        case (_, null) => false
        case (None, _) => false
        case (_, None) => false
        case (Some(a), Some(b)) if a == b => true
        case (Some(a), Some(b)) => isCyclic(a.parent, b.parent.flatMap(_.parent))
      }

    if (node == null)
      false
    else
      isCyclic(Some(node), Some(node).flatMap(_.parent))
  }


  def main(args: Array[String]) {

    val n1 = new Node(None)
    val n2 = new Node(Some(n1))
    val n3 = new Node(Some(n2))
    val n4 = new Node(Some(n3))
    val n5 = new Node(Some(n4))
    val n6 = new Node(Some(n5))
    val n7 = new Node(Some(n6))

    println(isCyclic(n7))

    n1.parent = Some(n5)

    println(isCyclic(n7))

    println(isCyclic(null))

  }

}
