package org.xml.sax;

/* loaded from: source-2895416-dex2jar.jar:org/xml/sax/DTDHandler.class */
public interface DTDHandler {
    void notationDecl(String str, String str2, String str3) throws SAXException;

    void unparsedEntityDecl(String str, String str2, String str3, String str4) throws SAXException;
}
