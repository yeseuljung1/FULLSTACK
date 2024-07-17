package V3;

import V3.command.*;

import java.util.Scanner;

public class App {
    // 아래 메소드에서 사용할 변수는 위로 정리해줌
    Scanner scanner = new Scanner(System.in);
    int studentNum = 0;
    int[] scores = null;

    Menu menu;
    Command[] commands;

    public App() {
        // 생성자에서 menu 객체 생성해서 초기화
        menu = new Menu();
        commands = new Command[]{
                new InitScoresCommand(), /*1. 학생수 입력 */
                new GetScoresCommand(), /*2. 점수 입력 */
                new PrintScoreCommand(), /*3. 점수 출력 */
                new AnalizeCommand(), /*4. 분석 */
                new ExitCommand() /*5. 종료 */
        };
    }

    // executeCommand : 만들어둔 메소드들을 사용자의 입력값에 따라 호출
    public void executeCommand(int selectNo) {
        // 인덱스로 접근해야 하기 때문에 사용자가 입력한 번호에서 -1 해줌
        Command command = commands[selectNo - 1];
        // 가져온 커맨드의 execute가 실행된다.
        command.execute();
    }

    public void run() {
        while (true) {
            menu.printMenu();
            int selectNo = menu.getSelect();
            executeCommand(selectNo);
            // 사용자가 입력한 값이 5일 때 while문을 종료시킴
            if (selectNo == 5) {
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


//필요 없어서 이제 삭제함
// getStudentNum : 1번 메뉴인 학생 수 받아주는 기능 처리하는 메소드
//    public void getStudentNum() {
//        System.out.print("학생수> ");
//        studentNum = Integer.parseInt
//                (scanner.nextLine());
//        scores = new int
//                [studentNum];
//    }
//
////    getScores : 2번 메뉴인 점수 입력기능 처리하는 메소드
//    public void getScores() {
//        for(int i=0; i<scores.length; i++) {
//            System.out.print("scores[" + i + "]> ");
//            scores[i] = Integer.parseInt(scanner.nextLine());
//        }
//    }

////    printScore ; 3번 메누인 점수 출력 기능 처리하는 메서드
//    public void printScore() {
//        for(int i=0; i<scores.length; i++) {
//            System.out.println("scores[" + i + "]: " + scores[i]);
//        }
//    }