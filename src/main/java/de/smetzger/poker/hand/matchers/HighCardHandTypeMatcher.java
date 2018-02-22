package de.smetzger.poker.hand.matchers;

import de.smetzger.poker.hand.PokerHand;
import de.smetzger.poker.hand.types.HighCardHandType;
import de.smetzger.poker.hand.types.PokerHandType;

/** base matcher - matches any card hand */
public class HighCardHandTypeMatcher implements PokerHandTypeMatcher {

    @Override
    public PokerHandType match(PokerHand hand) {
        return new HighCardHandType(hand);
    }

}
