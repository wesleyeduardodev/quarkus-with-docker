package io.github.wesleyeduardodev.controller;
import io.github.wesleyeduardodev.dto.ContructionDTO;
import io.github.wesleyeduardodev.service.ConstructionService;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Objects;

@Path("/api/constructions")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ConstructionController {

    @Inject
    ConstructionService constructionService;

    @GET
    public List<ContructionDTO> findAllConstructions() {
        return constructionService.findAllConstructions();
    }

    @GET
    @Path("/{id}")
    public Response findConstructionById(@PathParam("id") Long id) {
        Response response;
        ContructionDTO contructionDTO = constructionService.findConstructionById(id);
        if(Objects.isNull(contructionDTO)){
            response = Response.noContent().build();
        }else{
            response = Response.ok(contructionDTO).build();
        }
        return response;
    }

    @POST
    @Transactional
    public Response saveConstruction(ContructionDTO contructionDTO) {
        Response response;
        try {
            constructionService.createNewConstruction(contructionDTO);
            response = Response.ok().build();
        } catch (Exception e) {
            response = Response.serverError().build();
        }
        return response;
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response changeConstruction(@PathParam("id") Long id, ContructionDTO contructionDTO) {
        Response response;
        try {
            constructionService.changeConstruction(id, contructionDTO);
            response = Response.accepted().build();
        } catch (Exception e) {
            response = Response.serverError().build();
        }
        return response;
    }

    @DELETE
    @Path("/{id}")
    public Response deleteConstruction(@PathParam("id") Long id) {
        Response response;
        try {
            constructionService.deleteConstruction(id);
            response = Response.accepted().build();
        } catch (Exception e) {
            response = Response.serverError().build();
        }
        return response;
    }
}
