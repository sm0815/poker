package de.smetzger.poker;

import de.smetzger.poker.hand.PokerHand;
import de.smetzger.poker.hand.types.PokerHandType;

public interface PokerHandEvaluator {

    /** returns the the winning poker hand type (along with the poker hand) */
    PokerHandType compareHands(PokerHand oneHand, PokerHand anotherHand);
}
