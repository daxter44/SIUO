<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
<a href="<c:url value="/j_spring_security_logout" />" class="btn btn-danger btn-mini pull-right">Wyloguj się</a>
<div class="container">
<h1>Zadania</h1>
<p>Dodawanie Zadania</p>
</div>
</div>
</section>
<section class="container">
<form:form modelAttribute="newExercise" class="form-horizontal">
<form:errors path="*" cssClass="alert alert-danger" element="div" />
<fieldset>
<legend>Dodaj nowe zadanie </legend>
<div class="form-group">
<label class="control-label col-lg-2 col-lg-2" for="exerciseId"><spring:message code="addExercise.form.exerciseId.label"/></label>
<div class="col-lg-10">
<form:input id="exerciseId" path="exerciseId" type="text" class="form:input-large"/>
<form:errors path="exerciseId" cssClass="text-danger"/>
</div>
</div>
<div class="form-group">
<label class="control-label col-lg-2 col-lg-2" for="name"><spring:message code="addExercise.form.name.label"/></label>
<div class="col-lg-10">
<form:input id="name" path="name" type="text" class="form:input-large"/>
<form:errors path="name" cssClass="text-danger"/>
</div>
</div>
<div class="form-group">
<label class="control-label col-lg-2 col-lg-2" for="language">Język</label>
<div class="col-lg-10">
<form:input id="language" path="language" type="text" class="form:input-large"/>
</div>
</div>
<div class="form-group">
<label class="control-label col-lg-2 col-lg-2" for="course"><spring:message code="addExercise.form.course.label"/></label>
<div class="col-lg-10">
<form:input id="course" path="course" type="text" class="form:input-large"/>
</div>
</div>
<div class="form-group">
<label class="control-label col-lg-2 col-lg-2" for="in"><spring:message code="addExercise.form.in.label"/></label>
<div class="col-lg-10">
<form:input id="in" path="in" type="text" class="form:input-large"/>
</div>
</div>
<div class="form-group">
<label class="control-label col-lg-2 col-lg-2" for="out"><spring:message code="addExercise.form.out.label"/></label>
<div class="col-lg-10">
<form:input id="out" path="out" type="text" class="form:input-large"/>
</div>
</div>
<div class="form-group">
<label class="control-label col-lg-2 col-lg-2" for="example">Przyklad</label>
<div class="col-lg-10">
<form:input id="example" path="example" type="text" class="form:input-large"/>
</div>
</div>
<div class="form-group">
<label class="control-label col-lg-2" for="description">Opis</label>
<div class="col-lg-10">
<form:textarea id="description" path="description" rows = "2"/>
</div>
</div>
<div class="form-group">
<div class = "col-lg-offset-2 col-lg-10">
<input type="submit" id="btnAdd" class="btn btn-primary" value="Dodaj" /> 
<a href="../exercises" class = "btn btn-info btn-large">Powrót</a>
</div> 
</div>
</fieldset>

</form:form>
</section>
</body>
</html>