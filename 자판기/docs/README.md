# 기능목록

## Domain
### Coins
1. 생성자 : 금액을 입력받아 이를 최소한의 동전을 가지는 HashMap<Coin, Integer>으로 만든다.
2. showAvailableCoins : HashMap을 반환한다. 
3. giveExchange : 입력변수의 값을 잔돈 HashMap<Coin, Integer>로 반환한다.
   1. isTotalLessThanLeftMoney : 정수형 변수를 입력받아 HashMap의 Coin.getAmount * Integer의 총합이 더 작으면 참을 반환한다.
      1. getTotal : 키의 amount*value의 총합을 구한다.
   2. giveAll : 인스턴스 해시맵의 value가 0인 부분을 제외하고 전부 반환한다. 
   3. makeExchange : 해시맵의 동전으로 입력변수의 금액을 만들어 HashMap으로 반환한다. 

### Item
1. 생성자 : List<String>을 입력받아 첫째 항을 name, 둘째 항을 price, 셋째 항을 quantity 인스턴스로 초기화시켜준다. 
2. decreaseQuantity : quantity를 1 감소시킨다.
3. getPrice : price를 반환한다. 
4. isRequestedItem : 문자열을 입력받아 name과 같으면 참을 반환한다.
5. isSoldOut : Quantity가 0이면 참을 반환한다.
6. cannotBuyException : '[ERROR] 해당 품목이 품절 상태입니다'를 출력하고 예외처리한다.

### Items
1. 생성자 : List<List<String>>을 입력받아 List의 길이만큼 List<String>으로 Item을 생성해 인스턴스에 추가한다.
2. buySpecificItem : 입력변수로 들어온 특정 물품을 구입한다.
   1. noNameException : '[ERROR] 해당 품목이 존재하지 않습니다'를 출력하고 예외처리한다.
3. getCheapestItem : Item.getPrice의 최소값을 반환한다. 

### InsertedMoney
1. 생성자 : 금액을 입력받아 인스턴스를 초기화시킨다. 
2. decreaseMoney : 입력변수의 크기만큼 인스턴스에서 뺀다. 
3. isLessThanItems : 금액을 입력받아 인스턴스가 더 작으면 참을 반환한다. 
4. getLeft : 인스턴스를 반환한다. 

## DomainModel
### VendingMachine
1. 생성자 : 입력변수로 금액을 입력받아 Coins를 생성해준다. 
2. showAllCoins : Coins.showAvaliableCoins를 반환한다. 
3. makeItems : List<List<String>>을 입력받아 Items를 초기화시킨다. 
4. insertMoney : InsertedMoney를 입력변수로 생성해준다. 
5. takeProduct : 입력변수로 들어온 문자열을 Items.takeSpecificItem해주고 반환된 값으로 InsertedMoney.decreaseMoney해준다. 
6. isUnableToBuyMore : Items.getCheapestItem을 InsertedMoney.isLessThanItem에 넣어 반환한다. 
7. getLeftInsertedMoney : 투입금액의 남은 금액을 반환한다. 
8. showExchange : Coins.giveExchange를 반환한다.

## Validator
### InputValidator
1. validatePrice : 금액의 예외를 확인하고 정수형으로 반환한다. 
   1. isNotNumber : 입력변수가 정수가 아니면 참을 반환한다. 
   2. isNotDividedByTen : 10으로 나눈 나머지가 0이 아니면 참을 반환한다. 
   3. isLessThanHundred : 100보다 작으면 참을 반환한다. 
   4. notRightPriceException : '[ERROR]금액은 100원부터 시작하며, 10원으로 나누어떨어져야 한다.'를 출력하고 예외처리한다.

2. validateItemsInput : 상품에 대한 입력을 확인하고 List<List<String>>을 만들어 반환한다. 
   1. divideBySemiColon : 세미콜론으로 입력을 나누어 리스트로 반환한다. 
   2. validateEachItem : 나눈 리스트의 원소들을 검사하고 문제가 없다면 List<String>으로 반환한다. 
      1. deleteBracket : '[]'을 지운 값을 반환한다. 
      2. divideByComma : ','로 split한 후 리스트로 반환한다. 
      3. isNotThreeElements : 원소가 3개가 아닐 경우 참을 반환한다. 
      4. isNotNumber : 금액과 가격이 숫자인지 확인할 때 사용한다. 
      5. isNotDividedByTen : 금액 검사에 사용한다. 
      6. isLessThanHundred : 금액 검사에 사용한다. 
      7. notRightItemException : '[ERROR] 올바른 Item이 아닙니다. '를 출력하고 예외처리한다.

## View
### InputView
1. readInput : 입력 문자열을 출력하고 콘솔 입력문을 문자열로 반환한다. 
2. readPrice : try-catch로 올바른 입력이 올 때 까지 반복한다. 
   1. scanPrice : '자판기가 보유하고 있는 금액을 입력해 주세요.'를 입력변수로 readInput해준다. 
   2. validatePrice : InputValidator.validatePrice를 반환한다. 
3. readItems : try-catch로 올바른 입력이 올 떄 까지 반복한다.
   1. scanItems : '상품명과 가격, 수량을 입력해 주세요.'를 입력변수로 readInput해준다. 
   2. validateItems : InputValidator.validateItemsInput을 반환한다.
4. readInsertMoney : 
   1. scanInsert: '투입 금액을 입력해 주세요.'를 입력변수로 readInput을 반환한다. 
   2. validateInsert : InputValidator.validatePrice를 반환한다. 

### OutputView
1. printCoins : <Coin, Integer>해시맵을 입력받아 Coin.getAmount가 큰 순으로 개수와 출력한다. 
2. printLeftMoney : 입력변수를 '투입금액: ' + '원'사이에 넣어 출력시킨다. 
3. printLeftOver : '잔돈'을 출력시킨다. 

## Controller
### VendingMachineController
1. 생성자 : InputView.readPrice의 반환값으로 VendingMachine을 생성한다. 
2. printAvailableCoins : VendingMachine.showAllCoins를 OutputView.printCoins로 출력시킨다. 
3. createItems : InputView.readItems로 VendingMachine.makeItems해준다. 
4. insertMoney : InputView.readInsertMoney로 VendingMachine.insertMoney해준다.
5. isAvailableToBuy : VendingMachine.isUnableToBuyMore의 역을 반환한다. 
6. buyProduct : 
   1. printLeftMoney : OutputView.printLeftMoney를 VendingMachine.getLeftInsertedMoney로 출력시킨다. 
   2. pickProduct : VendingMachine.takeProduct해준다. 
7. printExchange : 투입금액의 남은 금액과 잔돈을 출력시킨다. 
   1. printLeftMoney : 남은 금액을 출력시킨다. 
   2. printLeftCoins : 
      1. OutputView.printLeftOver를 출력시킨다. 
      2. VendingMachine.showExchange를 OutputView.printCoins로 출력시킨다. 