package sh.hutch.todo.service

import java.io.File

/**
 * Any file or directory based operations
 */
object FileUtils {

  public fun write(path: String, lines: List<String>): Unit {
    val f = File(path)

    f.bufferedWriter().use { out ->
      lines.forEach {
        out.write(it)
        out.newLine()
      }
    }
  }

  /**
   * Read all the filenames of markdown files, excluding an index, for
   * a given path.
   *
   * @param path the path of the directory to check
   * @return all the matching file names
   */
  public fun list(path: String) = File(path)
      .listFiles { f ->
        f.isFile && f.extension.equals("md") && !f.name.equals(INDEX_FILE_NAME)
      }.map { it.name }

}
