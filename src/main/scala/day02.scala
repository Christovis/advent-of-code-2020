package advent

import math._
import scala.io.Source

object Day2 {

  case class Policy(min: Int, max: Int, char: Char)

  type Password = String

  sealed trait Part {
    def isValid(policy: Policy, password: Password): Boolean

    def countValid(passwordPolicies: Seq[(Policy, Password)]): Int = passwordPolicies.count((isValid _).tupled)
  }

  object Part1 extends Part {
    override def isValid(policy: Policy, password: Password): Boolean = {
      val Policy(min, max, char) = policy
      val count = password.count(_ == char)
      min <= count && count <= max
    }
  }

  object Part2 extends Part {
    override def isValid(policy: Policy, password: Password): Boolean = {
      val Policy(min, max, char) = policy
      (password(min - 1) == char) ^ (password(max - 1) == char)
    }
  }


  private val passwordPolicyRegex = """(\d+)-(\d+) (\w): (\w+)""".r

  def parsePasswordPolicy(s: String): (Policy, Password) = s match {
    case passwordPolicyRegex(min, max, char, password) =>
      (Policy(min.toInt, max.toInt, char.head), password)
  }

  def parsePasswordPolicies(input: String): Seq[(Policy, Password)] = input.linesIterator.map(parsePasswordPolicy).toSeq

  lazy val input: String = Source.fromResource("day_02.txt").mkString.trim

  def main(args: Array[String]): Unit = {
    println(Part1.countValid(parsePasswordPolicies(input)))
    println(Part2.countValid(parsePasswordPolicies(input)))
  }
}
