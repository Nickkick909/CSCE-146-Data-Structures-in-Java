/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nicho
 */
public class Process implements Comparable<Process>{
    private int priority;
    private double time;
    private String name;

    public Process(){
        this.name="No name";
        this.priority=0;
        this.time=0.0;
    }
    public Process(String aName, int aP, double aTime){
        this.setName(aName);
        this.setPriority(aP);
        this.setTime(aTime);
    }
    public int getPriority() {
        return priority;
    }
    public void setPriority(int priority) {
        if(priority>=0)
            this.priority = priority;
    }
    public double getTime() {
        return time;
    }
    public void setTime(double time) {
        if(time>=0)
            this.time = time;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String toString(){
        return this.name+" "+this.priority+" "+this.time;
    }
    public int compareTo(Process aProcess){
        if(priority>aProcess.getPriority())
            return 1;
        else if(priority< aProcess.getPriority())
            return -1;
        else
            return 0;
    }
}
