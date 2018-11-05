/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enclosing.symbol.checker;

/**
 *
 * @author nicho
 */

public class EnclosingSymbolChecker {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        CheckString checker= new CheckString();
        System.out.println("()");
        if(checker.enclosing("()"))
            System.out.println("true");
        else
            System.out.println("false");
        System.out.println("/*/**/*/");
        if(checker.enclosing("/*/**/*/"))
            System.out.println("true");
        else
            System.out.println("false");
        System.out.println("{([tacos])}");
        if(checker.enclosing("{([tacos])}"))
            System.out.println("true");
        else
            System.out.println("false");
        System.out.println("////");
        if(checker.enclosing("////"))
            System.out.println("true");
        else
            System.out.println("false");
        System.out.println("/*//");
        if(checker.enclosing("/*//"))
            System.out.println("true");
        else
            System.out.println("false");
        System.out.println("if(pass == true){/*Yay!*/;}");
        if(checker.enclosing("if(pass == true){/*Yay!*/;}"))
            System.out.println("true");
        else
            System.out.println("false");
        System.out.println("abcd");
        if(checker.enclosing("abcd"))
            System.out.println("true");
        else
            System.out.println("false");
    }
    
}

