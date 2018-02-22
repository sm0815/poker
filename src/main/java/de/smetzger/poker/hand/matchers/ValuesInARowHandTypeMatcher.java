package de.smetzger.poker.hand.matchers;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.google.common.collect.Lists;

import de.smetzger.poker.hand.PokerCard;
import de.smetzger.poker.hand.PokerCardSuit;
import de.smetzger.poker.hand.PokerCardValue;
import de.smetzger.poker.hand.PokerHand;
import de.smetzger.poker.hand.types.FlushHandType;
import de.smetzger.poker.hand.types.PokerHandType;
import de.smetzger.poker.hand.types.StraightFlushHandType;
import de.smetzger.poker.hand.types.StraightHandType;

/** identifies all hand types that have consecutive values or values of the same suit */
public class ValuesInARowHandTypeMatcher implements PokerHandTypeMatcher {

    @Override
    public PokerHandType match(PokerHand pokerHand) {

        boolean fiveValuesInARow=areFiveValuesInARow(pokerHand);
        boolean fiveValuesSameSuit=haveFiveValuesSameSuit(pokerHand);

        if(fiveValuesInARow&&fiveValuesSameSuit){
            return new StraightFlushHandType(pokerHand);
        }
        if(fiveValuesInARow){
            return new StraightHandType(pokerHand);
        }
        if(fiveValuesSameSuit){
            return new FlushHandType(pokerHand);
        }
        return null;
    }

    private boolean haveFiveValuesSameSuit(PokerHand pokerHand) {
        Set<PokerCardSuit> suits = pokerHand.getHand().stream().map(PokerCard::getSuit).collect(Collectors.toSet());
        return suits.size() == 1;
    }

    private boolean areFiveValuesInARow(PokerHand pokerHand) {
        List<PokerCard> cards = Lists.newArrayList(pokerHand.getHand());
        Collections.sort(cards);

        PokerCardValue lastSeenValue = null;
        for (PokerCard card : cards) {
            if (lastSeenValue != null && !card.getValue().equals(lastSeenValue.next())) {
                return false;
            }
            lastSeenValue = card.getValue();
        }
        return true;
    }

}
