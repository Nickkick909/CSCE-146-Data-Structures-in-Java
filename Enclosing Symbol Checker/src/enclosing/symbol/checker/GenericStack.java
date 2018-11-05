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
public class GenericStack <T> {
 private T[] stack;
    public static final int DEF_SIZE=100;
    private int headIndex;
    public GenericStack(){
        init(DEF_SIZE);
    }
    public GenericStack(int size){
        init(size);
    }
    public void init(int size){
        if(size<=0)
            return;
        stack=(T[])(new Object[size]);
        headIndex=0;
    }
    public void push(T aData){
        if(headIndex>=stack.length)
            return;
        stack[headIndex]=aData;
        headIndex++;
    }
    public T pop(){
        if(headIndex==0)
            return null;    //stack is empty
        headIndex--;        //not erased just seems like its gone and will be overwritten is added to slot
        return stack[headIndex];
    }
    public T peek(){
        if(headIndex<=0)
            return null;
        return stack[headIndex-1];  //head index is first null so -1 for first not null
    }
    public void print(){
        for(int i=headIndex;i>=0;i--){      //have to go backwards so its in right order
            System.out.println(stack[i]);
        }
    }   
}
