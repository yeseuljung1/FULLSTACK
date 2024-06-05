function displayA() {
    console.log('A');
}

// 콜백함수를 이용하면 원하는대로 순서를 보장 할 수 있다
// 하지만 콜백함수를 계속 쓰면 콜백 지옥도착=>그래서 등장한것이 promise랑 acync/awiat이다
function displayB(callback) {
    setTimeout(() => {
        console.log('B');
        callback();
    }, 2000);
}

function displayC() {
    console.log('C');
}

displayA();
displayB(displayC);
