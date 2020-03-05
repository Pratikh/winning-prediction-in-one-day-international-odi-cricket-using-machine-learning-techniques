<?php include 'header.php'; ?>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">

  <?php include 'navbar.php'; ?>
  <?php include 'menubar.php'; ?>
  <?php
session_start();
include 'dbconnection.php';

if (isset($_SESSION['mid']) && $_GET['mid'] == $_SESSION['mid']) {
    $mid = $_SESSION['mid'];
} else {
    $mid = $_GET['id'];
}
$sql = "select * from scores where mid='$mid'  order by timestamp desc";
$result = mysqli_query($con, $sql);
$count = mysqli_num_rows($result);
if ($count == 0) {
    $sql = "select * from matches where mid='$mid'";
    $result = mysqli_query($con, $sql);
    $row = mysqli_fetch_assoc($result);
    $team1 = $row['team1'];
    $team2 = $row['team2'];
    $toss = $row['toss'];
    if ($toss == 1) {
        $batting_team = $team1;
    } else {
        $batting_team = $team2;
    }
} else if ($count == 1) {
    
    $row = mysqli_fetch_assoc($result);
    $team = $row['team'];
    $playing_status = $row['playing_status'];
    if ($playing_status == 1) {
        $batting_team = $team;
    } else {
        $sql = "select * from matches where mid='$mid'";
        $result = mysqli_query($con, $sql);
        $row = mysqli_fetch_assoc($result);
        $team1 = $row['team1'];
        $team2 = $row['team2'];
        $toss = $row['toss'];
        if ($toss == 1) {
            $batting_team = $team2;
        } else {
            $batting_team = $team1;
        }
    }
} else if ($count == 2) {
    
    $row = mysqli_fetch_assoc($result);
    $batting_team = $row['team'];
}

$_SESSION['mid'] = $mid;
$_SESSION['batting_team'] = $batting_team;
?>

  <!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h1>Score Panel</h1>
				<ol class="breadcrumb">
					<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
					<li>Score</li>
					<li class="active">Add Live Score</li>
				</ol>
			</section>
			<!-- Main content -->
			<section class="content">

				<form class="form-inline" action="addScoreValues.php" method="get">

					<div class="row">
						<div class="col-xs-4">
							<div class="form-group">
								<label>Current Playing Team:  <?php echo $batting_team;?></label>
							</div>
						</div>
					</div>

					<br> <br>


					<div class="row">
						<div class="col-xs-4">
							<div class="form-group">
								<label>Runs:</label>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="col-xs-4">
							<div class="form-group">
								<input type="text" class="form-control" id="runs"
									placeholder="Runs" name="runs"
									value=<?php echo $_GET['runs'];?>>
							</div>
						</div>
					</div>


					<br> <br>

					<div class="row">
						<div class="col-xs-4">
							<div class="form-group">
								<label>Overs:</label>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="col-xs-4">
							<div class="form-group">
								<input type="text" class="form-control" id="overs"
									placeholder="Overs" name="overs"
									value=<?php echo $_GET['overs'];?>>
							</div>
						</div>
					</div>


					<br> <br>

					<div class="row">
						<div class="col-xs-4">
							<div class="form-group">
								<label>Player1:</label>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="col-xs-4">
							<div class="form-group">
								<input type="text" class="form-control" id="player1"
									placeholder="Player1" name="player1"
									value=<?php echo $_GET['player1'];?>>
							</div>
						</div>
					</div>

					<br> <br>

					<div class="row">
						<div class="col-xs-4">
							<div class="form-group">
								<label>Player2:</label>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="col-xs-4">
							<div class="form-group">
								<input type="text" class="form-control" id="player2"
									placeholder="Player2" name="player2"
									value=<?php echo $_GET['player2'];?>>
							</div>
						</div>
					</div>

					<br> <br>




					<div class="row">
						<div class="col-xs-4">
							<div class="form-group">
								<label>Number of Wickets:</label>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="col-xs-4">
							<div class="form-group">
								<input type="text" class="form-control" id="no_of_wickets"
									placeholder="Number of Wickets" name="no_of_wickets"
									value=<?php echo $_GET['no_of_wickets'];?>>
							</div>
						</div>
					</div>

					<br> <br>


					<div class="row">
						<div class="col-xs-4">
							<div class="form-group">
								<label>Wicket List:</label>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="col-xs-4">
							<div class="form-group">
								<input type="text" class="form-control" id="wicket_list"
									placeholder="Wicket List" name="wicket_list"
									value=<?php echo $_GET['wicket_list'];?>>
							</div>
						</div>
					</div>

					<br> <br>

					<div class="row">
						<div class="col-xs-4">
							<button type="submit" class="btn btn-primary btn-block btn-flat"
								name="save" id="add_score">
								<i class="fa fa-sign-in"></i> Add Score
							</button>
						</div>

						<div class="col-xs-4">
							<button type="submit" class="btn btn-primary btn-block btn-flat"
								name="next" id="next_inning" value="next">
								<i class="fa fa-sign-in"></i> Next Innings
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
            $("#team2").html("<option value='Australia'>Australia</option>");
        } else  if (val == "Australia") {
            $("#team2").html("<option value='India'>India</option>");
        } 
    });
});


       
        </script>
</body>
</html>
