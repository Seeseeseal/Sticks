package hi;

import java.util.Scanner;

class Sticks {

    int currentPlayer;

    int startSticks = 1;

    //Player number followed by which hand
    int pOneRight;
    int pOneLeft;
    int pTwoRight;
    int pTwoLeft;

    boolean turn;

    Scanner hit = new Scanner(System.in);
    String firstMove = hit.nextLine();


    //Creates the new game
    public static void main(String[] args) {
        Sticks game = new Sticks();
        game.play();
    }


    // Game constructor/setting up the game
    public Sticks() {
        pOneRight = 1;
        pOneLeft = 1;
        pTwoRight = 1;
        pTwoLeft = 1;
        System.out.println("Player One RH" + " " + pOneRight);
        System.out.println("Player One LH" + " " + pOneLeft);
        System.out.println("Player Two RH" + " " + pTwoRight);
        System.out.println("Player Two LH" + " " + pTwoLeft);
    }


    // Is there a winner?
    public boolean isWinner(String Player) {
        //if player one has no more sticks
        if (pOneRight == 0 && pOneLeft == 0) {
            return true;
        }
        //if player two has no more sticks
        else if (pTwoRight == 0 && pTwoLeft == 0) {
            return true;
        }
        return false;
    }

    // Playing the game
    //In order to play the commands are
    // 1R for player one right hand
    // 1L for player one left hand
    // 2R for player two right hand
    //2L for player two right hand
    public void play() {
        while (!isWinner("Player 1") || !isWinner("Player Two")) {
            if (currentPlayer == 1) {
                computerTurn();
            } else {
                myTurn();
            }
        }

    }


    // Player Move
    public void myTurn() {
        currentPlayer = 1;
        System.out.println("From where would you like to hit?");
        String hitFrom = hit.nextLine();
        if (hitFrom.equals("2R") || hitFrom.equals("2L")) {
            System.out.println("Please choose a valid move");
        }
        //If player chooses to hit from right hand
        else if (hitFrom.equals("1R")) {
            System.out.println("Where would you like to hit?");
            String makeMove = hit.nextLine();
            if (makeMove.equals("1R") || makeMove.equals("1L")) {
                System.out.println("Please choose a valid move");
            } else if (pTwoLeft == 0 || pTwoRight == 0) {
                System.out.println("You can't add to an empty hand. Choose a hand that has sticks.");
                //If player hits Player Two's Left hand
            } else if (makeMove.equals("2L")) {
                pTwoLeft = pOneRight + pTwoLeft;
                if (pTwoLeft >= 5) {
                    pTwoLeft = 0;
                }
            }
            //If player hits Player Two's right hand
            if (makeMove.equals("2R")) {
                if (pTwoRight == 0) {
                    System.out.println("You can't  add to an empty hand. Choose a hand that has sticks");
                }pTwoRight = pTwoRight + pOneRight;
                if (pTwoRight >= 5) {
                    pTwoRight = 0;
                }
            }
            System.out.println("Player One RH" + " " + pOneRight);
            System.out.println("Player One LH" + " " + pOneLeft);
            System.out.println("Player Two RH" + " " + pTwoRight);
            System.out.println("Player Two LH" + " " + pTwoLeft);


            //If player chooses to play from left hand
        } else if (hitFrom.equals("1L")) {
            System.out.println("Where would you like to hit?");
            String makeMove = hit.nextLine();

            if (makeMove.equals("1R") || makeMove.equals("1L")) {
                System.out.println("Please choose a valid move");
                //If player hits Player Two's Left hand
            } else if (makeMove.equals("2L")) {
                if (pTwoLeft == 0) {
                    System.out.println("You can't add to an empty hand. Choose a hand that has sticks.");
                }
                pTwoLeft = pOneLeft + pTwoLeft;
                if (pTwoLeft >= 5) {
                    pTwoLeft = 0;
                }
                //If player hits Player Two's right hand
            } else if (makeMove.equals("2R")) {
                if (pTwoRight == 0) {
                    System.out.println("You can't add to an empty hand. Choose a hand that has sticks.");
                }
                pTwoRight = pTwoRight + pOneLeft;
                if (pTwoRight >= 5) {
                    pTwoRight = 0;
                }
            }
            System.out.println("Player One RH" + " " + pOneRight);
            System.out.println("Player One LH" + " " + pOneLeft);
            System.out.println("Player Two RH" + " " + pTwoRight);
            System.out.println("Player Two LH" + " " + pTwoLeft);
        } else {
            System.out.println("Please make an actual move.");
        }
    }

    // AI Move
    public void computerTurn() {
        currentPlayer = 2;
        if (pTwoLeft >= pOneLeft) {
            pOneLeft = pTwoLeft + pOneLeft;
            if (pOneLeft >= 5) {
                pOneLeft = 0;
            }
            System.out.println("The opponent added 2L to 1L");
            System.out.println("Player One RH" + " " + pOneRight);
            System.out.println("Player One LH" + " " + pOneLeft);
            System.out.println("Player Two RH" + " " + pTwoRight);
            System.out.println("Player Two LH" + " " + pTwoLeft);
        } else if (pTwoLeft >= pOneRight) {
            pOneRight = pOneRight + pTwoLeft;
            if (pOneLeft >= 5) {
                pOneLeft = 0;
            }
            System.out.println("The opponent added 2L to 1R");
            System.out.println("Player One RH" + " " + pOneRight);
            System.out.println("Player One LH" + " " + pOneLeft);
            System.out.println("Player Two RH" + " " + pTwoRight);
            System.out.println("Player Two LH" + " " + pTwoLeft);
        } else if (pTwoRight >= pOneLeft) {
            pOneLeft = pTwoRight + pOneLeft;
            if (pOneLeft >= 5) {
                pOneLeft = 0;
            }
            System.out.println("The opponent added 2R to 1L");
            System.out.println("Player One RH" + " " + pOneRight);
            System.out.println("Player One LH" + " " + pOneLeft);
            System.out.println("Player Two RH" + " " + pTwoRight);
            System.out.println("Player Two LH" + " " + pTwoLeft);
        } else if (pTwoRight >= pOneRight) {
            pOneRight = pOneRight + pTwoRight;
            if (pOneLeft >= 5) {
                pOneLeft = 0;
            }
            System.out.println("The opponent added 2R to 1R");
            System.out.println("Player One RH" + " " + pOneRight);
            System.out.println("Player One LH" + " " + pOneLeft);
            System.out.println("Player Two RH" + " " + pTwoRight);
            System.out.println("Player Two LH" + " " + pTwoLeft);
        }

    }


    //If there is a winner, then return who the winner is.
    public String getWinner() {
        if (isWinner("Player 1")) {
            return "Player 1 wins";
        }
        return "Player 2 wins";
    }
}
