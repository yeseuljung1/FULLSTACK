package ch07.sec02;

//phone 클래스의 자식 클래스
public class Phone {
//    필드선언
    public String model;
    public String color;

//    메소드 선언
    public void bell() {
        System.out.println("벨이 울립니다");
    }

    public void sendVoice(String message) {
        System.out.println("자기: "  +message);
    }

    public void receiveVoice(String message) {
        System.out.println("자기: "  +message);
    }

    public void hangUp() {
        System.out.println("전화를 끊습니다");
    }
}
