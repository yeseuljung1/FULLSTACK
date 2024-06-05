<template>
    <div>
        X: <input type="text" v-model.number="state.x" />
        <br />
        Y: <input type="text" v-model.number="state.y" />
        <br />
        <button @click="calcAdd">계산</button><br />
        <div>결과 : {{ state.result }}</div>
    </div>
</template>

<script>
// composition api 내의 함수를 사용하려면 import 필수
import { reactive } from 'vue';

export default {
    name: 'Calc3',
    setup() {
        // reactive로 참조형 데이터를 감싸줘야 반응형으로 동작한다
        const state = reactive({ x: 10, y: 20, result: 30 });
        // 참조형은 데이터를 vlaue 로 접근 할 필요가 없다
        const calcAdd = () => {
            state.result = state.x + state.y;
        };
        // return을 해줘야 template쪽에서 사용 가능
        return { state, calcAdd };
    },
};
</script>
