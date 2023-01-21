package todo.app.base.db

import slick.lifted.TableQuery
import todo.app.base.db.Mapping.{AccountTable, UserTable}
import Mapping._

object AllTables {

  val users: TableQuery[UserTable]       = TableQuery[UserTable]
  val accounts: TableQuery[AccountTable] = TableQuery[AccountTable]
}
