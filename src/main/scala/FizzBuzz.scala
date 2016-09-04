object FizzBuzz {

  def main(args: Array[String]) {

    def if1FizzBuzz(): Unit = {
      (1 to 100).foreach { n =>
        if (n % 3 == 0 || n % 5 == 0) {
          if (n % 3 == 0) print("fis")
          if (n % 5 == 0) print("bus")
        } else {
          print(n)
        }
        println()
      }
    }

    def if2FizzBuzz(): Unit = {
      (1 to 100).foreach { n =>
        if (n % 5 == 0 && n % 3 == 0) {
          print("fisbus")
        } else if (n % 3 == 0) {
          print("fis")
        } else if (n % 5 == 0) {
          print("bus")
        } else {
          print(n)
        }
        println()
      }
    }

    def pmFizzBuzz(): Unit = {
      (1 to 100).foreach { n =>
        (n % 3 == 0, n % 5 == 0) match {
          case (true, true) => println("fisbus")
          case (false, true) => println("bus")
          case (true, false) => println("fis")
          case (false, false) => println(n)
        }
      }
    }

  }
}
