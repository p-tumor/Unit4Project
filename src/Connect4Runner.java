import java.awt.*;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.*;

public class Connect4Runner {
    public static void main(String[] args) {
        new Connect4Frame();
        boolean gameOver = false;




        //frame.getContentPane().setBackground(new Color(128,0,128));






        Scanner n = new Scanner(System.in);

        System.out.println("Player 1 input your desired name: ");
        String n1 = n.nextLine();
        System.out.println("Player 2 input your desired name: ");
        String n2 = n.nextLine();

        Connect4plus1 p = new Connect4plus1(n1,n2);

        p.displayGrid();

        while (gameOver = false){
            int row = 5;
            int col;
            boolean pOneTurn = true;
            boolean notValid = true;

            while (notValid){
                System.out.printf("%s choose a column: ", p.getP1());
                String colTemp = n.nextLine();
                if (p.userVal(colTemp) == -1){
                    System.out.println(p.userValRan());
                }else {
                    col = p.userVal(colTemp);
                    notValid = false;
                }
            }

            cl
        }

    }

    /*public static void clear() {
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {}
    }*/
}
