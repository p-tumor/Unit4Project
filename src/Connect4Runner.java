import java.awt.*;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.*;

public class Connect4Runner {
    public static void main(String[] args) {
        new Connect4Frame();

        /*boolean gameOver = false;
        int row = 5;
        int col = 0;
        boolean pOneTurn = true;
        boolean notValid = true;

        Scanner n = new Scanner(System.in);

        System.out.println("Player 1 input your desired name: ");
        String n1 = n.nextLine();
        System.out.println("Player 2 input your desired name: ");
        String n2 = n.nextLine();

        Connect4plus1 p = new Connect4plus1(n1,n2);

        System.out.println(p.displayGrid());
        while (gameOver == false){
            row = 5;
            col = 0;
            pOneTurn = true;
            notValid = true;

            //player 1 turn
            while (notValid == true){
                System.out.printf("%s choose a column: ", p.getP1());
                String colTemp = n.nextLine();
                if (p.userVal(colTemp) == -1){
                    System.out.println(p.userValRan());
                }else {
                    col = p.userVal(colTemp);
                    if (!p.userValColFull(col)){
                        notValid = false;
                    }else{
                        System.out.println(p.userVCFR());
                    }
                }
            }

            p.columnCheck(row,col,pOneTurn);
            System.out.println(p.displayGrid());

            //game over check
            gameOver = p.gameOver(col);
            if (gameOver) break;

            row = 5;
            col = 0;
            pOneTurn = false;
            notValid = true;

            //player 2 turn
            while (notValid){
                System.out.printf("%s choose a column: ", p.getP2());
                String colTemp = n.nextLine();
                if (p.userVal(colTemp) == -1){
                    System.out.println(p.userValRan());
                }else {
                    col = p.userVal(colTemp);
                    if (!p.userValColFull(col)){
                        notValid = false;
                    }else{
                        System.out.println(p.userVCFR());
                    }
                }
            }

            p.columnCheck(row,col,pOneTurn);
            System.out.println(p.displayGrid());

            //game over check
            gameOver = p.gameOver(col);
            if (gameOver) break;
        }

        System.out.println(p.congratulate(pOneTurn));
    }*/
    }


    /*public static void clear() {
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessB1uilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {}
    }*/
    }
