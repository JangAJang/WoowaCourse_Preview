package pairmatching.enums;

public enum OperationCommand {

    QUIT("Q"), MATCH_PAIR("1"), READ_PAIR("2"), CLEAR("3");

    private final String command;

    private OperationCommand(String command){
        this.command = command;
    }

    public String getCommand(){
        return this.command;
    }
}
