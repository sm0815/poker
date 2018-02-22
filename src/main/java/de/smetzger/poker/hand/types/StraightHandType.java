package de.smetzger.poker.hand.types;

import java.util.stream.Collectors;

import de.smetzger.poker.hand.PokerCard;
import de.smetzger.poker.hand.PokerHand;

public class StraightHandType extends BaseHandType {

    public StraightHandType(PokerHand hand) {
        super(hand, PokerHandTypeIdentifier.STRAIGHT);
    }

    @Override
    public int compareTo(PokerHandType o) {
        if (getPokerHandTypeIdentifier() != o.getPokerHandTypeIdentifier()) {
            return super.compareTo(o);
        }
        if (!(o instanceof StraightHandType)) {
            throw new RuntimeException("Poker hand types " + this + " and " + o
                    + " break the assumption that same PokerHandTypeIdentifier means same class");
        }

        return compareCardValuesForHighestDifferingValue(getPokerHand().getHand().stream().map(PokerCard::getValue)
                .collect(Collectors.toList()),
                o.getPokerHand().getHand().stream().map(PokerCard::getValue)
                .collect(Collectors.toList()));
    }

}
