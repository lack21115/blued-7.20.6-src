package org.apache.harmony.xml.dom;

import org.w3c.dom.Node;

/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/xml/dom/LeafNodeImpl.class */
public abstract class LeafNodeImpl extends NodeImpl {
    int index;
    InnerNodeImpl parent;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LeafNodeImpl(DocumentImpl documentImpl) {
        super(documentImpl);
    }

    @Override // org.apache.harmony.xml.dom.NodeImpl, org.w3c.dom.Node
    public Node getNextSibling() {
        if (this.parent == null || this.index + 1 >= this.parent.children.size()) {
            return null;
        }
        return this.parent.children.get(this.index + 1);
    }

    @Override // org.apache.harmony.xml.dom.NodeImpl, org.w3c.dom.Node
    public Node getParentNode() {
        return this.parent;
    }

    @Override // org.apache.harmony.xml.dom.NodeImpl, org.w3c.dom.Node
    public Node getPreviousSibling() {
        if (this.parent == null || this.index == 0) {
            return null;
        }
        return this.parent.children.get(this.index - 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isParentOf(Node node) {
        return false;
    }
}
