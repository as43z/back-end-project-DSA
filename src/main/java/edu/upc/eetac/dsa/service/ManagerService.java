package edu.upc.eetac.dsa.service;
import edu.upc.eetac.dsa.ManagerImpl;
import edu.upc.eetac.dsa.models.*;
import edu.upc.eetac.dsa.Manager;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;


//Models or Element Entity
//Swagger Imports
@Api(value = "/Authentication", description = "Endpoint to User Service")
@Path("/Authentication")
public class ManagerService
{
    static final Logger logger = Logger.getLogger(ManagerService.class);
    private Manager manager;


    public ManagerService(){
        //Configuring Log4j, location of the log4j.properties file and must always be inside the src folder
        PropertyConfigurator.configure("src/main/resources/log4j.properties");
        this.manager = ManagerImpl.getInstance();

        if (this.manager.getUsers().size() == 0)
        {
            //Adding Users
            this.manager.signUP("Albert","1234");
            this.manager.signUP("Marc","2345");
            this.manager.signUP("Javier","3456");
            this.manager.signUP("Guillem","4567");
            this.manager.signUP("Renuka","5678");
            this.manager.signUP("Victor","6789");
        }
    }


    //When multiple GET, PUT, POSTS & DELETE EXIST on the same SERVICE, path must be aggregated
    @GET
    @ApiOperation(value="Get all Users", notes="get all users")
    @ApiResponses(value={
            @ApiResponse(code = 201, message = "Successful", response = User.class, responseContainer = "List"),
    })
    @Path("/admin")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsers(){
        List<User> users = this.manager.getUsers();
        GenericEntity<List<User>> entity = new GenericEntity<List<User>>(users){};
        return Response.status(201).entity(entity).build();
    }


    //Adds a new user
    @POST
    @ApiOperation(value = "Create a new user", notes = "Adds a new user")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response=User.class),
            @ApiResponse(code = 500, message = "Validation Error")
    })
    @Path("/addUser")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response newUser(User u) {
        if (u.getUname() == null || u.getPswrd() == null)
        {
            return Response.status(400).entity(u).build();
        }

        if((this.manager.signUP(u.getUname(), u.getPswrd())) == null)
        {
            return Response.status(400).entity(u).build();
        }
        return Response.status(201).entity(u).build();
    }

    @POST
    @ApiOperation(value = "Login", notes = "Login")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response=User.class),
            @ApiResponse(code = 500, message = "Validation Error")
    })
    @Path("/Login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response newLogin(User u) {
        if (u.getUname() == null || u.getPswrd() == null)
        {
            return Response.status(400).entity(u).build();
        }

        if((this.manager.signIN(u.getUname(), u.getPswrd())) == null)
        {
            return Response.status(400).entity(u).build();
        }
        return Response.status(201).entity(u).build();
    }
}