package de.smetzger.poker.hand.types;

import de.smetzger.poker.hand.PokerCardValue;
import de.smetzger.poker.hand.PokerHand;

public class FullHouseHandType extends BaseHandType {
    private final PokerCardValue tripletValue;
    private final PokerCardValue pairValue;

    public FullHouseHandType(PokerHand pokerHand, PokerCardValue tripletValue, PokerCardValue pairValue) {
        super(pokerHand, PokerHandTypeIdentifier.FULL_HOUSE);
        this.tripletValue = tripletValue;
        this.pairValue = pairValue;
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

        // current specification indicates the triplet value is the only one of importance,
        // if on equal triplet value the pair value should be compared, this would do it
        // int pairValueComparison = pairValue.compareTo(otherType.pairValue);
        // if (pairValueComparison != 0) {
        // return pairValueComparison;
        // }

        return 0;
    }
}
