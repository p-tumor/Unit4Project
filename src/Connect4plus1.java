import java.util.Objects;
import java.util.Scanner;
public class Connect4plus1 {

    private String[][] grid = {
            { "0" , "0" , "0" , "0" , "0" , "0" , "0" },
            { "0" , "0" , "0" , "0" , "0" , "0" , "0" },
            { "0" , "0" , "0" , "0" , "0" , "0" , "0" },
            { "0" , "0" , "0" , "0" , "0" , "0" , "0" },
            { "0" , "0" , "0" , "0" , "0" , "0" , "0" },
            { "0" , "0" , "0" , "0" , "0" , "0" , "0" }
    };
    private int checkRow;
    private String p1;
    private String p2;
    private String color;

    public Connect4plus1(String n, String n2){
        p1 = n;
        p2 = n2;
    }
    public Connect4plus1(){
        p1 = "Player 1";
        p2 = "Player 1";
    }
    public Connect4plus1(String n){
        p1 = "Player 1";
        p2 = n;
    }
    public Connect4plus1(String x){
        p1 = n;
        p2 = "Player 1";
    }

    public String getP1(){return p1;}
    public String getP2(){return p2;}

    public String displayGrid(){
        String s = "-------------------------------\n";
        for (int r = 0; r < 6; r++){
            for (int c = 0; c < 7; c++){
                s += "| "+ grid[r][c];
                s += " |";
            }

            s += "\n";
        }
        int x = 1;
        while (x <8){
            s += "  "+x+"  ";
            x++;
        }
        s += "\n";
        s += "-------------------------------";
        return s;
    }

    public String congratulate(boolean b){
        if (b) return "Congratulations " + p1 + ". You win!";
        else return "Congratulations " + p2 + ". You win!";
    }

    public boolean gameOver(int column){
        int row = checkRow;
        if (downCheck(row, column)) return true;
        if (LRCheck(row,column)) return true;
        if (upperRight2LowerLeft(row,column)) return true;
        if (upperLeft2LowerRight(row,column)) return true;
        else return false;
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
            if (Objects.equals(grid[r][c], grid[r - 1][c + 1])){
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

    public void columnCheck(int row, int column, boolean b){
        int t = row;
        if (b == true){
            while(row>=0){
                if (grid[t][column] == "0"){
                    grid[t][column] = "\033[31m1\033[0m";
                    break;
                }else{
                    t--;
                    if (t == -1) break;
                }
            }
        }
        if (b == false){
            while(t>=0){
                if (grid[t][column] == "0"){
                    grid[t][column] = "\033[33m2\033[0m";
                    break;
                }else{
                    t--;
                    if (t == -1) break;
                }
            }
        }
        checkRow= t;
    }

    public int userVal(String s){
        int x;
        try{
            x = Integer.parseInt(s);
        }catch(Exception e) {
            return -1;
        }
        if (x > 7 || x < 0)  return -1;
        return x-1;
    }

    public String userValRan(){
        int r = (int)(Math.random()*6)+1;
        if (r == 1) return "Bro.";
        if (r == 2) return "C'mon.";
        if (r == 3) return "That's not a column dummy.";
        if (r == 4) return "Bozo try again.";
        if (r == 5) return "Barnacle brain";
        return "Doofus.";
    }

    public boolean userValColFull(int column){
        return grid[0][column] != "0";
    }

    public String userVCFR(){
        int r = (int)(Math.random()*3)+1;
        if (r == 1) return "Are you even looking?";
        if (r == 2) return "Open your eyes.";
        return "Seek visual assistance.";
    }
}

