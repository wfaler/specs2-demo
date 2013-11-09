package com.recursivity.specs2

import org.specs2.Specification
import org.specs2.matcher.DataTables

class DataTableSpecification extends Specification with DataTables{ def is = 

  "adding integers should just work in scala"  ! e1

  def e1 =
    "x"   | "y" | "sum" |                                   // the header
     2    !  2  !  4  | 
     4    !  1  !  6  |                                  // an example row
     1    !  1  !  2  |> {                                // the > operator to "execute" the table
       (x,y,sum) =>  x + y must_== sum                      // the expectation to check on each row
    }

}










