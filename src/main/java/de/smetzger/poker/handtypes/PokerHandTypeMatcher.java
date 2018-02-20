package de.smetzger.poker.handtypes;

import de.smetzger.poker.PokerHand;

public interface PokerHandTypeMatcher {

    /**
     * checks if the poker hand matches a hand type this matcher can identify
     * @param hand
     *            the poker hand to check against
     * @return the poker hand type this matcher could identify in the poker hand; if the matcher can identify multiple
     *         hands, the one ranked highest is returned
     *
     */
    PokerHandType match(PokerHand hand);
}
