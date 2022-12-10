package pairmatching.domainTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pairmatching.domain.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;
public class PairTest {

    Pair pair;

    @BeforeEach
    void initializeClass(){
        pair = new Pair(makeNames());
    }

    @DisplayName("생성시에 넣은 리스트는 순서대로 정렬되어 들어간다. ")
    @Test
    void getMembersTest(){
        assertThat(pair.getNames()).isEqualTo(makeNames()
                .stream().sorted().collect(Collectors.toList()));
    }

    @DisplayName("같은 페어인지 확인할 때, 구성요소가 전부 같을 때 참을 반환한다. ")
    @Test
    void isSamePairTest(){
        assertThat(pair.containsPair(makeNames()
                .stream().sorted().collect(Collectors.toList())))
                .isTrue();
    }

    private List<String> makeNames(){
        List<String> names  =new ArrayList<>();
        names.add("jang");
        names.add("hee");
        names.add("lee");
        return names;
    }
}
