<?php 
    require 'Page.php';
    $firstPage = new Page('Greetings', date('Y'), 'Tuan');
    $firstPage->addContent("
        <div>
        Xin chao<br>
        Hello<br>
        こんにちは<br>
        你好<br>
        ආයුබෝවන්<br>
        สวัสดี<br>
        Hola<br>
        Ahoj<br>
        Bonjour<br>
        </div>");
    echo $firstPage->get();
?>