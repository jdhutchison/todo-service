package sh.hutch.todo.model

data class AppConfig(
  lateinit var version
  lateinit var buildtime
  lateinit var todoPath
)
