package todo.app.base.helper

import org.joda.time.DateTime
import org.joda.time.format.{DateTimeFormat, DateTimeFormatter}
import todo.app.base.domain.companion.{UserInfo, UserLogin}

object JsonConversion {

  import com.github.plokhotnyuk.jsoniter_scala.core._
  import com.github.plokhotnyuk.jsoniter_scala.macros._

  val dateTimeFormat: DateTimeFormatter = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ")

  implicit val dateTimeCodec = new JsonValueCodec[DateTime] {
    override def decodeValue(in: JsonReader, default: DateTime): DateTime =
      DateTime.parse(in.readString(""), dateTimeFormat)

    override def encodeValue(dateTime: DateTime, out: JsonWriter): Unit = out.writeVal(dateTimeFormat.print(dateTime))

    override def nullValue: DateTime = null
  }

  implicit val userLoginCodec: JsonValueCodec[UserLogin] = JsonCodecMaker.make[UserLogin]
  implicit val userInfoCodec: JsonValueCodec[UserInfo] = JsonCodecMaker.make[UserInfo]
}
