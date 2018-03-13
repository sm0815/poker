package de.smetzger.poker.hand.types;

import de.smetzger.poker.hand.PokerHand;

public interface PokerHandType extends Comparable<PokerHandType> {

    public enum PokerHandTypeIdentifier {
        HIGH_CARD, PAIR, TWO_PAIRS, THREE_OF_A_KIND, STRAIGHT, FLUSH, FULL_HOUSE, FOUR_OF_A_KIND, STRAIGHT_FLUSH;
    }

    PokerHandTypeIdentifier getPokerHandTypeIdentifier();

    PokerHand getPokerHand();
}
