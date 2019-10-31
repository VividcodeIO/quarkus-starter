package io.vividcode.quarkus;

import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {

  @Inject
  UserService userService;

  @GET
  public List<User> list() {
    return userService.list();
  }

  @POST
  public User create(User user) {
    return userService.addUser(user);
  }

  @Path("{id}")
  @DELETE
  public void delete(@PathParam("id") String id) {
    userService.delete(id);
  }

  @Path("{id}")
  public Response getUser(@PathParam("id") String userId) {
    User user = userService.findById(userId);
    if (user != null) {
      return Response.ok(user).build();
    } else {
      return Response.status(Status.NOT_FOUND).build();
    }
  }
}