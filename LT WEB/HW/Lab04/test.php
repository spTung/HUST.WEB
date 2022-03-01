<html>
    <head><title>Distance and time calculations</title></head>
    <body>
        <?php
        $cities = array("Dallas" => 803, "Toronto" => 435, "Boston" => 848, 
        "Nashville" => 406, "Las Vegas" => 1526, "San Francisco" => 1835, "Washington DC" => 595,
        "Miami" => 1189, "Pittsburgh" => 409);

        if(array_key_exists("destination",$_POST)){
            $destination = $_POST["destination"];
        }
        if(isset($destination)){
            for ($i = 0; $i < sizeof($destination); $i++) {
                $dest = $destination[$i];
                if (isset($cities[$dest])) {
            $distance = $cities[$dest];
            $time = round(($distance / 60), 2);
            $walktime = round(($distance / 5), 2);
            print"The distance between Chicago and <I>$dest</I> is $distance miles.";
            print"<br>Driving at 60 miles per hour it would be take $time hours.";
            print"<br>Walking at 5 miles per hour it would take $walktime hours.";
        }
    }
}else{
        print"Sorry, do not have destination ";
    }
        ?>
    </body>
</html>