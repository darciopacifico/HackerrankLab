import java.util.Scanner

import scala.collection.mutable

/**
 * Created by darcio on 8/10/16.
 */
object LabScala {

  def main(args: Array[String]) {

    trait Iterator[T] {
      def hasNext: Boolean

      def next(): T

      def foldLeft[S](z: S)(f: (S, T) => S): S = {
        var result = z

        while (hasNext) result = f(result, next())

        result
      }
    }



    trait Traversable[T] {
      def foreach(f: T => Unit): Unit

      def newBuilder: mutable.Builder[T, Traversable[T]]

      def filter(p: T => Boolean): Traversable[T] = {
        val b = newBuilder

        foreach(elem => if (p(elem)) b += elem)

        b.result
      }

    }


  }

}
