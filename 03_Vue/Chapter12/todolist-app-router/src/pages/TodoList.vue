<template>
    <div class="row">
        <div class="col p-3">
            <!-- 링크 클릭시 할 일 추가 화면으로 이동 -->
            <router-link class="btn btn-primary" to="/todos/add"> 할일추가 </router-link>
            <button class="btn btn-primary ms-1" @click="fetchTodoList">새로 고침</button>
        </div>
    </div>
    <div class="row">
        <div class="col">
            <ul class="list-group">
                <!-- todolist 를 돌면서 todoitem 출력하고 자식에세 props로 todoitem  전송 -->
                <TodoItem v-for="todoItem in todoList" :key="todoItem.id" :todoItem="todoItem" />
            </ul>
        </div>
    </div>
</template>

<script setup>
import { inject } from 'vue';
import TodoItem from '@/components/TodoItem.vue';

// app.vue가 privide 한 todolist를 inject로 받아옴
const todoList = inject('todoList');
const { fetchTodoList } = inject('actions');
</script>
