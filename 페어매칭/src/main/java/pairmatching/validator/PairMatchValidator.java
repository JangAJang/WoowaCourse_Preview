package pairmatching.validator;

import pairmatching.enums.Course;

import static pairmatching.enums.Course.BACKEND;
import static pairmatching.enums.Course.FRONTEND;

public class PairMatchValidator {

    public Course validateCourse(String name){

    }

    private boolean isBackEnd(String name){
        return name.equals(BACKEND.getName());
    }

    private boolean isFrontEnd(String name){
        return name.equals(FRONTEND.getName());
    }
}
