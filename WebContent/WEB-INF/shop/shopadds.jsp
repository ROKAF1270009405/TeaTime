<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Teatime</title>

  <!-- Custom fonts for this template-->
  <link href="css/all2.min.css" rel="stylesheet" type="text/css">

  <!-- Custom styles for this template-->
  <link href="css/sb-admin.css" rel="stylesheet">
<style>
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
  /* background-color: #f8f8f8; */
  font-size: 16px;
  resize: none;
}
</style>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script>
function add_item(){
	// pre_set 에 있는 내용을 읽어와서 처리..
	var div = document.createElement('div');
	div.innerHTML = document.getElementById('pre_set').innerHTML;
	$('pre_set')
	document.getElementById('field').appendChild(div);
}

function remove_item(obj){
	// obj.parentNode 를 이용하여 삭제
	$('field').removeChild(obj.parentNode);
	//document.getElementById('field').removeChild(obj.parentNode);
}
</script>
<body>
<div id="shop">
<h3>매장 등록</h3>
  <form method="post" action="shopadd.do">
  	<div class="form-label-group">
  	  <input type="text" id="name" name="name" class="form-control" placeholder="매장 이름을 적어주세요.">
  	  <label for="name">매장 이름</label>
	</div>
	
	<label for="content">매장 소개</label>
	<textarea id="content" name="content" placeholder="매장 소개 해주세요."></textarea>
	
	<div class="form-label-group">
    	<input type="text" id="addr" name="addr" placeholder="매장 주소를 입력해주세요.">
    	<label for="addr">매장 주소</label>
	</div>
	
	<label for="workingtime">영업 시작 시간 </label>
    <input type="time" id="starttime" name="starttime" >
    
    <label for="workingtime"> 종료 시간</label>
    <input type="time" id="endtime" name="endtime" >
    
    <label for="menuname">메뉴</label>
    <div id="pre_set" style="display:none">
		<input type="text" name="menuname" value="" style="width:200px"> <input type="button" value="삭제" onclick="remove_item(this)">
	</div>
    <div id="field"></div>
    <input type="button" value=" 추가 " onclick="add_item()">
    <input type="submit" value="등록">
  </form>
</div>
  <!-- Bootstrap core JavaScript-->
  <script src="jquery/jquery.min.js"></script>
  <script src="jquery/bootstrap.bundle.min.js"></script>

  <!-- Core plugin JavaScript-->
  <script src="jquery/jquery.easing.min.js"></script>
</body>
</html>