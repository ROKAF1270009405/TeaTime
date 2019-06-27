<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Teatime Sign Up</title>

  <!-- Custom fonts for this template-->
  <link href="css/all2.min.css" rel="stylesheet" type="text/css">

  <!-- Custom styles for this template-->
  <link href="css/sb-admin.css" rel="stylesheet">
  <style>
  @import
	url(http://fonts.googleapis.com/css?family=Montserrat:400,700|Handlee);
  *{font: 400 13.3333px Arial;}
  input{
      border-bottom: 1px solid rgba(255,255,255,0.7);
      border-radius: 5px 0 0 0;
    font: 400 13.3333px Arial; 
    /* font-family: 'Montserrat', sans-serif; */
  	background: rgba(255,255,255,0.2);
  	box-shadow: inset 0 0 10px rgba(255,255,255,0.5);
  	text-shadow: 0 1px 2px rgba(0,0,0,0.3);
  }
  .form-control{
    color:#007bff;
  }
  #id{
  	/* position: absolute; */
  	top:0;
  	left:0;
  }
  #idbtn{
  	height:30px;
  	width:70px;
  	float:right;
  	/* position: relative; */
  	margin: 0 30px;
  }
  </style>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script>
$(document).ready(function(){
	let id = $('#id');
	
	$('#idbtn').on('click', function() {
		let idcheck = id.val();
		console.log(idcheck);
		let check = ""; 
		$.ajax({
			url:"http://localhost:8080/MiniPro2/DuplicateCheck.co",
			type:'GET',
			data:"idcheck="+idcheck,
			success:function(data){
				if(data==0){
					id.css('color', '#007bff');
					alert("사용 가능한 아이디 입니다.");
				} else {
					id.css('color', 'red');
					alert("중복된 아이디 입니다.");
				}
			}
		});
	});
	
	
	let check = $('#check');
	let pwd1 = $('#pwd');
	let pwd2 = $('#confirmPassword');
	
	pwd1.keyup(function(){
		check.text('');
	}); //#user_pass.keyup
	
	pwd2.keyup(function(){
		if(pwd1.val()!=pwd2.val()){
			check.text('');
			check.html("암호틀림");
			check.css('color', 'red');
			pwd1.css('color', 'red');
			pwd2.css('color', 'red');
		} else {
			check.text('');
			check.html("암호맞음");
			check.css('color', '#007bff');
			pwd1.css('color', '#007bff');
			pwd2.css('color', '#007bff');
		}
	}); //#chpass.keyup
});

</script>
</head>
<body class="bg-dark">
  <div class="container">
    <div class="card card-register mx-auto mt-5">
      <div class="card-header">회원가입</div>
           
      <div class="card-body">
        <form method="post" action="signupresult.do">
          <div class="form-group">
            <div class="form-label-group">
              <input type="text" id="id" name="id" class="form-control" placeholder="User ID" required="required">
              <label for="id">User ID</label>
                
            </div>
             <button id="idbtn">중복체크</button>
          </div>
          <div class="form-group">
            <div class="form-row">
              <div class="col-md-6">
                <div class="form-label-group">
                  <input type="password" id="pwd" name="pwd" class="form-control" placeholder="Password" required="required">
                  <label for="pwd">Password</label>
                </div>
              </div>
              <div class="col-md-6">
                <div class="form-label-group">
                  <input type="password" id="confirmPassword" name="confirmPassword" class="form-control" placeholder="Confirm password" required="required">
                  <label for="confirmPassword">Confirm password</label>
                  <font id="check" size="2" color="red"></font> 

                </div>
              </div>
            </div>
          </div>
          <div class="form-group">
            <div class="form-label-group">
              <input type="text" id="nickname" name="nickname" class="form-control" placeholder="Nick Name" required="required">
              <label for="nickname">Nick Name</label>
            </div>
          </div>
          <div class="form-group">
            <div class="form-label-group">
              <input type="email" id="email" name="email" class="form-control" placeholder="Email address" required="required">
              <label for="email">Email address</label>
            </div>
          </div>
          <button type="submit" class="btn btn-primary btn-block">회원가입</button>
        </form>
        <div class="text-center">
          <a class="d-block small mt-3" href="login.do">로그인 페이지로..</a>
        </div>
      </div>
    </div>
  </div>

  <!-- Bootstrap core JavaScript-->
  <script src="jquery/jquery.min.js"></script>
  <script src="jquery/bootstrap.bundle.min.js"></script>

  <!-- Core plugin JavaScript-->
  <script src="jquery/jquery.easing.min.js"></script>

</body>
</html>