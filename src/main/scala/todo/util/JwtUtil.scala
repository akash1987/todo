package todo.util

import com.github.plokhotnyuk.jsoniter_scala.core.writeToString
import pdi.jwt.{ Jwt, JwtAlgorithm, JwtClaim }
import todo.app.base.domain.companion.UserInfo
import todo.app.base.helper.JsonConversion._
import zio.ZIO

import java.time.Clock

object JwtUtil {

  private val SECRET_KEY    = "TO_BE_CHANGED"
  implicit val clock: Clock = Clock.systemUTC

  def encode(userInfo: UserInfo) = {
    val json = writeToString(userInfo)
    val claim = JwtClaim {
      json
    }.issuedNow.expiresIn(60000)
    Jwt.encode(claim, SECRET_KEY, JwtAlgorithm.HS512)
  }

}
