function returnHTML(xhr, type)
{
	var ret = "";
	
	switch (type)
	{
		case "HTML": ret = xhr.responseText; break;
		case "XML":  ret = xmlparse(xhr.responseText); break;
		case "Json": ret = jsonparse(xhr.responseText); break;
	}
	
	return ret;
}

function jsonparse(input)
{
	var arr = JSON.parse(input);
    var htmlText = '';
	
	for (i = 0; i < arr.length; i++) 
	{
		htmlText += "<tr><td>" 
				+ arr[i].id + "</td><td>" 
				+ arr[i].first_name + "</td><td>" 
              	+ arr[i].last_name + "</td><td>" 
              	+ arr[i].age + "</td><td>"
              	+ arr[i].street_id + "</td></tr>";
    }
	
    return htmlText;
}

function xmlparse(input)
{
	parser = new DOMParser();
	xmlDoc = parser.parseFromString(input, "text/xml");
	
    var htmlText = '';
    var id = xmlDoc.getElementsByTagName("id");
	var first_name = xmlDoc.getElementsByTagName("first_name");
	var last_name = xmlDoc.getElementsByTagName("last_name");
	var age = xmlDoc.getElementsByTagName("age");
	var street_id = xmlDoc.getElementsByTagName("street_id");
	for (i = 0; i < id.length; i++) 
	{
		htmlText += "<tr><td>" + id[i].childNodes[0].nodeValue + "</td><td>" 
				+ first_name[i].childNodes[0].nodeValue + "</td><td>" 
           		+ last_name[i].childNodes[0].nodeValue + "</td><td>" 
           		+ age[i].childNodes[0].nodeValue + "</td><td>"
           		+ street_id[i].childNodes[0].nodeValue + "</td></tr>";
	}
	
	return htmlText;
}