package baseball.view;

public class OutputView {

    private static final String STRIKE_COMMAND = "스트라이크";
    private static final String BALL_COMMAND = "볼 ";
    private static final String NOTHING = "낫싱";
    private static final String START_COMMAND = "숫자 야구 게임을 시작합니다.";
    private static final String END_COMMAND = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public void startGame(){
        System.out.println(START_COMMAND);
    }

    public void printSuccess(){
        System.out.println(END_COMMAND);
    }

    private boolean isNothing(int ball, int strike){
        return ball == 0 && strike == 0;
    }

    private boolean isOnlyStrike(int ball, int strike){
        return ball == 0;
    }


}
