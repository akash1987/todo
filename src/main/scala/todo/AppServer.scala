package todo

import todo.http.LoginRoute
import zio.ZIOAppDefault
import zio.http.Server

object AppServer extends ZIOAppDefault {

  val app = LoginRoute.route

  def run = Server.serve(app, None).provide(Server.default)
}
