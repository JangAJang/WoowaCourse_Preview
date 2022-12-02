package bridge.view;

import static bridge.enums.GameStatus.GOING;
import static bridge.enums.GameStatus.QUIT;

public class OutputView {

    private static final String FINAL_RESULT = "최종 게임 결과";
    private static final String GAME_STATUS = "게임 성공 여부: ";
    private static final String TOTAL_TRIAL = "총 시도한 횟수: ";

    public void printMap(String map) {
        System.out.println(map);
    }

    public void printFinalMap(String map){
        System.out.println(FINAL_RESULT);
        printMap(map);
    }

    public void printResult(boolean isGameQuit, int trialCount){
        System.out.println(GAME_STATUS + printGameStatus(isGameQuit));
        System.out.println(TOTAL_TRIAL + trialCount);
    }

    private String printGameStatus(boolean isGameQuit){
        if(isGameQuit) return QUIT.getStatement();
        return GOING.getStatement();
    }
}
