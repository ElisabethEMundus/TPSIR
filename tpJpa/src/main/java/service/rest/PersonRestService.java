package service.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import service.*;
import fr.istic.tpjpa1.domain.*;


@Path("/person")
public class PersonRestService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Person getDefaultPersonInJSON() {
        PersonService pers = new PersonService();
        return pers.getDefaultPerson();
    }
}