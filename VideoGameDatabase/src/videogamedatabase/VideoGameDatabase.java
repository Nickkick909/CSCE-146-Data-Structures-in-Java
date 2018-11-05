/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videogamedatabase;

/**
 *Written by Nicholas Knight
 */
import java.util.Scanner;
public class VideoGameDatabase {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner keyboard=new Scanner(System.in);
        VideoGameCollectionManager games= new VideoGameCollectionManager();
        System.out.println("Welcome to the video game database!");
        boolean quit=false;
        GenericLinkedList<VideoGame> currSearch= new GenericLinkedList<VideoGame>();
        while(!quit){
            System.out.println("Enter 1 to load the video game database"
                    + "\nEnter 2 to search the database"
                    + "\nEnter 3 to print the current results"
                    + "\nEnter 4 to print current results to file"
                    + "\nEnter 0 to quit");
            int choice=keyboard.nextInt();
            keyboard.nextLine();
            switch(choice){
                case 1:
                    System.out.println("Enter file name");
                    String file=keyboard.nextLine();
                    games.ReadFile(file);
                    break;
                case 2:
                    System.out.println("Enter the name of the game or \'*\' for all names");
                    String sName= keyboard.nextLine();
                    System.out.println("Enter the console of the game or \'*\' for all consoles");
                    String sConsole=keyboard.nextLine();
                    games.search(sName, sConsole, games.list).print();
                    
                    currSearch= games.search(sName, sConsole, games.list);
                    break;
                case 3:
                    currSearch.print();
                    break;
                case 4:
                    System.out.println("Enter file name");
                    String saveFile= keyboard.nextLine();
                    System.out.println("Append? (True or False)");
                    boolean append =keyboard.nextBoolean();
                    keyboard.nextLine();
                    games.writeFile(saveFile, append, currSearch);
                    break;
                case 0: 
                    quit=true;
                    break;
                    
            }
            
        }
        
    }
    
}
