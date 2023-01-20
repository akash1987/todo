package todo

import zio.ZIOAppDefault
import zio.http.Server

object Main extends ZIOAppDefault {

  def run = AppServer.start
}
