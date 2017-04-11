<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Zadanie</title>
</head>
<body>
<section> 
<div class="jumbotron">
<div class="container">
<h1>Zadanie</h1>
</div>
</div>
</section>
<section class="container">
<div class="row">
<div class = "col-md-5">
<h3>${exercise.name}</h3>
<p>${exercise.description}</p>
<p><strong>Wejście: </strong> ${exercise.in}</p>
<p><strong>Wyjście: </strong> ${exercise.out}</p>
<p>
<strong>Język:</strong><span class="label label-warning">${exercise.language}</span>
</p>
<p>
<strong>Nazwa przedmiotu:</strong> ${exercise.course}
</p>

<p>
<a href="../exercises/createAnswer?id=${exercise.exerciseId}" class="btn btn-info btn-large"><span class="glyphicon-save glyphicon"></span>Prześlij</a>
<a href="../exercises" class = "btn btn-info btn-large">Powrót</a>
</p>
</div>
</div>
</section>
</body>
</html>