/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sheepheap;

/**
 *
 * @author nicho
 */
public class SheepHeap {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MinHeap heap= new MinHeap();
        System.out.println("Adding 15 sheep to heap");
        for(int i=0; i<15; i++){
            Sheep sheep= new Sheep("sheep "+i, i);
            heap.addSheep(sheep);
    
        }
        heap.sheepRollCall();
        System.out.println("Removing 5 sheep");
        for(int i=0; i<5; i++)
            heap.removeSheep();
        heap.sheepRollCall();
        System.out.println("Sheep heap sort!!");
        heap.sheepHeapSort();
    }
}
