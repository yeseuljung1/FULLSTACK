package STUDY.sec07.eaxm05;

public class Car {
    String company = "현대 자동차";
    String model; 
    String color;
    int maxspeed;

    Car(String company) {
        this.company = company;
    }

    Car(String model , String color) {
        this.model = model;
        this.color = color;
    }

    Car(String model , String color, int maxspeed) {
        this.model = model;
        this.color = color;
        this.maxspeed = maxspeed;
    }
}
