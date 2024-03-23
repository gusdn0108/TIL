// 2011년 m1월 d1일로부터 2011년 m2월 d2일까지는 총 며칠이 있는지를 계산하는 프로그램을 작성해보자
// 2011년은 윤년이 아닌 해이기 때문에 2월은 28일까지 있습니다. 단, 날짜 계산시 시작일을 포함하여 세도록 한다.

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m1 = sc.nextInt();
        int d1 = sc.nextInt();
        int m2 = sc.nextInt();
        int d2= sc.nextInt();

        int[] month_of_days = new int[]{ 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int elapsedTime = 0;

        while (true){
            if(m1 ==m2 && d1 == d2){
                break;
            }
            elapsedTime++;
            d1++;

            if(d1 > month_of_days[m1]){
                m1++;
                d1 = 1;
            }

        }

        System.out.println(elapsedTime+1);
    }

}

