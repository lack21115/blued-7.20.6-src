package org.apache.harmony.xml.parsers;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/xml/parsers/DocumentBuilderFactoryImpl.class */
public class DocumentBuilderFactoryImpl extends DocumentBuilderFactory {
    private static final String NAMESPACES = "http://xml.org/sax/features/namespaces";
    private static final String VALIDATION = "http://xml.org/sax/features/validation";

    @Override // javax.xml.parsers.DocumentBuilderFactory
    public Object getAttribute(String str) throws IllegalArgumentException {
        throw new IllegalArgumentException(str);
    }

    @Override // javax.xml.parsers.DocumentBuilderFactory
    public boolean getFeature(String str) throws ParserConfigurationException {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        if (NAMESPACES.equals(str)) {
            return isNamespaceAware();
        }
        if (VALIDATION.equals(str)) {
            return isValidating();
        }
        throw new ParserConfigurationException(str);
    }

    @Override // javax.xml.parsers.DocumentBuilderFactory
    public DocumentBuilder newDocumentBuilder() throws ParserConfigurationException {
        if (isValidating()) {
            throw new ParserConfigurationException("No validating DocumentBuilder implementation available");
        }
        DocumentBuilderImpl documentBuilderImpl = new DocumentBuilderImpl();
        documentBuilderImpl.setCoalescing(isCoalescing());
        documentBuilderImpl.setIgnoreComments(isIgnoringComments());
        documentBuilderImpl.setIgnoreElementContentWhitespace(isIgnoringElementContentWhitespace());
        documentBuilderImpl.setNamespaceAware(isNamespaceAware());
        return documentBuilderImpl;
    }

    @Override // javax.xml.parsers.DocumentBuilderFactory
    public void setAttribute(String str, Object obj) throws IllegalArgumentException {
        throw new IllegalArgumentException(str);
    }

    @Override // javax.xml.parsers.DocumentBuilderFactory
    public void setFeature(String str, boolean z) throws ParserConfigurationException {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        if (NAMESPACES.equals(str)) {
            setNamespaceAware(z);
        } else if (!VALIDATION.equals(str)) {
            throw new ParserConfigurationException(str);
        } else {
            setValidating(z);
        }
    }
}
