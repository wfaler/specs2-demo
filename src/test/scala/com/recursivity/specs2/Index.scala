package com.recursivity.specs2

import org.specs2._
import runner.SpecificationsFinder._

class index extends Specification{ def is =

  examplesLinks("Specs2 Example specifications")

  // see the SpecificationsFinder trait for the parameters of the 'specifications' method
  def examplesLinks(t: String) = t.title ^ specifications(pattern = ".*Specification").map(see)

}
