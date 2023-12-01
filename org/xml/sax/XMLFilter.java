package org.xml.sax;

/* loaded from: source-2895416-dex2jar.jar:org/xml/sax/XMLFilter.class */
public interface XMLFilter extends XMLReader {
    XMLReader getParent();

    void setParent(XMLReader xMLReader);
}
