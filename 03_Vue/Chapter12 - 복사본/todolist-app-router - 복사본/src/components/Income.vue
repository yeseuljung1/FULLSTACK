<template>
    <div>
        <h2>수입</h2>
        <form @submit.prevent="addIncome">
            <div>
                <label for="category">카테고리:</label>
                <select v-model="income.category" required>
                    <option value="salary">월급</option>
                    <option value="allowance">용돈</option>
                </select>
            </div>
            <div>
                <label for="amount">금액:</label>
                <input type="number" v-model="income.amount" required />
            </div>
            <div>
                <label for="description">내용:</label>
                <input type="text" v-model="income.description" />
            </div>
            <button type="submit">추가</button>
        </form>
        <div>
            <h3>수입 내역</h3>
            <ul>
                <li v-for="(income, index) in incomes" :key="index">{{ income.category }}: {{ income.amount }} - {{ income.description }} ({{ new Date(income.date).toLocaleString() }})</li>
            </ul>
        </div>
    </div>
</template>

<script>
import axios from 'axios';

export default {
    data() {
        return {
            income: {
                category: 'salary',
                amount: '',
                description: '',
            },
            incomes: [],
        };
    },
    methods: {
        async addIncome() {
            try {
                const response = await axios.post('http://localhost:3000/api/income', this.income);
                if (response.data.success) {
                    this.incomes.push({ ...this.income, date: new Date() });
                    this.income = { category: 'salary', amount: '', description: '' };
                }
            } catch (error) {
                console.error('Error adding income:', error);
            }
        },
    },
    async mounted() {
        try {
            const response = await axios.get('http://localhost:3000/api/incomes');
            this.incomes = response.data;
        } catch (error) {
            console.error('Error fetching incomes:', error);
        }
    },
};
</script>

<style scoped>
form div {
    margin-bottom: 10px;
}
</style>
