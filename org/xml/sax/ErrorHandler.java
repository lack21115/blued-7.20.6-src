package org.xml.sax;

/* loaded from: source-2895416-dex2jar.jar:org/xml/sax/ErrorHandler.class */
public interface ErrorHandler {
    void error(SAXParseException sAXParseException) throws SAXException;

    void fatalError(SAXParseException sAXParseException) throws SAXException;

    void warning(SAXParseException sAXParseException) throws SAXException;
}
