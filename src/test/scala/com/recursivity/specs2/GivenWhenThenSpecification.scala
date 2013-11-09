package com.recursivity.specs2

import org.specs2.Specification
import org.specs2.specification.script.StandardDelimitedStepParsers
import org.specs2.specification.script.GWT

class GivenWhenThenSpecification extends Specification with GWT with StandardDelimitedStepParsers { def is = s2"""

 Let's add numbers!

  Given the first number is {1}         ${addition.start}
  When I add it to {2}
  Then I get {3}                  ${addition.end}
  """

  lazy val addition = Scenario("addition").
                        given(anInt).
                        when(anInt) { case i :: j :: _ => i + j }.
                        andThen(anInt) { case expected :: sum :: _ => sum must be_==(expected) }

}



