package ch03.sec04;

public class AccuracyExample1 {
    public static void main(String[] args) {
        int apple = 1; /* 정수 */
        double pieceUnit = 0.1;
        int number = 7;

//        부동소수점의 졍우 이진수의 ㅣ한계로 정확한 계산이 어렵다
        double result = apple - number * pieceUnit;
        System.out.println("사과 1개에서 남은 양" +result);
    }
}
