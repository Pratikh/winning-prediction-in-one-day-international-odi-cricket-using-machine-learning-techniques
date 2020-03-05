<?php include 'header.php'; ?>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">

  <?php include 'navbar.php'; ?>
  <?php include 'menubar.php'; ?>

  <!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h1>South Africa Player List</h1>
				<ol class="breadcrumb">
					<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
					<li>Players</li>
					<li class="active">Player List</li>
				</ol>
			</section>
			<!-- Main content -->
			<section class="content">

				<form class="form-inline" action="addSouthAfricaPlayers.php"
					method="get">

					<div class="row">
						<div class="col-xs-4">
							<div class="form-group">
								<label>Players</label> <select
									class="form-control select2 select2-hidden-accessible"
									multiple="" data-placeholder="Select Players"
									style="width: 100%;" tabindex="-1" aria-hidden="true"
									name="players[]" id="players">
									<option>Aiden Markram</option>
									<option>DEAN ELGAR</option>
									<option>FAF</option>
									<option>IMRAN TAHIR</option>
									<option>RABADA</option>
									<option>VERNON PHILANDER</option>
									<option>KLAASEN</option>
									<option>WAYNE PARNELL</option>
									<option>MORRIS</option>
								</select>
							</div>
						</div>
					</div>

					<br> <br>




					<div class="row">
						<div class="col-xs-4">
							<button type="submit" class="btn btn-primary btn-block btn-flat"
								name="save" id="eng_players">
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
          $('#players').change(function(event) {
            if ($(this).val().length > 12) {
              $(this).val(last_valid_selection);
            } else {
              last_valid_selection = $(this).val();
            }
          });
        });
        </script>
</body>
</html>
