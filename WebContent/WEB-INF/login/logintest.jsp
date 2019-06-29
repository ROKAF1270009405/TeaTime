<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.security.SecureRandom" %>
<%@ page import="java.math.BigInteger" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>네이버로그인</title>
      <script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js" charset="utf-8"></script>
  <script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
  </head>
 
  <body>
  
  
  
   <div id="naver_id_login"></div>
   
  <!-- //네이버아이디로로그인 버튼 노출 영역 -->
  <script type="text/javascript">
  	var naver_id_login = new naver_id_login("6rXHgI2ZoOW_8CoLjVmW", "http://localhost:8080/MiniPro2/naverlogin.do&svctype=0");
  	var state = naver_id_login.getUniqState();
  	naver_id_login.setButton("white", 2,40);
  	naver_id_login.setDomain("http://localhost:8080/MiniPro2/teatime.do");
  	naver_id_login.setState(state);
  	/* naver_id_login.setPopup(false); */
  	naver_id_login.init_naver_id_login();
  	//window.close();
  </script>
  </body>
</html>