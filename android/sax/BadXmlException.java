package android.sax;

import org.xml.sax.Locator;
import org.xml.sax.SAXParseException;

/* loaded from: source-9557208-dex2jar.jar:android/sax/BadXmlException.class */
class BadXmlException extends SAXParseException {
    public BadXmlException(String str, Locator locator) {
        super(str, locator);
    }

    @Override // org.xml.sax.SAXException, java.lang.Throwable
    public String getMessage() {
        return "Line " + getLineNumber() + ": " + super.getMessage();
    }
}
