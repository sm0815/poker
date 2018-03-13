package de.smetzger.poker.hand.types;

import de.smetzger.poker.hand.PokerCardValue;
import de.smetzger.poker.hand.PokerHand;

public class ThreeOfAKindHandType extends SingleXOfAKindHandType {

    public ThreeOfAKindHandType(PokerHand pokerHand, PokerCardValue pairvalue) {
        super(pokerHand, pairvalue, PokerHandTypeIdentifier.THREE_OF_A_KIND);
    }
}
