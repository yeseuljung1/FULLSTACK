package ch07.sec04.exam02;

public class ComputerExample {
    public static void main(String[] args) {
        SupersonicAirplane sa = new SupersonicAirplane();
        sa.takeOff();
        sa.fly();
        
//        static값은 클래스 명으로 접슨 
//        flayMode를 SUPERSONIC으로 변경해줌
        sa.flyMode = SupersonicAirplane.SUPERSONIC;
//        flayMode 가 SUPERSONIC으로 변경됐으므로 if문을 통해 자식의 코드 출력
        sa.fly();
        sa.flyMode = SupersonicAirplane.NORMAL;
//        다시 NORMAL으로 변경 댔으므로 Airplane의 fly 호출
        sa.fly();
//        Airplane의 land 메소드 실행
        sa.land();
    }
}
