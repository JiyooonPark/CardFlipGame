import java.io.IOException;

//������ �����ϴ� â�� thread�� �����ؼ� ������ ������ �Ͽ����ϴ�.
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
