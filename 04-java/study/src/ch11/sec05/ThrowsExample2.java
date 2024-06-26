package ch11.sec05;

public class ThrowsExample2 {
//    findClass에서 받아온 ClassNotFoundException을 상위 exception으로 다시 던진다
    public static void main(String[] args) throws Exception {
        findclass();
    }

    public static void findclass() throws Exception {
        Class.forName("java.lang.String2");
    }
}
