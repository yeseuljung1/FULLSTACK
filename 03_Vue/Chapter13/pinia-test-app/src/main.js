import { createApp } from 'vue';
import { createPinia } from 'pinia';
// ->피니아 모듈에서 createpinia 함수 가져오기
import App from './App.vue';

const app = createApp(App);

// pinia생성 후 연결
app.use(createPinia());

app.mount('#app');
