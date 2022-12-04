package vendingmachine.domainTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import vendingmachine.domain.Item;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
public class ItemTest {

    Item item;

    @BeforeEach
    void initializeClass(){
        List<String> components = new ArrayList<>();
        components.add("콜라");
        components.add("1500");
        components.add("1");
        item = new Item(components);
    }

    @DisplayName("decreaseQuantity할 때 수량이 줄어들고 0이 되면 soldOut이 참이 된다")
    @Test
    void decreaseQuantityTestSuccess(){
        item.decreaseQuantity();
        assertThat(item.isSoldOut()).isTrue();
    }

    @DisplayName("금액을 요청하면 정수형으로 생성자때의 금액이 나온다")
    @Test
    void getPriceTest(){
        assertThat(item.getPrice()).isEqualTo(1500);
    }

    @DisplayName("아이템과 같은 이름을 요청하면 참을 반환한다.")
    @Test
    void isRequestedItemTest(){
        assertThat(item.isRequestedItem("콜라")).isTrue();
    }

}
