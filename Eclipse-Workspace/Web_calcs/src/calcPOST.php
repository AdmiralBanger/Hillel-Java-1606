<?php
	$a = $_POST['aNum'];
	$b = $_POST['bNum'];
	$op = $_POST['op'];
	
	$res = 0;
	
	switch ( $op )
	{
		case "plus": $res = $a + $b; break;
		case '-': $res = $a - $b; break;
		case '*': $res = $a * $b; break;
		case '/': $res = $a / $b; break;
	}
	
	echo $res;
?>