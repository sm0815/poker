package de.smetzger.poker;

public interface PokerHandEvaluator {

	//TODO: return the hand instead of an int? a dedicated answer-object? 
	//TODO: extend documentation
	//TODO: write this as a comparator?
	/** returns 1 of the first hand is better, -1 if the second hand is better, 0 if none are better */
	int compareHands (PokerHand oneHand, PokerHand anotherHand);
}
