package pairmatching.view;

import java.util.List;

public class OutputView {

    private static final String RESULT_START = "페어 매칭 결과입니다";

    public void printMatchingResult(List<List<String>> members){
        printResultStarting();
        printEachPair(members);
    }

    private void printResultStarting(){
        System.out.println(RESULT_START);
    }

    private void printEachPair(List<List<String>> member){
        for(List<String> names : member){
            printLine(appendWithSeparator(names));
        }
    }

    private void printLine(String input){
        System.out.println(input);
    }

    private String appendWithSeparator(List<String> names){
        StringBuilder builder = new StringBuilder();
        for(String name : names){
            builder.append(name).append(" : ");
        }
        return builder.substring(0, builder.length()-2);
    }
}
