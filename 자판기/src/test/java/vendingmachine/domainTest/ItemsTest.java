package vendingmachine.domainTest;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import vendingmachine.domain.Items;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
public class ItemsTest {

    Items items;

    @BeforeEach
    void initializeClass(){
        List<List<String>> components = new ArrayList<>();
        components.add(component1());
        components.add(component2());
        components.add(component3());
        items = new Items(components);
    }

    @DisplayName("특정 아이템을 고르면 그 아이템의 개수가 1감소하고 금액을 반환한다.")
    @Test
    void takeSpecificTest(){
        assertThat(items.takeSpecificItem("콜라"))
                .isEqualTo(1500);
    }

    @DisplayName("품목이 이미 0개라면 구매시도시 예외처리한다.")
    @Test
    void cannotBuyExceptionTest(){
        items.takeSpecificItem("콜라");
        assertThatThrownBy(()->items.takeSpecificItem("콜라"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매 품목이 없는 상품이면 예외처리된다.")
    @Test
    void noNameExceptionTest(){
        assertThatThrownBy(()->items.takeSpecificItem("우유"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("가장 싼 품목의 금액을 확인 할 때, 구매 가능품목중 가장 싼 값을 반환한다.")
    @Test
    void getCheapestItemTest(){
        assertThat(items.getCheapestItem())
                .isEqualTo(500);
    }

    private List<String> component1(){
        List<String> components = new ArrayList<>();
        components.add("콜라");
        components.add("1500");
        components.add("1");
        return components;
    }

    private List<String> component2(){
        List<String> components = new ArrayList<>();
        components.add("사이다");
        components.add("2000");
        components.add("0");
        return components;
    }

    private List<String> component3(){
        List<String> components = new ArrayList<>();
        components.add("요구르트");
        components.add("500");
        components.add("3");
        return components;
    }
}
