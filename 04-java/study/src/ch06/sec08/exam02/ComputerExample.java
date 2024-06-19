package ch06.sec08.exam02;

public class ComputerExample {
    public static void main(String[] args) {
        Computer myCom = new Computer(); /*컴퓨터 객체 생성*/
        
//        sum()메소드 호출 시 매개값 1,2,3 울 제공 , 합산 한 결과를 리턴 받아 result변수에 대입
        int result1 = myCom.sum(1,2,3);
        System.out.println("result1: " + result1);


    //    sum()메소드 호출 시 매개값 1,2,3,4,5 울 제공 , 합산 한 결과를 리턴 받아 result2변수에 대입
    int result2 = myCom.sum(1,2,3,4,5);
        System.out.println("result2: " + result2);

    //        sum()메소드 호출 시 배열울 제공 , 합산 한 결과를 리턴 받아 result3변수에 대입
    int[] values = {1,2,3,4,5};
    int result3 = myCom.sum(values);
        System.out.println("result3: " + result3);

    int result4 = myCom.sum(new int[] {1,2,3,4,5});
            System.out.println("result4:" +result4);
}
}
