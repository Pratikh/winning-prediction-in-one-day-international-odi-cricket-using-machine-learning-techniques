<aside class="main-sidebar">
	<!-- sidebar: style can be found in sidebar.less -->
	<section class="sidebar">
		<!-- Sidebar user panel -->
		<div class="user-panel">
			<div class="pull-left image">
				<img
					src="<?php echo (!empty($user['photo'])) ? '../images/'.$user['photo'] : '../images/profile.jpg'; ?>"
					class="img-circle" alt="User Image">
			</div>
			<div class="pull-left info">
				<p><?php echo $user['firstname'].' '.$user['lastname']; ?></p>
				<a><i class="fa fa-circle text-success"></i> Online</a>
			</div>
		</div>
		<!-- sidebar menu: : style can be found in sidebar.less -->
		<ul class="sidebar-menu" data-widget="tree">
			<li class="treeview"><a href="#"> <i class="fa fa-user-plus"></i> <span>Players</span>
					<span class="pull-right-container"> <i
						class="fa fa-angle-left pull-right"></i>
				</span>
			</a>
				<ul class="treeview-menu">
					<li><a href="india.php"><i class="fa fa-circle-o"></i> India</a></li>
					<li><a href="australia.php"><i class="fa fa-circle-o"></i>
							Australia</a></li>
					<li><a href="england.php"><i class="fa fa-circle-o"></i> England</a></li>
					<li><a href="southafrica.php"><i class="fa fa-circle-o"></i> South
							Africa</a></li>
				</ul></li>
			<li class="treeview"><a href="#"> <i class="fa  fa-list-alt"></i> <span>Match</span>
					<span class="pull-right-container"> <i
						class="fa fa-angle-left pull-right"></i>
				</span>
			</a>
				<ul class="treeview-menu">
					<li><a href="addMatch.php"><i class="fa fa-circle-o"></i> Add Match</a></li>
				</ul></li>
			<li class="treeview"><a href="#"> <i class="fa  fa-line-chart"></i> <span>Score</span>
					<span class="pull-right-container"> <i
						class="fa fa-angle-left pull-right"></i>
				</span>
			</a>
				<ul class="treeview-menu">
					<?php
    include 'dbconnection.php';
    $sql = "select * from matches";
    $result = mysqli_query($con, $sql);
    while ($row = mysqli_fetch_assoc($result)) {
        
        $team1 = $row['team1'];
        $team2 = $row['team2'];
        $mid = $row['mid'];
        $id = $team1 . ":" . $team2;
        $idV = $team1 . " VS " . $team2;
        ?>
					<li><a href="score.php?id=<?php echo $mid; ?>"><i
							class="fa fa-circle-o"></i><?php echo $idV;?></a></li>

<?php
    }
    ?>
				</ul></li>
		</ul>
	</section>
	<!-- /.sidebar -->
</aside>