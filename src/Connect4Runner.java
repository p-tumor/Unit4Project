import java.util.Scanner;
public class Connect4Runner {
    public static void main(String[] args) {
        Scanner n = new Scanner(System.in);

        System.out.println("Player 1 input your desired name: ");
        String n1 = n.nextLine();
        System.out.println("Player 2 input your desired name: ");
        String n2 = n.nextLine();

        Connect4plus1 p = new Connect4plus1(n1,n2);

        p.game();
    }
}
