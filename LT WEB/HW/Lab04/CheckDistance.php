<!doctype html>
<html>
	<head>
		<title>Distance and Time Calculations</title>
	</head>

	<body>
		<?php
			$cities = array('Dallas' => 803,'Toronto' => 435, 'Boston' => 848,'Nashville' => 406, 'Las Vegas' => 1526,
			'San Francisco' => 1835, 'Washington, DC' => 595, 'Miami' => 1189, 'Pittsburgh' => 409);
			if(array_key_exists("destination",$_POST)){
				$destination = $_POST["destination"];
			}

			function calDriveTime ($city, $dest) {
				return round( ($city[$dest] / 60) , 2 );
			}

			function calWalkTime ($city, $dest) {
				return round( ($city[$dest] / 5) , 2 );
			}
		?>

		<font>Distance Chicago to: <br></font>
		<table border=1>
			<thead>
				<th>No.</th>
				<th>Destination</th>
				<th>Distance</th>
				<th>Driving time</th>
				<th>Walking time</th>
			</thead>
			<?php
				if (isset($destination)) {
					for ($i = 0; $i < sizeof($destination); $i++) {
						$dest = $destination[$i];
						print "<tr><td>" . $i+1 . "</td>";
						if (isset($cities[$dest])) {
							print "<td>$dest</td>";
							print "<td>$cities[$dest]km</td>";
							print "<td>" . calDriveTime($cities, $dest) . "h</td>";
							print "<td>" . calWalkTime($cities, $dest) . "h</td></tr>";
						}				
					}
				} else {
					print "<tr><td colspan=5>No city selected!</td></tr>";
				}
			?>
		</table>
	</body>
</html>