<html>
    <head><title>Date Check</title></head>
    <body>
        <?php

        $date= $_POST["date"];
        $two = '[[:digit:]]{2}';
        $month='[0-1][[:digit:]]';
        $day = '[0-3][[:digit:]]';
        $year = '2[[:digit:]]{3}';
        $pattern = "/\//";
        list($month, $day, $year) = preg_split($pattern, $date, 3);

        // if( preg_match("/^[0-1][0-9]\/[0-3][0-9]\/2[0-9]{3}$/", $date)){
        if( preg_match("/^$month\/$day\/$year$/", $date)){
            if(isValid($month,$day,$year) > 0){
                print "Valid date=$date<br>";
            } else {
                print "Invalid date=$date";
            }
        }


        function isValid($month,$day,$year){
            $d = (int)$day;
            $m = (int)$month;
            $y = (int)$year;

            switch ($m) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    if($d > 31){
                        return -1;
                    } else {
                        return 1;
                    }
                case 4:
                case 6:
                case 9:
                case 11:
                    if($d > 30){
                        return -1;
                    } else {
                        return 1;
                    }
                case 2:
                    if($y % 4 == 0){
                        if($d > 29){
                            return -1;
                        } else {
                            return 1;
                        }
                    } else {
                        if($d > 28){
                            return -1;
                        } else {
                            return 1;
                        }
                    }
                default:
                    return -1;
            }
        }
        ?>
    </body>
</html>