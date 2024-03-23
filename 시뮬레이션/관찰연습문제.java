import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

// 2011년 11월 11일 a시 b분에서 시작하여 2011년 11월 11일 c시 d분까지 몇 분이 계산하는 프로그램 작성

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        int elapsedTime = 0;


        while (true){
            if(a == c && b == d ){
                break;
            }

            elapsedTime++;
            b++;

            if(b == 60){
                a++;
                b = 0;
            }
        }

        System.out.println(elapsedTime);
    }

}

