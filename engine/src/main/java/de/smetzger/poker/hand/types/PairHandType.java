package de.smetzger.poker.hand.types;

import de.smetzger.poker.hand.PokerCardValue;
import de.smetzger.poker.hand.PokerHand;

public class PairHandType extends SingleXOfAKindHandType {

    public PairHandType(PokerHand pokerHand, PokerCardValue pairvalue) {
        super(pokerHand, pairvalue, PokerHandTypeIdentifier.PAIR);
    }
}
