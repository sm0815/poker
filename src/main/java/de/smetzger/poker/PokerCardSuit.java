package de.smetzger.poker;


public enum PokerCardSuit {
    CLUBS("C"), DIAMONDS("D"), HEARTS("H"), SPADES("S");

    private String stringRepresentation;

    PokerCardSuit(String stringRepresentation) {
        this.stringRepresentation = stringRepresentation;
    }


    /**
     * Converts a string representation of a suit into the representative PokerCardSuit enum.
     * Assumes the given string to match one associated with any PokerCardSuit enum.
     * Any string that does not match a defined enum is considered invalid.
     * @param cardRepresentation	the string representation, e.g. 'C'
     * @return	the PokerCardSuit enum representing the same suit as the string representation
     */
    public static PokerCardSuit fromStringRepresentation(String stringRepresentation){

        for (PokerCardSuit suit : values()) {
            if(suit.stringRepresentation.equals(stringRepresentation)){
                return suit;
            }
        }
        throw new IllegalArgumentException("String Representation '"+stringRepresentation+
                "' does not match a valid PokerCardSuit");
    }
}
