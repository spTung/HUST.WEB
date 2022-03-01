<?php
function user_sort($a, $b)
{
    // smarts is all-important, so sort it first
    if ($b == 'smarts') {
        return 1;
    } else if ($a == 'smarts') {
        return -1;
    }
    return ($a == $b) ? 0 : (($a < $b) ? -1 : 1);
}
$valuesOriginal = array(
    'name' => 'Buzz Lightyear',
    'email_address' => 'buzz@starcommand.gal',
    'age' => 32,
    'smarts' => 'some'
);
$values = array(
    'name' => 'Buzz Lightyear',
    'email_address' => 'buzz@starcommand.gal',
    'age' => 32,
    'smarts' => 'some'
);
$sorts = array(
    'sort' => 'Standard sort',
    'rsort' => 'Reverse sort',
    'usort' => 'User-defined sort',
    'ksort' => 'Key sort',
    'krsort' => 'Reverse key sort',
    'uksort' => 'User-defined key sort',
    'asort' => 'Value sort',
    'arsort' => 'Reverse value sort',
    'uasort' => 'User-defined value sort'
);

if (array_key_exists("submitted", $_POST)) {
    $sort_type = $_POST["sort_type"];
    $submitted = $_POST["submitted"];
} else {
    $sort_type = null;
    $submitted = null;
}

if ($submitted) {
    if ($sort_type == 'usort' || $sort_type == 'uksort' || $sort_type == 'uasort') {
        $sort_type($values, 'user_sort');
    } else {
        $sort_type($values);
    }
}
?>
<form action="UserSorting.php" method="post">
    <p>
        <?php
        foreach ($sorts as $id => $sort) {
            if ($sort_type == $id)
                printf("<input type=\"radio\" name=\"sort_type\" value=\"$id\" checked=\"checked\"/>$sort<br />");
            else
                printf("<input type=\"radio\" name=\"sort_type\" value=\"$id\" />$sort<br />");
        }
        ?>
    </p>
    <p align="center">
        <input type="submit" value="Sort" name="submitted" />
    </p>
    <table border="1" cellspacing>
        <tr>
            <td align="left">
                <p>
                    Values before sort:
                </p>
                <ul>
                    <?php
                    foreach ($valuesOriginal as $key => $value) {
                        echo "<li><b>$key</b>: $value</li>";
                    }
                    ?>
                </ul>
            </td>
            <td align="left">
                <p>
                    Values <?= $submitted ? "sorted by $sort_type" : "unsorted"; ?>:
                </p>
                <ul>
                    <?php
                    foreach ($values as $key => $value) {
                        echo "<li><b>$key</b>: $value</li>";
                    }
                    ?>
                </ul>
            </td>
        </tr>
    </table>
</form>