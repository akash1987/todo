package todo.app.base.helper

import zio.ZIO

object AppOps {

  implicit class ZioOptionOps[E <: Throwable, A](zio: ZIO[Any, E, Option[A]]) {
    def ifNotFound(e: AppError): ZIO[Any, Throwable, A] = zio.flatMap(ZIO.fromOption(_)).mapError(_ => e)
  }
}
