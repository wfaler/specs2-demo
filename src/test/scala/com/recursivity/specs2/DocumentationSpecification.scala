package com.recursivity.specs2

import org.specs2._
import org.specs2.specification.Snippets

class DocumentationSpecification extends Specification with Snippets{ def is =
 s2"""
  This is a multi-line string with a snippet of code: ${ snippet {
  def factorial(n: Int): Int = if (n == 1) n else (n * factorial(n - 1))
  factorial(3) == 6
  }} 

  first example $exampleAssertion								     
  """

  def exampleAssertion = 1 must be_==(1)
}
