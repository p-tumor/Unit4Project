import java.awt.*;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.*;

import static java.lang.System.exit;

public class Connect4Runner {
    public static void main(String[] args) {

        boolean gameOver = false;
        boolean notValid;

        Scanner n = new Scanner(System.in);

        System.out.println("Player 1 input your desired name: ");
        String n1 = n.nextLine();
        System.out.println("Player 2 input your desired name: ");
        String n2 = n.nextLine();
        //System.out.println("Would you like to do a challenge?");


        Connect4plus1 p = new Connect4plus1(n1, n2);

        System.out.println(p.displayGrid());
        while (gameOver == false || p.tie) {
            notValid = true;

            //player 1 turn
            while (notValid) {
                System.out.printf("%s choose a column: ", p.getP1());
                String colTemp = n.nextLine();
                if (p.userVal(colTemp) == -1) {
                    System.out.println(p.userValRan());
                } else {
                    p.setCol(p.userVal(colTemp));
                    if (!p.userValColFull(p.getCol())) {
                        notValid = false;
                    } else {
                        System.out.println(p.userVCFR());
                    }
                }
            }

            p.playerOneTurn();
            System.out.println(p.getP1Turn());
            System.out.println(p.displayGrid());

            //game over check
            gameOver = p.gameOver();
            if (gameOver) break;

            p.setRow(5);
            p.setCol(0);
            notValid = true;

            //player 2 turn
            while (notValid) {
                System.out.printf("%s choose a column: ", p.getP1());
                String colTemp = n.nextLine();
                if (p.userVal(colTemp) == -1) {
                    System.out.println(p.userValRan());
                } else {
                    p.setCol(p.userVal(colTemp));
                    if (!p.userValColFull(p.getCol())) {
                        notValid = false;
                    } else {
                        System.out.println(p.userVCFR());
                    }
                }
            }

            p.playerTwoTurn();
            System.out.println(p.getP1Turn());
            System.out.println(p.displayGrid());


            //game over check
            gameOver = p.gameOver();
            if (gameOver) break;
        }

        System.out.println(p.congratulate());
        exit(0);
    }
}


