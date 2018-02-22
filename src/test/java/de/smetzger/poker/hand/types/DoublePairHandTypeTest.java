package de.smetzger.poker.hand.types;

import junit.framework.Assert;

import org.junit.Test;

import com.google.common.collect.Lists;

import de.smetzger.poker.hand.PokerCardValue;
import de.smetzger.poker.hand.PokerHand;

public class DoublePairHandTypeTest {

    @Test
    public void testRankByHighestPairValue() {
        PokerHand aHand = PokerHand.fromStringRepresentation("C5 D5 H2 H4 S2");
        PokerHand anotherHand = PokerHand.fromStringRepresentation("C3 D3 D4 H4 S6");
        PokerHandType aTypeMatch = new DoublePairHandType(aHand, Lists.newArrayList(PokerCardValue.FIVE,
                PokerCardValue.TWO), PokerCardValue.FOUR);
        PokerHandType anotherTypeMatch = new DoublePairHandType(anotherHand, Lists.newArrayList(PokerCardValue.FOUR,
                PokerCardValue.THREE), PokerCardValue.SIX);
        Assert.assertTrue(aTypeMatch.compareTo(anotherTypeMatch) > 0);
    }

    @Test
    public void testRankBySecondHighestPairIfHighestPairEqual() {
        PokerHand aHand = PokerHand.fromStringRepresentation("C5 D5 H2 H4 S2");
        PokerHand anotherHand = PokerHand.fromStringRepresentation("C3 D3 D5 H5 S6");
        PokerHandType aTypeMatch = new DoublePairHandType(aHand, Lists.newArrayList(PokerCardValue.FIVE,
                PokerCardValue.TWO), PokerCardValue.FOUR);
        PokerHandType anotherTypeMatch = new DoublePairHandType(anotherHand, Lists.newArrayList(PokerCardValue.FIVE,
                PokerCardValue.THREE), PokerCardValue.SIX);
        Assert.assertTrue(aTypeMatch.compareTo(anotherTypeMatch) < 0);
    }

    @Test
    public void testRankByHighestCardIfPairsValueEqual() {
        PokerHand aHand = PokerHand.fromStringRepresentation("C5 D5 H3 H4 S3");
        PokerHand anotherHand = PokerHand.fromStringRepresentation("C3 D3 D5 H5 S6");
        PokerHandType aTypeMatch = new DoublePairHandType(aHand, Lists.newArrayList(PokerCardValue.FIVE,
                PokerCardValue.THREE), PokerCardValue.FOUR);
        PokerHandType anotherTypeMatch = new DoublePairHandType(anotherHand, Lists.newArrayList(PokerCardValue.FIVE,
                PokerCardValue.THREE), PokerCardValue.SIX);
        Assert.assertTrue(aTypeMatch.compareTo(anotherTypeMatch) < 0);
    }


    @Test
    public void testRankEqualIfPairsAndHighestRankEqual() {
        PokerHand aHand = PokerHand.fromStringRepresentation("C5 D5 H3 H4 H6");
        PokerHand anotherHand = PokerHand.fromStringRepresentation("C3 D3 D5 H5 S6");
        PokerHandType aTypeMatch = new DoublePairHandType(aHand, Lists.newArrayList(PokerCardValue.FIVE,
                PokerCardValue.THREE), PokerCardValue.SIX);
        PokerHandType anotherTypeMatch = new DoublePairHandType(anotherHand, Lists.newArrayList(PokerCardValue.FIVE,
                PokerCardValue.THREE), PokerCardValue.SIX);
        Assert.assertTrue(aTypeMatch.compareTo(anotherTypeMatch) == 0);
    }
}
