package ch17.sec07.exam01;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortingExample {
    public static void main(String[] args) {
//        List 컬렉션 생성
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("홍길동",30));
        studentList.add(new Student("신용권",10));
        studentList.add(new Student("유미션",20));

//        점수를 기준으로 오름차순으로 정렬한 새 스트림 얻기
        studentList.stream()
                .sorted() /*sorted : compareTo에 적힌 기준으로 요소들을 비교해서 정렬*/
//          점수순으로 정렬돼서 출력됨
                .forEach(s->System.out.println(s.getName()+":"+s.getScore()));
        System.out.println();


        //점수를 기준으로 내림차순으로 정렬한 새 스트림 얻기
        studentList.stream()
                .sorted(Comparator.reverseOrder())
                .forEach(s -> System.out.println(s.getName() + ": " + s.getScore()));
    }
}