package uk.gov.homeoffice

import org.specs2.matcher.MatchResult

package object specs2 {
  /**
    * Run a given match (assertion) twice.
    * @param r MatchResult[R]
    * @tparam R Type of match
    * @return MatchResult[R]
    */
  def twice[R](r: => MatchResult[R]): MatchResult[R] = times(2)(r)

  /**
    * Run a given match (assertion) a number of times.
    * @param n Int Number of times to run the match (assertion).
    * @param r MatchResult[R]
    * @tparam R Type of match
    * @return MatchResult[R]
    */
  def times[R](n: Int)(r: => MatchResult[R]): MatchResult[R] = {
    def run(count: Int, result: MatchResult[R]): MatchResult[R] = {
      if (result.isSuccess && count > 1) {
        run(count - 1, r)
      }

      result
    }

    run(n, r)
  }
}