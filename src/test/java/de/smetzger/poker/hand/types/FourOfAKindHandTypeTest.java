package de.smetzger.poker.hand.types;

import junit.framework.Assert;

import org.junit.Test;

import de.smetzger.poker.hand.PokerCardValue;
import de.smetzger.poker.hand.PokerHand;

public class FourOfAKindHandTypeTest {

    @Test
    public void testRankByHighestPairValue() {
        PokerHand aHand = PokerHand.fromStringRepresentation("C5 D5 H5 S5 S2");
        PokerHand anotherHand = PokerHand.fromStringRepresentation("C4 S4 D4 H4 SA");
        PokerHandType aTypeMatch = new FourOfAKindHandType(aHand, PokerCardValue.FIVE);
        PokerHandType anotherTypeMatch = new FourOfAKindHandType(anotherHand, PokerCardValue.FOUR);
        Assert.assertTrue(aTypeMatch.compareTo(anotherTypeMatch) > 0);
    }

    @Test
    public void testRankByHighestCardIfPairValueEqual() {
        PokerHand aHand = PokerHand.fromStringRepresentation("C5 D5 H5 S5 SA");
        PokerHand anotherHand = PokerHand.fromStringRepresentation("C5 S5 D5 H5 S2");
        PokerHandType aTypeMatch = new FourOfAKindHandType(aHand, PokerCardValue.FIVE);
        PokerHandType anotherTypeMatch = new FourOfAKindHandType(anotherHand, PokerCardValue.FIVE);
        Assert.assertTrue(aTypeMatch.compareTo(anotherTypeMatch) > 0);
    }

    @Test
    public void testRankEqualIfPairAndHighestRankEqual() {
        PokerHand aHand = PokerHand.fromStringRepresentation("C5 D5 H5 S5 S2");
        PokerHand anotherHand = PokerHand.fromStringRepresentation("D5 H5 S5 S5 D2");
        PokerHandType aTypeMatch = new FourOfAKindHandType(aHand, PokerCardValue.FIVE);
        PokerHandType anotherTypeMatch = new FourOfAKindHandType(anotherHand, PokerCardValue.FIVE);
        Assert.assertTrue(aTypeMatch.compareTo(anotherTypeMatch) == 0);
    }
}
