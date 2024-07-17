package V3.command;

import V3.domain.StudentScores;

public class AnalizeCommand implements Command {

    StudentScores studentScores = StudentScores.getInstance();
    @Override
    public void execute() {
//        기조에 저장되어있는 학생들의 점수 리스트를 가져옴
        int [] scores = studentScores.getScores();
        int max = 0;
        int sum = 0;
        double avg = 0;

        for(int i=0; i <scores.length; i++) {
            max = (max<scores[i])? scores[i] : max;
            sum += scores[i];
        }
        avg = (double) sum / studentScores.getStudentNum();

        System.out.println("최고 점수: " + max);
        System.out.println("평균 점수: " + avg);
    }
}
