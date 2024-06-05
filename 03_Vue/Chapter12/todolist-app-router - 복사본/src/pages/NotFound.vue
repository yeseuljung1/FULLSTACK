<template>
    <div class="m-3">
        <p>요청경로 : {{ currentRoute.path }}</p>
    </div>
</template>

<script setup>
import { useRoute } from 'vue-router';
const currentRoute = useRoute();
</script>
