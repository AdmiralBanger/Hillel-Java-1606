<?php
	$id   = '';
    $first_name = '';
    $last_name = '';
    $age   = '';
	$street_id = '';
    $op = '';
    $res   = '';
	
	if (isset($_POST['id']))
	{
		$jsonText = $_POST['Data'];
        $decodedText = html_entity_decode($jsonText);
        $arr = json_decode($decodedText, true);
        		
		$id = $arr[0]['id'];
        $first_name = $arr[0]['first_name'];
        $last_name = $arr[0]['last_name'];
        $age = $arr[0]['age'];
        $street_id = $arr[0]['street_id'];
        $op = $arr[0]['oper'];
    }
    
    switch ($op)
    {
        case ('create'): 	create($id, $first_name, $last_name, $age, $street_id); break;
        case ('read'): 		$res = read(); break;
        case ('update'): 	update($id, $first_name, $last_name, $age, $street_id); break;
        case ('delete'): 	del($id); break;
    }

    echo $res;

    function create($id, $first_name, $last_name, $age, $street_id)
    {
        $conn = new mysqli("localhost", "root", "", "person");
        $conn->query("INSERT INTO Person VALUES (" . $id . ", \"" . $first_name . "\", \"" . $last_name . "\", " . $age . ", " . $street_id . ")");
        $conn->close();
    }

    function update($id, $first_name, $last_name, $age, $street_id)
    {
        $conn = new mysqli("localhost", "root", "", "person");
        $conn->query("UPDATE Person SET first_name=\"" . $first_name . "\", last_name=\"" . $last_name . "\", age=" . $age . ", street_id=" . $street_id . " WHERE id=" . $id);
        $conn->close();
    }

    function del($id)
    {
        $conn = new mysqli("localhost", "root", "", "person");
		$conn->query("DELETE from Person WHERE id=" . $id);
        $conn->close();
    }
	
	function read()
    {
		$tab = "[";
        $conn = new mysqli("localhost", "root", "", "person");
        $result = $conn->query("SELECT * from Person");
        if ($result->num_rows > 0)
        {
            while($row = $result->fetch_assoc()) 
            {
                if ($tab != "[")
					{
						$tab .= ",";
					}
					$tab .= '{"id":"'  . $row["id"] . '",';
					$tab .= '"first_name":"'. $row["first_name"] . '",';
					$tab .= '"last_name":"'. $row["last_name"] . '",';
					$tab .= '"age":"'. $row["age"] . '"}';
					$tab .= '"street_id":"'. $row["street_id"] . '"}';
            }
        }
		$tab .="]";
        $conn->close();
        return $tab;
    }
?>