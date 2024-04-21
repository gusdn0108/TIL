package foreach;

public class Foreach {
    public static void main(String[] args) {
        int[] numbers = {1,2,3,4,5,6};

        // 일반 for문
        for (int i = 0; i < numbers.length; i++) {
            int number =numbers[i];
            System.out.println(number);
        }

        // 결과값 : 1,2,3,4,5,6 잘뜸

        // 상향된 for 문 for -each 문
        // 배열의 인덱스 사용 x
        // 종료 조건 x
        // 그냥 단순하게 배열을 처음부터 끝까지 탐색함.
        // :의 오른쪽에 numbrs와 같이 탐색할 배열을 선택 : 의 왼쪽에 int number 와 같이 반복할때 마다 찾은 값을 저장할 변수를 선언 해줌.
        // 인덱스를 사용하지 않고도 배열의 요소를 순회할수 있기때문에 코드가 간결하고 가독성이 좋음 ..
        for (int number : numbers) {
            System.out.println(number);
        }

        // 향상된 for문을 사용하지 못하는 경우도 존재
        // for문에는 증가하는 인덱스 값이 감추어져 있음 int i와 같은 증가하는 인덱스 값을 직접 사용해야하는 경우 for-each문을 사용할수 없음..

    }
  
}
