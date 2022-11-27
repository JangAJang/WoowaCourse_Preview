# 기능 목록

## Exception
### LottoException
1. validate : 
   1. isNumberOutOfRange : 입력변수가 1부터 45가 아닐 경우 참을 반환한다.
   2. isNotSixNumbers : 리스트의 길이가 6이 아닐 경우 참을 반환한다.
   3. containsSameNumber : 리스트를 Set으로 바꾸었을 때 길이가 6이 아니면 참을 반환한다. 
   4. notRightNumbersException : 예외처리 출력문과 IllegalArgumentException을 throw한다. 

### PriceInputException
1. validate
   1. isNotNumber : 숫자가 아닐 경우 참을 반환한다. 
   2. isNotDividedByThousand : 1,000으로 나눈 몫이 0이거나 나머지가 0이 아닐 때 참을 반환한다. 

### BonusNumberException
1. validate
   1. isNotNumber : 숫자가 아니면 예외처리
   2. isAlreadyInLotto : 입력변수 Lotto.containsBonusNumber를 반환한다. 
   3. isOutOfRange : 입력변수가 1부터 45가 아닐 경우 참을 반환한다.
   4. notRightBonusNumberException : 예외처리 출력문과 IllegalArgumentException을 throw해준다.

### LottoInputException
1. validate
   1. isNotNumber : ','으로 split한 배열이 숫자로 이루어진게 아닐 경우 참을 반환한다. 
   2. inputNotNumberException : 예외처리 출력문과 IllegalArgumentException을 throw한다. 
   3. calculatePercent : 백분율을 소수점 첫째자리까지 구해준다.  

## Enum
### GameResult
NOTHING(0, 0), THREE(3, 5,000), FOUR(4, 50,000), FIVE(5, 1,500,000)
, FIVE_WITH_BONUS(5, 30,000,000), SIX(6, 2,000,000,000)를 가지며
getCount로 괄호의 첫 번째 값을 int타입으로 반환한다. 
getPrice로 괄호의 두 번째 값을 Long타입으로 반환한다.

## Domain
### Lotto
1. 생성자 : 정수형 리스트를 받아 인스턴스 초기화시켜준다. 
2. validate : 예외사항이 있을 경우 예외처리해준다. 
3. containsBonusNumber : 입력변수가 정수형 리스트에 있을 때 참을 반환한다. 
4. matchWithPlayerLotto : 입력변수로 정수형 리스트를 받아 결과를 반환한다. 
   1. countMatch : 정수형 리스트의 원소중 인스턴스 리스트에 존재하는 원소들의 개수를 반환한다. 
5. getNumbers

### Winning
1. 생성자 : 입력받는 GameResult형 Hashmap으로 인스턴스를 초기화시켜준다. 
2. calculateProfit : addTotalWinning / countLotto * 100을 소수점 첫째 자리까지 문자열로 반환한다. 
   1. addTotalWinning : 상금을 다 합쳐 반환한다. 
      1. convertResultToPrice : GameResult.getPrice의 값을 반환한다. 
   2. countLotto : 인스턴스의 길이 * 1000을 반환한다.

### BonusNumber
1. 생성자 : Lotto와 문자열을 입력받는다. BonusNumberException.validate를 해준 후 정수형으로 인스턴스를 초기화시켜준다. 
2. isHavingBonusNumber : 정수형 리스트를 입력받아 인스턴스를 가지고 있으면 참을 반환한다. 

## Bounded-Context
### WinningLotto
인스턴스로 Lotto와 BonusNumber를 가진다. 
1. 생성자 : Lotto와 BonusNumber를 입력받아 인스턴스를 초기화시켜준다. 
2. makeResultOfLotto : 입력변수로 받는 Lotto의 결과를 GameResult형으로 반환한다. 
   1. countMatches : 인스턴스의 Lotto.matchWithPlayerLotto에 입력변수 로또의 정수형 리스트를 넣어 반환한다. 
   2. isFive : 입력변수가 5일 경우 참을 반환
   3. containsBonusNumber : BonusNumber.isHavingBonusNumber에 정수형 리스트를 넣어 반환한다.

### Player
1. 생성자 : int형 변수를 입력받아 List<Lotto>를 생성한다. 사이즈가 변수와 같아질 때 까지 Randoms로 로또를 만들어준다. 
2. matchResultByWinningLotto : WinningLotto를 입력받아 결과를 GameResult형 해시맵으로 반환한다. 
   1. matchEachByWinning : WinningLotto.makeResultOfLotto에 인스턴의 로또 하나를 넣어 결과를 반환한다. 
3. getPlayersLottoNumbers : List<Lotto>를 List<List<Integer>>로 반환한다. 

## Model
### LottoGame
1. 생성자 : long타입으로 금액을 입력받는다. 1,000으로 나누어 인스턴스로 Player를 초기화시켜준다. 
2. showPlayerNumbers : Player.getPlayersLottoNumbers를 반환한다. 
3. createWinningLotto : 당첨번호 리스트와 보너스 번호를 입력받아 WinningLotto를 초기화시켜준다. 
4. matchLotto : Player.matchResultByWinningLotto의 결과를 구해 Winning을 초기화시켜주고 반환한다. 
5. calculatePlayerProfit : Winning.calculateProfit을 반환한다. 

## View
### InputView
1. readInput : 문자열을 입력받아 출력하고 Console.readline을 반환한다. 
2. readPayment : '구입금액을 입력해 주세요.'를 readInput의 입력변수로 넣어 실행한다.
3. readWinningNumbers : '당첨 번호를 입력해 주세요.'를 readInput의 입력변수로 넣어 실행한다.
4. readBonusNumber : '보너스 번호를 입력해 주세요.'를 readInput의 입력변수로 넣어 실행한다.

### OutputView
1. printStarter : '당첨통계\n---'을 출력한다. 
2. printPlayerNumbers : List<List<Integer>>를 입력받아 '개를 구매했습니다.'에 크기와 List<Integer>를 문자열로 출력한다. 
3. printResult : 해시맵을 입력받아 '개 일치 (금액) - ', '개'를 합쳐 출력시킨다. 
4. printProfit : 입력받은 문자열을 '총 수익률을 ', '%입니다.'와 이어붙여 출력시킨다. 

## Controller
### LottoGameController
1. 생성자 : InputView.readPayment로 LottoGame을 초기화한다. 
2. showPlayerNumbers : LottoGame.showPlayerNumbers를 OutputView.printPlayerNumbers로 출력시킨다. 
3. generateWinningLotto : InputView.readWinningNumbers와 readBonusNumber로 LottoGame.createWinningLotto 해준다. 
4. showResultOfGame
   1. showStatistics : LottoGame.matchLotto의 값을 OutputView.printResult로 출력시킨다. 
   2. showProfit : LottoGame.calculatePlayerProfit을 OutputView.printProfit으로 출력시킨다.