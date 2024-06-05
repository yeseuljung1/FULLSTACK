<template>
    <div>
        <h2>관심있는 K-POP 가수?</h2>
        <hr />
        <ul>
            <Checkboxitem v-for="idol in idols" :key="idol.id" :id:="idol.id" :name="idol.name" :checked="idol.checked" />
            <!-- 자식에 등록된 props와 동일한 이름으로 넘겨줘야한다 -->
        </ul>
    </div>
</template>

<script>
// 지역 컴포넌트 등록 방법 (사용 할 파일에서만 명시)
import Checkboxitem from './components/Checkboxitem2.vue';
export default {
    name: 'App',
    components: { Checkboxitem },
    data() {
        return {
            // idols를 객체 배열로 만들어줌
            // props 부분에서 checked의 기본값을 false로 정해줬기 때문에 생략가능
            idols: [
                { id: 1, name: 'BTS', checked: true },
                { id: 2, name: 'Black pink' },
                { id: 3, name: 'Exo' },
                { id: 4, name: 'Itzy' },
            ],
        };
    },
};
</script>
