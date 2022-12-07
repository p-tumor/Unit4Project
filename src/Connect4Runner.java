import java.util.Scanner;
import static java.lang.System.exit;

public class Connect4Runner {
    public static void main(String[] args) {
        boolean notValid = true;
        Scanner n = new Scanner(System.in);
        String player1Color="";
        String player2Color="";
        String[] color = {"GREEN","green","BLUE","blue","YELLOW","yellow","MAGENTA","magenta","CYAN","cyan","red","RED",};


        System.out.println("Player 1 input your desired name: ");
        String name1 = n.nextLine();
        System.out.println("Player 2 input your desired name: ");
        String name2 = n.nextLine();

        Connect4 newGame;

        while (notValid){
            System.out.println(name1 +" what color would you like your token to be?\n" +
                    "Choices:Green, Blue, Yellow, Magenta, Cyan, Red (all caps or all lowercase)");
            player1Color = n.nextLine();
            for (String s : color){
                if (s.equals(player1Color)) {
                    notValid = false;
                    break;
                }
            }
        }

        notValid = true;

        while (notValid){
            System.out.println(name2+" what color would you like your token to be?\n" +
                    "Choices:Green, Blue, Yellow, Magenta, Cyan, Red (all caps or all lowercase)");
            player2Color = n.nextLine();
            for (String s : color){
                if (s.equals(player2Color)) {
                    notValid = false;
                    break;
                }
            }
        }

        newGame = new Connect4(name1, name2);
        newGame.setPlayer1Color(player1Color);
        newGame.setPlayer2Color(player2Color);

        boolean gameOver = newGame.gameOver();
        System.out.println(newGame.displayGameBoard());
        while (!gameOver) {
            notValid = true;

            //player 1 turn
            while (notValid) {

                System.out.printf("%s choose a column: ", newGame.getPLAYER_1_NAME());
                String colTemp = n.nextLine();

                if (newGame.userInputValidation(colTemp) == -1) {
                    System.out.println(newGame.userInputValidationRandomQuotes());
                } else {
                    byte colTemp2 = Byte.parseByte(colTemp);
                    newGame.setColumn((byte) (colTemp2-1));
                    if (!newGame.fullColumnCheck(newGame.getColumn())) {
                        notValid = false;
                    } else {
                        System.out.println(newGame.fullColumnCheckRandomQuotes());
                    }
                }
            }

            newGame.player1Turn();
            System.out.println(newGame.displayGameBoard());
            gameOver = newGame.gameOver();
            if (gameOver) break;

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
                    newGame.setColumn((byte)(colTemp2-1));
                    if (!newGame.fullColumnCheck(newGame.getColumn())) {
                        notValid = false;
                    } else {
                        System.out.println(newGame.fullColumnCheckRandomQuotes());
                    }
                }
            }

            newGame.playerTwoTurn();
            System.out.println(newGame.displayGameBoard());
            gameOver = newGame.gameOver();
            if (gameOver) break;

        }
        if (newGame.isItATie()) System.out.println("Both of you losers are losers");
        else System.out.println(newGame.congratulate());
        exit(0);
    }
}


