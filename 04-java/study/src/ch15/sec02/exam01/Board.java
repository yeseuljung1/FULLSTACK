package ch15.sec02.exam01;

import lombok.AllArgsConstructor;
import lombok.Data;

//필드 전부를 가지고 있는 생성자를 만들겠다
@AllArgsConstructor
//기본 생성자를 만들겠다
//@NoArgsConstructor
/*@Getter
@Setter*/
@Data /*Data 는 getter setter ,toString, 기본 생성자, hashCode, equlals 다 들어있다*/


public class Board {
    private String subject;
    private String content;
    private String writer;

}

