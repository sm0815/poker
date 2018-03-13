package de.smetzger.poker.hand.matchers;

import junit.framework.Assert;

import org.junit.Test;

import de.smetzger.poker.hand.PokerHand;
import de.smetzger.poker.hand.types.PokerHandType;
import de.smetzger.poker.hand.types.PokerHandType.PokerHandTypeIdentifier;

public class SameValueHandTypeMatcherTest {

    SameValueHandTypeMatcher matcher = new SameValueHandTypeMatcher();


    @Test
    public void testDontMatchAPlainHighRankHand() {
        PokerHand aHand = PokerHand.fromStringRepresentation("C5 DA H3 H4 S2");
        PokerHandType match = matcher.match(aHand);
        Assert.assertEquals(null, match);
    }

    @Test
    public void testDontMatchAStraightHand() {
        PokerHand aHand = PokerHand.fromStringRepresentation("C2 D3 H4 H5 S6");
        PokerHandType match = matcher.match(aHand);
        Assert.assertEquals(null, match);
    }

    // TODO: check special values, e.g. Pairvalues

    @Test
    public void testMatchAPairHand() {
        PokerHand aHand = PokerHand.fromStringRepresentation("C2 DA H3 H4 S2");
        PokerHandType match = matcher.match(aHand);
        Assert.assertEquals(PokerHandTypeIdentifier.PAIR, match.getPokerHandTypeIdentifier());
        Assert.assertEquals("the hand should stay unmodified", aHand, match.getPokerHand());
    }

    @Test
    public void testMatchATwoPairHand() {
        PokerHand aHand = PokerHand.fromStringRepresentation("C2 D3 H3 H4 S2");
        PokerHandType match = matcher.match(aHand);
        Assert.assertEquals(PokerHandTypeIdentifier.TWO_PAIRS, match.getPokerHandTypeIdentifier());
        Assert.assertEquals("the hand should stay unmodified", aHand, match.getPokerHand());
    }

    @Test
    public void testMatchATripletHand() {
        PokerHand aHand = PokerHand.fromStringRepresentation("C2 DA H2 H4 S2");
        PokerHandType match = matcher.match(aHand);
        Assert.assertEquals(PokerHandTypeIdentifier.THREE_OF_A_KIND, match.getPokerHandTypeIdentifier());
        Assert.assertEquals("the hand should stay unmodified", aHand, match.getPokerHand());
    }

    @Test
    public void testMatchAQuartetHand() {
        PokerHand aHand = PokerHand.fromStringRepresentation("C2 D2 H2 H4 S2");
        PokerHandType match = matcher.match(aHand);
        Assert.assertEquals(PokerHandTypeIdentifier.FOUR_OF_A_KIND, match.getPokerHandTypeIdentifier());
        Assert.assertEquals("the hand should stay unmodified", aHand, match.getPokerHand());
    }

    @Test
    public void testMatchAFullHouseHand() {
        PokerHand aHand = PokerHand.fromStringRepresentation("C2 D2 H3 D3 S3");
        PokerHandType match = matcher.match(aHand);
        Assert.assertEquals(PokerHandTypeIdentifier.FULL_HOUSE, match.getPokerHandTypeIdentifier());
        Assert.assertEquals("the hand should stay unmodified", aHand, match.getPokerHand());
    }
}
