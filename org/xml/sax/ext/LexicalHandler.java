package org.xml.sax.ext;

import org.xml.sax.SAXException;

/* loaded from: source-2895416-dex2jar.jar:org/xml/sax/ext/LexicalHandler.class */
public interface LexicalHandler {
    void comment(char[] cArr, int i, int i2) throws SAXException;

    void endCDATA() throws SAXException;

    void endDTD() throws SAXException;

    void endEntity(String str) throws SAXException;

    void startCDATA() throws SAXException;

    void startDTD(String str, String str2, String str3) throws SAXException;

    void startEntity(String str) throws SAXException;
}
