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
		$id = $_POST['id'];
		$first_name = $_POST['first_name'];
		$last_name = $_POST['last_name'];
		$age = $_POST['age'];
		$street_id = $_POST['street_id'];
		$op = $_POST['id'];
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
                $tab .= "<tr><td>".$row["id"]."</td><td>".$row["first_name"]."</td><td>".$row["last_name"]."</td><td>".$row['age']."</td><td>".$row['street_id']."</td></tr>";;
            }
        }
        $conn->close();
        return $tab;
    }
?>