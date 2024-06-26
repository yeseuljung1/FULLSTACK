package ch12.sec03.exam05;

import lombok.Data;


@Data

    public class Member2 {
        private String id;
//        @NonNull : null이면 안되는 필수 항목 , 따라서 @RequiredArgsConstructor에 의해 해당 필드를 포함시키는 생성자가 만들어진다
        private String name;
        private int age;
}


//ctrl + alt+ o -> 안쓰는 import 제거