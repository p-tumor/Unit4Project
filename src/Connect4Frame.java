import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import static java.lang.System.exit;

public class Connect4Frame extends JFrame implements ActionListener {
    private JButton button;
    private Connect4plus1 game;
    private JLabel labelGrid;
    public Connect4Frame(){
        game = new Connect4plus1();
        JFrame frame = new JFrame();
        ImageIcon image = new ImageIcon("C4LogoOrig.png");
        JLabel label = new JLabel("Start Game");
        label = new JLabel();
        labelGrid = new JLabel();
        button = new JButton();

        button.setBounds(200,100,250,100);
        button.addActionListener(this);
        button.setText("Start Game");
        button.setFocusable(false);
        button.setFont(new Font("Comfortaa",Font.PLAIN,12));
        frame.add(button);

        labelGrid.setText(game.displayGrid());
        labelGrid.setBounds(500,100,500,500);
        frame.add(labelGrid);

        label.setIcon(image);
        label.setFont(new Font("Comfortaa",Font.PLAIN,12));
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.TOP);
        label.setHorizontalAlignment(JLabel.LEFT);
        frame.add(label);


        frame.setTitle("Connect4+1");
        frame.setIconImage(image.getImage());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1280,720);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        boolean gameOver = false;
        int row = 5;
        int col = 0;
        boolean notValid = true;

        Scanner n = new Scanner(System.in);

        System.out.println("Player 1 input your desired name: ");
        String n1 = n.nextLine();
        System.out.println("Player 2 input your desired name: ");
        String n2 = n.nextLine();

        Connect4plus1 p = new Connect4plus1(n1, n2);

        System.out.println(p.displayGrid());
        while (gameOver == false) {
            row = 5;
            col = 0;
            notValid = true;

            //player 1 turn
            while (notValid == true) {
                System.out.printf("%s choose a column: ", p.getP1());
                String colTemp = n.nextLine();
                if (game.userVal(colTemp) == -1) {
                    System.out.println(game.userValRan());
                } else {
                    col = game.userVal(colTemp);
                    if (!game.userValColFull(col)) {
                        notValid = false;
                    } else {
                        System.out.println(game.userVCFR());
                    }
                }
            }

            game.playerOneTurn(row,col);
            System.out.println(game.displayGrid());
            System.out.println("IS it p1 turn "+game.isP1Turn());
            //game over check
            gameOver = game.gameOver(col);
            if (gameOver) break;

            row = 5;
            col = 0;
            notValid = true;

            //player 2 turn
            while (notValid) {
                System.out.printf("%s choose a column: ", p.getP2());
                String colTemp = n.nextLine();
                if (game.userVal(colTemp) == -1) {
                    System.out.println(game.userValRan());
                } else {
                    col = game.userVal(colTemp);
                    if (!game.userValColFull(col)) {
                        notValid = false;
                    } else {
                        System.out.println(game.userVCFR());
                    }
                }
            }

            game.playerTwoTurn(row,col);
            System.out.println(game.displayGrid());


            //game over check
            gameOver = game.gameOver(col);
            if (gameOver) break;
        }

        System.out.println(game.congratulate());
        exit(0);
    }

}
