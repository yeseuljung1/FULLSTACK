package ch07.sec04.exam01;

public class ComputerExample {
    public static void main(String[] args) {
        int r = 10;
        Calculator calculator = new Calculator();
//       calculator 클래스의 areacircle 호출
        System.out.println("원 면적: " +calculator.areaCircle(r));
        System.out.println();

        Computer computer = new Computer();
        //       computer 클래스의 areacircle 호출
        System.out.println("원 면적: " +calculator.areaCircle(r));
    }
}
