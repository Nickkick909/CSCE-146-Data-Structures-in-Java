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
public class Sheep implements Comparable<Sheep>{
    private String name;
    private double weight;
    public Sheep(){
        this.name="no name";
        this.weight=0.0;
    }
    public Sheep(String aName, double aWeight){
        this.setName(aName);
        this.setWeight(aWeight);
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        if(weight>=0)
            this.weight = weight;
    }
    public int compareTo(Sheep aSheep){
        if(weight>aSheep.getWeight())
            return 1;
        else if(weight< aSheep.getWeight())
            return -1;
        else
            return 0;
    }
    public String toString(){
        return "Name: "+this.name+" Weight: "+this.weight;
    }
}
