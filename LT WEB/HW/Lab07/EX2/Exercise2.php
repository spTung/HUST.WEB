<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Exercise2</title>
</head>

<body>
    <?php
    function test_input($data)
    {
        $data = trim($data);
        $data = stripslashes($data);
        $data = htmlspecialchars($data);
        return $data;
    }

    // $email = $_POST["email"];
    // $url = $_POST["url"];


    if (empty($_POST["phone"])) {
        $phoneErr = "phone is empty";
    } else {
        $phone = $_POST["phone"];
        // check if URL address syntax is valid
        if (!preg_match("/^[0-9]{10}$/", $_POST["phone"])) {
            $phoneErr = "Invalid phone format";
        }
        else $phoneErr = "phone ok";
    }

    if (empty($_POST["url"])) {
        $websiteErr = "url is empty";
    } else {
        $website = test_input($_POST["url"]);
        // check if URL address syntax is valid
        if (!preg_match("/\b(?:(?:https?|ftp):\/\/|www\.)[-a-z0-9+&@#\/%?=~_|!:,.;]*[-a-z0-9+&@#\/%=~_|]/i", $website)) {
            $websiteErr = "Invalid URL format";
        }
        else $websiteErr = "URL ok";
    }

    if (empty($_POST["email"])) {
        $emailErr = "Email is required";
    } else {
        $email = test_input($_POST["email"]);
        // check if e-mail address is well-formed
        if (!filter_var($email, FILTER_VALIDATE_EMAIL)) {
            $emailErr = "Invalid email format";
        }
        else $emailErr = "email ok";
    }
    echo $phoneErr . "<br>" . $websiteErr . "<br>" . $emailErr . "<br><a href="."Exercise2.html".">Return input</a>";
    ?>
</body>

</html>