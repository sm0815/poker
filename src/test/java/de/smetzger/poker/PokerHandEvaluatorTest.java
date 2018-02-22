package de.smetzger.poker;

import junit.framework.Assert;

import org.junit.Test;

import de.smetzger.poker.hand.PokerHand;


public class PokerHandEvaluatorTest {

    PokerHandEvaluator evaluator = new SimplePokerHandEvaluator();


    @Test
    public void testCompareTwoHighCardHands() {
        PokerHand lowerHand = PokerHand.fromStringRepresentation("C5 D2 H3 H4 S2");
        PokerHand higherHand = PokerHand.fromStringRepresentation("C8 D2 H3 H4 S2");
        Assert.assertTrue(evaluator.compareHands(lowerHand, higherHand) < 0);
    }

    @Test
    public void testCompareTwoEqualHighCardHands() {
        PokerHand hand1 = PokerHand.fromStringRepresentation("C5 D2 H3 H4 S2");
        PokerHand hand2 = PokerHand.fromStringRepresentation("D5 C2 S3 S4 H2");
        Assert.assertEquals(0, evaluator.compareHands(hand1, hand2));
    }

    @Test
    public void testCompareTwoPairHands() {
        PokerHand lowerHand = PokerHand.fromStringRepresentation("C5 D5 H3 H4 S2");
        PokerHand higherHand = PokerHand.fromStringRepresentation("C8 D8 H3 H4 S2");
        Assert.assertTrue(evaluator.compareHands(lowerHand, higherHand) < 0);
    }

    @Test
    public void testCompareTwoPairHandsWithEqualPairDecidedByHighRank() {
        PokerHand lowerHand = PokerHand.fromStringRepresentation("C5 D5 H3 H4 S2");
        PokerHand higherHand = PokerHand.fromStringRepresentation("H5 D5 S8 S4 H2");
        Assert.assertTrue(evaluator.compareHands(lowerHand, higherHand) < 0);
    }

    @Test
    public void testCompareTwoEqualPairHands() {
        PokerHand hand1 = PokerHand.fromStringRepresentation("C5 D5 H3 H4 S2");
        PokerHand hand2 = PokerHand.fromStringRepresentation("H5 D5 S3 S4 H2");
        Assert.assertEquals(0, evaluator.compareHands(hand1, hand2));
    }

    @Test
    public void testStraightVsThreeOfAKind() {
        PokerHand hand1 = PokerHand.fromStringRepresentation("C5 D6 H2 H4 S3");
        PokerHand hand2 = PokerHand.fromStringRepresentation("H5 D5 S5 S4 H2");
        Assert.assertTrue(evaluator.compareHands(hand1, hand2) > 0);
    }

    @Test
    public void testPairVsHighRank() {
        PokerHand hand1 = PokerHand.fromStringRepresentation("C3 D2 DK D3 C4");
        PokerHand hand2 = PokerHand.fromStringRepresentation("C3 D2 DK DA C4");
        Assert.assertTrue(evaluator.compareHands(hand1, hand2) > 0);
    }

    @Test
    public void testFlushVsStraightFlush() {
        PokerHand hand1 = PokerHand.fromStringRepresentation("C3 C2 CK C6 C4");
        PokerHand hand2 = PokerHand.fromStringRepresentation("C3 C2 C6 C5 C4");
        Assert.assertTrue(evaluator.compareHands(hand1, hand2) < 0);
    }

}
