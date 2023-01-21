package todo.app.service

import todo.app.base.db.UserDb
import todo.app.base.domain.{User, UserHelper}
import todo.app.base.domain.companion.UserLogin
import zio.ZIO

object UserService {

  def forLogin(userLogin: UserLogin) = UserDb.forLogin(userLogin)

  def add(user: User): ZIO[Any, Throwable, User] = {
    for {
      _     <- UserHelper.validate(user)
      added <- UserDb.add(user)
    } yield added
  }
}
