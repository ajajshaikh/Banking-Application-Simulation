<!DOCTYPE html >
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Expires" content="sat, 01 Dec 2001 00:00:00 GMT">
<title>Bank Application | home</title>
<link href="static/css/bootstrap.min.css" rel="stylesheet">
<link href="static/css/style.css" rel="stylesheet">
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>
<body>
	<div role="navigation">
		<div class="navbar navbar-inverse">
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="/firstproject/">GO BACK</a></li>
				</ul>
			</div>
		</div>
	</div>
	<c:choose>
	<c:when test="${mode=='MODE_A'}">
	<div class="container text-center" id="tasksDiv">
		<h3>All Transactions</h3>
		<hr>
		<div class="table-responsive">
		<table class="table table-striped table-bordered">
		<thead>
		<tr>
			<th>rusername</th>
			<th>sendername</th>
			<th>amount</th>
		</tr>
		</thead>
			<tbody>
			<c:forEach var="transaction" items="${idtransactions}">
			<tr>
			<td>${transaction.rusername}</td>
			<td>${transaction.sendername}</td>
			<td>${transaction.amount}</td>
			</tr>
			</c:forEach>
			</tbody>
			</table>
			</div>
			</div>
	</c:when>
	</c:choose>
	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="static/js/jquery-1.11.1.min.js"></script>
	<script src="static/js/bootstrap.min.js"></script>
</body>
</html>