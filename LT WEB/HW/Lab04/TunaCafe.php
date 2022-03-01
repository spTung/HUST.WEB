<html>
    <head><title> Tuna Cafe </title></head>
    <body><font size=4 color=blue>
        Welcome to the Tune Cafe Survey!
    </font>
    <form action="TunaResults.php" method="GET">
        <?php
        $menu = array('tuna casserole', 'tuna sandwitch', 'tuna pie', 'grilled tuna', 'tuna suprise');
        $bestseller = 2;
        print"Please indicate all your favorite dishes.<br>";
        for ($i = 0; $i < count($menu); $i++){
            print"<input type=\"checkbox\" name=\"prefer[]\" value=$i> $menu[$i]";
            if ($i == $bestseller){
                print"<font color=red> Our best seller!!</font>";
            }
            print"<br>";
        }
        ?>
        <input type="submit" value="Submit">
        <input type="reset" value="Restart">
    </form>
    </body>
</html>