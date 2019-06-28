<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" type="text/css" href="css/form.css">
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