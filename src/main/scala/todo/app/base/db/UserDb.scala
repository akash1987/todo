package todo.app.base.db

import todo.app.base.domain.companion.UserLogin
import todo.app.base.helper.AppBaseError
import AllTables._
import DBConn.profile.api._
import todo.app.base.domain.{Account, User}
import todo.app.base.helper.AppOps.ZioOptionOps
import zio.ZIO

object UserDb {

  def add(user: User): ZIO[Any, Throwable, User] = {
    val q = users.returning(users.map(_.id)).into((item, id) => item.copy(id = id)) += user
    DBConn.run(q)
  }

  def forLogin(userLogin: UserLogin): ZIO[Any, Throwable, (User, Account)] = {

    val query = for {
      (user, account) <- users.join(accounts).on(_.id === _.id)
                          if user.username === userLogin.userName && user.password === userLogin.password
    } yield (user, account)
    DBConn.run(query.result.headOption)
      .ifNotFound(AppBaseError("User name or password do not match."))
  }
}
