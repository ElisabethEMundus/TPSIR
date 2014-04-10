package service.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import service.*;
import fr.istic.tpjpa1.domain.*;


@Path("/elec")
public class ElectronicDeviceRestService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ElectronicDevice getDefaultElectronicDeviceInJSON() {
        ElectronicDeviceService elec = new ElectronicDeviceService();
        return elec.getDefaultElectronicDevice();
    }
}