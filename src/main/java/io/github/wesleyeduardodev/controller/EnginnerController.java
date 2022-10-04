package io.github.wesleyeduardodev.controller;
import io.github.wesleyeduardodev.dto.EnginnerDTO;
import io.github.wesleyeduardodev.service.EnginnerService;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Objects;

@Path("/api/enginners")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EnginnerController {

    @Inject
    EnginnerService enginnerService;

    @GET
    public List<EnginnerDTO> findAllEnginners() {
        return enginnerService.findAllEnginners();
    }

    @GET
    @Path("/{id}")
    public Response findEnginnerById(@PathParam("id") Long id) {
        Response response;
        EnginnerDTO enginnerDTO = enginnerService.findEnginnerById(id);
        if(Objects.isNull(enginnerDTO)){
            response = Response.noContent().build();
        }else{
            response = Response.ok(enginnerDTO).build();
        }
        return response;
    }

    @POST
    @Transactional
    public Response saveEnginner(EnginnerDTO enginnerDTO) {
        Response response;
        try {
            enginnerService.createNewEnginner(enginnerDTO);
            response = Response.ok().build();
        } catch (Exception e) {
            response = Response.serverError().build();
        }
        return response;
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response changeEnginner(@PathParam("id") Long id, EnginnerDTO enginnerDTO) {
        Response response;
        try {
            enginnerService.changeEnginner(id, enginnerDTO);
            response = Response.accepted().build();
        } catch (Exception e) {
            response = Response.serverError().build();
        }
        return response;
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deleteEnginner(@PathParam("id") Long id) {
        Response response;
        try {
            enginnerService.deleteEnginner(id);
            response = Response.accepted().build();
        } catch (Exception e) {
            response = Response.serverError().build();
        }
        return response;
    }
}
