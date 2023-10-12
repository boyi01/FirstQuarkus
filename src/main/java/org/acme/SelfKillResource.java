package org.acme;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/selfkill")
public class SelfKillResource {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        System.exit(0);
        return "Hello RESTEasyasasdasdasdd";
    }
}

