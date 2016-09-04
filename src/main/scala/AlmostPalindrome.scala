/**
 * Coreated by darcio on 9/2/16.
 */
object AlmostPalindrome {

  def main(args: Array[String]) {

    def isAlmostPalindrome( txt:String):Boolean = {

      val MAX_ERROR = 1;
      var errCount = 0;

      (0 to txt.length/2).foreach{i=>
        val l = i
        val r = txt.length-i-1

        if(txt.charAt(l)!=txt.charAt(r)){
          errCount+=1
          if(errCount>MAX_ERROR) return false;
        }
      }

      return true
    }

    println(isAlmostPalindrome("abczzcba"))
    println(isAlmostPalindrome("abccba"))
    println(isAlmostPalindrome("abczcba"))
    println(isAlmostPalindrome("abccbx"))
    println(isAlmostPalindrome("abccfg"))


  }



}
