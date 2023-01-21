package todo.app.base.helper

sealed trait AppError extends Throwable {
  val s: String

  override def getMessage: String = s
}
final case class AppUnauthorized(s: String) extends AppError
final case class AppInvalidInput(s: String) extends AppError
final case class AppItemNotFound(s: String) extends AppError
final case class AppBaseError(s: String) extends AppError
