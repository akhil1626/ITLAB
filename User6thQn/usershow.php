<html>
<div align="center">
<form method="post" >
    Username:<input type="text" name="username" required><br><br>

    Password:<input type="password" name="password" required><br><br>

    <input type="submit" name="submit" value="Login">
</form>
</div>
</html>


<?php
// Database configuration
$host     = "localhost";
$username = "root";
$password = "";
$dbname   = "user6thqn";

// Connect to MySQL database
$conn = mysqli_connect($host, $username, $password, $dbname);

// Check if the connection was successful or not
if (!$conn) {
    die("Connection failed: " . mysqli_connect_error());
}

// Check if the login form was submitted
if (isset($_POST['submit'])) {
    // Get the username and password from the login form
    $username = $_POST['username'];
    $password = $_POST['password'];

    // Create a SQL query to fetch the user details from the database
    $sql = "SELECT * FROM user WHERE username='$username' AND password='$password'";

    // Execute the SQL query
    $result = mysqli_query($conn, $sql);

    // Check if the query was successful or not
    if (!$result) {
        die("Query failed: " . mysqli_error($conn));
    }

    // Check if a row was returned from the database
    if (mysqli_num_rows($result) > 0) {
        // Fetch the row as an associative array
        $row = mysqli_fetch_assoc($result);

        // Display the user details
        echo "Username: " . $row['username'] . "<br>";
        echo "Full Name: " . $row['fullname'] . "<br>";
        echo "Email: " . $row['email'] . "<br>";
        echo "Address: " . $row['address'] . "<br>";
        // You can add more fields here

        // Close the database connection
        mysqli_close($conn);
    } else {
        // If no row was returned, display an error message
        echo "Invalid login credentials";
    }
}
?>



