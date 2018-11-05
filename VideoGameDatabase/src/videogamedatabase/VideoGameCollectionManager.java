package videogamedatabase;

/**
 *Written by Nicholas Knight
 */
import java.util.Scanner;
import java.io.*;
public class VideoGameCollectionManager {
    public static final String DELIM="\t";
    //public static final String file="JJCollection.txt";
    public static final int AMT=2;
    GenericLinkedList<VideoGame> list= new GenericLinkedList<VideoGame>();
    
    
    public void ReadFile(String file){
        if(file==null)
            return;
        try{
            Scanner fileScanner = new Scanner(new File(file));
            while(fileScanner.hasNextLine()){
                String fileLine=fileScanner.nextLine();    //read
                String[] splitLines=fileLine.split(DELIM);  //split
                if(splitLines.length==AMT){
                    VideoGame newGame= new VideoGame();
                    newGame.setName(splitLines[0]);
                    newGame.setConsole(splitLines[1]);
                    list.insert(newGame);
                    
                }
            }
            fileScanner.close();
            
        }
        catch(Exception e){
            System.out.println(e);
        }
        
    }
    public void writeFile(String file, boolean append, GenericLinkedList list){
        if(list==null || file==null)
            return;
        try{
            list.resetCurrent();
            PrintWriter fileWriter = 
                    new PrintWriter(new FileOutputStream(file));

            while(list.curr!=null){
               fileWriter.println(list.getCurrent().toString()); 
               list.moveCurrFoward();
            }
            fileWriter.close();
                
        }
        catch(Exception e){
            System.out.println(e);
        }
        
    }
    public GenericLinkedList search(String sName, String sConsole, GenericLinkedList list){
        GenericLinkedList<VideoGame> searchResults= new GenericLinkedList<VideoGame>();
        list.resetCurrent();
        while(list.curr!=null){
            if(sName.equalsIgnoreCase("*") && sConsole.equalsIgnoreCase("*")){
                searchResults=list;
            }
            else if(sName.equalsIgnoreCase("*")){   //all names
                String[] match= list.getCurrent().toString().split(DELIM);
                if(match[1].contains(sConsole)){
                    
                    if(match.length==AMT){
                    VideoGame newGame= new VideoGame();
                    newGame.setName(match[0]);
                    newGame.setConsole(match[1]);
                    searchResults.insert(newGame);
                    
                }

                }
                list.moveCurrFoward();
            }
            else if(sConsole.equalsIgnoreCase("*")){    //all consoles
                String[] match= list.getCurrent().toString().split(DELIM);
                if(match[0].contains(sName)){
                    
                    if(match.length==AMT){
                    VideoGame newGame= new VideoGame();
                    newGame.setName(match[0]);
                    newGame.setConsole(match[1]);
                    searchResults.insert(newGame);
                    
                }

                }
                list.moveCurrFoward();
            }
            else{       //specific search
                String[] match= list.getCurrent().toString().split(DELIM);
                if(match[1].contains(sConsole) &&match[0].contains(sName)){
                    
                    if(match.length==AMT){
                    VideoGame newGame= new VideoGame();
                    newGame.setName(match[0]);
                    newGame.setConsole(match[1]);
                    searchResults.insert(newGame);
                    
                }

                }
                list.moveCurrFoward();
            }
        }
         
        return searchResults;
    }
}
