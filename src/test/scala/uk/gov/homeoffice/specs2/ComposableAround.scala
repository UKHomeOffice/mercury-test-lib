package uk.gov.homeoffice.specs2

import org.specs2.execute._
import org.specs2.mutable.Around

trait ComposableAround extends Around {
  def around[R : AsResult](r: => R): Result = AsResult(r) match {
    case e: Error => throw new ErrorException(e)
    case f: Failure => throw new FailureException(f)
    case p: Pending => throw new PendingException(p)
    case s: Skipped => throw new SkipException(s)
    case other => other
  }
}