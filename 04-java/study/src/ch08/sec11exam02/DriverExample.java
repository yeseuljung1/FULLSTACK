package ch08.sec11exam02;

public class DriverExample {
    public static void main(String[] args) {
//        driver 객체 생성
        Driver driver = new Driver();

//        vehicle 구현 객체 생성
        Bus bus = new Bus();
        Taxi taxi = new Taxi();

//        매개값으로 구현 객체 대입(다향성 : 실행 결과가 다름)
        driver.drive(bus); /*자동 타입 변환  : Bus -> vehicle*/
        driver.drive(taxi); /*자동 타입 변환  : taxi -> vehicle*/

    }
}
