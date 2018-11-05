package hotpotato;

/**
 *Written by Nicholas Knight
 */
import java.util.Scanner;
public class HotPotato {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner keyboard=new Scanner(System.in);
        CircularLL <Player> playerList=new CircularLL<Player>();
        System.out.println("Welcome to Hot Potato!!"
                + "\nEnter number of players (at least 2)");
        int numPlayers=keyboard.nextInt();
        keyboard.nextLine();
        for(int i=0;i<numPlayers;i++){
            System.out.println("Enter player "+(i+1)+"\'s name");
            String name=keyboard.nextLine();
            Player temp=new Player(name);
            playerList.insert(temp);
        }
       // playerList.print();
        
        boolean quit=false;
        while(!quit){
           Potato potato=new Potato();
           int totalPotatoTime=0;
           while(!playerList.onePlayerLeft()){


                String temp= playerList.getCurrent().getName();
                System.out.println(temp+ " enter a time to hold the potato");
                
                int hold=keyboard.nextInt();
                if(hold<1 || hold>10){
                    System.out.println("1-10 seconds please. Defaulted to 10");
                    hold=10;
                }
                keyboard.nextLine();
                totalPotatoTime+=hold;
                if(totalPotatoTime>=potato.getTime()){
                    System.out.println("HOT POTATO!!"+playerList.getCurrent()+" is eliminated");
                    playerList.deleteCurrent();
                }
                else{
                    System.out.println(playerList.getCurrent()+" is safe");
                    playerList.moveForward();
                }

           } 
           System.out.println("Player "+ playerList.getCurrent()+" wins!!"
                   + "\nQuit? (true or false)");
           quit=keyboard.nextBoolean();
           if(quit)
               break;
              
        
        playerList=new CircularLL<Player>();
        System.out.println("Welcome to Hot Potato!!"
                + "\nEnter number of players (at least 2)");
        numPlayers=keyboard.nextInt();
        keyboard.nextLine();
            for(int i=0;i<numPlayers;i++){
                System.out.println("Enter player "+(i+1)+"\'s name");
                String name=keyboard.nextLine();
                Player temp=new Player(name);
                playerList.insert(temp);
            }
        } 
    }
}
       
    
    
