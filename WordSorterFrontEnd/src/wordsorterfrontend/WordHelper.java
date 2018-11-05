/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordsorterfrontend;

/**
 *Written by Nicholas Knight
 *
 * It's good to be back :)
 */
public class WordHelper {
    
    public static String[] sortByVowels(String[] words) {
        String[] wordsV = new String[words.length];
        for(int i=0; i<words.length;i++)
        {
           wordsV[i]=words[i]; 
        }
        //bubble sort
        boolean hasSwapped=true;
        while(hasSwapped==true)
        {
         hasSwapped=false;
             for(int i=0; i<wordsV.length-1;i++)
             {

                  if(numVowels(wordsV[i]) > numVowels(wordsV[i+1]))
                  {
                   String temp=wordsV[i];
                   wordsV[i]=wordsV[i+1];
                   wordsV[i+1]=temp;

                   hasSwapped=true;
                  }

             }
        }
        
        return wordsV;
    }
    
    public static String[] sortByConsonants(String[] words){
        String[] wordsC = new String[words.length];
        for(int i=0; i<words.length;i++){
           wordsC[i]=words[i]; //copy the array so the original is not sorted
        }
        //bubble sort
        boolean hasSwapped=true;
        while(hasSwapped==true)
        {
         hasSwapped=false;
             for(int i=0; i<wordsC.length-1;i++)
             {

                  if(numCons(wordsC[i]) > numCons(wordsC[i+1]))
                  {
                   String temp=wordsC[i];
                   wordsC[i]=wordsC[i+1];
                   wordsC[i+1]=temp;

                   hasSwapped=true;
                  }

             }
        }
        
        return wordsC;
    }
    
    public static String[] sortByLength(String[] words){
        String[] wordsL = new String[words.length];
        for(int i=0; i<words.length;i++){
           wordsL[i]=words[i];  
        }
        
    //bubble sort
    boolean hasSwapped=true;
    while(hasSwapped==true)
    {
     hasSwapped=false;
         for(int i=0; i<wordsL.length-1;i++)
         {
             if(wordsL[i].length()>wordsL[i+1].length())
              {
               String temp=wordsL[i];
               wordsL[i]=wordsL[i+1];
               wordsL[i+1]=temp;
               
               hasSwapped=true;
              }  
         }
    }
        return wordsL;
    }
    
    public static int numVowels(String word)
    {
        int vowels=0;
        for(int x=0;x<word.length();x++){
            if(word.charAt(x)=='a' || word.charAt(x)=='e' || word.charAt(x)=='i'
                    || word.charAt(x)=='o' || word.charAt(x)=='u'
                    || word.charAt(x)=='y')
            {
                vowels++;
            }
            
        }
        return vowels;
    }
    public static int numCons(String word){
        int cons=0;
        //anything other than a vowel
        for(int x=0;x<word.length();x++){
            if(word.charAt(x)!='a' && word.charAt(x)!='e' && word.charAt(x)!='i'
                    && word.charAt(x)!='o' && word.charAt(x)!='u'
                    && word.charAt(x)!='y')
            {
                cons++;
            }  
        }
        
        return cons;
    }

}
