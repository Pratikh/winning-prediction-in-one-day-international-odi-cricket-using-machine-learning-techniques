<?php
include 'dbconnection.php';
$tname = "India";
$sql = "delete from team1";
mysqli_query($con, $sql);

foreach ($_GET['batsman'] as $selectedPlayer) {
    $sql = "insert into india(pname) values('$selectedPlayer')";
    mysqli_query($con, $sql);
}

foreach ($_GET['bowlers'] as $selectedPlayer) {
    $sql = "insert into india(pname) values('$selectedPlayer')";
    mysqli_query($con, $sql);
}

header('location: home.php?status=1');
?>