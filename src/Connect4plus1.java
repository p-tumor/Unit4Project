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
    private int checkRow;
    private String name1;
    private String name2;

    public Connect4plus1(String n, String n2){
        name1 = n;
        name2 = n2;
    }

    private void displayGrid(){
        System.out.println("-------------------------------");
        for (int r = 0; r < 6; r++){
            for (int c = 0; c < 7; c++){
                System.out.print("| "+ grid[r][c]);
                System.out.print(" |");
            }
            System.out.println();
        }
        System.out.println("-------------------------------");
    }

    private boolean gameOver(int row, int column){
        if (downCheck(row, column)) return true;
        if (LRCheck(row,column)) return true;
        if (upperRight2LowerLeft(row,column) == true) return true;
        if (upperLeft2LowerRight(row,column) == true) return true;
        return false;
    }

    public void game(){
        Scanner s = new Scanner(System.in);
        boolean playerOneTurn = true;
        int column;
        int i;
        boolean gO = false;
        int x=0;
        String columnt;
        displayGrid();


        while (gO == false){
            //player 1 turn
            i = 5;
            column = -1;
            playerOneTurn = true;
            while (column > 6 || column < 0) {
                boolean notValid = true;
                while (notValid == true) {
                    System.out.printf("%s choose a column: ", name1);
                    columnt = s.nextLine();
                    try {
                        x = Integer.parseInt(columnt);
                        notValid = false;
                    } catch (Exception ignored) {}
                }
                column = x-1;
                if (column < 0 || column > 6){
                    int r = (int)(Math.random()*2)+1;
                    if (r == 1) System.out.println("That's not a column dummy.");
                    if (r == 2) System.out.println("Bozo try again.");
                    if (r == 3)System.out.println("Barnacle brain");
                }
            }
            columnCheck(i,column,playerOneTurn);
            displayGrid();

            //game over check for player 1
            gO = gameOver(checkRow,column);
            if (gO == true) break;

            //player 2 turn
            i = 5;
            column = -1;
            playerOneTurn = false;
            while (column > 6 || column < 0) {
                System.out.printf("%s choose a column: ",name2);
                column = s.nextInt() - 1;
                if (column < 0 || column > 6){
                    int r = (int)(Math.random()*2)+1;
                    if (r == 1) System.out.println("That's not a column dummy.");
                    if (r == 2) System.out.println("Bozo try again.");
                    if (r == 3)System.out.println("Barnacle brain");
                }
            }
            columnCheck(i,column,playerOneTurn);
            displayGrid();

            //game over check for player 2
            gO = gameOver(checkRow,column);
            if (gO == true) break;
        }
        if (playerOneTurn == true) System.out.printf("Congratulations %s, you win!",name1);
        if (playerOneTurn == false) System.out.printf("Congratulations %s, you win!",name2);
    }

    private boolean downCheck(int row, int column){
        int count = 0;
        int i = row;
        if (row <= 2){
            while (count<3){
                if (grid[i][column] == grid[i+1][column]){
                    count++;
                    i++;
                }else break;
            }
        }
        return count == 3;
    }

    private boolean LRCheck(int row, int column){
        int count = 0;
        int i = column;
        // left check
        while (count<3){
            if (i-1 == -1) break;
            if (grid[row][i] == grid[row][i-1]){
                count++;
                i--;
                if (i-1 == -1) break;
            }else break;
        }

        i = column;

        //right check
        while (count<3){
            if (i+1 == 7) break;
            if (grid[row][i] == grid[row][i+1]){
                count++;
                i++;
                if (i+1 == 7) break;
            }else break;
        }

        return count == 3;
    }

    private boolean upperRight2LowerLeft(int row, int column){
        int r = row;
        int c = column;
        int count = 0;

        // upper right
        while (count<3){
            if (r-1 == -1) break;
            if (c+1 == 7) break;
            if (grid[r][c] == grid[r-1][c+1]){
                count++;
                r--;
                c++;
                if (r-1 == -1) break;
                if (c+1 == 7) break;
            }else break;
        }
        r = row;
        c = column;

        //lower left
        while(count<3){
            if (r+1 == 6) break;
            if (c-1 == -1) break;
            if (grid[r][c] == grid[r+1][c-1]){
                count++;
                r++;
                c--;
                if (r+1 == 6) break;
                if (c-1 == -1) break;
            }else break;
        }
        return count == 3;
    }

    private boolean upperLeft2LowerRight(int row, int column){
        int r = row;
        int c = column;
        int count = 0;

        // upper left
        while (count<3){
            if (r-1 == -1) break;
            if (c-1 == -1) break;
            if (grid[r][c] == grid[r-1][c-1]){
                count++;
                r--;
                c--;
                if (r-1 == -1) break;
                if (c-1 == -1) break;
            }else break;
        }

        r = row;
        c = column;

        // lower right
        while(count<3){
            if (r+1 == 6) break;
            if (c+1 == 7) break;
            if (grid[r][c] == grid[r+1][c+1]){
                count++;
                r++;
                c++;
                if (r+1 == 6) break;
                if (c+1 == 7) break;
            }else break;
        }
        return count == 3;
    }

    private void columnCheck(int i, int column, boolean b){
        int t = i;
        if (b == true){
            while(i>=0){
                if (grid[t][column] == 0){
                    grid[t][column] = 1;
                    break;
                }else{
                    t--;
                    if (t == -1) break;
                }
            }
        }
        if (b == false){
            while(t>=0){
                if (grid[t][column] == 0){
                    grid[t][column] = 2;
                    break;
                }else{
                    t--;
                    if (t == -1) break;
                }
            }
        }
        checkRow= t;
    }
}

