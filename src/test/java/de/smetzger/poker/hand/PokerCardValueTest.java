package de.smetzger.poker.hand;

import junit.framework.Assert;

import org.junit.Test;

import de.smetzger.poker.hand.PokerCardValue;

public class PokerCardValueTest {


    @Test
    public void testSucessfulStringRepresentationParsingTwo() {
        PokerCardValue value = PokerCardValue.fromStringRepresentation("2");
        Assert.assertEquals(PokerCardValue.TWO, value);
    }

    @Test
    public void testSucessfulStringRepresentationParsingThree() {
        PokerCardValue value = PokerCardValue.fromStringRepresentation("3");
        Assert.assertEquals(PokerCardValue.THREE, value);
    }

    @Test
    public void testSucessfulStringRepresentationParsingFour() {
        PokerCardValue value = PokerCardValue.fromStringRepresentation("4");
        Assert.assertEquals(PokerCardValue.FOUR, value);
    }

    @Test
    public void testSucessfulStringRepresentationParsingFive() {
        PokerCardValue value = PokerCardValue.fromStringRepresentation("5");
        Assert.assertEquals(PokerCardValue.FIVE, value);
    }

    @Test
    public void testSucessfulStringRepresentationParsingSix() {
        PokerCardValue value = PokerCardValue.fromStringRepresentation("6");
        Assert.assertEquals(PokerCardValue.SIX, value);
    }

    @Test
    public void testSucessfulStringRepresentationParsingSeven() {
        PokerCardValue value = PokerCardValue.fromStringRepresentation("7");
        Assert.assertEquals(PokerCardValue.SEVEN, value);
    }

    @Test
    public void testSucessfulStringRepresentationParsingEight() {
        PokerCardValue value = PokerCardValue.fromStringRepresentation("8");
        Assert.assertEquals(PokerCardValue.EIGHT, value);
    }

    @Test
    public void testSucessfulStringRepresentationParsingNine() {
        PokerCardValue value = PokerCardValue.fromStringRepresentation("9");
        Assert.assertEquals(PokerCardValue.NINE, value);
    }

    @Test
    public void testSucessfulStringRepresentationParsingTen() {
        PokerCardValue value = PokerCardValue.fromStringRepresentation("T");
        Assert.assertEquals(PokerCardValue.TEN, value);
    }

    @Test
    public void testSucessfulStringRepresentationParsingJack() {
        PokerCardValue value = PokerCardValue.fromStringRepresentation("J");
        Assert.assertEquals(PokerCardValue.JACK, value);
    }

    @Test
    public void testSucessfulStringRepresentationParsingQueen() {
        PokerCardValue value = PokerCardValue.fromStringRepresentation("Q");
        Assert.assertEquals(PokerCardValue.QUEEN, value);
    }

    @Test
    public void testSucessfulStringRepresentationParsingKing() {
        PokerCardValue value = PokerCardValue.fromStringRepresentation("K");
        Assert.assertEquals(PokerCardValue.KING, value);
    }

    @Test
    public void testSucessfulStringRepresentationParsingAce() {
        PokerCardValue value = PokerCardValue.fromStringRepresentation("A");
        Assert.assertEquals(PokerCardValue.ACE, value);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFailingToParseEmptyString() {
        PokerCardValue.fromStringRepresentation("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFailingToParseNonMatchingString() {
        PokerCardValue.fromStringRepresentation("Z");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFailingToParseTooLongString() {
        PokerCardValue.fromStringRepresentation("AA");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFailingToParseSpecialCharacterString() {
        PokerCardValue.fromStringRepresentation("\nA");
    }
}
