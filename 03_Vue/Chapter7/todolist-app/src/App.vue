<template>
    <!-- 가운데 정렬을 위해 부스트 트랩의 containter클래스 삽입 -->
    <div id="app" class="container">
        <!-- 타이틀 부분 부트스트랩으로 추가 -->
        <div class="card card-body bg-light">
            <div class="title">::TodoList</div>
        </div>
        <div class="card card-default card-borderless">
            <div class="card-body">
                <inputTodolist />
                <todolist />
            </div>
        </div>
    </div>
</template>

<script>
import todolist from './components/todolist.vue';
import inputTodolist from './components/inputTodolist.vue';

let ts = new Date().getTime();
export default {
    name: 'App',
    /*  import와 짝꿍 컴포넌트로 등록해야함 */
    components: { inputTodolist, todolist },
    data() {
        return {
            todolist: [
                { id: ts, todo: '자전거 타기', completed: flase },
                { id: ts + 1, todo: '킥보드 타기', completed: true },
                { id: ts + 2, todo: '자동차 타기', completed: flase },
                { id: ts + 3, todo: '얼룩말 타기', completed: flase },
            ],
        };
    },
    methods: {
      addTodo(todo){
        // todo로 받아온 문자열의 길이가 2이상일 경우에만 todolist 맨 끝에 추가
        // push : 리스트의 맨끝에 요소 추가
        if(todo.length >=){
          this.todolist.push({id:new Date().getTime(), todo:todo, completed: false});
        }
      },
      deleteTodo(id){
        // todolist 돌면서 박아오 id와 꺼내온 아이템의 id가 같을 때 해당 인덱스 반환
        // findindex: 해다아 조건과 만족하는 아이템의 인덱스 반환
        let index = this.todolist.findIndex((item)=>id ===item.id)
        // splice: index 자리에 있는 1개 삭제 (세번째 인자부터는 추가)
        this.todolist.splice(index,1)
      },
toggleCompleted(id){
  let index = this.todolist.findIndex((item)=>id ===item.id);
  // 무조건 반대 값이 들어 갈 수 있도록 !붙여줌
  // 토글은 껐다켰다 하는 기능
this.todolist[index].completed =!this.todolist[index].completed
}
    },
};
</script>
