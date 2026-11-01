package sh.hutch.todo.service

import java.io.File
import jakarta.enterprise.context.ApplicationScoped
import org.eclipse.microprofile.config.inject.ConfigProperty
import org.slf4j.LoggerFactory
import sh.hutch.todo.model.ItemStatus
import sh.hutch.todo.model.TodoItem

const val INDEX_FILE_NAME = "index.md"
const val LIST_START = "<!-- todo-items:start -->"
const val LIST_END = "<!-- todo-items:end -->"

@ApplicationScoped
class ListService(@ConfigProperty(name = "service.todo-list.path") private val path: String) {

  private val log = LoggerFactory.getLogger(ListService::class.java)

  private val regex = Regex("""^-\s*\[(?<status>.*?)\]\s*\[\[(?<title>.*?)\]\]""")

  private fun readList(): List<TodoItem> {
    val lines = File(path + "/" + INDEX_FILE_NAME).readLines()
    val items: List<TodoItem> = mutableListOf()

    lines.filter { it.startsWith("- [")}.forEach {
      val matchResult = regex.find(it.trim())
      val (statusSymbol, title) = matchResult.destructured ?: ("", "")
      val status = ItemStatus.findBySymbol(statusSymbol)
      items.add(TodoItem(title, status, null, null, null))
    }

    return items
  }

  private fun extractList(lines: List<String>): List<String> {
    val start = lines.indexOf(LIST_START)
    val end = lines.indexOf(LIST_END)
    lines.filter { it}
    return lines.subList(start + 1, end)
  }


}
