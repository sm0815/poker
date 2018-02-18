package de.smetzger.poker;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PokerHand {
    private static final Logger LOGGER = LoggerFactory.getLogger(PokerHand.class);

    private final Set<PokerCard> hand;

    private PokerHand(Set<PokerCard> hand) {
        this.hand = hand;
    }

    public Set<PokerCard> getHand() {
        return Collections.unmodifiableSet(hand);
    }

    public static PokerHand fromStringRepresentation(String stringRepresentation) {
        String[] cardsInStringRepresentation = stringRepresentation.split("\\s*");
        LOGGER.debug("Split poker hand representation '{}' into: {}", stringRepresentation, cardsInStringRepresentation);
        if (cardsInStringRepresentation.length != 5) {
            throw new IllegalArgumentException("Invalid poker hand representation:'" + stringRepresentation
                    + "', could not split into 5 cards, but into:" + cardsInStringRepresentation);
        }

        try {
            Set<PokerCard> hand = Arrays.stream(cardsInStringRepresentation)
.map(PokerCard::fromStringRepresentation)
                    .collect(Collectors.toSet());
            return new PokerHand(hand);
        } catch (IllegalArgumentException parsingException) {
            throw new IllegalArgumentException("Could not parse poker hand " + cardsInStringRepresentation,
                    parsingException);
        }
    }
}
