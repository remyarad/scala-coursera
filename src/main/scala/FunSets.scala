/**
 * Created by radhre on 18/11/15.
 */
object FunSets {

  type Set = Int => Boolean

  def contains(s:Set, elem : Int):Boolean = s(elem)

  def singleToneSet(elem: Int): Set = (x => x ==elem)

  def intersect(s : Set, t : Set): Set = (x => contains(s, x) && contains(t, x))

  def union(s : Set, t : Set) : Set = (x => contains(s,x) || contains(t,x))

  def diff(s : Set, t : Set) : Set = (x => contains(s,x) &&  !contains(t,x))

  def filter(s : Set, p: Int => Boolean) : Set = (x  => s(x) && p(x))

  def forAll(s : Set, p: Int => Boolean): Boolean = {
    def iter(itrElem : Int): Boolean={
      if(contains(s,itrElem) && ! p(itrElem)) false
      else if (itrElem > 1000) true
      else iter(itrElem + 1)

    }
    iter(-1000)
  }

  def exists(s : Set,p: Int => Boolean): Boolean = {
    !forAll(s, x=>  !p(x))
  }

  def map(s : Set, f : Int => Int): Set = (y => exists(s, x => y==f(x)))

}
