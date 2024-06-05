const fs = require('fs');
fs.readdir('./', (err, files) => {
    if (err) {
        console.error(err);
        // return을 만나면 함수 종료
        return;
    }
    console.log(files);
});
