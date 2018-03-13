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

        switch (cardsByValue.size()) {
        case 5:
            // no duplicate values, this matcher has nothing to find
            return null;
        case 4:
            return handlePairHandType(pokerHand, cardsByValue);
        case 3:
            // three groups is either a double pair and a single value or a triplet and two single values
            return handleThreeOfAKindOrDoublePair(pokerHand, cardsByValue);

        case 2:
            // if we have only two groups it could be a full house or four and a single value
            return handleFourOfAKindOrFullHouse(pokerHand, cardsByValue);

        default:
            LOGGER.error("Unexpected number of different values ({}) on hand {}:{}", cardsByValue.size(), pokerHand,
                    cardsByValue);
            throw new IllegalStateException(
                    "There should always be 1 to 5 cardsByValue groups, now there are " + cardsByValue.size());
        }

    }

    private PokerHandType handleFourOfAKindOrFullHouse(PokerHand pokerHand,
            Map<PokerCardValue, Set<PokerCard>> cardsByValue) {
        Set<PokerCard> cardSetWithMaxSize = cardsByValue.values().stream()
                .max((cardsetA, cardsetB) -> Integer.compare(cardsetA.size(), cardsetB.size())).get();
        if (cardSetWithMaxSize.size() == 4) {
            return handleFourOfAKind(pokerHand, cardSetWithMaxSize);
        }

        return handleFullHouse(pokerHand, cardsByValue);
    }

    private PokerHandType handleThreeOfAKindOrDoublePair(PokerHand pokerHand,
            Map<PokerCardValue, Set<PokerCard>> cardsByValue) {
        Set<PokerCard> cardSetWithMaxSize = cardsByValue.values().stream()
                .max((cardsetA, cardsetB) -> Integer.compare(cardsetA.size(), cardsetB.size())).get();
        if (cardSetWithMaxSize.size() == 3) {
            return handleThreeOfAKind(pokerHand, cardSetWithMaxSize);
        }
        return handleDoublePair(pokerHand, cardsByValue);
    }

    private PokerHandType handleFullHouse(PokerHand pokerHand, Map<PokerCardValue, Set<PokerCard>> cardsByValue) {
        PokerCardValue tripletValue = findXOfAKindValue(cardsByValue, 3);
        return new FullHouseHandType(pokerHand, tripletValue);
    }

    private PokerHandType handleFourOfAKind(PokerHand pokerHand, Set<PokerCard> cardSetWithMaxSize) {
        PokerCardValue quartetValue = cardSetWithMaxSize.iterator().next().getValue();
        return new FourOfAKindHandType(pokerHand, quartetValue);
    }

    private PokerHandType handleDoublePair(PokerHand pokerHand, Map<PokerCardValue, Set<PokerCard>> cardsByValue) {
        List<PokerCardValue> pairValues = cardsByValue.entrySet().stream().filter(entry -> entry.getValue().size() == 2)
                .map(entry -> entry.getKey()).collect(Collectors.toList());
        PokerCardValue singleCardValue = findXOfAKindValue(cardsByValue, 1);

        return new DoublePairHandType(pokerHand, pairValues, singleCardValue);
    }

    private PokerHandType handleThreeOfAKind(PokerHand pokerHand, Set<PokerCard> cardSetWithMaxSize) {
        PokerCardValue tripletValue = cardSetWithMaxSize.iterator().next().getValue();
        return new ThreeOfAKindHandType(pokerHand, tripletValue);
    }

    private PokerHandType handlePairHandType(PokerHand pokerHand, Map<PokerCardValue, Set<PokerCard>> cardsByValue) {
        // if there are four groups of values, one value has to be duplicated
        PokerCardValue pairvalue = findXOfAKindValue(cardsByValue, 2);
        return new PairHandType(pokerHand, pairvalue);
    }

    private PokerCardValue findXOfAKindValue(Map<PokerCardValue, Set<PokerCard>> cardsByValue,
            int amountOfCardsWithSharedValue) {
        return cardsByValue.entrySet().stream().filter(entry -> entry.getValue().size() == amountOfCardsWithSharedValue)
                .findAny().get().getKey();
    }

}
