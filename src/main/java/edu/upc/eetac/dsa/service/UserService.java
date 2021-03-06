package edu.upc.eetac.dsa.service;

import edu.upc.eetac.dsa.ManagerImpl;
import edu.upc.eetac.dsa.models.*;
import edu.upc.eetac.dsa.Manager;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.jaxrs.PATCH;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

//Models or Element Entity
//Swagger Imports
@Api(value = "/User", description = "Endpoint to User Service")
@Path("/User")
public class UserService {
    static final Logger logger = Logger.getLogger(UserService.class);
    private Manager manager;

    public UserService(){
        this.manager = ManagerImpl.getInstance();
    }

    @GET
    @ApiOperation(value="Get a specific user", notes="Get a specific user")
    @ApiResponses(value={
            @ApiResponse(code = 201, message = "Successful", response = User.class),
            @ApiResponse(code = 404, message = "Not Found.")
    })
    @Path("/{userID}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(@PathParam("userID") String userID){
        User entity = this.manager.getUser(userID);
        if (entity.getUname() == null){
            return Response.status(404).build();
        } else {
            return Response.status(200).entity(entity).build();
        }
    }

    @GET
    @ApiOperation(value="Get a user inventory", notes="Get a user inventory")
    @ApiResponses(value={
            @ApiResponse(code = 201, message = "Successful", response = Inventory.class),
            @ApiResponse(code = 404, message = "Not Found.")
    })
    @Path("/{userID}/Inventory")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserInventory(@PathParam("userID") String userID){
        Inventory inventory = this.manager.getUserInventory(userID);
        if(inventory == null) {
            return Response.status(404).build();
        } else {
            return Response.status(200).entity(inventory).build();
        }
    }

    @GET
    @ApiOperation(value="Get a user game", notes="Get a user game")
    @ApiResponses(value={
            @ApiResponse(code = 201, message = "Successful", response = Game.class),
            @ApiResponse(code = 404, message = "Not Found.")
    })
    @Path("/{userID}/Game")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserGame(@PathParam("userID") String userID){
        Game game = this.manager.getUserGame(userID);
        if(game == null) {
            return Response.status(404).build();
        } else {
            return Response.status(200).entity(game).build();
        }
    }

    @GET
    @ApiOperation(value="Get a user achievements", notes="Get a user achievements")
    @ApiResponses(value={
            @ApiResponse(code = 201, message = "Successful", response = Achievements.class),
            @ApiResponse(code = 404, message = "Not Found.")
    })
    @Path("/{userID}/Achievements")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserAchievements(@PathParam("userID") String userID){
        Achievements achievements = this.manager.getUserAchievements(userID);
        if(achievements == null){
            return Response.status(404).build();
        } else {
            return Response.status(200).entity(achievements).build();
        }
    }

    @PATCH
    @ApiOperation(value="Updates a User", notes="Updates a User")
    @ApiResponses(value={
            @ApiResponse(code = 201, message = "Successful", response = User.class),
            @ApiResponse(code = 404, message = "Not Found.")
    })
    @Path("/UpdateUser")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateUser(User user){
        User u = this.manager.updateUser(user);
        if(u == null){
            return Response.status(404).build();
        } else {
            return Response.status(200).entity(u).build();
        }
    }

    @PATCH
    @ApiOperation(value="Updates a Achievements", notes="Updates a Achievements")
    @ApiResponses(value={
            @ApiResponse(code = 201, message = "Successful", response = Achievements.class),
            @ApiResponse(code = 404, message = "Not Found.")
    })
    @Path("/{userID}/UpdateAchievements")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateUserAchievements(Achievements achievements, @PathParam("userID") String userID){
        Achievements u = this.manager.updateAchievements(achievements, userID);

        if(u == null){
            return Response.status(404).build();
        } else {
            return Response.status(200).entity(u).build();
        }
    }

    @PATCH
    @ApiOperation(value="Updates a Inventory", notes="Updates a Inventory")
    @ApiResponses(value={
            @ApiResponse(code = 201, message = "Successful", response = Inventory.class),
            @ApiResponse(code = 404, message = "Not Found.")
    })
    @Path("/{userID}/UpdateInventory")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateUserInventory(Inventory inventory, @PathParam("userID") String userID){
        Inventory u = this.manager.updateInventory(inventory, userID);
        if(u == null){
            return Response.status(404).build();
        } else {
            return Response.status(200).entity(u).build();
        }
    }

    @PATCH
    @ApiOperation(value="Updates Cash", notes="Updates Cash")
    @ApiResponses(value={
            @ApiResponse(code = 204, message = "Successful."),
            @ApiResponse(code = 400, message = "Could not update.")
    })
    @Path("/{userID}/UpdateCash")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateUserCash(User u, @PathParam("userID") String userID){
        if(this.manager.updateUserSingleElement("cash", u.getCash(), userID)==1) {
            return Response.status(204).build();
        } else {
            return Response.status(400).build();
        }
    }

    @PATCH
    @ApiOperation(value="Updates Map", notes="Updates Map")
    @ApiResponses(value={
            @ApiResponse(code = 204, message = "Successful."),
            @ApiResponse(code = 400, message = "Could not update.")
    })
    @Path("/{userID}/UpdateMap")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateUserMap(@PathParam("userID") String userID, Maps map){
        logger.info(map.getID() + " " + map.getName());
        if(this.manager.updateUserMap(userID, map.getID()) != null) {
            return Response.status(204).build();
        } else {
            return Response.status(400).build();
        }
    }

    @GET
    @ApiOperation(value="reboot game", notes="reboot game")
    @ApiResponses(value={
            @ApiResponse(code = 204, message = "Successful"),
            @ApiResponse(code = 400, message = "Not Found.")
    })
    @Path("/{userID}/RestoreGame")
    @Produces(MediaType.APPLICATION_JSON)
    public Response restoreUserGame(@PathParam("userID") String userID){
        User u = this.manager.reiniciarGame(userID);
        if(u == null) {
            return Response.status(404).build();
        } else {
            return Response.status(200).build();
        }
    }
}
