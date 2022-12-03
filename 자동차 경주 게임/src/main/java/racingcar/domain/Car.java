package racingcar.domain;

public class Car {
    private final String name;
    private int position = 0;
    private static final int MOVING_REQUIREMENT = 4;

    public Car(String name) {
        this.name = name;
    }

    public void move(int value){
        if(isAbleToMove(value)) position++;
    }

    private boolean isAbleToMove(int value){
        return value >= MOVING_REQUIREMENT;
    }

    public String makeResult(){
        return null;
    }
    public int getPosition(){
        return position;
    }
}
