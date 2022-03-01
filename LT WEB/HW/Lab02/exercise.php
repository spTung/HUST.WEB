<!DOCTYPE html>
<html lang="en">
<head><title>Document</title>
</head>
<body>
    <h3>Your profile</h3>
    <?php
        $name = $_POST['name'];
        $class = $_POST['class'];
        $university = $_POST['university'];
        $hobbies = $_POST['hobbies'];
        printf("<br>Hello, $name !");
        printf("<br>You are studying at $class, $university .");
        printf("<br>Your hobby is<br>");
        foreach ($hobbies as $hobby){ 
            echo $hobby."<br />";
        }
        ?>
</body>
</html>