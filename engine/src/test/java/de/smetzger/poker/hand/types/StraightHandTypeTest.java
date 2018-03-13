package de.smetzger.poker.hand.types;

import junit.framework.Assert;

import org.junit.Test;

import de.smetzger.poker.hand.PokerHand;

public class StraightHandTypeTest {

    @Test
    public void testRankByHighestCardValue() {
        PokerHand aHand = PokerHand.fromStringRepresentation("C5 D6 H7 H8 S9");
        PokerHand anotherHand = PokerHand.fromStringRepresentation("C4 D5 D6 H7 S8");
        PokerHandType aTypeMatch = new StraightHandType(aHand);
        PokerHandType anotherTypeMatch = new StraightHandType(anotherHand);
        Assert.assertTrue(aTypeMatch.compareTo(anotherTypeMatch) > 0);
    }



    @Test
    public void testRankEqualIfEqualStraight() {
        PokerHand aHand = PokerHand.fromStringRepresentation("C5 D6 H7 H8 H9");
        PokerHand anotherHand = PokerHand.fromStringRepresentation("C5 D6 D7 H8 S9");
        PokerHandType aTypeMatch = new StraightHandType(aHand);
        PokerHandType anotherTypeMatch = new StraightHandType(anotherHand);
        Assert.assertTrue(aTypeMatch.compareTo(anotherTypeMatch) == 0);
    }
}
