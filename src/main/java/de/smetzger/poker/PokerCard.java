package de.smetzger.poker;

public class PokerCard {
    private PokerCardSuit suit;
    private PokerCardValue value;

    public PokerCard(PokerCardSuit suit, PokerCardValue value){
        this.suit=suit;
        this.value=value;
    }

    public PokerCardSuit getSuit() {
        return suit;
    }
    public void setSuit(PokerCardSuit suit) {
        this.suit = suit;
    }
    public PokerCardValue getValue() {
        return value;
    }

    public void setValue(PokerCardValue value) {
        this.value = value;
    }

    /**
     * Converts a string representation of a card into the representative PokerCard object.
     * Assumes a two character representation, e.g. 'C4' for the Clubs card with value 4.
     * @param cardRepresentation	the two character string representation, e.g. 'C4'
     * @return	the PokerCard object representing the same card as the string representation
     */
    public static PokerCard fromStringRepresentation(String cardRepresentation) {
        PokerCardSuit suit=PokerCardSuit.fromStringRepresentation(cardRepresentation.substring(0, 1));
        PokerCardValue value=PokerCardValue.fromStringRepresentation(cardRepresentation.substring(1, 2));
        return new PokerCard(suit,value);
    }
}
