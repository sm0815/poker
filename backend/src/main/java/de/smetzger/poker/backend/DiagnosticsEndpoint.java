package de.smetzger.poker.backend;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * This class provides dedicated diagnostics / monitoring methods.
 */
@Path("diagnostics")
@Api(tags = "poker")
@RequestScoped
public class DiagnosticsEndpoint {
    private static final Logger LOGGER = LoggerFactory.getLogger(DiagnosticsEndpoint.class);
    private static final Status ALIVE = new Status(true);

    public static class Status {

        boolean alive;

        public Status() {
            super();
        }

        public Status(boolean alive) {
            super();
            this.alive = alive;
        }

        public boolean isAlive() {
            return alive;
        }

        public void setAlive(boolean alive) {
            this.alive = alive;
        }

    }

    @GET
    @Path("alive")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(
            value = "As long as this answers with true, the application has in principle enough capacities to answer queries, obviously.")
    public Status isAlive() {

        LOGGER.trace("Attempt to retrieve alive status");

        return ALIVE;
    }
}
