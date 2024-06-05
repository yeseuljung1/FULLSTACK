<template>
    <div>
        <h2>최신인기곡</h2>
        <SongList :songs="songs" />
    </div>
</template>

<script>
import { computed } from 'vue';
import SongList from './components/SongList.vue';

export default {
    name: 'App',
    components: { SongList },
    data() {
        return {
            // 노래 목록이 들어 있는 객체배열
            songs: [
                { id: 1, title: 'Bluming', done: true },
                { id: 2, title: 'Dynamic', done: true },
                { id: 3, title: 'Lovesick Girls', done: false },
                { id: 4, title: '마리라(Maria)', done: false },
            ],
        };
    },
    provide() {
        // provide로 하위 컴포넌트에 속성이나 함수를 전달 할 수 있음
        return {
            icons: {
                checked: 'far fa-check-circle',
                unchecked: 'far fa-circle',
            },
            doneCount: computed(() => {
                return this.songs.filter((s) => s.done === true).length;
            }),
        };
    },
};
</script>

<style>
@import url('https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.14.0/css/all.min.css');
</style>
