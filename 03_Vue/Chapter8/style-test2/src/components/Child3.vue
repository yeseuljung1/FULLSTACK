<template>
    <div class="child">
        <h2>Child3</h2>
    </div>
</template>

<script>
export default {
    name: 'Child3',
};
</script>

<!--해당 컴포넌트에서만 적용하려면 scoped를 붙여줘야한다 -->
<style scoped>
.child {
    background-color: orange;
    border: solid 1px black;
    margin: 1.5em;
    padding: 1em;
}
</style>
