<?php
include "dbconnection.php";
$sql = "select * from india";
$result = mysqli_query($con, $sql);
$list1 = array();
while ($row = mysqli_fetch_assoc($result)) {
    $list1[] = $row;
}

$sql = "select * from australia";
$result = mysqli_query($con, $sql);
$list2 = array();
while ($row = mysqli_fetch_assoc($result)) {
    $list2[] = $row;
}

$sql = "select * from england";
$result = mysqli_query($con, $sql);
$list3 = array();
while ($row = mysqli_fetch_assoc($result)) {
    $list3[] = $row;
}

$sql = "select * from southafrica";
$result = mysqli_query($con, $sql);
$list4 = array();
while ($row = mysqli_fetch_assoc($result)) {
    $list4[] = $row;
}

$res = array(
    "data1" => $list1,
    "data2" => $list2,
    "data3" => $list3,
    "data4" => $list4
);
echo json_encode($res);

?>
