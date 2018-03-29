package so46768984;

import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.xml.sax.SAXException;

public class Test {

    public static void main(String[] args) throws JAXBException, IOException, SAXException {
    	
    	// See https://stackoverflow.com/questions/46768984/how-to-marshall-xml-with-namespace-in-jaxb/46772186
        final SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = factory.newSchema(new StreamSource(Test.class.getClassLoader().getResourceAsStream("so46768984/schema.xsd")));
        //new InputSource()

        JavaBean message = new JavaBean();
        JAXBElement<JavaBean> element = new JAXBElement<>(new QName("myNamespace", "element"), JavaBean.class, message);

        JAXBContext context = JAXBContext.newInstance(JavaBean.class);
        Marshaller jaxbMarshaller = context.createMarshaller();
        jaxbMarshaller.setSchema(schema);
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jaxbMarshaller.marshal(element, System.out);
    }
}