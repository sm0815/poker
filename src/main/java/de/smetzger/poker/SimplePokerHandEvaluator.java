package de.smetzger.poker;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Lists;

import de.smetzger.poker.hand.PokerHand;
import de.smetzger.poker.hand.matchers.HighCardHandTypeMatcher;
import de.smetzger.poker.hand.matchers.PokerHandTypeMatcher;
import de.smetzger.poker.hand.matchers.SameValueHandTypeMatcher;
import de.smetzger.poker.hand.matchers.ValuesInARowHandTypeMatcher;
import de.smetzger.poker.hand.types.PokerHandType;

public class SimplePokerHandEvaluator implements PokerHandEvaluator {

    private static final Logger LOGGER = LoggerFactory.getLogger(SimplePokerHandEvaluator.class);

    List<PokerHandTypeMatcher> matchers = Lists.newArrayList(new HighCardHandTypeMatcher(),
            new SameValueHandTypeMatcher(), new ValuesInARowHandTypeMatcher());

    @Override
    public PokerHandType compareHands(PokerHand oneHand, PokerHand anotherHand) {
        PokerHandType firstHandMatch = getBestPokerHandType(applyMatchers(oneHand));
        PokerHandType secondHandMatch = getBestPokerHandType(applyMatchers(anotherHand));

        int comparison = firstHandMatch.compareTo(secondHandMatch);
        if (comparison > 0) {
            return firstHandMatch;
        }
        if (comparison < 0) {
            return secondHandMatch;
        }
        return null;
    }

    Stream<PokerHandType> applyMatchers(PokerHand pokerHand) {
        return matchers.parallelStream().map(matcher -> matcher.match(pokerHand)).filter(Objects::nonNull);
    }


    PokerHandType getBestPokerHandType(Stream<PokerHandType> types) {
        Optional<PokerHandType> bestHandType = types.max((typeA, typeB) -> typeA.compareTo(typeB));
        if (bestHandType.isPresent()) {
            return bestHandType.get();
        }
        LOGGER.error("No match found in {}", types.toArray());
        return null;
    }

}
