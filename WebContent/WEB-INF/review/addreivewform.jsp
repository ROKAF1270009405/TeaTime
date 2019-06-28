<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
button {
	background-color: white;
	border-style: none;
}

@import url(https://fonts.googleapis.com/css?family=BenchNine:700);

label {
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

input[type=time] {
	padding: 8px 16px;
	margin: 8px 0;
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
	margin: 0 auto;
	width: 80%;
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

#mn {
	display: inline-block;
	position: relative;
	left: 0%;
}

#pr {
	display: inline-block;
	position: relative;
	margin-left: 10px;
}

.delbtn {
	background-color: #007bff;
	border-radius: 15%;
	border: none;
	color: #ffffff;
	cursor: pointer;
	display: inline-block;
	font-family: 'BenchNine', Arial, sans-serif;
	font-size: 20px;
	line-height: 1em;
	margin-left: 10px;
	outline: none;
	padding: 10px 15px 10px;
	position: relative;
	text-transform: uppercase;
	font-weight: 700;
	top: -9px;
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

.delbtn:hover, .delbtn.hover {
	background-color: #4CAF50;
}

.delbtn:hover:before, .delbtn.hover:before, .delbtn:hover:after, .delbtn.hover:after
	{
	border-color: #4CAF50;
	height: 100%;
	width: 100%;
}

.checks {
	position: relative;
}

.checks input[type="checkbox"] { /* 실제 체크박스는 화면에서 숨김 */
	position: absolute;
	width: 1px;
	height: 1px;
	padding: 0;
	margin: -1px;
	overflow: hidden;
	clip: rect(0, 0, 0, 0);
	border: 0
}

.checks input[type="checkbox"]+label {
	display: inline-block;
	position: relative;
	cursor: pointer;
	-webkit-user-select: none;
	-moz-user-select: none;
	-ms-user-select: none;
}

.checks input[type="checkbox"]+label:before { /* 가짜 체크박스 */
	content: ' ';
	display: inline-block;
	width: 21px; /* 체크박스의 너비를 지정 */
	height: 21px; /* 체크박스의 높이를 지정 */
	line-height: 21px; /* 세로정렬을 위해 높이값과 일치 */
	margin: -2px 8px 0 0;
	text-align: center;
	vertical-align: middle;
	background: #fafafa;
	border: 1px solid #cacece;
	border-radius: 3px;
	box-shadow: 0px 1px 2px rgba(0, 0, 0, 0.05), inset 0px -15px 10px -12px
		rgba(0, 0, 0, 0.05);
}

.checks input[type="checkbox"]+label:active:before, .checks input[type="checkbox"]:checked+label:active:before
	{
	box-shadow: 0 1px 2px rgba(0, 0, 0, 0.05), inset 0px 1px 3px
		rgba(0, 0, 0, 0.1);
}

.checks input[type="checkbox"]:checked+label:before { /* 체크박스를 체크했을때 */
	content: '\2714'; /* 체크표시 유니코드 사용 */
	color: #99a1a7;
	text-shadow: 1px 1px #fff;
	background: #e9ecee;
	border-color: #adb8c0;
	box-shadow: 0px 1px 2px rgba(0, 0, 0, 0.05), inset 0px -15px 10px -12px
		rgba(0, 0, 0, 0.05), inset 15px 10px -12px rgba(255, 255, 255, 0.1);
}

.checks.small input[type="checkbox"]+label {
	font-size: 12px;
}

.checks.small input[type="checkbox"]+label:before {
	width: 17px;
	height: 17px;
	line-height: 17px;
	font-size: 11px;
}

.checks.etrans input[type="checkbox"]+label {
	padding-left: 30px;
}

.checks.etrans input[type="checkbox"]+label:before {
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

.checks.etrans input[type="checkbox"]:checked+label:before {
	position: absolute;
	content: "";
	width: 10px;
	top: -5px;
	left: 5px;
	border-radius: 0;
	opacity: 1;
	background: transparent;
	border-color: transparent #6cc0e5 #6cc0e5 transparent;
	border-top-color: transparent;
	border-left-color: transparent;
	-ms-transform: rotate(45deg);
	-webkit-transform: rotate(45deg);
	transform: rotate(45deg);
}

.no-csstransforms .checks.etrans input[type="checkbox"]:checked+label:before
	{
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

input[type='file'] {
	display: none;
}

#shop ul{
list-style-type: none;

}

#shop ul li{
}



</style>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script>


</script>
</head>
<body>
	<jsp:useBean id="today" class="java.util.Date" />
	<fmt:formatDate var="now" value="${today }" pattern="yyyyMMdd" />
	<div id="shop">
		<form method="post" action="addreviewresult.do"
			enctype="multipart/form-data">
			<h2>${param.name }</h2>
			<ul>
				<li class="form-label-group"><label for="date"><input name="date"
						value="${now }" disabled class="form-control"></label></li>
				
				<li class="form-label-group"><label>
				<input type="hidden" name="shopno" value="${param.shopno }" /></label></li>
				<li class="form-label-group"><label>
				
				<li><label for="content"> <textarea rows="10"
							cols="30" placeholder="리뷰를 입력해주세요." name="content"></textarea>
				</label>   
				<li>
					<button type="button" class="gpa">
						<img src="reviewimg/happy.png" id="happy" name="" onclick=change('happy') alt="best">
					</button>
					<button type="button" class="gpa">
						<img src="reviewimg/surprised.png" id="surprised" name=""	onclick=change('surprised') alt="soso">
					</button>
					<button type="button" class="gpa">
						<img src="reviewimg/sad.png" id="sad" name="" onclick=change('sad') alt="worst">
					</button> <input id="gpa" name="gpa" type="hidden">
				</li>

				<li id="file"><label class="file1"> <label for="test0"	class="uploadlabel1"> 
				<input id="test0" type="file" name="board_file" onchange="change1(this)"> 
							<img src="reviewimg/addimage.png">
					</label>
					
				</label></li>

				<li><input type="submit" value="완료"> 	</li>

			</ul>
		</form>
	</div>

	<script type="text/javascript">
	$('#test1').on("change", function(){
		console.log(this);
		LoadImgtest(this);
		
		
	});
   function change(id){
      var img1 = document.getElementById("happy");
      var img2 = document.getElementById("surprised");
      var img3 = document.getElementById("sad");
      img1.src = "<%=request.getContextPath()%>/reviewimg/happy.png";
      img2.src = "<%=request.getContextPath()%>/reviewimg/surprised.png";
      img3.src = "<%=request.getContextPath()%>/reviewimg/sad.png";
      var gpa = document.getElementById("gpa");
      
      var img = document.getElementById(id);
      var u1 = "<%=request.getContextPath()%>/reviewimg/";
      var uu = u1.concat(id,"ck.png");
      console.log(uu);
      img.src = uu;
      img.name="gpa";
      gpa.value=id;
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
   
   </script>
</body>
</html>