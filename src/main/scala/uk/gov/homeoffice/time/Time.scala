package uk.gov.homeoffice.time

import grizzled.slf4j.Logging

/**
 * Time functionality e.g.
 * timed("Description of what is being timed") { your functionality }
 */
trait Time extends Logging {
  def timed[R](description: String)(f: => R) = {
    val start = System.currentTimeMillis()
    val result = f
    info(s"$description => ${System.currentTimeMillis() - start} milliseconds")
    result
  }
}