
package exercise1;

import java.util.Random;
import java.util.Scanner;

//
// @authour John Mazer Oct 5, 2026
//
public class CardTrick {

    public static void main(String[] args) {

        Card[] hand = new Card[7];
        Random random = new Random();

        // 1. Populate the hand with 7 random cards
        for (int i = 0; i < hand.length; i++) {
            Card card = new Card();
            card.setValue(random.nextInt(13) + 1); // Random value from 1 to 13
            card.setSuit(Card.SUITS[random.nextInt(4)]); // Random suit index 0 to 3
            hand[i] = card;
        }

        // 2. Prompt the user to pick a card ("any card")
        Scanner scanner = new Scanner(System.in);

        System.out.println("Pick a card, any card!");
        System.out.print("Enter card value (1 to 13, where 1=Ace, 11=Jack, 12=Queen, 13=King): ");
        int userValue = scanner.nextInt();

        System.out.println("Choose suit:");
        System.out.println("1: Hearts");
        System.out.println("2: Diamonds");
        System.out.println("3: Spades");
        System.out.println("4: Clubs");
        System.out.print("Enter suit number (1 to 4): ");
        int suitChoice = scanner.nextInt();

        // Create the user's card object
        Card userCard = new Card();
        userCard.setValue(userValue);
        userCard.setSuit(Card.SUITS[suitChoice - 1]); // Convert 1-4 menu choice to array index 0-3

        // 3. Search the hand array for a matching card
        boolean found = false;
        for (Card card : hand) {
            if (card.getValue() == userCard.getValue() &&
                card.getSuit().equalsIgnoreCase(userCard.getSuit())) {
                found = true;
                break;
            }
        }

        // 4. Report result and invoke printInfo() if found
        if (found) {
            printInfo();
        } else {
            System.out.println("\nSorry! Your card (" + userCard.getValue() + " of " + userCard.getSuit() + ") was not in the hand.");
        }

        scanner.close();
    }

    private static void printInfo() {

        System.out.println("Congratulations, you guessed right!");
        System.out.println();

        System.out.println("My name is John!");
        System.out.println();

        System.out.println("My career ambitions:");
        System.out.println("-- Try to build a good foundation of programming knowledge.");
        System.out.println("-- Find ways to help implement good work ethic into my life.");
        System.out.println();

        System.out.println("My hobbies:");
        System.out.println("-- Artistry");
        System.out.println("-- Cooking");
        System.out.println("-- Guild Wars 2");
        System.out.println("-- Playing bass guitar");
        System.out.println("-- Magic the Gathering");

        System.out.println();
    }
}
