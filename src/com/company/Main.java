package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Spring 2019 PA3
        Scanner keyboard = new Scanner(System.in);
        String userInput = "";
        int currentPoints = 500;
        System.out.println("Welcome to Jolly Jackpot Land! There are 2 games to choose from for lots of fun!");
        System.out.println("");

        while (userInput != "-1") {
            userInput = getMenuChoice(keyboard, userInput);
            int randNum = 0;
            randomNumber();
            pickWord(randNum);

            if (userInput.equals("1")) {
                currentPoints = game1(keyboard, userInput, currentPoints);
            } else if
            (userInput.equals("2")) {
                currentPoints = game2(keyboard, currentPoints);
            } else if
            (userInput == "3") {
                returnScore();
            } else if
            (userInput == "4") {
                startOver();
            } else if
            (userInput == "-1") {
                System.out.println("Goodbye! Come again soon!");
            } else
                System.out.println("Uh oh! Choose again from the list of valid options!");
        }
    }


        //This method is used to capture and return the user's menu choice.
        public static String getMenuChoice (Scanner keyboard, String userInput){
            System.out.println("Enter 1 to play game 1: Slot Machine" + "\n" +
                    "Enter 2 to play game 2: Dice Toss" + "\n" + "Enter 3 to see your total score"
                    + "\n" + "Enter 4 to restart Jolly Jackpot Land" + "\n" +
                    "Enter -1 to exit Jolly Jackpot Land! Come back soon!");
            return keyboard.next();

        }

        //This method will display game 1: Slot Machine.
        public static int game1 (Scanner keyboard, String userInput, int currentPoints) {
            Scanner userChoice = new Scanner(System.in);

            int pointsRisked = 0;

            System.out.println("Welcome to the Slot Machine!");
            System.out.println("You have " + currentPoints + " points. " + "You must enter the amount of points you want to risk. " +
                        "The computer will randomly generate 3 words." + "\n" + "If none of the words match each other, " +
                        "you will lose the points you risked, sorry! If two of the words match, you will " +
                        "win double the amount you risked! " + "\n" + "And if all three words match, you will win triple the amount you risked!");
            System.out.println();

            while (pointsRisked != -1 && !userInput.equals("-1")) {

                System.out.println("How many points would you like to risk?");

                pointsRisked = keyboard.nextInt();

                String word1 = pickWord(randomNumber());
                String word2 = pickWord(randomNumber());
                String word3 = pickWord(randomNumber());

                System.out.println(word1 + " " + word2 + " " + word3);

                if
                (word1 == word2 && word2 == word3) {
                    System.out.println("3 matches! Jackpot!");
                    currentPoints = (pointsRisked * 3) + currentPoints;

                    System.out.println("You now have " + currentPoints + " points.");

                } else if
                (word1 != word2 && word1 != word3 && word2 != word3) {
                    System.out.println("Sorry! No matches!");
                    currentPoints = currentPoints - pointsRisked;

                    System.out.println("You now have " + currentPoints + " points.");

                } else {
                    System.out.println("Congrats! You got 2 matches!");
                    currentPoints = (pointsRisked * 2) + currentPoints;

                    System.out.println("You now have " + currentPoints + " points.");

                }
                System.out.println("Press -1 to EXIT! Press any other key to play again");

                userInput = userChoice.next();
                }
                return currentPoints;
            }

        //This method will generate a random number.
        public static String pickWord (int randNum){
            String[] possibleValues = {"Elephant", "Computer", "Crimson", "Football", "Resume", "Capstone"};
            return possibleValues[randNum];
        }

        public static int randomNumber () {
            int randomIndex = (int) (Math.random() * 6);
            return randomIndex;
        }

        public static int game2 (Scanner keyboard, int currentPoints){
            String userInput = "";
            int roll1 = 0;
            int roll2 = 0;
            int pointsRisked = 0;
            System.out.println("Welcome to the Dice Toss! ");
            System.out.println("You have " + currentPoints + " points.");
            System.out.println("Enter the amount you want to risk. For the Dice Toss, you have two options: " +
                    "Range or Amount. ");
            System.out.println("Amount Rules: You will choose 'high' or 'low'. If you choose 'high', and the dice value is " +
                    " between 9 and 12, you double your risk amount. " + "\n" +
                    " If the dice value is not between 9 and 12, you " +
                    " lose your risk amount." + "\n" + "If you choose 'low', and the dice value is between 2 and 5, you double your risk amount!" +
                    " If the dice value is not between 2 and 5, you lose your risk amount.");
            System.out.println("");
            System.out.println("Range Rules: You will pick an amount between 2 and 12. If the number you choose matches the dice value, you triple your risk amount! " +
                    "\n" + "If it does not match exactly, you lose your risk amount.");

            System.out.println("Press 1 to play RANGE or Press 2 to play AMOUNT.");

            userInput = keyboard.next();

            while (!userInput.equals("-1")) {

                if (userInput.equals("1")) {
                    System.out.println("How many points would you like to risk?");

                    pointsRisked = keyboard.nextInt();

                   /* roll1 = rollDice1();
                    roll2 = rollDice2();
                    int rollTotal = roll1 + roll2;*/

                    System.out.println("Enter 'high' or 'low' to see if you hit!");
                    Scanner keyboard2 = new Scanner(System.in);
                    String whichGame = keyboard2.next();

                   if(whichGame.equals("high")) {
                       roll1 = rollDice1();
                       roll2 = rollDice2();
                       int rollTotal = roll1 + roll2;
                        if (rollTotal >= 9 && rollTotal <= 12) {

                            currentPoints = (pointsRisked * 2) + currentPoints;
                            System.out.print("The two dice gave you... " + rollTotal + "!" + "\n");
                            System.out.println("You hit! You now have " + currentPoints + " points!");

                        } else if (whichGame.equals("low")){
                        if (rollTotal >= 2 && rollTotal <= 5) {
                                currentPoints = (pointsRisked * 2) + currentPoints;
                                System.out.println("You hit! You now have " + currentPoints + " points!");
                            System.out.print("The two dice gave you... " + rollTotal + "!" + "\n");

                        } else {
                            System.out.println("Aw man! You didn't hit!");
                            currentPoints = currentPoints - pointsRisked;
                            System.out.println("You now have " + currentPoints + " points!");

                            }
                        }
                    }
                } else if
                (userInput.equals("2")) {
                    roll1 = rollDice1();
                    roll2 = rollDice2();
                    int rollTotal = roll1 + roll2;
                    System.out.println(rollTotal);
                } else
                    System.out.println("Not a valid game choice!");

                System.out.println("Press 1 to play RANGE or Press 2 to play AMOUNT. -1 to GO BACK to menu.");
                userInput = keyboard.next();
            }
            return currentPoints;
        }

    public static int rollDice1() {
        int dice = (int) (Math.random() * 6) + 1;
        System.out.println("Die 1: " + dice);
        return dice;
    }

        public static int rollDice2 () {
            int dice = (int) (Math.random() * 6) + 1;
            System.out.println("Die 2: " + dice);
            return dice;

        }


    /*public static int amountGame() {
        int points = 0;
        return points;
    }



    public static int rangeGame() {
        int points = 0;
        return points;
    }*/

    public static int returnScore() {
        int score = 0;
        return score;
    }

    public static void startOver() {

    }
}