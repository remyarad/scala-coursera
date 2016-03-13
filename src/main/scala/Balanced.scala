/**
 * Created by radhre on 10/11/15.
 */
object Balanced {
  def main(args: Array[String]) {
     val st : String = "(just( an example"
     val ch = st.toList
     println(ch)
     println(balanceParanthesis(ch,0))
  }
  def balanceParanthesis(ch : List[Char], count : Int): Boolean = {
    if (ch.isEmpty) count == 0
    else if (count < 0) false
    else balanceParanthesis(ch.tail, countValue(ch.head, count))

  }
  def countValue(ch : Char, c : Int): Int = {
    ch match {
      case '(' => c + 1
      case ')' => c - 1
      case _ => c
    }
  }



}
