package nbrm;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.lang.reflect.Field;
import java.nio.charset.Charset;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import javax.xml.xquery.XQException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.sun.org.apache.bcel.internal.generic.DDIV;

import ch.ethz.mxquery.xqj.MXQueryXQDataSource;
import net.xqj.sedna.SednaXQDataSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class NbrmTest {
	public static void main(String[] args) throws DatatypeConfigurationException, XQException, IOException,
			XMLStreamException, XPathExpressionException, SAXException, NoSuchFieldException, SecurityException,
			IllegalArgumentException, IllegalAccessException, ParserConfigurationException {

		System.setProperty("file.encoding", "UTF-8");
		Field charset = Charset.class.getDeclaredField("defaultCharset");
		charset.setAccessible(true);
		charset.set(null, null);
		System.out.println("Default Charset=" + Charset.defaultCharset());
		System.setProperty("file.encoding", "Latin-1");
		System.out.println("file.encoding=" + System.getProperty("file.encoding"));
		System.out.println("Default Charset=" + Charset.defaultCharset());
		System.out.println("Default Charset in Use=" + getDefaultCharSet());

		Kurs kurs = new Kurs();
		KursSoap kSoap = kurs.getKursSoap();
		// System.out.println(kSoap.getExchangeRate("20.06.2015",
		// "26.06.2015"));
		// System.out.println(kSoap.getExchangeRates("20.06.2015",
		// "26.06.2015"));

		String xmlSource = kSoap.getExchangeRates("25.06.2015", "26.06.2015");
		// XML(xmlSource);

		parseXML(xmlSource);

	}

	private static String getDefaultCharSet() {
		OutputStreamWriter writer = new OutputStreamWriter(new ByteArrayOutputStream());
		String enc = writer.getEncoding();
		return enc;
	}

	public static String XML(String xml) {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = null;
		String message = null;
		try {
			db = dbf.newDocumentBuilder();
			InputSource is = new InputSource();
			is.setCharacterStream(new StringReader(xml));
			try {
				Document doc = db.parse(is);
				message = doc.getDocumentElement().getTextContent();
				System.out.println(message);
			} catch (SAXException e) {
				// handle SAXException
			} catch (IOException e) {
				// handle IOException
			}
		} catch (ParserConfigurationException e1) {
			// handle ParserConfigurationException
		}
		return message;
	}

	public static void parseXML(String xml) throws XQException, IOException, XMLStreamException,
			XPathExpressionException, SAXException, ParserConfigurationException {

		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = null;
		builder = builderFactory.newDocumentBuilder();

		
		Document xmlDocument = builder.parse(new ByteArrayInputStream(xml.getBytes()));
		
		XPath xPath = XPathFactory.newInstance().newXPath();

		String expression = "/dsKurs/KursZbir";
		NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(xmlDocument, XPathConstants.NODESET);
		System.out.println(expression);
		Node node = (Node) xPath.compile(expression).evaluate(xmlDocument, XPathConstants.NODE);
		NodeList nodeList1;
		for (int j = 0; j < nodeList.getLength(); j++) {
			if (nodeList != null) {
				node = nodeList.item(j);
				if (null != node) {
					nodeList1 = node.getChildNodes();
					
						Node nod = nodeList1.item(21);
						Node nod1 = nodeList1.item(11);
						Node nod2 = nodeList1.item(15);
						
							System.out.println(
									nodeList1.item(21).getNodeName() + " : " + nod.getFirstChild().getNodeValue() + " " + nodeList1.item(11).getNodeName() + " : " + nod1.getFirstChild().getNodeValue() + " " + nodeList1.item(15).getNodeName() + " : " + nod2.getFirstChild().getNodeValue());
						
				
				}
			}
		}

		// FileWriter fw = new java.io.FileWriter("my-file.xml");
		// fw.write(xml);
		// fw.close();

	}
}
