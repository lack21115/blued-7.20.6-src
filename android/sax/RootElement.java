package android.sax;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/* loaded from: source-9557208-dex2jar.jar:android/sax/RootElement.class */
public class RootElement extends Element {
    final Handler handler;

    /* loaded from: source-9557208-dex2jar.jar:android/sax/RootElement$Handler.class */
    class Handler extends DefaultHandler {
        Locator locator;
        int depth = -1;
        Element current = null;
        StringBuilder bodyBuilder = null;

        Handler() {
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void characters(char[] cArr, int i, int i2) throws SAXException {
            if (this.bodyBuilder != null) {
                this.bodyBuilder.append(cArr, i, i2);
            }
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void endElement(String str, String str2, String str3) throws SAXException {
            Element element = this.current;
            if (this.depth == element.depth) {
                element.checkRequiredChildren(this.locator);
                if (element.endElementListener != null) {
                    element.endElementListener.end();
                }
                if (this.bodyBuilder != null) {
                    String sb = this.bodyBuilder.toString();
                    this.bodyBuilder = null;
                    element.endTextElementListener.end(sb);
                }
                this.current = element.parent;
            }
            this.depth--;
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void setDocumentLocator(Locator locator) {
            this.locator = locator;
        }

        void start(Element element, Attributes attributes) {
            this.current = element;
            if (element.startElementListener != null) {
                element.startElementListener.start(attributes);
            }
            if (element.endTextElementListener != null) {
                this.bodyBuilder = new StringBuilder();
            }
            element.resetRequiredChildren();
            element.visited = true;
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void startElement(String str, String str2, String str3, Attributes attributes) throws SAXException {
            Children children;
            Element element;
            int i = this.depth + 1;
            this.depth = i;
            if (i == 0) {
                startRoot(str, str2, attributes);
            } else if (this.bodyBuilder != null) {
                throw new BadXmlException("Encountered mixed content within text element named " + this.current + ".", this.locator);
            } else {
                if (i != this.current.depth + 1 || (children = this.current.children) == null || (element = children.get(str, str2)) == null) {
                    return;
                }
                start(element, attributes);
            }
        }

        void startRoot(String str, String str2, Attributes attributes) throws SAXException {
            RootElement rootElement = RootElement.this;
            if (rootElement.uri.compareTo(str) != 0 || rootElement.localName.compareTo(str2) != 0) {
                throw new BadXmlException("Root element name does not match. Expected: " + rootElement + ", Got: " + Element.toString(str, str2), this.locator);
            }
            start(rootElement, attributes);
        }
    }

    public RootElement(String str) {
        this("", str);
    }

    public RootElement(String str, String str2) {
        super(null, str, str2, 0);
        this.handler = new Handler();
    }

    public ContentHandler getContentHandler() {
        return this.handler;
    }
}
