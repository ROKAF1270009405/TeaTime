<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<style>
button {
	background-color: white;
	border-style: none;
}

img {
	width: 100px;
	height: auto;
}

img:hover {
	cursor: pointer;
}

button:hover {
	/* background-color:black; */
	/* backgound-image: url('reviewimg/happyck.png'); */
	
}

input[type='file'] {
	display: none;
}
</style>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script>


</script>
</head>
<body>
	<jsp:useBean id="today" class="java.util.Date" />
	<fmt:formatDate var="now" value="${today }" pattern="yyyyMMdd" />
	<form method="post" action="addreviewresult.do"
		enctype="multipart/form-data">
		<ul>
			<li><label for="date"><input name="date" value="${now }"
					disabled>${now }</label></li>
			<li><label for="shopname"><input name="shopname"
					value="<%=request.getParameter("name")%>" disabled></label></li>
			<li><label><input type="text" name="shopno"
					value="${requestScope.shopno }" /></label></li>
			<li><label for="id">${requestScope.id }</label></li>
			<li><label for="content">내용 <textarea rows="10"
						cols="30" placeholder="내용을 입력하세요." name="content"></textarea>
			</label>
			<li>
				<button type="button" class="gpa">
					<img src="reviewimg/happy.png" id="happy" name="" onclick=change('happy') alt="best">
				</button>
				<button type="button" class="gpa">
					<img src="reviewimg/surprised.png" id="surprised" name="" onclick=change('surprised') alt="soso">
				</button>
				<button type="button" class="gpa">
					<img src="reviewimg/sad.png" id="sad" name="" onclick=change('sad') alt="worst">
				</button> <input id="gpa" name="gpa" value="">
			</li>

			<li id="file">
					<label class="file1">
						<label for="test0" class="uploadlabel1"> <input id="test0"
							type="file" name="board_file" onchange="change1(this)"> <img
							src="reviewimg/addimage.png">
						</label>
					</label>
				</li>

			<li><input type="submit" value="완료"> <input type="reset"
				value="취소"></li>

			<li><img src="reviewuploadimg/profile.jpg">test1</li>


		</ul>
	</form>

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
  
   
   
   function removeImg(value){
      value.remove();
   }

   
   
   var count = 1;
   function change1(value){
        /* $(value).next().attr("src","reviewimg/a.jpg"); */
        if(value.files && value.files[0]){
           $(".file1:first").clone().appendTo('#file');
           console.log('ok');
           let id = 'test' + count;
           console.log($(value).attr('id'));
           let b = $(value).attr('id');
           $(value).attr('id','test' + count);
           console.log($(value).attr('id'));
           console.log($(value).parent().attr("for", 'test'+count));
           
           
           
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