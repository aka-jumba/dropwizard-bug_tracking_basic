package in.dreamplug.userservice.resource;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.codahale.metrics.annotation.Timed;
import in.dreamplug.userservice.CreateCheck;
import in.dreamplug.userservice.UpdateCheck;
import in.dreamplug.userservice.domain.User;
import in.dreamplug.userservice.exception.Error;
import in.dreamplug.userservice.service.UserService;
import io.dropwizard.validation.Validated;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author sidhant.aggarwal
 * @since 12/01/2020
 */
@Path ("/v1/users")
@Slf4j
@Produces (MediaType.APPLICATION_JSON)
@Consumes (MediaType.APPLICATION_JSON)
@Timed
@AllArgsConstructor
public class UserResource {
    private UserService userService;

    @POST
    public Response create(final @NotNull (groups = CreateCheck.class) @Validated (CreateCheck.class) @Valid User user) {
        final User createdUser = userService.insert(user);
        return Response.status(Response.Status.CREATED).entity(createdUser).build();
    }

    @PATCH
    @Path ("/{userId}")
    public Response update(@PathParam ("userId") final String userId, final @NotNull (groups = UpdateCheck.class) @Validated (UpdateCheck.class) @Valid User user) {
        user.setExternalId(userId);
        final User updatedUser = userService.update(user);
        return Response.status(Response.Status.CREATED).entity(updatedUser).build();
    }

    @GET
    @Path ("/{userId}")
    public User getById(@PathParam ("userId") final String userId) {
        return userService.getById(userId).orElseThrow(Error.user_not_found.getBuilder()::build);
    }

    @GET
    @Path ("/email/{emailId}")
    public User getByEmail(@PathParam ("emailId") final String emailId) {
        return userService.getByEmail(emailId).orElseThrow(Error.user_not_found.getBuilder()::build);
    }

    @GET
    @Path ("/phone/{phone}")
    public User getByPhone(@PathParam ("phone") final String phone) {
        return userService.getByPhone(phone).orElseThrow(Error.user_not_found.getBuilder()::build);
    }
}
