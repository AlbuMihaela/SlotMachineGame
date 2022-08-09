package slotMachineGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SlotMachineGame {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Can we start the game? Yes or No .");
        String playerAnswer = scanner.nextLine();
        if (playerAnswer.equalsIgnoreCase("yes")) {
            startGame();
        } else if (playerAnswer.equalsIgnoreCase("no")) {
            System.out.println("Hope you will come back soon!");

        } else {
            System.out.println("Please enter a valid response. Yes or No.");
        }


    }

    public static void startGame() {
        double budget = 100;
        ArrayList<String> options = new ArrayList<>(Arrays.asList("Diamond", "Cherry", "Bar"));
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        while (true) {
            System.out.println("Please bet! Your budget is " + budget);
            double bet = scanner.nextDouble();
            if (bet > budget) {
                System.out.println("You don't have enough money!");
            } else {
                budget -= bet;
                System.out.println("Yeyy! Let's see");
                String result1 = options.get(random.nextInt(options.size()));
                String result2 = options.get(random.nextInt(options.size()));
                String result3 = options.get(random.nextInt(options.size()));

                printResults(result1, result2, result3);

                if (result1.equals(result2) && result2.equals(result3) && result1.equals(result3)) {
                    System.out.println("JACKPOT!!!!");
                    double moneyToAdd = (30.0 / 100.0) * bet;
                    budget += bet + moneyToAdd;
                } else if (result1.equals(result2) || result1.equals(result3) || result2.equals(result3)) {
                    System.out.println("Semi Jackpot");
                    double moneyToAdd = (90.0 / 100.0) * bet;
                    budget += moneyToAdd;
                } else {
                    System.out.println("You lost!");
                }

                if (budget <= 1) {
                    System.out.println("You lost the game");
                    break;
                } else if (budget >= 1000) {
                    System.out.println("You won the game");
                    break;
                }
            }
        }
    }

    private static void printResults(String result1, String result2, String result3) {
        System.out.println("[ " + result1 + " ] [ " + result2 + " ] [ " + result3 + " ]");
    }

}
