package org.xml.sax;

@Deprecated
/* loaded from: source-2895416-dex2jar.jar:org/xml/sax/DocumentHandler.class */
public interface DocumentHandler {
    void characters(char[] cArr, int i, int i2) throws SAXException;

    void endDocument() throws SAXException;

    void endElement(String str) throws SAXException;

    void ignorableWhitespace(char[] cArr, int i, int i2) throws SAXException;

    void processingInstruction(String str, String str2) throws SAXException;

    void setDocumentLocator(Locator locator);

    void startDocument() throws SAXException;

    void startElement(String str, AttributeList attributeList) throws SAXException;
}
