let human = {
    name: '김상형',
    age: 29,
    // 갹채 내의 함수를 메소드 라고 한다
    intro: function () {
        human.intro();
        console.log(`name =${this.name}`);
        console.log(`age =${this.age}`);
    },
};

// 메소드를 호출 할 때에도 객체 먼저 접근한다
human.intro();
