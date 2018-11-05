/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nicho
 */
public class ProcessHeap{
    private Process[] heap;
    public static final int SIZE=128;
    private int lastIndex;
    public ProcessHeap(){
        init(SIZE);
    }
    public ProcessHeap(int size){
        init(size);
    }
    private void init(int size){
        if(size>0){
            heap= new Process[size];
        }
        lastIndex=0;
    }
    public void insert(Process aData){
        if(lastIndex>=heap.length)
            return; //heap is full
        heap[lastIndex]=aData;
        bubbleUp();
        lastIndex++;
    }
    private void bubbleUp(){
        int index=lastIndex;
        while(index>0 && heap[(index-1)/2].compareTo(heap[index])<0){
            //swap
            Process temp= heap[(index-1)/2];
            heap[(index-1)/2]=heap[index];
            heap[index]=temp;
            index=(index-1)/2;  //go up to the parent
        }
    }
    public Process remove(){
        Process retVal=heap[0];
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
                    heap[index*2+1].compareTo(heap[index*2+2])<0){
                bigIndex =index*2+2; //we found out the right was bigger
            }
            if(heap[index].compareTo(heap[bigIndex])<0){
                //swap
                Process temp= heap[index];
                heap[index]=heap[bigIndex];
                heap[bigIndex]=temp;
            }
            else
                break;
        }
    }
    public void heapSort(){
        for(int i=0; i<lastIndex;i++){
            System.out.println(this.remove());  //will print out the heap but will destroy the array
        }
    }
    public void printHeap(){
        for(int i=0;i<lastIndex;i++){
            System.out.println(heap[i].toString());
        }
    }
    public boolean isEmpty(){
        if(lastIndex==0)
            return true;
        else
            return false;
    }
    public Process peak(){
        return heap[0];
    }
}
