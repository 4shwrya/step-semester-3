 import java.util.Random;

public class RockPaperScissor {

    public static void main(String[] args) {

        String[] player = {"Rock", "Paper", "Scissors", "Rock", "Paper"};
        String[] moves = {"Rock", "Paper", "Scissors"};

        Random r = new Random();

        int wins = 0, losses = 0, draws = 0;

        for (int i = 0; i < 5; i++) {

            String computer = moves[r.nextInt(3)];

            System.out.println("Round " + (i + 1));
            System.out.println("Player: " + player[i]);
            System.out.println("Computer: " + computer);

            if (player[i].equals(computer)) {
                System.out.println("Draw\n");
                draws++;
            }
            else if ((player[i].equals("Rock") && computer.equals("Scissors")) ||
                    (player[i].equals("Paper") && computer.equals("Rock")) ||
                    (player[i].equals("Scissors") && computer.equals("Paper"))) {
                System.out.println("Player Wins\n");
                wins++;
            }
            else {
                System.out.println("Computer Wins\n");
                losses++;
            }
        }

        System.out.println("Wins = " + wins);
        System.out.println("Losses = " + losses);
        System.out.println("Draws = " + draws);
    }
}


