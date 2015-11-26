package de.hillkorn.rest;

import de.hillkorn.dto.Simple;
import de.hillkorn.service.TestService;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/hello")
public class Hello {

    @Inject
    public TestService testService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Simple get() {
        return testService.getTest();
    }

    @GET
    @Path("/async")
    @Produces(MediaType.APPLICATION_JSON)
    public void get(@Suspended AsyncResponse response) {
        response.resume(Response.ok(new Simple("ASYNC")).build());
    }
}
