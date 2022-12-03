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
        return name + " : " + makeResultPosition();
    }

    private String makeResultPosition(){
        StringBuilder dashBuilder = new StringBuilder();
        for(int count = 0; count < position; count++){
            dashBuilder.append("-");
        }
        return dashBuilder.toString();
    }
    public int getPosition(){
        return position;
    }

    public String getName(){
        return name;
    }
}
