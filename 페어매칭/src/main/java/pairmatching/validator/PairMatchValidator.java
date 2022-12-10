package pairmatching.validator;

import pairmatching.enums.Course;
import pairmatching.enums.Level;

import static pairmatching.enums.Course.BACKEND;
import static pairmatching.enums.Course.FRONTEND;
import static pairmatching.enums.Level.ONE;
import static pairmatching.enums.Level.TWO;

public class PairMatchValidator {

    private static final String NOT_RIGHT_COURSE = "[ERROR] 입력한 코스가 존재하지 않습니다.";

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

    }

    private boolean isLevelOne(String level){
        return level.equals(ONE.getName());
    }

    private boolean isLevelTwo(String level){
        return level.equals(TWO.getName());
    }
}
