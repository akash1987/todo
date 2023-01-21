package todo.app.base.db

import slick.basic.DatabaseConfig
import slick.dbio.DBIO
import slick.jdbc.JdbcProfile
import zio.ZIO

import scala.concurrent.ExecutionContext

object DBConn {

  private val config = DatabaseConfig.forConfig[JdbcProfile]("mydb")
  val profile = config.profile
  val db = config.db

  def run[R](a: DBIO[R]): ZIO[Any, Throwable, R] =
    ZIO.fromFuture(_ => db.run(a))

  def runWithExecutionContext[R](f: ExecutionContext => DBIO[R]): ZIO[Any, Throwable, R] =
    ZIO.fromFuture(ec => db.run(f(ec)))
}
