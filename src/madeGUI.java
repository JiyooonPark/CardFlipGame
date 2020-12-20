import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URI;
import java.net.URISyntaxException;

public class madeGUI extends JFrame {

    madeGUI() throws URISyntaxException {

        JPanel panel = new JPanel();
        JPanel panel_info = new JPanel();

        setTitle("게임 만든이");
        panel.setBackground(new Color(186, 220, 88));
        panel.setLayout(new GridLayout(1, 2));
        panel_info.setLayout(new GridLayout(5,1));
        panel_info.setBackground(new Color(248, 165, 194));

        JLabel picture = new JLabel();
        ImageIcon img = new ImageIcon("src/img/me.jpg");
        Image newimg_java = resize(img);
        img = new ImageIcon(newimg_java);

        picture.setIcon(img);
        JLabel name = new JLabel("  박지윤");
        JLabel id = new JLabel("  1876166");
        JLabel major = new JLabel("  컴퓨터공학과");
//        JLabel github = new JLabel("  https://github.com/jiyoonpark0207");
        JButton github = new JButton("GITHUB");
        JLabel email = new JLabel("   jiyoonpark0207@gmail.com");

        final URI uri = new URI("https://github.com/jiyoonpark0207");

        github.setBackground(new Color(149, 175, 192));

        //버튼을 누르면 창을 열게 하는것입니다. 이 부분은 구글 검색을 통해 썼습니다.
        github.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (Desktop.isDesktopSupported()) {
                    Desktop desktop = Desktop.getDesktop();
                    try {
                        desktop.browse(uri);
                    } catch (Exception ex) {
                    }
                } else {
                }
            }
        });

        Font f = new Font("", Font.BOLD, 25);
        Font f2 = new Font("", Font.BOLD, 20);
        name.setFont(f);id.setFont(f);major.setFont(f);email.setFont(f2);github.setFont(f2);
        panel_info.add(name);panel_info.add(id);panel_info.add(major);panel_info.add(email);panel_info.add(github);
        panel.add(picture);
        panel.add(panel_info);
        add(panel);
        setSize(700, 350);
        setVisible(true);
    }
    private Image resize(ImageIcon img){
        Image image = img.getImage();
        Image newimg = image.getScaledInstance(350, 350,  java.awt.Image.SCALE_SMOOTH);
        return newimg;
    }
//    public static void main(String [] args) throws URISyntaxException {
//        new madeGUI();
//    }
}
