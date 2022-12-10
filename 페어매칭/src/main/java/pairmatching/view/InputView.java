package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.enums.OperationCommand;
import pairmatching.validator.InputValidator;

import java.util.List;

public class InputView {

    private static final String OPERATIONS = "기능을 선택하세요.\n" +
            "1. 페어 매칭\n" +
            "2. 페어 조회\n" +
            "3. 페어 초기화\n" +
            "Q. 종료";
    private static final String PAIR_MATCHING_REQUEST = "#############################################\n" +
            "과정: 백엔드 | 프론트엔드\n" +
            "미션:\n" +
            "  - 레벨1: 자동차경주 | 로또 | 숫자야구게임\n" +
            "  - 레벨2: 장바구니 | 결제 | 지하철노선도\n" +
            "  - 레벨3: \n" +
            "  - 레벨4: 성능개선 | 배포\n" +
            "  - 레벨5: \n" +
            "############################################\n" +
            "과정, 레벨, 미션을 선택하세요.\n" +
            "ex) 백엔드, 레벨1, 자동차경주";
    private static final String REMATCHING_REQ = "매칭 정보가 있습니다. 다시 매칭하시겠습니까? \n네 | 아니오";

    InputValidator inputValidator = new InputValidator();

    private String readInput(String request){
        System.out.println(request);
        return Console.readLine();
    }

    public OperationCommand readOperation(){
        return inputValidator.validateOperation(readInput(OPERATIONS));
    }

    public List<String> readMissionChoice(){
        return inputValidator.validateMissionChoice(readInput(PAIR_MATCHING_REQUEST));
    }

    public boolean readRematch(){
        return inputValidator.validateRematch(readInput(REMATCHING_REQ));
    }
}
