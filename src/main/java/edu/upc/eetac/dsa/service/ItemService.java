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
@Api(value = "/Item", description = "Endpoint to Item Service")
@Path("/Item")
public class ItemService {
    static final Logger logger = Logger.getLogger(ItemService.class);
    private Manager manager;

    public ItemService(){
        //Configuring Log4j, location of the log4j.properties file and must always be inside the src folder
        PropertyConfigurator.configure("src/main/resources/log4j.properties");
        this.manager = ManagerImpl.getInstance();

        if (this.manager.getItems().size() == 0)
        {
            //Adding Items
            this.manager.registerItem("o1", "Turtle", "item_01",1,"images/turtle.png");
            this.manager.registerItem("o2", "Coffee", "item_02",2,"images/coffee.png");
            this.manager.registerItem("o3", "RedBull", "item_03,",3,"images/redbull.png");
            this.manager.registerItem("o4", "Pills", "item_04",4,"images/pills.png");
            this.manager.registerItem("o5", "Calculator", "item_05",4,"images/calculator.png");
            this.manager.registerItem("o6", "Rule", "item_06",4,"images/rule.png");
            this.manager.registerItem("o7", "Compas", "item_07",4,"images/compas.png");
            this.manager.registerItem("o8", "Pencil", "item_08",4,"images/pencil.png");
            this.manager.registerItem("o9", "Glasses", "item_09",4,"images/glasses.png");
            this.manager.registerItem("o10", "Puzzle", "item_10",4,"images/puzzle.png");
            this.manager.registerItem("o11", "Book", "item_11",4,"images/book.png");
            this.manager.registerItem("o12", "USB", "item_12",4,"images/usb.png");
            this.manager.registerItem("o13", "CheatSheet", "item_13",4,"images/cheatsheet.png");
        }
    }

    //When multiple GET, PUT, POSTS & DELETE EXIST on the same SERVICE, path must be aggregated
    @GET
    @ApiOperation(value="Get all items", notes="get all items")
    @ApiResponses(value={
            @ApiResponse(code = 201, message = "Successful", response = Item.class, responseContainer = "List"),
            @ApiResponse(code = 404, message = "Not Found.")
    })
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getItems(){
        List<Item> items = this.manager.getItems();
        if(items == null){
            return Response.status(404).build();
        } else {
            GenericEntity<List<Item>> entity = new GenericEntity<List<Item>>(items) {
            };
            return Response.status(201).entity(entity).header("Access-Control-Allow-Origin", "*").build();
        }
    }

   @GET
   @ApiOperation(value="get an specific item", notes="get an specific item")
   @ApiResponses(value={
           @ApiResponse(code = 201, message = "Successful", response = Item.class, responseContainer = "List"),
           @ApiResponse(code = 404, message = "Not Found.")
   })
   @Path("/{itemID}")
   @Produces(MediaType.APPLICATION_JSON)
   public Response getItem(@PathParam("itemID") String itemID){
        Item entity = this.manager.getItem(itemID);
        if(entity == null){
            return Response.status(404).build();
        } else {
            return Response.status(201).entity(entity).build();
        }
   }
}
