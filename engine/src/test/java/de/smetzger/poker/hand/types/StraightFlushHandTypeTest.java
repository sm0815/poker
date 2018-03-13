package de.smetzger.poker.hand.types;

import junit.framework.Assert;

import org.junit.Test;

import de.smetzger.poker.hand.PokerHand;

public class StraightFlushHandTypeTest {

    @Test
    public void testRankByHighestCardValue() {
        PokerHand aHand = PokerHand.fromStringRepresentation("C5 C6 C7 C8 C9");
        PokerHand anotherHand = PokerHand.fromStringRepresentation("C4 C5 C6 C7 C8");
        PokerHandType aTypeMatch = new StraightFlushHandType(aHand);
        PokerHandType anotherTypeMatch = new StraightFlushHandType(anotherHand);
        Assert.assertTrue(aTypeMatch.compareTo(anotherTypeMatch) > 0);
    }



    @Test
    public void testRankEqualIfEqualStraight() {
        PokerHand aHand = PokerHand.fromStringRepresentation("C5 C6 C7 C8 C9");
        PokerHand anotherHand = PokerHand.fromStringRepresentation("C5 C6 C7 C8 C9");
        PokerHandType aTypeMatch = new StraightFlushHandType(aHand);
        PokerHandType anotherTypeMatch = new StraightFlushHandType(anotherHand);
        Assert.assertTrue(aTypeMatch.compareTo(anotherTypeMatch) == 0);
    }
}
