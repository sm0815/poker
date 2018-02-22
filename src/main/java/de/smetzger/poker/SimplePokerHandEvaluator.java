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
    public int compareHands(PokerHand oneHand, PokerHand anotherHand) {
        PokerHandType firstHandMatch = getBestMatch(applyMatchers(oneHand));
        PokerHandType secondHandMatch = getBestMatch(applyMatchers(anotherHand));

        return firstHandMatch.compareTo(secondHandMatch);
    }

    Stream<PokerHandType> applyMatchers(PokerHand pokerHand) {
        return matchers.parallelStream().map(matcher -> matcher.match(pokerHand)).filter(Objects::nonNull);
    }

    PokerHandType getBestMatch(Stream<PokerHandType> matches) {
        Optional<PokerHandType> bestMatch = matches.max((matchA, matchB) -> matchA.compareTo(matchB));
        if (bestMatch.isPresent()) {
            return bestMatch.get();
        }
        LOGGER.error("No match found in {}", matches.toArray());
        return null;
    }

}
