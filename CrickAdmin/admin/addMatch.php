<?php include 'header.php'; ?>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">

  <?php include 'navbar.php'; ?>
  <?php include 'menubar.php'; ?>

  <!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h1>Select Teams</h1>
				<ol class="breadcrumb">
					<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
					<li>Teams</li>
					<li class="active">Match</li>
				</ol>
			</section>
			<!-- Main content -->
			<section class="content">

				<form class="form-inline" action="addMatchValues.php" method="get">


					<div class="row">
						<div class="col-xs-4">
							<div class="form-group">
								<label>Ground</label> <select
									class="form-control select2 select2-hidden-accessible"
									style="width: 100%;" tabindex="-1" aria-hidden="true"
									id="ground" name="ground">
									<option>Himachal Pradesh Cricket Association Stadium</option>
									<option>Feroz Shah Kotla</option>
									<option>Punjab Cricket Association IS Bindra Stadium</option>
									<option>Dr YS Rajasekhara Reddy Cricket Stadium</option>
									<option>Maharashtra Cricket Association Stadium</option>
									<option>Barabati Stadium</option>
									<option>Eden Gardens</option>
									<option>MA Chidambaram Stadium</option>
									<option>Holkar Cricket Stadium</option>
									<option>Vidarbha Cricket Association Stadium</option>
									<option>Wankhede Stadium</option>
									<option>Green Park</option>
									<option>Edgbaston</option>
									<option>Kennington Oval</option>
									<option>SuperSports Park</option>
									<option>Newsland</option>
									<option>New Wanderers</option>
									<option>St.George</option>
									<option>Kingsmead</option>
									<option>Sydney Cricket Ground</option>
								</select>
							</div>
						</div>
					</div>

					<br> <br>


					<div class="row">
						<div class="col-xs-4">
							<div class="form-group">
								<label>Team1</label> <select
									class="form-control select2 select2-hidden-accessible"
									style="width: 100%;" tabindex="-1" aria-hidden="true"
									id="team1" name="team1">
									<option>India</option>
									<option>Australia</option>
									<option>England</option>
									<option>South Africa</option>
								</select>
							</div>
						</div>
					</div>

					<br> <br>

					<div class="row">
						<div class="col-xs-4">
							<div class="form-group">
								<label>Team2</label> <select
									class="form-control select2 select2-hidden-accessible"
									style="width: 100%;" tabindex="-1" aria-hidden="true"
									id="team2" name="team2">
									<option>Australia</option>
								</select>
							</div>
						</div>
					</div>

					<br> <br>

					<div class="row">
						<div class="col-xs-4">
							<div class="form-group">
								<label>Toss</label> <select
									class="form-control select2 select2-hidden-accessible"
									style="width: 100%;" tabindex="-1" aria-hidden="true" id="toss"
									name="toss">
									<option>Batting First</option>
									<option>Chasing</option>
								</select>
							</div>
						</div>
					</div>

					<br> <br>

					<div class="row">
						<div class="col-xs-4">
							<button type="submit" class="btn btn-primary btn-block btn-flat"
								name="save" id="india_players">
								<i class="fa fa-sign-in"></i> Save
							</button>
						</div>
					</div>
				</form>

			</section>
		</div>

	</div>
<?php include 'scripts.php'; ?>
<script type="text/javascript">


$(document).ready(function () {
    $("#team1").change(function () {
        var val = $(this).val();
        if (val == "India") {
            $("#team2").html("<option value='Australia'>Australia</option><option value='England'>England</option><option value='South Africa'>South Africa</option>");
        } else  if (val == "Australia") {
        	 $("#team2").html("<option value='India'>India</option><option value='England'>England</option><option value='South Africa'>South Africa</option>");
        } 
        else  if (val == "South Africa") {
       	 $("#team2").html("<option value='India'>India</option><option value='England'>England</option><option value='Australia'>Australia</option>");
       } 
        else  if (val == "England") {
          	 $("#team2").html("<option value='India'>India</option><option value='South Africa'>South Africa</option><option value='Australia'>Australia</option>");
          } 
    });
});


       
        </script>
</body>
</html>
