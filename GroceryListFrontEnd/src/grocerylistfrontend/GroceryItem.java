/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grocerylistfrontend;

/**
 * Written by Nicholas Knight
 */
public class GroceryItem {
 private String name;
 private double value;

    public GroceryItem() {
        this.name = "no name yet";
        this.value = 0.0;
    }

    public GroceryItem(String name, double value) {
        setName(name);
        setValue(value);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        if(value>=0)
            this.value = value;
    }
    
    public String toString(){
        return "Name: "+this.name+ " Value: " +this.value;
    }
    public boolean equals(GroceryItem item){
        return item!=null &&
                this.name.equals(item.getName()) &&
                this.value==item.getValue();
    }
    
    
    
 
 
}
