<template>
    <li><input type="Checkbox" :checked="checked" /> {{ name }}</li>
</template>

<script>
export default {
    name: 'Checkboxitem',
    // props :부모 컴퍼넌트(app.vue)한테 받아온 속성
    props: ['name', 'checked'] /* 속성명을 배열로 정의 */,
};
</script>
