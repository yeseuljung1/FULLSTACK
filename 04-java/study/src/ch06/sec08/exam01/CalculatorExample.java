package ch06.sec08.exam01;

public class CalculatorExample {
    public static void main(String[] args) {
        Caculator myCalc = new Caculator(); /*calculator 객체 생성*/
        
        myCalc.powerOn(); /*리턴값이 없는 poweron으로 메소드 호출*/

//        plus 메소드 호출 시 5와 6을 매개값으로 제고하고 \
//        덧셈 결과를 리턴박아 result 변수에 대입
        int result1 = myCalc.plus(5,6);
        System.out.println("result1:" + result1);

        int x = 10;
        int y = 4;

        double result2 = myCalc.divide(x,y);
        System.out.println("result2:" + result2);

        myCalc.powerOff();
    }
}
