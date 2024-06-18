package ch02.sec01;

public class VariableUseExample {
    public static void main(String[] args) {
        int hour = 3;
        int minute = 5;
//        문자와 변수를 이어줄 떄는 +로 이어준다
//        문자열은 ""으로 감싸주고 변수는 변수 이름만 작성
        System.out.println(hour + "시간" + minute + "분");

        int totalMinutes = (hour * 60) + minute;
        System.out.println("총" + totalMinutes + "분");
    }
}
