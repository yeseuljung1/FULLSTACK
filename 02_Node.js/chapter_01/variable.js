let x = 100;
let y = 200;
// 전역변수:스코프(중괄호) 바깥 범위의 변수
// 전체영역에 적용
function swap(/* x, y */) {
    // 우선순위 :지역변수> 전역변수
    //함수 내에서는 지역변수로 쓰이고 함수가 끝나는 즉시 반환된다.
    /*  let temp = x;
    x = y;
    y = temp; */
    console.log(`swap함수 안 ->x:${x},y=${y}`); /* ->지금 여기의 x,y는 밖에x,y 사용한다 만약 안에 있으면 안에꺼 먼저 사용 */
}
console.log(`swap 호출 전 ->x:${x},y=${y}`);
swap(x, y);
console.log(`swap 호출 후 ->x:${x},y=${y}`);
