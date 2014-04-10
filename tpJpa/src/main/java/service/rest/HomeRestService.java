package service.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import service.*;
import fr.istic.tpjpa1.domain.*;


@Path("/home")
public class HomeRestService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Home getDefaultHomeInJSON() {
        HomeService home = new HomeService();
        return home.getDefaultHome();
    }
}