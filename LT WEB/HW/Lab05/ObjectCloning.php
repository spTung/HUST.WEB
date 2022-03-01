<?php
class ObjectTracker {
    private static $nextSerial = 0;
    private $id;
    private $name;

    function __construct($name) {
        $this->name = $name;
        $this->id = ++self::$nextSerial;
    }

    function __clone() {
        $this->name = 'Clone of ' . $this->name;
        $this->id = ++self::$nextSerial;
    }

    function getId() {
        return $this->id;
    }

    function getName() {
        return $this->name;
    }

    function setName($name) {
        $this->name = $name;
    }
}

$ot = new ObjectTracker('Zeev\'s object');
$ot2 = new ObjectTracker('Another object');
$ot = $ot2;
// 2 Another object
// 2 Another object

print $ot->getId() . ' ' . $ot->getName() . '<br>';
print $ot2->getId() . ' ' . $ot2->getName() . '<br>';


?>