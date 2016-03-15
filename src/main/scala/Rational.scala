/**
 * Created by radhre on 27/10/15.
 */
class Rational(a : Int,b : Int)  {

  require(b!=0, "Denominator must be positive")
  def num = a
  def denom = b

  def this(x : Int) = this(x,1)

  def gcd(x: Int,y:Int):Int={
    if(y == 0)  x else gcd(y,x % y)
  }
  def simplify:Rational={
    new Rational(num/gcd(num,denom),denom/gcd(num,denom))
  }
  def add(that:Rational):Rational={
      new Rational(num * that.denom + denom * that.num,denom * that.denom)
  }
  def convertToString:String={
    num + "/" + denom
  }
  def neg:Rational={
    new Rational(-num,denom)
  }
  def prod(that:Rational):Rational={
    new Rational(num * that.num, denom * that.denom)
  }
  def lessThan(that:Rational):Boolean={
    num * that.denom < that.num * denom
  }
  def max(that:Rational):Rational={
    if(this.lessThan(that)) that else this
  }
}
object Rational{

  def main(args: Array[String]):Unit = {
    val x = new Rational(1,15)
    val y = new Rational(4,5)
    //To print a rational number of the form num/denom
    println(x.convertToString)
    println(y.convertToString)
    //To add to rational numbers
    println(x.add(y).convertToString)
    //To add two rational numbers and simplify the result
    println(x.add(y).simplify.convertToString)
    //To subtract a rational number from another
    println(x.add(y.neg).convertToString)
    //To subtract a rational number from another and simplify the result
    println(x.add(y.neg).simplify.convertToString)
    //Multiply two rational numbers
    println(x.prod(y).convertToString)
    //Multiply two rational numbers and simplify
    println(x.prod(y).simplify.convertToString)
    //To check if the rational number x is less than y
    println(x.lessThan(y))
    //To find the largest of the two rational numbers x and y
    println(x.max(y).convertToString)

  }
}
