function foodReporrt(name, age, ...favoriteFoods) {
    // 파라미터 순서 :일반 파라미터>디폴트 파라미터>가변 파라미터
    console.log(name + ',' + age);
    console.log(favoriteFoods);
}
// 가변 파라미터는 개수에 상관없이 들어가지면 무조건 배열 형태이다
foodReporrt('이몽룡', 20, '짜장면', '냉명', '불고기');
foodReporrt('홍길동', 16, '초밥');
