package ch02.sec08;

public class CastingExample {
    public static void main(String[] args) {
        int var1 = 10;
//        큰값을 작은 값에 넣을 때는 명시적으로 형변환을 해줘야한다(케스팅)
        byte var2 = (byte) var1;
        System.out.println(var2); /*강제 타입 변환 후에 10이 그대로 유지*/

        long var3 = 300;
        int var4 = (int) var3;
        System.out.println(var4); /*강제 타입 변환 후에 300이 그대로 유지*/

        int var5 = 65;
        char var6 = (char) var5;
        System.out.println(var6);/*'A'가 출력*/

//        실수를 정ㅇ수에 넣을 경우 소수점 이하 값은 버려진다
        double var7 = 3.14;
        int var8 = (int) var7;
        System.out.println(var8);/*3이 출력*/
    }
}
