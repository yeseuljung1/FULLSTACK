<template>
    <!-- idol 안에 있는 속성들을 따로 받아왔기 때문에 해당 속성 이름으로 변경 -->
    <!-- checked는 실제 체크박스 안에 있는 html속성(체크여부) -->
    <li><input type="Checkbox" :checked="checked" /> {{ id }} - {{ name }}</li>
</template>

<script>
export default {
    name: 'Checkboxitem',
    // props :부모 컴퍼넌트(app.vue)한테 받아온 속성
    // 받아올 속성이 많은 경우 객체를 통째로 넘겨준다
    // props를 객체로 박아오는 경우 세부 옵션까지 설정 가능
    props: {
        id: [Number, String] /*  number 나 string 타입이다 */,
        name: String,
        checked: {
            type: Boolean,
            require: false /* 필수 속성이 아닌 옵션이다 */,
            default: false /* 생략하면 기본값이  false 가 된다  */,
        },
    },
};
</script>
