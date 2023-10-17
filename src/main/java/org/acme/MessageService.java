package org.acme;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.acme.entity.Messages;
import org.jboss.logging.Logger;

import com.arjuna.ats.jta.exceptions.NotImplementedException;
import com.oracle.svm.core.annotate.Inject;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Tags;



@Path("/message")
public class MessageService {


    @Inject
    MeterRegistry registry;

    private static final Logger LOG = Logger.getLogger(MessageService.class);

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String message() {
        List<Messages> messages = Messages.findAllMessages();
        

        String stringMessage = messages.stream().map(Messages::getMessage)
                       .collect(Collectors.joining(", "));
        LOG.info("Send the Messages");
        registry.counter("send message", Tags.of("length",String.valueOf(messages.size()))).increment();
        return stringMessage;
    }

    @POST
    @Transactional
    public void hello(String message){

        Messages messages = new Messages();
        if (!message.isBlank()){
            messages.setMessage(message);
            messages.persist();
            registry.counter("get new message", Tags.of("mesage",message)).increment();
        } else {
            LOG.info("receoved empty message");
        }
        
    }

    @DELETE
    @Transactional
    public void reset(){
        Messages.deleteAllMessages();
    }

    @PUT
    public void put() throws NotImplementedException{
        throw new NotImplementedException();
    }
}
