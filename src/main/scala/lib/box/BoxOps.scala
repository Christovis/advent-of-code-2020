package lib.box

import lib.pos.BoxPosOps

trait BoxOps[A <: BoxPosOps[A], B <: BoxOps[A, B]] {
  val min: A
  val max: A

  require(min <= max)

  def factory: BoxFactory[A, B]

  def contains(pos: A): Boolean =
    min <= pos && pos <= max

  def union(that: B): B = {
    val unionMin = min min that.min
    val unionMax = max max that.max
    factory(unionMin, unionMax)
  }

  def intersect(that: B): Option[B] = {
    val intersectMin = min max that.min
    val intersectMax = max min that.max
    if (intersectMin <= intersectMax)
      Some(factory(intersectMin, intersectMax))
    else
      None
  }

  def iterator: Iterator[A]
}
