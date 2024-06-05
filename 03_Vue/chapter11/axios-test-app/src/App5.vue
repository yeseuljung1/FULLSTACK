<template>
    <div>
        <h2>콘솔을 확인합니다.</h2>
    </div>
</template>

<script setup>
import axios from 'axios';

const requestAPI = async () => {
    // const url = 'http://localhost:3000/todos/1';
    const url = '/api/todos';
    // api요청에 성공했을때
    try {
        const response = await axios.get(url, { timeout: 900 });
        console.log('#응답객체:', response);
    } catch (e) {
        // api요청에 실패했을때
        console.log('##다음 오류가 발생했습니다.');
        if (e instanceof Error) console.log(e.message);
        // instanceof: e가 에러 타입인지 체크
        else console.log(e);
    }
};

requestAPI();
</script>
