<%@page import="java.util.ArrayList"%>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.net.URL" %>
<%@ page import="java.net.HttpURLConnection" %>
<%@ page import="java.io.BufferedReader" %>
<%@ page import="java.io.InputStreamReader" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>네이버로그인</title>
    <script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js" charset="utf-8"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
  </head>
  <body>
  
  
  <a href="teatime.do" > 로그인 성공!</a>
  <script type="text/javascript">
  var naver_id_login = new naver_id_login("6rXHgI2ZoOW_8CoLjVmW", "http://localhost:8080/MiniPro2/naverlogin.do&svctype=0");
  // 접근 토큰 값 출력
  //alert(naver_id_login.oauthParams.access_token);
  // 네이버 사용자 프로필 조회
  naver_id_login.get_naver_userprofile("naverSignInCallback()");
  // 네이버 사용자 프로필 조회 이후 프로필 정보를 처리할 callback function
  function naverSignInCallback() {
	let id = naver_id_login.getProfileData('id');
	let email = naver_id_login.getProfileData('email');
	let nickname = naver_id_login.getProfileData('nickname');
	
	// 로그인 -> 아이디 체크 -> 없으면 가입 및 로그인 or 있으면 로그인
	
	/* location.href = "logincheck.do?id=" +id + "&pwd=0" + "&naverid=1"; // 아이디 패스워드가 맞으면 로그인 및 세션 저장, 틀리면 로그인 페이지 */
	location.href = "signupresult.do?id=" + id + "&email=" + email + "&nickname=" + nickname + "&pwd=0" + "&confirmPassword=0" +"&naverid=1" ; // 이미 가입 되어 있으면, 회원가입 폼으로
	
	opener.location.href="logincheck.do?id=" +id + "&pwd=0";
	window.close();
  }
</script>

  
  </body>
</html>