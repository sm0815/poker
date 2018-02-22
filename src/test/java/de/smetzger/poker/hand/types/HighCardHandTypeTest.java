package de.smetzger.poker.hand.types;

import junit.framework.Assert;

import org.junit.Test;

import de.smetzger.poker.hand.PokerHand;

public class HighCardHandTypeTest {

    @Test
    public void testRankByHighestValue() {
        PokerHand aHand = PokerHand.fromStringRepresentation("C5 DA H3 H4 S2");
        PokerHand anotherHand = PokerHand.fromStringRepresentation("C5 D8 H3 H4 S2");
        HighCardHandType aTypeMatch = new HighCardHandType(aHand);
        HighCardHandType anotherTypeMatch = new HighCardHandType(anotherHand);
        Assert.assertTrue(aTypeMatch.compareTo(anotherTypeMatch) > 0);
    }
}
