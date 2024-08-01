<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>새 Todo 생성</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background: linear-gradient(135deg, #e0f7fa, #80deea);
            color: #333;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .container {
            background: #ffffff;
            border-radius: 12px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
            padding: 30px;
            width: 100%;
            max-width: 500px;
            text-align: center;
        }
        h1 {
            color: #00796b;
            margin-bottom: 20px;
            font-size: 2em;
        }
        form {
            display: flex;
            flex-direction: column;
            align-items: stretch;
        }
        input[type="text"], textarea {
            border: 1px solid #b2dfdb;
            border-radius: 8px;
            padding: 10px;
            margin-bottom: 15px;
            font-size: 1em;
            transition: border-color 0.3s, box-shadow 0.3s;
        }
        input[type="text"]:focus, textarea:focus {
            border-color: #00796b;
            box-shadow: 0 0 5px rgba(0, 121, 107, 0.5);
            outline: none;
        }
        input[type="submit"] {
            background-color: #00796b;
            color: #ffffff;
            border: none;
            border-radius: 8px;
            padding: 12px;
            font-size: 1.1em;
            cursor: pointer;
            transition: background-color 0.3s, transform 0.2s;
        }
        input[type="submit"]:hover {
            background-color: #004d40;
            transform: scale(1.05);
        }
    </style>
</head>
<body>
<div class="container">
    <h1>새 Todo 생성</h1>
    <form method="POST">
        <label for="title">제목:</label>
        <input type="text" id="title" name="title" placeholder="제목을 입력하세요">

        <label for="content">내용:</label>
        <textarea name="content" id="content" cols="30" rows="10" placeholder="내용을 입력하세요"></textarea>

        <input type="submit" value="제출">
    </form>
</div>
</body>
</html>
