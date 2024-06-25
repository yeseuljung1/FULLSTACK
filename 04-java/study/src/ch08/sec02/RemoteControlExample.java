package ch08.sec02;

public class RemoteControlExample {
    public static void main (String[] arge) {
        RemoteControl rc;

//        rc변수에 텔레비젼 객체를 대입
        rc = new Television();
        rc.turnOn();

//        re변수에 Audio 객체를 대입(교체시킹)
        rc = new Audio();
        rc.turnOn();
    }
}
