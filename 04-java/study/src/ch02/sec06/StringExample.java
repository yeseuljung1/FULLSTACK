package ch02.sec06;

import java.awt.*;

public class StringExample {
        public static void main(String[] args) {
            String name ="홍길동";
            String job ="프로그래머";
System.out.println(name);
System.out.println(job);

//""은 문자열을 표시하므로 직접 문자열에 추가하기 위해서느 \을 붙여줘야함
String str = "나는 \"자바\"를 배웁니다.";
System.out.println(str);

//위에 정의한 str 변수를 변경해줌
//             t는 탭하나 추가
str = "번호\t이름\t직업";
System.out.println(str);

//            println은 출력후 줄 바꿈,print은 줄바꿈없이 출력
            System.out.println("나는\n");
            System.out.println("자바를\n");
            System.out.println("배웁니다\n");
        }
}
