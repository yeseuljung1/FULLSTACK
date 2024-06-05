const p = new Promise((resolve, reject) => {
    setTimeout(() => {
        let num = Math.random();
        if (num >= 0.8) {
            reject('생성된 숫자가 0.8 이상임-' + num);
        }
        resolve(num);
    }, 2000);
});

p.then((result) => {
    // resolve엣 받아온 값은 result에 할당
    console.log('처리 결과 : ', result);
}).catch((error) => {
    // reject에서 받아온 값을 error에 할당
    console.log('오류 : ', error);
});
console.log('## Promise 객체 생성!');
