<template>
    <div style="border: solid 1px gray; padding: 5px">
        <!-- name 속성을 input 과 양방향 바인딩 시킴 -->
        이름: <input type="text" v-model="name" />
        <!-- 버튼 클릭시 nmeChanged 라는 이벤트에 name 값을 객체로 담아서 부모에게 전송 -->
        <button @click="$emit('nameChanged', { name })">이벤트 발신</button>
    </div>
</template>

<script>
export default {
    name: 'inputname',
    // props :부모 컴퍼넌트(app.vue)한테 받아온 속성
    // 받아올 속성이 많은 경우 객체를 통째로 넘겨준다
    // props를 객체로 박아오는 경우 세부 옵션까지 설정 가능
    data() {
        return { name: '' };
    },
};
</script>
