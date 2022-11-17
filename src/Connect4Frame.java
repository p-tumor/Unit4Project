import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Connect4Frame extends JFrame implements ActionListener {
    JButton button;
    Connect4Frame(){
        JFrame frame = new JFrame();
        ImageIcon image = new ImageIcon("C4LogoOrig.png");
        JLabel label = new JLabel("Start Game");
        button = new JButton();

        button.setBounds(200,100,250,100);
        button.addActionListener(e -> System.out.println("poo"));
        button.setText("Start Game");
        button.setFocusable(false);
        button.setFont(new Font("Comfortaa",Font.PLAIN,12));
        frame.add(button);

        label.setIcon(image);
        label.setFont(new Font("Comfortaa",Font.PLAIN,12));
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.TOP);
        label.setHorizontalAlignment(JLabel.LEFT);
        frame.add(label);


        frame.setTitle("Connect4+1");
        frame.setIconImage(image.getImage());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button);

    }
}
