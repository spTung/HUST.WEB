<?php
if (isset($_REQUEST["LinkTo"], $_POST["UserName"], $_POST["Password"])) {
    $linkTo = $_REQUEST["LinkTo"];
    $userName = $_POST["UserName"];
    $password = $_POST["Password"];
} else {
    $linkTo = "";
    $userName = "";
    $password = "";
}


if (isset($userName)) {
    $host = 'localhost';
    $user = 'root';
    $passwd = '';
    $database = 'lab12';
    $table_name = 'users';
    $query = "SELECT * FROM $table_name WHERE username = '$userName' AND password = '$password'";
    $connect = mysqli_connect($host, $user, $passwd, $database);

    if ($connect) {
        $res = mysqli_query($connect, $query);

        $row = mysqli_fetch_row($res);
        if ($res && $row) {
            if ($linkTo != "") {
                header("Location: " . $linkTo);
//                => The role of linkTo is just to make the form appear again if user enter invalid account
            } else {
                header("Location: https://www.youtube.com/");
                exit();
            }
        }
    }
}
?>


<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>
            Input please
        </title>
        <script >
            function fCommit() {
                if (document.frmLogin.UserName.value == "") {
                    alert("Username must be entered!");
                    document.frmLogin.UserName.focus();
                    return false;
                }

                return true;
            }

            function fReset() {
                document.frmLogin.UserName.value = "";
                document.frmLogin.Password.value = "";
                document.frmLogin.UserName.focus();
            }
        </script>

        <!--EXTERNAL DOCUMENTS--> 
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    </head>
    <body>

    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

    <br>
    <br>
            <form role="form" method="post" action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]);?>" name="frmLogin" onsubmit="return fCommit();>
            <div class="card">
                <div class="card-header">
                    <h4>Welcome</h4>
                </div>
                <div class="card-body">
                    <div class="form-group row">

                    <label for="username" class="col-sm-2 col-form-label">User Name</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="login" name="UserName" placeholder="Username" value="<?php echo $userName ?>">
                        <input type="hidden" name="LinkTo" value="<?php echo $linkTo ?>">
                    </div>
                    </div>
                    <div class="form-group row">
                    <label for="password" class="col-sm-2 col-form-label">Password</label>
                    <div class="col-sm-10">
                        <input type="password" class="form-control" id="password" name="Password" placeholder="Password">
                    </div>
                    </div>
                    <div class="form-group row">
                    <div class="offset-sm-2 col-sm-10">
                        <input type="submit" value="Sign in" name="submit" class="btn btn-primary"/>
                        <input type="reset" value="Reset" name="reset" class="btn btn-primary" onclick="fReset();">
                    </div>
                    </div>
                </div>
                </div>
            </form>

                        <!--Handle the case username is entered but invalid account-->
                        <?php
                        if (isset($userName) && !$row) {
                            echo '
                                <div class="alert alert-danger" style="margin: 10px;">
                                    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                                    Invalid name and/or password!
                                </div>
                                ';
                        }
                        mysqli_free_result($res);
                        mysqli_close($connect);
                        ?>
            <script type="text/javascript">
                docmument.frmLogin.UserName.focus();
            </script>
        </div>
    </body>
</html>
