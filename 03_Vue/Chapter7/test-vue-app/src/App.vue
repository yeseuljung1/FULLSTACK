<template>
    <div>
        <h2>App 컴포넌트</h2>
        <hr />
        <ul>
            <Checkboxitem />
            <Checkboxitem />
            <Checkboxitem />
            <Checkboxitem />
        </ul>
    </div>
</template>

<script>
// 지역 컴포넌트 등록 방법 (사용 할 파일에서만 명시)
import Checkboxitem from './components/Checkboxitem.vue';
export default {
    name: 'App',
    components: { Checkboxitem },
};
</script>
