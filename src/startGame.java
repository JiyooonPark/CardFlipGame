import java.io.IOException;
import java.util.ArrayList;

public class startGame {
    public static void main(String [] args) throws IOException, InterruptedException {

        hintReader hintReader = new hintReader("settings.txt");
        ArrayList<Integer> arr = hintReader.read();
        int width = arr.get(0), height=arr.get(1);
        if((width*height)%2 !=0){
            width=4;height=4;
        }
        boolean neon=true;
        if(arr.get(2)==0){
            neon=false;
        }
        else
            neon = true;


        //Thread를 사용해서 게임창은 게임창대로 작동하고 설명창은 설명창대로 작동해서 설명창이 몇초 후 꺼지게 하였습니다.
        gameManager gameManager = new gameManager(width, height,neon);
        aboutGUIThread aboutThread = new aboutGUIThread();
        gameManager.start();
        aboutThread.start();
    }
}
