/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package processqueuesimulator;

/**
 *Nicholas Knight
 */
public class Process {
    private String name;
    private double completionTime;
    
    public Process(){
        this.name="no name yet";
        this.completionTime=0.0;
    }

    public Process(String aName, double aCompletionTime) {
        setName(aName);
        setCompletionTime(aCompletionTime);
    }

    public String getName() {
        return name;
    }

    public void setName(String aName) {
        this.name = aName;
    }

    public double getCompletionTime() {
        return completionTime;
    }

    public void setCompletionTime(double aCompletionTime) {
        if(aCompletionTime>=0.0)
            this.completionTime = aCompletionTime;
        if(aCompletionTime<=0){
            this.completionTime=0;
        }
    }
    public String toString(){
        return "Name: "+this.name
                +" Completion Time: "+this.completionTime;
    }
    
}
