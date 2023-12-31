package org.xml.sax;

import java.io.IOException;
import java.util.Locale;

@Deprecated
/* loaded from: source-2895416-dex2jar.jar:org/xml/sax/Parser.class */
public interface Parser {
    void parse(String str) throws SAXException, IOException;

    void parse(InputSource inputSource) throws SAXException, IOException;

    void setDTDHandler(DTDHandler dTDHandler);

    void setDocumentHandler(DocumentHandler documentHandler);

    void setEntityResolver(EntityResolver entityResolver);

    void setErrorHandler(ErrorHandler errorHandler);

    void setLocale(Locale locale) throws SAXException;
}
