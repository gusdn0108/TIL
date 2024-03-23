2월 5일에서 4우러 1일 되려면 몇 일이 흘러야 하는지 계산하려면 어떻게 코드를 작성해야할까 ?

단 , 해당 연은 윤년이 아니기 때문에 2월은 28일까지 있다.

단순히는 다음과 같이 2월 5일에서 시작하여 1일 단위로 시뮬레이션을 하며 해당 월에 있는 일 수를 넘어가게 되면 그 다음달로 넘기고 일자를 다시 1로 맞추는 식으로 진행해 볼수 있다.

하지만 각 월마다 몇 일이 있는지를 배열로 저장하면 코드를 굉장히 간결하게 구현할수 있다.

```java
public class Main {
    public static void main(String[] args) {
        int month = 2, day = 5;
        int elapsedDays = 0;

        //                                1.  2.  3.  4.  5.  6.  7.  8.  9. 10. 11. 12.
        int[] num_of_days = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        while(true) {
            if(month == 4 && day == 1)
                break;
        
            elapsedDays++;
            day++;
        
            if(day > num_of_days[month]) {
                month++;
                day = 1;
            }
        }
        
        System.out.print(elapsedDays);
    }
```
이런식으로 말이다.

하지만 이런 경우는 1월1일에서 시작하여 각 날짜까지 총 몇 일이 있는지를 계산하여 그 차이를 계산하는 식으로 진행하면 시뮬레이션을 직접 진행하지 않더라도 답을 쉽게 구할수 있게 된다.

![image](https://github.com/gusdn0108/TIL/assets/96761523/e9378d4b-f692-433e-991f-af8b86e8d309)
