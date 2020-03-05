<?php include 'header.php'; ?>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">

  <?php include 'navbar.php'; ?>
  <?php include 'menubar.php'; ?>

  <!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h1>Australia Player List</h1>
				<ol class="breadcrumb">
					<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
					<li>Players</li>
					<li class="active">Player List</li>
				</ol>
			</section>
			<!-- Main content -->
			<section class="content">

				<form class="form-inline" action="addAustraliaPlayers.php" method="get">

					<div class="row">
						<div class="col-xs-4">
							<div class="form-group">
								<label>BatsMan</label> <select
									class="form-control select2 select2-hidden-accessible"
									multiple="" data-placeholder="Select BatsMan"
									style="width: 100%;" tabindex="-1" aria-hidden="true"
									name="batsman[]" id="batsman">
									<option>david</option>
									<option>finch</option>
									<option>hazlewood</option>
									<option>Head</option>
									<option>hilton</option>
									<option>maxwell</option>
									<option>SHAUN MARSH</option>
									<option>STEVEN SMITH</option>
									<option>tim</option>
									<option>wade</option>
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
									<option>JAMES FAULKNAR</option>
									<option>KEN RICHARDSON</option>
									<option>mmarsh</option>
									<option>PETER HANDSCOMB</option>
									<option>Starc</option>
									<option>stoinnis</option>
									<option>zampa</option>
									<option>Ashton Agar</option>
									<option>COULTER NILE</option>
									<option>cummins</option>
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
