package de.smetzger.poker.hand.types;

import junit.framework.Assert;

import org.junit.Test;

import de.smetzger.poker.hand.PokerHand;

public class FlushHandTypeTest {

    @Test
    public void testRankByHighestCardValue() {
        PokerHand aHand = PokerHand.fromStringRepresentation("C5 C2 C7 C8 C9");
        PokerHand anotherHand = PokerHand.fromStringRepresentation("C4 C5 CA C7 C8");
        PokerHandType aTypeMatch = new FlushHandType(aHand);
        PokerHandType anotherTypeMatch = new FlushHandType(anotherHand);
        Assert.assertTrue(aTypeMatch.compareTo(anotherTypeMatch) < 0);
    }



    @Test
    public void testRankEqualIfEqualStraight() {
        PokerHand aHand = PokerHand.fromStringRepresentation("C5 C6 D7 C8 C9");
        PokerHand anotherHand = PokerHand.fromStringRepresentation("C5 C6 S7 C8 C9");
        PokerHandType aTypeMatch = new FlushHandType(aHand);
        PokerHandType anotherTypeMatch = new FlushHandType(anotherHand);
        Assert.assertTrue(aTypeMatch.compareTo(anotherTypeMatch) == 0);
    }
}
