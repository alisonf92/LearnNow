<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
  <head>
  <meta charset = "utf-8">
 <title>My first Bootstrap project</title>
    <link href="css/bootstrap.min.css" rel="stylesheet" type = "text/css">
  </head>
  <body>
    <script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
<div class="" id="loginModal">
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
		<h3>Have an Account?</h3>
	</div>
	<div class="modal-body">
		<div class="well">
			<ul class="nav nav-tabs">
				<li class="active"><a href="#login" data-toggle="tab">Login</a></li>
				<li><a href="#create" data-toggle="tab">Create Account</a></li>
			</ul>
			<div id="myTabContent" class="tab-content">
				<div class="tab-pane active in" id="login">
					<form class="form-horizontal" action='LoginAction' method="post">
						<fieldset>
							<div id="legend">
								<legend class="">Login</legend>
							</div>    
							<div class="control-group">
							
								<label class="control-label"  for="username">Username</label>
								<div class="controls">
									<input type="text" id="username" name="loginEmail" placeholder="" class="input-xlarge">
								</div>
							</div>
							
							<div class="control-group">
							
								<label class="control-label" for="password">Password</label>
								<div class="controls">
									<input type="password" id="password" name="loginPassword" placeholder="" class="input-xlarge">
								</div>
							</div>
							
							
							<div class="control-group">
							
								<div class="controls">
									<button class="btn btn-success">Login</button>
								</div>
							</div>
						</fieldset>
					</form>                
				</div>
				<div class="tab-pane fade" id="create">
					<form id="tab" action = "RegisterAction" >
						<label>Full Name</label>
						<input type="text" value="" class="input-xlarge" name ="registerName">
						<label>UserName</label>
						<input type="text" value="" class="input-xlarge" name = "registerEmail">
						<label>Password</label>
						<input type="password" value="" class="input-xlarge" name = "registerPassword">
						</textarea>			
						<div>
							<button class="btn btn-primary">Create Account</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
