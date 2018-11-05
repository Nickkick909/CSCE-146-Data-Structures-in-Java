/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fruittree;

/**
 *Nicholas Knight
 */
import java.util.Scanner;
import java.io.*;
public class FruitTree {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        GenericTree<Fruit> tree= new GenericTree<Fruit>();
        //readFile(file, tree);
        System.out.println("Welcome to the fruit tree!"
                + "\nPopulating the tree file"
                + "\nPrinting in-order traversal");
        Fruit fruit= new Fruit("apple", 5.0);
        tree.insert(fruit);
        fruit= new Fruit("kiwi", 6.0);
        tree.insert(fruit);
        fruit= new Fruit("pinapple", 7.0);
        tree.insert(fruit);
        tree.delete(fruit);
        tree.printInOrder();
        System.out.println("Printing PreOrder");
        tree.printPreOrder();
        System.out.println("Prining PostOrder");
        tree.printPreOrder();
        System.out.println("Deleting Apple 0.4859853412170728");
        Fruit deleteApple= new Fruit("Apple", 0.4859853412170728);
        tree.delete(deleteApple);
        tree.printPreOrder();
        
    }
    public static final String DELIM="\t";
    public static final String file="fruitFile.txt";
    public static void readFile(String fileName, GenericTree<Fruit> tree){
        if(fileName==null)
            return;
        try{
            Scanner fileScanner = new Scanner(new File(fileName));
            String fileLine= fileScanner.nextLine();
            String[] splitLines=fileLine.split(DELIM);
            //GenericTree<Fruit> tree= new GenericTree<Fruit>();
            if(splitLines.length==2){
                Fruit fruit= new Fruit((splitLines[0]),
                Double.parseDouble(splitLines[1]));
                tree.insert(fruit);
            }
            else{
                return;
            }

            while(fileScanner.hasNextLine()){
                fileLine= fileScanner.nextLine();
                splitLines=fileLine.split(DELIM);
                if(splitLines.length==2){
                    String type=splitLines[0];
                    double weight=Double.parseDouble(splitLines[1]);
                    Fruit fruit=new Fruit(type, weight);
                    tree.insert(fruit);
                }
        }
            fileScanner.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
        return;
    }
}

