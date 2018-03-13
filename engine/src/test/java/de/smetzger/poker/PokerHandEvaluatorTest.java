package de.smetzger.poker;

import junit.framework.Assert;

import org.junit.Test;

import de.smetzger.poker.hand.PokerHand;
import de.smetzger.poker.hand.types.PokerHandType;
import de.smetzger.poker.hand.types.PokerHandType.PokerHandTypeIdentifier;


public class PokerHandEvaluatorTest {

    PokerHandEvaluator evaluator = new SimplePokerHandEvaluator();


    @Test
    public void testCompareTwoHighCardHands() {
        PokerHand lowerHand = PokerHand.fromStringRepresentation("C5 D7 H3 H4 S2");
        lowerHand.setPlayer("ONE");
        PokerHand higherHand = PokerHand.fromStringRepresentation("C8 D5 H3 H4 S2");
        higherHand.setPlayer("TWO");
        PokerHandType winningHandType = evaluator.compareHands(lowerHand, higherHand);
        Assert.assertEquals(higherHand, winningHandType.getPokerHand());
        Assert.assertEquals(PokerHandTypeIdentifier.HIGH_CARD, winningHandType.getPokerHandTypeIdentifier());
    }

    @Test
    public void testCompareTwoEqualHighCardHands() {
        PokerHand hand1 = PokerHand.fromStringRepresentation("C5 D2 H3 H4 S2");
        PokerHand hand2 = PokerHand.fromStringRepresentation("D5 C2 S3 S4 H2");
        Assert.assertEquals(null, evaluator.compareHands(hand1, hand2));
    }

    @Test
    public void testCompareTwoPairHands() {
        PokerHand lowerHand = PokerHand.fromStringRepresentation("C5 D5 H3 H4 S2");
        PokerHand higherHand = PokerHand.fromStringRepresentation("C8 D8 H3 H4 S2");
        PokerHandType winningHandType = evaluator.compareHands(lowerHand, higherHand);
        Assert.assertEquals(higherHand, winningHandType.getPokerHand());
        Assert.assertEquals(PokerHandTypeIdentifier.PAIR, winningHandType.getPokerHandTypeIdentifier());
    }

    @Test
    public void testCompareTwoPairHandsWithEqualPairDecidedByHighRank() {
        PokerHand lowerHand = PokerHand.fromStringRepresentation("C5 D5 H3 H4 S2");
        PokerHand higherHand = PokerHand.fromStringRepresentation("H5 D5 S8 S4 H2");
        PokerHandType winningHandType = evaluator.compareHands(lowerHand, higherHand);
        Assert.assertEquals(higherHand, winningHandType.getPokerHand());
        Assert.assertEquals(PokerHandTypeIdentifier.PAIR, winningHandType.getPokerHandTypeIdentifier());
    }

    @Test
    public void testCompareTwoEqualPairHands() {
        PokerHand hand1 = PokerHand.fromStringRepresentation("C5 D5 H3 H4 S2");
        PokerHand hand2 = PokerHand.fromStringRepresentation("H5 D5 S3 S4 H2");
        Assert.assertEquals(null, evaluator.compareHands(hand1, hand2));
    }

    @Test
    public void testStraightVsThreeOfAKind() {
        PokerHand higherHand = PokerHand.fromStringRepresentation("C5 D6 H2 H4 S3");
        PokerHand lowerHand = PokerHand.fromStringRepresentation("H5 D5 S5 S4 H2");
        PokerHandType winningHandType = evaluator.compareHands(lowerHand, higherHand);
        Assert.assertEquals(higherHand, winningHandType.getPokerHand());
        Assert.assertEquals(PokerHandTypeIdentifier.STRAIGHT, winningHandType.getPokerHandTypeIdentifier());
    }

    @Test
    public void testPairVsHighRank() {
        PokerHand higherHand = PokerHand.fromStringRepresentation("C3 D2 DK D3 C4");
        PokerHand lowerHand = PokerHand.fromStringRepresentation("C3 D2 DK DA C4");
        PokerHandType winningHandType = evaluator.compareHands(lowerHand, higherHand);
        Assert.assertEquals(higherHand, winningHandType.getPokerHand());
        Assert.assertEquals(PokerHandTypeIdentifier.PAIR, winningHandType.getPokerHandTypeIdentifier());
    }

    @Test
    public void testFlushVsStraightFlush() {
        PokerHand lowerHand = PokerHand.fromStringRepresentation("C3 C2 CK C6 C4");
        PokerHand higherHand = PokerHand.fromStringRepresentation("C3 C2 C6 C5 C4");
        PokerHandType winningHandType = evaluator.compareHands(lowerHand, higherHand);
        Assert.assertEquals(higherHand, winningHandType.getPokerHand());
        Assert.assertEquals(PokerHandTypeIdentifier.STRAIGHT_FLUSH, winningHandType.getPokerHandTypeIdentifier());
    }

}
