package app.util;

import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import app.entity.VkUser;

public class URLHelper {
	public static VkUser parseVkUser(String urlText) {
		try {
			URL url = new URL(urlText);
			
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(url.openStream());
			NodeList nodes = doc.getElementsByTagName("row");
			System.out.println(nodes.getLength() + " nodes found");

			return null;
		} catch (Exception e) {
			//TODO Implement logging
			e.printStackTrace();
			return null;
		}
	}
}
