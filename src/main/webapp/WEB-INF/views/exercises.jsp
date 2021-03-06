<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Zadania</title>
</head>
<body>
<section>
<div class="jumbotron">
<a href="../siuo/exercises/add" class="btn btn-info btn-large pull-right"><span class="glyphicon-save glyphicon"></span>Dodaj zadanie</a>
<a href="<c:url value="/j_spring_security_logout" />" class="btn btn-danger btn-mini pull-right">Wyloguj się</a>
<div class="containter">
<h1>Zadania</h1>
<p>Wszystkie zadania dostępne w naszym systemie</p>
</div>
</div>
</section>
<section class="container">
<div class="row">
<c:forEach items="${exercise}" var="exercise">
<div class="col-sm-6 col-md-3" style="padding-bottom:15px">
<div class="thumbnail">
<div class="caption">
<h3>${exercise.name}</h3>
<p>${exercise.description}</p>
<p>${exercise.language}</p>
<p><a href="<spring:url value="/exercises/exercise?id=${exercise.exerciseId}"/>" class="btn btn-primary"><span class="glyphicon-info-sign glyphicon" /></span> Szegóły</a>
</div>
</div>
</div>
</c:forEach>
</div>
</section>
</body>
</html>