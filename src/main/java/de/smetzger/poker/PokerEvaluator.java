package de.smetzger.poker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import de.smetzger.poker.hand.PokerHand;

public class PokerEvaluator
{
    public static void main(String[] args) throws IOException {

        String cardsPlayerOne = null;
        String cardsPlayerTwo = null;
        PokerHand handPlayerOne = null;
        PokerHand handPlayerTwo = null;
        PokerHandEvaluator handEvaluator = new SimplePokerHandEvaluator();


        System.out
        .println("In the following, please enter the hands for both players each as a single line with cards separated by space.");
        System.out.println("Example: C3 D2 DK DA C4");

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println("Please enter the hand of player one now:");
            cardsPlayerOne = br.readLine();
            handPlayerOne = PokerHand.fromStringRepresentation(cardsPlayerOne);

            System.out.println("Please enter the hand of player two now:");
            cardsPlayerTwo = br.readLine();
            handPlayerTwo = PokerHand.fromStringRepresentation(cardsPlayerTwo);
        }

        int result = handEvaluator.compareHands(handPlayerOne, handPlayerTwo);
        if (result > 0) {
            System.out.println("Player one wins this round");
        }
        if (result < 0) {
            System.out.println("Player two wins this round");
        }
        if (result == 0) {
            System.out.println("This round is undecided");
        }
    }

}
