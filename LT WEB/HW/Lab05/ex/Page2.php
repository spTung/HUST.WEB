<?php 
    require 'Page.php';
    $secondPage = new Page('About Bill Gates', date('Y'), 'Tuan');
    $secondPage->addContent("<style>
        .footer{
            position: fixed;
            left: 0;
            bottom: 10px;
            width: 100%;
            color: black;
            text-align: center;
            }
    </style>");
    $secondPage->addContent("<p>
    William Henry Gates III (born October 28, 1955) is an American business magnate,
    software developer, investor, author, and philanthropist. He is a co-founder of Microsoft,
    along with his late childhood friend Paul Allen.[2][3] During his career at Microsoft, 
    Gates held the positions of chairman, chief executive officer (CEO), president and chief software architect,
    while also being the largest individual shareholder until May 2014.
    [4] He is considered one of the best known entrepreneurs of the microcomputer revolution of the 1970s and 1980s.<br>
    Gates was born and raised in Seattle, Washington.
    In 1975, he and Allen founded Microsoft in Albuquerque, New Mexico.
    It became the world's largest personal computer software company.
    [5][a] Gates led the company as chairman and CEO until stepping down as CEO in January 2000, 
    succeeded by Steve Ballmer, but he remained chairman of the board of directors and became chief software architect.
    [8] During the late 1990s, he was criticized for his business tactics, which have been considered anti-competitive.
    </p>");
    echo $secondPage->get();
?>