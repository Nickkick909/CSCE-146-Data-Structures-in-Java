package hotpotato;

/**
 *Nicholas Knight
 */
public class Player {
    private String name;
    
    public Player(){
        this.name="no name yet";
    }

    public Player(String aName) {
        setName(aName);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String toString(){
        return this.name;
    }
    
}
