package bridge.enums;

public enum GameStatus {

    GOING("R", "성공"), QUIT("Q", "실패");

    private String command;
    private String statement;

    private GameStatus(String command, String statement){
        this.command = command;
        this.statement = statement;
    }

    public String getCommand(){
        return this.command;
    }

    public String getStatement(){
        return this.statement;
    }
}
