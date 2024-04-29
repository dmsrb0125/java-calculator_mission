# 계산기 만들기 프로젝트
Level1 부터 Level3 까지 각각의 레벨별로 요구사항에 맞는 계산기 기능을 구현

## 프로젝트 요구사항
- [ ] 요구사항에 작성된 순서대로 과제를 진행합니다.
- [ ] 과제를 진행하면서 요구사항에 없더라도 변경이 필요한 부분이 있다면 변경 
- [ ] 각 요구사항을 완료할 때마다 Git Commit 남기기
- [ ] 소스 코드를 설명하는 주석을 작성

## Level 1 

### 학습 목표
- 변수 & 타입 이해하기
- 연산자 이해하기
- 제어문 & 반복문 이해하기
- 배열 & 컬렉션 이해하기

### 과제 요구사항

#### 요구사항 1번
- [x] Scanner를 사용하여 양의 정수 2개(0 포함)를 전달 받을 수 있습니다
  - [x] 양의 정수는 각각 하나씩 전달 받습니다.

#### 요구사항 2번
- [x] Scanner를 사용하여 사칙연산 기호를 전달 받을 수 있습니다.
  - [x] 사칙연산 기호를 적합한 타입으로 선언한 변수에 저장합니다

#### 요구사항 3번
- [x] 입력받은 양의 정수 2개와 사칙연산 기호를 사용하여 연산을 진행한 후 결과값을 출력합니다.
  - [x] 사칙연산 기호에 맞는 연산자를 사용하여 연산을 진행합니다.
  - [x] 입력받은 연산 기호를 구분하기 위해 제어문을 사용합니다
  - [x] 연산 오류가 발생할 경우 해당 오류에 대한 내용을 정제하여 출력합니다.

#### 요구사항 4번
- [x] 반복문을 사용하여 반복의 종료를 알려주는 “exit” 문자열을 입력하기 전까지 무한으로 계산을 진행할 수 있도록 소스 코드를 수정합니다.

#### 요구사항 5번
- [x] 연산 결과 10개를 저장할 수 있는 배열을 선언 및 생성하고 연산의 결과를 저장합니다.
  - [x] 연산의 결과를 저장할 수 있도록 적합한 타입의 배열을 생성합니다.
  - [x] 연산의 결과를 비어있는 곳에 저장하기 위해 저장할 때마다 count 합니다.

#### 요구사항 6번
 - [x] 연산 결과가 10개를 초과하는 경우 가장 먼저 저장된 결과를 삭제하고 새로운 연산 결과가 저장될 수 있도록 소스 코드를 수정합니다.

#### 요구사항 7번
 - [x] 연산 결과가 10개로 고정되지 않고 무한이 저장될 수 있도록 소스 코드를 수정합니다.
   - [x] JCF(Java Collection Framework)를 사용합니다
   - [x] “remove”라는 문자열을 입력받으면 가장 먼저 저장된 결과가 삭제될 수 있도록 구현합니다

#### 요구사항 8번
 - [x] "inquiry”라는 문자열이 입력되면 저장된 연산 결과 전부를 출력합니다.
   - [x] foreach(향상된 for문)을 활용하여 구현 해봅니다.

## Level 2

### 학습 목표
- 클래스 & 메서드 이해하기
- 생성자 & 접근 제어자 이해하기
- static & final 이해하기
- 상속(&포함) & 다형성 이해하기
- Exception & 예외처리 이해하기

### 과제 요구사항

#### 요구사항 1번
- [x] 양의 정수 2개(0 포함)와 연산 기호를 매개변수로 받아 사칙연산(+,-,*,/) 기능을 수행한 후 결과 값을 반환하는 메서드와 연산 결과를 저장하는 컬렉션 타입 필드를 가진 Calculator 클래스를 생성합니다.
  - [x] 나눗셈에서 분모에 0이 들어오거나 연산자 기호가 잘 못 들어온 경우 적합한 Exception 클래스를 생성하여 throw 합니다. (매개변수로 해당 오류 내용을 전달합니다.)

#### 요구사항 2번
- [x] Level 1에서 구현한 App 클래스의 main 메서드에 Calculator 클래스가 활용될 수 있도록 수정합니다.
  - [x] 연산 수행 역할은 Calculator 클래스가 담당합니다.
    - [x] 연산 결과는 Calculator 클래스의 연산 결과를 저장하는 필드에 저장됩니다.
  - [x] 소스 코드 수정 후에도 수정 전의 기능들이 반드시 똑같이 동작해야합니다.

#### 요구사항 3번
- [ ] App 클래스의 main 메서드에서 Calculator 클래스의 연산 결과를 저장하고 있는 컬렉션 필드에 직접 접근하지 못하도록 수정합니다. (캡슐화)
  - [ ] 간접 접근을 통해 필드에 접근하여 가져올 수 있도록 구현합니다. (Getter 메서드)
  - [ ] 간접 접근을 통해 필드에 접근하여 수정할 수 있도록 구현합니다. (Setter 메서드)
  - [ ] App 클래스의 main 메서드에서 위에서 구현한 메서드를 활용 해봅니다.

#### 요구사항 4번
- [ ] Calculator 클래스에 저장된 연산 결과들 중  가장 먼저 저장된 데이터를 삭제하는 기능을 가진 메서드를 구현한 후 App 클래스의 main 메서드에 삭제 메서드가 활용될 수 있도록 수정합니다.

#### 요구사항 5번
- [ ] Calculator 클래스에 저장된 연산 결과들을 조회하는 기능을 가진 메서드를 구현한 후 App 클래스의 main 메서드에 조회 메서드가 활용될 수 있도록 수정합니다.

#### 요구사항 6번
- [ ] Calculator 인스턴스를 생성(new)할 때 생성자를 통해 연산 결과를 저장하고 있는 컬렉션 필드가 초기화 되도록 수정합니다.

#### 요구사항 7번
- [ ] Calculator 클래스에 반지름을 매개변수로 전달받아 원의 넓이를 계산하여 반환해주는 메서드를 구현합니다.
  - [ ] APP 클래스의 main 메서드에 Scanner를 활용하여 사칙연산을 진행할지 원의 넓이를 구할지 명령어를 입력 받은 후 원의 넓이를 구하는 것을 선택했을 때 원의 반지름을 입력 받아 원의 넓이를 구한 후 출력되도록 구현합니다.
    - [ ] 기존에 구현되어있던 사칙연산 기능은 수정 후에도 반드시 이전과 동일하게 동작해야합니다.
  - [ ] static, final 키워드 활용하고 설명과 활용한 이유에 대해 주석으로 작성
  - [ ] 원의 넓이 결과를 저장하는 컬렉션 타입의 필드 선언 및 생성
    - [ ] 계산된 원의 넓이를 저장합니다.
    - [ ] 생성자로 초기화됩니다.
    - [ ] 외부에서 직접 접근할 수 없습니다.
    - [ ] Getter, Setter 메서드를 구현합니다.
    - [ ] 원의 넓이 결과값들을 조회하는 메서드를 구현합니다.

#### 요구사항 8번
- [ ] 사칙연산을 수행하는 계산기 ArithmeticCalculator 클래스와 원과 관련된 연산을 수행하는 계산기 CircleCalculator 클래스 2개를 구현합니다.
  - [ ] 기존에 만들어둔 Calculator 클래스를 수정합니다
  - [ ] 수정한 Calculator 클래스를 활용하여 ArithmeticCalculator, CircleCalculator 클래스를 구현 해봅니다. (상속)
  - [ ] 구현한 클래스들을 활용하여 오류가 발생하지 않고 활용될 수 있도록 수정 

#### 요구사항 9번
- [ ] ArithmeticCalculator 클래스의 연산 메서드에 책임(역할)이 많아 보입니다. 사칙연산 각각의 기능을 담당하는 AddOperator, SubtractOperator, MultiplyOperator, DivideOperator 클래스를 만들어 연산 메서드의 책임을 분리 해봅니다. (SRP)
  - [ ] Calculator 클래스에 사칙연산 클래스들을 활용. (포함 관계)
  - [ ] 사칙연산 클래스들을 초기화 해야하는데 이때, 반드시 생성자를 활용
  - [ ] ArithmeticCalculator 클래스의 연산 메서드를 수정 하더라도 이전과 똑같이 동작해야합니다.

#### 요구사항 10번
- [ ] ArithmeticCalculator 클래스에 추가로 나머지 연산(%) 기능을 추가하기 위해 ModOperator 클래스를 만들어 추가합니다
  - [ ] 소스 코드의 변경은 최소화하면서 기능을 쉽게 추가(확장)할 수 있는 방법을 고민 해봅니다. (OCP) 
  - [ ] 수정 후에도 이전과 똑같이 동작해야합니다.

## Level 3

### 학습 목표
- Enum 이해하기
- 제네릭스 이해하기
- 람다 & 스트림 이해하기

### 과제 요구사항

#### 요구사항 1번
- [ ] Enum 타입을 활용하여 연산자 타입에 대한 정보를 관리하고 이를 사칙연산 계산기 ArithmeticCalculator 클래스에 활용 해봅니다.

#### 요구사항 2번
- [ ] 양의 정수 뿐만 아니라 실수, 즉 double 타입의 값을 전달 받았을 경우에도 연산이 수행되도록, 즉 피연산자를 여러 타입으로 받을 수 있도록 기능을 확장하고 싶습니다. 
- [ ] 위 요구사항을 만족할 수 있도록 ArithmeticCalculator 클래스를 수정합니다. (제네릭스) 
- [ ] 추가적으로 수정이 필요한 다른 클래스나 메서드가 있다면 같이 수정 해주세요.

#### 요구사항 3번
- [ ] 저장된 연산 결과들 중 Scanner로 입력받은 값보다 큰 결과 값 들을 출력하고 싶습니다.
  - [ ] ArithmeticCalculator 클래스에 위 요구사항을 만족하는 조회 메서드를 구현합니다.
  - [ ] 해당 메서드를 구현할 때 Lambda & Stream을 활용하여 구현합니다


## 입력
- 계산 입력
  - [ ] 첫번째 입력 : 첫번째 피연산자를 입력 받습니다
  - [ ] 두번째 입력 : 두번째 피연산자를 입력 받습니다
  - [ ] 세번째 입력 : 적용할 사칙연산자 하나를 기호로 입력받는다.
- 명령어 입력
  - [ ] 조회 입력 : “inquiry”라는 문자열이 입력되면 저장된 연산 결과 전부를 출력합니다.
  - [ ] 제거 입력 : “remove”를 입력시 첫번째 계산값 제거
  - [ ] 종료 입력 : "exit" 입력시 프로그램 종료

## 출력
- 입력 안내 출력
  - [ ] 첫번째 입력을 받기전  첫번째 숫자 입력을 요구하는 안내문 출력
  - [ ] 두번째 입력을 받기전  두번째 숫자 입력을 요구하는 안내문 출력
  - [ ] 세번째 입력을 받기전  사칙연산 기호를 입력 요구하는 안내문 출력
- 결과 출력
  - [ ] 잘못된 입력시 오류에 대한 내용을 출력합니다
  - [ ] 올바른 입력시 해당연산 결과값 출력
- 추가 로직 확인 출력
  - [ ] 저장된 값을 삭제할지 여부 확인 메세지 출력
  - [ ] 저장된 연산결과 조회 여부 확인 메세지 출력
  - [ ] 추가적인 계산을 실행할지의 여부 확인 메세지 출력
- 저장된값 조회
  - [ ] 저장된 연산 결과 전부를 출력
  - [ ] 저장된 연산 결과들 중 입력받은 값보다 큰 결과 값 들을 출력
