package pairmatching.enums;

public enum Level {

    ONE("래밸1"),
    TWO("래밸2"),
    THREE("래밸3"),
    FOUR("래밸4"),
    FIVE("래밸5");

    private final String name;

    private Level(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}
