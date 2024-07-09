--  * : 모두 선택 , FROM 뒤에는 테이블 명, SELECT 뒤에는 컬럼(열)
SELECT * FROM producttbl;
-- 데이터를 두개 이상 검색 할 때는 ,로 이어준다
SELECT memberName, memberAddress FROM membertbl;
-- WHERE 절 뒤에는 조건식, = 이 같다라는 뜻으로 쓰임
SELECT * FROM membertbl WHERE memberName = '지운이';