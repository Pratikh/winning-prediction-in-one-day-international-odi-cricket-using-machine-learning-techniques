<?php
include 'dbconnection.php';
$tname = "Australia";
$sql = "delete from team2";
mysqli_query($con, $sql);

foreach ($_GET['batsman'] as $selectedPlayer) {
    $sql = "insert into australia(pname) values('$selectedPlayer')";
    mysqli_query($con, $sql);
}

foreach ($_GET['bowlers'] as $selectedPlayer) {
    $sql = "insert into australia(pname) values('$selectedPlayer')";
    mysqli_query($con, $sql);
}

header('location: home.php?status=2');
?>