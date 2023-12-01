package org.apache.harmony.xml.dom;

import org.w3c.dom.EntityReference;

/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/xml/dom/EntityReferenceImpl.class */
public class EntityReferenceImpl extends LeafNodeImpl implements EntityReference {
    private String name;

    /* JADX INFO: Access modifiers changed from: package-private */
    public EntityReferenceImpl(DocumentImpl documentImpl, String str) {
        super(documentImpl);
        this.name = str;
    }

    @Override // org.apache.harmony.xml.dom.NodeImpl, org.w3c.dom.Node
    public String getNodeName() {
        return this.name;
    }

    @Override // org.apache.harmony.xml.dom.NodeImpl, org.w3c.dom.Node
    public short getNodeType() {
        return (short) 5;
    }
}
