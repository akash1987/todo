package todo.app.base.domain

import org.joda.time.DateTime
import zio.ZIO


final case class User(id: Long,
                      userName: String,
                      email: String,
                      password: String,
                      createdDateTime: DateTime,
                      createdBy: Long,
                      updatedDateTime: DateTime,
                      updatedBy: Long)

object UserHelper {

  def validate(user: User) = {
    ZIO.succeed(user)
  }
}