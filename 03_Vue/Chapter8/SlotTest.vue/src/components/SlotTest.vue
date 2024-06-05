<template>
    <div>
        <h3>당신이 경험한 프로트엔드 기술은?(두번째: slot 기본)</h3>
        <CheckBox2 v-for="item in items" :key="item.id" :id="item.id" :label="item.label" :checked="item.checked" @check-changed="CheckBoxChanged">
            <!-- slot으로 보내줄 요소는 무조선 자식 컴포넌트 태그 사이에 위치한다 -->
            <!-- 기존 코드는 props에서 checked와 label을 가져왔으므로 부모에서느 item내로 접근해줘야한다 -->
            <span v-if="item.checked" style="color: blue; text-decoration: underline">
                <i>{{ item.label }}</i>
            </span>
        </CheckBox2>
    </div>
</template>

<script>
import CheckBox2 from './CheckBox2.vue';

export default {
    name: 'SlotTest',
    components: { CheckBox2 },
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
            let item = this.items.find((item) => item.id === e.id);
            item.checked = e.checked; /* 해당 아이템의 checked 값을 받아온  */
        },
    },
};
</script>
