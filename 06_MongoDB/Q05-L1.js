use test;

//다음 형태의 문서 20,000건을 추가하세요.
for(let i=0;i<20000;i++){
    db.product.insert({
          num: i,
          name : '스마트폰'+i
});
}

//db.product.count()

//product 컬렉션의 전체 문서수를 출력하세요
db.product.count()

//product 컬렉션의 문서를 num의 내림 차순으로 정렬하여 출력하세요.
//sort로 문서를 정렬 가능
//sort ({키값:오름차순(1)/내림차순(-1)})
db.product.find().sort({ "num": -1 })

//product 컬렉션의 문서를 num의 내림 차순으로 정렬하여 상위 10건을 출력하세요.
//limit(출력 할 데이터 갯수)
//데이터를 원하는 개수만큼만 출력해준다
db.product.find().sort({ "num": -1 }).limit(10)

//product 컬렉션의 문서를 num의 내림 차순으로 정렬한 상태에서 다음을 처리하세요.(한페이지 당 10건씩 출력 ,6페이지에 해당하는 문서 출력)
//메소드 체이닝의 순서는 중요하지 않다
//skip() : 건너 뛸 데이터의 개수 , 페이징에 주로 사용 
//skip 할 페이지 공식 : (페이지 쪽수 -1) * 한페이지에 보여줄 데이터 개수
db.product.find()
.sort({ "num": -1 })
.limit(10)
.skip((6 -1) * 10)

//product 컬렉션에서 num이 15미만 이거나 19995 초과인 것을 출력하세요.
//$or : 배열 중 하나라도 true라면 일치
//$lt-> 미만 /  $gt ->초과
db.product.find({
    $or: [
        { "num": { $lt: 15 } },  // num이 15 미만인 경우
        { "num": { $gt: 19995 } }  // num이 19995 초과인 경우
    ]
}).sort({ "num": -1 })

//product 컬렉션에서 name이 '스마트폰 10', '스마트폰 100', '스마트폰 1000' 중에 하나이면 출력하세요.
//$in :어떤 인수든 하나라도 해당 배열에 있으면 검색됨
db.product.find({
    "name": { $in: ['스마트폰10', '스마트폰100', '스마트폰1000'] }
})

//product 컬렉션에서 num이 5보다 작은 문서를 출력하는데, name만 출력하세요.(_id 출력하면 안됨)
//해당 컬럼에 0을 주면 해당 데이터 숨기기 , 1을 주면 해당 데이터 출력 (원래는 아무덧도 주지 않으면 아무것도 보이지 않는게 당연하지만 id 는1이 기본값이다 즉 나머지는 기본값이 0이다)
//find({조건문서},{프로젝션 문서})
db.product.find({ "num": { $lt: 5 } }, { "_id": 0, "name": 1 })

