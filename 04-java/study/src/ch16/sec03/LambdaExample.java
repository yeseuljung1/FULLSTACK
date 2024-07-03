package ch16.sec03;

public class LambdaExample {
    public static void main(String[] args) {
        Person person = new Person();

//매개변수가 두 개일 경우 ->괄호 생략 불가능
// action1을 부르고 있으므로 람다식은  workable내의 work에 들어간다
        person.action1((name, job) -> {
            System.out.print(name + "이 ");
            System.out.println(job + "을 합니다.");
        });

// 실행 문장이 하나일 경우 중괄호 생략 가능
        person.action1((name, job) -> System.out.println(name + "이 " + job + "을 하지 않습니다."));

        //매개변수가 한 개일 경우
        person.action2(word -> {
            System.out.print("\"" + word + "\"");  /*}"\" 는 escape이기 떄문에 "를 출력하기 위함이다 */
            System.out.println("라고 말합니다.");
        });
        person.action2(word -> System.out.println("\"" + word + "\"라고 외칩니다."));
    }
} 
