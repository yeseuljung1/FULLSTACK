<template>
    <div>
        <div class="container">
            <!-- 왼쪽: 수입 입력 폼 -->
            <div class="form-container">
                <h2>수입 추가</h2>
                <form @submit.prevent="submitIncome" class="form">
                    <div class="form-group">
                        <label for="date">날짜:</label>
                        <input type="date" id="date" v-model="incomeData.date" required />
                    </div>
                    <div class="form-group">
                        <label for="income">수입 내용:</label>
                        <input type="text" id="income" v-model="incomeData.income" required />
                    </div>
                    <div class="form-group">
                        <label for="amount">금액:</label>
                        <input type="number" id="amount" v-model.number="incomeData.amount" required />
                    </div>
                    <div class="form-group">
                        <label for="memo">메모:</label>
                        <input type="text" id="memo" v-model="incomeData.memo" />
                    </div>
                    <button type="submit">추가</button>
                </form>
            </div>

            <!-- 오른쪽: 수입 목록 -->
            <div class="list-container">
                <h2>수입 목록</h2>
                <ul>
                    <li v-for="(item, index) in incomeList" :key="index">
                        {{ item.date }} - {{ item.income }} - {{ item.amount }}원
                        <button @click="editIncome(index)">수정</button>
                        <button @click="deleteIncome(index)">삭제</button>
                    </li>
                </ul>
            </div>
        </div>

        <!-- 편집 모달 -->
        <div v-if="isEditing" class="modal">
            <div class="modal-content">
                <span class="close" @click="cancelEdit">&times;</span>
                <h2>수입 수정</h2>
                <form @submit.prevent="updateIncome" class="form">
                    <div class="form-group">
                        <label for="editDate">날짜:</label>
                        <input type="date" id="editDate" v-model="editData.date" required />
                    </div>
                    <div class="form-group">
                        <label for="editIncome">수입 내용:</label>
                        <input type="text" id="editIncome" v-model="editData.income" required />
                    </div>
                    <div class="form-group">
                        <label for="editAmount">금액:</label>
                        <input type="number" id="editAmount" v-model.number="editData.amount" required />
                    </div>
                    <div class="form-group">
                        <label for="editMemo">메모:</label>
                        <input type="text" id="editMemo" v-model="editData.memo" />
                    </div>
                    <button type="submit">수정</button>
                </form>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    data() {
        return {
            incomeData: {
                date: '',
                income: '',
                amount: null,
                memo: '',
            },
            editData: {
                date: '',
                income: '',
                amount: null,
                memo: '',
            },
            incomeList: [], // 예시 데이터로 초기화되었다고 가정합니다.
            isEditing: false,
            currentIndex: null,
        };
    },
    methods: {
        submitIncome() {
            this.incomeList.push({ ...this.incomeData });
            this.incomeData = { date: '', income: '', amount: null, memo: '' };
        },
        editIncome(index) {
            this.isEditing = true;
            this.currentIndex = index;
            this.editData = { ...this.incomeList[index] };
        },
        updateIncome() {
            if (this.currentIndex !== null) {
                this.incomeList.splice(this.currentIndex, 1, this.editData);
                this.cancelEdit();
            }
        },
        deleteIncome(index) {
            this.incomeList.splice(index, 1);
        },
        cancelEdit() {
            this.isEditing = false;
            this.editData = { date: '', income: '', amount: null, memo: '' };
            this.currentIndex = null;
        },
    },
};
</script>

<style scoped>
.container {
    display: flex;
}

.form-container {
    flex: 1;
    margin-right: 20px;
}

.list-container {
    flex: 1;
}

.form-group {
    margin-bottom: 10px;
}

input[type='text'],
input[type='number'],
input[type='date'] {
    width: 100%;
    padding: 8px;
    box-sizing: border-box;
}

button {
    padding: 10px 20px;
    background-color: #0c063c;
    color: white;
    border: none;
    cursor: pointer;
    margin-top: 10px;
}

button:hover {
    background-color: #a9f1ff;
    color: rgb(2, 24, 29) f;
}

.modal {
    display: flex;
    align-items: center;
    justify-content: center;
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background-color: rgba(0, 0, 0, 0.5);
}

.modal-content {
    background-color: white;
    padding: 20px;
    border-radius: 5px;
    width: 50%;
    box-sizing: border-box;
}

.close {
    float: right;
    font-size: 24px;
    cursor: pointer;
}

.close:hover {
    color: red;
}
</style>
