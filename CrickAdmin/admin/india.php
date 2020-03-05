<?php include 'header.php'; ?>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">

  <?php include 'navbar.php'; ?>
  <?php include 'menubar.php'; ?>

  <!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h1>India Player List</h1>
				<ol class="breadcrumb">
					<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
					<li>Players</li>
					<li class="active">Player List</li>
				</ol>
			</section>
			<!-- Main content -->
			<section class="content">

				<form class="form-inline" action="addIndiaPlayers.php" method="get">

					<div class="row">
						<div class="col-xs-4">
							<div class="form-group">
								<label>BatsMan</label> <select
									class="form-control select2 select2-hidden-accessible"
									multiple="" data-placeholder="Select BatsMan"
									style="width: 100%;" tabindex="-1" aria-hidden="true"
									name="batsman[]" id="batsman">
									<option>Ajinkya Rahane</option>
									<option>Dinesh Karthik</option>
									<option>Manish Pandey</option>
									<option>MS Dhoni</option>
									<option>Pandya</option>
									<option>K L Rahul</option>
									<option>Rohit Sharma</option>
									<option>Shikhar Dhawan</option>
									<option>Virat Kohli</option>
									<option>Ravindra Jadeja</option>
								</select>
							</div>
						</div>
					</div>

					<br> <br>

					<div class="row">
						<div class="col-xs-4">
							<div class="form-group">
								<label>Bowlers</label> <select
									class="form-control select2 select2-hidden-accessible"
									multiple="" data-placeholder="Select Bowlers"
									style="width: 100%;" tabindex="-1" aria-hidden="true"
									name="bowlers[]" id="bowlers">
									<option>Axar</option>
									<option>B Kumar</option>
									<option>Bumrah</option>
									<option>M Shami</option>
									<option>Shreyas Iyer</option>
									<option>Umesh Yadav</option>
									<option>Yuzvendra Chahal</option>
									<option>Kedar Jadhav</option>
									<option>Kuldeep Y</option>
									<option>R Ashwin</option>
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

        $(document).ready(function() {
          var last_valid_selection = null;
          $('#bowlers').change(function(event) {
            if ($(this).val().length > 5) {
              $(this).val(last_valid_selection);
            } else {
              last_valid_selection = $(this).val();
            }
          });
        });
        </script>

	<script type="text/javascript">

        $(document).ready(function() {
          var last_valid_selection = null;
          $('#batsman').change(function(event) {
            if ($(this).val().length > 5) {
              $(this).val(last_valid_selection);
            } else {
              last_valid_selection = $(this).val();
            }
          });
        });
        </script>
</body>
</html>
