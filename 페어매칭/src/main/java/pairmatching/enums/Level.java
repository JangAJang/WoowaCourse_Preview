package pairmatching.enums;

public enum Level {

    ONE("레벨1"),
    TWO("레벨2"),
    THREE("레벨3"),
    FOUR("레벨4"),
    FIVE("레벨5");

    private final String name;

    private Level(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}
