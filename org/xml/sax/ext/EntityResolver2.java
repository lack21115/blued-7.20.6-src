package org.xml.sax.ext;

import java.io.IOException;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/* loaded from: source-2895416-dex2jar.jar:org/xml/sax/ext/EntityResolver2.class */
public interface EntityResolver2 extends EntityResolver {
    InputSource getExternalSubset(String str, String str2) throws SAXException, IOException;

    InputSource resolveEntity(String str, String str2, String str3, String str4) throws SAXException, IOException;
}
