<?php
// Start the session
session_start();

// Connect to the MySQL database
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "login4thqn";

$conn = mysqli_connect($servername, $username, $password, $dbname);

// Check connection
if (!$conn) {
    die("Connection failed: " . mysqli_connect_error());
}

// If the user has submitted the login form, validate the username and password
if (isset($_POST['name']) && isset($_POST['password'])) {
    $username = $_POST['name'];
    $password = $_POST['password'];

    // Hash the password using the default algorithm
    // $hashed_password = password_hash($password, PASSWORD_DEFAULT);

    // Check if the username and hashed password match a record in the database
    $sql = "SELECT * FROM login WHERE name='$username'";
    $result = mysqli_query($conn, $sql);

    if (mysqli_num_rows($result) > 0) {
        $row = mysqli_fetch_assoc($result);
        if (($password== $row['password'])) {
            // If the username and password are correct, start the session and redirect to the homepage
            $_SESSION['name'] = $username;
            echo "Login Successfull ";
            exit;
        } else {
            // If the password is incorrect, display an error message
            echo "invalid  password";
        }
    } else {
        // If the username is incorrect, display an error message
        echo "Invalid username.";
    }
}
?>

<!DOCTYPE html>
<html>
<head>
    <title>Login Page</title>
</head>
<body>
    <h1>Login</h1>
    <form method="post" action="<?php echo htmlspecialchars($_SERVER['PHP_SELF']); ?>">
        <label for="username">Username:</label>
        <input type="text" id="username" name="name"><br><br>
        <label for="password">Password:</label>
        <input type="password" id="password" name="password"><br><br>
        <input type="submit" value="Submit">
    </form>
</body>
</html>
