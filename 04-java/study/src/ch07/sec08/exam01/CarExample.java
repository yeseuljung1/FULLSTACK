package ch07.sec08.exam01;

public class CarExample {
    public static void main(String[] args) {
//        car 객체 생성
        Car myCar = new Car();
//        동일하게 myCar의 run 메소드를 호출했지만 다 다른 값이 호출됨
        
//       tire객체 장착
//        tire 객체 하나를 생성해서 car 클래스의 tire 필드에 널어줌
        myCar.tire = new Tire();
//        tire의 rnn 메소드 호출
        myCar.run();
        
//        힌국 타이어 객체 장착
        myCar.tire = new HankookTire();
        //        한국tire의 rnn 메소드 호출
        myCar.run();

    //        금호 타이어 객체 장착
        myCar.tire = new KumhoTire();
    //        금호tire의 rnn 메소드 호출
        myCar.run();
}
}
