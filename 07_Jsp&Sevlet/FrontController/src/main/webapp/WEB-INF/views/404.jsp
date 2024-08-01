<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>404 - Page Not Found</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background: linear-gradient(135deg, #2b2d34, #1c1e22);
            color: #f0f0f0;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            text-align: center;
            overflow: hidden;
        }
        .container {
            background: #1f1f1f;
            border-radius: 12px;
            box-shadow: 0 12px 24px rgba(0, 0, 0, 0.3);
            padding: 40px;
            width: 90%;
            max-width: 500px;
            position: relative;
            overflow: hidden;
            animation: pulse 1.5s infinite;
        }
        @keyframes pulse {
            0% { box-shadow: 0 0 15px rgba(255, 0, 0, 0.8); }
            50% { box-shadow: 0 0 40px rgba(255, 0, 0, 1); }
            100% { box-shadow: 0 0 15px rgba(255, 0, 0, 0.8); }
        }
        .container::before {
            content: '';
            position: absolute;
            top: -20%;
            left: -20%;
            width: 140%;
            height: 140%;
            background: radial-gradient(circle at 50% 50%, rgba(255, 0, 0, 0.4), transparent);
            z-index: 0;
            animation: glow 3s infinite, rotate 10s linear infinite;
        }
        @keyframes glow {
            0% { opacity: 0.5; transform: scale(1); }
            50% { opacity: 0.2; transform: scale(1.3); }
            100% { opacity: 0.5; transform: scale(1); }
        }
        @keyframes rotate {
            0% { transform: rotate(0deg); }
            100% { transform: rotate(360deg); }
        }
        h1 {
            color: #ff4b5c;
            font-size: 6em;
            margin: 0;
            z-index: 1;
            text-shadow: 0 0 20px rgba(255, 0, 0, 1), 0 0 30px rgba(255, 0, 0, 0.8);
            animation: flicker 1.5s infinite;
        }
        @keyframes flicker {
            0%, 100% { text-shadow: 0 0 20px rgba(255, 0, 0, 1); }
            50% { text-shadow: 0 0 10px rgba(255, 0, 0, 0.8); }
        }
        h3 {
            color: #d0d0d0;
            font-size: 1.5em;
            margin-top: 20px;
            z-index: 1;
            text-shadow: 0 0 10px rgba(255, 255, 255, 0.5);
        }
        a {
            display: inline-block;
            margin-top: 30px;
            padding: 15px 30px;
            font-size: 1.2em;
            color: #ffffff;
            background-color: #ff6f61;
            text-decoration: none;
            border-radius: 8px;
            transition: background-color 0.3s, transform 0.2s, box-shadow 0.3s;
            z-index: 1;
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.5);
            position: relative;
        }
        a::before {
            content: '';
            position: absolute;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            background: radial-gradient(circle at 50% 50%, rgba(255, 0, 0, 0.5), transparent);
            z-index: -1;
            border-radius: 8px;
            filter: blur(5px);
            opacity: 0.6;
            animation: glow-link 2s infinite;
        }
        @keyframes glow-link {
            0% { opacity: 0.6; transform: scale(1); }
            50% { opacity: 0.3; transform: scale(1.1); }
            100% { opacity: 0.6; transform: scale(1); }
        }
        a:hover {
            background-color: #e55b5b;
            transform: scale(1.05);
            box-shadow: 0 8px 16px rgba(0, 0, 0, 0.6);
        }
        @media (max-width: 600px) {
            .container {
                padding: 20px;
            }
            h1 {
                font-size: 4em;
            }
            a {
                font-size: 1em;
                padding: 10px 20px;
            }
        }
    </style>
</head>
<body>
<div class="container">
    <h1>404</h1>
    <h3>경고! 요청하신 페이지를 찾을 수 없습니다.</h3>
    <a href="/">홈으로 돌아가기</a>
</div>
</body>
</html>
