<html>
<head>
  <title> Coin Flip Results </title>
</head>

<body>
  <?php
  srand((float) microtime() * 10000000);
  $pick = $_POST['pick'];
  $flip = rand(0, 1);
  if ($flip == 0 && $pick == 0) {
    print "The flip=$flip, which is heads! <br> ";
    print '<font color="blue"> You got it right!</font>';
  } elseif ($flip == 0 && $pick == 1) {
    print "The flip=$flip, which is heads! <br> ";
    print '<font color="red"> You got it wrong!</font>';
  } elseif ($flip == 1 && $pick == 1) {
    print "The flip=$flip, which is tails! <br>";
    print '<font color="blue"> You got it right!</font>';
  } elseif ($flip == 1 && $pick == 0) {
    print "The flip=$flip, which is tails! <br>";
    print '<font color="red"> You got it wrong!</font>';
  } else {
    print "<br>Illegal state error!";
  }
  ?> </body>

</html>