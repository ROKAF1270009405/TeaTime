<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
</head>
<body>
	<div class="container">
		<section class="main">
			<form class="form-5 clearfix">
				<p>
					<input type="text" id="id" name="id" placeholder="Username">
					<input type="password" name="pwd" id="pwd" placeholder="Password">
				</p>
				<button type="submit" name="submit">
					<i class="icon-arrow-right"></i> <span>로그인</span>
				</button>
			</form>
		</section>

	</div>
	<!-- jQuery if needed -->
	<script type="text/javascript"
		src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
	<script type="text/javascript" src="jquery/jquery.placeholder.min.js"></script>
	<!-- <script type="text/javascript">
		$(function() {
			$('input, textarea').placeholder();
		});
	</script> -->
</body>
</html>