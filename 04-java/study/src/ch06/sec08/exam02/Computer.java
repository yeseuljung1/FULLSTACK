package ch06.sec08.exam02;

public class Computer {
//    가변길이 매개변수를 갖는 메소드 선언
    int sum(int ... valuses) {

        int sum = 0;

        for (int i = 0; i < valuses.length; i++) {
            sum += valuses[i];
        }

        return sum;
    }
}
