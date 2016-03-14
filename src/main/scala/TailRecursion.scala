/**
 * Created by radhre on 14/03/16.
 */
object TailRecursion {

  def factorial(n:Int):Int={
    def loop(acc:Int,n: Int):Int=
      if(n==0)acc  else loop(acc*n,n-1)
    loop(1,n)
  }
  def main (args: Array[String]){
    println("Factorial of 5 is: "+factorial(5))
  }
}
