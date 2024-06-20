package ch07.sec02;

public class SmartPhoneExample {
    public static void main(String[] args) {
//        smartphone 객체 생성
        SmartPhone myphone  = new SmartPhone("갤럭시","은색");

//        phone으로 부터 상속 받은 필드 읽기
        System.out.println("모델:" +myphone.model);
        System.out.println("색상:" +myphone.color);

//        Smartphone 의 필드 읽기
        System.out.println("와이파이 상태:" + myphone.wifi);

//       phone 우로 부터 상속박은 메소드 호출
        myphone.bell();
        myphone.sendVoice("여보세요");
        myphone.receiveVoice("안녕하세요! 저는 홍길동 인데요.");
        myphone.sendVoice("아 네 반갑습니다");
        myphone.hangUp();
        
//       smartphone 의 메소드 호출
myphone.setWifi(true);
myphone.internet();
    }
}
