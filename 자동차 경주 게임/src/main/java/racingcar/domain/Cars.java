package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        cars.forEach(car -> results.add(car.makeResult()));
        return results;
    }

    public List<String> getFinalWinners(){
        return cars.stream()
                .filter(carEach-> carEach.getPosition() == getBiggestPosition())
                .map(Car::getName).collect(Collectors.toList());
    }

    private int getBiggestPosition(){
        return cars.stream().mapToInt(Car::getPosition).max().orElse(0);
    }

    public void moveCars(){
        cars.forEach(car -> car.move(Randoms
                .pickNumberInRange(LEAST_NUMBER, MAX_NUMBER)));
    }
}
