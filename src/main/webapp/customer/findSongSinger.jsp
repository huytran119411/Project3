<%--
  Created by IntelliJ IDEA.
  User: haphong
  Date: 02/08/2022
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://kit.fontawesome.com/44761d56f1.js" crossorigin="anonymous"></script>
<html>
<head>
    <title>Play Song</title>
</head>
<body>
<div id="home"></div>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="d-flex flex-grow-1">
        <span class="w-100 d-lg-none d-block"></span>
        <a class="navbar-brand d-none d-lg-inline-block" href="/Singer?action=home"><i class="fa-solid fa-house-user"></i> Home </a>
        <form action="/Song?action=findSongSinger" method="post">
            <div class="input-group sm">
                <input type="text" name="name" class="form-control" placeholder="Search" style="width:500px;">
                <button class="btn btn-success" type="submit"><i class="fa-solid fa-magnifying-glass"></i></button>
            </div>
        </form>
    </div>
    <div class="collapse navbar-collapse flex-grow-1 text-right" id="myNavbar">
        <ul class="navbar-nav ms-auto flex-nowrap">
            <a href="#" class="nav-link m-2 menu-item"><button type="button" class="btn btn-outline-warning">Hello ${singerName} </button></a>
            <li class="nav-item">
                <a href="/Singer?action=edit&id=${singerId}" class="nav-link m-2 menu-item"><button type="button" class="btn btn-success">Thay Đổi Thông Tin</button></a>
            </li>
            <li class="nav-item">
                <a href="/Song?action=tranfer&id=${singerId}" class="nav-link m-2 menu-item"><button type="button" class="btn btn-success">Thêm Bài Hát</button></a>
            </li>
            <li class="nav-item">
                <a href="/Customer?action=" class="nav-link m-2 menu-item"><button type="button" class="btn btn-success">Sign Out</button></a>
            </li>
            <li class="nav-item">
            </li>
        </ul>
    </div>
</nav>
<div class="row" style="background-color: #f8f9fa">
    <div class="navbar navbar-expand-lg navbar-dark bg-dark" >
        <ul class="navbar-nav ms-auto flex-nowrap">
            <li class="nav-item">
                <a href="#" class="nav-link m-2 menu-item">Ca Sĩ</a>
            </li>
        </ul>
    </div>
</div>
<div class="row" style=" padding-top:10px;">
    <div class="col-3" style="padding-right:0; background-color: #212529;">
        <img src="../picture/black modern religious motivational quote poster.png" alt="..." style="width:100%;border-radius: 5%">
    </div>
    <div class="col-9" style="background-color: #212529">
        <div class="row">
            <br>
            <h2 style="color:white">Song</h2>
            <c:forEach items="${songArrayList}" var="s">
            <div class="col-3" style="text-align: center; border-radius: 5%;border: 5px solid #170f24 ;background-color: #170f24;padding: 10px;">
                <a href="/Song?action=playSongSinger&id=${s.getId()}" style="text-decoration: none"><img src="${s.getLinkImage()}" alt="..." style="width:90%;height: 180px;border-radius: 5%">
                    <b><p style="text-align: center; color: white;padding: 13px";>${s.getSongName()}</p></b>
                    <p style="text-align: center; color: white"></p></a>
            </div>
            </c:forEach>
    </div>
</div>
<%--body end--%>
<div class="row">
    <div class="col-12">
        <footer class="text-center text-white" style="background-color: #212529;">
            <!-- Grid container -->
            <div class="container pt-4">
                <!-- Section: Social media -->
                <section class="mb-4">
                    <!-- Facebook -->
                    <a
                            class="btn btn-link btn-floating btn-lg text-white m-1"
                            href="#!"
                            role="button"
                            data-mdb-ripple-color="dark"
                    ><i class="fab fa-facebook-f"></i
                    ></a>

                    <!-- Twitter -->
                    <a
                            class="btn btn-link btn-floating btn-lg text-white m-1"
                            href="#!"
                            role="button"
                            data-mdb-ripple-color="dark"
                    ><i class="fab fa-twitter"></i
                    ></a>

                    <!-- Google -->
                    <a
                            class="btn btn-link btn-floating btn-lg text-white m-1"
                            href="#!"
                            role="button"
                            data-mdb-ripple-color="dark"
                    ><i class="fab fa-google"></i
                    ></a>

                    <!-- Instagram -->
                    <a
                            class="btn btn-link btn-floating btn-lg text-white m-1"
                            href="#!"
                            role="button"
                            data-mdb-ripple-color="dark"
                    ><i class="fab fa-instagram"></i
                    ></a>

                    <!-- Linkedin -->
                    <a
                            class="btn btn-link btn-floating btn-lg text-white m-1"
                            href="#!"
                            role="button"
                            data-mdb-ripple-color="dark"
                    ><i class="fab fa-linkedin"></i
                    ></a>
                    <!-- Github -->
                    <a
                            class="btn btn-link btn-floating btn-lg text-white m-1"
                            href="#!"
                            role="button"
                            data-mdb-ripple-color="dark"
                    ><i class="fab fa-github"></i
                    ></a>
                </section>
                <!-- Section: Social media -->
            </div>
            <!-- Grid container -->

            <!-- Copyright -->
            <div class="text-center text-white p-3" style="background-color: rgba(0, 0, 0, 0.2);">
                © 2020 Copyright:
                <a class="text-white" href="">Privatemusic.com</a>
            </div>
            <!-- Copyright -->
        </footer>
    </div>
</div>
</body>
</html>
