package sh.hutch.todo

import jakarta.ws.rs.GET
import jakarta.ws.rs.Path

@Path("/health")
class HealthCheckController {

  @GET
  fun healthCheck() = "OK"
}
