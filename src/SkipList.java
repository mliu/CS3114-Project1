import java.util.Random;

public class SkipList {
    
    private Random rnd = new Random();
    
    private int randomLevel() {
        int lev;
        for (lev = 0; rnd.nextInt(2) == 0; lev++);
        return lev;
    }
    
    
}
