package de.smetzger.poker.hand.types;

import java.util.List;

import de.smetzger.poker.hand.PokerCardValue;
import de.smetzger.poker.hand.PokerHand;

public class DoublePairHandType extends BaseHandType {
    private final List<PokerCardValue> pairValues;
    private final PokerCardValue singleCardValue;

    public DoublePairHandType(PokerHand pokerHand, List<PokerCardValue> pairValues, PokerCardValue singleCardValue) {
        super(pokerHand, PokerHandTypeIdentifier.TWO_PAIRS);
        this.pairValues = pairValues;
        this.singleCardValue = singleCardValue;
    }

    @Override
    public int compareTo(PokerHandType o) {
        if (getPokerHandTypeIdentifier() != o.getPokerHandTypeIdentifier()) {
            return super.compareTo(o);
        }
        if (!(o instanceof DoublePairHandType)) {
            throw new RuntimeException("Poker hand types " + this + " and " + o
                    + " break the assumption that same PokerHandTypeIdentifier means same class");
        }

        DoublePairHandType otherType = (DoublePairHandType) o;

        int pairValueComparison = compareCardValuesForHighestDifferingValue(pairValues, otherType.pairValues);
        if (pairValueComparison != 0) {
            return pairValueComparison;
        }

        return singleCardValue.compareTo(otherType.singleCardValue);
    }
}
