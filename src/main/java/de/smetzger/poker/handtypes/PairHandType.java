package de.smetzger.poker.handtypes;

import java.util.stream.Collectors;

import de.smetzger.poker.PokerCard;
import de.smetzger.poker.PokerCardValue;
import de.smetzger.poker.PokerHand;

public class PairHandType extends BaseHandType {
    private final PokerCardValue pairValue;

    PairHandType(PokerHand pokerHand, PokerCardValue pairvalue, PokerHandTypeIdentifier typeIdentifier) {
        super(pokerHand, PokerHandTypeIdentifier.PAIR);
        this.pairValue = pairvalue;
    }

    public PokerCardValue getPairValue() {
        return pairValue;
    }

    @Override
    public int compareTo(PokerHandType o) {
        if (getPokerHandTypeIdentifier() != o.getPokerHandTypeIdentifier()) {
            return super.compareTo(o);
        }
        if (!(o instanceof HighCardHandType)) {
            throw new RuntimeException("Poker hand types " + this + " and " + o
                    + " break the assumption that same PokerHandTypeIdentifier means same class");
        }

        PairHandType otherType = (PairHandType) o;

        int pairvalueComparison = pairValue.compareTo(otherType.getPairValue());
        if (pairvalueComparison != 0) {
            return pairvalueComparison;
        }

        // TODO: limit to the non-pair values
        return compareCardValuesForHighestDifferingValue(getPokerHand().getHand().stream().map(PokerCard::getValue)
                .collect(Collectors.toList()),
                o.getPokerHand().getHand().stream().map(PokerCard::getValue)
                .collect(Collectors.toList()));

    }

}
