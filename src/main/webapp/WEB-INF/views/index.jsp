<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>System Process Monitor</title>
	<link href="/resources/css/bootstrap.min.css" rel="stylesheet" type="text/css">
</head>
<body>
	<nav class="navbar navbar-default" role="navigation">
        <div class="navbar-header">
            <a class="navbar-brand" href="">System Process Monitor</a>
        </div>
    </nav>

	<div class="container">
		<h3>Currently running:</h3>
		<table class="table">
		<thead>
			<tr>
				<td>PID</td>
				<td>USER</td>
				<td>CPU</td>
				<td>MEM</td>
				<td>VSZ</td>
				<td>RSS</td>
				<td>TTY</td>
				<td>STAT</td>
				<td>START</td>
				<td>TIME</td>
				<td>COMMAND</td>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${list}" var="item">
			<tr>
			 <td><c:out value="${item.pid}" /></td>
			 <td><c:out value="${item.user}" /></td>
			 <td><c:out value="${item.cpu}" /></td>
			 <td><c:out value="${item.mem}" /></td>
			 <td><c:out value="${item.vsz}" /></td>
			 <td><c:out value="${item.rss}" /></td>
			 <td><c:out value="${item.tty}" /></td>
			 <td><c:out value="${item.stat}" /></td>
			 <td><c:out value="${item.start}" /></td>
			 <td><c:out value="${item.time}" /></td>
			 <td><c:out value="${item.command}" /></td>
			</tr>
		  </c:forEach>
		  </tbody>
		</table>
	</div>
</body>
</html>