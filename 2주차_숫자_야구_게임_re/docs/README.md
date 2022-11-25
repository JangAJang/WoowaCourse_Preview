# 기능 목록
## Domain
### RandomNumbers
1. 생성자 : 3개의 1~9의 숫자를 생성해 정수형 리스트에 저장한다. 
2. countStrike : 정수형 리스트를 입력받아 전역변수와 비교해 인덱스의 값이 같은 개수를 반환한다. 
3. countBall : 정수형 리스트를 입력받아 전역변수와 비교해 인덱스는 다르지만 전역변수에 포함하는 정수형 리스트의 원소 개수를 반환한다. 
### Player
1. 생성자 : 문자열을 입력받아 정수형 리스트로 반환한다. 
   1. makeInputToNumbers : 문자열을 정수형 리스트로 전환해 저장한다. 
2. getPlayerNumbers : 정수형 리스트를 반환한다. 

##  Model
### Baseball
1. 생성자 : RandomNumbers 생성한다. 
2. createPlayer : 입력변수 문자열로 Player을 생성한다. 
3. countStrikeWithPlayer : 플레이어의 정수형 리스틀 입력받아 RandomNumbers.countStrike를 반환한다. 
4. countBallWithPlayer : 플레이어의 정수형 리스틀 입력받아 RandomNumbers.countBall을 반환한다.
5. isThreeStrike : countStrikeWithPlayer == 3이면 참을 반환한다. 

## Exception
### PlayerInputException
1. validate
   1. isNotNumber : 입력 문자열이 숫자가 아닐 경우 참을 반환한다.
   2. isNotThreeDigit : 문자열의 길이가 3이 아니면 참을 반환한다.
   3. containsZero : 문자열에 0이 있으면 참을 반환한다. 
   4. notRightPlayerNumberException : '[ERROR] 입력은 1~9로 이루어진 숫자 3개여야 합니다'를 출력하고 IllegalArgumentException으로 예외처리한다. 
### GameStatusException
1. validate
   1. isNotOne : '1'이 아니면 참을 반환한다. 
   2. isNotTwo : '2'가 아니면 참을 반환한다.
   3. notRightGameStatusException : '[ERROR] 입력은 1 또는 2를 입력해야 합니다. '를 출력하고 IllegalArgumentException으로 예외처리한다.

## View
### InputView
1. readPlayerNumber
   1. requestNumbers : '숫자를 입력해주세요 : '를 출력한다. 
   2. validateNumbers : PlayerInputException.validate으로 예외처리한다. 
   3. scanInput : 콘솔에 입력한 문자열을 반환한다. 
2. readGameCommand
   1. requestGameStatus : '게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.'를 출력한다.
   2. validateGameStatus : GameStatusException.validate으로 예외처리한다.
   3. scanInput : 콘솔에 입력한 문자열을 반환한다. 

### OutputView
1. printScore : 볼과 스트라이크를 입력받아 결과를 출력한다. 
   1. makeResultStatement : 결과 문자열을 반환한다. 
      1. isNothing : 볼과 스트라이크가 0일 때 참을 반환한다. 
      2. isOnlyStrike : 볼만 0일 때 참을 반환한다. 
      3. isOnlyBall : 스트라이크만 0일때 참을 반환한다. 
      4. stateOnlyStrike : 'a볼'을 반환한다. 
      5. stateOnlyBall : 'b스트라이크'를 반환한다.
      6. stateBoth : 'a볼 b스트라이크'를 반환한다. 
2. printSuccess : '3개의 숫자를 모두 맞히셨습니다! 게임 종료'를 출력한다.
3. startGame : '숫자 야구 게임을 시작합니다.'를 출력한다. 

## Controller
### BaseballController
1. 생성자 : 
   1. initializeGame : OutputView.startGame을 실행한다.
   2. createAnswer : 전역변수 Baseball 를  초기화해준다.
2. makePlayer : InputView.readPlayerNumber의 값으로 Baseball.createPlayer해준다. 
3. concludeRound : Baseball.countStrike, Baseball.countBall을 OutputView.printScore에 넣어 출력한다. 
4. isThreeStrike : Baseball.isThreeStrike를 반환한다. 
5. isOutputQuit : OutputView.readGameCommand가 '2'와 같으면 참을 반환한다. 
6. resetGame : Baseball을 초기화해준다. 