package ch04.sec02;

public class IfElseIfElseExample {
    public static void main(String[] args) {
        int score = 75;

//        조건이 여러개일 경우 else와 ifㄴㄴ 무한정 추가 가능하지만 if 와 else는 한개씩 사용해야한다
        if (score >= 90) {
            System.out.println("점수가 90~100입니다");
            System.out.println("등급은 A입니다");
        }else if (score >= 80) { /* 80 <=score< 90일경우 */
            System.out.println("점수가 80~89입니다");
            System.out.println("등급은 B입니다");
        }else if (score >= 70) { /* 70 <=score< 80일경우 */
            System.out.println("점수가 70~79입니다");
            System.out.println("등급은 C입니다");
        }else{                   /* score< 70일경우 */
            System.out.println("점수가 70미만 입니다");
            System.out.println("등급은 D입니다");
        }
    }
}
