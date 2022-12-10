package pairmatching.enums;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private final String name;

    private Course(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}
