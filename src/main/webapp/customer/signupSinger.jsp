<%--
  Created by IntelliJ IDEA.
  User: haphong
  Date: 27/07/2022
  Time: 21:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Sign Up</title>
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


    label{
        color: #000000;
        font-size: 2em;
        justify-content: center;
        display: flex;
        margin: 40px;
        font-weight: bold;
        text-shadow: 4px 4px 0 #3ea68a, 7px 7px 0 rgba(0, 0, 0, 0.2);
        text-align: center;
    }
    input{
        width: 70%;
        height: 30px;
        background: #ffffff;
        justify-content: center;
        display: flex;
        margin: 10px auto;
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
        cursor: pointer;
    }

    button:hover{
        background: #3ea68a;
    }

    .signup{
        height: 460px;
    }

    #result1{
        color: #000000;
        margin: 2px;
        text-align: center;
        font-size: 20px;
        font-weight: bold;
    }
</style>
<body>
<div class="main">
    <div class="signup">
        <form action="/Singer?action=create" method="post">
            <label >Sign Up Singer</label>
            <input type="text" name="username" id="username" placeholder="Username (6-30 kí tự )" value="${singer.getUsername()}">
            <input type="text" name="password" id="password" placeholder="Password (chữ,số,kí tự,chữ in hoa)" value="${singer.getPassword()}">
            <input type="text" name="singer_name" id="singer_name" placeholder="Singer Name" value="${singer.getSingerName()}">
            <input type="text" name="picture" id="picture" placeholder="Picture" value="${singer.getPicture()}">
            <input type="text" name="phone_number" id="phone_number" placeholder="Phone Number" value="${singer.getPhonenumber()}">
            <input type="text" name="email" id="email" placeholder="Email" value="${singer.getEmail()}">
            <input type="text" name="address" id="address" placeholder="Address" value="${singer.getAddress()}">
            <p id = "result1">${result1}</p>
            <button type="submit">Sign up</button>
        </form>
    </div>
</div>
</body>
</html>