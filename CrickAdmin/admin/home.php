<?php include 'header.php'; ?>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">

  <?php include 'navbar.php'; ?>
  <?php

include 'menubar.php';
$status = $_GET['status'];
$msg = "";
if ($status == 1) {
    $msg = "India team players added successfully";
} else if ($status == 2) {
    $msg = "Australia team players added successfully";
} else if ($status == 3) {
    $msg = "Match  added successfully";
} else if ($status == 4) {
    $msg = "England team players added successfully";
} else if ($status == 5) {
    $msg = "South Africa team players added successfully";
}
?>
  
  

  <!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h1>Dashboard</h1>
				<ol class="breadcrumb">
					<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
					<li class="active">Dashboard</li>

<?php
if (strlen($msg) > 0) {
    ?>
					<div class="box-body">
						<div class="alert alert-success alert-dismissible">
							<button type="button" class="close" data-dismiss="alert"
								aria-hidden="true">×</button>
							<h4>
								<i class="icon fa fa-check"></i> Message!
							</h4>
							<?php
    
    echo $msg;
    $msg = "";
    unset($GLOBALS['status']);
    ?>
						</div>
					</div>

<?php
}
?>

				</ol>
			</section>

			<!-- Main content -->
			<section class="content"></section>
			<!-- right col -->
		</div>
  	<?php include 'includes/footer.php'; ?>

</div>
	<!-- ./wrapper -->

	<!-- Chart Data -->

	<!-- End Chart Data -->
<?php include 'scripts.php'; ?>
<script>
$(function(){
  var barChartCanvas = $('#barChart').get(0).getContext('2d')
  var barChart = new Chart(barChartCanvas)
  var barChartData = {
    labels  : <?php echo $months; ?>,
    datasets: [
      {
        label               : 'Borrow',
        fillColor           : 'rgba(210, 214, 222, 1)',
        strokeColor         : 'rgba(210, 214, 222, 1)',
        pointColor          : 'rgba(210, 214, 222, 1)',
        pointStrokeColor    : '#c1c7d1',
        pointHighlightFill  : '#fff',
        pointHighlightStroke: 'rgba(220,220,220,1)',
        data                : <?php echo $borrow; ?>
      },
      {
        label               : 'Return',
        fillColor           : 'rgba(60,141,188,0.9)',
        strokeColor         : 'rgba(60,141,188,0.8)',
        pointColor          : '#3b8bba',
        pointStrokeColor    : 'rgba(60,141,188,1)',
        pointHighlightFill  : '#fff',
        pointHighlightStroke: 'rgba(60,141,188,1)',
        data                : <?php echo $return; ?>
      }
    ]
  }
  barChartData.datasets[1].fillColor   = '#00a65a'
  barChartData.datasets[1].strokeColor = '#00a65a'
  barChartData.datasets[1].pointColor  = '#00a65a'
  var barChartOptions                  = {
    //Boolean - Whether the scale should start at zero, or an order of magnitude down from the lowest value
    scaleBeginAtZero        : true,
    //Boolean - Whether grid lines are shown across the chart
    scaleShowGridLines      : true,
    //String - Colour of the grid lines
    scaleGridLineColor      : 'rgba(0,0,0,.05)',
    //Number - Width of the grid lines
    scaleGridLineWidth      : 1,
    //Boolean - Whether to show horizontal lines (except X axis)
    scaleShowHorizontalLines: true,
    //Boolean - Whether to show vertical lines (except Y axis)
    scaleShowVerticalLines  : true,
    //Boolean - If there is a stroke on each bar
    barShowStroke           : true,
    //Number - Pixel width of the bar stroke
    barStrokeWidth          : 2,
    //Number - Spacing between each of the X value sets
    barValueSpacing         : 5,
    //Number - Spacing between data sets within X values
    barDatasetSpacing       : 1,
    //String - A legend template
    legendTemplate          : '<ul class="<%=name.toLowerCase()%>-legend"><% for (var i=0; i<datasets.length; i++){%><li><span style="background-color:<%=datasets[i].fillColor%>"></span><%if(datasets[i].label){%><%=datasets[i].label%><%}%></li><%}%></ul>',
    //Boolean - whether to make the chart responsive
    responsive              : true,
    maintainAspectRatio     : true
  }

  barChartOptions.datasetFill = false
  var myChart = barChart.Bar(barChartData, barChartOptions)
  document.getElementById('legend').innerHTML = myChart.generateLegend();
});
</script>
	<script>
$(function(){
  $('#select_year').change(function(){
    window.location.href = 'home.php?year='+$(this).val();
  });
});
</script>
</body>
</html>
