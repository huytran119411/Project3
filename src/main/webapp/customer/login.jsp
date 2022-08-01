<%--
  Created by IntelliJ IDEA.
  User: haphong
  Date: 27/07/2022
  Time: 10:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Log In</title>
  <link href="https://fonts.googleapis.com/css2?family=Jost:wght@500&display=swap" rel="stylesheet">
</head>
<style>
  body{
    margin: 0;
    padding: 0;
    display: flex;
    justify-content: center;
    align-items: center;
    min-height: 100vh;
    font-family: 'Jost', sans-serif;
    background: #212529;
    flex-direction: column;
  }

  .main{
    width: 350px;
    height: 500px;
    overflow: hidden;
    background-image: url(/picture/icons-gray-bg.svg);
    background-color: white ;
    border-radius: 10px;
    box-shadow: 5px 20px 50px #000;
  }


  .login{
    position: relative;
    width:100%;
    height: 100%;
  }

  label{
    color: #000000;
    font-size: 4em;
    justify-content: center;
    display: flex;
    margin: 40px;
    font-weight: bold;
    text-shadow: 4px 4px 0 #3ea68a, 7px 7px 0 rgba(0, 0, 0, 0.2);
  }

  input{
    width: 60%;
    height: 30px;
    background: #ffffff;
    justify-content: center;
    display: flex;
    margin: 20px auto;
    padding: 10px;
    border: 1px solid #3ea68a;
    outline: none;
    border-radius: 5px;
  }
  button{
    width: 60%;
    height: 40px;
    margin: 10px auto;
    justify-content: center;
    display: block;
    color: #fff;
    background: #3ea68a;
    font-size: 1em;
    font-weight: bold;
    margin-top: 20px;
    outline: none;
    border: none;
    border-radius: 5px;
    transition: .2s ease-in;
    cursor: pointer;
  }

  button:hover{
    background: #3ea68a;
  }

  .login{
    height: 460px;
  }

  #result{
    color: #e53131;
    margin: 2px;
    text-align: center;
    font-size: 17px;
    font-weight: bold;
  }
</style>
<body>
<div class="main">
  <div class="login">
    <form action="/Customer?action=login" method="post" >
      <label>Login</label>
      <input type="text" name="username" id="username" placeholder="Username">
      <input type="text" name="password" id="password" placeholder="Password">
      <p id = "result">${result}</p>
      <br><br>
      <button type="submit" >Login</button>

    </form>
  </div>
</div>
</body>
</html>