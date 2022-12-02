package bridge.enums;

public enum BridgeStatus {

    UPPER(1, "U"), DOWN(0, "D");


    private int value;
    private String command;

    private BridgeStatus(int value, String command){
        this.value = value;
        this.command = command;
    }

    public int getValue(){
        return this.value;
    }

    public String getCommand(){
        return this.command;
    }
}
