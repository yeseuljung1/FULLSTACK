<template>
    <div>
        X: <input type="text" v-model.number="x" />
        <br />
        Y: <input type="text" v-model.number="y" />
        <br />
        <button @click="calcAdd">계산</button><br />
        <div>결과 : {{ result }}</div>
    </div>
</template>

<script>
// composition api 내의 함수를 사용하려면 import 필수
import { ref } from 'vue';

export default {
    name: 'Calc2',
    setup() {
        // ref로 값형 데이터를 감싸줘야 반응형으로 동작한다
        // 기존 옵션 api 의 data와 같은 역할
        const x = ref(10);
        const y = ref(20);
        const result = ref(30);
        // ref데이토 내의 값에 접근 할 때는 무조건 .value를 붙여야한다
        const calcAdd = () => {
            result.value = x.value + y.value;
        };
        // return을 해줘야 template쪽에서 사용 가능
        return { x, y, result, calcAdd };
    },
};
</script>
