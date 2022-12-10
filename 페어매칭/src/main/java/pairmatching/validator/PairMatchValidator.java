package pairmatching.validator;

import pairmatching.enums.Course;

import static pairmatching.enums.Course.BACKEND;
import static pairmatching.enums.Course.FRONTEND;

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
}
