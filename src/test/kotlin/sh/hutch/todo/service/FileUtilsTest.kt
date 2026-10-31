package sh.hutch.todo.service

import java.nio.file.Path

import kotlin.io.path.readLines

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test



class FileUtilsTest {

  private val testTodoListDirUri = this::class.java.classLoader.getResource("test-todo-list").toURI()
  private val path = Path.of(testTodoListDirUri).toString()

  @Test
  fun `list should return all non index file names`() {
    // GIVEN,
    val expected = listOf("h.md", "r.md", "s.md")

    // WHEN
    val result = FileUtils.list(path)

    // THEN
    Assertions.assertLinesMatch(expected, result)
  }

  @Test
  fun `write should write to file successfully`() {
    // GIVEN
    val contents = listOf("a", "b", "c", "d")
    val newFile = path + "/x.txt"

    // WHEN
    FileUtils.write(newFile, contents)

    // THEN
    val result = Path.of(newFile).readLines()
    Assertions.assertLinesMatch(contents, result)

    Path.of(newFile).toFile().delete()
  }
}
