package de.smetzger.poker.backend;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sun.istack.internal.NotNull;

import de.smetzger.poker.PokerHandEvaluator;
import de.smetzger.poker.SimplePokerHandEvaluator;
import de.smetzger.poker.hand.PokerHand;
import de.smetzger.poker.hand.types.PokerHandType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * This class provides the poker backend API.
 */
@Path("poker")
@Api(tags = "poker")
// @RequestScoped
public class PokerEndpoint {
    private static final Logger LOGGER = LoggerFactory.getLogger(PokerEndpoint.class);

    // TODO use factory, pool, dep injetion?
    PokerHandEvaluator handEvaluator = new SimplePokerHandEvaluator();

    // TODO: take the hand as an object already?
    @GET
    @Path("evaluate")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Evaluates two poker hand and returns the winning hand.")
    public ResultDTO evaluate(@NotNull @ApiParam(required = true) @QueryParam("handOne") String handOne,
            @NotNull @ApiParam(required = true) @QueryParam("handTwo") String handTwo) {

        LOGGER.debug("Attempt to evaluate hand '{}' against hand '{}'", handOne, handTwo);
        PokerHand handPlayerOne = PokerHand.fromStringRepresentation(handOne);
        handPlayerOne.setPlayer("ONE");
        PokerHand handPlayerTwo = PokerHand.fromStringRepresentation(handTwo);
        handPlayerTwo.setPlayer("TWO");
        PokerHandType evaluationResult = handEvaluator.compareHands(handPlayerOne, handPlayerTwo);

        ResultDTO result = new ResultDTO(evaluationResult.getPokerHand().getPlayer(),
                evaluationResult.getPokerHandTypeIdentifier());
        LOGGER.debug("Evaluated hand '{}' against hand '{}' to {}/{}", handOne, handTwo, evaluationResult, result);

        return result;
    }
}
