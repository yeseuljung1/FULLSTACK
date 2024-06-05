const c = require('ansi-colors');
function hello(name) {
    console.log(`${c.green(name)}님, 안녕하세요?`);
}
hello('홍길동');

// npm init-y 치면 한번에 초기화됨
