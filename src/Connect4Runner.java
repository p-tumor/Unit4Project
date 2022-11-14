import java.awt.*;
import java.util.Scanner;
import javax.swing.*;

public class Connect4Runner {
    public static void main(String[] args) {
        new Connect4Frame();





        //frame.getContentPane().setBackground(new Color(128,0,128));






        Scanner n = new Scanner(System.in);

        System.out.println("Player 1 input your desired name: ");
        String n1 = n.nextLine();
        System.out.println("Player 2 input your desired name: ");
        String n2 = n.nextLine();

        Connect4plus1 p = new Connect4plus1(n1,n2);

        p.game();

    }
}
