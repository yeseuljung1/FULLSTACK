let human = {
    name: '김상형',
    age: 29,
};
// human객체에 salary속성 추가
human.salary = 520;
// human객체에 age속성 삭제
delete human.age;

console.log(`${human.name}의 월급: ${human.salary}`);
console.log(`${human.name}의 나이: ${human.age}`);
