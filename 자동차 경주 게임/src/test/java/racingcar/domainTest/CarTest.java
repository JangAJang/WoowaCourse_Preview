package racingcar.domainTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import static org.assertj.core.api.Assertions.*;
public class CarTest {

    Car car;

    @BeforeEach
    void initializeClass(){
        car = new Car("hee");
    }

    @DisplayName("move에서 입력값이 4보다 크거나 같으면 position이 1증가한다.")
    @Test
    void moveTest(){
        int lastPosition = car.getPosition();
        car.move(5);
        assertThat(car.getPosition()).isEqualTo(lastPosition+1);
    }

    @DisplayName("makeResult하면 이름 : -(position만큼)이 문자열로 나온다. ")
    @Test
    void makeResultTest(){
        int lastPosition = car.getPosition();
        car.move(5);
        car.move(5);
        assertThat(car.makeResult()).isEqualTo("hee : --");
    }


}
