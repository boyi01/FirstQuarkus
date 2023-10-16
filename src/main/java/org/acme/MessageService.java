package org.acme;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.acme.entity.Messages;
import org.jboss.logging.Logger;

@Path("/message")
public class MessageService {

    private static final Logger LOG = Logger.getLogger(MessageService.class);

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String message() {
        List<Messages> messages = Messages.findAllMessages();
        
        String stringMessage = messages.stream().map(Messages::getMessage)
                       .collect(Collectors.joining(", "));
        return stringMessage;
    }

    @POST
    @Transactional
    public void hello(String message){

        Messages messages = new Messages();
        messages.setMessage(message);
        messages.persist();
    }
}
