<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <title>Teatime</title>
  <!-- Custom fonts for this template-->
  <link href="css/all2.min.css" rel="stylesheet" type="text/css">

  <!-- Custom styles for this template-->
  <link href="css/sb-admin.css" rel="stylesheet">
<style>
@import url(https://fonts.googleapis.com/css?family=BenchNine:700);
label{
	text-align: left;
}
input[type=text], select {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}
input[type=time]{
  padding: 8px 16px;
  margin:8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

input[type=submit] {
  width: 100%;
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type=submit]:hover {
  background-color: #45a049;
}
#starttime{
	margin-right: 10px;
}
#shop {
margin:0 auto;
width:80%;
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}

textarea {
  width: 100%;
  height: 150px;
  padding: 12px 20px;
  box-sizing: border-box;
  border: 2px solid #ccc;
  border-radius: 4px;
  font-size: 16px;
  resize: none;
}
#mn{
	display: inline-block;
	position: relative;
	left:0%;
}
#pr{
	display: inline-block;
	position: relative;
	margin-left: 10px;
}
.delbtn {
  background-color: #007bff;
  border-radius:15%;
  border: none;
  color: #ffffff;
  cursor: pointer;
  /* display: inline-block; */
  font-family: 'BenchNine', Arial, sans-serif;
  font-size: 20px;
  line-height: 1em;
  margin-left: 10px;
  outline: none;
  padding: 10px 15px 10px;
  position: relative;
  text-transform: uppercase;
  font-weight: 700;
  top:-9px;
}
.delbtn:before, .delbtn:after {
  border-color: transparent;
  -webkit-transition: all 0.25s;
  transition: all 0.25s;
  border-style: solid;
  border-width: 0;
  content: "";
  height: 12px;
  position: absolute;
  width: 12px;
}

.delbtn:before {
  border-color: #007bff;
  border-right-width: 2px;
  border-top-width: 2px;
  right: -5px;
  top: -5px;
}
.delbtn:after {
  border-bottom-width: 2px;
  border-color: #007bff;
  border-left-width: 2px;
  bottom: -5px;
  left: -5px;
}
.delbtn:hover,
.delbtn.hover {
  background-color: #4CAF50;
}
.delbtn:hover:before,
.delbtn.hover:before,
.delbtn:hover:after,
.delbtn.hover:after {
  border-color:#4CAF50;
  height: 100%;
  width: 100%;
}
.checks {position: relative;}

.checks input[type="checkbox"] {  /* 실제 체크박스는 화면에서 숨김 */
  position: absolute;
  width: 1px;
  height: 1px;
  padding: 0;
  margin: -1px;
  overflow: hidden;
  clip:rect(0,0,0,0);
  border: 0
}
.checks input[type="checkbox"] + label {
  display: inline-block;
  position: relative;
  cursor: pointer;
  -webkit-user-select: none;
  -moz-user-select: none;
  -ms-user-select: none;
}
.checks input[type="checkbox"] + label:before {  /* 가짜 체크박스 */
  content: ' ';
  display: inline-block;
  width: 21px;  /* 체크박스의 너비를 지정 */
  height: 21px;  /* 체크박스의 높이를 지정 */
  line-height: 21px; /* 세로정렬을 위해 높이값과 일치 */
  margin: -2px 8px 0 0;
  text-align: center; 
  vertical-align: middle;
  background: #fafafa;
  border: 1px solid #cacece;
  border-radius : 3px;
  box-shadow: 0px 1px 2px rgba(0,0,0,0.05), inset 0px -15px 10px -12px rgba(0,0,0,0.05);
}
.checks input[type="checkbox"] + label:active:before,
.checks input[type="checkbox"]:checked + label:active:before {
  box-shadow: 0 1px 2px rgba(0,0,0,0.05), inset 0px 1px 3px rgba(0,0,0,0.1);
}

.checks input[type="checkbox"]:checked + label:before {  /* 체크박스를 체크했을때 */ 
  content: '\2714';  /* 체크표시 유니코드 사용 */
  color: #99a1a7;
  text-shadow: 1px 1px #fff;
  background: #e9ecee;
  border-color: #adb8c0;
  box-shadow: 0px 1px 2px rgba(0,0,0,0.05), inset 0px -15px 10px -12px rgba(0,0,0,0.05), inset 15px 10px -12px rgba(255,255,255,0.1);
}

.checks.small input[type="checkbox"] + label {
  font-size: 12px;
}

.checks.small input[type="checkbox"] + label:before {
  width: 17px;
  height: 17px;
  line-height: 17px;
  font-size: 11px;
}

.checks.etrans input[type="checkbox"] + label {
  padding-left: 30px;
}
.checks.etrans input[type="checkbox"] + label:before {
  position: absolute;
  left: 0;
  top: 0;
  margin-top: 0;
  opacity: .6;
  box-shadow: none;
  border-color: #6cc0e5;
  -webkit-transition: all .12s, border-color .08s;
  transition: all .12s, border-color .08s;
}

.checks.etrans input[type="checkbox"]:checked + label:before {
  position: absolute;
  content: "";
  width: 10px;
  top: -5px;
  left: 5px;
  border-radius: 0;
  opacity:1; 
  background: transparent;
  border-color:transparent #6cc0e5 #6cc0e5 transparent;
  border-top-color:transparent;
  border-left-color:transparent;
  -ms-transform:rotate(45deg);
  -webkit-transform:rotate(45deg);
  transform:rotate(45deg);
}
.cbox{
	margin-left: 10px;
}
.dbtn{
	top:1px;
}
.no-csstransforms .checks.etrans input[type="checkbox"]:checked + label:before {
  /*content:"\2713";*/
  content: "\2714";
  top: 0;
  left: 0;
  width: 21px;
  line-height: 21px;
  color: #6cc0e5;
  text-align: center;
  border: 1px solid #6cc0e5;
}

</style>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script>
/* $(document).ready(function(){
$(".hover").mouseleave(
		  function() {
		    $(this).removeClass("hover");
		  }
		);
}); */
function add_item(){
    var div = document.createElement('div');
    div.innerHTML = document.getElementById('pre_set').innerHTML;
    document.getElementById('field').appendChild(div);
}

function remove_item(obj){
    document.getElementById('field').removeChild(obj.parentNode);
}
</script>
<body>
<div id="shop">
<h3>매장 등록</h3>
  <form method="post" action="shopadds.do">
  	<div class="form-label-group">
  	  <input type="text" id="name" name="name" class="form-control" placeholder="매장 이름을 적어주세요.">
  	  <label for="name">매장 이름</label>
	</div>
	<h5>음식 종류</h5>
    <div class="checks etrans">
  		<input type="checkbox" id="korean" name="korean" value="한식"> 
  		<label for="korean" class="cbox">한식</label> 
  		
  		<input type="checkbox" id="japanese" name="japanese" value="일식"> 
  		<label for="japanese" class="cbox">일식</label>
  		 
  		<input type="checkbox" id="chinese" name="chinese" value="중식"> 
  		<label for="chinese" class="cbox">중식</label> 
  		
  		<input type="checkbox" id="yangsig" name="yangsig" value="양식"> 
  		<label for="yangsig" class="cbox">양식</label>
  	
	</div>
	<label for="content">매장 소개</label>
	<textarea id="content" name="content" placeholder="매장 소개 해주세요."></textarea>
	
	<div class="form-label-group">
    	<input type="text" id="addr" name="addr" placeholder="매장 주소를 입력해주세요.">
    	<label for="addr">매장 주소</label>
	</div>
	
	<label for="starttime">영업 시작 시간 </label>
    <input type="time" id="starttime" name="starttime" >
    
    <label for="endtime"> 종료 시간</label>
    <input type="time" id="endtime" name="endtime" >
    
    <hr>
    <h3>메뉴</h3>
    <div id="pre_set"  style="display:none">
    <div class="form-label-group" id="mn">
		<input type="text" name="menuname" value="" style="width:200px">
		<label for="menuname">메뉴이름</label>
	</div>	
	<div class="form-label-group" id="pr">
		<input type="text" name="price" value="" style="width:100px"> 
		<label for="menuname">가격</label>
	</div>
		<input  class="delbtn" type="button" onclick="remove_item(this)" value="삭제">
    	<!-- <button class="delbtn" onclick="remove_item(this)">삭제</button> -->
	</div>
    <div id="field"></div>
    <input type="button" value="메뉴 추가 " class="delbtn dbtn" onclick="add_item()">
    <input type="submit" value="등록">
    <!-- <button class="delbtn" >등록</button> -->
  </form>
</div>
</body>
</html>