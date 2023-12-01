package org.apache.harmony.xml.dom;

import org.w3c.dom.DOMException;
import org.w3c.dom.DocumentType;
import org.w3c.dom.NamedNodeMap;

/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/xml/dom/DocumentTypeImpl.class */
public final class DocumentTypeImpl extends LeafNodeImpl implements DocumentType {
    private String publicId;
    private String qualifiedName;
    private String systemId;

    public DocumentTypeImpl(DocumentImpl documentImpl, String str, String str2, String str3) {
        super(documentImpl);
        if (str == null || "".equals(str)) {
            throw new DOMException((short) 14, str);
        }
        int lastIndexOf = str.lastIndexOf(":");
        if (lastIndexOf != -1) {
            String substring = str.substring(0, lastIndexOf);
            String substring2 = str.substring(lastIndexOf + 1);
            if (!DocumentImpl.isXMLIdentifier(substring)) {
                throw new DOMException((short) 14, str);
            }
            if (!DocumentImpl.isXMLIdentifier(substring2)) {
                throw new DOMException((short) 5, str);
            }
        } else if (!DocumentImpl.isXMLIdentifier(str)) {
            throw new DOMException((short) 5, str);
        }
        this.qualifiedName = str;
        this.publicId = str2;
        this.systemId = str3;
    }

    @Override // org.w3c.dom.DocumentType
    public NamedNodeMap getEntities() {
        return null;
    }

    @Override // org.w3c.dom.DocumentType
    public String getInternalSubset() {
        return null;
    }

    @Override // org.w3c.dom.DocumentType
    public String getName() {
        return this.qualifiedName;
    }

    @Override // org.apache.harmony.xml.dom.NodeImpl, org.w3c.dom.Node
    public String getNodeName() {
        return this.qualifiedName;
    }

    @Override // org.apache.harmony.xml.dom.NodeImpl, org.w3c.dom.Node
    public short getNodeType() {
        return (short) 10;
    }

    @Override // org.w3c.dom.DocumentType
    public NamedNodeMap getNotations() {
        return null;
    }

    @Override // org.w3c.dom.DocumentType
    public String getPublicId() {
        return this.publicId;
    }

    @Override // org.w3c.dom.DocumentType
    public String getSystemId() {
        return this.systemId;
    }

    @Override // org.apache.harmony.xml.dom.NodeImpl, org.w3c.dom.Node
    public String getTextContent() throws DOMException {
        return null;
    }
}
