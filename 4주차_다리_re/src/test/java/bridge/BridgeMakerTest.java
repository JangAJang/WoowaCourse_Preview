package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class BridgeMakerTest {

    BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    @DisplayName("사이즈만큼 생성하면 사이즈만큼의 문자열 리스트가 생성된다. ")
    @Test
    void makeBridgeTest(){
        assertThat(bridgeMaker.makeBridge(3).size()).isEqualTo(3);
    }
    @DisplayName("사이즈만큼 생성하면 원소는 U, D로 이루어져 있다. ")
    @Test
    void makeBridgeElementTest(){
        assertThat(bridgeMaker.makeBridge(10).containsAll(List.of("U", "D"))).isTrue();
    }
}
