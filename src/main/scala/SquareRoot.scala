/**
 * Created by radhre on 3/11/15.
 */
object SquareRoot {
  def main(args: Array[String]) {
    println(sqrt(1,16))

  }
  def sqrtItr(guess: Double, x: Double):Double={
    if(isGoodEnough(guess,x)) guess else sqrtItr(improve(guess,x), x)

  }
  def isGoodEnough(guess: Double, x: Double):Boolean = {
     abs(guess * guess - x)/x < 0.001
  }
  def improve(guess: Double, x: Double):Double={
    (guess + x/guess)/2
  }
  def abs(x: Double):Double = if (x > 0) x else -x
  def sqrt(guess: Double, x: Double):Double = sqrtItr(guess,x)
}
