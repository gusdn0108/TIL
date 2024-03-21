import java.util.Objects;
import java.util.Scanner;

/*
두 정수 값 교환하기
두 개의 정수 n, m이 주어지면 두 개의 숫자에 있는 값을 교환하여 출력하는 프로그램을 작성해보세요.
단, a, b를 인자로 하는 함수를 작성하여 두 변수에 담겨있는 값을 교환하고 출력은 함수 호출 이후에 진행하도록 합니다.

입력:
13 8
출력:
8 13
*/


class IntWapper {
    int value;

    public IntWapper(int value) {
        this.value = value;
    }
}

public class Main {
    public static void swap(IntWapper n,IntWapper m) {
        int temp = n.value;
        n.value = m.value;
        m.value = temp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        IntWapper nWrapper = new IntWapper(n);
        IntWapper mWrapper = new IntWapper(m);

        swap(nWrapper,mWrapper);

        n = nWrapper.value;
        m = mWrapper.value;

        System.out.println(n+" "+m);
    }

}

