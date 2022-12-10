package pairmatching.validator;

import pairmatching.enums.Course;

import static pairmatching.enums.Course.BACKEND;

public class PairMatchValidator {

    public Course validateCourse(String name){

    }

    private boolean isBackEnd(String name){
        return name.equals(BACKEND.getName());
    }
}
