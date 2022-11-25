package baseball.domainTest;

import baseball.domain.RandomNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
public class RandomNumbersTest {

    RandomNumbers randomNumbers = new RandomNumbers();

    @DisplayName("스트라이크 카운트를 할 때 값은 항상 0에서 3사이 이다. ")
    @Test
    void countStrikeTest(){
        assertThat(randomNumbers.countStrike(List.of(1, 2, 3)))
                .isLessThanOrEqualTo(3)
                .isGreaterThanOrEqualTo(0);
    }
    @DisplayName("볼 카운트를 할 때 값은 항상 0에서 3사이 이다. ")
    @Test
    void countBallTest(){
        assertThat(randomNumbers.countStrike(List.of(1, 2, 3)))
                .isLessThanOrEqualTo(3)
                .isGreaterThanOrEqualTo(0);
    }
}
