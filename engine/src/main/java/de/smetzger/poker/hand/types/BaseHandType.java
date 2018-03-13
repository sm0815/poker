package de.smetzger.poker.hand.types;

import java.util.Collection;
import java.util.List;

import com.google.common.collect.Lists;

import de.smetzger.poker.hand.PokerCardValue;
import de.smetzger.poker.hand.PokerHand;

public class BaseHandType implements PokerHandType {

    private final PokerHandTypeIdentifier typeIdentifier;
    private PokerHand pokerHand;

    BaseHandType(PokerHand pokerHand, PokerHandTypeIdentifier typeIdentifier) {
        this.pokerHand = pokerHand;
        this.typeIdentifier = typeIdentifier;
    }

    @Override
    public PokerHand getPokerHand() {
        return pokerHand;
    }

    @Override
    public PokerHandTypeIdentifier getPokerHandTypeIdentifier() {
        return typeIdentifier;
    }

    @Override
    public int compareTo(PokerHandType o) {
        return typeIdentifier.compareTo(o.getPokerHandTypeIdentifier());
    }

    /**
     * compares two collections of PokerCardValues by comparing the highest value, if that is equal, the second-highest
     * etc.
     *
     * @return If all values are equal 0 is returned. Starting with the highest value in each collection going through a
     *         pairwise comparison, if a value of the first collection is higher than that of the second
     *         collection, -1 is returned. Otherwise 1.
     *
     *         (7,4,6), (4,8,1) -> 1
     */
    protected int compareCardValuesForHighestDifferingValue(Collection<PokerCardValue> handOneValues,
            Collection<PokerCardValue> handTwoValues) {
        List<PokerCardValue> sortedListOne = Lists.newArrayList(handOneValues);
        sortedListOne.sort((a, b) -> b.compareTo(a));

        List<PokerCardValue> sortedListTwo = Lists.newArrayList(handTwoValues);
        sortedListTwo.sort((a, b) -> b.compareTo(a));

        for (int i = 0; i < sortedListOne.size(); i++) {
            int valueComparison = sortedListOne.get(i).compareTo(sortedListTwo.get(i));
            if (valueComparison != 0) {
                return valueComparison;
            }
        }
        return 0;
    }



}
