# 기능 목록
## Domain
### Bridge
1. 생성자 : List<String>을 입력받아 인스턴스를 초기화한다. 
2. getBridges : List<String>을 반환한다.
3. isCorrectAnswer : Player.getPlayerAnswers의 길이와 문자열을 입력받아 인덱스의 인스턴스 원소가 입력변수와 같으면 참을 반환한다. 

### Player
1. 생성자 : List<boolean>타입 인스턴스를 초기화시킨다. 
2. addPlayerAnswer :  boolean타입 입력변수를 리스트에 추가한다. 
3. isFailedGame : 리스트에 false가 있으면 참을 반환한다. 
4. isFinished : Bridge의 리스트 길이를 입력받아, 인스턴스의 길이와 같고 인스턴스가 모두 true이면 참을 반환한다.
5. getPlayerAnswers : List<boolean>타입의 인스턴스를 반환한다.
6. clearAnswer : List<boolean>을 초기화시킨다. 
   

### GameResult
1. 생성자 : 인스턴스 trialCount를 1으로 , gameStatus를 GameStatus.GOING으로 초기화시킨다. 
2. resetGame : trialCount를 1 증가시키고, gameStatus를 GOING으로 초기화시킨다.
3. failGame : gameStatus를 QUIT로 초기화시킨다. 
4. isQuit : gameStatus가 QUIT이면 참을 반환한다. 
5. getTrialCounts : trialCount를 반환한다. 

### BridgeConstructor
인스턴스로 StringBuilder 2개가 존재한다. 
1. constructBridges : Bridge.getBridges와 Player.getPlayerAnswers를 입력받아 실행한다. 
   1. initializeConstructor : 두 StringBuilder를 초기화시켜준다. 
   2. constructEachBridge : 한 인덱스의 다리와 플레이어 정답여부를 입력받아 정답을 반환한다. 
      1. constructRightBridge
         1. isUpperBridge : Bridge에서 가져온 다리가 'U'이면 참을 반환한다.

## enum
### BridgeStatus
UPPER(1, "U"), DOWN(0, "D")가 존재한다. 
getValue, getCommand로 속성값을 반환할 수 있다. 

### GameStatus
GOING("R", "성공"), QUIT("Q", "실패")가 존재한다. 
getCommand와 getStatement로 속성값을 반환할 수 있다. 

### BridgeMakingElements
STARTER("[ "), FINISHER("]"), CORRECT("O "), WRONG("X "), EMPTY("  "), DIVIDER("| ")를 가진다. 
getElement로 속성값을 가져온다. 

## util
### BridgeMaker
1. makeBridge : 입력받은 사이즈만큼 makeEachBridge의 값을 List<String>에 담아 반환한다. 
   1. makeEachBridge : BridgeNumberGenerator로 숫자를 만들어 U, 또는 D로 반환한다. 
      1. isUpperBridge : 만든 숫자가 1이면 참을 반환한다.

## Model
### BridgeGame
1. 생성자 : 정수형 입력변수 size로 BridgeMaker에 BridgeRandomNumberGenerator를 생성해 makeBridge를 실행한다. 결과로 Bridge의 생성자를 실행시킨다. 
2. move : Bridges.isCorrectAnswer해준 결과를 Player.addPlayerAnswer해준다.
3. retry : GameResult.resetGame을 해주고 Player.clearAnswer해준다. 
4. isAllCorrect : Player.isFinished를 반환한다. 
5. containsWrongAnswer : Player.isFaildGame을 반환한다. 
6. isGameResultQuit : GameResult.isQuit을 반환한다. 
7. quitGame : GameResult.failGame으로 gameStatus를 Quit으로 초기화한다. 
8. makePlayerAnswerBridge : BridgeConstructor.constructBridges를 반환한다.
9. getTrialCounts : GameResult.getTrialCount를 반환한다. 

## Validator
### InputValidator
1. validateLength : 입력변수를 확인하고 정수형으로 반환한다. 
   1. isNotNumber : 입력변수가 정수가 아니면 참을 반환한다. 
   2. isOutOfRange : 3부터 20이 아니면 참을 반환한다. 
   3. throwLengthException : '[ERROR] 다리의 길이는 3부터 20의 정수여야 합니다.'를 출력하고 IllegalArgumentException을 던진다. 
2. validateBridgeChoice : 입력변수를 확인하고 문자열로 반환한다.
     1. isNotU : UPPER.getCommand가 아니면 참을 반환한다. 
    2. isNotD : DOWN.getCommand가 아니면 참을 반환한다. 
    3. throwLengthException : '[ERROR] 다리는 위는 U, 아래는 D로만 입력해주셔야 합니다.'를 출력하고 IllegalArgumentException을 던진다.
3. validateGameRetrialChoice : 입력변수를 확인하고 문자열로 반환한다.
     1. isNotRetry : GOING.getCommand가 아니면 참을 반환한다. 
    2. isNotQuit : QUIT.getCommand가 아니면 참을 반환한다. 
    3. throwLengthException : '[ERROR] 재시도는 R, 종료는 Q로 입력해주셔야 합니다.'를 출력하고 IllegalArgumentException을 던진다.


## View
### InputView
1. readInput : 문자열을 입력받아 이를 출력하고 Console.readLine을 반환해준다.
2. readLength :  scanLength : '다리의 길이를 입력해주세요.'를 입력변수로 readInput한 값을 InputValidator.validateLength로 반환해준다. 
3. readBridgeChoice : '이동할 칸을 선택해주세요. (위: U, 아래: D)'를 입력변수로 readInput한 값을 InputValidator.validateBridgeChoice로 반환해준다. 
4. readGameRetrialChoice : '게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)'를 입력변수로 readInput한 값을 InputValidator.validateGameRetrialChoice로 반환해준다. 

### OutputView
1. printPlayerChoices : 입력받은 BridgeConstructor.constructBridges의 값을 출력한다. 
2. printFinalResult : '최종 게임 결과'를 출력하고 printPlayerChoices를 출력해준다. 
3. printGameStatus : '게임 성공 여부: '와 boolean타입의 입력변수가 참이면 '실패'를 출력해준다. 
4. printGameTrials : '총 시도한 횟수: '와 정수형 입력변수를 출력해준다. 

## Controller
### BridgeGameController
1. 생성자 : InputView.readLength로 BridgeGame을 생성해준다. 
2. runGame : 다 맞추거나 게임을 끝내길 원할 때 까지 게임을 반복시키고, 끝날 때 최종 결과를 출력해준다. 
   1. moveUntilStopMoment : 다리 길이만큼 다 맞추거나 틀리는 답이 존재할때 까지 BridgeGame.move해준다. 
      1. isStopMoment : BridgeGame.isAllCorrect || BridgeGame.containsWrongAnswer를 반환한다. 
      2. movePlayer : InputView.readBridgeChoice의 결과로 BridgeGame.move해준다. 
      3. printPlayerMovement : OutputView.printPlayerChoices로 BridgeGame.makePlayerAnswerBridge의 결과를 출력해준다. 
   2. retryGame : isRunning이라면 BridgeGame.retry해준다. 
   3. isRunning : BridgeGame.isAllCorrect || BridgeGame.isGameResultQuit의 역을 반환한다. 
   4. concludeGame 
      1. BrigdeGame.makePlayerAnswerBridge을 OutputView.printFinalResult해준다. 
      2. BridgeGame.getTrialCount의 값을 printGameTrials해준다. 
   5. changeGameStatusIfRunning : 만약 isRunning이 참이면 입력을 받아 GameStatus를 바꾼다.  
      1. isInputQuit : InputView.readGameRetrialChoice가 QUIT.getCommand와 같으면 참을 반환한다. 
      2. bridgeGame.quitGame을 실행해준다. 

runGame 구조
while(!isRunning){
    moveUntilStopMoment
    changeGameStatusIfRunning
    retryGame
}
concludeGame