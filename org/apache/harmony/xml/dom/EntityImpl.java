package org.apache.harmony.xml.dom;

import org.w3c.dom.Entity;

/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/xml/dom/EntityImpl.class */
public class EntityImpl extends NodeImpl implements Entity {
    private String notationName;
    private String publicID;
    private String systemID;

    EntityImpl(DocumentImpl documentImpl, String str, String str2, String str3) {
        super(documentImpl);
        this.notationName = str;
        this.publicID = str2;
        this.systemID = str3;
    }

    @Override // org.w3c.dom.Entity
    public String getInputEncoding() {
        throw new UnsupportedOperationException();
    }

    @Override // org.apache.harmony.xml.dom.NodeImpl, org.w3c.dom.Node
    public String getNodeName() {
        return getNotationName();
    }

    @Override // org.apache.harmony.xml.dom.NodeImpl, org.w3c.dom.Node
    public short getNodeType() {
        return (short) 6;
    }

    @Override // org.w3c.dom.Entity
    public String getNotationName() {
        return this.notationName;
    }

    @Override // org.w3c.dom.Entity
    public String getPublicId() {
        return this.publicID;
    }

    @Override // org.w3c.dom.Entity
    public String getSystemId() {
        return this.systemID;
    }

    @Override // org.w3c.dom.Entity
    public String getXmlEncoding() {
        throw new UnsupportedOperationException();
    }

    @Override // org.w3c.dom.Entity
    public String getXmlVersion() {
        throw new UnsupportedOperationException();
    }
}
