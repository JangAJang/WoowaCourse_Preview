package pairmatching.validator;

import static pairmatching.enums.OperationCommand.QUIT;

public class InputValidator {

    public String validateOperation(String input){

    }

    private boolean isQ(String input){
        return input.equals(QUIT.getCommand());
    }
}
