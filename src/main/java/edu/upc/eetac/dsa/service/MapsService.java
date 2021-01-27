package edu.upc.eetac.dsa.service;
import edu.upc.eetac.dsa.ManagerImpl;
import edu.upc.eetac.dsa.models.*;
import edu.upc.eetac.dsa.Manager;
import edu.upc.eetac.dsa.Manager;
import edu.upc.eetac.dsa.ManagerImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

//Models or Element Entity
//Swagger Imports
@Api(value = "/Maps", description = "Endpoint to Maps Service")
@Path("/Maps")
public class MapsService
{
    static final Logger logger = Logger.getLogger(MapsService.class);
    private Manager manager;

    public MapsService()
    {
        //Configuring Log4j, location of the log4j.properties file and must always be inside the src folder
        PropertyConfigurator.configure("src/main/resources/log4j.properties");
        this.manager = ManagerImpl.getInstance();

        if (this.manager.getMapsList().size() == 0)
        {
            //Adding Maps
            this.manager.registerMap("2","Resa", "11-41/"
                    + "W-W-W-W-W-W-W-W-W-W-W-W-W-W-W-W-W-W-W-W-W-W-W-W-W-W-W-W-W-W-W-W-W-W-W-W-W-W-W-W-W/"
                    + "W-f-f-f-f-f-f-f-f-f-f-f-f-f-f-f-f-f-f-f-f-f-f-f-f-f-f-f-f-f-f-f-f-f-f-f-f-f-f-f-W/"
                    + "W-f-f-f-f-f-f-f-f-f-f-f-f-f-f-f-f-f-f-f-f-f-f-f-f-f-f-f-f-f-f-f-f-f-f-f-f-f-f-f-W/"
                    + "e1-ed-W-f-f-W-W-W-W-W-W-e7-e8-e8-e8-e9-W-f-f-W-W-W-W-W-W-e7-e8-e8-e8-e9-W-f-f-W-W-W-W-W-W-ed-e4/"
                    + "no-no-W-f-f-w-f-f-f-f-W-no-no-no-no-no-W-f-f-w-f-f-f-f-W-no-no-no-no-no-W-f-f-w-f-f-f-f-W-no-no-no-no-no-no-no/"
                    + "no-no-W-f-f-f-f-f-f-f-W-no-no-no-no-no-W-f-f-f-f-f-f-f-W-no-no-no-no-no-W-f-f-f-f-f-f-f-W-no-no-no-no-no-no-no/"
                    + "no-no-W-f-f-W-f-t2-t4-f-W-no-no-no-no-no-W-f-f-W-f-t2-t4-f-W-no-no-no-no-no-W-f-f-W-f-t2-t4-f-W-no-no-no-no-no-no-no/"
                    + "no-no-W-f-f-W-f-f-f-f-W-no-no-no-no-no-W-f-f-W-f-f-f-f-W-no-no-no-no-no-W-f-f-W-f-f-f-f-W-no-no-no-no-no-no-no/"
                    + "no-no-W-f-f-W-f-t2-t4-f-W-no-no-no-no-no-W-f-f-W-f-t2-t4-f-W-no-no-no-no-no-W-f-f-W-f-t2-t4-f-W-no-no-no-no-no-no-no/"
                    + "no-no-W-f-f-W-f-f-f-f-W-no-no-no-no-no-W-f-f-W-f-f-f-f-W-no-no-no-no-no-W-f-f-W-f-f-f-f-W-no-no-no-no-no-no-no/"
                    + "no-no-e1-e2-e3-e7-e8-e8-e8-e9-e4-no-no-no-no-no-e1-e2-e3-e7-e8-e8-e8-e9-e4-no-no-no-no-no-e1-e2-e3-e7-e8-e8-e8-e9-e4-no-no-no-no-no-no-no/");
            this.manager.registerMap("3","Canteen", "10-18/"
                    + "w-w-w-w-w-w-w-w-w-w-@-w-w-5-7-5-7-w/"
                    + "C-1-3-s-C-1-3-s-C-C-R-C-C-6-8-6-8-C/"
                    + "C-2-4-s-C-2-4-s-C-S-#-C-C-C-C-C-C-C/"
                    + "C-s-s-C-C-s-s-C-C-C-R-C-C-C-C-C-C-C/"
                    + "C-C-C-C-C-C-C-C-C-S-%-&-&-&-&-&-&-&/"
                    + "C-C-C-C-C-C-C-C-C-S-~-(-(-(-(-(-(-(/"
                    + "C-1-3-s-C-1-3-s-C-C-C-C-C-C-C-C-C-C/"
                    + "C-2-4-s-C-2-4-s-C-2-4-C-C-C-C-C-C-C/"
                    + "C-s-s-C-C-s-s-C-C-s-s-C-C-C-C-C-C-C/"
                    + "C-C-C-C-C-C-C-C-C-C-C-C-C-C-C-C-ed-C/");
            this.manager.registerMap("1","Campus", "14-18/"
                    + "g-g-g-g-g-g-g-g-g-g-g-g-g-g-g-g-g-g/"
                    + "g-f-f-f-f-f-f-f-f-q-no-f-f-f-f-f-f-g/"
                    + "g-f-f-f-f-f-f-f-f-no-no-f-f-f-f-f-f-g/"
                    + "g-f-g-g-g-g-g-g-f-f-g-g-g-g-g-g-f-g/"
                    + "g-f-g-u-no-no-f-f-f-f-f-f-r-no-g-g-f-g/"
                    + "g-f-g-no-no-no-f-f-f-f-f-f-no-no-g-g-f-g/"
                    + "g-f-g-g-g-g-g-g-f-f-g-g-g-g-g-g-f-g/"
                    + "g-f-g-e-1-1-f-f-f-f-g-g-g-g-g-g-g-g/"
                    + "g-f-g-1-1-1-f-f-f-f-g-g-i-o-p-g-g-g/"
                    + "g-f-g-g-g-g-f-f-f-f-g-g-k-lk-n-g-g-g/"
                    + "g-f-g-g-g-g-g-g-f-f-g-g-x-c-v-g-g-g/"
                    + "g-f-f-f-f-f-f-f-f-f-g-g-g-g-g-g-g-g/"
                    + "g-f-f-f-f-f-f-f-f-f-f-f-f-f-f-f-f-g/"
                    + "g-g-g-g-g-g-g-g-g-g-g-g-g-g-g-g-g-g/");
            this.manager.registerMap("4","Office", "12-19/"
                    + "W-K-L-Ñ-w-w-w-K-L-Ñ-w-w-w-K-L-Ñ-w-w-W/"
                    + "W-C-C-C-C-C-W-C-C-C-C-C-W-C-C-C-C-C-W/"
                    + "W-S-O-4-C-C-W-S-O-4-C-C-W-S-O-4-C-C-W/"
                    + "W-C-s-s-C-C-W-C-s-s-C-C-W-C-s-s-C-C-W/"
                    + "W-w-w-w-w-C-w-w-w-w-w-C-w-w-w-w-w-C-W/"
                    + "ed-C-C-C-C-C-C-C-C-C-C-C-C-C-C-C-C-C-W/"
                    + "ed-C-C-C-C-C-C-C-C-C-C-C-C-C-C-C-C-C-W/"
                    + "W-K-L-Ñ-w-C-w-K-L-Ñ-w-C-w-K-L-Ñ-w-C-W/"
                    + "W-C-C-C-C-C-W-C-C-C-C-C-W-C-C-C-C-C-W/"
                    + "W-S-O-4-C-C-W-S-O-4-C-C-W-S-O-4-C-C-W/"
                    + "W-C-s-s-C-C-W-C-s-s-C-C-W-C-s-s-C-C-W/"
                    + "W-W-W-W-W-W-W-W-W-W-W-W-W-W-W-W-W-W-W/");
            this.manager.registerMap("5","Lake", "10-18/"
                    + "ed-f-f-f-f-f-f-f-f-f-f-f-f-f-f-f-f-f/"
                    + "f-g-g-g-g-g-g-g-g-g-g-g-g-g-g-g-g-f/"
                    + "f-g-i-o-o-o-o-o-o-o-o-o-o-o-o-p-g-f/"
                    + "f-g-k-l-l-l-l-l-l-l-l-l-l-l-l-n-g-f/"
                    + "f-g-k-l-l-l-z-l-l-l-l-l-z-l-l-n-g-f/"
                    + "f-g-k-l-l-l-l-l-l-z-l-l-l-l-l-n-g-f/"
                    + "f-g-k-l-l-l-l-l-l-l-l-l-l-l-l-n-g-f/"
                    + "f-g-x-c-c-c-c-c-c-c-c-c-c-c-c-v-g-f/"
                    + "f-g-g-g-g-g-g-g-g-g-g-g-g-g-g-g-g-f/"
                    + "f-f-f-f-f-f-f-f-f-f-f-f-f-f-f-f-f-f");
            this.manager.registerMap("6","EETAC", "11-41/"
                    + "W-W-W-W-W-W-W-W-W-W-W-W-W-W-W-W-W-W-W-W-W-W-W-W-W-W-W-W-W-W-W-W-W-W-W-W-W-W-W-W-W/"
                    + "W-f-f-f-f-f-f-f-f-f-f-f-f-f-f-f-f-f-f-f-f-f-f-f-f-f-f-f-f-f-f-f-f-f-f-f-f-f-f-f-W/"
                    + "W-f-f-f-f-f-f-f-f-f-f-f-f-f-f-f-f-f-f-f-f-f-f-f-f-f-f-f-f-f-f-f-f-f-f-f-f-f-f-f-W/"
                    + "e1-ed-W-f-f-W-W-W-W-W-W-e7-e8-e8-e8-e9-W-f-f-W-W-W-W-W-W-e7-e8-e8-e8-e9-W-f-f-W-W-W-W-W-W-ed-e4/"
                    + "no-no-W-f-f-w-f-f-f-f-W-no-no-no-no-no-W-f-f-w-f-f-f-f-W-no-no-no-no-no-W-f-f-w-f-f-f-f-W-no-no-no-no-no-no-no/"
                    + "no-no-W-f-f-f-f-f-f-f-W-no-no-no-no-no-W-f-f-f-f-f-f-f-W-no-no-no-no-no-W-f-f-f-f-f-f-f-W-no-no-no-no-no-no-no/"
                    + "no-no-W-f-f-W-f-2-4-f-W-no-no-no-no-no-W-f-f-W-f-2-4-f-W-no-no-no-no-no-W-f-f-W-f-2-4-f-W-no-no-no-no-no-no-no/"
                    + "no-no-W-f-f-W-f-f-f-f-W-no-no-no-no-no-W-f-f-W-f-f-f-f-W-no-no-no-no-no-W-f-f-W-f-f-f-f-W-no-no-no-no-no-no-no/"
                    + "no-no-W-f-f-W-f-2-4-f-W-no-no-no-no-no-W-f-f-W-f-2-4-f-W-no-no-no-no-no-W-f-f-W-f-2-4-f-W-no-no-no-no-no-no-no/"
                    + "no-no-W-f-f-W-f-f-f-f-W-no-no-no-no-no-W-f-f-W-f-f-f-f-W-no-no-no-no-no-W-f-f-W-f-f-f-f-W-no-no-no-no-no-no-no/"
                    + "no-no-e1-e2-e3-e7-e8-e8-e8-e9-e4-no-no-no-no-no-e1-e2-e3-e7-e8-e8-e8-e9-e4-no-no-no-no-no-e1-e2-e3-e7-e8-e8-e8-e9-e4-no-no-no-no-no-no-no/");
        }
    }

    //
    @GET
    @ApiOperation(value="Get all Maps", notes="get all maps")
    @ApiResponses(value={
            @ApiResponse(code = 201, message = "Successful", response = Maps.class, responseContainer = "List"),
            @ApiResponse(code = 404, message = "Not Found.")
    })
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMaps(){
        List<Maps> maps = this.manager.getMapsList();
        if (maps == null){
            return Response.status(404).build();
        } else {
            GenericEntity<List<Maps>> entity = new GenericEntity<List<Maps>>(maps) {
            };
            return Response.status(201).entity(entity).header("Access-Control-Allow-Origin", "*").build();
        }
    }

    //
    @GET
    @ApiOperation(value="Get a map", notes="Get a map")
    @ApiResponses(value={
            @ApiResponse(code = 201, message = "Successful", response = Maps.class, responseContainer = "List"),
            @ApiResponse(code = 404, message = "Not Found.")
    })
    @Path("/{mapID}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMap(@PathParam("mapID") String MapID){
        Maps entity = this.manager.getMaps(MapID);
        if (entity == null){
            return Response.status(404).build();
        } else {
            return Response.status(201).entity(entity).build();
        }
    }
}

