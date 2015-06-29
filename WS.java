package mk.nbrm.klservice;

import java.io.IOException;
import java.io.StringReader;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class WS  {

	public static void main(String[] args) throws DatatypeConfigurationException {		
		Kurs kurs = new Kurs();
		KursSoap kSoap = kurs.getKursSoap();
		System.out.println(kSoap.getExchangeRate("20.06.2015", "26.06.2015"));
		System.out.println(kSoap.getExchangeRates("20.06.2015", "26.06.2015"));
	
		String xmlSource = kSoap.getExchangeRates("25.06.2015", "26.06.2015");
		XML(xmlSource);
		
		
		GetExchangeRatesD getExchangeRatesD = new GetExchangeRatesD();
		Date d = new Date();
		System.out.println(d.getDate());
		GregorianCalendar c = new GregorianCalendar();
		c.setTime(d);
		XMLGregorianCalendar date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);

		
		System.out.println(kSoap.getExchangeRateD(date2, date2));
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
	
}
