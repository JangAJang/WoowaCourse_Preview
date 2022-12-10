package pairmatching.validator;

import static pairmatching.enums.OperationCommand.*;

public class InputValidator {

    public String validateOperation(String input){

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
}
