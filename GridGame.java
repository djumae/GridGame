
/**
 * Write a description of class GridGame here.
 *
 * @author Daniel Jiang
 * @version March 14, 2023
 * constructor is done, working on playGame
 */
import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
public class GridGame {
    private int columns;
    private int rows;
    private char[][] board;

    public GridGame(String boardInfo) throws Exception{
        

        File file = new File(boardInfo);
        Scanner input = new Scanner(file);
        String coords = input.nextLine();
        String[] pieces = coords.split(" ");
        rows = Integer.parseInt(pieces[0]);
        columns = Integer.parseInt(pieces[1]);
        int i = 0;
        
        
        board = new char[rows][columns];
        
        while(input.hasNextLine()){
            String line = input.nextLine();
            char[] cArray = line.toCharArray();
            for(int j = 0; j < columns; j++){
                board[i][j] = cArray[j];
            }
            i++;
        }
        input.close();
    }
    public void playGame(){
        char charE = 'E';
        char charN = 'N';
        char charS = 'S';
        char charW = 'W';
        char charT = 'T';
        boolean foundTreasure = false;
        boolean[][] visited = new boolean[rows][columns];
        int countRows = 0;
        int countColumns= 0;
        int moveCount = 0;
        while(countRows < rows && countColumns < columns && countRows >= 0 && countColumns >= 0){
        if(visited[countRows][countColumns]){
            System.out.println("Location: countRows + "+ " + countColumns + ");
            System.out.println("You are getting nowhere");
            break;
        }
        else{
            visited[countRows][countColumns] = true;
            moveCount++;
        }
        if(countColumns < rows && board[countRows][countColumns] == charE){
            countColumns ++;
        }
        else if(countColumns > 0 && board[countRows][countColumns] == charW){
            countColumns -=1;
        }
        else if(board[countRows][countColumns] == charT){
            foundTreasure = true;
            moveCount -= 1;
            break;
        }
        else if(countRows < rows && board[countRows][countColumns] == charS){
            countRows ++;
        }
        else if(countRows > 0 && board[countRows][countColumns] == charN){
            countRows -=1;
        }
        else{
            System.out.println("You fell off the board.");
            break;
        }
    }
    
    if(foundTreasure){
        System.out.println("I reached the treasure in " + moveCount + "turns.");
    }
    else{
        System.out.println("Game over.");
    }
}
}


















