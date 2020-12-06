package advent

import lib.Grid
import lib.GridImplicits._
import lib.pos.Pos

import math._
import scala.io.Source
import scala.annotation.tailrec

object Day3 {

  def countSlopeTrees(grid: Grid[Boolean], slope: Pos = Pos(3, 1)): Int = {
    def gridRepeat(pos: Pos): Boolean = {
      val row = grid(pos.y)
      row(pos.x % row.size)
    }

    // original row-by-row solution generalized to bigger y steps
    (grid.indices by slope.y)
      .view.zipWithIndex
      .map({ case (y, i) => Pos(slope.x * i, y) })
      .count(gridRepeat)

  }

  private val multiplySlopes = Seq(
    Pos(1, 1),
    Pos(3, 1),
    Pos(5, 1),
    Pos(7, 1),
    Pos(1, 2),
  )

  def multiplySlopeTrees(grid: Grid[Boolean]): Long = {
    multiplySlopes.map(countSlopeTrees(grid, _)).map(_.toLong).product
  }


  def parseGrid(input: String): Grid[Boolean] = input.linesIterator.map(_.toVector).toVector.mapGrid({
    case '#' => true
    case '.' => false
  })


  lazy val input: String = Source.fromResource("day_03.txt").mkString.trim

  def main(args: Array[String]): Unit = {
    println(countSlopeTrees(parseGrid(input)))
    println(multiplySlopeTrees(parseGrid(input)))
  }
}
