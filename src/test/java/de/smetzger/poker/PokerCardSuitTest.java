package de.smetzger.poker;

import junit.framework.Assert;

import org.junit.Test;

public class PokerCardSuitTest {


    @Test
    public void testSucessfulStringRepresentationParsingClubs() {
        PokerCardSuit suit = PokerCardSuit.fromStringRepresentation("C");
        Assert.assertEquals(PokerCardSuit.CLUBS, suit);
    }

    @Test
    public void testSucessfulStringRepresentationParsingDiamonds() {
        PokerCardSuit suit = PokerCardSuit.fromStringRepresentation("D");
        Assert.assertEquals(PokerCardSuit.DIAMONDS, suit);
    }

    @Test
    public void testSucessfulStringRepresentationParsingHearts() {
        PokerCardSuit suit = PokerCardSuit.fromStringRepresentation("H");
        Assert.assertEquals(PokerCardSuit.HEARTS, suit);
    }

    @Test
    public void testSucessfulStringRepresentationParsingSpades() {
        PokerCardSuit suit = PokerCardSuit.fromStringRepresentation("S");
        Assert.assertEquals(PokerCardSuit.SPADES, suit);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFailingToParseEmptyString() {
        PokerCardSuit.fromStringRepresentation("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFailingToParseNonMatchingString() {
        PokerCardSuit.fromStringRepresentation("Z");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFailingToParseTooLongString() {
        PokerCardSuit.fromStringRepresentation("CC");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFailingToParseSpecialCharacterString() {
        PokerCardSuit.fromStringRepresentation("\nC");
    }
}
