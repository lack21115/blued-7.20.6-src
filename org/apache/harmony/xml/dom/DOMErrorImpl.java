package org.apache.harmony.xml.dom;

import org.w3c.dom.DOMError;
import org.w3c.dom.DOMLocator;
import org.w3c.dom.Node;

/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/xml/dom/DOMErrorImpl.class */
public final class DOMErrorImpl implements DOMError {
    private static final DOMLocator NULL_DOM_LOCATOR = new DOMLocator() { // from class: org.apache.harmony.xml.dom.DOMErrorImpl.1
        @Override // org.w3c.dom.DOMLocator
        public int getByteOffset() {
            return -1;
        }

        @Override // org.w3c.dom.DOMLocator
        public int getColumnNumber() {
            return -1;
        }

        @Override // org.w3c.dom.DOMLocator
        public int getLineNumber() {
            return -1;
        }

        @Override // org.w3c.dom.DOMLocator
        public Node getRelatedNode() {
            return null;
        }

        @Override // org.w3c.dom.DOMLocator
        public String getUri() {
            return null;
        }

        @Override // org.w3c.dom.DOMLocator
        public int getUtf16Offset() {
            return -1;
        }
    };
    private final short severity;
    private final String type;

    public DOMErrorImpl(short s, String str) {
        this.severity = s;
        this.type = str;
    }

    @Override // org.w3c.dom.DOMError
    public DOMLocator getLocation() {
        return NULL_DOM_LOCATOR;
    }

    @Override // org.w3c.dom.DOMError
    public String getMessage() {
        return this.type;
    }

    @Override // org.w3c.dom.DOMError
    public Object getRelatedData() {
        return null;
    }

    @Override // org.w3c.dom.DOMError
    public Object getRelatedException() {
        return null;
    }

    @Override // org.w3c.dom.DOMError
    public short getSeverity() {
        return this.severity;
    }

    @Override // org.w3c.dom.DOMError
    public String getType() {
        return this.type;
    }
}
