package uk.gov.homeoffice.specs2

import org.specs2.mutable.Specification

class Spec extends Specification {
  "Specs2" should {
    "work" in {
      true must beTrue
    }
  }
}