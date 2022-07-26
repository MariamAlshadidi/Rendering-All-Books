<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
  </head>
  <body>
	<div class="container">
	    <form action="#" th:action="@{/greeting}" th:object="${greeting}" method="post"></form>
		<table class="table">
		  <thead>
		    <tr>
		      <th scope="col">Title</th>
		      <th scope="col">Language</th>
		      <th scope="col">Pages</th>
		    </tr>
		  </thead>
		  <tbody>
		  <c:forEach items="${books}" var="bookElement">
		  	<tr>
		  		<td><a href='/books/<c:out value="${bookElement.getId()}"/>' >
				<c:out value="${bookElement.getTitle()}"/></a></td>
		  		<td><c:out value="${bookElement.getLanguage()}"/></td>
		  		<td><c:out value="${bookElement.getNumberOfPages()}"/></td>
		  	</tr>
		  </c:forEach>
		  </tbody>
		</table>
	</form>
	</div>
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
  </body>
</html>