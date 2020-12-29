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
import java.util.List;


//Models or Element Entity
//Swagger Imports
@Api(value = "/Authentication", description = "Endpoint to User Service")
@Path("/Authentication")
public class AuthenticationService
{
    static final Logger logger = Logger.getLogger(AuthenticationService.class);
    private Manager manager;


    public AuthenticationService(){
        //Configuring Log4j, location of the log4j.properties file and must always be inside the src folder
        PropertyConfigurator.configure("src/main/resources/log4j.properties");
        this.manager = ManagerImpl.getInstance();

        if (this.manager.getUsers().size() == 0)
        {
            //Adding Users
            this.manager.signUP("Albert","1234", "email.albert@thisemail.is.a.test.com");
            this.manager.signUP("Marc","2345", "email.marc@thisemail.is.a.test.com");
            this.manager.signUP("Javier","3456", "email.javi@thisemail.is.a.test.com");
            this.manager.signUP("Guille","4567", "email.guille@thisemail.is.a.test.com");
            this.manager.signUP("Renuka","5678", "email.renuka@thisemail.is.a.test.com");
            this.manager.signUP("Victor","6789", "email.victor@thisemail.is.a.test.com");
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
        return Response.status(201).entity(entity).header("Access-Control-Allow-Origin", "*").build();
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
            return Response.status(400).entity(u).header("Access-Control-Allow-Origin", "*").build();
        }

        if((this.manager.signUP(u.getUname(), u.getPswrd(), u.getEmail())) == null)
        {
            return Response.status(400).entity(u).header("Access-Control-Allow-Origin", "*").build();
        }
        return Response.status(201).entity(u).header("Access-Control-Allow-Origin", "*").build();
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
            return Response.status(400).entity(u).header("Access-Control-Allow-Origin", "*").build();
        }

        if((this.manager.signIN(u.getUname(), u.getPswrd())) == null)
        {
            return Response.status(400).entity(u).header("Access-Control-Allow-Origin", "*").build();
        }
        return Response.status(201).entity(u).header("Access-Control-Allow-Origin", "*").build();
    }
}
