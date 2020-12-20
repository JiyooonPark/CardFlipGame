import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class hintGUI extends JFrame {
    int width, height,size;
    boolean neon=true; //네온모드로 할건지 아닌지 선택 할 수 있게

    Card deck[];

    ImageIcon imgIcon[] = new ImageIcon[20];
    ImageIcon imgIcon_back;

    //파일로부터 힌트를 읽어오기위한 용도
    hintReader hReader = new hintReader("hint.txt");

    hintGUI(boolean neon) throws IOException {
        ArrayList<Integer> arr = hReader.read();
        this.width = arr.remove(0);
        this.height = arr.remove(0);
        size = width*height;
        this.neon = neon;

        deck = new Card[size];

        //타이틀을 설정
        setTitle("답안창!");

        JPanel card_panel=new JPanel();
        card_panel.setBackground(new Color(209, 204, 192));
//        card_panel.setBackground(new Color(120, 111, 166));

        //레이아웃 설정
        card_panel.setLayout(new GridLayout(height, width));

        //이미지 효율적으로 사용하기 위해 배열에 넣음
        //리사이징 + 이미지 넣기
        for(int i=0; i<20; i++){
            if(neon == true)
                imgIcon[i] = new ImageIcon("src/img/neon/"+(i+1)+".jpg");
            else
                imgIcon[i] = new ImageIcon("src/img/basic/"+(i+1)+".jpg");
            Image newimg = resize(imgIcon[i]);
            imgIcon[i] = new ImageIcon(newimg);
        }
        
        //파일에서 읽어온대로 그대로 다시 넣기
        for(int i=0; i<size/2; i++){
            int a=arr.remove(0), b=arr.remove(0), c=arr.remove(0);
            deck[a] = new Card(c, imgIcon[c], neon, true);
            deck[b] = new Card(c, imgIcon[c], neon, true);
        }

        //deck배열에 있는 것들을 프레임에 추가합니다.
        for(int i=0; i<size; i++){
            card_panel.add(deck[i].label);
        }
        add(card_panel);

        setSize((2+width)*100, (2+height)*100);
        setVisible(true);
        System.out.println("카드들 추가 완료");

    }

    //제가 그린 그림이 너무 커서 리사이징이 필요합니다.
    private Image resize(ImageIcon img){
        Image image = img.getImage();
        Image newimg = image.getScaledInstance(100, 100,  java.awt.Image.SCALE_SMOOTH);
        return newimg;
    }

//    public static void main(String [] args) throws IOException {
//        new hintGUI(true);
//    }
}
