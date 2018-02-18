package de.smetzger.poker;

public class PokerCard {
    private final PokerCardSuit suit;
    private final PokerCardValue value;

    public PokerCard(PokerCardSuit suit, PokerCardValue value) {
        this.suit = suit;
        this.value = value;
    }

    public PokerCardSuit getSuit() {
        return suit;
    }

    public PokerCardValue getValue() {
        return value;
    }

    /**
     * Converts a string representation of a card into the representative PokerCard object.
     * Assumes a two character representation, e.g. 'C4' for the Clubs card with value 4.
     * @param cardRepresentation
     *            the two character string representation, e.g. 'C4'
     * @return the PokerCard object representing the same card as the string representation
     */
    public static PokerCard fromStringRepresentation(String cardRepresentation) {
        if (cardRepresentation.length() != 2) {
            throw new IllegalArgumentException("Card representation has invalid length of "
                    + cardRepresentation.length() + ":" + cardRepresentation);
        }
        PokerCardSuit suit = PokerCardSuit.fromStringRepresentation(cardRepresentation.substring(0, 1));
        PokerCardValue value = PokerCardValue.fromStringRepresentation(cardRepresentation.substring(1, 2));
        return new PokerCard(suit, value);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((suit == null) ? 0 : suit.hashCode());
        result = prime * result + ((value == null) ? 0 : value.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PokerCard other = (PokerCard) obj;
        if (suit != other.suit)
            return false;
        if (value != other.value)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "PokerCard [suit=" + suit + ", value=" + value + "]";
    }

}
