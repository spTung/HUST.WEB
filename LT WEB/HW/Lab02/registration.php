<html>
    <head><title> Receiving Input </title></head>
    <body>
        <font size=5>Thanh you for your registration</font>
        <?php 
            $username = $_POST("username");
            $email = $_POST("email");
            $birthday = $_POST("birthday");
            $fav_language = $_POST("fav_language");
            $experience = $_POST("experience");
            print("<br>Your username is: $username");
            print("<br>Your email is: $email");
            print("<br>Your birthday is: $birthday");
            print("<br>Your favorite language: $fav_language");
            print("<br>Years of experience: $experience");
        ?>
    </body>
</html>