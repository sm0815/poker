package de.smetzger.poker;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Joiner;

public class PokerHand {
    private static final Logger LOGGER = LoggerFactory.getLogger(PokerHand.class);

    private final Set<PokerCard> hand;

    PokerHand(Set<PokerCard> hand) {
        this.hand = hand;
    }

    public Set<PokerCard> getHand() {
        return Collections.unmodifiableSet(hand);
    }

    public static PokerHand fromStringRepresentation(String stringRepresentation) {
        String[] cardsInStringRepresentation = stringRepresentation.split("\\s+");
        LOGGER.debug("Split poker hand representation '{}' into: {}", stringRepresentation, cardsInStringRepresentation);
        if (cardsInStringRepresentation.length != 5) {
            throw new IllegalArgumentException("Invalid poker hand representation:'" + stringRepresentation
                    + "', could not split into 5 cards, but into:" + Joiner.on(',').join(cardsInStringRepresentation));
        }

        try {
            Set<PokerCard> hand = Arrays.stream(cardsInStringRepresentation).map(PokerCard::fromStringRepresentation)
                    .collect(Collectors.toSet());
            return new PokerHand(hand);
        } catch (IllegalArgumentException parsingException) {
            throw new IllegalArgumentException("Could not parse poker hand " + cardsInStringRepresentation,
                    parsingException);
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((hand == null) ? 0 : hand.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PokerHand other = (PokerHand) obj;
        if (hand == null) {
            if (other.hand != null)
                return false;
        } else if (!hand.equals(other.hand))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "PokerHand [hand=" + hand + "]";
    }

}
