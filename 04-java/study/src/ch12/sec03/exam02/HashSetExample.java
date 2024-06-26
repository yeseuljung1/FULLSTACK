package ch12.sec03.exam02;

import java.util.HashSet;

public class HashSetExample {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
        Student s1 = new Student(1, "홍길동");
//        hashcode를 호출해서 같은 값이 리턴되면 같은 객체라고 판단한다
        hashSet.add(s1);
        System.out.println("저장된 객체 수: " + hashSet.size());
        Student s2 = new Student(1, "홍길동");
//        s1과s2의 no 와 name이 모두 같으므로 hashcode내에서도 같은 값을 반환한다
//        따라서 같은 객체로 인식하기 때문에 add를 해도 set내에 추가 되지 않는다
//        hashcode를 오버라이딩한 코드를 주석처리하면
        hashSet.add(s2);
        System.out.println("저장된 객체 수: " + hashSet.size());
        Student s3 = new Student(2, "홍길동");
        hashSet.add(s3);
        System.out.println("저장된 객체 수: " + hashSet.size());
    }
}
