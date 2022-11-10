public class Connect4Runner {
    public static void main(String[] args) {
        boolean gameOver = false;
        Connect4plus1 p = new Connect4plus1();
        while (gameOver == false){
            p.displayGrid();
            p.playing();

        }
    }
}
