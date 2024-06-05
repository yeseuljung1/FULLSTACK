<template>
    <div>
        <input type="checkbox" :value="id" :checked="checked" @change="$emit('check-changed', { id, checked: $event.target.checked })" />
        <!-- slot으로 부모에서 보낸 span을 전달 받는다
        부모에서 온 -->
        <slot>Item</slot>
    </div>
</template>

<script>
export default {
    name: 'CheckBox2',
    props: ['id', 'checked'],
};
</script>
