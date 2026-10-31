package sh.hutch.todo.model

data class AppConfig(
  var version: String,
  var buildtime: String,
  var todoPath: String
)
