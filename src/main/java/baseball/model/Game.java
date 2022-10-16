package baseball.model;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashMap;

public class Game {

    private static int LENGTH_LIMIT = 3;
    private static final String BALL_SIGN = "볼 ";
    private static final String STRIKE_SIGN = "스트라이크";
    private static final String NOTHING = "포볼";
    private static final String EXIT_CODE = "2";
    private static final String CLEAR_SENTENCE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String EXIT_SENTENCE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private int[] player;
    private HashMap<Integer, Integer> computer;
    private boolean finished = false;

    private int strike = 0;
    private int ball = 0;

    public Game(){}

    public void startGame(){
        Number playerNumber = new Number();
        Number computerNumber = new Number();
        computer = new HashMap<>();
        computerNumber.createRandomNumber();
        saveComputerNumber(computerNumber.getNumbers());
        while(!finished){
            playerNumber.getNumbersFromPlayer();
            player = playerNumber.getNumbers();
            resetScore();
            calculateScore();
            printResult();
            if(strike == LENGTH_LIMIT) askForAnotherGame();
        }
    }

    public void saveComputerNumber(int[] computerNumber){
        for(int i=0; i<LENGTH_LIMIT; i++){
            computer.put(i, computerNumber[i]);
        }
    }

    private void askForAnotherGame(){
        System.out.println(EXIT_SENTENCE);
        String code = Console.readLine();
        if(code.equals(EXIT_CODE)) finished = true;
    }

    private void resetScore(){
        this.strike = 0;
        this.ball = 0;
    }

    private void calculateScore(){
        for(int i=0; i<LENGTH_LIMIT; i++){
            checkStrikeOrBall(i);
        }
    }

    private void checkStrikeOrBall(int index){
        if(computer.containsValue(player[index])){
            if(computer.get(index) == player[index]) strike++;
            else ball++;
        }
    }

    private void printResult(){
        System.out.println(getResultString());
        if(strike == LENGTH_LIMIT) System.out.println(CLEAR_SENTENCE);
    }

    private String getResultString(){
        if(strike == 0 && ball == 0) return NOTHING;
        StringBuilder sb = new StringBuilder();
        if(ball > 0) sb.append(ball).append(BALL_SIGN);
        if(strike > 0) sb.append(strike).append(STRIKE_SIGN);
        return sb.toString();
    }

}
