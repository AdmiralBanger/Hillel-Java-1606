package savers;

import java.io.File;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import org.w3c.dom.*;

import logic.Person;

public class saveXML 
{
	public static void save(ArrayList<Person> pp)
	{
		try
		{
			String userDir = System.getProperty("user.home");
			JFileChooser fc = new JFileChooser(userDir + "/Desktop");
			if (fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION)
			{
				File file = new File(fc.getSelectedFile().getPath() + ".xml");
			
				TransformerFactory transformerFactory = TransformerFactory.newInstance();
				Transformer transformer = transformerFactory.newTransformer();
				
				DOMSource source = new DOMSource(createPersonTree(pp));
				StreamResult result = new StreamResult(file);
				
				transformer.transform(source, result);
			}
		}
		catch (TransformerException | ParserConfigurationException e) 
		{
			e.printStackTrace();
		}
	}
	
	public static Document createPersonTree(ArrayList<Person> pp) throws ParserConfigurationException
	{
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		Document doc = docBuilder.newDocument();
		//root
		Element rootElement = doc.createElement("Table");
		doc.appendChild(rootElement);
		
		for (Person p : pp)
		{
			//person id
			Element personElement = doc.createElement("Person");
			rootElement.appendChild(personElement);
			personElement.setAttribute("id", Integer.toString(p.id));
			
			//first name
			Element firstname = doc.createElement("first_name");
			firstname.appendChild(doc.createTextNode(p.first_name));
			personElement.appendChild(firstname);

			//last name
			Element lastname = doc.createElement("last_name");
			lastname.appendChild(doc.createTextNode(p.last_name));
			personElement.appendChild(lastname);

			//age
			Element nickname = doc.createElement("age");
			nickname.appendChild(doc.createTextNode(Integer.toString(p.age)));
			personElement.appendChild(nickname);

			//street id
			Element salary = doc.createElement("street_id");
			salary.appendChild(doc.createTextNode(Integer.toString(p.street_id)));
			personElement.appendChild(salary);
		}
		return doc;
	}

}
