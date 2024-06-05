// 키워드로 전체 파일을 가져와서 사용가능
// 하지만 안쪽이 변수나 함수를 접근 할 때는 .을 써서 접근해야한다
import * as say from './greeting-1 .mjs'; // greeting.mjs 에서 내보낸 함수들을 한꺼번에 say 로 받기

say.hi('홍길동');
say.goodbye('홍길동');
