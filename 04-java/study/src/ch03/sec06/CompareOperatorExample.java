package ch03.sec06;

public class CompareOperatorExample {
    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 10;
        boolean result1 = (num1 == num2);/*num1 과 num2가 같니?*/
        boolean result2 = (num1 != num2);/*num1 과 num2가 다르니?*/
        boolean result3 = (num1 <= num2);/*num2 가 num1 보다 같거나 크니?*/
        System.out.println("result1:" + result1);
        System.out.println("result2:" + result2);
        System.out.println("result3:" + result3);

        char char1 = 'A';
        char char2 = 'B';
        boolean result4 = (char1 < char2);/*65<66*//*a의 아스키코드값(65)보다 b의 아스키코드값(66)이 크니?*/
        System.out.println("result4:" + result4);

        int num3 = 1;
        double num4 = 1.0;
        boolean result5 = (num3 == num4); /*더블로 변경돼서 둘 다 같다고 나옴*/
        System.out.println("result5:" + result5);

        float num5 = (float) 1.0f;
        double num6 = 1.0;
        boolean result6 = (num5 == num6); /*false*/
        boolean result7 = (num5==(float)num6);/*true*/
        System.out.println("result6:" + result6);
        System.out.println("result7:" + result7);

        String str1 = "자바";
        String str2 = "Java";
         boolean result8 = (str1.equals(str2)); /* string끼리 비교 할 떄는 equlas 사용*/
         boolean result9 = (! str1.equals(str2));/* 나온 결과값을 반대로 뒤집을 떄는 앞에 !붙임*/
         System.out.println("result8:" + result8);
         System.out.println("result9:" + result9);
    }
}
