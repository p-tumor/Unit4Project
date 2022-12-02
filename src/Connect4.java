import java.util.Arrays;

public class Connect4 {//this is a full rewrite to improve readability of code. I was rereading the other class i made and really didn't like it.
    private String[][] gameBoard = {
            { "0" , "0" , "0" , "0" , "0" , "0" , "0" },
            { "0" , "0" , "0" , "0" , "0" , "0" , "0" },
            { "0" , "0" , "0" , "0" , "0" , "0" , "0" },
            { "0" , "0" , "0" , "0" , "0" , "0" , "0" },
            { "0" , "0" , "0" , "0" , "0" , "0" , "0" },
            { "0" , "0" , "0" , "0" , "0" , "0" , "0" }
    };
    private final String PLAYER_1_NAME;
    private final String PLAYER_2_NAME;
    private byte turnCount;
    private byte row;
    private byte column;
    private byte rowToCheck;
    private boolean isItPlayer1Turn;

    public Connect4(String player1Name, String player2Name){
        PLAYER_1_NAME = player1Name;
        PLAYER_2_NAME = player2Name;
        isItPlayer1Turn = true;//player 1 always starts first
        row = 5;//the bottom row
        column = 0;//the leftmost column
    }

    //getters

    public String[][] getGameBoard() {
        return gameBoard;
    }

    public String getPLAYER_1_NAME() {
        return PLAYER_1_NAME;
    }

    public String getPLAYER_2_NAME() {
        return PLAYER_2_NAME;
    }

    public byte getTurnCount() {
        return turnCount;
    }

    public byte getRow() {
        return row;
    }

    public byte getColumn() {
        return column;
    }

    public byte getRowToCheck() {
        return rowToCheck;
    }

    public boolean isItPlayer1Turn() {
        return isItPlayer1Turn;
    }


    //setters


    public void setGameBoard(String[][] gameBoard) {
        this.gameBoard = gameBoard;
    }

    public void setTurnCount(byte turnCount) {
        this.turnCount = turnCount;
    }

    public void setRowToCheck(byte rowToCheck) {
        this.rowToCheck = rowToCheck;
    }

    public void setItPlayer1Turn(boolean itPlayer1Turn) {
        isItPlayer1Turn = itPlayer1Turn;
    }

    public void setColumn(byte column) {
        this.column = column;
    }
    public void setRow(byte row){this.row = row;}
    public String displayGameBoard(){
        String gameBoardDisplay = "-------------------------------\n";
        for (byte row = 0; row < 6; row++){
            for (byte column = 0; column < 7; column++){
                gameBoardDisplay += "| "+ gameBoard[row][column];
                gameBoardDisplay += " |";
            }
            gameBoardDisplay += "\n";
        }
        byte columnNumbers = 1;//the numbers below the columns
        while (columnNumbers < 8){
            if (turnCount > 0){
                if (columnNumbers == column){
                    String columnNumbersString = Byte.toString(columnNumbers);
                    gameBoardDisplay += "  \033[94m"+columnNumbersString+"\033[0m  ";
                    columnNumbers++;
                }
            }
            gameBoardDisplay += "  "+columnNumbers+"  ";
            columnNumbers++;
        }
        gameBoardDisplay += "\n";
        gameBoardDisplay += "-------------------------------";
        return gameBoardDisplay;
    }

    //please note all checks start at from the last placed token
    //also keep in mind all checks only look for three because the placed token is already counted, obviously.
    //ALSO also keep in mind that temp variables are created so that attributes do not need to be manipulated directly.
    public boolean downwardCheck(){
        byte count = 0;
        byte rowToCheckTemp = rowToCheck;
        if (!gameBoard[rowToCheck][column].equals("0")){
            if (rowToCheck < 3){
                while (count<3){
                    if (gameBoard[rowToCheckTemp][column].equals(gameBoard[rowToCheckTemp+1][column])){
                        count++;
                        rowToCheckTemp++;
                    }else break;
                }
            }
        }
        return count == 3;
    }

    public boolean leftAndRightCheck(){
        byte count = 0;//keeps track of tokens found similar
        byte columnTemp = column;

        if (!gameBoard[rowToCheck][columnTemp].equals("0")){
            // left check
            if (columnTemp-1 != -1){//to make sure there are no out of bounds errors
                while (count<3){
                    if (gameBoard[rowToCheck][columnTemp].equals(gameBoard[rowToCheck][columnTemp-1])){
                        count++;
                        columnTemp--;//to check the following left column
                        if (columnTemp-1 != -1) break;//if this goes out of bounds, the loop is stopped
                    }else break;//this break is so that when the next token is found to not be the same, it ends the loop so that the right check may begin
                }
            }

            columnTemp = column;//goes back to last placed token and checks the right

            //right check
            if (columnTemp+1 == 7){
                while (count<3){
                    if (gameBoard[rowToCheck][columnTemp].equals(gameBoard[rowToCheck][columnTemp+1])){
                        count++;
                        columnTemp++;//to check the following right column
                        if (columnTemp+1 == 7) break;//if the increment goes out of bounds, the loop is stopped
                    }else break;//this break is so that when the next token is found to not be the same, it ends the loop so that the right check may being
                }
            }
        }
        return count == 3;
    }

    public boolean upperRightToLowerLeft() {
        byte rowToCheckTemp = rowToCheck;
        byte columnTemp = column;
        byte count = 0;

        if (!gameBoard[rowToCheckTemp][columnTemp].equals("0")) {
            if (rowToCheckTemp - 1 != -1 && columnTemp + 1 != 7) {//make sure there are no out of bounds errors
                while (count < 3) {
                    if ((gameBoard[rowToCheckTemp][columnTemp].equals(gameBoard[rowToCheckTemp - 1][columnTemp + 1]))) {
                        count++;
                        rowToCheckTemp--;//moves upward
                        columnTemp++;//moves to the right
                        if (rowToCheckTemp - 1 == -1 || columnTemp + 1 == 7)
                            break;//if either variables go otu of bounds, loop is stopped
                    } else
                        break;//this break is so that when the next token is found to not be the same, it ends the loop so that the right check may being
                }
            }

            //reset to last placed token
            rowToCheckTemp = rowToCheck;
            columnTemp = column;

            //lower left
            if (rowToCheckTemp + 1 != 6 && columnTemp - 1 != -1) {
                while (count < 3) {
                    if (gameBoard[rowToCheckTemp][columnTemp].equals(gameBoard[rowToCheckTemp + 1][columnTemp - 1])) {
                        count++;
                        rowToCheckTemp++;//moves downward
                        columnTemp--;//moves to the left
                        if (rowToCheckTemp + 1 == 6 || columnTemp - 1 == -1) break;//another out of bounds check
                    } else break;
                }
            }
        }
        return count == 3;
    }


    public boolean upperLeftToLowerRight(){
        byte rowToCheckTemp = rowToCheck;
        byte columnTemp = column;
        byte count = 0;

        if (!gameBoard[rowToCheckTemp][columnTemp].equals("0")){
            // upper left
            if (rowToCheckTemp-1 != -1 && columnTemp-1 != -1){//bet you can't tell me what this is. i'll help. its another out of bounds check
                while (count<3){
                    if (gameBoard[rowToCheckTemp][columnTemp].equals(gameBoard[rowToCheckTemp-1][columnTemp-1])){
                        count++;
                        rowToCheckTemp--;//moves upward
                        columnTemp--;//moves to the left
                        if (rowToCheckTemp-1 == -1 || columnTemp-1 == -1) break;//yet another out of bounds check
                    }else break;
                }
            }

            //reset to last placed
            rowToCheckTemp = rowToCheck;
            columnTemp = column;

            // lower right
            if (rowToCheckTemp+1 != 6 && columnTemp+1 != 7){//out of bounds check
                while(count<3){
                    if (gameBoard[rowToCheckTemp][columnTemp].equals(gameBoard[rowToCheckTemp+1][columnTemp+1])){
                        count++;
                        rowToCheckTemp++;//moves downward
                        columnTemp++;//moves to the right
                        if (rowToCheckTemp+1 == 6 || columnTemp+1 == 7) break;//wow who would've guessed, another out of bounds check
                    }else break;
                }
            }
        }
        return count == 3;
    }

    public boolean gameOver(){// if any of these are true, game over.
        if (downwardCheck() == true) return true;
        if (leftAndRightCheck() == true) return true;
        if (upperLeftToLowerRight() == true) return true;
        if (upperRightToLowerLeft() == true) return true;
        return false;
    }

    public void player1Turn(){
        byte rowTemp = row;
        if (isItPlayer1Turn()){
            while (row >= 0 ) {//loop to check if the bottom of the column is filled. this is so token actually go to the bottom of the column. I know this loop may seem a bit point less, but i need this loop ok?
                if (gameBoard[rowTemp][column].equals("0")) {
                    gameBoard[rowTemp][column] = "\033[31m1\033[0m";
                    turnCount++;
                    break;
                }else{
                    rowTemp--;
                    if (rowTemp == -1) break;
                }
            }
        }
        rowToCheck = rowTemp;
        if (!gameOver()) isItPlayer1Turn = !isItPlayer1Turn;//inverts playerturn variable so that the other turn my begin
    }

    public void playerTwoTurn(){
        byte rowTemp = row;
        if (!isItPlayer1Turn()){
            while(rowTemp>=0){
                if (gameBoard[rowTemp][column].equals("0")){
                    gameBoard[rowTemp][column] = "\033[93m2\033[0m";
                    turnCount++;
                    break;
                }else{
                    rowTemp--;
                    if (rowTemp == -1) break;
                }
            }
        }
        rowToCheck = rowTemp;
        if (!gameOver()) isItPlayer1Turn = !isItPlayer1Turn;
    }

    public int userInputValidation(String s){
        byte x;
        try{
            x = Byte.parseByte(s);
        }catch(Exception e) {
            return -1;
        }
        if (x > 7 || x < 0)  return -1;
        return x-1;//so its the proper index
    }

    public String userInputValidationRandomQuotes(){//if the input is wrong, you can use these quotes
        byte r = (byte)((Math.random()*6)+1);
        if (r == 1) return "Bro.";
        if (r == 2) return "C'mon.";
        if (r == 3) return "That's not a column dummy.";
        if (r == 4) return "Bozo try again.";
        if (r == 5) return "Barnacle brain";
        return "Doofus.";
    }

    public boolean fullColumnCheck(byte col){return !gameBoard[0][col].equals("0");}//checks the top of a given column to see if it is full

    public boolean isItATie(){
        byte count =0;
        for (byte column = 0; column < 7; column++){
            if (fullColumnCheck(column)) {
                count++;
            }
        }
        return count==7;
    }

    public String fullColumnCheckRandomQuotes(){
        byte r = (byte)((Math.random()*3)+1);
        if (r == 1) return "Are you even looking?";
        if (r == 2) return "Open your eyes.";
        return "Seek visual assistance.";
    }

    public String congratulate(){
        if (isItPlayer1Turn()) return "Congratulations " + PLAYER_1_NAME + ". You win!";
        else return "Congratulations " + PLAYER_2_NAME + ". You win!";
    }

    public String toString(){
        String display = "This is the current grid: \n";
        display += getGameBoard() + "\n";
        display += "Player 1 name: "+getPLAYER_1_NAME()+"\n";
        display += "Player 2 name: "+getPLAYER_2_NAME()+"\n";
        if (isItPlayer1Turn()) display += "It is "+getPLAYER_1_NAME()+"'s turn.";
        else display += "It is "+getPLAYER_2_NAME()+"'s turn.";
        return display;
    }
}