package de.smetzger.poker.hand.types;

import junit.framework.Assert;

import org.junit.Test;

import de.smetzger.poker.hand.PokerCardValue;
import de.smetzger.poker.hand.PokerHand;

public class PairHandTypeTest {

    @Test
    public void testRankByHighestPairValue() {
        PokerHand aHand = PokerHand.fromStringRepresentation("C5 D5 H3 H4 S2");
        PokerHand anotherHand = PokerHand.fromStringRepresentation("C5 D8 D4 H4 SA");
        PokerHandType aTypeMatch = new PairHandType(aHand, PokerCardValue.FIVE);
        PokerHandType anotherTypeMatch = new PairHandType(anotherHand, PokerCardValue.FOUR);
        Assert.assertTrue(aTypeMatch.compareTo(anotherTypeMatch) > 0);
    }

    @Test
    public void testRankByHighestCardIfPairValueEqual() {
        PokerHand aHand = PokerHand.fromStringRepresentation("C5 D5 H3 H4 SA");
        PokerHand anotherHand = PokerHand.fromStringRepresentation("C4 D8 D5 H5 S2");
        PokerHandType aTypeMatch = new PairHandType(aHand, PokerCardValue.FIVE);
        PokerHandType anotherTypeMatch = new PairHandType(anotherHand, PokerCardValue.FIVE);
        Assert.assertTrue(aTypeMatch.compareTo(anotherTypeMatch) > 0);
    }

    @Test
    public void testRankEqualIfPairAndHighestRankEqual() {
        PokerHand aHand = PokerHand.fromStringRepresentation("C5 D5 H3 H4 S2");
        PokerHand anotherHand = PokerHand.fromStringRepresentation("D5 H5 S3 H4 D2");
        PokerHandType aTypeMatch = new PairHandType(aHand, PokerCardValue.FIVE);
        PokerHandType anotherTypeMatch = new PairHandType(anotherHand, PokerCardValue.FIVE);
        Assert.assertTrue(aTypeMatch.compareTo(anotherTypeMatch) == 0);
    }
}
