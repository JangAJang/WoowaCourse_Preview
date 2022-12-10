package pairmatching.validator;

import pairmatching.enums.Course;
import pairmatching.enums.Level;

import static pairmatching.enums.Course.BACKEND;
import static pairmatching.enums.Course.FRONTEND;
import static pairmatching.enums.Level.*;

public class PairMatchValidator {

    private static final String NOT_RIGHT_COURSE = "[ERROR] 입력한 코스가 존재하지 않습니다.";
    private static final String NO_MISSION_FOR_LEVEL = "[ERROR] 해당 레벨에는 미션이 존재하지 않습니다.";
    private static final String NOT_RIGHT_LEVEL = "[ERROR] 해당 레벨이 존재하지 않습니다.";

    public Course validateCourse(String name){
        if(isBackEnd(name)) return BACKEND;
        if(isFrontEnd(name)) return FRONTEND;
        System.out.println(NOT_RIGHT_COURSE);
        throw new IllegalArgumentException();
    }

    private boolean isBackEnd(String name){
        return name.equals(BACKEND.getName());
    }

    private boolean isFrontEnd(String name){
        return name.equals(FRONTEND.getName());
    }

    private Level validateLevel(String level){
        if(isLevelOne(level)) return ONE;
        if(isLevelTwo(level)) return TWO;
        if(isLevelFour(level)) return FOUR;
        if(isLevelThreeOrFive(level)) noMissionForLevelException();
        return notRightLevelException();
    }

    private boolean isLevelOne(String level){
        return level.equals(ONE.getName());
    }

    private boolean isLevelTwo(String level){
        return level.equals(TWO.getName());
    }

    private boolean isLevelFour(String level){
        return level.equals(FOUR.getName());
    }

    private boolean isLevelThreeOrFive(String level){
        return level.equals(THREE.getName()) ||
                level.equals(FIVE.getName());
    }

    private void noMissionForLevelException(){
        System.out.println(NO_MISSION_FOR_LEVEL);
        throw new IllegalArgumentException();
    }

    private Level notRightLevelException(){
        System.out.println(NOT_RIGHT_LEVEL);
        throw new IllegalArgumentException();
    }
}
