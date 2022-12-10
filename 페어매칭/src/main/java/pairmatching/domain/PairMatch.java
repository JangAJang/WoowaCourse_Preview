package pairmatching.domain;

import pairmatching.enums.Course;
import pairmatching.enums.Level;
import pairmatching.enums.Mission;

import java.util.ArrayList;
import java.util.List;

public class PairMatch {

    private Course course;
    private Level level;
    private Mission mission;
    private Pairs pairs;

    public PairMatch(List<String> components){

    }

    public Course getCourse() {
        return course;
    }

    public Level getLevel() {
        return level;
    }

    public Mission getMission() {
        return mission;
    }

    public boolean isSame(List<String> comparator){
        return false;
    }

    public List<List<String>> createEachPair(List<String> names){
        return new ArrayList<>();
    }

    public boolean hasSamePairBefore(){
        return false;
    }

    public List<List<String>> getPairsMembers(){
        return new ArrayList<>();
    }
}
