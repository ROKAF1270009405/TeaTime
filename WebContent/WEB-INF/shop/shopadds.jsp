<%@page import="java.io.File"%>
<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
img {
	width: 100px;
	height: auto;
}
img:hover {
	cursor: pointer;
}
.img_wrap{
width:300px;
margin-top: 50px;
}
.img_wrap img{
	max-width:100%; 
}
#fileName1{
	display: none;
}
#imgs{
	display: inline-block;
}
</style>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script>
function add_item(){
    var div = document.createElement('div');
    div.innerHTML = document.getElementById('pre_set').innerHTML;
    document.getElementById('field').appendChild(div);
}
function remove_item(obj){
    document.getElementById('field').removeChild(obj.parentNode);
}
var count = 1;
function change1(value){
     /* $(value).next().attr("src","reviewimg/a.jpg"); */
     if(value.files && value.files[0]){
        $clone = $(".file1:first").clone().appendTo('#file');
        console.log('ok');
        let id = 'test' + count;
        console.log($(value).attr('id'));
        let b = $(value).attr('id');
        $(value).attr('id','test' + count);
        console.log($(value).attr('id'));
        $(value).parent().attr("for", 'test'+count);
        $clone.find('input').attr('name','test' + count);
        
           var reader = new FileReader();
           let a = $(value).attr('id');
           console.log(a+ "ggggg");
           let v = count-1;
           console.log(count-1);
           let vv = 'test'+v;
           console.log(b+"aaaaa");
           reader.onload=function(e){
              console.log("====================");
              $('#'+b).parent().off();
              console.log($('#'+b).parent());
              $('#'+b).off();
              console.log($('#'+b));
              $('#'+b).next().off();
              console.log($('#'+b).next());
              $("#"+b).next().attr('src', e.target.result);
              e.preventDefault();
              console.log(e);
              $("#"+b).on('click', function(val){
                //console.log($(val).clear());
                console.log($(this).next().remove());
                $(this).remove();
                console.log("==1=1=1=1=1=1=1=11122222111");
                return false;
              });
              $(id).next().attr('src', e.target.result); 
              }
           /* value.files[0].select().clear(); */
           reader.readAsDataURL(value.files[0]);
           $(value).val("");
           count++;
     }
}
 function previewImage(targetObj, View_area) {
	var preview = document.getElementById(View_area); //div id
	var ua = window.navigator.userAgent;
  //ie일때(IE8 이하에서만 작동)
	if (ua.indexOf("MSIE") > -1) {
		targetObj.select();
		try {
			var src = document.selection.createRange().text; // get file full path(IE9, IE10에서 사용 불가)
			var ie_preview_error = document.getElementById("ie_preview_error_" + View_area);


			if (ie_preview_error) {
				preview.removeChild(ie_preview_error); //error가 있으면 delete
			}

			var img = document.getElementById(View_area); //이미지가 뿌려질 곳

			//이미지 로딩, sizingMethod는 div에 맞춰서 사이즈를 자동조절 하는 역할
			img.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(src='"+src+"', sizingMethod='scale')";
		} catch (e) {
			if (!document.getElementById("ie_preview_error_" + View_area)) {
				var info = document.createElement("<p>");
				info.id = "ie_preview_error_" + View_area;
				info.innerHTML = e.name;
				preview.insertBefore(info, null);
			}
		}
  //ie가 아닐때(크롬, 사파리, FF)
	} else {
		var files = targetObj.files;
		for ( var i = 0; i < files.length; i++) {
			var file = files[i];
			var imageType = /image.*/; //이미지 파일일경우만.. 뿌려준다.
			if (!file.type.match(imageType))
				continue;
			var prevImg = document.getElementById("prev_" + View_area); //이전에 미리보기가 있다면 삭제
			if (prevImg) {
				preview.removeChild(prevImg);
			}
			var img = document.createElement("img"); 
			img.id = "prev_" + View_area;
			img.classList.add("obj");
			img.file = file;
			img.style.width = '100px'; 
			img.style.height = '100px';
			preview.appendChild(img);
			if (window.FileReader) { // FireFox, Chrome, Opera 확인.
				var reader = new FileReader();
				reader.onloadend = (function(aImg) {
					return function(e) {
						aImg.src = e.target.result;
					};
				})(img);
				reader.readAsDataURL(file);
			} else { // safari is not supported FileReader
				//alert('not supported FileReader');
				if (!document.getElementById("sfr_preview_error_"
						+ View_area)) {
					var info = document.createElement("p");
					info.id = "sfr_preview_error_" + View_area;
					info.innerHTML = "not supported FileReader";
					preview.insertBefore(info, null);
				}
			}
		}
	}
} 

</script>
<body>
<div id="shop">
<h3>매장 등록</h3>

  <form method="post" action="shopadds.do">
  	<div class="form-label-group">
  	  <input type="text" id="name" name="name" class="form-control" placeholder="매장 이름을 적어주세요." autofocus required>
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
	<textarea id="content" name="content" placeholder="매장 소개 해주세요." required></textarea>
	
	<div class="form-label-group">
    	<input type="text" id="addr" name="addr" placeholder="매장 주소를 입력해주세요." required>
    	<label for="addr">매장 주소</label>
	</div>
	
	<label for="starttime">영업 시작 시간 </label>
    <input type="time" id="starttime" name="starttime" >
    
    <label for="endtime"> 종료 시간</label>
    <input type="time" id="endtime" name="endtime" ><br>
    <label for="fileName1">매장 사진</label><br>
    
    <!-- <div id="imgs"> -->
    <!-- <input type="file" name="fileName1" id="fileName1"> -->
    <div id="file">
	    	<label>
		    	<input type="file" name="fileName1" id="fileName1" onchange="previewImage(this,'View_area')">
				<img src="reviewimg/addimage.png">
			</label>
		</div>
		<div id='View_area' style='position:relative; width: 100px; height: 100px; color: black; border: 0px solid black; dispaly: inline; '></div>
	</div>
    
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