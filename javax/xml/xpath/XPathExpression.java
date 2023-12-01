package javax.xml.xpath;

import javax.xml.namespace.QName;
import org.xml.sax.InputSource;

/* loaded from: source-2895416-dex2jar.jar:javax/xml/xpath/XPathExpression.class */
public interface XPathExpression {
    Object evaluate(Object obj, QName qName) throws XPathExpressionException;

    Object evaluate(InputSource inputSource, QName qName) throws XPathExpressionException;

    String evaluate(Object obj) throws XPathExpressionException;

    String evaluate(InputSource inputSource) throws XPathExpressionException;
}
