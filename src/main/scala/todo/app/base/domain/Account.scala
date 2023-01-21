package todo.app.base.domain

import org.joda.time.DateTime


final case class Account(id: Long,
                          userId: Long,
                          createdDateTime: DateTime,
                          createdBy: Long,
                          updatedDateTime: DateTime,
                          updatedBy: Long)

object AccountHelper {

}