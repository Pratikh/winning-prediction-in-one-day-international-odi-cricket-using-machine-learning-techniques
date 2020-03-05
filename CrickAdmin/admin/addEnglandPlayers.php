<?php
include 'dbconnection.php';
$tname = "England";
$sql = "delete from england";
mysqli_query($con, $sql);

foreach ($_GET['players'] as $selectedPlayer) {
    $sql = "insert into england(pname) values('$selectedPlayer')";
    mysqli_query($con, $sql);
}
header('location: home.php?status=4');
?>