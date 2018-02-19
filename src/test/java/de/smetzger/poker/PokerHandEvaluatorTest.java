package de.smetzger.poker;

import junit.framework.Assert;

import org.junit.Test;

public class PokerHandEvaluatorTest {

    // TODO: inject
    PokerHandEvaluator evaluator = new SimplePokerHandEvaluator();


    @Test
    public void testCompareTwoHighCardHands() {
        PokerHand lowerHand = PokerHand.fromStringRepresentation("C5 D2 H3 H4 S2");
        PokerHand higherHand = PokerHand.fromStringRepresentation("C8 D2 H3 H4 S2");
        Assert.assertEquals(1, evaluator.compareHands(lowerHand, higherHand));
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
        Assert.assertEquals(1, evaluator.compareHands(lowerHand, higherHand));
    }

    @Test
    public void testCompareTwoPairHandsWithEqualPairDecidedByHighRank() {
        PokerHand lowerHand = PokerHand.fromStringRepresentation("C5 D5 H3 H4 S2");
        PokerHand higherHand = PokerHand.fromStringRepresentation("H5 D5 S8 S4 H2");
        Assert.assertEquals(0, evaluator.compareHands(lowerHand, higherHand));
    }

    @Test
    public void testCompareTwoEqualPairHands() {
        PokerHand hand1 = PokerHand.fromStringRepresentation("C5 D5 H3 H4 S2");
        PokerHand hand2 = PokerHand.fromStringRepresentation("H5 D5 S3 S4 H2");
        Assert.assertEquals(0, evaluator.compareHands(hand1, hand2));
    }

    // TODO: fill up with the other test cases once these work

}
