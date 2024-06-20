package ch07.sec10.exam01;

public class AbstractMethodExample {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.sound();

        Cat cat = new Cat();
        cat.sound();
//        여기까지 멍멍 야옹 한번
        
//파라미터로 객체를 주입받아서 다향성을 부여함
//        매개변수의 다향성
        animalSound(new Dog());
        animalSound(new Cat());
    }
//    여기서 멍멍 야옹 두번째

    public static void animalSound(Animal animal) {
        animal.sound();
    }
}
