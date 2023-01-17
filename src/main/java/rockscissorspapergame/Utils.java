package rockscissorspapergame;

import java.util.Random;
import java.util.Scanner;

public class Utils {

    protected static String userChoice(){
        Scanner in = new Scanner(System.in);
        return in.next();
    }

    protected static String javaChoice(){
        Random rand = new Random();
        String[] arr = {"Rock", "Scissors", "Paper"};
        return arr[rand.nextInt(3)];
    }

    protected static boolean winner(String user, String java){
        return (user.equalsIgnoreCase("Rock") && java.equalsIgnoreCase("Scissors")) ||
                (user.equalsIgnoreCase("Paper") && java.equalsIgnoreCase("Rock")) ||
                (user.equalsIgnoreCase("Scissors") && java.equalsIgnoreCase("Paper"));
    }

    protected static void game(){
        int userWinCounter = 0;
        int javaWinCounter = 0;
        do {
            System.out.println("Enter Rock, Scissors or Paper to Play!");
            String user = userChoice();
            String java = javaChoice();
            if (user.equalsIgnoreCase(java)){
                System.out.println("You Picked: " + user);
                System.out.println("I Picked: " + java);
                System.out.println("Looks like its a Tie! Lets Try Again!\nYour Point is: " + userWinCounter + "\n" +
                        "My Point is: " + javaWinCounter);
            }
            else if (winner(user, java)){
                userWinCounter++;
                System.out.println("You Picked: " + user);
                System.out.println("I Picked: " + java);
                System.out.println("You won the round!\nYour Point is: " + userWinCounter + "\n" +
                        "My Point is: " + javaWinCounter);
            }else {
                javaWinCounter++;
                System.out.println("You Picked: " + user);
                System.out.println("I Picked: " + java);
                System.out.println("I won the round!\nYour Point is: " + userWinCounter + "\n" +
                        "My Point is: " + javaWinCounter);
            }
            if (userWinCounter == 3){
                System.out.println("Congrats! You Have Won the Game");
            } else if (javaWinCounter == 3) {
                System.out.println("Loser! You Have Been Defeated! ");
            }
        }while (userWinCounter<3 && javaWinCounter<3);

    }
}
