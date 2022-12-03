package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars = new ArrayList<>();
    private static final int LEAST_NUMBER = 0;
    private static final int MAX_NUMBER = 9;

    public Cars(List<String> names){
        for(String nameEach : names){
            cars.add(new Car(nameEach));
        }
    }

    public List<String> getCarsResult(){
        List<String> results = new ArrayList<>();
        for(Car carEach : cars){
            results.add(carEach.makeResult());
        }
        return results;
    }

    public List<String> getFinalWinners(){
        return new ArrayList<>();
    }

    public void moveCars(){
        for(Car carEach : cars){
            carEach.move(Randoms.pickNumberInRange(LEAST_NUMBER, MAX_NUMBER));
        }
    }
}
