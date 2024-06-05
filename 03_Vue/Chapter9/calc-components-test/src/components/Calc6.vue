<template>
    <div>
        X: <input type="text" v-model.number="state.x" />
        <br />
        <div>결과 : {{ state.result }}</div>
    </div>
    <!-- computed 함수로 인해 바뀌는 값에 따라 바로  result로 변경 -->
</template>

<script>
// composition api 내의 함수를 사용하려면 import 필수
import { reactive, watch } from 'vue';

export default {
    name: 'Calc6',
    // computed 로 계산해주기때문에 result초기화 필요 없어짐
    setup() {
        const state = reactive({ x: 0, result: 0 });
        // 첫번째 인자로는 반응성 데이터가 와야하기 때문에 state.x는
        watch(
            () => state.x,
            (current, old) => {
                console.log(`${old} -> ${current}`);
                state.result = current * 2;
            }
        );
        // return을 해줘야 template쪽에서 사용 가능
        return { state };
    },
};
</script>
