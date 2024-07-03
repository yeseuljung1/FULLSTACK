package V3.command;

import V3.domain.StudentScores;
import V3.Input;

public class InitScoresCommand implements Command{
    StudentScores studentScores = StudentScores.getInstance();
    @Override
    public void execute() {
//        getIntㄹ를 사용해서 사용자한테 학생수를 입력받음
        int studentNum = Input.getInt("학생수> ");
//        setStudentNum과 점수 배열의 크기를 할당
        studentScores.setStudentNum(studentNum);
    }
}
