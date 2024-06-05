<template>
    <div>
        X: <input type="text" v-model.number="x" />
        <br />
        <div>결과 : {{ result }}</div>
    </div>
    <!-- computed 함수로 인해 바뀌는 값에 따라 바로  result로 변경 -->
</template>

<script>
// composition api 내의 함수를 사용하려면 import 필수
import { ref, watch } from 'vue';

export default {
    name: 'Calc5',
    // computed 로 계산해주기때문에 result초기화 필요 없어짐
    setup() {
        // reactive로 참조형 데이터를 감싸줘야 반응형으로 동작한다
        const x = ref(0);
        const result = ref(0);
        // 첫번째 인자 :감시하고 싶은 데이터 (반응성 데이터)
        // 두번째 인자(current 부터 2괄호 까지): 현재값과 전의 값을 받아서 실행 할 함수
        watch(x, (current, old) => {
            console.log(`${old}-> ${current}`);
            result.value = current * 2;
        });
        // return을 해줘야 template쪽에서 사용 가능
        return { x, result };
    },
};
</script>
