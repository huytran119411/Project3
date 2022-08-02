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
        font-size: 3em;
        justify-content: center;
        display: flex;
        margin: 40px;
        font-weight: bold;
        text-shadow: 4px 4px 0 #3ea68a, 7px 7px 0 rgba(0, 0, 0, 0.2);
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
        <form action="/Song?action=create" method="post">
            <label >Create Song</label>
            <input type="text" name="songName" id="songName" placeholder="Song Name" >
            <input type="text" name="linkSong" id="linkSong" placeholder="Link Song (.mp3)">
            <input type="text" name="linkImage" id="linkImage" placeholder="Link Image">
            <input type="text" name="id" id="id" value="${id}" style="display: none">
            <button type="submit">Create</button>
        </form>
    </div>
</div>
</body>
</html>