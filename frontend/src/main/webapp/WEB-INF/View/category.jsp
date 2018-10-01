<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@include file="Header.jsp" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>	
<h2 align="center">Add Category</h2>
<div class="container">
<spring:form action="${pageContext.request.contextPath}/addCategory" modelAttribute="cat" method="post" >

<div class="form-group">
<c:if test="${not empty cat.categoryName}">
<label for=cid>Category ID:</label>
<spring:input type="text" id="cid" class="form-control" path="categoryId" readonly="true" disabled="true"/>
<spring:hidden path="categoryId"/>
</c:if>
</div>
<div class="form-group">
<label for=cname>Category Name:</label>
<spring:input type="text"  id="cname" class="form-control" path="categoryName"/>
</div>

<div class="form-group">
<label for=cdes>Category Description:</label>
<spring:input type="text" path="categoryDescription"  id="cdes" class="form-control"/><br>
</div>
<c:if test="${empty cat.categoryName }">
<input type="submit" value="Add"/></c:if>
<c:if test="${not empty cat.categoryName}">
<input type="submit" value="Update">
</c:if>
 </spring:form>
<c:if test="${not empty categoryList}">


<table border="table table-hover">
<thead>
<tr><th>categoryId</th>
<th>categoryName</th>
<th>categoryDescription</th>
<th>Edit</th>
<th>delete</th>
</tr>
</thead>
<c:forEach items="${categoryList}" var="cate">
<tbody>
<tr>
<td>${cate.categoryId}</td>
<td>${cate.categoryName}</td>
<td>${cate.categoryDescription} </td>
<td><a href="<c:out value="editCategory/${cate.categoryId}"></c:out>">edit</a>
<td><a href="<c:out value="deleteCategory/${cate.categoryId}"></c:out>">delete</a>
</tr>
</tbody>
</c:forEach>
</table>
</c:if>
</div>

</body>
</html>