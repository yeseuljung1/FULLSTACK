<template>
    <nav class="navbar navbar-expand-md bg-dark navbar-dark mt-2">
        <span class="navbar-brand">이날치(LeeNalChi)</span>
        <!-- 버튼 클릭시 changeisnavshow 함수 호출 -->
        <button class="navbar-toggler" type="button" @click="changeIsNavShow">
            <span class="navbar-toggler-icon"></span>
        </button>
        <!-- navclass 데이터 내에 있는 클래스 이름 바인딩 -->
        <div :class="navClass">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <router-link class="nav-link" to="/">홈</router-link>
                </li>
                <li class="nav-item">
                    <router-link class="nav-link" to="/about">소개</router-link>
                </li>
                <li class="nav-item">
                    <router-link class="nav-link" to="/members">멤버</router-link>
                </li>
                <li class="nav-item">
                    <router-link class="nav-link" to="/videos">영상</router-link>
                </li>
            </ul>
        </div>
    </nav>
</template>

<script>
import { reactive, computed } from 'vue';

export default {
    setup() {
        const state = reactive({ isNavShow: false });
        // 내부 클래스에 state의 isnavshow가 true면 앞의 클래스명을 넣고 , false면 뒤의 클래스명을 넣는다
        const navClass = computed(() => (state.isNavShow ? 'collapse navbar-collapse show' : 'collapse navbar-collapse'));

        // 버튼 클릭시 state의 isnavshow를 반대로 바꿔줌 (true-> false,false->true)
        const changeIsNavShow = () => {
            state.isNavShow = !state.isNavShow;
        };

        return { state, changeIsNavShow, navClass };
    },
};
</script>
