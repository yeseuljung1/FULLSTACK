package ch04.sec02;

public class IfNestedExample {
    public static void main(String[] args) {
        int score = (int)(Math.random()*20) + 81;
        System.out.println("점수: " + score);

        String grade;
//        중첩if문 :if문 안에 if문 ======다 못 씀 값 90으로 나와야하는데 100으로 나옴
        if(score>=90){
        if (score >= 95) {
            grade = "A+";
        }else{
            grade = "A";
        }
    }else {
            if (score >= 85) {
                grade = "B+";
            }else{
                grade = "B";
            }
        }
        System.out.println("학점:" +grade);
    }
}
