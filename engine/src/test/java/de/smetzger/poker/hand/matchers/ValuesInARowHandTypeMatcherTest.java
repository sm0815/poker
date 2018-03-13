package de.smetzger.poker.hand.matchers;

import junit.framework.Assert;

import org.junit.Test;

import de.smetzger.poker.hand.PokerHand;
import de.smetzger.poker.hand.matchers.ValuesInARowHandTypeMatcher;
import de.smetzger.poker.hand.types.PokerHandType;
import de.smetzger.poker.hand.types.PokerHandType.PokerHandTypeIdentifier;

public class ValuesInARowHandTypeMatcherTest {

    ValuesInARowHandTypeMatcher matcher = new ValuesInARowHandTypeMatcher();


    @Test
    public void testDontMatchAPlainHighRankHand() {
        PokerHand aHand = PokerHand.fromStringRepresentation("C5 DA H3 H4 S2");
        PokerHandType match = matcher.match(aHand);
        Assert.assertEquals(null, match);
    }

    @Test
    public void testDontMatchAPairHand() {
        PokerHand aHand = PokerHand.fromStringRepresentation("C5 DA H3 H2 S2");
        PokerHandType match = matcher.match(aHand);
        Assert.assertEquals(null, match);
    }

    @Test
    public void testmatchAStraightHand() {
        PokerHand aHand = PokerHand.fromStringRepresentation("C2 D3 H4 H5 S6");
        PokerHandType match = matcher.match(aHand);
        Assert.assertEquals(PokerHandTypeIdentifier.STRAIGHT, match.getPokerHandTypeIdentifier());
        Assert.assertEquals("the hand should stay unmodified", aHand, match.getPokerHand());
    }

    @Test
    public void testMatchAFlush() {
        PokerHand aHand = PokerHand.fromStringRepresentation("C2 CA C3 C4 C8");
        PokerHandType match = matcher.match(aHand);
        Assert.assertEquals(PokerHandTypeIdentifier.FLUSH, match.getPokerHandTypeIdentifier());
        Assert.assertEquals("the hand should stay unmodified", aHand, match.getPokerHand());
    }

    @Test
    public void testMatchAStraightFlush() {
        PokerHand aHand = PokerHand.fromStringRepresentation("C2 C3 C4 C5 C6");
        PokerHandType match = matcher.match(aHand);
        Assert.assertEquals(PokerHandTypeIdentifier.STRAIGHT_FLUSH, match.getPokerHandTypeIdentifier());
        Assert.assertEquals("the hand should stay unmodified", aHand, match.getPokerHand());
    }
}
