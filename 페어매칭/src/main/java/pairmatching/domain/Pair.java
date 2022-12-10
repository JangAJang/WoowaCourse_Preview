package pairmatching.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Pair {

    private final List<String> names;

    public Pair(List<String> names){
        this.names = names.stream().sorted().collect(Collectors.toList());
    }

    public List<String> getNames() {
        return names;
    }

    public boolean containsPair(List<String> names){
        int count = 0;
        for (String name : names) {
            count += countIfContains(name);
        }
        return count >= 2;
    }

    private int countIfContains(String name){
        if(names.contains(name)) return 1;
        return 0;
    }
}
