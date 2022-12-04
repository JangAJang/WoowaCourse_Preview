package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private String readInput(String request){
        System.out.println(request);
        return Console.readLine();
    }


}
