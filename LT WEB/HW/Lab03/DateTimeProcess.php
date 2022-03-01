<html>
    <head><title>Date time validation</title></head>
    <body>
        <div><span>Enter your name and select and time for the apppointment</span></div><br><br>
        <form action="<?php echo $_SERVER['PHP_SELF'] ?>" method="POST">
        <?php
        if(isset($_POST["submit"])){
            $name = $_POST["name"];
            $day = $_POST["day"]; 
            $month = $_POST["month"];
            $year = $_POST["year"];
            $hour = $_POST["hour"];
            $minute = $_POST["minute"];
            $second = $_POST["second"];
        } else {
            $day = 0; $month = 0; $year = 0;
            $hour = 0; $minute = 0; $second = 0;
        }
        ?>
        <table>
            <tr>
                <td>Your name</td>
                <td><input type="text" size="15" maxlength="30" name="name" value='<?php if(isset($_POST['name']) && $_POST['name'] != NULL){ echo $_POST['name']; } ?>' /><br/></td> 
            </tr>
            <tr>
                <td>Date</td>
                <td><select name="day">
                    <?php
                    for ($i = 0; $i  <= 31; $i++){
                        if($day == $i){
                            print("<option selected>$i</option>");
                        } else {
                            print("<option>$i</option>");
                        }
                    }   
                    ?>
                </select>
                <select name="month">
                    <?php
                    for ($i = 0; $i  <= 12; $i++){
                        if($month == $i){
                            print("<option selected>$i</option>");
                        } else {
                            print("<option>$i</option>");
                        }
                    }
                    ?>
                </select>
                <select name="year">
                    <?php
                    for ($i = 0; $i  <= 3000; $i++){
                        if($year == $i){
                            print("<option selected>$i</option>");
                        } else {
                            print("<option>$i</option>");
                        }
                    }
                    ?>
                </select></td>
            </tr>
            <tr>
                <td>Time</td>
                <td><select name="hour">
                    <?php
                    for ($i = 0; $i  < 24; $i++){
                        if($hour == $i){
                            print("<option selected>$i</option>");
                        } else {
                            print("<option>$i</option>");
                        }
                    }
                    ?>
                </select>
                <select name="minute">
                    <?php
                    for ($i = 0; $i  < 60; $i++){
                        if($minute == $i){
                            print("<option selected>$i</option>");
                        } else {
                            print("<option>$i</option>");
                        }
                    }
                    ?>
                </select>
                <select name="second">
                    <?php
                    for ($i = 0; $i  < 60; $i++){
                        if($second == $i){
                            print("<option selected>$i</option>");
                        } else {
                            print("<option>$i</option>");
                        }
                    }
                    ?>
                </select></td>
            </tr>
            <tr>
                <td align="right"><input type="submit" name="submit" value="Submit"></td>
                <td align="left"><input type="reset" value="Reset"></td>
            </tr>
        </table>
    </form>
    <br>
    <?php
    if(isset($_POST["submit"])) {
        echo "Hi, $name! <br><br>";
        echo "You have choose to have an appointment on " . $hour . ":" . $minute . ":" . $second . "," . $day . "/" . $month . "/" . $year . "<br><br>";
        echo "More information <br><br>";
        if($hour >= 12){
            $hour = $hour - 12;
            echo "In 12 hours, the time and date is " . $hour . ":" . $minute . ":" . $second . " PM," . $day . "/" . $month . "/" . $year . "<br><br>";
        } else {
            echo "In 12 hours, the time and date is " . $hour . ":" . $minute . ":" . $second . "," . $day . "/" . $month . "/" . $year . "<br><br>";
        }
        switch ($month) {
            case 1 : 
            case 3 : 
            case 5 : 
            case 7 : 
            case 8 : 
            case 9 : 
            case 10 : 
                $days = 31;
                break;
            case 4 :
            case 6 :
            case 9 :
            case 11 :
                $days = 30;
                break;
            case 2 :
                if ($year % 400 == 0 || $year % 4 == 0) {
                    $days = 29;
                } elseif ($year % 100 == 0){
                    $days = 28;
                } else $days = 28;
                break;
            default :
                echo "<br>Invalid";
                break;
        }
        echo "This month has $days days!";
    }
    ?>
    </body>
</html>