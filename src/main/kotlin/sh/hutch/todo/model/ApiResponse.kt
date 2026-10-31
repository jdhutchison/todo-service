package sh.hutch.todo.model

/**
 * What the REST/HTTP API returns
 */
data class ApiResponse<T>(
  val status: String,
  val statusCode: Int,
  // Could be one item, could be a list of them
  val result: T?,
  val errorCode: String?,
  val errors: List<Error>?
)

data class Error(
  val type: String,
  val message: String
)

