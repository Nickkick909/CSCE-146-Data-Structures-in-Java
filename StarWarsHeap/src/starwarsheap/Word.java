/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package starwarsheap;

/**
 *
 * @author nicho
 */
public class Word {
    private String word;
    private int number;

    public Word(String word, int number) {
        this.setNumber(number);
        this.setWord(word);
    }
    public String getWord() {
        return word;
    }
    public void setWord(String word) {
        this.word = word;
    }
    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        if(number>=0)
            this.number = number;
    }
    public int compareTo(Word aWord){
        if(number>aWord.getNumber())
            return 1;
        else if(number< aWord.getNumber())
            return -1;
        else
            return 0;
    }
    public String toString(){
        return this.word+" "+this.number;
    }
    
}
