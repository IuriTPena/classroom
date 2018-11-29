package interoperability;

import service.IClassroomService;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/classroom")
public class ClassroomEndpoint {
    @Inject
    private IClassroomService classroomService;

    @Path("/addClassroom")
    @POST
    @Produces({"application/json"})
    public String addClassroom(String classroom) {
        return classroomService.addClassroom(classroom);
    }

    @Path("/getClassroom/{id}")
    @GET
    @Produces({"application/json"})
    public String getClassroom(@PathParam("id") Long id) {
        return classroomService.retrieveClassroom(id);
    }

    @Path("/updateClassroom")
    @POST
    @Produces({"application/json"})
    public String updateClassroom(String classroom) {
        return classroomService.updateClassroom(classroom);
    }

    @Path("/deleteClassroom/{id}")
    @DELETE
    @Produces({"application/json"})
    public String deleteClassroom(@PathParam("id") Long id) {
        return classroomService.deleteClassroom(id);
    }

    @Path("/getClassroom/All")
    @GET
    @Produces({"application/json"})
    public String getAllClassrooms() {
        return classroomService.getClassrooms();
    }

    public void setService(IClassroomService classroomService) {
        this.classroomService = classroomService;
    }
}
