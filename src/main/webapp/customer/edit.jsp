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
        background: linear-gradient(0.25turn, #3f87a6, #ebf8e1, #f69d3c);
        flex-direction: column;
    }
    .main{
        width: 40%;
        height: 500px;
        overflow: hidden;
        border-radius: 10px;
        box-shadow: 5px 20px 50px #000;
        justify-content: center;
        display: flex;
    }
    table{
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
        color: #3ea68a;
        font-size: 2.3em;
        justify-content: center;
        display: flex;
        margin: 30px;
        font-weight: bold;
        cursor: pointer;
        transition: .5s ease-in-out;
    }
</style>
<body>
<div class="main">
<form action="/Customer?action=edit" method="post">
    <table>
        <tr>
            <th colspan="2"><label>Edit Infomation</label></th>
        </tr>
        <tr>
            <td>User Id</td>
            <td> <input size="40" type="text" name="id" id="id" value="${customer.getId()}" readonly></td>
        </tr>
        <tr>
            <td>Username</td>
            <td> <input size="40" type="text" name="username" id="username" value="${customer.getUsername()}" readonly></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input size="40" type="text" name="password" id="password" value="${customer.getPassword()}"></td>
        </tr>
        <tr>
            <td>Phone Number</td>
            <td><input size="40" type="text" name="phone_number" id="phone_number" value="${customer.getPhonenumber()}"></td>
        </tr>
        <tr>
            <td>Email</td>
            <td><input size="40" type="text" name="email" id="email" value="${customer.getEmail()}"></td>
        </tr>
        <tr>
            <td>Address</td>
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
