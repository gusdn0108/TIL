이 글을 쓰기전 나는 의문의 들었다..

아직 자바를 공부중이라 자바에 대해서는 잘 모르지만 이것저것 코드를 들여다 보았다.

그래서 인강을 보며 제일 궁금한 부분이 이 부분이 였다.

오버로딩이 뭐임 ???

( 머릿속 상황 )

![img_1.png](img_1.png)

그래도 떠오르는게 하나 있었다 

설마 이거임 !?
![img.png](img.png)

.. 당연히 아니다 
그래도 이름을 보았을때 나는 제일 먼저 떠오른게 이거였다 ( 스타 오버로드 )



# 메서드 오버로딩은 무엇인가?

다음과 같은 메서드를 만들고싶다.

```두 수를 더하는 메서드```

``` 세 수를 더하는 메서드 ```

이 경우 둘다 메서드이기 때문에 가급적 같은 이름인 add 를 사용하고싶을 것..

자바는 메서드의 이름 뿐 아니라 매개변수 정보를 함께 사용해서 메서드를 구분한다.

따라서 이름은 같지만 매개변수가 다른 메서드를 정의 할수 있다.

```java
add(int a , int b)
add(int a , int b, int c)
add(double a, double b)
```

이런식으로 말이다..

하지만 오버로드 할때도 규칙이 있다.

## 오버로드 규칙

```
1.메서드의 이름이 같아도 매개변수의 타입 및 순서가 다르면 오버로딩을 할수 있다. 참고로 반환 타입은 인정하지 않는다.
2. 다음 케이스는 메서드 이름과 매개변수의 타입이 같으므로 컴파일 오류가 발생한다 반환타입은 인정하지 않는다.
```


### fail case

```java
int add(int a, int b)
double add(int a, int b)
```

이렇게 오버로딩을 한다면 컴파일 에러가 뜰 것이다 

메서드 이름이랑 매개변수 가 같지만 반환타입이 다르다면 실패한다!! 


### 용어 : 메서드 시그니처 (method signature)


!!! ```메서드 시그니쳐 = 메서드 이름 + 매개변수 타입(순서)``` !!!

메서드 시그니쳐는 자바에서 메서드를 구분할 수 있는 고유한 식별자나 서명을 뜻함.

메서드 시그니처는 메서드의 이름과 매개변수 타입(순서 포함)으로 구성되어 있다고 한다 쉽게 이야기해서 메서드를 구분할 수 있는 기준이다.

( 필자는 카드 서명으로 좀 이해 했다

5만원 이상일때 서명하듯이 아 접니다 ㅎㅎ 라고 하듯이 .. )

자바 입장에서 는 각각의 메서드를 고유하게 구분할 수 있어야한다 !!! 

```그래야 어떤 메서드를 호출 할 지 결정할 수 있다.```

따라서 메서드 오버로딩에서 설명한 것 처럼 메서드 이름이 같아도 메서드 시그니처가 다르면 다른 메서드로 간주한다.

반환 타입은 시그니처에 포함되지 않는다. 

방금 오버로딩이 fail case 메서드를 보자. 

두 메서드는 add(int a, int b) 로 메서드 시그니처가 같다. 

따라서 메서드의 구분이 불가능하므로 컴파일 오류가 발생한다.



```java
int add(int a ,int b)
int add(int c , int d)
```

이것도 안된다 메서드의 구분이 불가능하므로 컴파일 오류가 발생한다 !!!

정리를 해보자면 오버로딩을 하는 이유와 하기 위한 조건은

```java
# 이유
        
기능이 같아서 가급적 메서드 이름을 똑같이 해주고 싶을때.
        
# 조건
        
1. 메서드 이름은 같아야함.
2. 파라미터의 반환타입이 (모두)? 같으면 오버로딩은 불가하다
```

이 정도로 일단 이해 했다..

```java
아직 솔직히 내용이 전부 와닿지 않는다 코드 예제를 통해서 이해 해 보자...
```


## case 1

```java
public static int add(int a , int b){
        System.out.println("1번 호출");
        return a+b;
    }

    public static int add( int a , int b , int c){
        System.out.println("2번 호출");
        return a+b+c;
    }
```


add 메서드를 오버로딩 해서 a +b + c 까지 매개변수를 늘려주었다 .

아! 매개변수의 타입은 같지만 갯수가 같지 않으면 오버로딩을 할수 있구나 라는걸 알수있다.

```java
    public static void main(String[] args) {
        System.out.println("1:" + add(1,2));
        System.out.println("2:"+ add(1,2,3));
    }
```

메인에 딱 !!! 이렇게 넣어주면 

![img_2.png](img_2.png)

오버로딩 이 잘 된것 을 볼 수 있다.


## case 2

```java
    public static void myMethod(int a,double b){
        System.out.println("int a , double b");
    }

    public static void myMethod(double a,int b){
        System.out.println("double a , int b");
    }
```
이번엔 매개변수 타입이 다른 오버로딩을 예제로 해보자

일단 매개변수 타입이 같지않아서 void로 해주었다.

이제 호출 해보자.

```java
public static void main(String[] args) {
 myMethod(1, 1.2);
 myMethod(1.2, 2);
 }
```

```java
1: 정수1, 실수 1.2를 호출했으므로 myMethod(int a, double b) 가 호출된다.
2: 실수 1.2, 정수 2를 호출했으므로 myMethod(double a, int b) 가 호출된다
```
실행 결과

```java
int a, double b
double a, int b
```

마지막 으로 매개변수의 타입이 아에 다른 경우를 추가로 확인해보자 .

## case 3


```java
 public static int add(int a,int b){
        System.out.println("1번 호출");
         return a+b;
    }

    public static double add(double a , double b){
        System.out.println("2번호출");
        return a+b;
    }
```

첫번째 add 메서드는 두 수의 정수를 받아서 합을 반환하고

두번째 add 매서드는 두 실수를 받아서 합을 반환시켜 주었다.

호출하게 되면

```java

 public static void main(String[] args) {
        System.out.println("1: " + add(1, 2));
        System.out.println("2: " + add(1.2, 1.5));
    }

```

```java
1: 정수1, 정수 2를 호출했으므로 add(int a, int b) 가 호출된다.
2: 실수 1.2, 실수 1.5를 호출했으므로 add(double a, double b) 가 호출된다.
```

실행결과

```java
1번 호출
1: 3
2번 호출
2: 2.7
```

근데 만약 다음 첫 메서드를 삭제하면 어떻게 될까 ???

```java
public static int add(int a, int b) {
 System.out.println("1번 호출");
 return a + b;
}
```


```java
1: int 형 정수 1, int 형 정수 2를 호출했으므로 자동 형변환이 발생해서 add(double a, double b) 가 호출
된다.
2: 실수 1.2, 실수 1.5를 호출했으므로 add(double a, double b) 가 호출된다.
```

실행결과

```java
2번 호출
1: 3.0
2번 호출
2: 2.7
```

이렇게 본인의 타입에 최대한 맞는 메서드를 찾아서 실행하게 되고 
그래도 없으면 형 변환 가능한 타입의 메서드를 찾아서 실행하게 된다.


