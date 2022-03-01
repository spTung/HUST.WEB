<html>
    <head><title>Guess A Number</title></head>
    <body>
        <form action="<?php echo $_SERVER['PHP_SELF'] ?>" method="POST">
        <?php
            $flip = rand(0, 100);
            if(isset($_POST["submit"])){
                $number = $_POST["number"];
        }
        ?>

        <table>
            <tr>
                <td>Enter a number:</td>
                <td>
                    <input type="text" name="number" value='<?php if(isset($_POST['number']) && $_POST['number'] != NULL){ echo $_POST['number']; } ?>' /><br/>
                </td>
            </tr>

            <tr>
                <td align="right"><input type="submit" name="submit" value="Submit"></td>
                <td align="left"><input type="reset" value="Reset"></td>
            </tr>
        </table>
        

        <?php
        if(isset($_POST["submit"])){
            if(!is_numeric($number)){
                echo $number . " is not numeric. Please enter again! <br>";
            } else {
                if ($flip > $number) {
                print(" Wrong. Please try a higher number. You have guessed 1 time!. <br>");
                } elseif ($flip < $number){
                print("Wrong. Please try a lower number. You have guessed 1 time!. <br>");
                } else {
                print("Congrulations! You got it right.");
                }
            }
        }
        ?>
        </form>
    </body>
</html>