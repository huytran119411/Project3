<%--
  Created by IntelliJ IDEA.
  User: haphong
  Date: 01/08/2022
  Time: 17:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: haphong
  Date: 27/07/2022
  Time: 08:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://kit.fontawesome.com/44761d56f1.js" crossorigin="anonymous"></script>
<html>
<head>
    <title>Main Page User</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>CSS glowing icons</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
<link rel="stylesheet" href="/customer/test.css">
<div id="home"></div>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="d-flex flex-grow-1">
        <span class="w-100 d-lg-none d-block"></span>
        <a class="navbar-brand d-none d-lg-inline-block" href="/Customer?action=home"><i class="fa-solid fa-house-user"></i> Home </a>
        <form action="/Song?action=findSongUser" method="post">
            <div class="input-group sm">
                <input type="text" name="name" class="form-control" placeholder="Search" style="width:500px;">
                <button class="btn btn-success" type="submit"><i class="fa-solid fa-magnifying-glass"></i></button>
            </div>
        </form>
    </div>
    <div class="collapse navbar-collapse flex-grow-1 text-right" id="myNavbar">
        <ul class="navbar-nav ms-auto flex-nowrap">
            <a href="#" class="nav-link m-2 menu-item">
                <button type="button" class="btn btn-outline-warning">Hello ${name} </button>
            </a>
            <li class="nav-item">
                <a href="/Playlist?action=displaySong&id=${id}" class="nav-link m-2 menu-item" ><button type="submit" class="btn btn-success">Quản Lý Playlist</button></a>
            </li>
            <li class="nav-item">
                <a href="/Customer?action=edit&id=${id}" class="nav-link m-2 menu-item" ><button type="submit" class="btn btn-success">Thay Đổi Thông Tin</button></a>
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
    <div class="navbar navbar-expand-lg navbar-dark bg-dark">
        <ul class="navbar-nav ms-auto flex-nowrap">
            <li class="nav-item">
                <a href="#" class="nav-link m-2 menu-item">Ca Sĩ</a>
            </li>
        </ul>
    </div>
</div>
<div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="carousel"
     style="text-align: center;background-color: #212529; width: 100%">
    <div class="carousel-indicators">
        <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active"
                aria-current="true" aria-label="Slide 1"></button>
        <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1"
                aria-label="Slide 2"></button>
        <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2"
                aria-label="Slide 3"></button>
        <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="3"
                aria-label="Slide 4"></button>
    </div>
    <div class="carousel-inner">
        <div class="carousel-item active">
            <img src="https://photo-zmp3.zmdcdn.me/banner/2/f/2/e/2f2ee9e31054d0894da4d2a3495bb54c.jpg" alt="...">
        </div>
        <div class="carousel-item">
            <img src="https://photo-zmp3.zmdcdn.me/banner/5/e/2/d/5e2d6801a400d0ac6171fff990b0bb1a.jpg" alt="...">
        </div>
        <div class="carousel-item">
            <img src="https://photo-zmp3.zmdcdn.me/banner/c/f/1/4/cf14856b2c5204bfef4b147753b636f5.jpg" alt="...">
        </div>
        <div class="carousel-item">
            <img src="https://photo-zmp3.zmdcdn.me/banner/2/9/8/d/298db64412c5da6ab258d5a75fbfd1d6.jpg" alt="...">
        </div>
    </div>
    <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators"
            data-bs-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Previous</span>
    </button>
    <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators"
            data-bs-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Next</span>
    </button>
</div>
<%--body start--%>
<div class="row">
    <div class="col-3" style="padding-right:0; background-color:#170f24;">
        <img src="../picture/black modern religious motivational quote poster.png" alt="..." style="width:100%;border-radius: 5%">
    </div>
    <div class="col-9" style="background-color: #170f24">
        <div class="row">
            <br>
            <h2 style="color:white">Hit Song</h2>
            <div class="col-3" style="text-align: center; border-radius: 5%;border: 5px solid #170f24 ;background-color: #170f24;padding: 10px;">
                <a href="/Song?action=playSongUser&id=5" style="text-decoration: none"><img src="../picture/maxresdefault.jpeg" alt="..." style="width:90%;height: 180px;border-radius: 5%">
                    <b><p style="text-align: center; color: white;padding: 13px";>Hương Mùa Hè</p></b>
                    <p style="text-align: center; color: white"> Hương Mùa Hè Band </p></a>
                <a href="/Playlist?action=add&username=${name}&id=5&customerId=${id}"><button class="btn btn-success" type="submit">Add To Playlist</button></a>
            </div>
            <div class="col-3" style="text-align: center; border-radius: 5%;border: 5px solid #170f24 ;background-color: #170f24;padding: 10px;">
                <a href="/Song?action=playSongUser&id=1" style="text-decoration: none"><img src="https://photo-zmp3.zmdcdn.me/banner/2/f/2/e/2f2ee9e31054d0894da4d2a3495bb54c.jpg" alt="..." style="width:90%;height: 180px;border-radius: 5%">
                    <b><p style="text-align: center; color: white;padding: 13px";>Đoạn Kết Mới</p></b>
                    <p style="text-align: center; color: white"> Hoàng Dũng </p></a>
                <a href="/Playlist?action=add&username=${name}&id=1&customerId=${id}"><button class="btn btn-success" type="submit">Add To Playlist</button></a>
            </div>
            <div class="col-3" style="text-align: center; border-radius: 5%;border: 5px solid #170f24 ;background-color: #170f24;padding: 10px;">
                <a href="/Song?action=playSongUser&id=2" style="text-decoration: none"><img src="https://data.chiasenhac.com/data/cover/166/165383.jpg" alt="..." style="width:90%;height: 180px;border-radius: 5%">
                    <b><p style="text-align: center; color: white;padding: 13px";>Vì Mẹ Anh Bắt Chia Tay</p></b>
                    <p style="text-align: center; color: white">Miu Lê</p></a>
                <a href="/Playlist?action=add&username=${name}&id=2&customerId=${id}"><button class="btn btn-success" type="submit">Add To Playlist</button></a>
            </div>
            <div class="col-3" style="text-align: center; border-radius: 5%;border: 5px solid #170f24 ;background-color: #170f24;padding: 10px;">
                <a href="/Song?action=playSongUser&id=3" style="text-decoration: none"><img src="https://i.ytimg.com/vi/B9PDYlaV84w/maxresdefault.jpg" alt="..." style="width:90%;height: 180px;border-radius: 5%">
                    <b><p style="text-align: center; color: white;padding: 13px";>Lời Tạm Biệt Chưa Nói</p></b>
                    <p style="text-align: center; color: white"> Orange & Grey D </p></a>
                <a href="/Playlist?action=add&username=${name}&id=3&customerId=${id}"><button class="btn btn-success" type="submit">Add To Playlist</button></a>
            </div>
            <div class="col-3" style="text-align: center; border-radius: 5%;border: 5px solid #170f24 ;background-color: #170f24;padding: 10px;">
                <a href="/Song?action=playSongUser&id=4" style="text-decoration: none"><img src="https://i.ytimg.com/vi/LaxkmhiECfM/maxresdefault.jpg" alt="..." style="width:90%;height: 180px;border-radius: 5%">
                    <b><p style="text-align: center; color: white;padding: 13px";>Bên Trên Tầng Lầu</p></b>
                    <p style="text-align: center; color: white">Tăng Duy Tân</p></a>
                <a href="/Playlist?action=add&username=${name}&id=4&customerId=${id}"><button class="btn btn-success" type="submit">Add To Playlist</button></a>
            </div>
            <div class="col-3" style="text-align: center; border-radius: 5%;border: 5px solid #170f24 ;background-color: #170f24;padding: 10px;">
                <a href="/Song?action=playSongUser&id=10" style="text-decoration: none"><img src="https://i.scdn.co/image/ab67616d0000b27311011e6d4d2fc5969ba8ab68" alt="..." style="width:90%;height: 180px;border-radius: 5%">
                    <b><p style="text-align: center; color: white;padding: 13px";>Hết Nhạc Con Về</p></b>
                    <p style="text-align: center; color: white"> Cukak </p></a>
                <a href="/Playlist?action=add&username=${name}&id=10&customerId=${id}"><button class="btn btn-success" type="submit">Add To Playlist</button></a>
            </div>
            <div class="col-3" style="text-align: center; border-radius: 5%;border: 5px solid #170f24 ;background-color: #170f24;padding: 10px;">
                <a href="/Song?action=playSongUser&id=9" style="text-decoration: none"><img src="https://navicdn.com/karaokeviet/images/2019/03/05/i4XWOJwUr5onCXarVFBnf8Dt8VDhqYiLAjYGngWy.jpeg" alt="..." style="width:90%;height: 180px;border-radius: 5%">
                    <b><p style="text-align: center; color: white;padding: 13px";>Mãi Mãi Bên Nhau</p></b>
                    <p style="text-align: center; color: white"> Noo Phước Thịnh </p></a>
                <a href="/Playlist?action=add&username=${name}&id=9&customerId=${id}"><button class="btn btn-success" type="submit">Add To Playlist</button></a>
            </div>
            <div class="col-3" style="text-align: center; border-radius: 5%;border: 5px solid #170f24 ;background-color: #170f24;padding: 10px;">
                <a href="/Song?action=playSongUser&id=11" style="text-decoration: none"><img src="https://i.ytimg.com/vi/iODOOoONVew/maxresdefault.jpg" alt="..." style="width:90%;height: 180px;border-radius: 5%">
                    <b><p style="text-align: center; color: white;padding: 13px";>Đồi Thông Hai Mộ</p></b>
                    <p style="text-align: center; color: white"> Hoàng Châu </p></a>
                <a href="/Playlist?action=add&username=${name}&id=11&customerId=${id}"><button class="btn btn-success" type="submit">Add To Playlist</button></a>
            </div>
        </div>
        <div class="row">
            <br>
            <h2 style="color:white">Album</h2>
            <div class="col-3"
                 style="text-align: center; border-radius: 5%;border: 5px solid #170f24 ;background-color: #170f24;padding: 10px;">
                <img src="https://photo-resize-zmp3.zmdcdn.me/w320_r1x1_webp/cover/0/1/c/7/01c7b5ca14a7e541977f46dfd8cabdb5.jpg"
                     alt="" style="width:90%;height: 180px;border-radius: 5%">
                <b><p style="text-align: center; color: white;padding: 10px" ;>Nhạc Cho Chủ Nhật</p></b>
                <p style="text-align: center; color: white"></p>
            </div>
            <div class="col-3"
                 style="text-align: center; border-radius: 5%;border: 5px solid #170f24 ;background-color: #170f24;padding: 10px;">
                <img src="https://photo-resize-zmp3.zmdcdn.me/w320_r1x1_webp/cover/7/2/d/0/72d0d3414a89b76712dbdf05a4e2473c.jpg"
                     alt="" style="width:90%;height: 180px;border-radius: 5%">
                <b><p style="text-align: center; color: white;padding: 10px" ;>Nhạc Phim Hàn</p></b>
                <p style="text-align: center; color: white"></p>
            </div>
        </div>
        <div class="row">
            <br>
            <h2 style="color:white">Nghệ Sĩ Yêu Thích</h2>
            <div class="col-3"
                 style="text-align: center; border-radius: 5%;border: 5px solid #170f24 ;background-color: #170f24;padding: 10px;">
                <img src="https://yt3.ggpht.com/ytc/AKedOLQ-pO1p4Djrp5KaiawzzlBYUrKWBA-ZKteptNztQw=s900-c-k-c0x00ffffff-no-rj"
                     alt="" style="width:90%;height: 180px;border-radius: 5%">
                <p style="text-align: center; color: white;padding: 10px" ;>SooBin</p>
                <p style="text-align: center; color: white"></p>
            </div>
            <div class="col-3"
                 style="text-align: center; border-radius: 5%;border: 5px solid #170f24 ;background-color: #170f24;padding: 10px;">
                <img src="https://spartabeerclub.vn/media/images/article/507/nu-ca-si-min.jpg" alt=""
                     style="width:90%;height: 180px;border-radius: 5%">
                <p style="text-align: center; color: white;padding: 10px" ;>Min</p>
                <p style="text-align: center; color: white"></p>
            </div>
            <div class="col-3"
                 style="text-align: center; border-radius: 5%;border: 5px solid #170f24 ;background-color: #170f24;padding: 10px;">
                <img src="https://znews-photo.zingcdn.me/w660/Uploaded/wyhktpu/2022_02_07/thumb.jpg" alt=""
                     style="width:90%;height: 180px;border-radius: 5%">
                <p style="text-align: center; color: white;padding: 10px" ;>Erik</p>
                <p style="text-align: center; color: white"></p>
            </div>
        </div>
    </div>
</div>
<%--body end--%>
<div class="row">
    <div class="col-12">
        <footer class="text-center text-white" style="background-color: #170f24;">
            <!-- Grid container -->
            <div class="container pt-4">
                <!-- Section: Social media -->
                <section>
                    <div class="container">
                        <i class="fa fa-apple" id="apple"></i>
                        <i class="fa fa-twitter" id="twitter"></i>
                        <i class="fa fa-github-square github" id="github"></i>
                        <i class="fa fa-facebook-square" id="facebook"></i>
                    </div>
                </section>
                <!-- Section: Social media -->
            </div>
            <!-- Grid container -->

            <!-- Copyright -->
            <div class="text-center text-white p-3" style="background-color: #170f24;">
                © 2020 Copyright:
                <a class="text-white" href="">Privatemusic.com</a>
            </div>
            <!-- Copyright -->
        </footer>
    </div>
</div>

</body>
</html>
