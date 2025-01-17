package lib.pos

case class Pos3(x: Int, y: Int, z: Int) extends BoxPosOps[Pos3] {
  override def +(that: Pos3): Pos3 =
    Pos3(x + that.x, y + that.y, z + that.z)

  override def *:(k: Int): Pos3 =
    Pos3(k * x, k * y, k * z)

  override def manhattanDistance(that: Pos3): Int =
    (x - that.x).abs + (y - that.y).abs + (z - that.z).abs

  override def <=(that: Pos3): Boolean =
    x <= that.x && y <= that.y && z <= that.z

  override def min(that: Pos3): Pos3 =
    Pos3(x min that.x, y min that.y, z min that.z)

  override def max(that: Pos3): Pos3 =
    Pos3(x max that.x, y max that.y, z max that.z)
}

object Pos3 extends PosFactory[Pos3] {
  override val zero: Pos3 = Pos3(0, 0, 0)
}
