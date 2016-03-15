/**
 * Created by radhre on 14/03/16.
 */
object TailRecursion {

  def factorial(n:Int):Int={
    def loop(acc:Int,n: Int):Int=
      if(n==0)acc  else loop(acc*n,n-1)
    loop(1,n)
  }
  
  def sum(f:Int=>Int)(a:Int,b:Int):Int={
    def loop(a:Int,acc:Int):Int=
      if(a>b)acc else loop(a+1,f(a)+acc)
    loop(a,0)

  }
  def cube(x: Int):Int=x*x*x
  
  def main (args: Array[String]){
    println("Factorial of 5 is: "+factorial(5))
    println("Sum of cubes: "+sum(cube)(1,3))  
  }
}
