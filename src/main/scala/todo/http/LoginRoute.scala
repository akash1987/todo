package todo.http

import todo.app.base.domain.companion.UserLogin
import todo.app.base.helper.JsonConversion._
import todo.app.serviceComposite.AuthenticationService
import todo.util.HttpOps.JsoniterOps
import todo.util.JwtUtil
import zio.http._
import zio.http.model.Method

object LoginRoute {

  val route: HttpApp[Any, Throwable] = Http.collectZIO[Request] {
    case req @ Method.GET -> !! / "login" => {
      for {
        userLogin <- req.bodyFromJson[UserLogin]
        userInfo  <- AuthenticationService.authenticate(userLogin)
      } yield Response.text(JwtUtil.encode(userInfo))
    }
  }
}
