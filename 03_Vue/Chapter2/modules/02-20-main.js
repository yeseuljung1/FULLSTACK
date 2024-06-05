// import, export 키워드를 사용하기 위해서는
/* 1)확장자를 mjs로 사용하거나
2)package.jason에 type module 설정 추가할것 */

import { add } from './02-19-module.js';
console.log(add(4));
