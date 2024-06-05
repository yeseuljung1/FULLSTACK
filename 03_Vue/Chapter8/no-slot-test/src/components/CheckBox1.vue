<template>
    <div>
        <!-- 체크박스 변경시 id값과 현재 체크박스의 체크상태값으르 check-change 이벤트를 담아서 부모로 보냄 -->
        <input type="checkbox" :value="id" :checked="checked" @change="$emit('check-changed', { id, checked: $event.target.checked })" />
        <!-- 체크박스가 체크 됐을 경우 span 태그 렌더링 -->
        <span v-if="checked === true" style="color: blue; text-decoration: underline">
            <!-- 보여질 경우 이탤리체로 -->
            <i>{{ label }}</i>
        </span>
        <!-- 체크 해제 됐을 경우 렌더링 되는 span
            만약에 체크가 된다면 위에 span이 나온다 -->
        <span v-else style="color: gray">{{ label }}</span>
    </div>
</template>

<script>
export default {
    name: 'CheckBox1',
    props: ['id', 'checked', 'label'] /* 부모 컨포넌트로부터 받을 속성들 */,
};
</script>
