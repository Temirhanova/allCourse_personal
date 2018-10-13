<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <!--[if lt IE 9]><script src="https://cdnjs.cloudflare.com/ajax/libs/html5shiv/3.7.3/html5shiv.min.js"></script><![endif]-->
    <title></title>
    <meta name="keywords" content="" />
    <meta name="description" content="" />
    <link href="/resources/style.css" rel="stylesheet">
</head>

<body>

<div class="wrapper">

    <header class="header">
        <div class="logo"></div>
        <div class="login">
            <c:if test="${login != null}">
                Вы вошли как: <c:out value="${login}"/>
                &nbsp;<a href="/index?action=logout">Выйти</a>
            </c:if>
            <c:if test="${login == null}">
                <form action="/index" method="post" title="Создать пользователя">
                <input type="login" name="login" title="Логин"/>
                <input type="password" name="password" title="Пароль"/>
                <input type="submit" name="signIn" value="Войти">
                <input type="submit" name="registration" value="Регистрация">
                <p>
                    <a href="/registration?action=forgot">Забыли пароль</a>
                </p>
            </form>
            </c:if>
        </div>
    </header><!-- .header-->

    <div class="middle">
        <ul class="main-menu">
            <li><a href="/index">Главная</a></li>
            <li><a href="#">Возможности</a></li>
            <li><a href="#">Методология</a></li>
            <li><a href="#">О нас</a></li>
        </ul>
            <div class="container">
                <main class="content">