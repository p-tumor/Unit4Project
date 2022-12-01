import java.awt.*;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Scanner;
import javax.swing.*;

import static java.lang.System.exit;

public class Connect4Runner {
    public static void main(String[] args) {
        boolean notValid;

        Scanner n = new Scanner(System.in);

        System.out.println("Player 1 input your desired name: ");
        String name1 = n.nextLine();
        System.out.println("Player 2 input your desired name: ");
        String name2 = n.nextLine();
        //System.out.println("Would you like to do a challenge?");


        Connect4 newGame = new Connect4(name1, name2);
        boolean gameOver = newGame.gameOver();
        System.out.println(gameOver);

        System.out.println(newGame.displayGameBoard());

        while (gameOver == false) {
            notValid = true;

            //player 1 turn
            while (notValid) {
                System.out.printf("%s choose a column: ", newGame.getPLAYER_1_NAME());
                String colTemp = n.nextLine();
                if (newGame.userInputValidation(colTemp) == -1) {
                    System.out.println(newGame.userInputValidationRandomQuotes());
                } else {
                    byte colTemp2 = Byte.parseByte(colTemp);
                    newGame.setColumn(colTemp2);
                    if (!newGame.fullColumnCheck(newGame.getColumn())) {
                        notValid = false;
                    } else {
                        System.out.println(newGame.fullColumnCheckRandomQuotes());
                    }
                }
            }

            newGame.player1Turn();
            System.out.println(newGame.displayGameBoard());

            newGame.setRow((byte)5);
            newGame.setColumn((byte)0);
            notValid = true;

            //player 2 turn
            while (notValid) {
                System.out.printf("%s choose a column: ", newGame.getPLAYER_2_NAME());
                String colTemp = n.nextLine();
                if (newGame.userInputValidation(colTemp) == -1) {
                    System.out.println(newGame.userInputValidationRandomQuotes());
                } else {
                    byte colTemp2 = Byte.parseByte(colTemp);
                    newGame.setColumn(colTemp2);
                    if (!newGame.fullColumnCheck(newGame.getColumn())) {
                        notValid = false;
                    } else {
                        System.out.println(newGame.fullColumnCheckRandomQuotes());
                    }
                }
            }

            newGame.playerTwoTurn();
            System.out.println(newGame.displayGameBoard());

        }
        if (newGame.isItATie()){
            System.out.println("Both are you losers are losers.");
        }else{
            System.out.println(newGame.congratulate());

        }
        exit(0);
    }
}


