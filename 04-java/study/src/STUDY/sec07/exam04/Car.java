package STUDY.sec07.exam04;

public class Car {
//    필드
    String company = "현대자동차";
    String model;
    String color;
    int maxspeed;

//    생성자
//    아무것도 초기화 하지 않는 기본 생성자
//    필드들은 이미 선언 시 기본값으로 초기화 됨
    Car(){}

//    모델명을 매개변수로 가지는 생성자
    Car(String model) {
        this.model = model; /*매개변수로 전달된 모델명으로 필드 초기화*/
    }

//    모델명과 색상을 매개변수로 가지는 생성자 
    Car(String model, String color) {
        this.model = model;
        this.color = color;
    }

//    모델명 생상 최고 속도흘 매개변수로 가지는 생성자
    Car(String model, String color, int maxspeed) {
        this.model = model;
        this.color = color;
        this.maxspeed = maxspeed;
    }
}
