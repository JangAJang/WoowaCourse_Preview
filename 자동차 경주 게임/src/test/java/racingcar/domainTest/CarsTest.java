package racingcar.domainTest;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Cars;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
public class CarsTest {

    Cars cars;

    @BeforeEach
    void initializeClass(){
        cars = new Cars(getNames());
    }

    @DisplayName("이동 결과를 출력할 때 출력문을 만들어 반환한다. ")
    @Test
    void getCarsResultTest(){
        assertThat(cars.getFinalWinners())
                .isEqualTo(getNames());
    }

    @DisplayName("점수가 모두 같으면 최종 결과가 이름들의 리스트로 나온다. ")
    @Test
    void getFinalWinnerTest(){
        assertThat(cars.getFinalWinners())
                .isEqualTo(getResult());
    }

    private List<String> getNames(){
        List<String> names = new ArrayList<>();
        names.add("lee");
        names.add("jang");
        names.add("hee");
        return names;
    }

    private List<String> getResult(){
        List<String> names = new ArrayList<>();
        names.add("lee : ");
        names.add("jang : ");
        names.add("hee : ");
        return names;
    }
}
