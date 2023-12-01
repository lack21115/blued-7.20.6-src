package org.xml.sax;

import java.io.IOException;

/* loaded from: source-2895416-dex2jar.jar:org/xml/sax/EntityResolver.class */
public interface EntityResolver {
    InputSource resolveEntity(String str, String str2) throws SAXException, IOException;
}
