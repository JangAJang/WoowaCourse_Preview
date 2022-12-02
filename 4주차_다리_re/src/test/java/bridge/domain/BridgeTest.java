package bridge.domain;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
public class BridgeTest {

    Bridge bridge;

    @BeforeEach
    void initializeClass(){
        bridge = new Bridge(List.of("U", "D", "U"));
    }

    @DisplayName("리스트를 반환하면 생성시에 들어간 리스트가 그대로 나온다. ")
    @Test
    void getBridgesTest(){
        assertThat(bridge.getBridges())
                .isEqualTo(List.of("U", "D", "U"));
    }

    @DisplayName("2번째의 값과 U를 맞는 답인지 비교하면 참이 나온다. ")
    @Test
    void isCorrectAnswerTest(){
        assertThat(bridge.isCorrectAnswer(2, "U")).isTrue();
    }
}
