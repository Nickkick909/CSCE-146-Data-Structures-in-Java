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
public class Shape implements Comparable<Shape>{
    private String type;
    private double area;
    
    public Shape(){
        type="No type yet";
        area=0.0;
    }
    public Shape(String aType, double aArea){
        type=aType;
        this.setArea(aArea);
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public double getArea() {
        return area;
    }
    public void setArea(double weight) {
        if(weight>=0)
            this.area = weight;
    }
    
    public int compareTo(Shape aShape){
        if(area>aShape.area)
            return 1;
        else if(area<aShape.area)
            return -1;
        else
            return 0;
            
    }
    public String toString(){
        return this.type;
    }
    
}
