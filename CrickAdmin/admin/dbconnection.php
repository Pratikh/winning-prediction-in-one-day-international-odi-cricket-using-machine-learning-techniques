<?php
error_reporting(0);
include "config.php";
$con = mysqli_connect(DB_HOST_NAME, DB_USER_NAME, DB_PASSWORD);
if ($con) {
    mysqli_select_db($con, DB_NAME);
}

?>