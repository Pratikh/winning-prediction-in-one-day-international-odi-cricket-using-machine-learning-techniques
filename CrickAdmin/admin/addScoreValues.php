<?php
session_start();
include 'dbconnection.php';
$mid = $_SESSION['mid'];
$batting_team = $_SESSION['batting_team'];

if ($_GET['next'] == 'next') {
    $sql = "update scores set playing_status=2 where team='$batting_team'";
    mysqli_query($con, $sql);
    header('location: score.php');
    die();
}

$runs = $_GET['runs'];
$overs = $_GET['overs'];
$player1 = $_GET['player1'];
$player2 = $_GET['player2'];
$no_of_wickets=0;
if(isset($_GET['no_of_wickets']))
{
$no_of_wickets = $_GET['no_of_wickets'];
}
$wicket_list = $_GET['wicket_list'];
$timestamp = round(microtime(true) * 1000);
$sql = "select * from scores where mid='$mid' and team='$batting_team'";
$result = mysqli_query($con, $sql);
$count = mysqli_num_rows($result);
$playing_status = 1;
if ($count > 0) {
    $sql = "update scores set runs='$runs',no_of_wickets='$no_of_wickets',overs='$overs',player1='$player1',player2='$player2',wickets='$wicket_list',playing_status='$playing_status'";
} else {
    $sql = "insert into scores(runs,no_of_wickets,overs,player1,player2,wickets,team,timestamp,mid,playing_status) values('$runs','$no_of_wickets','$overs','$player1','$player2','$wickets','$batting_team','$timestamp','$mid','$playing_status')";
}
mysqli_query($con, $sql);

header('location: score.php?runs=' . $runs . '&overs=' . $overs . '&player1=' . $player1 . '&player2=' . $player2 . '&no_of_wickets=' . $no_of_wickets . '&wicket_list=' . $wicket_list);
?>