package pairmatching.validator;

import pairmatching.enums.Course;
import pairmatching.enums.Level;
import pairmatching.enums.Mission;

import static pairmatching.enums.Course.BACKEND;
import static pairmatching.enums.Course.FRONTEND;
import static pairmatching.enums.Level.*;
import static pairmatching.enums.Mission.*;

public class PairMatchValidator {

    private static final String NOT_RIGHT_COURSE = "[ERROR] 입력한 코스가 존재하지 않습니다.";
    private static final String NO_MISSION_FOR_LEVEL = "[ERROR] 해당 레벨에는 미션이 존재하지 않습니다.";
    private static final String NOT_RIGHT_LEVEL = "[ERROR] 해당 레벨이 존재하지 않습니다.";
    private static final String NOT_RIGHT_MISSION = "[ERROR] 존재하지 않는 미션입니다.";

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

    public Level validateLevel(String level){
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

    public Mission validateMission(String level, String mission){
        if(isLevelOne(level)) return getLevelOneMission(mission);
        if(isLevelTwo(level)) return getLevelTwoMission(mission);
        return getLevelFourMission(mission);
    }

    private Mission getLevelOneMission(String mission){
        if(isRacing(mission)) return RACING;
        if(isLotto(mission)) return LOTTO;
        if(isBaseball(mission)) return BASEBALL;
        return notRightMissionException();
    }

    private Mission getLevelTwoMission(String mission){
        if(isShopping(mission)) return SHOPPING;
        if(isPayment(mission)) return PAYMENT;
        if(isSubway(mission)) return SUBWAY;
        return notRightMissionException();
    }

    private Mission getLevelFourMission(String mission){
        if(isImprove(mission)) return IMPROVE;
        if(isDistribute(mission)) return DISTRIBUTE;
        return notRightMissionException();
    }

    private boolean isRacing(String mission){
        return mission.equals(RACING.getName());
    }

    private boolean isLotto(String mission){
        return mission.equals(LOTTO.getName());
    }

    private boolean isBaseball(String mission){
        return mission.equals(BASEBALL.getName());
    }

    private boolean isShopping(String mission){
        return mission.equals(SHOPPING.getName());
    }

    private boolean isPayment(String mission){
        return mission.equals(PAYMENT.getName());
    }

    private boolean isSubway(String mission){
        return mission.equals(SUBWAY.getName());
    }

    private boolean isImprove(String mission){
        return mission.equals(IMPROVE.getName());
    }

    private boolean isDistribute(String mission){
        return mission.equals(DISTRIBUTE.getName());
    }

    private Mission notRightMissionException(){
        System.out.println(NOT_RIGHT_MISSION);
        throw new IllegalArgumentException();
    }
}
