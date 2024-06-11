<template>
    <div id="app">
        <h1>달력 및 가계부yyysss</h1>
        <!-- ---------------------------------------------------------- -->
        <div id="header">
            <div>
                <label for="year">연도:</label>
                <input v-model.number="year" type="number" id="year" />
            </div>
            <div>
                <label for="month">월:</label>
                <select v-model.number="month" id="month">
                    <option v-for="m in 12" :key="m" :value="m">{{ m }}월</option>
                </select>
            </div>
        </div>

        <button @click="generateCalendar">달력 생성</button>
        <!-- ---------------------------------------------------------- -->
        <div v-if="days.length">
            <h2>{{ year }}년 {{ month }}월</h2>
            <div class="calendar">
                <div class="day-header" v-for="day in dayNames" :key="day">
                    {{ day }}
                </div>
                <div class="day" v-for="(day, index) in days" :key="index" @click="selectDay(day)">
                    {{ day }}
                </div>
            </div>
        </div>
        <!-- ---------------------------------------------------------- -->
        <div v-if="selectedDate">
            <h2>{{ selectedDate }}의 수입 및 지출 내역</h2>
            <ul>
                <li v-for="(transaction, index) in transactionsByDate" :key="index">
                    {{ transaction.type === 'income' ? '수입' : '지출' }}:
                    {{ transaction.amount }}
                    <button @click="editTransaction(index)">편집</button>
                    <button @click="deleteTransaction(index)">삭제</button>
                </li>
            </ul>
        </div>
        <!-- ---------------------------------------------------------- -->
        <div>
            <label for="amount">금액:</label>
            <input v-model.number="amount" type="number" id="amount" />
        </div>
        <div>
            <label for="type">유형:</label>
            <select v-model="type" id="type">
                <option value="income">수입</option>
                <option value="expense">지출</option>
            </select>
        </div>
        <div v-if="type === 'income'">
            <label>수입 카테고리:</label>
            <button v-for="category in incomeCategories" :key="category" @click="setCategory(category)">
                {{ category }}
            </button>
        </div>
        <div v-if="type === 'expense'">
            <label>지출 카테고리:</label>
            <button v-for="category in expenseCategories" :key="category" @click="setCategory(category)">
                {{ category }}
            </button>
        </div>
        <!-- ---------------------------------------------------------- -->
        <h2>전체 총 수입: {{ totalIncome }}</h2>
        <h2>전체 총 지출: {{ totalExpense }}</h2>
        <h2>전체 잔액: {{ balance }}</h2>
    </div>
</template>

<script>
export default {
    data() {
        return {
            year: new Date().getFullYear(),
            month: new Date().getMonth() + 1,
            days: [],
            dayNames: ['일', '월', '화', '수', '목', '금', '토'],
            transactions: {},
            selectedDate: null,
            amount: 0,
            type: 'income',
            editIndex: -1,
            incomeCategories: ['용돈', '주식', '월급'],
            expenseCategories: ['미용', '병원', '교통'],
        };
    },
    computed: {
        totalIncome() {
            return this.calculateTotal(this.allTransactions, 'income');
        },
        totalExpense() {
            return this.calculateTotal(this.allTransactions, 'expense');
        },
        balance() {
            return this.totalIncome - this.totalExpense;
        },
        allTransactions() {
            return Object.values(this.transactions).reduce((acc, transactions) => acc.concat(transactions), []);
        },
        transactionsByDate() {
            return this.transactions[this.selectedDate] || [];
        },
    },
    methods: {
        generateCalendar() {
            const date = new Date(this.year, this.month - 1, 1);
            const days = [];
            const firstDayIndex = date.getDay();
            const lastDay = new Date(this.year, this.month, 0).getDate();
            for (let i = 0; i < firstDayIndex; i++) {
                days.push('');
            }
            for (let i = 1; i <= lastDay; i++) {
                days.push(i);
            }
            this.days = days;
        },
        selectDay(day) {
            if (day) {
                this.selectedDate = `${this.year}-${String(this.month).padStart(2, '0')}-${String(day).padStart(2, '0')}`;
            }
        },
        addTransaction() {
            if (this.selectedDate) {
                if (this.editIndex >= 0) {
                    this.transactions[this.selectedDate][this.editIndex] = {
                        amount: this.amount,
                        type: this.type,
                    };
                    this.editIndex = -1;
                } else {
                    if (!this.transactions[this.selectedDate]) {
                        this.transactions[this.selectedDate] = [];
                    }
                    this.transactions[this.selectedDate].push({
                        amount: this.amount,
                        type: this.type,
                    });
                }
                this.amount = 0;
                this.type = 'income';
            }
        },
        editTransaction(index) {
            const transaction = this.transactionsByDate[index];
            this.amount = transaction.amount;
            this.type = transaction.type;
            this.editIndex = index; // 편집할 인덱스 설정
        },
        deleteTransaction(index) {
            this.transactions[this.selectedDate].splice(index, 1);
            if (this.transactions[this.selectedDate].length === 0) {
                delete this.transactions[this.selectedDate];
            }
        },
        calculateTotal(transactions, type) {
            return transactions.filter((transaction) => transaction.type === type).reduce((sum, transaction) => sum + transaction.amount, 0);
        },
        setCategory(category) {
            this.selectedCategory = category;
            this.addTransaction();
        },
    },
    mounted() {
        this.generateCalendar();
    },
};
</script>

<style>
html,
body {
    margin: 0;
    padding: 0;
    height: 100%;
    overflow: auto;
}

#app {
    font-family: Avenir, Helvetica, Arial, sans-serif;
    text-align: center;
    color: #2c3e50;
    margin-top: 60px;
    width: 1000px;
    margin: 0 auto;
    padding: 20px;
    box-sizing: border-box;
}
input,
select {
    margin: 5px;
}
button {
    margin: 10px;
}
/* 전체 달력 컨테이너 */
.calendar {
    display: grid;
    grid-template-columns: repeat(7, 1fr);
    gap: 5px;
    margin-top: 20px;
    background-color: #f0f4f8;
    border-radius: 10px;
    padding: 10px;
    box-shadow: 0px 3px 15px rgba(0, 0, 0, 0.1);
}

/* 날짜 헤더 */
.day-header {
    font-weight: bold;
    padding: 10px;
    border: 1px solid #dcdcdc;
    text-align: center;
    background-color: #f8fafc;
}

/* 각 날짜 */
.day {
    padding: 10px;
    border: 1px solid #dcdcdc;
    text-align: center;
    cursor: pointer;
    transition: background-color 0.3s ease;
}

/* 날짜 호버 시 배경색 변경 */
.day:hover {
    background-color: #70c6ff;
}

/* 선택된 날짜 */
.selected-day {
    background-color: rgb(176, 244, 255);
    color: #ffffff;
    border-radius: 50%;
}

/* 날짜가 비어있는 경우 */
.empty-day {
    visibility: hidden;
}

#container {
    width: 100px;
    height: 100px;
    background-color: gray;
    float: right;
}
#header {
    display: flex;
}
button {
    color: rgb(224, 255, 220);
    background-color: rgb(9, 5, 54);
    border-radius: 10px;
}
button:hover {
    background-color: #16c5ff;
    color: #000001;
}
</style>
