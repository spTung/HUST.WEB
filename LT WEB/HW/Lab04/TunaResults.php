<html>
<head><title>Tuna Cafe</title></head>
<body>
    <font size=4 color=blue>Tuna cafe results received</font>
    <?php
    $menu = array('tuna casserole', 'tuna sandwitch', 'tuna pie', 'grilled tuna', 'tuna suprise');

    $prefer = $_GET["prefer"];
    if(count($prefer) == 0){
        print"Oh no! Please pick something as your favorite!";
    }else{
        print"<br>Your selections were <ul>";
        foreach($prefer as $item){
            print"<li>$menu[$item]</li>";
        }
        print"</ul>";
    }
    ?>
</body>
</html>