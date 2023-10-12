package org.acme;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.logging.Logger;
import org.jboss.resteasy.resteasy_jaxrs.i18n.LogMessages_.logger;

@Path("/selfkill")
public class SelfKillResource {

    private static final Logger LOG = Logger.getLogger(SelfKillResource.class);

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        LOG.info("Pod will dye now");
        System.exit(0);
        return "Hello RESTEasyasasdasdasdd";
    }
}

