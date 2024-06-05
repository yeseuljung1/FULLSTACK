<template>
    <div>
        <h3>당신이 경험한 프로트엔드 기술은?(처번째: slot 사용(x))</h3>
        <!-- items 배열을 순회하면서 자식의 props에 해단 값들을 넘겨준다
        자식에서 보낸 check-changed 이벤트에 CheckBoxChanged 함수 연결 -->
        <CheckBox1 v-for="item in items" :key="item.id" :id="item.id" :label="item.label" :checked="item.checked" @check-changed="CheckBoxChanged"></CheckBox1>
    </div>
</template>

<script>
import CheckBox1 from './CheckBox1.vue';

export default {
    name: 'NoSlotTest',
    components: { CheckBox1 },
    data() {
        return {
            items: [
                { id: 'V', checked: true, label: 'Vue' },
                { id: 'A', checked: false, label: 'Angular' },
                { id: 'R', checked: false, label: 'React' },
                { id: 'S', checked: false, label: 'Svekte' },
            ],
        };
    },
    methods: {
        CheckboxChanged(e) {
            // 변경된 체크박스의 id로 현재 items배열에서 해당 요소를 찾는다.
            let item = this.items.find((item) => item.id === e.id);
            item.checked = e.checked; /* 해당 아이템ㅇ의 checked 값을 받아온  */
        },
    },
};
</script>
