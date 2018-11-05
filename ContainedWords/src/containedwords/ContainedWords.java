package containedwords;

/**
 * Written by Nicholas Knight
 */
import java.util.Scanner;
public class ContainedWords {
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner keyboard=new Scanner(System.in);
        System.out.println("Enter 2 words. I will determine if"
                + "\nthe letters of one is contained in"
                + "\nthe other");
        String word1=keyboard.nextLine();
        String word2=keyboard.nextLine();
        containsWord(word1, word2);
    }
    public static void containsWord(String word1, String word2){
        int index=0;
        char[] word1A= new char[word1.length()];
        word1A= word1.toCharArray();
        char[] word2A= new char[word2.length()];
        word2A= word2.toCharArray();
        if(index<word2.length()){
            
            if(linearSearch(word2A, word1A[index]))
                System.out.println("They are contained");
            else
                System.out.println("They are not contained");
        }
    }
    public static boolean linearSearch(char[] a, char target){
        for(int i=0; i<a.length;i++){
            if(a[i]==target)
                return true; 
        }
        return false;
    }  
}
