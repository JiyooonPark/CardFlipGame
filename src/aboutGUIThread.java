import java.io.IOException;

//게임을 설명하는 창을 thread로 구현해서 몇초후 꺼지게 하였습니다.
public class aboutGUIThread extends Thread{
    public void run(){
        try {
            aboutGUI a =new aboutGUI();
            sleep(5000);
            a.dispose();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
