package bridge.domain;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
public class BridgeConstructorTest {

    BridgeConstructor bridgeConstructor = new BridgeConstructor();

    @DisplayName("입력 리스트 두개를 통해 결과를 반환한다. ")
    @Test
    void constructBridgeTest(){
        List<String> bridge = List.of("U", "D", "U");
        List<Boolean> answers = List.of(true, true, true);
        assertThat(bridgeConstructor.constructBridges(bridge, answers))
                .isEqualTo("[ O | O | O ]\n[   |   |   ]");
    }
}
