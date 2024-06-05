// let getTriangle = (base, height) => {
//     return (base * height) / 2;
// };
/* let getTriangle = (base, height) => {
    return (base * height) / 2;
}; */
let getTriangle = (base, height) => (base * height) / 2;

//  객체 reutrn시에는 소괄호로 한번 더 감싸준다
// (구현부와 차이점을 두기 위해)
let getObject = () => ({
    이름: 'yura',
});

console.log(`삼각형의 면적:${getTriangle(5, 2)}`);
