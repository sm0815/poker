package de.smetzger.poker.hand.matchers;

import junit.framework.Assert;

import org.junit.Test;

import de.smetzger.poker.hand.PokerHand;
import de.smetzger.poker.hand.matchers.HighCardHandTypeMatcher;
import de.smetzger.poker.hand.types.PokerHandType;
import de.smetzger.poker.hand.types.PokerHandType.PokerHandTypeIdentifier;

public class HighCardHandTypeMatcherTest {

    HighCardHandTypeMatcher matcher = new HighCardHandTypeMatcher();


    @Test
    public void testMatchARandomCardHand() {
        PokerHand aHand = PokerHand.fromStringRepresentation("C5 D2 H3 H4 S2");
        PokerHandType match = matcher.match(aHand);
        Assert.assertEquals(PokerHandTypeIdentifier.HIGH_CARD, match.getPokerHandTypeIdentifier());
        Assert.assertEquals(aHand, match.getPokerHand());
    }
}
