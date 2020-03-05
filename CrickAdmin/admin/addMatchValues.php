<?php
include 'dbconnection.php';
$team1 = $_GET['team1'];
$team2 = $_GET['team2'];
$toss = $_GET['toss'];
$ground = $_GET['ground'];
$iToss = 1;

if ($toss == 'Chasing') {
    $iToss = 2;
}

$sql = "delete from matches where (team1='$team1' or team1='$team2') and (team2='$team1' or team2='$team2')";
mysqli_query($con, $sql);
$sql = "insert into matches(team1,team2,toss,ground) values('$team1','$team2','$iToss','$ground')";
mysqli_query($con, $sql);

$sql="delete from scores where team='$team1' or team='$team2'";
mysqli_query($con, $sql);
header('location: home.php?status=3');
?>