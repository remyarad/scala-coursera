Basic Functions on Sets

Let’s start by implementing basic functions on sets.

Define a function which creates a singleton set from one integer value: the set represents the set of the one given element. Its signature is as follows:

def singletonSet(elem: Int): Set
Now that we have a way to create singleton sets, we want to define a function that allow us to build bigger sets from smaller ones.

Define the functions union, intersect, and diff, which takes two sets, and return, respectively, their union, intersection and differences. diff(s, t) returns a set which contains all the elements of the set s that are not in the set t. These functions have the following signatures:

def union(s: Set, t: Set): Set
def intersect(s: Set, t: Set): Set
def diff(s: Set, t: Set): Set

Define the function filter which selects only the elements of a set that are accepted by a given predicate p. The filtered elements are returned as a new set. The signature of filter is as follows:
def filter(s: Set, p: Int => Boolean): Set

2.2 Queries and Transformations on Sets

In this part, we are interested in functions used to make requests on elements of a set. The first function tests whether a given predicate is true for all elements of the set. Thisforall function has the following signature:

def forall(s: Set, p: Int => Boolean): Boolean
Note that there is no direct way to find which elements are in a set. contains only allows to know whether a given element is included. Thus, if we wish to do something to all elements of a set, then we have to iterate over all integers, testing each time whether it is included in the set, and if so, to do something with it. Here, we consider that an integerx has the property -1000 <= x <= 1000 in order to limit the search space.

Implement forall using linear recursion. For this, use a helper function nested in forall. Its structure is as follows (replace the ???):

def forall(s: Set, p: Int => Boolean): Boolean = {
 def iter(a: Int): Boolean = {
   if (???) ???
   else if (???) ???
   else iter(???)
 }
 iter(???)
}

Using forall, implement a function exists which tests whether a set contains at least one element for which the given predicate is true. Note that the functions foralland exists behave like the universal and existential quantifiers of first-order logic.

def exists(s: Set, p: Int => Boolean): Boolean
Finally, write a function map which transforms a given set into another one by applying to each of its elements the given function. map has the following signature:

def map(s: Set, f: Int => Int): Set
