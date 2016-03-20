/**
 * Created by radhre on 17/03/16.
 */
import java.util.Random
import java.util.Scanner
object BattleShip {

  def main (args: Array[String]){
    println("Battle Ship")
    var hits:Int = 0
    val sizeOfShip : Int = 6
    val maxAttempts : Int = 10
    var attempts : Int = 0
    val board : Array[Array[String]] = Array.ofDim[String](8,8)
    val myBoard : Array[Array[String]] = createBoard(board)
    breakline
    showBoard(myBoard)
    breakline
    println("Placing the ship of size "+sizeOfShip)
    createRandonShip("horiz", sizeOfShip,myBoard)
    showBoard(myBoard)
    while(attempts < maxAttempts && hits<sizeOfShip) {
      hits += userFire(myBoard)
      attempts+=1
      showBoard(myBoard)
    }
    if(hits==sizeOfShip)
      println("Ship is sunk..You won !!")
    if(attempts==maxAttempts && hits!=sizeOfShip)
      println("You lost..")
  }
  def createBoard(board:Array[Array[String]]):Array[Array[String]]= {
    for (i <- 0 to board.length-1) {
      for (j <- 0 to board(0).length-1) {
        board(i)(j) = "~"
      }
    }
    return board
  }
  def showBoard(board:Array[Array[String]]):Array[Array[String]]= {
    for (a <- 0 to board.length-1) {
      for (b <- 0 to board(0).length-1) {
        if(b==board(0).length-1)
          println(board(a)(b))
        else
          print(board(a)(b)+" ")
      }
    }
    return board
  }
  def breakline():Unit={
    println("----------------------------------")

  }

  def userFire(board:Array[Array[String]]): Int ={
      val input = new Scanner(System.in)
      var hit :Int = 0
      println("Select a row to fire in")
      var row:Int = input.nextInt
      while(row>7 || row <0) {
        println("Enter a valid row (0 ->7)")
        row = input.nextInt
      }
      println("Select a column to fire in")
      var col:Int = input.nextInt
      while(col>7 || col <0){
        println("Enter a valid column (0->7)")
        col = input.nextInt
      }
      board(row)(col) match {
        case "S" => {
          println("-------------HIT------------")
          board(row)(col)="H"
          return hit+1
        }
        case "H" => {
          println("This was already a hit")
          return 0
        }
        case _  => {
          println("--------------MISS-----------")
          board(row)(col)="M"
          return  0
        }

      }
  }

  def createRandonShip(align:String, sizeOfShip:Int, board : Array[Array[String]]):Array[Array[String]]={
    val iter:Int = 0
    val randomno = new Random()
    val row = randomno.nextInt(board.length)
    val start:Int = randomno.nextInt(board(0).length)
    val right:Int = start + sizeOfShip - 1
    val left:Int = start -sizeOfShip + 1
    val up:Int = row - sizeOfShip + 1
    val down:Int = row + sizeOfShip - 1
    align match {
      case "horiz" =>
        if (start + sizeOfShip < board(0).length) {
          for (i: Int <- start to right) {
            board(row)(i) = "S"
          }
        } else if(start - sizeOfShip > 0) {
            for (i: Int <- start to left by -1) {
              board(row)(i) = "S"
            }
          }
        else
            createRandonShip(align,sizeOfShip,board)
      case "vertical" =>
        if (row + sizeOfShip < board.length) {
          for (i: Int <- row to down) {
            board(i)(start) = "S"
          }
        } else if(row - sizeOfShip > 0) {
          for (i: Int <- row to up by -1) {
            board(i)(start) = "S"
          }
        }else
          createRandonShip(align,sizeOfShip,board)
    }

    return board
  }


}
