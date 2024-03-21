```java
public class Main {
    public static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
        System.out.println(a + " " + b);
    }

    public static void main(String[] args) {
        int n = 10, m = 20;
        swap(n, m);
        System.out.println(n + " " + m);
    }
}
```

코드를 이렇게 작성할경우

결과값은 

20 / 10
10 / 20

이렇게 나오게된다

결과를 해석해자면 swap 함수가 호출된 이후에 n,m 값은 바뀌지 않게 되어10,20 이 그대로 출력이 된다

근데 왜 이렇게 될까?

java 에서는 함수에 인자를 넘길 때 끼본적으로 값을 복사해서 넘겨주게 된다.

즉 n,m 자체가 넘어가는게 아닌 n,m에 적혀있떤 값인 10,20이 a,b라는 새로운 변수에 복사되어 넘어가게 된다.

이러한 현상을 call by value 라고 부른다.

값을 복사해서 넘겼기 때문에 , 함수 안에서는 a,b 값이 서로 바뀌어 실제 20 10 이라는 결과가 나오게 되었지만 , 함수를 빠져나온 뒤 n,m값에는 아무런 변화가 없기 때문에 이후 출력 결과는 10 ,20 이 되는것이다.

![image](https://github.com/gusdn0108/TIL/assets/96761523/ee7368e5-739a-431c-8eed-bc03511feb6a)


그렇다면 같은 패턴을 이용하여 , 함수 호출 이후에 실제 n,m 값을 바뀌게 할수 없을까?

결론부터 말하자면 불가능하다.

이를 이해하기 위해서는 먼저 JVM 메모리에 변수가 어떻게 되는지를 이해해야 한다.

``int, char, double과 같은 primitive type의 변수들은 변수와 그 변수에 들어있는 값이 모두 Stack에 저장됩니다.
하지만 String, Integer, Array와 같은 reference type의 경우 그 객체(값)는 Heap 영역에 저장되고, Stack 영역에 있는 변수가 객체의 주소값을 갖고 있습니다.``

예시를 들어보자

```java
class IntWrapper {
    int value;
    public IntWrapper(int value) {
        this.value = value;
    }

    public class main {
        public static void main(String[] args) {
            int n = 10;
            IntWrapper m = new IntWrapper(20);
        }
    }
}
```

![image](https://github.com/gusdn0108/TIL/assets/96761523/183e60bf-b080-4a8b-aab5-85554bad9409)

primitive tpye 과 referendce type 에 해당하는 값을 저장하는 방법 차이 때문에 java는 항상 call by value 방식을 따름에도 불구하고 Call By Reference 처럼 동작한다는 오해를 종종 받고는 한다.

이해를 돕기 위해 이 코드를 살펴보자.

```java
class IntWrapper {
    int value;

    public IntWrapper(int value) {
        this.value = value;
    }
}

public class Main {
    public static void modify(IntWrapper n, IntWrapper m) {
        n.value = 50;
        m = new IntWrapper(60);
        System.out.println(n.value + " " + m.value);
    }

    public static void main(String[] args) {
        IntWrapper n = new IntWrapper(10);
        IntWrapper m = new IntWrapper(20);
        modify(n, m);
        System.out.println(n.value + " " + m.value);
    }
}
```


이 코드의 결과는 어떻게 될까? 

답은

50 60
50 20 

이 된다.

과정을 천천히 따라가보면 그 답이 보인다.

먼저 main 함수 안에서 정의 된 n,m은 reference type 이기에 객체 정보가 heap 영역에 저장됩니다.


![image](https://github.com/gusdn0108/TIL/assets/96761523/7ba39a71-dcf6-41cc-8284-cd71f34a111b)

이제 modifiy 함수를 호출하게 된다.

이때reference type 인 변수를 함수의 임자로 넘기게 되면 해당 객체를 가리키는 새로운 변수가 stack 영역에 정의가 된다.

`이 부분 이 가장 중요하다.`

이러한 이유 때문에 java 는 항상 call by value 원칙을 따르게 된다.

![image](https://github.com/gusdn0108/TIL/assets/96761523/96e2c40f-01cd-4d02-a579-efc05222289f)


modify 함수에서의 n은 main 안에서 만들어진 객체 값을 참조할 수 있기에 n.value 값을 바꿀시에는 실제 main 함수에서 만들어진 객체의 값이 10에서 50으로 바뀌게 된다.

![image](https://github.com/gusdn0108/TIL/assets/96761523/8e8ad663-325d-4f06-88bb-3fa1c3308dca)


하지만 이때 modify 함수에서 변수 m의 역할을 단지 Heap 에 정의된 객체를 가르키는 것 뿐이기에 IntWrapper(60) 이라는 객체를 새로 할당하더라도 변수 m은 새로운 객체를 가르키게 되므로

main함수에서의 m의 값에는 아무런 변동이 생기지 않게 된다.

![image](https://github.com/gusdn0108/TIL/assets/96761523/a8c15b68-79f2-4449-babe-8fbb1c33bbb2)


따라서 java 에서 우리가 원하는 swap 함수는 primitive type 을 이용해서는 절대 불가능하다.

즉 java 에서의  swap 은 reference type 을 이용하여 다음과 같이 구현해야만 한다...


```java
class IntWrapper {
    int value;

    public IntWrapper(int value) {
        this.value = value;
    }
}

public class Main {
    public static void swap(IntWrapper n, IntWrapper m) {
        int temp = n.value;
        n.value = m.value;
        m.value = temp;
    }

    public static void main(String[] args) {
        IntWrapper n = new IntWrapper(10);
        IntWrapper m = new IntWrapper(20);

        swap(n, m);

        System.out.println(n.value + " " + m.value); // 20 10
    }
}
```





