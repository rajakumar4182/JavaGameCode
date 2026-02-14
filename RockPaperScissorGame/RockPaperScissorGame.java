import java.util.Scanner;
import java.util.Random;

public class RockPaperScissorGame {

    public static void main(String[] args) {

        int userWin = 0, computerWin = 0;
        System.out.println("Game starts....");

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        for (int i = 0; i < 5; i++) {

            System.out.println((i + 1) + " round");
            System.out.println("Enter 0 for rock, 1 for paper or 2 for scissor");

            int userInput = sc.nextInt();

            // Input validation
            if (userInput < 0 || userInput > 2) {
                System.out.println("Invalid input! Only select 0 (Rock), 1 (Paper), or 2 (Scissor).");
                System.out.println("This round is invalid. Please try again.");
                System.out.println();
                i--; // repeat same round
                continue;
            }

            System.out.println("User input is " + userInput);

            int computerInput = random.nextInt(3);
            System.out.println("Computer input is " + computerInput);

            if (userInput == computerInput) {
                System.out.println("Draw");
            } else if ((userInput == 0 && computerInput == 2) ||
                    (userInput == 1 && computerInput == 0) ||
                    (userInput == 2 && computerInput == 1)) {

                System.out.println("You win this round");
                userWin++;
            } else {
                System.out.println("Computer wins this round");
                computerWin++;
            }

            System.out.println("-----End of " + (i + 1) + " round------");
            System.out.println();
        }

        if (userWin > computerWin)
            System.out.println("Finally You win");
        else
            System.out.println("Computer wins");

        System.out.println("-------Game End-----");

        sc.close();
    }
}
