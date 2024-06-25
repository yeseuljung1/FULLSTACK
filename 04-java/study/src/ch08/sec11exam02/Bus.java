package ch08.sec11exam02;

public class Bus implements Vehicle{
//    추싱 메소드 재저의
    @Override
    public void run() {
        System.out.println("버스가 달립니다");
    }
}
