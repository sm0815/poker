package de.smetzger.poker.hand.types;

import java.util.stream.Collectors;

import de.smetzger.poker.hand.PokerCard;
import de.smetzger.poker.hand.PokerCardValue;
import de.smetzger.poker.hand.PokerHand;

public class SingleXOfAKindHandType extends BaseHandType {
    private final PokerCardValue xOfAKindCardValue;

    SingleXOfAKindHandType(PokerHand pokerHand, PokerCardValue pairvalue, PokerHandTypeIdentifier typeIdentifier) {
        super(pokerHand, typeIdentifier);
        this.xOfAKindCardValue = pairvalue;
    }

    @Override
    public int compareTo(PokerHandType o) {
        if (getPokerHandTypeIdentifier() != o.getPokerHandTypeIdentifier()) {
            return super.compareTo(o);
        }
        if (!(o instanceof SingleXOfAKindHandType)) {
            throw new RuntimeException("Poker hand types " + this + " and " + o
                    + " break the assumption that same PokerHandTypeIdentifier means same class");
        }

        SingleXOfAKindHandType otherType = (SingleXOfAKindHandType) o;

        int xOfAKindValueComparison = xOfAKindCardValue.compareTo(otherType.xOfAKindCardValue);
        if (xOfAKindValueComparison != 0) {
            return xOfAKindValueComparison;
        }

        // compare the remaining values
        return compareCardValuesForHighestDifferingValue(getPokerHand().getHand().stream().map(PokerCard::getValue)
                .filter(value -> !value.equals(xOfAKindCardValue)).collect(Collectors.toList()),
                otherType.getPokerHand().getHand().stream().map(PokerCard::getValue)
                        .filter(value -> !value.equals(otherType.xOfAKindCardValue))
                .collect(Collectors.toList()));
    }

}
