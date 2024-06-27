package V1;

import java.util.Scanner;

public class App {
//    아래 메소드어서 사용 할 변수는 위로 정리해줌
    boolean run = true;
    int studentNum = 0;
    int[] scores = null;
    Scanner scanner = new Scanner(System.in);
    public void printMenu() {
        System.out.println("--------------------------------------------------------------");
        System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
        System.out.println("--------------------------------------------------------------");
    }
//    getSelect : 사용자가 입력한 메뉴번호 리턴
    public int getSelect() {
        System.out.print("선택> ");
        return Integer.parseInt(scanner.nextLine());
    }

//   analize :  4번 메뉴만 분석 기능 처리하느 메서드
    private void analize() {
        int max = 0;
        int sum = 0;
        double avg = 0;
        for(int i=0; i <scores.length; i++) {
            max = (max<scores[i])? scores[i] : max;
            sum += scores[i];
        }
        avg = (double) sum / studentNum;
        System.out.println("최고 점수: " + max);
        System.out.println("평균 점수: " + avg);
    }
    
//    getStudentNum : 1번 메뉴인 학생 수 받아주는 기능 처리하는 메소드
    public void getStudentNum() {
        System.out.print("학생수> ");
        studentNum = Integer.parseInt
                (scanner.nextLine());
        scores = new int
                [studentNum];
    }

//    getScores : 2번 메뉴인 점수 입력기능 처리하는 메소드
    public void getScores() {
        for(int i=0; i<scores.length; i++) {
            System.out.print("scores[" + i + "]> ");
            scores[i] = Integer.parseInt(scanner.nextLine());
        }
    }
    
//    printScore ; 3번 메누인 점수 출력 기능 처리하는 메서드
    public void printScore() {
        for(int i=0; i<scores.length; i++) {
            System.out.println("scores[" + i + "]: " + scores[i]);
        }
    }
    
//   exit : 5번메뉴인 종료 기능 처리하는 메소드
    public void exit() {
        run = false;
    }
    
//    executeCommand : 만들어둔 메소드들을 사용자의 입력값에 따라 호출
    public void executeCommand
            (int selectNo) {
        if(selectNo == 1) {
            getStudentNum();
        } else if(selectNo == 2) {
            getScores();
        } else if(selectNo == 3) {
            printScore();
        } else if(selectNo == 4) {
            analize();
        } else if(selectNo == 5) {
            exit();
        }
    }
    public void run() {
        while(run) {
            printMenu();
            int selectNo = getSelect();
            executeCommand
                    (selectNo);
        }
        System.out.println("프로그램 종료");
    }
    public static void main(String[] args) {
        App app = new App();
        app.run();
    }
}

