import javax.swing.*;
import java.awt.*;

public class restartGUI extends JFrame {
    restartGUI(){
        JPanel p = new JPanel();
        setTitle("설정이 완료되었습니다.");
        JLabel restart1 = new JLabel("  설정이 완료되었습니다 ");
        JLabel restart2 = new JLabel("적용을 위해 다시시작해야합니다");
        JLabel restart3 = new JLabel(" !! 다시시작해주세요 !!");
        Font f = new Font("", Font.BOLD, 30);
        restart1.setFont(f);
        restart2.setFont(f);
        restart3.setFont(f);
        p.add(restart1);
        p.add(restart2);
        p.add(restart3);
        p.setBackground(new Color(196, 69, 105));
        add(p);

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        setSize(480,200);
        setVisible(true);
    }
//    public static void main(String [] args){
//        new restartGUI();
//    }
}
