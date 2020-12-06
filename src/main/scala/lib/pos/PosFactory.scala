package lib.pos

trait PosFactory[A <: PosOps[A]] {
  val zero: A
}
