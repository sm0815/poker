package de.smetzger.poker.hand.matchers;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.smetzger.poker.hand.PokerCard;
import de.smetzger.poker.hand.PokerCardValue;
import de.smetzger.poker.hand.PokerHand;
import de.smetzger.poker.hand.types.DoublePairHandType;
import de.smetzger.poker.hand.types.FourOfAKindHandType;
import de.smetzger.poker.hand.types.FullHouseHandType;
import de.smetzger.poker.hand.types.PairHandType;
import de.smetzger.poker.hand.types.PokerHandType;
import de.smetzger.poker.hand.types.ThreeOfAKindHandType;

/** identifies all hand types that have the same value multiple times */
public class SameValueHandTypeMatcher implements PokerHandTypeMatcher {
    private static final Logger LOGGER = LoggerFactory.getLogger(SameValueHandTypeMatcher.class);

    @Override
    public PokerHandType match(PokerHand pokerHand) {

        Map<PokerCardValue, Set<PokerCard>> cardsByValue = pokerHand.getHand().stream()
                .collect(Collectors.groupingBy(PokerCard::getValue, Collectors.toSet()));

        if(cardsByValue.size()==5){
            return null;
        }

        //TODO: move generations into HandType classes

        if(cardsByValue.size()==4){
            PokerCardValue pairvalue=findXOfAKindValue(cardsByValue,2);
            return new PairHandType(pokerHand, pairvalue);
        }

        if(cardsByValue.size()==2){
            Set<PokerCard> cardSetWithMaxSize = cardsByValue.values().stream()
                    .max((cardsetA, cardsetB) -> Integer.compare(cardsetA.size(), cardsetB.size())).get();
            if (cardSetWithMaxSize.size() == 4) {
                PokerCardValue quartetValue = cardSetWithMaxSize.iterator().next().getValue();
                return new FourOfAKindHandType(pokerHand, quartetValue);
            }

            PokerCardValue tripletValue=findXOfAKindValue(cardsByValue,3);
            PokerCardValue pairValue=findXOfAKindValue(cardsByValue,2);
            return new FullHouseHandType(pokerHand, tripletValue, pairValue);
        }



        if(cardsByValue.size()==3){
            Set<PokerCard> cardSetWithMaxSize = cardsByValue.values().stream()
                    .max((cardsetA, cardsetB) -> Integer.compare(cardsetA.size(), cardsetB.size())).get();
            if (cardSetWithMaxSize.size() == 3) {
                PokerCardValue tripletValue = cardSetWithMaxSize.iterator().next().getValue();
                return new ThreeOfAKindHandType(pokerHand, tripletValue);
            }
            List<PokerCardValue> pairValues= cardsByValue.entrySet().stream()
                    .filter(entry -> entry.getValue().size() == 2).map(entry -> entry.getKey())
                    .collect(Collectors.toList());
            PokerCardValue singleCardValue = findXOfAKindValue(cardsByValue, 1);

            return new DoublePairHandType(pokerHand, pairValues, singleCardValue);
        }
        LOGGER.error("Unexpected number of different values ({}) on hand {}:{}", cardsByValue.size(), pokerHand,
                cardsByValue);
        return null;
    }

    private PokerCardValue findXOfAKindValue(Map<PokerCardValue, Set<PokerCard>> cardsByValue,
            int amountOfCardsWithSharedValue) {
        return cardsByValue.entrySet().stream()
                .filter(entry -> entry.getValue().size() == amountOfCardsWithSharedValue).findAny().get().getKey();
    }

}