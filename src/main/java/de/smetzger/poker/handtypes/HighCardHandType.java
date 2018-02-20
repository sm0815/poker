package de.smetzger.poker.handtypes;

import java.util.stream.Collectors;

import de.smetzger.poker.PokerCard;
import de.smetzger.poker.PokerHand;

public class HighCardHandType extends BaseHandType {

    HighCardHandType(PokerHand hand) {
        super(hand, PokerHandTypeIdentifier.HIGH_CARD);
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

        return compareCardValuesForHighestDifferingValue(getPokerHand().getHand().stream().map(PokerCard::getValue)
                .collect(Collectors.toList()),
                o.getPokerHand().getHand().stream().map(PokerCard::getValue)
                .collect(Collectors.toList()));
    }

}
