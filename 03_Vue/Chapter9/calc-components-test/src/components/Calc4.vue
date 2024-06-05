<template>
    <div>
        X: <input type="text" v-model.number="state.x" />
        <br />
        Y: <input type="text" v-model.number="state.y" />
        <br />
        <div>결과 : {{ result }}</div>
    </div>
    <!-- computed 함수로 인해 바뀌는 값에 따라 바로  result로 변경 -->
</template>

<script>
// composition api 내의 함수를 사용하려면 import 필수
import { reactive, computed } from 'vue';

export default {
    name: 'Calc4',
    // computed 로 계산해주기때문에 result초기화 필요 없어짐
    setup() {
        // reactive로 참조형 데이터를 감싸줘야 반응형으로 동작한다
        const state = reactive({ x: 10, y: 20 });
        // 기존 옵션 api의 computed옵션과 동일한 역할
        // 참조형은 데이터를 vlaue 로 접근 할 필요가 없다
        const result = computed(() => {
            return state.x + state.y;
        });
        // return을 해줘야 template쪽에서 사용 가능
        return { state, result };
    },
};
</script>
