package ch07.sec08.exam02;

import ch07.sec08.exam01.Tire;

public class DriverExample {
    public static void main(String[] args) {
//        diver객체 생성
        Driver driver = new Driver();

//        매개값을 bus객체를 제공하고 driver()메소드 호출
        Bus bus = new Bus();
        driver.drive(bus);

//        매개값으러 taxi 객체를 제공하고 driver()메소드 호출
        Taxi taxi = new Taxi();
        driver.drive(taxi);
    }
}
