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
        return this.names.contains(names) || names.contains(this.names);
    }
}
