<?php
include 'dbconnection.php';
$tname = "South Africa";
$sql = "delete from southafrica";
mysqli_query($con, $sql);

foreach ($_GET['players'] as $selectedPlayer) {
    $sql = "insert into southafrica(pname) values('$selectedPlayer')";
    mysqli_query($con, $sql);
}
header('location: home.php?status=5');
?>