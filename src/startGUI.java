//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.io.IOException;
//
///*
//    게임을 시작하는 GUI
//    기능 1. 기본모드로 시작할건지 메인모드로 시작할건지 정할 수 있게
//    기능 2. 최고점수를 기록할 수 있게 하기
//    기능 3. ID 입력할 수 있게
//    기능 4. 게임 크기(?) 입력할 수 있게 하기!
//*/
//
//public class startGUI extends JFrame{
//    String id;
//    static JTextField width_input, height_input, id_input;
//    int width, height;
//    boolean neon=true; //네온모드로 할건지 아닌지 선택 할 수 있게
//
//    startGUI() throws IOException, InterruptedException {
//
////        gameManager myGame = new gameManager(id,width, height, neon);
////        gameManager myGame = new gameManager("hello",4,4,true);
////        myGame.play();
//        JPanel panel = new JPanel();
//        JPanel panel_input = new JPanel(); //두개의 input을 어떻게 받을지 고민하다가 그냥 새로운 panel을 만들기로 했습니다.
//
//        setTitle("게임을 시작하세요");
//        panel.setBackground(Color.lightGray);
//        panel.setLayout(new GridLayout(4, 2));
//        JLabel player_id = new JLabel("플레이어 ID: ");
//        JLabel game_size = new JLabel("카드의 개수 ");
//        JLabel neon_label = new JLabel("테마 선택");
//        width_input = new JTextField();
//        height_input = new JTextField();
//        id_input = new JTextField();
//        JLabel inputs_list = new JLabel();
//
//        JComboBox neon_choice = new JComboBox(new String[]{"NEON MODE", "BASIC MODE"});
//        neon_choice.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//                String neon_input = (String) neon_choice.getSelectedItem();
//                if(neon_input.equals("NEON MODE")) neon=true;
//                else neon=false;
//                System.out.println(neon_input);
//
//            }
//        });
//
//        JButton start_button = new JButton("START GAME");
//        start_button.addActionListener(new ActionListener() {
//
//            @Override
//            public void actionPerformed(ActionEvent arg0) {
//                try {
//                    gameManager g = new gameManager("me",4,4,true);
//                } catch (InterruptedException | IOException e) {
//                    e.printStackTrace();
//                }
////                try {
////                    dispose();
////                    new gameGUI(4,4,true);
////                } catch (IOException e) {
////                    e.printStackTrace();
////                } catch (InterruptedException e) {
////                    e.printStackTrace();
////                }
//
////                width = Integer.parseInt(width_input.getText());
////                height = Integer.parseInt(height_input.getText());
////                id = id_input.getText();
//
//                if(width*height%2 ==0) {
//                    inputs_list.setText("게임을 시작합니다!");
//
//                    //이게 왜 안될까요?
////                    gameManager myGame = new gameManager(id,width, height, neon);
////                    gameManager myGame = new gameManager(id,2,2, neon);
////                    try {
////                        System.out.print("성공");
////                        myGame.play();
////                        System.out.print("성공");
////                    } catch (InterruptedException e) {
////                        e.printStackTrace();
////                    }
////                    gameManager myGame = new gameManager(id,width, height, neon);
////                    JFrame frame
//////                    frame.setSize(100, 100);
////                    frame.setVisible(true);
//
//                }
//                else{
//                    inputs_list.setText("곱해서 짝수가 되는 두수를 입력해주세요!!");
//                }
////                inputs_list.setText(width_input.getText() + " " + height_input.getText() + " " + id_input.getText());
//            }
//        });
//
//        panel_input.setLayout(new GridLayout(1, 2));
//
//        panel.add(player_id);
//        panel.add(id_input);
//        panel.add(game_size);
//
//        panel_input.add(width_input);
//        panel_input.add(height_input);
//        panel.add(panel_input);
//        panel.add(neon_label);
//        panel.add(neon_choice);
//        panel.add(start_button);
//        panel.add(inputs_list);
//
//
//        add(panel);
//        setSize(1000, 300);
//        setVisible(true);
//
//    }
//
//    public static void main(String [] args) throws InterruptedException, IOException {
//        new startGUI();
//    }
//}
