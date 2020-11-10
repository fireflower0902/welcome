<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 인코딩 설정할때는 UTF-8을 쓴다 최근에 많이 쓰이는 한글/영어 모두 지원하는 인코딩 언어임. -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width", initial-scale="1">
<!-- 부트스트랩은 핸드폰/컴퓨터 어떤 것으로 접속하든 그에 맞게 반응하는 템플릿  -->
<link rel="stylesheet" href="css/bootstrap.css"><!--디자인을 담당할 ccs -->
<title>JSB 게시판 웹 사이트</title>
</head>
<body>
<!--내비게이션: 하나의 웹사이트에 전반적인 구성을 보여주는 역할 -->
	<nav class="navbar navbar-default">
		<div class="navbar-header">
			 <button type="button" class="navbar-toggle collapsed"
			 data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
			 aria-expanded="false">
			 <span class="icon-bar"></span>
			 <span class="icon-bar"></span>
			 <span class="icon-bar"></span>
			 </button>
			 <a class="navbar-brand" href="main.jsp">JSP 게시판 웹 사이트</a>
		</div>
		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li><a href="main.jsp">메인</a></li>
				<li><a href="bbs.jsp">게시판</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown">
					<a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
					    aria-expanded="false">접속하기<span class="caret"></span></a>
					    
					<ul class="dropdown-menu">
						<li class="active"><a href="login.jsp">로그인</a></li>
						<li><a href="join.jsp">회원가입</a></li>
					</ul>
				</li>
			</ul>
		</div>
	</nav>
	<div class="container">
		<div class="col-lg-4"></div>
		<div class="col-lg-4">
			<div class="jumbotron" style="padding-top: 20px;">
				<form method="post" action="loginAction.jsp">
					<h3 style="text-align: center;">로그인 화면</h3>
					<div class="form-group">
						<input type="text" class="form-control" placeholder="아이디" name="userID" maxlength="20">
					</div>
					<div class="form-group">
						<input type="password" class="form-control" placeholder="비밀번호" name="userPassword" maxlength="20">
					</div>
					<input type="submit" class="btn btn-primary form-control" value="로그인">
				</form>
			</div>
		</div>
		<div class="col-lg-4"></div>
	</div>
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<!-- 애니메이션을 담당하게 될 자바스크립트 참조, jquery를 특정한 홈페이지에서 가져올수있도록하고-->
	<script src="js/bootstrap.js"></script>
</body>
</html> 
<!--홈페이지를 만들때는 디자인을 먼저 입히고, 기능을 구현하는 경우가 많다.
이때, 디자인을 좀더빠르게 해서 디자인 프레임 워크인 부트스트랩을 사용 getbootstrap.com -->