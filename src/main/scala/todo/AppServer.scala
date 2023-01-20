package todo

import todo.route.LoginRoute
import zio.http.Server

object AppServer {

  val app = LoginRoute.route

  def start = Server.serve(app, None).provide(Server.default)
}
