package fruittree;

/**
 *Nicholas Knight
 */
public class Fruit implements Comparable<Fruit>{
    private String type;
    private double weight;
    
    public Fruit(){
        type="No type yet";
        weight=0.0;
    }
    public Fruit(String aType, double aWeight){
        this.setType(aType);
        this.setWeight(aWeight);
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        if(weight>0.0)
            this.weight = weight;
    }
    public int compareTo(Fruit aFruit){
        if(aFruit.weight< weight)
            return 1;
        else if(aFruit.weight>weight)
            return -1;
        else
            return 0;
    }
    public String toString(){
        return this.type +" " +this.weight;
    }
}
