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
public class MinHeap {
    private Word[] heap;
    public static final int SIZE=128;
    private int lastIndex;
    public MinHeap(){
        init(SIZE);
    }
    public MinHeap(int size){
        init(size);
    }
    private void init(int size){
        if(size>0){
            heap= new Word[size];
        }
        lastIndex=0;
    }
    public void insert(Word aData){
        if(lastIndex>=heap.length)
            return; //heap is full
        heap[lastIndex]=aData;
        bubbleUp();
        lastIndex++;
    }
    private void bubbleUp(){
        int index=lastIndex;
        while(index>0 && heap[(index-1)/2].compareTo(heap[index])>0){
            //swap
            int parent= (index-1)/2;
            Word temp= heap[parent];
            heap[parent]=heap[index];
            heap[index]=temp;
            index=parent;  //go up to the parent
        }
    }
    
    public void print(){
        for(int i=0;i<lastIndex;i++){
            System.out.println(heap[i].toString());
        }
    }
    public Word remove(){
        Word retVal=heap[0];
        heap[0]=heap[lastIndex-1];//one from the first null so its last
        heap[lastIndex-1]=null;
        lastIndex--;
        bubbleDown();
        return retVal;
    }
    private void bubbleDown(){
        int index=0;
        while(index*2+1<lastIndex){
            int bigIndex= index*2+1;    //assumes left is larger
            if(index*2+2<lastIndex &&
                    heap[index*2+1].compareTo(heap[index*2+2])>0){
                bigIndex =index*2+2; //we found out the right was bigger
            }
            if(heap[index].compareTo(heap[bigIndex])>0){
                //swap
                Word temp= heap[index];
                heap[index]=heap[bigIndex];
                heap[bigIndex]=temp;
            }
            else
                break;
            index=bigIndex;
        }
    }
    public void heapSort(){
        MinHeap temp=this;
        for(int i=lastIndex; i>0;i--){
            System.out.println(this.remove());  //will print out the heap but will destroy the array
        }
    }

}


