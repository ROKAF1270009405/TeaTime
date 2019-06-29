<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Teatime Login</title>
<meta name="description" content="Custom Login Form Styling with CSS3" />
<meta name="keywords"
	content="css3, login, form, custom, input, submit, button, html5, placeholder" />
<meta name="author" content="Codrops" />
<link rel="shortcut icon" href="../favicon.ico">
<link rel="stylesheet" type="text/css" href="css/style.css" />
<script src="jquery/modernizr.custom.63321.js"></script>
<script type="text/javascript" src="https://static.nid.naver.com/js/naveridlogin_js_sdk_2.0.0.js" charset="utf-8"></script>
      <script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js" charset="utf-8"></script>
  <script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<!--[if lte IE 7]><style>.main{display:none;} .support-note .note-ie{display:block;}</style><![endif]-->
<style>
@import
	url(http://fonts.googleapis.com/css?family=Montserrat:400,700|Handlee);

body {
	background: #eedfcc url(img/bg3.jpg) no-repeat center top;
	-webkit-background-size: cover;
	-moz-background-size: cover;
	background-size: cover;
}

.container>header h1, .container>header h2 {
	color: #fff;
	text-shadow: 0 1px 1px rgba(0, 0, 0, 0.5);
}

</style>
<script type="text/javascript"
		src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
</head>
<body>
	<div class="container">
		<section class="main">
			<form class="form-5 clearfix" method="post" action="logincheck.do" name="frm">
				<p>
					<input type="text" id="id" name="id" placeholder="Username" autofocus required>
					<input type="password" name="pwd" id="pwd" placeholder="Password" required>
				</p>
				<button type="submit" name="submit">
					<i class="icon-arrow-right"></i> <span>↓</span>
				</button>
			</form>
		</section>
		<div id="naverIdLogin"></div>
	  <p class="text--center"><a href="signup.do">회원가입</a> <span class="fontawesome-arrow-right"></span></p>
	    <div id="naver_id_login"></div>
	</div>
	
	
	
	 <script type="text/javascript">
  	var naver_id_login = new naver_id_login("6rXHgI2ZoOW_8CoLjVmW", "http://localhost:8080/MiniPro2/naverlogin.do");
  	var state = naver_id_login.getUniqState();
  	naver_id_login.setButton("white", 2,40);
  	naver_id_login.setDomain("http://localhost:8080/MiniPro2/teatime.do");
  	naver_id_login.setState(state);
  	naver_id_login.setPopup();
  	naver_id_login.init_naver_id_login();
  </script>
	
	<!-- jQuery if needed -->
	<!-- <script type="text/javascript" src="jquery/jquery.placeholder.min.js"></script> -->
	<!-- <script type="text/javascript">
		$(function() {
			$('input, textarea').placeholder();
		});
	</script> -->
<!-- <script type="text/javascript">
var naver_id_login = new naver_id_login("TuceI6ryHcQLt78CA67C", "http://localhost:8080/MiniPro2/login.do");
var state = naver_id_login.getUniqState();
naver_id_login.setButton("white", 2, 40);
	naver_id_login.setDomain("http://localhost:8080/MiniPro2/login.do");	//  URL
	naver_id_login.setState(state);
	naver_id_login.setPopup();
	naver_id_login.init_naver_id_login();
var naverLogin = new naver.LoginWithNaverId(
		{
			clientId: "TuceI6ryHcQLt78CA67C",
			callbackUrl: "http://localhost:8080/MiniPro2/login.do",
			isPopup: false, /* 팝업을 통한 연동처리 여부 */
			loginButton: {color: "green", type: 3, height: 60} /* 로그인 버튼의 타입을 지정 */
		}
	);
	
	/* 설정정보를 초기화하고 연동을 준비 */
	naverLogin.init();
	
</script> -->



</body>
</html>