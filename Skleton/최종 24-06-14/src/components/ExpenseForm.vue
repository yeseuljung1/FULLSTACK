<template>
    <div class="container mt-5 custom-container">
        <div class="form-container">
            <div class="buttons mb-3 text-center">
                <button :class="{ active: mode === 'income' }" @click="setMode('income')">수입</button>
                <button :class="{ active: mode === 'expense' }" @click="setMode('expense')">지출</button>
            </div>
            <div class="categories mb-3 text-center">
                <button v-for="category in currentCategories" :key="category" :class="{ active: selectedCategory === category }" @click="selectedCategory = category" class="category-button">
                    {{ category }}
                </button>
                <button @click="showAddCategoryModal" class="btn btn-secondary btn-sm">+</button>
            </div>
            <div class="divbox">
                <label for="date">날짜</label>
                <input type="date" id="date" v-model="date" class="form-control" />
            </div>
            <div class="divbox">
                <label for="amount">금액</label>
                <input type="text" id="amount" v-model="formattedAmount" @input="formatAmount" class="form-control" />
            </div>
            <div class="divbox">
                <label for="description">메모</label>
                <textarea id="description" v-model="description" class="form-control"></textarea>
            </div>
            <div class="divbox" v-if="mode === 'expense'">
                <label for="usage">사용처:</label>
                <input type="text" id="usage" v-model="usage" class="form-control" />
            </div>
            <div class="divbox">
                <label for="file">이미지 첨부파일</label>
                <input type="file" id="file" @change="handleFileUpload" accept="image/*" class="form-control" />
            </div>
            <div v-if="imageUrl" class="mb-3 text-center">
                <img :src="imageUrl" alt="첨부 이미지" style="max-width: 50%; margin-top: 10px" />
            </div>
            <div class="action-buttons">
                <button @click="handleSubmit" class="btn btn-primary me-2">
                    {{ editMode ? '수정' : '추가' }}
                </button>
                <button @click="handleCancel" class="btn btn-secondary">취소</button>
            </div>
        </div>
        <div class="table-container">
            <div class="filters mb-3">
                <select v-model="filterMonth" class="form-control mb-2" @change="applyMonthFilter">
                    <option value="">월별 선택</option>
                    <option v-for="month in uniqueMonths" :key="month" :value="month">{{ month }}월</option>
                </select>
                <select v-model="filterDate" class="form-control mb-2" @change="applyFilters">
                    <option value="">날짜 선택</option>
                    <option v-for="date in uniqueDates" :key="date" :value="date">
                        {{ date }}
                    </option>
                </select>
                <select v-model="filterType" class="form-control mb-2" @change="applyFilters">
                    <option value="">유형 선택</option>
                    <option value="income">수입</option>
                    <option value="expense">지출</option>
                </select>
                <select v-model="filterCategory" class="form-control mb-2" @change="applyFilters">
                    <option value="">카테고리 선택</option>
                    <option v-for="category in allCategories" :key="category" :value="category">
                        {{ category }}
                    </option>
                </select>
                <select v-model="sortType" class="form-control" @change="applySort">
                    <option value="">정렬 선택</option>
                    <option value="oldest">오래된 순</option>
                    <option value="newest">최신 순</option>
                </select>
            </div>
            <table class="table mt-5">
                <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">날짜</th>
                        <th scope="col">유형</th>
                        <th scope="col">카테고리</th>
                        <th scope="col">금액</th>
                        <th scope="col">메모</th>
                        <th scope="col">사용처</th>
                        <th scope="col">영수증 내역</th>
                        <th scope="col"></th>
                    </tr>
                </thead>
                <tbody>
                    <tr v-for="(item, index) in paginatedExpenses" :key="item.id || index">
                        <th scope="row">
                            {{ (currentPage - 1) * itemsPerPage + index + 1 }}
                        </th>
                        <td>{{ item.date }}</td>
                        <td>{{ item.type }}</td>
                        <td>{{ item.category }}</td>
                        <td>{{ item.amount ? item.amount.toLocaleString() : 0 }}원</td>
                        <td>{{ item.memo }}</td>
                        <td>{{ item.usage }}</td>
                        <td>
                            <img v-if="item.imageUrl" :src="item.imageUrl" alt="첨부 이미지" style="max-width: 100px" />
                        </td>
                        <td>
                            <span class="badge bg-secondary pointer m-1" @click="editTransaction(item)">편집</span>
                            <span class="badge bg-secondary pointer m-1" @click="deleteTransaction(item)">삭제</span>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="1.5"><strong>총 수입</strong></td>
                        <td colspan="2">{{ totalIncome.toLocaleString() }}원</td>
                        <td colspan="1.5"><strong>총 지출</strong></td>
                        <td colspan="2">{{ totalExpense.toLocaleString() }}원</td>
                        <td colspan="1.5"><strong>총 잔액</strong></td>
                        <td colspan="2">{{ balance.toLocaleString() }}원</td>
                    </tr>
                </tbody>
            </table>
            <nav aria-label="Page navigation example">
                <ul class="pagination">
                    <li class="page-item" :class="{ disabled: currentPage === 1 }">
                        <a class="page-link" href="#" aria-label="Previous" @click.prevent="changePage(currentPage - 1)">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                    <li class="page-item" v-for="page in totalPages" :key="page" :class="{ active: currentPage === page }">
                        <a class="page-link" href="#" @click.prevent="changePage(page)">{{ page }}</a>
                    </li>
                    <li class="page-item" :class="{ disabled: currentPage === totalPages }">
                        <a class="page-link" href="#" aria-label="Next" @click.prevent="changePage(currentPage + 1)">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </ul>
            </nav>
        </div>

        <div class="modal" tabindex="-1" :class="{ show: isModalVisible }" style="display: block" v-if="isModalVisible">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title">카테고리 추가</h5>
                        <button type="button" class="btn-close" @click="hideAddCategoryModal"></button>
                    </div>
                    <div class="modal-body">
                        <input type="text" v-model="newCategory" class="form-control" placeholder="새 카테고리 이름" />
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-primary" @click="addCategory">추가</button>
                        <button type="button" class="btn btn-secondary" @click="hideAddCategoryModal">취소</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import axios from 'axios';

export default {
    props: ['transactions'],
    data() {
        return {
            mode: 'income',
            date: '',
            amount: '',
            formattedAmount: '',
            selectedCategory: '',
            description: '',
            usage: '',
            file: null,
            imageUrl: null,
            incomeCategories: ['용돈', '월급', '주식'],
            expenseCategories: ['교통', '식비', '도서', '통신', '문화생활'],
            isModalVisible: false,
            newCategory: '',
            filterMonth: '',
            filterDate: '',
            filterType: '',
            filterCategory: '',
            sortType: '', // 기본 정렬을 빈 값으로 설정
            editMode: false,
            editId: null,
            currentPage: 1,
            itemsPerPage: 7,
        };
    },
    computed: {
        currentCategories() {
            return this.mode === 'income' ? this.incomeCategories : this.expenseCategories;
        },
        allCategories() {
            return [...this.incomeCategories, ...this.expenseCategories];
        },
        uniqueMonths() {
            const allTransactions = this.transactions ? [...this.transactions.users, ...this.transactions.expenditures] : [];
            const months = new Set(allTransactions.map((transaction) => transaction.date.split('-')[1]));
            return Array.from(months).sort((a, b) => a - b);
        },
        uniqueDates() {
            if (!this.filterMonth) return [];

            const allTransactions = this.transactions ? [...this.transactions.users, ...this.transactions.expenditures] : [];
            const dates = new Set(allTransactions.filter((transaction) => transaction.date.split('-')[1] === this.filterMonth).map((transaction) => transaction.date));
            return Array.from(dates).sort((a, b) => new Date(a) - new Date(b));
        },
        filteredExpenses() {
            const allTransactions = this.transactions ? [...this.transactions.users, ...this.transactions.expenditures] : [];
            return allTransactions.filter((expense) => {
                return (
                    (!this.filterMonth || expense.date.split('-')[1] === this.filterMonth) &&
                    (!this.filterDate || expense.date === this.filterDate) &&
                    (!this.filterType || expense.type === this.filterType) &&
                    (!this.filterCategory || expense.category === this.filterCategory)
                );
            });
        },
        sortedExpenses() {
            let sorted = [...this.filteredExpenses];
            if (this.sortType === 'oldest') {
                sorted = sorted.sort((a, b) => new Date(a.date) - new Date(b.date));
            } else if (this.sortType === 'newest') {
                sorted = sorted.sort((a, b) => new Date(b.date) - new Date(a.date));
            }
            console.log(sorted);
            return sorted;
        },
        paginatedExpenses() {
            const start = (this.currentPage - 1) * this.itemsPerPage;
            const end = start + this.itemsPerPage;
            return this.sortedExpenses.slice(start, end);
        },
        totalIncome() {
            return this.filteredExpenses.filter((expense) => expense.type === 'income').reduce((total, expense) => total + expense.amount, 0);
        },
        totalExpense() {
            return this.filteredExpenses.filter((expense) => expense.type === 'expense').reduce((total, expense) => total + expense.amount, 0);
        },
        balance() {
            return this.totalIncome - this.totalExpense;
        },
        totalPages() {
            return Math.ceil(this.sortedExpenses.length / this.itemsPerPage);
        },
    },
    watch: {
        sortType() {
            this.applySort();
        },
    },
    methods: {
        setMode(mode) {
            this.mode = mode;
            this.selectedCategory = ''; // 모드를 변경할 때 선택된 카테고리 초기화
        },
        showAddCategoryModal() {
            this.isModalVisible = true;
        },
        hideAddCategoryModal() {
            this.isModalVisible = false;
            this.newCategory = '';
        },
        addCategory() {
            if (!this.newCategory) {
                alert('카테고리 이름을 입력해 주세요.');
                return;
            }
            if (this.mode === 'income') {
                this.incomeCategories.push(this.newCategory);
            } else {
                this.expenseCategories.push(this.newCategory);
            }
            this.hideAddCategoryModal();
        },
        formatAmount() {
            const numericValue = this.formattedAmount.replace(/\D/g, '');
            this.formattedAmount = numericValue.replace(/\B(?=(\d{3})+(?!\d))/g, ',');
            this.amount = numericValue;
        },
        handleFileUpload(event) {
            const file = event.target.files[0];
            this.file = file;

            if (file) {
                const reader = new FileReader();
                reader.onload = (e) => {
                    this.imageUrl = e.target.result;
                };
                reader.readAsDataURL(file);
            } else {
                this.imageUrl = null;
            }
        },
        validateDate() {
            if (!this.isValidDate(this.date)) {
                alert('유효하지 않은 날짜입니다. 다시 입력해 주세요.');
                this.date = '';
            }
        },
        isValidDate(dateStr) {
            const date = new Date(dateStr);
            return date instanceof Date && !isNaN(date);
        },
        async handleSubmit() {
            if (!this.selectedCategory) {
                alert('카테고리를 선택해 주세요.');
                return;
            }

            if (!this.isValidDate(this.date)) {
                alert('유효하지 않은 날짜입니다. 다시 입력해 주세요.');
                return;
            }

            const formData = {
                date: this.date,
                type: this.mode,
                category: this.selectedCategory,
                amount: parseInt(this.amount, 10),
                memo: this.description,
                usage: this.usage,
                imageUrl: this.imageUrl,
            };

            const category = this.mode === 'income' ? 'users' : 'expenditures';

            try {
                if (this.editMode) {
                    await axios.put(`http://localhost:3000/${category}/${this.editId}`, formData);
                    this.$emit('update-transaction', { ...formData, id: this.editId });
                } else {
                    const response = await axios.post(`http://localhost:3000/${category}`, formData);
                    this.$emit('add-transaction', { ...formData, id: response.data.id });
                }
                this.resetForm();
            } catch (error) {
                console.error('Error submitting transaction:', error);
            }
        },
        handleCancel() {
            this.resetForm();
        },
        resetForm() {
            this.mode = 'income';
            this.date = '';
            this.amount = '';
            this.formattedAmount = '';
            this.selectedCategory = '';
            this.description = '';
            this.usage = '';
            this.file = null;
            this.imageUrl = null;
            this.editMode = false;
            this.editId = null;
        },
        applyFilters() {
            // This method is used to refresh the sortedExpenses computed property
            this.sortedExpenses;
        },
        applyMonthFilter() {
            this.filterDate = '';
            this.applyFilters();
        },
        resetFiltersAndSort() {
            this.filterMonth = '';
            this.filterDate = '';
            this.filterType = '';
            this.filterCategory = '';
            this.sortType = '';
            this.applySort();
        },
        applySort() {
            // This method is used to refresh the sortedExpenses computed property
            this.sortedExpenses;
        },
        editTransaction(item) {
            this.editMode = true;
            this.editId = item.id;
            this.date = item.date;
            this.mode = item.type;
            this.selectedCategory = item.category;
            this.amount = item.amount;
            this.formattedAmount = item.amount.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',');
            this.description = item.memo;
            this.usage = item.usage;
            this.imageUrl = item.imageUrl;
        },
        async deleteTransaction(item) {
            const category = item.type === 'income' ? 'users' : 'expenditures';
            try {
                await axios.delete(`http://localhost:3000/${category}/${item.id}`);
                this.$emit('delete-transaction', item.id);
            } catch (error) {
                console.error('Error deleting transaction:', error);
            }
        },
        changePage(page) {
            if (page >= 1 && page <= this.totalPages) {
                this.currentPage = page;
            }
        },
    },
    async mounted() {
        try {
            const responseUsers = await axios.get('http://localhost:3000/users');
            const responseExpenditures = await axios.get('http://localhost:3000/expenditures');
            if (responseUsers.data && responseExpenditures.data) {
                this.$emit('load-transactions', {
                    users: responseUsers.data,
                    expenditures: responseExpenditures.data,
                });
            }
        } catch (error) {
            console.error('Error fetching transactions:', error);
        }
    },
};
</script>

<style scoped>
.container.custom-container {
    width: 100%;
    max-width: 1200px;
    background-color: rgba(255, 255, 255, 0.8); /* 배경을 반투명으로 설정 */
    border-radius: 8px;
    padding: 20px;
    box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
    margin: 20px auto;
}

.form-container {
    display: flex;
    flex-direction: column;
    align-items: flex-start;
    width: 20%;
    margin-bottom: 50px;
    width: 1010px;
}

.form-container .buttons,
.form-container .categories {
    display: flex;
    justify-content: center;
    margin-bottom: 10px;
    padding: auto;
    width: 650px;
    margin-left: 200px;
}

.table-container {
    display: flex;
    flex-direction: column;
    align-items: center; /* 수평으로 가운데 정렬 */
    width: 100%;
}
.form-container .buttons button,
.form-container .categories button {
    display: flex;
    justify-content: space-between;
    margin-bottom: 10px;
    flex: 1;
    margin: 0 5px;
}

.form-container .buttons button.active:hover {
    background-color: #d8b5a9; /* 원하는 호버 색상으로 변경 */
}

.form-container .buttons .active,
.form-container .categories .active {
    background-color: #967e76;
}

.form-group {
    display: flex;
    align-items: center; /* 수직으로 가운데 정렬 */
    justify-content: center; /* 수평으로 가운데 정렬 */
    margin-bottom: 15px;
    width: 100%;
}

.form-group label {
    flex: 0 0 100px; /* 레이블 너비 설정 */
    text-align: right;
    padding-right: 10px;
    display: flex;
    align-items: center; /* 수직으로 가운데 정렬 */
}

.form-group input,
.form-group textarea,
.form-group select {
    flex: 1;
    max-width: 100px; /* 입력 필드의 최대 너비 설정 */
    box-sizing: border-box; /* 패딩과 테두리를 포함하여 너비를 계산 */
}

.form-group input[type='file'] {
    max-width: none; /* 파일 입력 필드는 최대 너비 제한 없음 */
}

.action-buttons {
    display: flex;
    justify-content: center;
}

.filters {
    display: flex;
    justify-content: space-between;
}

.filters select {
    margin-right: 10px;
}

.table {
    table-layout: auto;
    width: 100%;
    word-wrap: break-word;
}

.table th,
.table td {
    word-wrap: break-word;
    white-space: normal;
    overflow: hidden;
    vertical-align: middle;
}

.table th {
    min-width: 100px; /* 최소 너비 설정 */
    text-align: center;
    padding: 10px;
}

.table td {
    min-width: 100px; /* 최소 너비 설정 */
    padding: 10px;
}

.table th:nth-child(2),
.table td:nth-child(2) {
    width: 50%; /* 날짜 열 너비 설정 */
}

.table th:nth-child(3),
.table td:nth-child(3),
.table th:nth-child(4),
.table td:nth-child(4) {
    width: 3%; /* 유형 및 카테고리 열 너비 설정 */
}

.table th:nth-child(5),
.table td:nth-child(5) {
    width: 15%; /* 금액 열 너비 설정 */
}

.table th:nth-child(6),
.table td:nth-child(6) {
    width: 100%; /* 메모 열 너비 설정 */
    overflow: hidden;
    text-overflow: ellipsis;
}

.table th:nth-child(7),
.table td:nth-child(7) {
    width: 10%; /* 사용처 열 너비 설정 */
}

.table th:nth-child(8),
.table td:nth-child(8) {
    width: 10%; /* 영수증 내역 열 너비 설정 */
}

.table th:nth-child(9),
.table td:nth-child(9) {
    width: 100%; /* 편집 및 삭제 버튼 열 너비 설정 */
}

.table img {
    max-width: 100%;
    height: auto;
}

.modal.show {
    display: block;
    background: rgba(0, 0, 0, 0.5);
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    z-index: 1050;
}

.modal-dialog {
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
}

label {
    display: inline-block;
    width: 100%;
    text-align: center;
}

.form-control {
    width: 100%;
}
.divbox {
    width: 1000px;
    padding: 8px;
    margin-left: 10px;
}
.btn-primary {
    background-color: #967e76;
    border-color: #967e76;
}

.btn-primary:hover {
    background-color: #7d6a64;
    border-color: #7d6a64;
}
.pagination .page-item:nth-child(2) .page-link {
    background-color: #7d6a64; /* 원하는 색상으로 변경 */
    border: none;
}
.action-buttons {
    margin-left: 850px;
}
</style>
