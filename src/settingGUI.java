import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class settingGUI extends JFrame{
    static JTextField width_input, height_input;
    int width, height;
    boolean neon; //네온모드로 할건지 아닌지 선택 할 수 있게

    settingGUI() throws IOException {

        JPanel panel = new JPanel();
        JPanel panel_input = new JPanel(); //두개의 input을 어떻게 받을지 고민하다가 그냥 새로운 panel을 만들기로 했습니다.

        setTitle("게임 설정 창");
        panel.setBackground(new Color(247, 215, 148));
        panel.setLayout(new GridLayout(3, 2));
        Font f = new Font("", Font.BOLD, 18);
        JLabel game_size = new JLabel("  카드의 개수 ");
        JLabel neon_label = new JLabel("  테마 선택");
        game_size.setFont(f);neon_label.setFont(f);
        width_input = new JTextField();
        height_input = new JTextField();
        
        JLabel inputs_list = new JLabel();

        hintWriter hWriter = new hintWriter("settings.txt");

        JComboBox neon_choice = new JComboBox(new String[]{"NEON MODE", "BASIC MODE"});
        neon_choice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String neon_input = (String) neon_choice.getSelectedItem();
                if(neon_input.equals("NEON MODE")) {
                    neon = true;
                }
                else {
                    neon = false;
                }
                System.out.println(neon_input);

            }
        });

        JButton start_button = new JButton("설정완료");
        start_button.setFont(f);
        start_button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {

                width = Integer.parseInt(width_input.getText());
                height = Integer.parseInt(height_input.getText());

                if(width*height%2 ==0) {
                    //file에 쓰기
                    try {
                        hWriter.add(String.valueOf(width));
                        hWriter.add(String.valueOf(height));
                        if(neon)
                            hWriter.add(String.valueOf(1));
                        else
                            hWriter.add(String.valueOf(0));
                        hWriter.add("end");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    inputs_list.setText("게임을 다시 시작해주세요");
                    dispose();
                    new restartGUI();

                }
                else{
                     System.out.println("4x4 -네온모드 로 설정됨");
                    try {
                        hWriter.add(String.valueOf(4));
                        hWriter.add(String.valueOf(4));
                        if(neon)
                            hWriter.add(String.valueOf(1));
                        else
                            hWriter.add(String.valueOf(0));
                        hWriter.add("end");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    dispose();
                }
            }
        });

        panel_input.setLayout(new GridLayout(1, 2));

        panel.add(game_size);

        panel_input.add(width_input);
        panel_input.add(height_input);
        panel.add(panel_input);
        panel.add(neon_label);
        panel.add(neon_choice);
        panel.add(start_button);
        panel.add(inputs_list);

        add(panel);

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        setSize(400, 300);
        setVisible(true);

    }

//    public static void main(String [] args) throws InterruptedException, IOException {
//        new settingGUI();
//    }
}
