<template>
    <div>
        <h2>관심있는 K-POP 가수?</h2>
        <hr />
        <ul>
            <Checkboxitem v-for="idol in idols" :key="idol.id" :idol="idol" />
            <!-- 자식의 props 에 적은 name과 checked를 똑같이 적어두면 됨 
            :idol은  자식한테 props로 전달해주는 속성(사용자 정의)
           그냥 idol 은 idols 배열르 돌면서 객체 하나식 접근-->
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
            idols: [
                { id: 1, name: 'BTS', checked: true },
                { id: 2, name: 'Black pink', checked: false },
                { id: 3, name: 'Exo', checked: false },
                { id: 4, name: 'Itzy', checked: false },
            ],
        };
    },
};
</script>
