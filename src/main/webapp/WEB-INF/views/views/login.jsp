    <div class="app-content content container-fluid">
      <div class="content-wrapper">
        <div class="content-header row">
          <div class="content-header-left col-md-6 col-xs-12 mb-1">
            <h2 class="content-header-title">NICE알리미</h2>
          </div>
        </div>
     
		<div class="col-md-6">
			<div class="card">
				<div class="card-header">
					<h4 class="card-title" id="basic-layout-colored-form-control">Login</h4>
					<a class="heading-elements-toggle"><i class="icon-ellipsis font-medium-3"></i></a>
				</div>
				<div class="card-body collapse in">
					<div class="card-block">

						<div class="card-text">
							<p>You can always change the border color of the form controls using <code>border-*</code> class. In this example we have user <code>border-primary</code> class for form controls. Form action buttons are on the bottom right position.</p>
						</div>

						<form class="form" action="/spring-mvc-showcase/users/login" method="get" id="loginForm">
							<div class="form-body">
								<h4 class="form-section"><i class="icon-eye6"></i> About User</h4>
								<div class="row">
									<div class="col-md-6">
										<div class="form-group">
											<label for="userinput1">ID</label>
											<input type="text" id="gwId" class="form-control border-primary" placeholder="id" name="gwId" value="wychoi">
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-group">
											<label for="userinput2">PW</label>
											<input type="text" id="pw" class="form-control border-primary" placeholder="password" name="pw" value="nice1234!!">
										</div>
									</div>
								</div>

							<div class="form-actions right">
								<button type="submit" class="btn btn-primary">
									<i class="icon-check2"></i> Login
								</button>
							</div>
							</div>
						</form>

					</div>
				</div>
			</div>
		</div>
	</div>
</div>
  </body>
</html>
