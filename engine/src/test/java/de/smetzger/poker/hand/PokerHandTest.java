package de.smetzger.poker.hand;

import java.util.Set;

import junit.framework.Assert;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

import org.junit.Test;

import com.google.common.collect.Sets;

public class PokerHandTest {


    @Test
    public void testSucessfulStringRepresentationParsingValidHandNumbers() {
        PokerHand hand = PokerHand.fromStringRepresentation("C5 D3 S7 C6 H8");

        PokerHand expectedPokerHand = getDefaultExpectedHand();

        Assert.assertEquals(expectedPokerHand, hand);
    }

    @Test
    public void testSucessfulStringRepresentationParsingValidHandNumbersWithVaryingWhitespaces() {
        PokerHand hand = PokerHand.fromStringRepresentation("C5 \t D3  S7 C6    H8");

        PokerHand expectedPokerHand = getDefaultExpectedHand();

        Assert.assertEquals(expectedPokerHand, hand);
    }

    private PokerHand getDefaultExpectedHand() {
        Set<PokerCard> expectedHandCards = Sets.newHashSet();
        expectedHandCards.add(new PokerCard(PokerCardSuit.CLUBS, PokerCardValue.FIVE));
        expectedHandCards.add(new PokerCard(PokerCardSuit.DIAMONDS, PokerCardValue.THREE));
        expectedHandCards.add(new PokerCard(PokerCardSuit.SPADES, PokerCardValue.SEVEN));
        expectedHandCards.add(new PokerCard(PokerCardSuit.CLUBS, PokerCardValue.SIX));
        expectedHandCards.add(new PokerCard(PokerCardSuit.HEARTS, PokerCardValue.EIGHT));
        PokerHand expectedPokerHand = new PokerHand(expectedHandCards);
        return expectedPokerHand;
    }

    @Test
    public void testSucessfulStringRepresentationParsingValidHandFaces() {
        PokerHand hand = PokerHand.fromStringRepresentation("CQ DJ SK CA HT");

        Set<PokerCard> expectedHandCards = Sets.newHashSet();
        expectedHandCards.add(new PokerCard(PokerCardSuit.CLUBS, PokerCardValue.QUEEN));
        expectedHandCards.add(new PokerCard(PokerCardSuit.DIAMONDS, PokerCardValue.JACK));
        expectedHandCards.add(new PokerCard(PokerCardSuit.SPADES, PokerCardValue.KING));
        expectedHandCards.add(new PokerCard(PokerCardSuit.CLUBS, PokerCardValue.ACE));
        expectedHandCards.add(new PokerCard(PokerCardSuit.HEARTS, PokerCardValue.TEN));
        PokerHand expectedPokerHand = new PokerHand(expectedHandCards);

        Assert.assertEquals(expectedPokerHand, hand);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFailingToParseEmptyString() {
        PokerHand.fromStringRepresentation("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFailingToParseTooManyCards() {
        PokerHand.fromStringRepresentation("CQ DJ SK CA HT C4");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFailingToParseTooFewCards() {
        PokerHand.fromStringRepresentation("CQ DJ SK CA");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFailingToParseInvalidCards() {
        PokerHand.fromStringRepresentation("CQ DJ SK CA CC");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFailingToParseInvalidlySeparatedCards() {
        PokerHand.fromStringRepresentation("CQ,DJ,SK,CA,CC");
    }


    @Test
    public void testEqualsHashCodeContract() {
        EqualsVerifier.forClass(PokerHand.class).usingGetClass().suppress(Warning.NONFINAL_FIELDS).verify();
    }
}
