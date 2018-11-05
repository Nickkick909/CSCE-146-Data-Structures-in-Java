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
public class Circle extends Shape {
    private double radius;
    public Circle(){
        super();
        this.radius=0.0;
    }
    public Circle(String aType, double aRadius,double area){
        super(aType, area);
        this.setRadius(aRadius);
    }
    public double getRadius() {
        return radius;
    }
    public void setRadius(double radius) {
        if(radius>=0)
            this.radius = radius;
    }
    public void area(double radius){
        setArea(radius*radius*Math.PI);
    }
    public String toString(){
        return super.toString()+ " Radius: "+this.radius+ " Area: "+getArea();
    }
}
