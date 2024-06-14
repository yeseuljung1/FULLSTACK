<template>
  <div id="app">
    <ExpenseForm
      :transactions="transactions"
      @add-transaction="addTransaction"
      @delete-transaction="deleteTransaction"
      @update-transaction="updateTransaction"
      @load-transactions="setTransactions"
    />
  </div>
</template>

<script>
import ExpenseForm from '../components/ExpenseForm.vue';

export default {
  name: 'InOut',
  components: {
    ExpenseForm,
  },
  data() {
    return {
      transactions: {
        users: [],
        expenditures: [],
      },
    };
  },

  methods: {
    addTransaction(transaction) {
      const category = transaction.type === 'income' ? 'users' : 'expenditures';
      this.transactions[category].unshift(transaction);
      // 데이터를 추가한 후 다시 정렬
      this.transactions[category].sort(
        (a, b) => new Date(b.date) - new Date(a.date)
      );
    },
    deleteTransaction(id) {
      this.transactions.users = this.transactions.users.filter(
        (transaction) => transaction.id !== id
      );
      this.transactions.expenditures = this.transactions.expenditures.filter(
        (transaction) => transaction.id !== id
      );
    },
    updateTransaction(updatedTransaction) {
      const category =
        updatedTransaction.type === 'income' ? 'users' : 'expenditures';
      const index = this.transactions[category].findIndex(
        (transaction) => transaction.id === updatedTransaction.id
      );
      if (index !== -1) {
        this.transactions[category].splice(index, 1, updatedTransaction);
      }
    },
    setTransactions(data) {
      this.transactions = data;
      console.log('Transactions loaded:', this.transactions);
    },
  },
};
</script>

<style>
#app {
  font-family: 'Pretendard Variable', Pretendard, -apple-system,
    BlinkMacSystemFont, system-ui, Roboto, 'Helvetica Neue', 'Segoe UI',
    'Apple SD Gothic Neo', 'Noto Sans KR', 'Malgun Gothic', 'Apple Color Emoji',
    'Segoe UI Emoji', 'Segoe UI Symbol', sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
</style>
