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

enum class ItemStatus(val symbol: String) {
  In_progress("/"),
  Blocked("!"),
  Done("x");

  companion object {
    public fun findBySymbol(symbol: String): ItemStatus? {
      return entries.firstOrNull { it.symbol == symbol }
    }
  }
}

enum class ItemPriority {
  Low,
  Normal,
  High,
  Critical
}
