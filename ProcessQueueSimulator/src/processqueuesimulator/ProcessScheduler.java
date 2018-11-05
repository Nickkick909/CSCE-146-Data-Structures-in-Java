/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package processqueuesimulator;

/**
 *Nicholas Knight
 */
public class ProcessScheduler {
    private LinkedListQueue<Process> processes;
    private Process currentProcess;
    
    public ProcessScheduler(){
        this.processes=new LinkedListQueue<Process>();
        this.currentProcess=null;
    }
    public Process getCurrentProcess(){
        return this.currentProcess;
    }
    public void addProcess(Process aProcess){
        if(currentProcess==null){
            this.currentProcess=aProcess;
        }
        else{
            processes.enqueue(aProcess);
        }
            
    }
    public void runNextProcess(){
        
        currentProcess=processes.dequeue();
    }
    public void cancelCurrentProcess(){
        processes.dequeue();
    }
    public void printProcessQueue(){
        processes.print();
    }
}
