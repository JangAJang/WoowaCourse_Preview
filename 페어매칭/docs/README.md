# 기능목록
## enums
### Course
BACKEND("백엔드"), FRONTEND("프론트엔드")로 있고, name으로 내부의 인스턴스를 불러온다. 

### Level
ONE("래밸1"), TWO("래밸2"), THREE("래밸3"), FOUR("래밸4"), FIVE("래밸5")
로 이루어져 있고 name으로 인스턴스를 호출한다.

### Mission
RACING("자동차경주"), LOTTO("로또"), BASEBALL("숫자야구게임"),
SHOPPING("장바구니"), PAYMENT("결제"), SUBWAY("지하철노선도"),
IMPROVE("성능개선"), DISTRIBUTE("배포")
로 이루어져 있고, name으로 인스턴스를 호출한다. 

### OperationCommand
QUIT("Q"), MATCH_PAIR("1"), READ_PAIR("2"), CLEAR("3")을 가지며 getCommand로 문자열을 반환한다. 

## Domain

### Pair
1. 생성자 : List<String>을 입력받아 순서대로 정렬해 인스턴스를 초기화한다. 
2. isPairMember : 입력변수 이름을 받아 인스턴스에 존재하면 참을 반환한다. 
3. getMembers : 인스턴스를 반환한다. 
4. isSamePair : List<String>을 입력받아 인스턴스와 같으면 참을 반환한다.

### Pairs
1. 생성자 : List<String>을 입력받는다. 2명씩 Pair를 생성하다가 마지막이 3명이면 하나로 Pair를 만들어 List<Pair>인스턴스에 추가한다. 
2. getPairs : List<Pair> 인스턴스를 반환한다. 
3. isDuplicatedPairs : 인스턴스와 입력변수 Pairs인스턴스를 비교해 isSamePair이 하나라도 참이면 참을 반환한다.

### PairMatch
1. 생성자 : List<String>으로 정보를 받아와 이를 토대로 PairMatchValidator를 통해 나온 반환값으로 인스턴스를 초기화한다.
2. getCourse : Course인스턴스를 반환한다.
3. getLevel : Level 인스턴스를 반환한다. 
4. getMission : Mission 인스턴스를 반환한다. 
5. isSame : List<String>을 입력받아 getCourse.getName(), getLevel.getName(), getMission.getName()을 비교해 전부 같으면 참을 반환한다. 
6. createEachPair
   1. getMembers : resources에서 크루명을 받아 문자열로 반환한다. 
      1. isBackEnd : Course의 값이 BACKEND이면 참을 반환한다.
      2. enlistBackEndCrew : resources/backend-crew.md의 이름을 List<String>으로 반환한다. 
      3. enlistFrontEndCrew : resources/frontend-crew.md의 이름을 List<String>으로 반환한다.
   2. shuffleMembersOrder : 이름을 무작위로 순서를 섞어 반환한다.
   3. createPairs : List<String>을 입력변수로 Pairs인스턴스를 생성한다. 
7. hasSamePairBefore : PairMatch를 입력받아 Level이 같을 때 둘의 Pairs를 가지고, isDuplicatedPairs를 반환한다. 
8. getPairMembers : List<List<String>형으로 각 페어를 한 리스트로, 그 리스트들을 리스트로 반환한다. 

### PairMatchData
1. 생성자 : List<PairMatch> 인스턴스를 생성해준다.
2. createPairMatch : List<String>을 입력받아 PairMatch를 생성해 인스턴스에 저장하고 getPairMembers를 반환한다
   1. groupMembers : PairMatch.createeachPair를 해준다. 
   2. containsSamePairBefore : 인스턴스에 반복문으로 hasSamePairBefore을 통해 한번이라도 같은 레벨에서 겹친 크루가 있으면 참을 반환한다. 
   3. threeDuplicatedException : 에러문구를 출력하고 예외처리한다. 
3. containsExistingDataAlready : List<String>으로 인스턴스의 PairMatch에서 isSame가 참인게 하나라도 있으면 참을 반환한다. 
4. readPairMatch : List<String>입력변수와 인스턴스의 리스트중 PairMatch.isSame인 PairMatch의 getPairMembers를 반환한다. 
5. resetData : 인스턴스를 데이터를 초기화시킨다. 
6. recreatePairMatch : List<String>을 입력받아 이미 존재하는 데이터를 지우고, 새롭게 create한다.
   1. deleteExistingData : 리스트의 PairMatch중에 isSame인 PairMatch를 삭제한다. 
   2. createpairMatch : 다시 실행시킨다. 

## Validator
### InputValidator
1. validateOperation : 입력변수가 1부터 3이 아니거나 Q가 아니면 예외처리하고, 맞다면 문자열로 반환한다. 
   1. isNotQ : 입력변수가 "Q"가 아니면 참을 반환한다. 
   2. isNotFromOneToThree : 1부터 3이 아니면 참을 반환한다. 
   3. notOperationException : 정해진 기능이 아님을 알리고 예외처리한다.

2. validateMissionChoice : 입력변수를 미션 선택에 관한 리스트로 나눌때 길이에 대한 예외처리해준다. 
   1. separateComponent : 입력변수를 ", "로 나누어 리스트로 반환한다. 
   2. isNotThree : 리스트의 길이가 3이 아니면 참을 반환한다. 
   3. notThreeComponentException : 요소가 3개가 아님을 출력하고 예외처리한다. 

### PairMatchValidator
1. validateCourse : 과정을 확인해 이상이 없을 때 Course형으로 반환한다.
   1. isBackEnd : "백엔드"와 입력변수가 같으면 참을 반환한다.
   2. isFrontEnd : "프론트엔드"와 입력변수가 같으면 참을 반환한다.
   3. notRightCourseException : 코스가 올바르지 않음을 출력하고 예외처리한다.
2. validateLevel : 레벨을 입력변수로 이상이 없으면 결과를 반환한다. 있을경우 예외처리한다.  
   1. isLevelOne : 입력변수가 "레벨1" 이면 참을 반환한다.
   2. isLevelTwo : 입력변수가 "레벨2" 이면 참을 반환한다.
   3. isLevelFour : 입력변수가 "레벨4" 이면 참을 반환한다.
   4. isLevelThreeOrFive : 입력변수가 "레벨3"또는 "레벨5"면 참을 반환한다.
   5. noMissionForLevelException : 해당 레벨의 미션이 없음을 알려주고 예외처리한다.
   6. notRightLevelException : 올바른 레벨이 아님을 알려주고 예외처리한다.
3. validateMission
   1. isLevelOne 일 때 자동차, 로또, 숫자야구뿐이므로 이중에 반환한다.
      1. isRacing : 입력변수가 "자동차경주"면 참을 반환한다.
      2. isLotto : 입력변수가 "자동차경주"면 참을 반환한다.
      3. isBaseball : 입력변수가 "숫자야구게임"이면 참을 반환한다.
   2. isLevelTwo 일 때 장바구니, 결제, 지하철노선도 중에 하나를 반환한다.
      1. isShopping : 입력변수가 "자동차경주"면 참을 반환한다.
      2. isPayment : 입력변수가 "결제"면 참을 반환한다.
      3. isSubway : 입력변수가 "지하철노선도"면 참을 반환한다.
   3. isLevelFour일 때 성능개선, 배포중에 하나만을 반환한다.
      1. isImprove : 입력변수가 "성능개선"이면 참을 반환한다.
      2. isDistribute : 입력변수가 "배포"면 참을 반환한다.
   4. notRightMissionException : 올바른 미션이 아님을 알려주고 예외처리한다.

## View
### InputView
1. readInput : 입력변수를 출력하고 콘솔 입력값을 문자열로 반환한다. 
   1. requestInput : 입력변수를 출력해준다. 
   2. scanInput : 콘솔 입력문구를 반환한다. 
2. readOperation
   1. getOperation : readInput에 기능선택요청문을 넣어 반환한다. 
   2. validateOperation : InputValidator.validateOperation을 반환한다. 
3. readMissionChoice
   1. getMissionChoice : readInput에 과정, 레벨, 미션 요청문구를 입력변수로 반환한다. 
   2. validateMissions : InputValidator.validateMissionChoice의 결과를 반환한다. 
4. readRematch
   1. getRematchingInfo : "매칭 정보가 있습니다. 다시 매칭하시겠습니까? \n네 | 아니오"를 출력해준다. 
   2. isYes : "네"면 참을 반환한다.

### OutputView
1. showBluePrint : 과정, 레벨당 미션을 전부 출력해준다. 
2. printMatchingResult : 페어 매칭 결과를 출력한다.
   1. printResultStarting : '페어 매칭 결과입니다'를 출력한다. 
   2. printResultPairs : List<List<String>>으로 받은모든 페어를 출력시킨다. 
      1. printEachpair : List<String>을 출력시켜준다. 
         1. appendWithSeparator : List의 사이마다 ' : '를 넣어 문자열로 반환한다. 
         2. printLine : 입력문자열을 출력한다.
3. printResetSuccess : "초기화되었습니다"를 출력해준다. 

## Controller
### PairMatchDataController
1. runPairMatching : InputView.readOperation이 Q가 아닌 동안 실행된다. 
   1. isPairMatching : 입력변수가 1이면 참을 반환한다. 
   2. matchPair : 미션을 입력받아 페어 매칭을 하고 결과를 반환합니다. 만약 이미 존재한다면 다시 매칭할지 결정하고,그럴 경우 새롭게 데이터를 만듭니다. 
      1. readPairMatchingMission : InputView.readMission을 반환한다. 
      2. isAlreadyExistingMission : PairMatchData.containsExistingDataAlready를 반환한다.
      3. isRequiringRematch : InputView.readRematch의 결과를 반환한다. 
      4. createPairs : PairMatchData.createPairMatch를 실행한다. 
      5. printResult : OutputView.printMatchingResult를 실행한다. 
      6. recreatePairs : PairMatchData.recreatepairMatch를 실행시킨다. 
   3. isReadPair : 입력변수가 2이면 참을 반환한다. 
   4. readPair : InputView.readMission을 입력받아 PairMatchData.readPairMatch를 OutputView.printResult로 출력해준다. 
   5. isResetPairs: 입력변수가 3이면 참을 반환한다. 
   6. resetPair : PairMatchData.reset을 실행한다. Outputview.printResetSuccess를 출력한다. 
   
   