package de.smetzger.poker.backend;

import de.smetzger.poker.hand.types.PokerHandType.PokerHandTypeIdentifier;

public class ResultDTO {
    String winner;
    PokerHandTypeIdentifier handType;

    public ResultDTO() {
    }

    public ResultDTO(String winner, PokerHandTypeIdentifier typeIdentifier) {
        this.winner = winner;
        this.handType = typeIdentifier;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public PokerHandTypeIdentifier getHandType() {
        return handType;
    }

    public void setHandType(PokerHandTypeIdentifier handType) {
        this.handType = handType;
    }

}
