package sh.hutch.todo.controller;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.slf4j.LoggerFactory
import sh.hutch.todo.model.ApiResponse;
import sh.hutch.todo.model.TodoItem;

@Path("/items")
public class RestApiController {

  private val log = LoggerFactory.getLogger(RestApiController::class.java)

  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @PUT
  fun addOrUpdate(item: TodoItem): ApiResponse<TodoItem> {
    log.info("Put or update new entry, '{}'", item.title)
    return ApiResponse("ok", 200, null, null, null)
  }

  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @GET
  fun list(): Unit {

  }

}
