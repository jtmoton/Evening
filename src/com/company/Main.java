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
                currentPoints = runGame1(currentPoints, userInput, keyboard);
            } else if
            (userInput.equals("2")) {
                currentPoints = runGame2(currentPoints, userInput, keyboard);
            } else if
            (userInput.equals("3")) {
                returnScore(currentPoints);
            } else if
            (userInput.equals("4")) {
                currentPoints = startOver(userInput, keyboard, currentPoints);
            } else if
            (userInput.equals("-1")) {
                System.out.println("Goodbye! Come again soon!");
            } else
                System.out.println("Uh oh! Choose again from the list of valid options!");
        }
    }


    //This method is used to capture and return the user's menu choice.
    public static String getMenuChoice(Scanner keyboard, String userInput) {
        System.out.println("Enter 1 to play game 1: Slot Machine" + "\n" +
                "Enter 2 to play game 2: Dice Toss" + "\n" + "Enter 3 to see your total score"
                + "\n" + "Enter 4 to restart Jolly Jackpot Land" + "\n" +
                "Enter -1 to exit Jolly Jackpot Land! Come back soon!");
        return keyboard.next();

    }

    //This method will display game 1: Slot Machine.
    public static int game1(Scanner keyboard, String userInput, int currentPoints) {
        Scanner userChoice = new Scanner(System.in);
        int pointsRisked = 0;

        System.out.println("Welcome to the Slot Machine!");
        System.out.println("You must enter the amount of points you want to risk. You can't bet more than you have!" +
                "The computer will randomly generate 3 words." + "\n" + "If none of the words match each other, " +
                "you will lose the points you risked, sorry! If two of the words match, you will " +
                "win double the amount you risked! " + "\n" + "And if all three words match, you will win triple the amount you risked!");
        System.out.println();

        //while (pointsRisked != -1 && !userInput.equals("-1")) {

            System.out.println("You have " + currentPoints + " points. How many points would you like to risk?");
            pointsRisked = keyboard.nextInt();
            if (pointsRisked > currentPoints) {
                System.out.println("You don't have that many points! Enter a number less than what you have!");
            } else {
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
                currentPoints = whatLevel(currentPoints);
                //System.out.println("Press 0 to PLAY AGAIN! Press 9 to EXIT!");
                //userInput = keyboard.next();

                //runGame1(currentPoints, userInput, keyboard);

                /*while(!userInput.equals("9")) {

                    if (userInput.equals("0")) {
                        currentPoints = game1(keyboard, userInput, currentPoints);
                    } else if (userInput.equals("9")) {
                        getMenuChoice(keyboard, userInput);
                    }
                }*/
                currentPoints = whatLevel(currentPoints);
                userInput = gameOverInput(userInput);
            }
        //}
        return currentPoints;
    }

    //This method will generate a random number.
    public static String pickWord(int randNum) {
        String[] possibleValues = {"Elephant", "Computer", "Crimson", "Football", "Resume", "Capstone"};
        return possibleValues[randNum];
    }

    public static int randomNumber() {
        int randomIndex = (int) (Math.random() * 6);
        return randomIndex;
    }

    public static int game2(Scanner keyboard, int currentPoints, String userChoice) {

        String userInput = "";
        int pointsRisked = 0;
        System.out.println("Welcome to the Dice Toss! ");
        System.out.println("Enter the amount you want to risk. You can't bet more than you have! For the Dice Toss, you have two options: " +
                "Range or Amount. ");
        System.out.println("Amount Rules: You will choose high or low. If you choose high, and the dice value is " +
                " between 9 and 12, you double your risk amount. " + "\n" +
                " If the dice value is not between 9 and 12, you " +
                " lose your risk amount." + "\n" + "If you choose low, and the dice value is between 2 and 5, you double your risk amount!" +
                " If the dice value is not between 2 and 5, you lose your risk amount.");
        System.out.println("");
        System.out.println("Range Rules: You will pick an amount between 2 and 12. If the number you choose matches the dice value, you triple your risk amount! " +
                "\n" + "If it does not match exactly, you lose your risk amount.");


        //while (!userInput.equals("-1")) {

            System.out.println("Press 1 to play RANGE or Press 2 to play AMOUNT.");

            userInput = keyboard.next();

            if (userInput.equals("1")) {
                if (userInput.equals("1")) {
                    System.out.println("You have " + currentPoints + " points. How many points would you like to risk?");
                    currentPoints = whatLevel(currentPoints);
                    pointsRisked = keyboard.nextInt();

                    if (pointsRisked > currentPoints) {
                        System.out.println("You don't have that many points! Enter a number less than what you have!");
                    } else {
                        Scanner keyboard2 = new Scanner(System.in);

                        System.out.println("Input 5 for high or 6 for low to see if you hit!");
                        String whichGame = keyboard2.nextLine();

                        int rollTotal = rollDice1() + rollDice2();

                        if (whichGame.equals("5")) {
                            if (rollTotal >= 9 && rollTotal <= 12) {
                                currentPoints = (pointsRisked * 2) + currentPoints;
                                System.out.print("The two dice gave you... " + rollTotal + "!" + "\n");
                                System.out.println("You hit! You now have " + currentPoints + " points!");
                            } else {
                                System.out.print("The two dice gave you... " + rollTotal + "!" + "\n");
                                System.out.println("Aw man! You didn't hit!");
                                currentPoints = currentPoints - pointsRisked;
                                System.out.println("You now have " + currentPoints + " points.");
                            }
                        }
                        if (whichGame.equals("6")) {
                            if (rollTotal >= 2 && rollTotal <= 5) {
                                currentPoints = (pointsRisked * 2) + currentPoints;
                                System.out.print("The two dice gave you... " + rollTotal + "!" + "\n");
                                System.out.println("You hit! You now have " + currentPoints + " points!");
                            } else {
                                System.out.print("The two dice gave you... " + rollTotal + "!" + "\n");
                                System.out.println("Aw man! You didn't hit!");
                                currentPoints = currentPoints - pointsRisked;
                                System.out.println("You now have " + currentPoints + " points.");
                            }
                        }
                    }
                    currentPoints = whatLevel(currentPoints);
                    //System.out.println("Press 0 to PLAY AGAIN! Press 9 to EXIT!");
                    //userInput = keyboard.next();

                    currentPoints = whatLevel(currentPoints);
                    userInput = gameOverInput(userInput);
                }
                /*while (!userInput.equals("9")) {
                    if (userInput.equals("0")) {
                        currentPoints = game2(keyboard, currentPoints, userInput);
                    } else if (userInput.equals("9")) {
                        getMenuChoice(keyboard, userInput);
                    }
                }*/
            } else if (userInput.equals("2")) {
                System.out.println("You have " + currentPoints + " points. How many points would you like to risk?");
                currentPoints = whatLevel(currentPoints);
                pointsRisked = keyboard.nextInt();

                if (pointsRisked > currentPoints) {
                    System.out.println("You don't have that many points! Enter a number less than what you have!");
                }

                System.out.println("What do you think the roll will be?");
                int rollGuess = keyboard.nextInt();

                int rollTotal = rollDice1() + rollDice2();


                if (rollTotal == rollGuess) {
                    currentPoints = (pointsRisked * 3) + currentPoints;
                    System.out.print("The two dice gave you... " + rollTotal + "!" + "\n");
                    System.out.println("You hit! You now have " + currentPoints + " points!");

                } else {
                    System.out.print("The two dice gave you... " + rollTotal + "!" + "\n");
                    System.out.println("Aw man! You didn't hit!");
                    currentPoints = currentPoints - pointsRisked;
                    System.out.println("You now have " + currentPoints + " points.");
                }
                currentPoints = whatLevel(currentPoints);
                //System.out.println("Press 0 to PLAY AGAIN! Press 9 to EXIT!");
                //userInput = keyboard.next();

                /*while (!userInput.equals("9")) {

                    if (userInput.equals("0")) {
                        currentPoints = game2(keyboard, currentPoints, userInput);
                    } else if (userInput.equals("9")) {
                        getMenuChoice(keyboard, userInput);
                    }
                }*/
            }


        return currentPoints;
    }

    public static int rollDice1() {
        int dice = (int) (Math.random() * 6) + 1;
        System.out.println("Die 1: " + dice);
        return dice;
    }

    public static int rollDice2() {
        int dice = (int) (Math.random() * 6) + 1;
        System.out.println("Die 2: " + dice);
        return dice;

    }

    public static void returnScore(int currentPoints) {
        System.out.println(currentPoints);
    }

    public static int startOver(String userInput, Scanner keyboard, int currentPoints) {
        while (currentPoints != 500) {
            currentPoints = 500;
            System.out.println("RESTART: You're resetting to " + currentPoints + " points.");
        }
        return currentPoints;
    }

    public static String gameOverInput(String userInput) {
        userInput = "-1";
        return userInput;
    }

    public static int whatLevel(int currentPoints) {
        if (currentPoints <= 0) {
            System.out.println("Yikes! You hit rock bottom.");
            currentPoints = 500;
            System.out.println("You're reset to 500 points! Try again...");
        } else if (currentPoints >= 2000) {
            System.out.println("CONGRATS on reaching 2000 points! You're a star!");
            currentPoints = 500;
            System.out.println("You'll be reset to 500 points so you can play again!");
        }
        return currentPoints;
    }

    public static int runGame1(int currentPoints, String userInput, Scanner keyboard) {
        userInput = "0";

        while (userInput.equals("0")) {
            currentPoints = game1(keyboard, userInput, currentPoints);
            System.out.println("Press 0 to PLAY AGAIN or 9 to EXIT!");
            userInput = keyboard.next();
        }
            return currentPoints;
    }

    public static int runGame2(int currentPoints, String userInput, Scanner keyboard) {
        userInput = "0";

        while (userInput.equals("0")) {
            currentPoints = game2(keyboard, currentPoints, userInput);
            System.out.println("Press 0 to PLAY AGAIN or 9 to EXIT!");
            userInput = keyboard.next();
        }
        return currentPoints;
    }
}


