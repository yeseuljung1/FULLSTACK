package V2;

import java.util.Scanner;

public class Input {
//    Scanner 객체는 하나만 있어도 되기 때문에 static으로 생성(앞에 대문자는 클래스->stactic)
    static Scanner scanner = new Scanner(System.in);
    
//    사용자 한테 입력 받을때 출력할 문구를 title로 받아옴
    public static int getInt(String title) {
        System.out.print(title);
        return Integer.parseInt(scanner.nextLine());
    }
}