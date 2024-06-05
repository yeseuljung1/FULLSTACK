fs = require('fs');
const data = fs.readFileSync('./chapter_03/sec03/example.txt', 'utf-8');

// fs.existsSync:해달 파일이 존재하는지 여부를 boolean으로 변환
if (fs.existsSync('./chapter_03/sec03/text-1.txt')) {
    console.log('file already exist');
} else {
    fs.writeFileSync('./chapter_03/sec03/text-1.txt', data);
}
