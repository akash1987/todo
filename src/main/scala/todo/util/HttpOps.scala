package todo.util

import com.github.plokhotnyuk.jsoniter_scala.core.{JsonValueCodec, readFromArray, writeToArray}
import todo.app.base.helper.AppInvalidInput
import zio.Chunk.ByteArray
import zio.http.model.{HeaderNames, HeaderValues, Headers}
import zio.http.{Body, Request, Response}
import zio.{Chunk, ZIO}

object HttpOps {

  private val jsonHeaderStatic = Headers(HeaderNames.contentType, HeaderValues.applicationJson)
  private val asChunk = (array: Array[Byte]) => ByteArray(array, 0, array.length).asInstanceOf[Chunk[Byte]]

  implicit class JsoniterOps(req: Request) {
    def bodyFromJson[A: JsonValueCodec]: ZIO[Any, Throwable, A] = {
      req.body.asArray.flatMap(s => ZIO.attempt(readFromArray[A](s))).mapError( _ => AppInvalidInput("Unable to parse the input."))
    }
  }

  def responseAsJson[A: JsonValueCodec](a: A): Response = {
    Response(
      body = Body.fromChunk(asChunk(writeToArray(a))),
      headers = jsonHeaderStatic
    )
  }
}
