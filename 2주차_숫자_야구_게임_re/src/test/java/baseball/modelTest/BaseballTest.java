package baseball.modelTest;

import baseball.model.Baseball;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class BaseballTest {

    Baseball baseball;

    @BeforeEach
    void initializeClass(){
        baseball = new Baseball();
        baseball.createPlayer("123");
    }

    @DisplayName("countStrikeWithPlayer의 결과는 0부터 3 사이이다. ")
    @Test
    void countStrikeWithPlayerTest(){
        assertThat(baseball.countStrikeWithPlayer())
                .isLessThanOrEqualTo(3)
                .isGreaterThanOrEqualTo(0);
    }

    @DisplayName("countBallWithPlayer의 결과는 0부터 3 사이이다. ")
    @Test
    void countBallWithPlayerTest(){
        assertThat(baseball.countStrikeWithPlayer())
                .isLessThanOrEqualTo(3)
                .isGreaterThanOrEqualTo(0);
    }
    @DisplayName("isThreeStrike가 거짓이면 스트라이크 값이 3이 아니다")
    @Test
    void isThreeStrikeTest(){
        assertThat((baseball.countStrikeWithPlayer() == 3)
                == baseball.isThreeStrike())
                .isTrue();
    }
}
