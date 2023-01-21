package todo.app.base.db

import com.github.tototoshi.slick.MySQLJodaSupport._
import org.joda.time.DateTime
import DBConn.profile.api._
import todo.app.base.domain.{Account, User}

object Mapping {

  final case class UserTable(tag: Tag) extends Table[User](tag, "user") {
    def id = column[Long]("id", O.PrimaryKey, O.AutoInc)
    def username = column[String]("username")
    def email = column[String]("email")
    def password = column[String]("password")
    def createdDateTime = column[DateTime]("createdDateTime")
    def createdBy = column[Long]("createdBy")
    def updatedDateTime = column[DateTime]("updatedDateTime")
    def updatedBy = column[Long]("updatedBy")
    def * = (id, username, email, password, createdDateTime, createdBy, updatedDateTime, updatedBy) <> (User.tupled, User.unapply)
  }

  final case class AccountTable(tag: Tag) extends Table[Account](tag, "account") {
    def id = column[Long]("id", O.PrimaryKey, O.AutoInc)
    def userId = column[Long]("userId")
    def createdDateTime = column[DateTime]("createdDateTime")
    def createdBy = column[Long]("createdBy")
    def updatedDateTime = column[DateTime]("updatedDateTime")
    def updatedBy = column[Long]("updatedBy")
    def * = (id, userId, createdDateTime, createdBy, updatedDateTime, updatedBy) <> (Account.tupled, Account.unapply)
  }
}
