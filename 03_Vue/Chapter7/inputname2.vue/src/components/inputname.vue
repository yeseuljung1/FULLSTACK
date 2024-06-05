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
    // emits: [namechanged1]
    emits: {
        nameChanged: (e) => {
            // name이 비어있지 않고 type이 string이며 앞뒤 공백을 제거 하고 길이가 3이상일 경울 true리턴
            return e.name && type(e.name) === 'string' && e.name.trim().length >= 3 ? true : false;
        },
    },
    data() {
        return { name: '' };
    },
};
</script>
