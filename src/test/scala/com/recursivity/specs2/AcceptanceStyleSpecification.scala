package com.recursivity.specs2

import org.specs2.Specification
import org.specs2.matcher.Hamcrest
import org.specs2.ScalaCheck
import org.hamcrest.{BaseMatcher,Description}
import org.scalacheck._

class AcceptanceStyleSpecification extends Specification with Hamcrest with ScalaCheck{ def is = 

  "This is an Acceptance Style Specification" ^
   p^
     "An Acceptance specification can" ^
       "Have arbitrary amounts of indentation" ^
         "with assertions at any point" ! wordContains("Hello", "ello")^
           "foo bar" ^	
   endp^
     "A Specs2 Specification should" ^
       "be able to re-use Hamcrest based matchers" ! hamCrestMatcherAssertion(2)^
       "display meaningful error messages" ! hamCrestMatcherAssertion(3)^
   endp^
     "Sorting should always conform to the following rules (Property based test):" ^
       "a sorted list should preserve size" ! preserveSize^
       "the next element must be equal to- or greater than the last" !enforceOrdering^
   end

  // assertions can be combined with 'and', 'not', 'or', 'eventually' (for timing based testing) to read very human readably.
  def wordContains(fullWord: String, subString: String) = 
    fullWord must contain(subString) and endWith(subString) and not have size(subString.length)
  	

  def hamCrestMatcherAssertion(number: Int) = 
    number must beEven


  // a couple of assertions using ScalaCheck property based testing, generates test data for you and runs 100 tests (by default)
  def preserveSize = 
    Prop.forAll{(list: List[Int]) =>
      list.size == list.sorted.size
    }

  def enforceOrdering = 
    Prop.forAll{(list: List[Int]) =>
      val (highestInt, heldProperty) = list.sorted.foldLeft((Integer.MIN_VALUE, true))((accumulator, nextInt) => {
	val (lastInt, passed) = accumulator
	if(passed)
	  (nextInt, lastInt <= nextInt)
        else
	  accumulator
      })
      heldProperty
    }
  

   // a Hamcrest matcher for even numbers
  val beEven = new BaseMatcher[Int] {
    def matches(item: Object): Boolean       = item.toString.toInt % 2 == 0
    def describeTo(description: Description) { description.appendText(" is odd") }
  }			
}
