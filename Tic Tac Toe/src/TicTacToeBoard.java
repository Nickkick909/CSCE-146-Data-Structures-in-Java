/**
 *Written by Nicholas Knight
 */

public class TicTacToeBoard {
    public static final String EMPTY_SPACE= "_";
    public static final String X_SPACE= "X";
    public static final String O_SPACE= "O";
    public static final int SIZE= 3; //board size
    
    private String[][] spaces;
    
    public TicTacToeBoard(){
        spaces= new String[SIZE][SIZE]; //create array to correct size
        
        clearBoard();
    }
    
    public void clearBoard(){
        for(int i=0; i<SIZE;i++){
            for(int j=0;j <SIZE;j++){
            spaces[i][j]= EMPTY_SPACE;
            }
        }
    }
    
    public void drawBoard(){
        for(int i=0;i<SIZE;i++){
            for(int j=0; j<SIZE; j++){
                if(j==0 || j==2){
                    System.out.print("|" + spaces[i][j] + "|"); //prints the "|" on the outside spaces
                }
                else
                {
                    System.out.print(spaces[i][j]);
                }
            }
            System.out.println();
        }
    }
    
    public boolean checkHorizontalVictory(){
        boolean hV=false;
        if(spaces[0][0]==spaces[0][1] && spaces[0][0]==spaces[0][2] && spaces[0][0]!= EMPTY_SPACE) //if 3 on top
        {
            hV=true;        
        }
        else if(spaces[1][0]==spaces[1][1] && spaces[1][0]==spaces[1][2] && spaces[1][0]!= EMPTY_SPACE){
            hV=true;
        }
        else if(spaces[2][0]==spaces[2][1] && spaces[2][0]==spaces[2][2] && spaces[2][0]!= EMPTY_SPACE){
            hV=true;
        }
        return hV;
    }
    
    public boolean checkVerticalVictory(){ //checks each row vertically
        boolean vV=false;
        if(spaces[0][0]==spaces[1][0] && spaces[0][0]==spaces[2][0] && spaces[0][0]!= EMPTY_SPACE) //if 3 on top
        {
            vV=true;            
        }
        else if(spaces[0][1]==spaces[1][1] && spaces[0][1]==spaces[2][1] && spaces[0][1]!= EMPTY_SPACE){
            vV=true;
        }
        else if(spaces[0][2]==spaces[1][2] && spaces[0][2]==spaces[2][2] && spaces[2][0]!= EMPTY_SPACE){
            vV=true;
        }
        return vV;
    }
    
    public boolean checkDiagonalVictory(){ //only 2 diags possible
        boolean dV=false;
        if(spaces[0][0]==spaces[1][1] && spaces[0][0]==spaces[2][2] && spaces[0][0]!=EMPTY_SPACE){
            dV=true;
        }
        else if(spaces[0][2]==spaces[1][1] && spaces[0][2]==spaces[2][0] && spaces[0][2]!=EMPTY_SPACE){
            dV=true;
        }
        return dV;
    }
    
    public boolean checkVictory(){
        boolean victory=false;
        if(checkHorizontalVictory() || checkVerticalVictory() || checkDiagonalVictory()) //if 3 in any direction you win
        {
            victory=true;
        }
        return victory;
    }
    
    public boolean checkFilledBoard(){ 
        boolean filled=true;        //starts off as true 
        for(int i=0; i<spaces.length;i++){
            for(int j=0;j<spaces.length;j++){
                if(spaces[i][j]==EMPTY_SPACE){          //if it finds a single space that isnt used it will become false
                    filled=false;
                }
            }
        }
        return filled;
    }
    
    public boolean setSpace(int X, int Y, String player){
        boolean set= true;
        if(X>2 || Y>2){     //check for out of bounds
            set=false;
        }
        else if(spaces[X][Y]!= EMPTY_SPACE){ //else in bounds but already selected
            set =false;
        }
        else{
            spaces[X][Y]= player; 
        }
              
        return set;
    }
}
