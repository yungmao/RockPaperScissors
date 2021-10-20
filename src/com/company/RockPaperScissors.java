package com.company;

import java.util.Locale;
import java.util.Scanner;

public class RockPaperScissors {
    private static final String[] options = {"Rock", "Paper", "Scissors"};

    public static void rockPaperScissors() {
        Scanner scan = new Scanner(System.in);
        boolean stillPlay = true;
        while (stillPlay) {
            System.out.print("How many round do you want to play?(Between 1-10): ");
            int number_of_rounds = scan.nextInt();
            String foo = scan.nextLine();
            if (number_of_rounds >= 1 && number_of_rounds <= 10) {
                playRockPaperScissors(number_of_rounds);
            } else {
                System.out.println("Number outside of the range. Program will close");
                break;
            }
            System.out.println("Do you want to play?");
            System.out.print("Yes or no: ");
            String _choice = scan.nextLine();
            _choice = _choice.toLowerCase();
            if (_choice.equals("yes")) {
                stillPlay = true;
            } else if (_choice.equals("no")) {
                System.out.println("Thanks for playing!");
                stillPlay = false;
            } else {
                System.out.println("Error - wrong choice");
                break;
            }
        }
    }

    public static void playRockPaperScissors(int rounds) {
        Scanner scan = new Scanner(System.in);
        int user_wins = 0;
        int ties = 0;
        int computer_wins = 0;
        for (int i = 0; i < rounds; i++) {
            System.out.println("Possible choices:");
            System.out.println("1--Rock");
            System.out.println("2--Paper");
            System.out.println("3--Scissors");
            System.out.print("User's choice: ");
            int users_choice = scan.nextInt();
            String foo = scan.nextLine();
            if (users_choice <= 3 && users_choice >= 1) {
                System.out.println("User chose: " + options[users_choice - 1]);
            } else { //Maybe while until
                System.out.println("All you had to do is chose 1,2 or 3. Now it will be random");
                users_choice = randomChoice();
                System.out.println("And it will be.... " + options[users_choice - 1]);
            }
            int computer_choice = randomChoice();
            System.out.println("Computer chose " + options[computer_choice - 1]);
            int result = result_of_round(users_choice, computer_choice);
            switch (result) {
                case 0: {
                    ties++;
                    System.out.println("Tie");
                    break;
                }
                case 1: {
                    user_wins++;
                    System.out.println("User won");
                    break;
                }
                case 2: {
                    computer_wins++;
                    System.out.println("Computer won");
                    break;
                }
                case -1: {
                    System.out.println("Error");
                    break;
                }
            }

        }
        System.out.println("Result of the game:");
        System.out.println("User won: " + user_wins + " times");
        System.out.println("Computer won: " + computer_wins + " times");
        System.out.println("There were: " + ties + " draws");
        System.out.print("Result: ");
        if (computer_wins > user_wins) {
            System.out.println("Computer won");
        } else if (user_wins > computer_wins) {
            System.out.println("User won");
        } else {
            System.out.println("Tie");
        }
    }

    public static int randomChoice() {
        int random_choice = (int) (Math.random() * 100) % 3;
        return random_choice + 1;
    }

    /*
     * result_of_round returns:
     * 0 -- Tie
     * 1 -- User won
     * 2 -- Computer won
     * -1 -- Error
     * */
    public static int result_of_round(int players_choice, int computers_choice) {
        if (players_choice == computers_choice) {
            return 0;
        } else if (players_choice == 1) {
            if (computers_choice == 2) {
                return 2; // 2-Paper Wins over 1-Rock = Computer won
            } else if (computers_choice == 3) {
                return 1; // 1-Rock Wins over 3-Scissors = Player Won
            }
        } else if (players_choice == 2) {
            if (computers_choice == 1) {
                return 1; // 2-Paper Wins over 1-Rock = Player Won
            } else if (computers_choice == 3) {
                return 2; //3-Scissors Wins over 2-Paper = Computer won
            }
        } else if (players_choice == 3) {
            if (computers_choice == 1) {
                return 2; // 1-Rock Wins over 3-Scissors = Computer won
            } else if (computers_choice == 2) {
                return 1; //3-Scissors Wins over 2-Paper = Player Won
            }
        }
        return -1;
    }

}
