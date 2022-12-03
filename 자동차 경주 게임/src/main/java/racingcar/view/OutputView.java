package racingcar.view;

import java.util.List;

public class OutputView {

    private static final String RESULT = "실행 결과";
    private static final String FINAL_WINNERS = "최종 우승자 : ";

    public void printStartOfResult(){
        System.out.println(RESULT);
    }

    public void printCarsPositions(List<String> results){
        StringBuilder builder = new StringBuilder();
        results.forEach(resultEach->builder
                .append(resultEach).append("\n"));
        System.out.println(builder);
    }

    public void printFinalWinners(List<String> names){
        StringBuilder namePrinter = new StringBuilder();
        names.forEach(nameEach->namePrinter.append(nameEach).append(","));
        System.out.println(FINAL_WINNERS + namePrinter.substring(0, namePrinter.length()-1));
    }
}
