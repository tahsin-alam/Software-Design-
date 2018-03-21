/*
 * @Group Project: Hasibul Islam, Tashin Alam and Shakir Chowdhury
 */
//import statement
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class GameController {

    private int duration;
    private List<String> messageQueue;
    private GameGrid gg;


    public GameController() {
        try{
            gg = new GameGrid(GameGrid.MAX,GameGrid.MAX, GameGrid.MAX/2, GameGrid.MAX/2, GameGrid.MAX/2);
        }
        catch(IOException ex){
            System.out.println("ImageIcon failed to load!");
        }
        duration = 0;
        messageQueue = new ArrayList<String>();
    }


    public void Reset() {
        duration = 0;
        clearMessages();
        messageQueue.add("Reset simulation");
    }

    public void Begin() throws IOException {
        messageQueue.add("Begin simulation");
    }

    public void Exit() {
        messageQueue.add("Exit simulation");
        System.exit(0);
    }

    public List<String> getMessages() {
        return messageQueue;
    }

    public void addMessage(String s) {
        messageQueue.add(s);
    }

    public void clearMessages() {
        messageQueue.clear();
    }

    public int getDuration() {
        return this.duration;
    }

    public void setDuration(int days) {
        this.duration = days;
    }

    public void stepForward() {
        this.duration++;
    }

    public GameGrid getGameGrid() {
        return gg;
    }
}
