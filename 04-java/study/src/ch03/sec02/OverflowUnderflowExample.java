package ch03.sec02;

public class OverflowUnderflowExample {
    public static void main(String[] args) {
        byte var1 = 125;
                for(int i=0; i<5; i++) { /*{}를 5번 반복 실행*/
                    var1++; /*++연산은 var1의 값을 1 증가시킨다.*//*byte의 범위를 위로 초과할 경우 bbyte의 최소값인 -128로 돌아간다*/
                    System.out.println("var1 = " + var1);
                }

                System.out.println("--------------------");

                byte var2 = -125;
                for(int i=0; i<5; i++) {/*{}를 5번 반복 실행*/
                    var2--;/*++연산은 var1의 값을 1 증가시킨다.*//*byte의 범위를 아래로 초과할 경우 bbyte의 최대값인 127로 돌아간다*/
                    System.out.println("var2 = " + var2);
                }
    }
}
