<?php
session_start();

if (isset($_POST['login'])) {
    $username = $_POST['username'];
    $password = $_POST['password'];
    if ($username == "admin" && $password == "admin") {
        $_SESSION['admin'] = "admin";
    }
    else {
        $_SESSION['error'] = "error";
    }
} else {
    $_SESSION['error'] = 'Input admin credentials first';
}

header('location: index.php');

?>