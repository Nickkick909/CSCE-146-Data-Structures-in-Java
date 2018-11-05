/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shapetree;

/**
 *
 * @author nicho
 */
import java.io.*;
import java.util.Scanner;
public class ShapeTree {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        BSTree tree= new BSTree();
        System.out.println("Welcome to the shape tree tester!!!!!"
                + "\nReading from file\n");
        readFile(file, tree);
        System.out.println("\nPrinting PreOrder");
        tree.printPreOrder();
        
        System.out.println("\nPrinting InOrder");
        tree.printInOrder();
        
        System.out.println("\nPrinting PostOrder");
        tree.printPostOrder();
        
        Shape max=tree.maxArea();
        System.out.println("\nThe max area is "+max.getArea());
        
        System.out.println("\nDeleting Right Triangle Side1: 5.0 Side 2: 6.0 Area: 15.0");
        Shape delete= new Shape("Right Triangle", 15.0);
        tree.delete(delete);
        System.out.println("Priting InOrder");
        tree.printInOrder();
        
        System.out.println("\nDeleting values larger than 30");
        Shape greater= new Shape("", 30.0);
        tree.deleteAreaGreater(30.0);    //this doesn't work
        System.out.println("Printing InOrder");
        tree.printInOrder();
    }
    public static final String DELIM="\t";
    public static final String file="shapeFile.txt";
    public static void readFile(String fileName, BSTree tree){
        if(fileName==null)
            return;
        try{
            
            Scanner fileScanner = new Scanner(new File(fileName));
            String fileLine= fileScanner.nextLine();
            String[] splitLines=fileLine.split(DELIM);
            //GenericTree<Fruit> tree= new GenericTree<Fruit>();
            if(splitLines.length==3){
                if(splitLines[0].equalsIgnoreCase("Rectangle")){
                    Rectangle shape= new Rectangle(splitLines[0], Integer.parseInt(splitLines[1]), Integer.parseInt(splitLines[2]), 0);
                    shape.area(shape.getSide1(),shape.getSide2());
                    tree.insert(shape);
                    System.out.println(shape);
                }
                else if(splitLines[0].equalsIgnoreCase("Right Triangle")){
                    RightTriangle shape= new RightTriangle(splitLines[0], Integer.parseInt(splitLines[1]), Integer.parseInt(splitLines[2]), 0);
                    shape.area(shape.getSide1(),shape.getSide2());
                    tree.insert(shape);
                    System.out.println(shape);
                }
                else if(splitLines[0].equalsIgnoreCase("Circle")){
                    Circle shape= new Circle(splitLines[0], Integer.parseInt(splitLines[1]), 0);
                    shape.area(shape.getRadius());
                    tree.insert(shape);
                    System.out.println(shape);
                }
                else
                    System.out.println("invalid format");
                //Shape shape= new Shape((splitLines[0]),
                //Double.parseDouble(splitLines[1]));
                //tree.insert(shape);
                
                
            }
            else{
                
                System.out.println("Not valid format");
                return;
            }
            
            while(fileScanner.hasNextLine()){
                fileLine= fileScanner.nextLine();
                splitLines=fileLine.split(DELIM);
                if(splitLines.length==3 || splitLines.length==2){
                    if(splitLines[0].equalsIgnoreCase("Rectangle")){
                        Rectangle shape= new Rectangle(splitLines[0], Integer.parseInt(splitLines[1]), Integer.parseInt(splitLines[2]), 0);
                        shape.area(shape.getSide1(),shape.getSide2());
                        tree.insert(shape);
                        System.out.println(shape);
                    }
                    else if(splitLines[0].equalsIgnoreCase("Right Triangle")){
                        RightTriangle shape= new RightTriangle(splitLines[0], Integer.parseInt(splitLines[1]), Integer.parseInt(splitLines[2]), 0);
                        shape.area(shape.getSide1(),shape.getSide2());
                        tree.insert(shape);
                        System.out.println(shape);
                    }
                    else if(splitLines[0].equalsIgnoreCase("Circle")){
                        Circle shape= new Circle(splitLines[0], Integer.parseInt(splitLines[1]), 0);
                        shape.area(shape.getRadius());
                        tree.insert(shape);
                        System.out.println(shape);
                    } 
                }
                else
                    System.out.println("invalid format");
                
        }
            fileScanner.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
        return;
    }
}
//enter area as 0 then find it later :)