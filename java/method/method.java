package method;

public class MethodRef {
    public static void main(String[] args) {
        // 여러번 같은 계산을 해야 한다면 지금처럼 함수를 만들어두고(정의), 필요한 입력 값을 넣어서 해당 함수를
        //호출하면 된다. 그러면 계산된 결과가 나온다.
        // 함수는 마치 블랙박스와 같다. 함수를 호출할 때는 외부에서는 필요한 값만 입력하면 된다. 그러면 계산된
        //결과가 출력된다.
        //여기서 핵심은 함수를 한번 정의해두면 계속해서 재사용할 수 있다는 점이다

        // 계산1
        int sum1 = add(5,10);
        System.out.println("결과 출력"+sum1);

        // 계산 2
        int sum2  = add(15,20);
        System.out.println("결과2"+sum2);
    }

    public static int add(int a,  int b ){
        System.out.println(a+"+"+b+"연산수행");
        int sum = a + b;
        return sum;
    }


}
