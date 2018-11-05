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
public class RightTriangle extends Shape{
    private double side1;
    private double side2;
    public RightTriangle(){
        super();
        side1=0.0;
        side2=0.0;                
    }
    public RightTriangle(String aType, double S1, double S2, double area){
        super(aType, area);
        this.setSide1(S1);
        this.setSide2(S2);
    }
    public double getSide1() {
        return side1;
    }
    public void setSide1(double side1) {
        if(side1>=0.0)
            this.side1 = side1;
    }
    public double getSide2() {
        return side2;
    }
    public void setSide2(double side2) {
        if(side2>=0.0)
            this.side2 = side2;
    }
    public void area(double side1, double side2){
       setArea((side1*side2)/2.0);
    }
    public String toString(){
        return super.toString() + " Side 1: "+this.side1+ " Side 2: "+this.side2+ " Area: "+getArea();
    }
}
