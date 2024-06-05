<template>
    <div>
        <h2>TodoList 테스트(Composition API)</h2>
        <hr />
        할 일 추가:
        <input type="text" v-model="todo" />
        <button @click="addTodoHandler">추가</button>
        <hr />
        <ul>
            <li v-for="todoItem in todoList">
                <span style="cursor: pointer" @click="toggleDone(todoItem.id)">
                    <!-- 할 일의 내용을 표시하고 할일이 완료된 경우 (완료) 라는 글씨 표시 -->
                    {{ todoItem.todo }}{{ todoItem.done ? '(완료)' : '' }}
                </span>
                <!-- 스페이스 3칸 추가 -->
                &nbsp;&nbsp;&nbsp;
                <!-- 클릭 시 해당 아이디를 가진 할 일이 삭제 됨 -->
                <button @click="deleteTodo(todoItem.id)">삭제</button>
            </li>
        </ul>
        <!-- 스토어의 donecount에 접근해서 계산된 속성으로 만들어줌 -->
        <div>완료된 할일 수:{{ doneCount }}</div>
    </div>
</template>

<script setup>
import { useTodoListStore } from '@/stores/todoList.js';
import { ref, computed } from 'vue';

// 값형 데이터 이기 때문에 ref반응성 추가
const todo = ref('');
const TodoListStore = useTodoListStore();
// 분해할당으로 스토어 내에서 리턴한 데이터들 가져옴
const { todoList, addTodo, deleteTodo, toggleDone } = TodoListStore;

// 분해 할당으로 받아오지 않은 값은 스토어 명으로 접근해야함
const doneCount = computed(() => TodoListStore.doneCount);

const addTodoHandler = () => {
    // 축가적인 기능이 있을 때는 새로운 핸들러 작성
    addTodo(todo.value);
    todo.value = '';
};
</script>
