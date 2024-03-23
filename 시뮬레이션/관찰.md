2시 5분에서 4시 1분이 되려면 몇 분이 흘러야 할까?

단순히 다음과 같이 2시 5분에서 시작해서 1분 단위로 시뮬레이션을 하면된다.

60분이 되면 시간을 늘리고 분을 다시 0으로 맞추는 식으로 진행하면 된다.

```java
public class Main {
    public static void main(String[] args) {
        int hour = 2, mins = 5;
        int elapsedTime = 0;

        while(true) {
            if(hour == 4 && mins == 1)
                break;
            
            elapsedTime++;
            mins++;

            if(mins == 60) {
                hour++;
                mins = 0;
            }
        }
        
        System.out.print(elapsedTime);
    }
}
```

하지만 이런 경우에는 0시 0분에서 시작하여 각 시간까지 걸리는 분을 계산하여 그 차이를 계산하는식으로 진행하면 시뮬레이션을 직접 진행하지 않더라도 답을 쉽게 구할 수 있게 된다.

![image](https://github.com/gusdn0108/TIL/assets/96761523/6cee46f4-4d11-4fe4-b835-cf9945f29707)
