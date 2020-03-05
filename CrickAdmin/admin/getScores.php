<?php
include "dbconnection.php";
$mid =$_GET['mid'];
$sql = "select * from scores where mid='$mid'";
$result = mysqli_query($con, $sql);
$list = array();
while ($row = mysqli_fetch_assoc($result)) {
    $list[] = $row;
}

$res = array(
    "data" => $list
);
echo json_encode($res);

?>
