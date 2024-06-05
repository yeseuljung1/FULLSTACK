<template>
    <li><input type="Checkbox" v-model="checked" /> 옵션1</li>
</template>

<script>
export default {
    name: 'Checkboxitem',
    data() {
        return {
            checked: false,
        };
    },
};
</script>
