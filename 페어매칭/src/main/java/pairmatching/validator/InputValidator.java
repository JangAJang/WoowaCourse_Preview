package pairmatching.validator;

import pairmatching.enums.OperationCommand;

import static pairmatching.enums.OperationCommand.*;

public class InputValidator {

    private static final String NOT_RIGHT_COMMAND = "[ERROR] 종료는 Q, 페어 매칭은 1, 매칭 결과 불러오기는 2, 초기화는 3을 입력해야합니다.";

    public OperationCommand validateOperation(String input){
        if(isQ(input)) return QUIT;
        if(isPairMatch(input))return MATCH_PAIR;
        if(isReaPair(input)) return READ_PAIR;
        if(isClear(input))return CLEAR;
        return notOperationException();
    }

    private boolean isQ(String input){
        return input.equals(QUIT.getCommand());
    }

    private boolean isPairMatch(String input){
        return input.equals(MATCH_PAIR.getCommand());
    }

    private boolean isReaPair(String input){
        return input.equals(READ_PAIR.getCommand());
    }

    private boolean isClear(String input){
        return input.equals(CLEAR.getCommand());
    }

    private OperationCommand notOperationException(){
        System.out.println(NOT_RIGHT_COMMAND);
        throw new IllegalArgumentException();
    }
}
