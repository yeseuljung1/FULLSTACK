<template>
    <div>
        <h2>지출</h2>
        <form @submit.prevent="addExpense">
            <div>
                <label for="category">카테고리:</label>
                <select v-model="expense.category" required>
                    <option value="salary">월급</option>
                    <option value="allowance">용돈</option>
                </select>
            </div>
            <div>
                <label for="amount">금액:</label>
                <input type="number" v-model="expense.amount" required />
            </div>
            <div>
                <label for="description">내용:</label>
                <input type="text" v-model="expense.description" />
            </div>
            <button type="submit">추가</button>
        </form>
        <div>
            <h3>지출 내역</h3>
            <ul>
                <li v-for="(expense, index) in expenses" :key="index">{{ expense.category }}: {{ expense.amount }} - {{ expense.description }} ({{ new Date(expense.date).toLocaleString() }})</li>
            </ul>
        </div>
    </div>
</template>

<script>
import axios from 'axios';

export default {
    data() {
        return {
            expense: {
                category: 'salary',
                amount: '',
                description: '',
            },
            expenses: [],
        };
    },
    methods: {
        async addExpense() {
            try {
                const response = await axios.post('http://localhost:3000/api/expense', this.expense);
                if (response.data.success) {
                    this.expenses.push({ ...this.expense, date: new Date() });
                    this.expense = { category: 'salary', amount: '', description: '' };
                }
            } catch (error) {
                console.error('Error adding expense:', error);
            }
        },
    },
    async mounted() {
        try {
            const response = await axios.get('http://localhost:3000/api/expenses');
            this.expenses = response.data;
        } catch (error) {
            console.error('Error fetching expenses:', error);
        }
    },
};
</script>

<style scoped>
form div {
    margin-bottom: 10px;
}
</style>
