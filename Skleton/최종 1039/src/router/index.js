import { createRouter, createWebHistory } from 'vue-router';
import Home from '@/pages/Home.vue';
import CardRecommendation from '@/pages/CardRecommendation.vue';
import TodoList from '@/pages/TodoList.vue';
import NotFound from '@/pages/NotFound.vue';
import InOut from '@/pages/InOut.vue';
import ListView from '@/pages/ListView.vue';
import Challenge from '@/pages/Challenge.vue';
import Join from '@/pages/Join.vue';

const routes = [
  { path: '/', name: 'Home', component: Home },
  { path: '/cardRecommendation', component: CardRecommendation },
  { path: '/money', component: TodoList },
  { path: '/:paths(.*)*', component: NotFound },
  { path: '/inOut', component: InOut, meta: { needsTransactions: true } },
  { path: '/ListView', component: ListView },
  { path: '/Challenge', component: Challenge },
  { path: '/Join', component: Join },
];

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes,
});

export default router;
