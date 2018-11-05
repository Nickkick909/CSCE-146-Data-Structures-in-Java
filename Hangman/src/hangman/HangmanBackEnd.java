package hangman;

/**
 *Written by Nicholas Knight
 */
import java.util.Scanner;
import java.io.*;
import java.util.Random;

public class HangmanBackEnd {
    private String secretWord;
    private String dWord;
    private int guessCount;
    private int wrongCount;
    private String[] dictionary;
    public static final String DELIM= "\n";
    public static final int FIELD_AMT=1;
    public static final String FILE ="dict.txt";

    public HangmanBackEnd() {
        this.secretWord = "no word yet";
        this.dWord = "???????????";
        this.guessCount = 0;
        this.wrongCount = 0;
        
        //loadDictionary(FILE);
    }

   
    public String getSecretWord() {
        return secretWord;
    }
    public String getdWord() {
        return dWord;
    }
    public int getGuessCount() {
        return guessCount;
    }
    public int getWrongCount() {
        return wrongCount;
    }
    public String[] getDictionary() {
        return this.dictionary;
    }
    public void setSecretWord(String secretWord) {
        this.secretWord = secretWord;
    }
    public void setdWord(String dWord) {
        this.dWord = dWord;
    }
    public void setGuessCount(int guessCount) {
        if(guessCount>=0)
            this.guessCount = guessCount;
    }
    public void setWrongCount(int wrongCount) {
        if(wrongCount>=0)
            this.wrongCount = wrongCount;
    }
    public void setDictionary(String[] dictionary) {
        this.dictionary = dictionary;
    }
    public void loadDictionary(String fileName){
        if(fileName==null)
            return;
        try{
            System.out.println("test");
            Scanner fileScanner=new Scanner(new File(fileName));
            int count =0;       //count the length of the file to make the array
            while(fileScanner.hasNextLine()){
                //System.out.println("i");
                fileScanner.nextLine();
                count++;
            }
                        System.out.println("test");
            this.init(count);        //creates array for dictionary
            fileScanner=new Scanner(new File(fileName)); //reset scanner
            count=0;
            while(fileScanner.hasNextLine()){
                String fileLine=fileScanner.nextLine();     //read
                String[] splitLines= fileLine.split(DELIM);  //split
                if(splitLines.length==FIELD_AMT){
                    String word= splitLines[0];
                    dictionary[count]=word;
                    count++;
                } 
            }
            fileScanner.close();     
        }
        catch(IOException e){
            System.out.println(e);
        }
        catch(Exception e){
            System.out.println(e);
        } 
    }
    private void init(int size){
        if(size>=0)
            dictionary=new String[size];
    }
    public void resetGame(){
        this.loadDictionary(FILE);
        Random r=new Random();
        
        this.setSecretWord(this.dictionary[r.nextInt(dictionary.length)]);
        dWord=secretWord;
        char[] dWordC=this.secretWord.toCharArray();
        for(int i=0;i<dWordC.length;i++){
                dWordC[i]='?';    //replaces secret word with ????
        }
        dWord="";
        for(int i=0;i<secretWord.length();i++){
            dWord+=dWordC[i];
        }
        
        //this.dWord = "no word yet";
        this.guessCount = 0;
        this.wrongCount = 0;
        //this.dictionary = null;
    }  
    public boolean makeGuess(String letter){
        boolean correct=false;
        char[] dWordC=dWord.toCharArray();  //changes String dWord to char[] to replace the ?'s
        for(int i=0;i<this.secretWord.length();i++){
            if(this.secretWord.charAt(i)==letter.charAt(0)){
                correct=true;
                
                dWordC[i]=letter.charAt(0); //replaces ? with guessed letter
                
            }  
        }
        dWord="";
        for(int i=0;i<secretWord.length();i++){
           
            dWord+=dWordC[i];
        }
        
        this.guessCount++;
        return correct;
    }
    public boolean isFound(){
        boolean found=true;
        for(int i =0; i<dWord.length();i++){
            if(this.dWord.charAt(i)=='?'){
                found=false;
            }
        }
        return found;
    }
}
