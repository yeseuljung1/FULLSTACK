fs = require('fs');
const data = fs.readFileSync('./chapter_03/sec03/example.txt', 'utf-8');
// fs.writeFileSync 동기로 파일 쓰기
fs.writeFileSync('./chapter_03/sec03/text-1.txt', data);
