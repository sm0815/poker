package de.smetzger.poker;

import de.smetzger.poker.hand.PokerHand;

public interface PokerHandEvaluator {

	/** returns 1 of the first hand is better, -1 if the second hand is better, 0 if none are better */
	int compareHands (PokerHand oneHand, PokerHand anotherHand);
}
