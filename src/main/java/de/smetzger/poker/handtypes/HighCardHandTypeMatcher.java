package de.smetzger.poker.handtypes;

import de.smetzger.poker.PokerHand;

public class HighCardHandTypeMatcher implements PokerHandTypeMatcher {

    @Override
    public PokerHandType match(PokerHand hand) {
        return new HighCardHandType(hand);
    }

}
