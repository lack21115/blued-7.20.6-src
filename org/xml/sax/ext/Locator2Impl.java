package org.xml.sax.ext;

import org.xml.sax.Locator;
import org.xml.sax.helpers.LocatorImpl;

/* loaded from: source-2895416-dex2jar.jar:org/xml/sax/ext/Locator2Impl.class */
public class Locator2Impl extends LocatorImpl implements Locator2 {
    private String encoding;
    private String version;

    public Locator2Impl() {
    }

    public Locator2Impl(Locator locator) {
        super(locator);
        if (locator instanceof Locator2) {
            Locator2 locator2 = (Locator2) locator;
            this.version = locator2.getXMLVersion();
            this.encoding = locator2.getEncoding();
        }
    }

    @Override // org.xml.sax.ext.Locator2
    public String getEncoding() {
        return this.encoding;
    }

    @Override // org.xml.sax.ext.Locator2
    public String getXMLVersion() {
        return this.version;
    }

    public void setEncoding(String str) {
        this.encoding = str;
    }

    public void setXMLVersion(String str) {
        this.version = str;
    }
}
