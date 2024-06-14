<template>
  <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <span class="navbar-brand ps-2">달디단 가계부</span>
    <button
      class="navbar-toggler"
      type="button"
      @click="isNavShow = !isNavShow"
    >
      <span class="navbar-toggler-icon"></span>
    </button>
    <div
      :class="
        isNavShow ? 'collapse navbar-collapse show' : 'collapse navbar-collapse'
      "
    >
      <ul class="navbar-nav">
        <li class="nav-item">
          <router-link class="navHome nav-link" to="/"> Home </router-link>
        </li>
        <li class="nav-item">
          <router-link
            class="navCardRecommendation nav-link"
            to="/CardRecommendation"
          >
            카드 추천
          </router-link>
        </li>
        <li class="nav-item">
          <router-link class="navInOut nav-link" to="/InOut">InOut</router-link>
        </li>

        <li class="nav-item">
          <router-link class="navChallenge nav-link" to="/Challenge"
            >무지출 챌린지</router-link
          >
        </li>
      </ul>
    </div>
    <div class="collapse navbar-collapse d-flex justify-content-end">
      <ul class="navbar-nav">
        <li class="nav-item">
          <router-link class="navListView nav-link" to="/Listview"
            >회원가입/로그인</router-link
          >
        </li>
      </ul>
    </div>
  </nav>
</template>

<script setup>
import { ref } from 'vue';

const isNavShow = ref(false);
</script>

<style>
@import url('../main.css');
</style>
