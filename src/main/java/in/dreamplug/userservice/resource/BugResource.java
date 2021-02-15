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
import in.dreamplug.userservice.domain.Bug;
import in.dreamplug.userservice.domain.User;
import in.dreamplug.userservice.exception.BugError;
import in.dreamplug.userservice.exception.Error;
import in.dreamplug.userservice.service.BugService1;
import in.dreamplug.userservice.service.UserService;
import io.dropwizard.validation.Validated;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Path ("/v1/bugs")
@Slf4j
@Produces (MediaType.APPLICATION_JSON)
@Consumes (MediaType.APPLICATION_JSON)
@Timed
@AllArgsConstructor
public class BugResource {
    private BugService1 bugService1;
    private UserService userService;

    @POST
    public Response create(final @NotNull(groups = CreateCheck.class) @Validated (CreateCheck.class) @Valid Bug bug) {
        final Bug createdBug = bugService1.insert(bug);
        return Response.status(Response.Status.CREATED).entity(createdBug).build();
    }

    @GET
    @Path("/{bugName}/{email}")
    public Response assignUser(@PathParam ("bugName") final String bugName, @PathParam ("email") final String email) {
        final User user = userService.getByEmail(email).orElseThrow(BugError.bug_not_found.getBuilder()::build);
        final Long generatedId = bugService1.assignUser(user,bugName);
        return Response.status(Response.Status.OK).build();
    }

    @PATCH
    @Path ("/{bugName}")
    public Response update(@PathParam ("bugName") final String bugName, final @NotNull (groups = UpdateCheck.class) @Validated (UpdateCheck.class) @Valid Bug bug) {
        final Bug updatedBug = bugService1.update(bug, bugName);
        return Response.status(Response.Status.CREATED).entity(updatedBug).build();
    }

    @GET
    @Path ("/{bugName}")
    public Bug getByBugName(@PathParam ("bugName") final String bugName) {
        return bugService1.getByName(bugName).orElseThrow(BugError.bug_not_found.getBuilder()::build);
    }

}
