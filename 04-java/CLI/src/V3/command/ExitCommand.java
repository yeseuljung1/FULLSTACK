package V3.command;

//5번 메누인 종료 기능 처리하는 클래스
public class ExitCommand implements Command{
    @Override
    public void execute() {
        System.out.println("프로그램 종료");
        System.exit(0);
    }
}
