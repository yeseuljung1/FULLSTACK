package org.example.exception;

//사용자 정의 예외 클래스,예외로 만들어주려면Exception 상속필요 
public class BadMenuException extends Exception{
    public BadMenuException() {
        super("잘못된 메뉴 선택입니다.");
    }
    public BadMenuException(String message) {
        super(message);
    }
}
