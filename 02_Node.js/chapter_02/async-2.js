let likepizza = true;
const pizza = new Promise((resolve, reject) => {
    // if(likepizza ===true와 동일한 코드)
    if (likepizza) resolve('피자를 주문합니다');
    // resolve :작업이 성공했을 떄 실행되는 함수
    else reject('피자를 주문하지 않습니다');
    // reject :작업이 실패했을 떄 실행되는 함수
});

pizza
    // then: 작업이 성공했을때 실행되는 코드 (resolve값을 받아옴)
    .then((result) => console.log(result))
    // catch는 에러를 위한 코드이기때문에 이 문자이 없어도 결과는 같다
    // catch: 작업이 실패했을때 실행되는 코드 (reject값을 받아옴)
    .catch((err) => console.log(err))
    // finally: 성공하든 실패하든 실행되는 코드
    .finally(() => console.log('finally'));
