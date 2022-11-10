import java.util.Scanner;
public class Connect4plus1 {

    private int[][] grid = {
            { 0 , 0 , 0, 0 , 0 , 0 , 0 },
            { 0 , 0 , 0, 0 , 0 , 0 , 0 },
            { 0 , 0 , 0, 0 , 0 , 0 , 0 },
            { 0 , 0 , 0, 0 , 0 , 0 , 0 },
            { 0 , 0 , 0, 0 , 0 , 0 , 0 },
            { 0 , 0 , 0, 0 , 0 , 0 , 0 }
    };

    public void displayGrid(){
        System.out.println("-------------------------------");
        for (int r = 0; r < 6; r++){
            for (int c = 0; c < 7; c++){
                System.out.print(grid[r][c]);
            }
            System.out.println();
        }
        System.out.println("-------------------------------");
    }

    public boolean gameOver(int row, int column){
        int count = 0;
        while (count < 5){
            int x = grid[row][column];

        }
    }

    public void playing(){
        Scanner s = new Scanner(System.in);
        boolean bottom;
        int i = 5;

        //player 1 turn
        System.out.print("Player one choose a column: ");
        int column = s.nextInt()-1;
        while(i>-1){
            if (grid[i][column] == 0){
                grid[i][column] = 1;
                break;
            }else{
                i--;
            }
        }
        displayGrid();

        //player 2 turn
        System.out.print("Player two choose a column: ");
        column = s.nextInt()-1;
        while(i>-1){
            if (grid[i][column] == 0){
                grid[i][column] = 2;
                break;
            }else{
                i--;
            }
        }
        displayGrid();
    }
}

