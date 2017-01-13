package uk.gov.homeoffice.specs2

import org.specs2.execute._
import org.specs2.mutable.Around

trait ComposableAround extends Around {
  def around[R : AsResult](r: => R): Result = AsResult(r) match {
    case e: Error => throw ErrorException(e)
    case f: Failure => throw FailureException(f)
    case p: Pending => throw PendingException(p)
    case s: Skipped => throw SkipException(s)
    case other => other
  }
}