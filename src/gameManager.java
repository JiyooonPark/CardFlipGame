import java.io.IOException;
import java.util.ArrayList;

//gameManager 게임을 전체적으로 메니지 하는 클래스
class gameManager extends Thread{
    int size, width, height;
    boolean neon;
    String player;

    gameManager( int width, int height, boolean neon) {
        this.width = width;
        this.height = height;
        this.neon = neon;
        size = width*height;
        this.player = player;
    }

    public void run() {
        System.out.println("======게임을 생성중입니다=======");
        System.out.println("======카드창이 나온 후 5초간만 숫자가 보이니 집중해주세요!=======");
        gameGUI myGame = null;

        try {
            myGame = new gameGUI(width, height, neon);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        
        //뭐가 눌렸는지 계속 확인한다 + 맞는걸 찾았는지 체크한다
        while(true){
            Card card1= null, card2= null;
            int card1_i=-1, card2_i=-1;
            while(card1 == null){
                for(int i=0; i<size; i++){
                    if(myGame.deck[i].fliped_now==true && i!= card2_i && !myGame.deck[i].correct) {
                        card1 = myGame.deck[i];
                        card1_i = i;
                    }
                }
            }

            while(card2 == null){
                for(int i=0; i<size; i++){
                    if(myGame.deck[i].fliped_now==true && i!= card1_i && !myGame.deck[i].correct) {
                        card2 = myGame.deck[i];
                        card2_i=i;
                    }
                }
            }

            if(card1.name.equals(card2.name)){
                System.out.println("==============맞음============");
                card1.correct=true;
                card2.correct=true;
            }
            else{
                System.out.println("==============틀림============");

                //수업시간에 배운 sleep ,안쓰면 너무 빨리 카드가 돌아가서 사용
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                card1.incorrect_choice();
                card2.incorrect_choice();
            }
            if(check_end_game(myGame)) end_game(myGame);

        }
    }


    private void end_game(gameGUI myGame) {
        myGame.end_game_thankyou();
        System.out.println("==============게임이 끝났습니다==============");
    }

    private boolean check_end_game(gameGUI myGame) {
        for(int i=0; i<size; i++){
            if(myGame.deck[i].correct==false) return false;
        }
        return true;
    }

}
