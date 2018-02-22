package de.smetzger.poker.hand.types;

import de.smetzger.poker.hand.PokerCardValue;
import de.smetzger.poker.hand.PokerHand;

public class FullHouseHandType extends BaseHandType {
    private final PokerCardValue tripletValue;


    public FullHouseHandType(PokerHand pokerHand, PokerCardValue tripletValue) {
        super(pokerHand, PokerHandTypeIdentifier.FULL_HOUSE);
        this.tripletValue = tripletValue;
    }

    @Override
    public int compareTo(PokerHandType o) {
        if (getPokerHandTypeIdentifier() != o.getPokerHandTypeIdentifier()) {
            return super.compareTo(o);
        }
        if (!(o instanceof FullHouseHandType)) {
            throw new RuntimeException("Poker hand types " + this + " and " + o
                    + " break the assumption that same PokerHandTypeIdentifier means same class");
        }

        FullHouseHandType otherType = (FullHouseHandType) o;

        int tripletValueComparison = tripletValue.compareTo(otherType.tripletValue);
        if (tripletValueComparison != 0) {
            return tripletValueComparison;
        }

        return 0;
    }
}
