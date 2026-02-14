package GuessTheNumber;

import java.util.Scanner;
import java.util.Random;

class GuessTheNumber {
    private int userNumber;
    private int noOfGuess;
    private int computerInput;

    // constructor
    GuessTheNumber() {
        Random random = new Random();
        computerInput = random.nextInt(101);
    }

    public void takeUserNumber(Scanner sc) {

        System.out.println(" Please guess the number from 0 to 100. Enter the number ");

        // System.out.println("Enter the number ");
        userNumber = sc.nextInt();
        // noOfGuess++;
        setNumberOfGuesses(getNumberOfGuesses() + 1);
    }

    public boolean isCorrectNumber() {
        if (userNumber == computerInput) {
            System.out.println("Wow! you guessed it right");
            return true;
        } else if (userNumber > computerInput) {
            System.out.println("Your guess number is greater. Try smaller");
        } else {
            System.out.println("your guess number is lower. Try larger");
        }
        return false;
    }

    public int getNumberOfGuesses() {
        return noOfGuess;
    }

    public void setNumberOfGuesses(int numberofGuess) {
        noOfGuess = numberofGuess;
    }

}

public class GuessTheNumberGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        GuessTheNumber g = new GuessTheNumber();

        boolean hasWon = false;

        while (!hasWon) {
            g.takeUserNumber(sc);
            hasWon = g.isCorrectNumber();
        }

        sc.close();

        System.out.println("Number of guess taken is :- " + g.getNumberOfGuesses());

    }

}
