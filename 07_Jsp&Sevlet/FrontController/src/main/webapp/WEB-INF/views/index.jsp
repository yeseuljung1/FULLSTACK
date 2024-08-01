<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>JSP - Hello World</title>
  <style>
    body {
      font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
      background: linear-gradient(135deg, #ffb3e6, #c2e0ff);
      color: #333;
      margin: 0;
      padding: 0;
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100vh;
      overflow: hidden;
    }
    .container {
      background: #ffffff;
      border-radius: 20px;
      box-shadow: 0 12px 24px rgba(0, 0, 0, 0.15);
      padding: 40px;
      width: 100%;
      max-width: 600px;
      text-align: center;
      position: relative;
      overflow: hidden;
      animation: bounceIn 1s ease-out;
    }
    .container::before {
      content: '';
      position: absolute;
      top: -20%;
      left: -20%;
      width: 140%;
      height: 140%;
      background: radial-gradient(circle at 50% 50%, rgba(255, 223, 186, 0.4), transparent);
      z-index: 0;
      transform: rotate(30deg);
    }
    .container:hover {
      transform: translateY(-5px);
      box-shadow: 0 16px 32px rgba(0, 0, 0, 0.2);
      transition: all 0.3s ease;
    }
    h1 {
      color: #ff69b4;
      font-size: 3em;
      margin-bottom: 20px;
      font-weight: 700;
      position: relative;
      z-index: 1;
      text-shadow: 1px 1px 4px rgba(0, 0, 0, 0.1);
      animation: textGlow 2s ease-in-out infinite alternate;
    }
    @keyframes textGlow {
      from { text-shadow: 1px 1px 5px rgba(0, 0, 0, 0.2); }
      to { text-shadow: 1px 1px 15px rgba(255, 105, 180, 0.8); }
    }
    a {
      display: inline-block;
      padding: 15px 30px;
      font-size: 1.2em;
      color: #ffffff;
      background-color: #ffb347;
      text-decoration: none;
      border-radius: 12px;
      transition: background-color 0.3s, transform 0.2s, box-shadow 0.3s;
      position: relative;
      z-index: 1;
    }
    a:hover {
      background-color: #ff8c00;
      transform: scale(1.05);
      box-shadow: 0 4px 12px rgba(0, 0, 0, 0.2);
    }
    .footer {
      margin-top: 20px;
      font-size: 0.9em;
      color: #888;
      position: relative;
      z-index: 1;
    }
    @keyframes bounceIn {
      from {
        opacity: 0;
        transform: scale(0.9);
      }
      to {
        opacity: 1;
        transform: scale(1);
      }
    }
    @media (max-width: 600px) {
      .container {
        padding: 20px;
      }
      h1 {
        font-size: 2em;
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
  <h1>FrontController</h1>
  <a href="todo/list">Todo 목록보기</a>
  <div class="footer">
    &copy; 2024 Your Company
  </div>
</div>
</body>
</html>
