package V2.V2;

import java.util.Scanner;

public class App {
//    아래 메소드어서 사용 할 변수는 위로 정리해줌
    Scanner scanner = new Scanner(System.in);
    int studentNum = 0;
    int[] scores = null;

    Menu menu;
    public App() {
    //    생성자에서 menu로 객체 생성해서 초기화
        menu = new Menu();
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
        }
    }

    public void run() {
        while(true) {
            menu.printMenu();
            int selectNo = menu.getSelect();
            executeCommand(selectNo);
//            사용자가 입력한 값이 5일 때 while문을 종료시킴
            if(selectNo == 5) {
                break;
            }
        }
        System.out.println("프로그램 종료");
    }
    public static void main(String[] args) {
        App app = new App();
        app.run();
    }
}

