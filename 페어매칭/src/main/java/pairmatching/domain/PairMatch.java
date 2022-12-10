package pairmatching.domain;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.enums.Course;
import pairmatching.enums.Level;
import pairmatching.enums.Mission;
import pairmatching.validator.PairMatchValidator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PairMatch {

    private static final int COURSE_INDEX = 0;
    private static final int LEVEL_INDEX = 1;
    private static final int MISSION_INDEX = 2;
    private static final String BACK_END = "backend-crew.md";
    private static final String FRONT_END = "frontend-crew.md";

    private final Course course;
    private final Level level;
    private final Mission mission;
    private Pairs pairs;

    public PairMatch(List<String> components){
        PairMatchValidator pairMatchValidator = new PairMatchValidator();
        course = pairMatchValidator.validateCourse(components.get(COURSE_INDEX));
        level = pairMatchValidator.validateLevel(components.get(LEVEL_INDEX));
        mission = pairMatchValidator.validateMission(level.getName(), components.get(MISSION_INDEX));
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
        return course.getName().equals(comparator.get(COURSE_INDEX)) &&
                level.getName().equals(comparator.get(LEVEL_INDEX)) &&
                mission.getName().equals(comparator.get(MISSION_INDEX));
    }

    public void createEachPair(){
        createPairs(shuffleMembersOrder(getMembers()));
    }

    private List<String> getMembers(){
        if(isBackEnd()) return enlistNamesFrom(BACK_END);
        return enlistNamesFrom(FRONT_END);
    }

    private List<String> shuffleMembersOrder(List<String> members){
        return Randoms.shuffle(members);
    }

    private void createPairs(List<String> members){
        pairs = new Pairs(members);
    }

    private boolean isBackEnd(){
        return course.equals(Course.BACKEND);
    }

    private List<String> enlistNamesFrom(String resourceFileName){
        File file = new File(Objects.requireNonNull(this.getClass().getClassLoader().getResource(resourceFileName)).getFile());
        List<String> names = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            bufferedReader.lines().forEach(names::add);
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException();
        }
        return names;
    }

    public boolean hasSamePairBefore(PairMatch other){
        if(other.getLevel().equals(this.level)
                && other.getPairs().isDuplicatedPairs(this.pairs))
            return true;
        return false;
    }

    public Pairs getPairs(){
        return this.pairs;
    }

    public List<List<String>> getPairsMembers(){
        return new ArrayList<>();
    }
}
