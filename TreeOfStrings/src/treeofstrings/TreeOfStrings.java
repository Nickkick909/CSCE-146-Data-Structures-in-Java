/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treeofstrings;

/**
 *
 * @author nicho
 */
public class TreeOfStrings {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        StrBSTree tree = new StrBSTree();
        System.out.println("Testing the tree"
                + "\nInserting 10 words");
        System.out.println("Inserting buzzwings");
        tree.insert("buzzwings");
        //tree.printPreOrder();
        System.out.println("Inserting ABBREVIATIONS");
        tree.insert("ABBREVIATIONS");
        //tree.printPreOrder();
        System.out.println("Inserting Cat");
        tree.insert("Cat");
        //tree.printPreOrder();
        System.out.println("Inserting food");
        tree.insert("food");
        
        System.out.println("Inserting abovementioned");
        tree.insert("abovementioned");
        
        System.out.println("Inserting ABSORBABILITIES");
        tree.insert("ABSORBABILITIES");
        
        System.out.println("Inserting VOLATILITY");
        tree.insert("VOLATILITY");
        
        System.out.println("Inserting I");
        tree.insert("I");
        //tree.printPreOrder();
        System.out.println("Inserting TWIRLIEST");
        tree.insert("TWIRLIEST");
        //tree.printPreOrder();
        System.out.println("Inserting at");
        tree.insert("at");
        
        System.out.println("Printing preorder");
        tree.printPreOrder();
        
        System.out.println("Removing the word \"food\"");
        tree.delete("food");
        tree.printPreOrder();
        
        tree.getDepth("TWIRLIEST");
        System.out.println("Done!");
    }
    
}
