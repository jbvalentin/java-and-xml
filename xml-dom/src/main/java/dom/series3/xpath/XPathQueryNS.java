package dom.series3.xpath;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import javax.xml.XMLConstants;
import javax.xml.namespace.NamespaceContext;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;

public class XPathQueryNS {

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
		xPath.setNamespaceContext(new NameSpaceContextImpl());
		final XPathExpression xPe = xPath.compile(xPathQuery);
		return xPe.evaluate(dom);

	}

	// In Spring: use the SimpleNamespaceContext
	public static class NameSpaceContextImpl implements NamespaceContext {

		private static final Map<String, String> NS_PREFIX_MAP = new TreeMap<>();
		static {
			NS_PREFIX_MAP.put("xhtml", "http://www.w3.org/1999/xhtml");
		}

		@Override
		public String getNamespaceURI(final String prefix) {
			if ("".equals(prefix)) {
				return XMLConstants.DEFAULT_NS_PREFIX;
			} else {
				return NS_PREFIX_MAP.get(prefix);
			}

		}

		@Override
		public String getPrefix(final String namespaceURI) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Iterator<String> getPrefixes(final String namespaceURI) {
			return NS_PREFIX_MAP.keySet().iterator();
		}

	}
}
