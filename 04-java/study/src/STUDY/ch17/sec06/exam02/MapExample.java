package STUDY.ch17.sec06.exam02;

import java.util.Arrays;
import java.util.stream.IntStream;
public class MapExample {
    public static void main(String[] args) {
        int[] intArray = { 1, 2, 3, 4, 5};
//        다음과 같이 출력되도록 스트림으로 처리하세요
        IntStream intStream = Arrays.stream(intArray);
        intStream
                .asDoubleStream()
                .forEach(d->System.out.println(d));

        System.out.println();

        intStream = Arrays.stream(intArray);
        intStream
                .boxed()
                .forEach(obj->System.out.println(obj));

    }
}
