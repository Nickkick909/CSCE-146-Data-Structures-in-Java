package hotpotato;

/**
 *Nicholas Knight
 */
import java.util.Random;
public class Potato {
    private int time;
    
    public Potato(){
        Random r =new Random();
        time=r.nextInt(180);
    }
    public int getTime(){
        return this.time;
    }
    
}
