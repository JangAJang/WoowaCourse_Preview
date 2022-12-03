package racingcar.view;

import java.util.List;

public class OutputView {

    private static final String RESULT = "실행 결과";

    public void printStartOfResult(){
        System.out.println(RESULT);
    }

    public void printCarsPositions(List<String> results){
        StringBuilder builder = new StringBuilder();
        results.forEach(resultEach->builder
                .append(resultEach).append("\n"));
        System.out.println(builder);
    }
}
