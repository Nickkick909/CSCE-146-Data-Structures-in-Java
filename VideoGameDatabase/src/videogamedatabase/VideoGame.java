package videogamedatabase;

/**
 *Written by Nicholas Knight
 */
public class VideoGame {
    private String name;
    private String console;
    
    public VideoGame(){
        this.name="no name yet";
        this.console="no console yet";
    }

    public VideoGame(String name, String console) {
        setName(name);
        setConsole(console);
    }
    
    public String getName() {
        return name;
    }
    
    public String getConsole() {
        return console;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setConsole(String console) {
        this.console = console;
    }
    public String toString(){
        return this.name +"\t"+this.console;
    }
    
}
