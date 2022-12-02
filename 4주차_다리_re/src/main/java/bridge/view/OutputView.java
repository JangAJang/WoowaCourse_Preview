package bridge.view;

public class OutputView {

    private static final String FINAL_RESULT = "최종 게임 결과";

    public void printMap(String map) {
        System.out.println(map);
    }

    public void printFinalMap(String map){
        System.out.println(FINAL_RESULT);
        printMap(map);
    }

    public void printResult() {
    }
}
