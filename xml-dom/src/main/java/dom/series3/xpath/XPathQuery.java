package dom.series3.xpath;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;

public class XPathQuery {
	/**
	 * Apply a simple XPath - return a string result.
	 *
	 * @param xPathQuery
	 * @param dom
	 * @return
	 * @throws XPathExpressionException
	 */
	public String performSimpleXPathQueryOnDom(final String xPathQuery, final Document dom)
			throws XPathExpressionException {
		final XPathFactory factory = XPathFactory.newInstance();
		final XPath xPath = factory.newXPath();
		final XPathExpression xPe = xPath.compile(xPathQuery);
		return xPe.evaluate(dom);

	}

}
