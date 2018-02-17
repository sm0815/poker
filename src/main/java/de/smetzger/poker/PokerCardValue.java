package de.smetzger.poker;

public enum PokerCardValue implements Comparable<PokerCardValue> {
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5"),
    SIX("6"),
    SEVEN("7"),
    EIGHT("8"),
    NINE("9"),
    TEN("T"),
    JACK("J"),
    QUEEN("Q"),
    KING("K"),
    ACE("A");

    private String stringRepresentation;

    PokerCardValue(String stringRepresentation) {
        this.stringRepresentation = stringRepresentation;
    }

    /**
     * Converts a string representation of a suit into the representative PokerCardSuit enum.
     * Assumes the given string to match one associated with any PokerCardSuit enum.
     * Any string that does not match a defined enum is considered invalid.
     * @param cardRepresentation
     *            the string representation, e.g. 'C'
     * @return the PokerCardSuit enum representing the same suit as the string representation
     */
    // TODO: dedicated exception / validity handling?
    public static PokerCardValue fromStringRepresentation(String stringRepresentation) {
        for (PokerCardValue value : values()) {
            if (value.stringRepresentation.equals(stringRepresentation)) {
                return value;
            }
        }
        throw new IllegalArgumentException("String Representation '" + stringRepresentation
                + "' does not match a valid PokerCardValue");
    }
}
