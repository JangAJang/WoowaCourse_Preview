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

    public void printScore(int ball, int strike){
        System.out.println(makeResultStatement(ball, strike));
    }

    private String makeResultStatement(int ball, int strike){
        if(isNothing(ball, strike)) return NOTHING;
        if(isOnlyBall(strike)) return stateOnlyBall(ball);
        if(isOnlyStrike(ball)) return stateOnlyStrike(strike);
        return stateBoth(strike, ball);
    }

    private boolean isNothing(int ball, int strike){
        return ball == 0 && strike == 0;
    }

    private boolean isOnlyStrike(int ball){
        return ball == 0;
    }

    private boolean isOnlyBall(int strike){
        return strike == 0;
    }

    private String stateOnlyStrike(int strike){
        return strike + STRIKE_COMMAND;
    }

    private String stateOnlyBall(int ball){
        return ball + BALL_COMMAND;
    }

    private String stateBoth(int strike, int ball){
        return stateOnlyBall(ball) + stateOnlyStrike(strike);
    }
}
