package hangman;

/**
 *Written by Nicholas Knight
 */
import java.util.Scanner;
import java.util.Random;
public class Hangman {

    /**
     * @param args the command line arguments
     */
    public static final int bH=7;
    public static final int bW=6;
    public static void main(String[] args) {
        
        // TODO code application logic here
        Scanner keyboard =new Scanner(System.in);
        
        HangmanBackEnd game= new HangmanBackEnd();
        Random r =new Random();
        game.resetGame();
        String[][] board= new String[bH][bW];
        
        setBoard(board);
        boolean quit=false;
        
        while(!quit){
            boolean lose=false;
            while(!lose){
                printBoard(board);
                System.out.println("You have made "+game.getGuessCount()+" guesses");
                System.out.println(game.getdWord());
                System.out.println("Enter a letter");
                String guess= keyboard.nextLine();
                game.makeGuess(guess);
                if(!game.makeGuess(guess))
                {
                    game.setWrongCount(game.getWrongCount()+1);
                }
                if(game.getWrongCount()==1){    //head
                    board[2][4]="O";
                }
                if(game.getWrongCount()==2){    //body
                    board[3][4]="|";
                    board[4][4]="|";
                }
                if(game.getWrongCount()==3){    //arm 1
                    board[3][3]="\\";
                }
                if(game.getWrongCount()==4){    //arm 2
                    board[3][5]="/";
                }
                if(game.getWrongCount()==5){    //leg 1
                    board[5][3]="/";
                }
                if(game.getWrongCount()==6){    //leg 2
                    board[5][5]="\\";
                }
                if(game.getWrongCount()>=7){ //check for lose
                    System.out.println("You lose! Play again? (Yes/No)");
                    lose=true;
                    
                }
                
                //check for win
                if(game.isFound()){
                    System.out.println("You win!! Play again? (Yes or No)");
                    lose=true; //not a lose but break the loop
                }
                 

            //System.out.println(r.nextInt(game.getDictionary().length));
            }
            
            if(keyboard.nextLine().equalsIgnoreCase("Yes")){
                quit=false;
                game.resetGame();
                setBoard(board);
            }
            else{
                quit=true;
                game.resetGame();
            }
                
            
        }
    }
    public static void printBoard(String[][] board){
        for(int i=0;i<bH;i++){
            for(int j=0; j<bW;j++){
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
    public static void setBoard(String[][] board){
        //set up board
        for(int i=0;i<bW;i++){ //set up top row
            board[0][i]="_ ";
        }
        for(int i=1;i<bH;i++){
            board[i][0]="|";
        }
        for(int i=1;i<bH;i++){
            for(int j=1; j<bW;j++){
                board[i][j]=" ";
            }
        }
        board[1][4]="|";
    }
    
}
