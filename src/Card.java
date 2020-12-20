import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class Card {
    String name;
    boolean fliped_now; //fliped_now는 지금 현재 뒤집어져있는지 의미
                        //false : Java 카드가 보임 (숫자 안보임) true: 뒤집어져 있음.
    boolean correct;
    ImageIcon imgIcon, imgIcon_back;
    JLabel label;

    //생성자 오버로딩
    Card(int name, ImageIcon imgIcon, boolean neon){
        this.name = String.valueOf(name);
        fliped_now=false;
        correct=false;
        this.imgIcon = imgIcon;

        //카드 뒷면의 이미지 만들기
        if(neon==true)
            imgIcon_back = new ImageIcon("src/img/neon/background.jpg");
        else
            imgIcon_back = new ImageIcon("src/img/basic/java.jpg");
        Image newimg_java = resize(imgIcon_back);
        imgIcon_back = new ImageIcon(newimg_java);

        //초기 이미지는 앞를 향하고 있게 한다.
        label = new JLabel(this.imgIcon);

        //카드를 클릭하면 뒤집게 하기
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
//                 System.out.println("clicked");
                if(fliped_now==true && !correct){
                    flip_back();
                }
                else if(!correct){
                    flip_front();
                }
            }
        });
    }

    Card(int name, ImageIcon imgIcon, boolean neon, boolean end){
        this.name = String.valueOf(name);
        correct=true;
        this.imgIcon = imgIcon;
        label = new JLabel(imgIcon);

    }

    private Image resize(ImageIcon img){
        Image image = img.getImage();
        Image newimg = image.getScaledInstance(100, 100,  java.awt.Image.SCALE_SMOOTH);
        return newimg;
    }

    public void incorrect_choice() {
        label.setIcon(imgIcon_back);
        fliped_now=false;
        correct=false;
    }
    public void flip_front(){
        label.setIcon(imgIcon);
        fliped_now = true;
    }

    public void flip_back(){
        label.setIcon(imgIcon_back);
        fliped_now=false;
        correct = false;
    }
}