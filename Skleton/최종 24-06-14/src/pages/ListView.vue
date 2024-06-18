<template>
  <div class="login-container">
    <h2>로그인</h2>
    <div class="form-group">
      <label for="username">아이디</label>
      <input
        type="text"
        id="username"
        v-model="username"
        placeholder="아이디를 입력해주세요"
      />
    </div>
    <div class="form-group">
      <label for="password">비밀번호</label>
      <input
        type="password"
        id="password"
        v-model="password"
        placeholder="비밀번호를 입력해주세요"
      />
    </div>
    <div class="form-group">
      <!-- <router-link :to="{ name: 'Login' }">로그아웃</router-link> -->
      <button @click="login">로그인</button>
    </div>
    <p v-if="error" class="error">{{ error }}</p>
    <router-link to="/Join">
      <button>회원가입</button>
    </router-link>
  </div>
  <div class="form-group">
    <!-- <router-link :to="{ name: 'Login' }">로그아웃</router-link> -->
  </div>
</template>

<script>
export default {
  data() {
    return {
      username: '',
      password: '',
      error: '',
    };
  },
  methods: {
    login() {
      if (this.username === 'daldidan' && this.password === '1234') {
        console.log('aaaaa');
        this.$router.push({ name: 'Home' });

        // alert('로그인 성공!');
      } else {
        this.error = '유효하지 않은 사용자 이름 또는 비밀번호입니다.';
      }
    },
  },
};
</script>

<style scoped>
.login-container {
  width: 300px;
  margin: 50px auto;
  padding: 20px;
  border: 1px solid #ccc;
  border-radius: 5px;
  background-color: #f9f9f9;
  box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
}
.form-group {
  margin-bottom: 15px;
}
.form-group label {
  display: block;
  font-weight: bold;
  margin-bottom: 5px;
}
.form-group input {
  width: calc(100% - 10px);
  padding: 8px;
  font-size: 14px;
  border: 1px solid #ccc;
  border-radius: 3px;
}
.form-group button {
  width: 100%;
  padding: 10px;
  background-color: #007bff;
  color: #fff;
  border: none;
  border-radius: 3px;
  cursor: pointer;
}
.form-group button:hover {
  background-color: #0056b3;
}
.error {
  color: red;
}
</style>
