function calc(a, b, op)
{
	var res = 0;
	if(b == 0 && op == '/')
	{
		return "dividing by zero";
	}
	switch ( op )
	{
		case '+': res = a + b; break;
		case '-': res = a - b; break;
		case '*': res = a * b; break;
		case '/': res = a / b; break;
	}
	return res;
}