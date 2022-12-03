package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars = new ArrayList<>();

    public Cars(List<String> names){
        for(String nameEach : names){
            cars.add(new Car(nameEach));
        }
    }

    public List<String> getCarsResult(){
        return new ArrayList<>();
    }

    public List<String> getFinalWinners(){
        return new ArrayList<>();
    }

    public void moveCars(){

    }
}
