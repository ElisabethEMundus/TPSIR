package service.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import service.*;
import fr.istic.tpjpa1.domain.*;


@Path("/heat")
public class HeaterRestService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Heater getDefaultElectronicDeviceInJSON() {
        HeaterService heat = new HeaterService();
        return heat.getDefaultHeater();
    }
}