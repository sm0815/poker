package de.smetzger.poker;

import junit.framework.Assert;
import nl.jqno.equalsverifier.EqualsVerifier;

import org.junit.Test;

public class PokerCardTest {


    @Test
    public void testSucessfulStringRepresentationParsingValidCardC5() {
        PokerCard card = PokerCard.fromStringRepresentation("C5");
        Assert.assertEquals(PokerCardSuit.CLUBS, card.getSuit());
        Assert.assertEquals(PokerCardValue.FIVE, card.getValue());
    }

    @Test
    public void testSucessfulStringRepresentationParsingValidCardHA() {
        PokerCard card = PokerCard.fromStringRepresentation("HA");
        Assert.assertEquals(PokerCardSuit.HEARTS, card.getSuit());
        Assert.assertEquals(PokerCardValue.ACE, card.getValue());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFailingToParseEmptyString() {
        PokerCard.fromStringRepresentation("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFailingToParseTotallyNonMatchingString() {
        PokerCard.fromStringRepresentation("ZC");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFailingToParsePartiallyNonMatchingString() {
        PokerCard.fromStringRepresentation("CC");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFailingToParseInvertedNonMatchingString() {
        PokerCard.fromStringRepresentation("5C");
    }


    @Test(expected = IllegalArgumentException.class)
    public void testFailingToParseSpecialCharacterString() {
        PokerCard.fromStringRepresentation("\nC5");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFailingToParseTooLongString() {
        PokerCard.fromStringRepresentation("C5C5");
    }

    @Test
    public void testEqualsHashCodeContract() {
        EqualsVerifier.forClass(PokerCard.class).usingGetClass().verify();
    }
}
