package ec.devnull.group.resource;


import ec.devnull.group.model.Group;
import ec.devnull.group.repository.GroupRepository;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * @author Kleber Ayala
 */
@ApplicationScoped
@Produces({MediaType.APPLICATION_JSON})
@Consumes(MediaType.APPLICATION_JSON)
@Path("/group")
public class GroupResource {

    @Inject
    private GroupRepository groupRepository;

    @GET
    @Path("/list")
    @Counted(monotonic = true)
    @Operation(summary = "List all groups")
    public List<Group> listGroups() {
        return groupRepository.list();
    }

    @POST
    @Path("/add")
    @Counted(monotonic = true)
    @Operation(summary = "Creates a new Group")
    public Group addGroup(@RequestBody(description = "Specify the values to create a new Group",
            content = @Content(mediaType = MediaType.APPLICATION_JSON,
                    schema = @Schema(implementation = Group.class))) Group group) {

        return groupRepository.add(group);
    }


}
