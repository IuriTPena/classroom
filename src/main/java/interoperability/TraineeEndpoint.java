package interoperability;

import service.ITraineeService;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/trainee")
public class TraineeEndpoint {
    @Inject
    private ITraineeService traineeService;

    @Path("/addTrainee")
    @POST
    @Produces({"application/json"})
    public String addTrainee(String trainee) {
        return traineeService.addTrainee(trainee);
    }

    @Path("/getTrainee/{id}")
    @GET
    @Produces({"application/json"})
    public String getTrainee(@PathParam("id") Long id) {
        return traineeService.retrieveTrainee(id);
    }

    @Path("/updateTrainee")
    @POST
    @Produces({"application/json"})
    public String updateTrainee(String trainee) {
        return traineeService.updateTrainee(trainee);
    }

    @Path("/deleteTrainee/{id}")
    @DELETE
    @Produces({"application/json"})
    public String deleteTrainee(@PathParam("id") Long id) {
        return traineeService.deleteTrainee(id);
    }

    @Path("/getTrainee/All")
    @GET
    @Produces({"application/json"})
    public String getAllTrainees() {
        return traineeService.getTrainees();
    }

    public void setService(ITraineeService traineeService) {
        this.traineeService = traineeService;
    }
}
