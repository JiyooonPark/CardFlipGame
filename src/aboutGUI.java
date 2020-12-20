import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class aboutGUI extends JFrame {

    aboutGUI() throws IOException {
        
        //전체적인 레이아웃정하기
        setLayout(new GridLayout(2,1));
        
        //게임 방법 알려주는 패널
        JPanel panel_step = new JPanel();

        setTitle("게임 방법");
        panel_step.setBackground(new Color(199, 236, 238));
        panel_step.setLayout(new GridLayout(5, 1));
        Font f = new Font("", Font.BOLD, 17);
        JLabel steps = new JLabel("  ==========게임 방법 설명==========");
        JLabel step1 = new JLabel("  1. 카드들은 숫자별로 2장씩 있습니다.");
        JLabel step2 = new JLabel("  2. 이 두장을 찾아내는것이 플레이어의 목표입니다");
        JLabel step3 = new JLabel("  3. 두장을 눌러보고 틀리면 0.5초후에 카드가 다시 뒤집어집니다. ");
        JLabel step4 = new JLabel("  4. 카드를 모두 맞추면 메세지가 나옵니다");

        steps.setFont(f);step1.setFont(f);step2.setFont(f);step3.setFont(f);step4.setFont(f);

        panel_step.add(steps);
        panel_step.add(step1);
        panel_step.add(step2);
        panel_step.add(step3);
        panel_step.add(step4);
        
        add(panel_step);

        
        //게임 설정 방법 알려주는 패널
        JPanel panel_set = new JPanel();

        setTitle("게임 방법");
        panel_set.setBackground(new Color(246, 229, 141));
        panel_set.setLayout(new GridLayout(6, 1));
        Font f2 = new Font("", Font.BOLD, 14);
        JLabel sets = new JLabel("  ==========게임 설정 방법==========");
        JLabel set1 = new JLabel("  1. 게임의 카드수는 게임메뉴 > 설정바꾸기 에서 변경 할 수 있습니다. ");
        JLabel set1_1 = new JLabel("     + 가로 - 세로 - 네온모드 순으로 입력하면 됩니다.  ");
        JLabel set1_2 = new JLabel("     + 단, 가로x세로가 짝수여야합니다. 아닐 시 기본 4x4로 플레이됩니다.  ");
        JLabel set1_3 = new JLabel("     + 반드시 설정을 완료하신 후에 다시 게임을 시작해주세요 ");
        JLabel set2 = new JLabel("  2. 네온모드를 더 열심히 그렸습니다! (네온모드가 더 이뻐요)");

        sets.setFont(f);set1.setFont(f);set2.setFont(f);set1_1.setFont(f2);set1_2.setFont(f2);set1_3.setFont(f2);

        panel_set.add(sets);
        panel_set.add(set1);
        panel_set.add(set1_1);
        panel_set.add(set1_2);
        panel_set.add(set1_3);
        panel_set.add(set2);

        add(panel_set);
        
        //기본 설정
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        setSize(600, 600);
        setVisible(true);
    }
    public static void main(String [] args) throws IOException {
        new aboutGUI();
    }
}
