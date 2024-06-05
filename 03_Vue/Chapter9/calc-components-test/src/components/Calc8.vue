<template>
    <div>
        X: <input type="text" v-model.number="x" />
        <br />
        Y: <input type="text" v-model.number="y" />
        <br />
        <div>결과 : {{ result }}</div>
    </div>
    <!-- computed 함수로 인해 바뀌는 값에 따라 바로  result로 변경 -->
</template>

<script>
// composition api 내의 함수를 사용하려면 import 필수
import { ref, watchEffect } from 'vue';

export default {
    name: 'Calc8',
    // computed 로 계산해주기때문에 result초기화 필요 없어짐
    setup() {
        const x = ref(10);
        const y = ref(20);
        const result = ref(30);

        watchEffect(() => {
            result.value = x.value + y.value;
            console.log(`${x.value} + ${y.value} = ${result.value}`);
        });
        // return을 해줘야 template쪽에서 사용 가능
        return { x, y, result };
    },
};
</script>
