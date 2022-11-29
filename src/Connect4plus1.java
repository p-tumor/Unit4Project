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
    private final String P1;
    private final String P2;
    private String color;
    private boolean p1Turn;
    private int row;
    private int col;

    public Connect4plus1(String n, String n2){
        P1 = n;
        P2 = n2;
        p1Turn = true;
        row = 5;
        col = 0;
    }
    public Connect4plus1(){
        P1 = "Player 1";
        P2 = "Player 2";
        p1Turn = true;
        row = 5;
        col = 0;
    }


    public String getP1(){return P1;}
    public String getP2(){return P2;}
    public int getCheckRow(){return checkRow;}
    public int getRow(){return row;}
    public int getCol(){return col;}

    public String getGrid(){
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

    public boolean getP1Turn(){
        return p1Turn;
    }

    public void setGrid(String[][] grid){
        this.grid = grid;
    }
    public void setP1Turn(boolean p1Turn){
        this.p1Turn = p1Turn;
    }

    public void setRow(int x){row = x;}
    public void setCol(int x){col = x;}

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

    public String congratulate(){
        if (getP1Turn()) return "Congratulations " + P1 + ". You win!";
        else return "Congratulations " + P2 + ". You win!";
    }

    public boolean gameOver(){
        if (downCheck()) return true;
        if (lRCheck()) return true;
        if (upperRight2LowerLeft()) return true;
        if (upperLeft2LowerRight()) return true;
        else return false;
    }

    private boolean downCheck(){
        int count = 0;
        int i = checkRow;
        if (checkRow <= 2){
            while (count<3){
                if (grid[i][col] == grid[i+1][col]){
                    count++;
                    i++;
                }else break;
            }
        }
        return count == 3;
    }

    private boolean lRCheck(){
        int count = 0;
        int i = col;
        // left check
        while (count<3){
            if (i-1 == -1) break;
            if (grid[checkRow][i].equals(grid[checkRow][i-1])){
                count++;
                i--;
                if (i-1 == -1) break;
            }else break;
        }

        i = col;

        //right check
        while (count<3){
            if (i+1 == 7) break;
            if (grid[checkRow][i].equals(grid[checkRow][i+1])){
                count++;
                i++;
                if (i+1 == 7) break;
            }else break;
        }

        return count == 3;
    }

    private boolean upperRight2LowerLeft(){
        int r = checkRow;
        int c = col;
        int count = 0;

        // upper right
        while (count<3){
            if (r-1 == -1) break;
            if (c+1 == 7) break;
            if ((grid[r][c].equals(grid[r - 1][c + 1]))){
                count++;
                r--;
                c++;
                if (r-1 == -1) break;
                if (c+1 == 7) break;
            }else break;
        }
        r = checkRow;
        c = col;

        //lower left
        while(count<3){
            if (r+1 == 6) break;
            if (c-1 == -1) break;
            if (grid[r][c].equals(grid[r+1][c-1])){
                count++;
                r++;
                c--;
                if (r+1 == 6) break;
                if (c-1 == -1) break;
            }else break;
        }
        return count == 3;
    }

    private boolean upperLeft2LowerRight(){
        int r = checkRow;
        int c = col;
        int count = 0;

        // upper left
        while (count<3){
            if (r-1 == -1) break;
            if (c-1 == -1) break;
            if (grid[r][c].equals(grid[r-1][c-1])){
                count++;
                r--;
                c--;
                if (r-1 == -1) break;
                if (c-1 == -1) break;
            }else break;
        }

        r = checkRow;
        c = col;

        // lower right
        while(count<3){
            if (r+1 == 6) break;
            if (c+1 == 7) break;
            if (grid[r][c].equals(grid[r+1][c+1])){
                count++;
                r++;
                c++;
                if (r+1 == 6) break;
                if (c+1 == 7) break;
            }else break;
        }
        return count == 3;
    }

    public void playerOneTurn(){
        int t = row;
        if (getP1Turn()){
            while(row>=0){
                if (grid[t][col].equals("0")){
                    grid[t][col] = "\033[31m1\033[0m";
                    break;
                }else{
                    t--;
                    if (t == -1) break;
                }
            }
        }
        checkRow = t;
        if (!gameOver()) p1Turn = !p1Turn;
    }

    public void playerTwoTurn(){
        int t = row;
        if (getP1Turn() == false){
            while(t>=0){
                if (grid[t][col].equals("0")){
                    grid[t][col] = "\033[93m2\033[0m";
                    break;
                }else{
                    t--;
                    if (t == -1) break;
                }
            }
        }
        checkRow= t;
        if (!gameOver()) p1Turn = !p1Turn;
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

    public boolean userValColFull(){
        return grid[0][this.col] != "0";
    }

    public boolean tie(){
        int x;
        int count = 0;
        for (x = 0; x < 7; x++){
            if (userValColFull(col)) count++;
        }
        return count==7;
    }

    public String userVCFR(){
        int r = (int)(Math.random()*3)+1;
        if (r == 1) return "Are you even looking?";
        if (r == 2) return "Open your eyes.";
        return "Seek visual assistance.";
    }

    public String toString(){
        String str = "This is the current grid: \n";
        str += getGrid() + "\n";
        str += "Player 1 name: "+getP1()+"\n";
        str += "Player 2 name: "+getP2()+"\n";
        if (getP1Turn()) str += "It is "+getP1()+"'s turn.";
        else str += "It is "+getP2()+"'s turn.";
        return str;
    }
}

