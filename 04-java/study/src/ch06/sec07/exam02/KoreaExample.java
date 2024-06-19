package ch06.sec07.exam02;

public class KoreaExample {
    public static void main(String[] args) {
//        Korea객체 생성
        Korea k1 = new Korea("박자바","011225-1234567");
//        Korea 객체 데이터 읽기
        System.out.println("k1.nation : " + k1.nation);
        System.out.println("k1.name : " + k1.name);
        System.out.println("k1.ssn : " + k1.ssn);
        System.out.println();

//        또다른 Korea 객체 생성
        Korea k2 = new Korea("김자바","64561321-65156132");
//        또 다른 Korea 객체 데이터 읽기
        System.out.println("k2.nation : " + k2.nation);
        System.out.println("k2.name : " + k2.name);
        System.out.println("k2.ssn : " + k2.ssn);
    }
}
