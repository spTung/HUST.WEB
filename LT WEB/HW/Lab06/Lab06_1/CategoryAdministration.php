<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Table Output</title>
    <style>
        th {
            background-color: lightgray;
        }
    </style>
</head>
<body>
    <?php
        $host = 'localhost:3306';
        $user = 'root';
        $password = '';
        $database = 'business_service';
        $connect = mysqli_connect($host, $user, $password);
        $table_name = 'categories';

        mysqli_select_db($connect,$database);

        if (isset($_POST["CatID"]) && isset($_POST["Title"]) && isset($_POST["Desc"])) {
            echo"1";
            $categoryID = $_POST["CatID"];
            $title = $_POST["Title"];
            $description = $_POST["Desc"];
            $insertquery =  "Insert into $table_name values('$categoryID','$title', '$description');";

            $connect->query($insertquery);
        }
   
        print '<font size="5">';
        print "Category Administration</font><br>";

        $query = "SELECT * FROM $table_name";
        $results_id = mysqli_query($connect,$query);
            
        if ($results_id) {
            print '<form action="" method="post">';
            print '<table border=1 style="width:100%">';
            print '<th style="width:10%">CatID<th>Title<th>Description';
                
            while ($row = mysqli_fetch_row($results_id)) {
                print '<tr>';
                foreach ($row as $field) {
                    print "<td>$field</td> ";
                }
                print '</tr>';
            }
                
            print '<tr>';
            print '<td><input type="text" style="width:100%" name="CatID"></td>';
            print '<td><input type="text" style="width:100%" name="Title"></td>';
            print '<td><input type="text" style="width:100%" name="Desc"></td>';
            print '</tr>';
            print '</table>';
            print '<input type="submit" value="Add Category">';
            print '</form>';
        } else {
            die("Query=$query failed!");
        }
            
        mysqli_close($connect);
    ?>
</body>
</html>