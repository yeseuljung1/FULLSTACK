<template>
    <div>
        <!-- 자식 컴포넌트에서 정의한 namechanged 이벤트를 namechangedhandler 함수와 연결
        (사용자 정의 이벤트) -->
        <inputname @nameChanged="nameChangedHandler" />
        <br />
        <h3>App데이터 :{{ parentName }}</h3>
    </div>
</template>

<script>
// 지역 컴포넌트 등록 방법 (사용 할 파일에서만 명시)
import inputname from './components/inputname.vue';
export default {
    name: 'App',
    components: { inputname },
    data() {
        return {
            parentName: '',
        };
    },
    methods: {
        nameChangedHandler(e) {
            //   객체 안에 있는 name울 접근해서 data에 있는 parentName에 넣어줌
            this.parentName = e.name;
        },
    },
};
</script>
