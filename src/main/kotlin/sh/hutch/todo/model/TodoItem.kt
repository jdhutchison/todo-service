package sh.hutch.todo.model

import java.time.LocalDate

data class TodoItem(
  val title: String,
  val status: ItemStatus?,

  // By default things have a normal status
  val priority: ItemPriority? = ItemPriority.Normal,
  val dueDate: LocalDate?,
  val notes: String?
)

enum class ItemStatus {
  In_progress,
  Blocked,
  Done
}

enum class ItemPriority {
  Low,
  Normal,
  High,
  Critical
}
