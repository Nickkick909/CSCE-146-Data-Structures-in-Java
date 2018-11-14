/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package starwarsheap;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author nicho
 */
public class StarWarsHeap {

    /**
     * @param args the command line arguments
     */
    public static final String FILE= "StarWarsNewHopeScript.txt";
    public static void main(String[] args) {
        // TODO code application logic here
        MinHeap heap= new MinHeap();
        int force=0;
        int wookie=0;
        int jabba=0;
        int lightsaber=0;
        int skywalker=0;
        int tatooine=0;
        int bantha=0;
        int wedge=0;
        int deathStar=0;
        if(FILE==null)
            return;
        try{

            Scanner fileScanner=new Scanner(new File(FILE));
            fileScanner=new Scanner(new File(FILE)); //reset scanner
            
            while(fileScanner.hasNext()){
                String fileLine=fileScanner.next(); //read
                fileLine=fileLine.toLowerCase();
                if(fileLine.contains("force"))
                    force++;
                if(fileLine.contains("wookie"))
                    wookie++;
                if(fileLine.contains("jabba"))
                    jabba++;
                if(fileLine.contains("lightsaber"))
                    lightsaber++;
                if(fileLine.contains("skywalker"))
                    skywalker++;
                if(fileLine.contains("tatooine"))
                    tatooine++;
                if(fileLine.contains("bantha"))
                    bantha++;
                if(fileLine.contains("wedge"))
                    wedge++;
                if(fileLine.contains("death"))
                    if(fileScanner.next().toLowerCase().contains("star"))
                        deathStar++;
            }
            fileScanner.close();     
        }
        catch(Exception e){
            System.out.println(e);
        } 
        
        Word word= new Word("force", force);
        heap.insert(word);
        word= new Word("wookie", wookie);
        heap.insert(word);
        word= new Word("jabba", jabba);
        heap.insert(word);
        word= new Word("lightsaber", lightsaber);
        heap.insert(word);
        word= new Word("skywalker", skywalker);
        heap.insert(word);
        word= new Word("tatooine", tatooine);
        heap.insert(word);
        word= new Word("bantha", bantha);
        heap.insert(word);
        word= new Word("wedge", wedge);
        heap.insert(word);
        word= new Word("death star", deathStar);
        heap.insert(word);
        
        heap.heapSort();
    }
    
}
