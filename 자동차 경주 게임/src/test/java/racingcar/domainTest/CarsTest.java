package racingcar.domainTest;

import com.sun.tools.javac.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Cars;

import static org.assertj.core.api.Assertions.*;
public class CarsTest {

    Cars cars;

    @BeforeEach
    void initializeClass(){
        cars = new Cars(List.of("lee", "jang", "hee"));
    }

    @DisplayName("이동 결과를 출력할 때 출력문을 만들어 반환한다. ")
    @Test
    void getCarsResultTest(){
        assertThat(cars.getFinalWinners())
                .isEqualTo(List.of("lee : ", "jang : ", "hee : "));
    }

    @DisplayName("점수가 모두 같으면 최종 결과가 이름들의 리스트로 나온다. ")
    @Test
    void getFinalWinnerTest(){
        assertThat(cars.getFinalWinners())
                .isEqualTo(List.of("lee", "jang", "hee"));
    }
}
