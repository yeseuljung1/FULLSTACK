package ch07.sec10.exam01;

public class Dog extends Animal {

//    추상 메소드는 자식 클래스에서
//    추상 메소드 정의
    @Override
    public void sound() {
        System.out.println("멍멍");
    }
}
