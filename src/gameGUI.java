import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

import static java.lang.Thread.sleep;

//game을 하는 GUI
public class gameGUI extends JFrame implements ActionListener{
    
    //수업시간에 배우지 않은 새로운 컴포넌트 추가
    JMenuBar mb;
    JMenu menu,help,hints;
    JMenuItem replay, about, made, answer,setting;

    //게임관련 변수들
    int size, width, height;
    boolean neon;
    Card deck[];

    ImageIcon imgIcon[] = new ImageIcon[20];
    ImageIcon imgIcon_back;

    //hint관련
    hintWriter hWriter = new hintWriter("hint.txt");

    gameGUI(int width, int height, boolean neon) throws IOException, InterruptedException {

        this.width = width;
        this.height = height;
        size = width*height;
        this.neon = neon;
        hWriter.add(this.width+"-"+this.height);

        deck = new Card[size];
        Font f = new Font("", Font.BOLD, 15);

        //타이틀을 설정
        setTitle("같은 카드를 맞추는 게임");

        JPanel card_panel=new JPanel();
        if(neon){
//            card_panel.setBackground(new Color(71, 71, 135));
//            card_panel.setBackground(new Color(64, 64, 122));
            card_panel.setBackground(new Color(64, 64, 122));
//            card_panel.setBackground(Color.BLACK);
        }
        else{
            card_panel.setBackground(new Color(34, 112, 147));
        }

        //메뉴바 설정하기
        replay =new JMenuItem("다시 다 뒤집기");
        about =new JMenuItem("게임 설명 다시 보기");

        answer =new JMenuItem("정답 보기");

        made =new JMenuItem("만든이");
        setting =new JMenuItem("설정 바꾸기");

        replay.addActionListener(this);
        about.addActionListener(this);

        answer.addActionListener(this);

        made.addActionListener(this);
        setting.addActionListener(this);

        mb=new JMenuBar();
        replay.setFont(f);
        answer.setFont(f);about.setFont(f);made.setFont(f);setting.setFont(f);

        menu=new JMenu("게임 메뉴");
        hints = new JMenu("힌트 관련");
        help=new JMenu("도움말");
        menu.setFont(f);help.setFont(f);hints.setFont(f);
        menu.add(replay);menu.add(setting);
        hints.add(answer);
        help.add(about);help.add(made);

        mb.add(menu);mb.add(hints);mb.add(help);
        add(mb);
        setJMenuBar(mb);

        //레이아웃 설정
        card_panel.setLayout(new GridLayout(height, width));

        //카드 뒷면의 이미지 만들기
        if(neon==true)
            imgIcon_back = new ImageIcon("src/img/neon/background.jpg");
        else
            imgIcon_back = new ImageIcon("src/img/basic/java.jpg");
        Image newimg_java = resize(imgIcon_back);
        imgIcon_back = new ImageIcon(newimg_java);

        //카드 앞면의 이미지 만들기 : 리사이징 + 이미지 넣기
        for(int i=0; i<20; i++){
            if(neon == true)
                imgIcon[i] = new ImageIcon("src/img/neon/"+(i+1)+".jpg");
            else
                imgIcon[i] = new ImageIcon("src/img/basic/"+(i+1)+".jpg");
            Image newimg = resize(imgIcon[i]);
            imgIcon[i] = new ImageIcon(newimg);
        }

        //card들을 클릭하면 뒤집어지게 하기 위해서 JLabel로 구현했습니다.
        JLabel card_labels[] = new JLabel[size];

        //JAVA 컬렉션중 ArrayList를 사용했습니다. 카드들을 배치하기위해 사용할 리스트들입니다.
        ArrayList<Integer> used = new ArrayList<>();
        ArrayList<Integer> used_cards = new ArrayList<>();

        //이 for loop 안에서는 1-20까지의 숫자중 무작위로 사이즈/2만큼을 선택하여 deck 배열에 넣습니다.
        for(int i=0; i<size/2; i++){

            int j1;
            while(true){
                j1= (int) (Math.random()*size)%(size+1);
                if (!used.contains(j1)) {
                    used.add(j1);
                    break;
                }
            }

            int k;
            while(true){
                k = (int) (Math.random()*20);
                if (!used_cards.contains(k)) {
                    used_cards.add(k);
                    break;
                }
            }

            int j2;
            while(true){
                j2= (int) (Math.random()*size)%(size+1);
                if (!used.contains(j2)) {
                    used.add(j2);
                    break;
                }
            }
//            System.out.println(j1+ "   "+ j2);
            deck[j1] = new Card(k, imgIcon[k], neon);
            deck[j2] = new Card(k, imgIcon[k], neon);
//            System.out.println(j1+","+j2+","+k);
            hWriter.add(j1+"-"+j2+"-"+k);

        }
        hWriter.add("end");

        //deck배열에 있는 것들을 프레임에 추가합니다.
        for(int i=0; i<size; i++){
//            System.out.println(deck[i].name);
            card_panel.add(deck[i].label);
        }
        add(card_panel);
//        System.out.println("카드들 추가 완료");

        //기본 설정
        setSize((2+width)*100, (2+height)*100);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        setVisible(true);
        sleep(3000);
        redo();
//        System.out.println("카드들 추가 완료");
    }


    //제가 그린 그림이 너무 커서 리사이징이 필요합니다.
    private Image resize(ImageIcon img){
        Image image = img.getImage();
        Image newimg = image.getScaledInstance(100, 100,  java.awt.Image.SCALE_SMOOTH);
        return newimg;
    }

    //게임이 끝났을 때 성공메세지로 바뀌는 기능 추가!
    public void end_game_thankyou() {
        ImageIcon imgIcon_ty[]= new ImageIcon[12];
        
        //사이즈별로 다르게 해야함 (12 이상이여야만 전체 출력 미만이면 하트만 출력
        if(size >= 12) {
            for (int i = 0; i < 12; i++) {
                if (neon == true)
                    imgIcon_ty[i] = new ImageIcon("src/img/neon/ty/ty_neon_" + (i + 1) + ".jpg");
                else
                    imgIcon_ty[i] = new ImageIcon("src/img/basic/ty/ty_" + (i + 1) + ".jpg");
                Image newimg = resize(imgIcon_ty[i]);
                imgIcon_ty[i] = new ImageIcon(newimg);
                deck[i].label.setIcon(imgIcon_ty[i]);
                deck[i].correct=true;
//                deck[i] = new Card(i, imgIcon_ty[i], neon, true);
            }
            for (int i = 12; i < size; i++) {
                deck[i].label.setIcon(imgIcon_ty[11]);
                deck[i].correct=true;
//                deck[i] = new Card(i, imgIcon_ty[i], neon, true);
            }
        }
        else{
//            System.out.print("else");
            if (neon == true)
                imgIcon_ty[0] = new ImageIcon("src/img/neon/ty/ty_neon_" + 12 + ".jpg");
            else
                imgIcon_ty[0] = new ImageIcon("src/img/basic/ty/ty_" + 12 + ".jpg");
            Image newimg = resize(imgIcon_ty[0]);
            imgIcon_ty[0] = new ImageIcon(newimg);
            for(int i=0; i<size; i++){
                deck[i].label.setIcon(imgIcon_ty[0]);
                deck[i].correct=true;
//                deck[i] = new Card(12, imgIcon_ty[0], neon, true);
            }

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== replay) {
            redo();
            System.out.println("다시 다 뒤집기");
        }
        if(e.getSource() == answer) {
            System.out.println("답안창 열기");
            try {
                new hintGUI(neon);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }

        if(e.getSource()== made) {
            System.out.println("만든이 보여주기");
            try {
                new madeGUI();
            } catch (URISyntaxException uriSyntaxException) {
                uriSyntaxException.printStackTrace();
            }
        }
        if(e.getSource()== about) {
            System.out.println("게임에 대해");
            try {
                new aboutGUI();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        if(e.getSource()== setting) {
            System.out.println("게임 설정 창");
            try {
                new settingGUI();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }

    private void redo() {

        for(int i=0; i<size;i++){
            deck[i].flip_back();
        }
    }

}




