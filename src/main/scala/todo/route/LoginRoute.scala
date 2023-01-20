package todo.route

import zio.ZIO
import zio.http._
import zio.http.model.Method

object LoginRoute {

  val route: HttpApp[Any, Throwable] = Http.collectZIO[Request] {
    case req @ Method.GET -> !! / "hi" =>
      ZIO.succeed(Response.text("Hi!!!"))
  }
}
