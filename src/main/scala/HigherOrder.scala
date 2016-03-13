/**
 * Created by radhre on 3/11/15.
 */
object HigherOrder {
  def main(args: Array[String]) {

    println("Sum of Cubes of all numbers between 1 and 4: "+sumOfCubes(1,4))

    println("Sum of factorials of all consecutive numbers between given numbers 1 and 4: "+sumOfFactorial(1,4))

    //Different implementation of sum of cubes of all numbers between 1 and 4
    println("Different implementation of sum of cubes of all numbers between 1 and 4: "+sum (x => x * x * x) (1,4))

    println("Different implementation of sum of factorial of all numbers between 1 and 4: "+sum(fact)(1, 4))

    println("Product of Cubes of all numbers between 1 and 4: "+product(cube)(1,4))

    //Product of cubes of all consecutive numbers between 1 and 4 using mapReduce method
    println("MapReduce method for Product of cubes of all numbers between 1 and 4: "+mapReduce(cube, (x, y) => x * y,1)(1,4))

    //Sum of cubes of all consecutive numbers between 1 and 4 using mapReduce method
    println("MapReduce method for Sum of cubes of all numbers between 1 and 4 :"+mapReduce(cube, (x, y) => x + y,0)(1,4))

    //Test method for sum of fact
    assert(sum(fact) (1, 4) ==  sumOfFactorial(1,4), "Methods are not implemented correctly")


  }
  //Sum of cubes of all consecutive numbers between given number a and b
  def sumOfCubes(a : Int, b : Int):Int={
    if(a > b) 0
    else cube(a) + sumOfCubes(a+1, b)
  }
  //Sum of factorials of all consecutive numbers between given number a and b
  def sumOfFactorial(a : Int, b : Int): Int ={
    if(a > b) 0
    else fact(a) + sumOfFactorial(a+1, b)

  }
  /* Result obtained when Intermediate Results obtained when a function (here fact)is applied seperately to
   all consecutive numbers between given number a and b are then added together */
  def sum(f : Int => Int)(a : Int, b : Int): Int = {
     if (a > b) 0
      else f(a) + sum(f) (a + 1, b)
    }

  /* Result obtained when Intermediate Results obtained when a function (here cube) is applied seperately to
   all consecutive numbers between given number a and b are then multiplied together */

  def product(f : Int => Int)(a : Int, b : Int): Int = {
   if (a > b) 1
    else f(a) * product(f) (a + 1, b)
  }

  def mapReduce(f : Int => Int, combine : (Int, Int) =>  Int, zero : Int)(a : Int, b : Int): Int = {
    if (a > b) zero
    else combine(f(a), mapReduce(f, combine,zero) (a + 1, b))
  }

  //Function to get the factorial of a given number
  def fact(n : Int): Int = {

    if (n == 0) 1 else n * fact(n -1)
  }
  //Function to get the cube of a given number
  def cube(a:Int):Int= a * a * a

}
