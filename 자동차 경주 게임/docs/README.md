# 기능목록 : 종료시간 1시간 33분 36초
## Domain
### Car
1. 생성자 : 문자열을 입력받아 인스턴스 name을 초기화시켜준다. 
2. move : 입력변수가 isAbleToMove면  인스턴스 position을 +1해준다. 
   1. isAbleTomove : 입력변수가 4보다 크거나 같으면 참을 반환한다. 
3. makeResult : 이름 : -(position개수만큼)을 문자열로 만들어 반환한다. 
   1. makeResultPosition : -(position개수만큼)을 만들어 반환한다. 
4. getPosition : position을 반환한다. 
5. getName : name을 반환한다. 

### Cars
인스턴스로 List<Car>이 존재한다. 
1. 생성자 : List<String>이 입력변수로 들어오면 각 문자열마다 Car 객체를 생성해 인스턴스에 추가한다. 
2. getCarsResult : List<String>으로 모든 Car.makeResult를 반환한다. 
3. getFinalWinner : getBiggestPosition과 위치가 같은 최종 승자의 이름을 List<String>으로 반환한다. 
   1. getBiggestPosition : List<Car>의 position중 최대값을 구한다. 
4. moveCars : 인스턴스의 모든 Car에 Randoms로 무작위의 값을 생성해 입력변수로 Car.move해준다. 

### InputValidator
1. validateNames : 이름들 입력의 예외를 확인하고 없다면 문자열 리스트로 반환한다. 
   1. separateNames : ','으로 문자열을 나누어 리스트로 초기화한다. 
   2. isEachNameTooLong : 이름이 5자가 넘는게 하나라도 있으면 참을 반환한다. 
   3. nameTooLongException : '[ERROR] 이름은 5글자 이내여야 합니다.'를 출력하고 예외처리한다. 

2. validateTrialCount : 시도 횟수 입력의 예외를 확인하고 없다면 정수로 반환한다. 
   1. isNotNumber : 입력 문자열이 숫자가 아니면 참을 반환한다. 
   2. notNumberException : '[ERROR] 시도 횟수는 숫자로 입력해야 합니다.'를 출력하고 예외처리한다.

## View
### InputView
1. readInput : 입력변수를 출력해주고 콘솔 입력문을 문자열로 반환한다. 
2. readNames : 이름들 입력을 받고 예외사항을 확인한 후 정수형으로 반환한다. 
   1. scanNames : '경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)'을 입력변수로 readInput해준다. 
   2. validateNameInput : InputValidator.validatenames를 반환한다. 
3. readTrials : 시도 횟수를 입력을 받고 예외사항을 확인한 후 정수형으로 반환한다. 
   1. scanTrials : '시도할 회수는 몇회인가요?'를 입력변수고 readInput해준다. 
   2. validateTrials : InputValidator.validateTrialCount를 반환한다. 

### OutputView
1. printStartOfResult : '실행결과'를 출력해준다. 
2. printCarsPositions : Cars.getCarsResult를 출력해준다. 
3. printFinalWinner : '최종 우승자 : '에 이름들을 출력해준다. 

## Controller
### RacingCarController
1. 생성자 : InputView.readNames의 리턴값으로 Cars를 생성해준다. 
2. runGame : 게임 로직을 실행시킨다. 
   1. readCarsMovingTime : InputView.readTrials를 반환한다. 
   2. startGame
      1. startMakingResult : OutputView.printStartOfResult를 출력시킨다. 
      2. moveCars : readCarsMovingTime만큼 Cars.moveCars한 후 getCarsResult를 OutputView.printCarsPosition해준다.
   3. showFinalWinners : Cars.getFinalWinners를 OutputView.printFinalWinners로 출력해준다. 