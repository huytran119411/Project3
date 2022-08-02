<%--
  Created by IntelliJ IDEA.
  User: haphong
  Date: 26/07/2022
  Time: 16:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Edit Infomation</title>
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
        width: 450px;
        height: 500px;
        overflow: hidden;
        background-image: url(/picture/icons-gray-bg.svg);
        background-color: white ;
        border-radius: 10px;
        box-shadow: 5px 20px 50px #000;
    }

    table{
        width: 450px;
        height: 500px;
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
    label{
        text-align: center;
        color: #000000;
        font-size: 35px;
        justify-content: center;
        display: flex;
        margin: 40px;
        font-weight: bold;
        text-shadow: 4px 4px 0 #3ea68a, 7px 7px 0 rgba(0, 0, 0, 0.2);
    }
</style>
<body>
<div class="main">
<form action="/Customer?action=edit" method="post">
    <table>
        <tr>
            <th colspan="2" ><label>Edit Infomation</label></th>
        </tr>
        <tr>
            <td style=text-align:center >User Id</td>
            <td> <input size="40" type="text" name="id" id="id" value="${customer.getId()}" readonly></td>
        </tr>
        <tr>
            <td style=text-align:center >Username</td>
            <td> <input size="40" type="text" name="username" id="username" value="${customer.getUsername()}" readonly></td>
        </tr>
        <tr>
            <td style=text-align:center >Password</td>
            <td><input size="40" type="text" name="password" id="password" value="${customer.getPassword()}"></td>
        </tr>
        <tr>
            <td style=text-align:center >Phone Number</td>
            <td><input size="40" type="text" name="phone_number" id="phone_number" value="${customer.getPhonenumber()}"></td>
        </tr>
        <tr>
            <td style=text-align:center >Email</td>
            <td><input size="40" type="text" name="email" id="email" value="${customer.getEmail()}"></td>
        </tr>
        <tr>
            <td style=text-align:center >Address</td>
            <td><input size="40" type="text" name="address" id="address" value="${customer.getAddress()}"></td>
        </tr>
        <tr>
            <td colspan="2">
                <button type="submit">Edit</button>
            </td>
        </tr>
    </table>
</form>
</div>
</body>
</html>
