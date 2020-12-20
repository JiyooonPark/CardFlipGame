import java.io.IOException;

//게임창을 thread로 사용하기 위해
public class gameGUIThread extends Thread{
    int width, height;
    boolean neon;

    gameGUIThread(int width, int height, boolean neon){
        this.width = width;
        this.height=height;
        this.neon = neon;
    }
    public void run(){
        try {
            gameGUI myGame = new gameGUI(width, height, neon);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
