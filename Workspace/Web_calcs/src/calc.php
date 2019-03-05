<?php
	$a = $_GET['aNum'];
	$b = $_GET['bNum'];
	$op = $_GET['op'];
	
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