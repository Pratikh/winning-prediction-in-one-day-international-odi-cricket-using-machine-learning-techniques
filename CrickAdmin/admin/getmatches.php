<?php
include "dbconnection.php";
$sql = "select * from matches";
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
