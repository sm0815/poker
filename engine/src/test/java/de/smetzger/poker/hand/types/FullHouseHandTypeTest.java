package de.smetzger.poker.hand.types;

import junit.framework.Assert;

import org.junit.Test;

import de.smetzger.poker.hand.PokerCardValue;
import de.smetzger.poker.hand.PokerHand;

public class FullHouseHandTypeTest {

    @Test
    public void testRankByTripletValue() {
        PokerHand aHand = PokerHand.fromStringRepresentation("C5 D5 H5 S2 S2");
        PokerHand anotherHand = PokerHand.fromStringRepresentation("C4 S4 D4 HA SA");
        PokerHandType aTypeMatch = new FullHouseHandType(aHand, PokerCardValue.FIVE);
        PokerHandType anotherTypeMatch = new FullHouseHandType(anotherHand, PokerCardValue.FOUR);
        Assert.assertTrue(aTypeMatch.compareTo(anotherTypeMatch) > 0);
    }

    @Test
    public void testRankEqualIfTripletValueIsEqual() {
        PokerHand aHand = PokerHand.fromStringRepresentation("C4 D4 H4 S2 S2");
        PokerHand anotherHand = PokerHand.fromStringRepresentation("C4 S4 D4 HA SA");
        PokerHandType aTypeMatch = new FullHouseHandType(aHand, PokerCardValue.FOUR);
        PokerHandType anotherTypeMatch = new FullHouseHandType(anotherHand, PokerCardValue.FOUR);
        Assert.assertTrue(aTypeMatch.compareTo(anotherTypeMatch) == 0);
    }
}
