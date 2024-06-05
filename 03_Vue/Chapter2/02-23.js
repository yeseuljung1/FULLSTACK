let obj1 = { name: '박문수', age: 29 };
let obj2 = obj1; //shallow copy! obj1, obj2 는 동일한 객체를 참조( obj1 객체의 주소 복사)
let obj3 = { ...obj1 }; // 객체 내부의 값은 복사하지만 obj3, obj1 은 다른 객체(obj1객체의 값만 복사)
let obj4 = { ...obj1, email: 'mspark@gmail.com ' }; /* 새로운 속성 추가 */

obj2.age = 19;
// obj1과ob2는 같은 주소를 가리키고 있기 때문에 값이 같이 변경된다
console.log(obj1); //{ name:"박문수 ", age:19
console.log(obj2); //{ name:"박문수 ", age:19 } obj1 과 동일
// obj3은 값만 복사했기 때문에 같이 변경되지 않는다
console.log(obj3); //{ name:"박문수 ", age:29 } age 가 바뀌지 않음
console.log(obj1 == obj2); //같은 주소라서 true
console.log(obj1 == obj3); //다른 주소라서 false

let arr1 = [100, 200, 300];
// 전개 연산자를 통해 원하는 값들을 중간에 삽입 가능
let arr2 = ['hello', ...arr1, 'world'];
console.log(arr1); // [ 100, 200, 300 ]
console.log(arr2); // [ "hello", 100, 200, 300, "world" ]
