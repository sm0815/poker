package de.smetzger.poker.hand.types;

import de.smetzger.poker.hand.PokerCardValue;
import de.smetzger.poker.hand.PokerHand;

public class FourOfAKindHandType extends SingleXOfAKindHandType {

    public FourOfAKindHandType(PokerHand pokerHand, PokerCardValue pairvalue) {
        super(pokerHand, pairvalue, PokerHandTypeIdentifier.FOUR_OF_A_KIND);
    }
}
