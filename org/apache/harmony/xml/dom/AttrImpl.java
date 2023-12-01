package org.apache.harmony.xml.dom;

import org.w3c.dom.Attr;
import org.w3c.dom.DOMException;
import org.w3c.dom.Element;
import org.w3c.dom.TypeInfo;

/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/xml/dom/AttrImpl.class */
public final class AttrImpl extends NodeImpl implements Attr {
    boolean isId;
    String localName;
    boolean namespaceAware;
    String namespaceURI;
    ElementImpl ownerElement;
    String prefix;
    private String value;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AttrImpl(DocumentImpl documentImpl, String str) {
        super(documentImpl);
        this.value = "";
        setName(this, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AttrImpl(DocumentImpl documentImpl, String str, String str2) {
        super(documentImpl);
        this.value = "";
        setNameNS(this, str, str2);
    }

    @Override // org.apache.harmony.xml.dom.NodeImpl, org.w3c.dom.Node
    public String getLocalName() {
        if (this.namespaceAware) {
            return this.localName;
        }
        return null;
    }

    @Override // org.w3c.dom.Attr
    public String getName() {
        return this.prefix != null ? this.prefix + ":" + this.localName : this.localName;
    }

    @Override // org.apache.harmony.xml.dom.NodeImpl, org.w3c.dom.Node
    public String getNamespaceURI() {
        return this.namespaceURI;
    }

    @Override // org.apache.harmony.xml.dom.NodeImpl, org.w3c.dom.Node
    public String getNodeName() {
        return getName();
    }

    @Override // org.apache.harmony.xml.dom.NodeImpl, org.w3c.dom.Node
    public short getNodeType() {
        return (short) 2;
    }

    @Override // org.apache.harmony.xml.dom.NodeImpl, org.w3c.dom.Node
    public String getNodeValue() {
        return getValue();
    }

    @Override // org.w3c.dom.Attr
    public Element getOwnerElement() {
        return this.ownerElement;
    }

    @Override // org.apache.harmony.xml.dom.NodeImpl, org.w3c.dom.Node
    public String getPrefix() {
        return this.prefix;
    }

    @Override // org.w3c.dom.Attr
    public TypeInfo getSchemaTypeInfo() {
        return NULL_TYPE_INFO;
    }

    @Override // org.w3c.dom.Attr
    public boolean getSpecified() {
        return this.value != null;
    }

    @Override // org.w3c.dom.Attr
    public String getValue() {
        return this.value;
    }

    @Override // org.w3c.dom.Attr
    public boolean isId() {
        return this.isId;
    }

    @Override // org.apache.harmony.xml.dom.NodeImpl, org.w3c.dom.Node
    public void setPrefix(String str) {
        this.prefix = validatePrefix(str, this.namespaceAware, this.namespaceURI);
    }

    @Override // org.w3c.dom.Attr
    public void setValue(String str) throws DOMException {
        this.value = str;
    }
}
