/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_2;

import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author aakpi
 */
public class Project_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Welcome to Arithmetic's Exercise Program\n" + "—————————————————————-------\n" + "You have 90 seconds to answer as many questions as possible.\n"
                + "You will get 5 seconds bonus if you answer 5 questions in a row.\n"
                + "Use java arithmetic precedence rules to find answers!\n"
                + "Press 'q' to quit or any key to start…");
        int currentLevel = 1;

        String input = scn.nextLine();
        if (!input.equals("q")) {
            while (true) {
                if (currentLevel == 1) {

                    int cc = level1();
                    boolean success = checkResults(1, cc);

                    askUser(success, 1);

                    String inp = scn.nextLine();

                    if (success && inp.equals("n")) {
                        currentLevel = 2;
                    } else if (inp.equals("q")) {
                        System.out.println("GoodBye!");
                        break;
                    }
                } else {
                    int tc = level2();
                    boolean success = checkResults(2, tc);

                    askUser(success, 2);

                    String inp = scn.nextLine();
                    if (success && inp.equals("r")) {
                        currentLevel = 2;
                    } else if (inp.equals("q")) {
                        System.out.println("GoodBye!");
                        break;
                    }

                }
            }
        } else {
            System.out.println("GoodBye!");
        }
    }

    public static int produceLevel1Question(int qN) {
        Random random = new Random();
        String operands = "+-/*";
        int op = new Random().nextInt(4);
        int num1 = random.nextInt(9);
        int num2 = random.nextInt(9);
        System.out.print("Q" + Integer.toString(qN) + "\t" + Integer.toString(num1) + operands.charAt(op) + Integer.toString(num2) + " = ");
        int correct_result = 0;
        if (op == 0) {
            correct_result = num1 + num2;
        } else if (op == 1) {
            correct_result = num1 - num2;
        } else if (op == 2) {
            while (num2 == 0) {
                num2 = random.nextInt(9);
            }
            correct_result = num1 / num2;
        } else if (op == 3) {
            correct_result = num1 * num2;
        }

        return correct_result;

    }

    public static int produceLevel2Question(int qN) {
        Random random = new Random();
        String operands = "+-/*";

        int op1 = new Random().nextInt(4);
        int op2 = new Random().nextInt(4);
        int num1 = random.nextInt(9);
        int num2 = random.nextInt(9);
        int num3 = random.nextInt(9);

        System.out.print("Q" + Integer.toString(qN) + "\t" + Integer.toString(num1) + operands.charAt(op1) + Integer.toString(num2) + operands.charAt(op2) + Integer.toString(num3) + " = ");
        int correct_result = 0;

        if (op1 == 0 && op2 == 0) {
            correct_result = num1 + num2 + num3;
        } else if (op1 == 0 && op2 == 1) {
            correct_result = num1 + num2 - num3;
        } else if (op1 == 0 && op2 == 2) {
            while (num3 == 0) {
                num3 = random.nextInt(9);
            }
            correct_result = num1 + num2 / num3;
        } else if (op1 == 0 && op2 == 3) {
            correct_result = num1 + num2 * num3;
        } else if (op1 == 1 && op2 == 0) {
            correct_result = num1 - num2 + num3;
        } else if (op1 == 1 && op2 == 1) {
            correct_result = num1 - num2 - num3;
        } else if (op1 == 1 && op2 == 2) {
            while (num3 == 0) {
                num3 = random.nextInt(9);
            }
            correct_result = num1 - num2 / num3;
        } else if (op1 == 1 && op2 == 3) {
            correct_result = num1 - num2 * num3;
        } else if (op1 == 2 && op2 == 0) {
            while (num2 == 0) {
                num2 = random.nextInt(9);
            }
            correct_result = num1 / num2 + num3;
        } else if (op1 == 2 && op2 == 1) {
            while (num2 == 0) {
                num2 = random.nextInt(9);
            }
            correct_result = num1 / num2 - num3;
        } else if (op1 == 2 && op2 == 2) {
            while (num2 == 0 || num3 == 0) {
                num2 = random.nextInt(9);
                num3 = random.nextInt(9);
            }
            correct_result = num1 / num2 / num3;
        } else if (op1 == 2 && op2 == 3) {
            while (num2 == 0 || num3 == 0) {
                num2 = random.nextInt(9);
                num3 = random.nextInt(9);
            }
            correct_result = num1 / num2 * num3;
        } else if (op1 == 3 && op2 == 0) {
            correct_result = num1 * num2 + num3;
        } else if (op1 == 3 && op2 == 1) {
            correct_result = num1 * num2 - num3;
        } else if (op1 == 3 && op2 == 2) {
            while (num3 == 0) {
                num3 = random.nextInt(9);
            }
            correct_result = num1 * num2 / num3;
        } else if (op1 == 3 && op2 == 3) {
            correct_result = num1 * num2 * num3;
        }
        return correct_result;

    }

    public static boolean checkAnswer(int enteredNumber, int correctResult) {
        if (enteredNumber == correctResult) {
            System.out.println("Correct");

            return true;

        } else {
            System.out.println("Wrong");
            return false;
        }
    }

    public static boolean checkResults(int currentLevel, int correctResults) {

        if (currentLevel == 1) {
            return correctResults > 20;
        } else {
            return correctResults > 15;
        }

    }

    public static void askUser(boolean success, int currentLevel) {
        if (currentLevel == 1) {
            if (success) {
                System.out.println("You successfully completed level 1. Press 'q' to quit, 'r' to try again, n to advance the next level.");
            } else {
                System.out.println("You failed to complete level 1. \nSorry!!! You cannot advance to the next level!  \nPress 'q' to quit, 'r' to try again.");

            }
        } else if (currentLevel == 2) {
            if (success) {
                System.out.println("You successfully completed level 2. Press 'q' to quit, 'r' to try again.");
            } else {
                System.out.println("You failed to complete level 2. \nYou are as fast as a turtle!  \nPress 'q' to quit, 'r' to try again.");
            }
        }
    }

    public static int level1() {
        Scanner scn = new Scanner(System.in);
        System.out.println("Level 1 started!");
        long endTime = System.currentTimeMillis() + 90000;
        int currentStreak = 0;
        int totalCorrect = 0;
        int totalAsked = 0;
        while (System.currentTimeMillis() < endTime) {
            totalAsked++;
            int correct_result = produceLevel1Question(totalAsked);
            int entered_number = scn.nextInt();
            if (checkAnswer(entered_number, correct_result)) {

                currentStreak++;
                totalCorrect++;
            } else {
                currentStreak = 0;
            }
            if (currentStreak == 5) {
                endTime += 5000;
                currentStreak = 0;
                System.out.println("5 Streak, you earned 5 more seconds!");
            }
        }
        System.out.println("Time is up!\nCorrect Answers: " + totalCorrect + "\nTotal Questions: " + totalAsked + "\nTotal time: ");

        return totalCorrect;
    }

    public static int level2() {
        Scanner scn = new Scanner(System.in);
        System.out.println("Level 2 started!");
        long endTime = System.currentTimeMillis() + 90000;
        int currentStreak = 0;
        int totalCorrect = 0;
        int totalAsked = 0;
        while (System.currentTimeMillis() < endTime) {
            totalAsked++;
            int correct_result = produceLevel2Question(totalAsked);
            int entered_number = scn.nextInt();
            if (checkAnswer(entered_number, correct_result)) {

                currentStreak++;
                totalCorrect++;
            } else {
                currentStreak = 0;
            }
            if (currentStreak == 5) {
                endTime += 5000;
                currentStreak = 0;
                System.out.println("5 Streak, you earned 5 more seconds!");
            }
        }
        System.out.println("Time is up!\nCorrect Answers: " + totalCorrect + "\nTotal Questions: " + totalAsked);

        return totalCorrect;
    }

}
