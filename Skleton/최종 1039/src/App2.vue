<template>
    <div>
        <h1>Expenditures</h1>
        <ul>
            <li v-for="expenditure in sortedExpenditures" :key="expenditure.id">
                <b>{{ expenditure.date }} - {{ expenditure.description }} - ${{ expenditure.amount }}</b>
            </li>
        </ul>
    </div>
</template>

<script>
import axios from 'axios';

export default {
    data() {
        return {
            expenditures: [],
        };
    },
    async mounted() {
        await this.fetchExpenditures();
    },
    computed: {
        sortedExpenditures() {
            // 날짜순으로 정렬된 지출 내역 반환
            return this.expenditures.sort((a, b) => new Date(b.date) - new Date(a.date));
        },
    },
    methods: {
        async fetchExpenditures() {
            try {
                const response = await axios.get('http://localhost:3000/expenditures');
                this.expenditures = response.data;
            } catch (error) {
                console.error('Error fetching expenditures:', error);
            }
        },
    },
};
</script>

<style scoped>
/* CSS 스타일링을 위한 부분 */
</style>
