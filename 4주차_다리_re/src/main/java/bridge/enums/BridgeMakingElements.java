package bridge.enums;

public enum BridgeMakingElements {

    STARTER("[ "),
    FINISHER("]"),
    CORRECT("O "),
    WRONG("X "),
    EMPTY(" "),
    DIVIDER("| ");

    private String element;

    private BridgeMakingElements(String element){
        this.element = element;
    }

    public String getElement(){
        return this.element;
    }
}
