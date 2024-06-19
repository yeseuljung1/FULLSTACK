package ch04.sec03;

public class SwitchExample {
    public static void main(String[] args) {
//        1부터 6까지 랜덤
        int num = (int) (Math.random ()*6) +1;
//        하나의 값으로 비교 할 때 switch
        switch(num) {
            case 1:
                System.out.println ("1 번이 나왔습니다");
                break;
            case 2:
                System.out.println("2 번이 나왔습니다");
                break;
            case 3:
                System.out.println("3 번이 나왔습니다");
                break;
            case 4:
                System.out.println("4 번이 나왔습니다");
                break;
            case 5:
                System.out.println("5 번이 나왔습니다");
                break;
            default:
                System.out.println("6 번이 나왔습니다");
        }
    }
}
