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
	<c:choose>
	<c:when test="${mode=='MODE_NEWTRANSACTION'}">
	<div role="navigation">
		<div class="navbar navbar-inverse">
			<a href="/firstproject/login-user" class="navbar-brand">Home</a>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="/firstproject/transactionhistory">Transactionhistory</a></li>
					<li><a href="/firstproject/login-user/newtransaction">NewTransaction</a></li>
					<li><a href="/firstproject/balance">Balance</a></li>
				</ul>
			</div>
		</div>
	</div>
	<div class="container" id="homediv">
		<div class="jumbotron text-center">
		<h2>Welcome to Your account</h2>
		<h4>Use below form for Transaction</h4>
		<h4>Use Above Tool bar for any other activities</h4>
		</div>
	</div>
	<div class="container text-center">
		<h3>New Transaction</h3>
		<hr>
		<form class="form-horizontal" method="POST" action="/firstproject/login-user/">
		<div class="form-group">
		<label class="control-label col-md-3">tamount</label>
		<div class="col-md-7">
			<input type="text" class="form-control" name="tamount" value="${transaction.tamount }" />
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-md-3">idrecv</label>
		<div class="col-md-7">
		<input type="text" class="form-control" name="idrecv" value="${transaction.idrecv }" />
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-md-3">tstaus</label>
		<div class="col-md-7">
		<input type="text" class="form-control" name="tstaus" value="${transaction.tstaus }" />
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-md-3">idsend</label>
		<div class="col-md-3">
		<input type="text" class="form-control" name="id" value="${transaction.idsend }" />
		</div>
	</div>
	<div class="form-group ">
		<input type="submit" class="btn btn-primary" value="Completetransaction" />
		</div>
		</form>
	</div>
	</c:when>
	</c:choose> 
	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="static/js/jquery-1.11.1.min.js"></script>
	<script src="static/js/bootstrap.min.js"></script>
</body>
</html>