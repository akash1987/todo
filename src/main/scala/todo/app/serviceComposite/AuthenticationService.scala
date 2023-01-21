package todo.app.serviceComposite

import todo.app.base.domain.companion.{UserInfo, UserLogin}
import todo.app.base.domain.{Account, User}
import todo.app.service.UserService
import zio.ZIO

object AuthenticationService {

  def authenticate(userLogin: UserLogin) =
    for {
      userAndAccount <- UserService.forLogin(userLogin)
      userInfo       <- isAuthorized(userAndAccount)
    } yield userInfo

  def isAuthorized(userAndAccount: (User, Account)) = ZIO.succeed {
    // check if account active
    val (user, account) = userAndAccount
    UserInfo(user.id, user.userName, account.id)
  }
}
