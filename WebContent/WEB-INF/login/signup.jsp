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
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
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
          <!-- <a class="d-block small" href="forgot-password.html">Forgot Password?</a> -->
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