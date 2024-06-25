package ch08.sec08;


//인터페이스는 다중상속 가능
public class SmartTelevision implements RemoteControl, Searchable  {
//    turnon() 추상 메소드 오버라이딩
//    remotecontrol의 turn on turnoff 구현
    @Override
    public void turnOn() {
        System.out.println("TV를 켭니다");
    }
    //    turnoff() 추상 메소드 오버라이딩
    @Override
    public void turnOff() {
        System.out.println("TV를 끕니다");
    }

    //    serach() 추상 메소드 오버라이딩
    @Override
    public void search(String url) {
        System.out.println(url +" 을 검색합니다");
    }

}
