package org.apache.harmony.xml.dom;

import com.android.internal.telephony.PhoneConstants;
import java.util.ArrayList;
import java.util.List;
import libcore.util.Objects;
import org.w3c.dom.DOMException;
import org.w3c.dom.DocumentFragment;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/xml/dom/InnerNodeImpl.class */
public abstract class InnerNodeImpl extends LeafNodeImpl {
    List<LeafNodeImpl> children;

    /* JADX INFO: Access modifiers changed from: protected */
    public InnerNodeImpl(DocumentImpl documentImpl) {
        super(documentImpl);
        this.children = new ArrayList();
    }

    private static boolean matchesNameOrWildcard(String str, String str2) {
        return PhoneConstants.APN_TYPE_ALL.equals(str) || Objects.equal(str, str2);
    }

    private void refreshIndices(int i) {
        while (i < this.children.size()) {
            this.children.get(i).index = i;
            i++;
        }
    }

    @Override // org.apache.harmony.xml.dom.NodeImpl, org.w3c.dom.Node
    public Node appendChild(Node node) throws DOMException {
        return insertChildAt(node, this.children.size());
    }

    @Override // org.apache.harmony.xml.dom.NodeImpl, org.w3c.dom.Node
    public NodeList getChildNodes() {
        NodeListImpl nodeListImpl = new NodeListImpl();
        for (LeafNodeImpl leafNodeImpl : this.children) {
            nodeListImpl.add(leafNodeImpl);
        }
        return nodeListImpl;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void getElementsByTagName(NodeListImpl nodeListImpl, String str) {
        for (LeafNodeImpl leafNodeImpl : this.children) {
            if (leafNodeImpl.getNodeType() == 1) {
                ElementImpl elementImpl = (ElementImpl) leafNodeImpl;
                if (matchesNameOrWildcard(str, elementImpl.getNodeName())) {
                    nodeListImpl.add(elementImpl);
                }
                elementImpl.getElementsByTagName(nodeListImpl, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void getElementsByTagNameNS(NodeListImpl nodeListImpl, String str, String str2) {
        for (LeafNodeImpl leafNodeImpl : this.children) {
            if (leafNodeImpl.getNodeType() == 1) {
                ElementImpl elementImpl = (ElementImpl) leafNodeImpl;
                if (matchesNameOrWildcard(str, elementImpl.getNamespaceURI()) && matchesNameOrWildcard(str2, elementImpl.getLocalName())) {
                    nodeListImpl.add(elementImpl);
                }
                elementImpl.getElementsByTagNameNS(nodeListImpl, str, str2);
            }
        }
    }

    @Override // org.apache.harmony.xml.dom.NodeImpl, org.w3c.dom.Node
    public Node getFirstChild() {
        if (this.children.isEmpty()) {
            return null;
        }
        return this.children.get(0);
    }

    @Override // org.apache.harmony.xml.dom.NodeImpl, org.w3c.dom.Node
    public Node getLastChild() {
        if (this.children.isEmpty()) {
            return null;
        }
        return this.children.get(this.children.size() - 1);
    }

    @Override // org.apache.harmony.xml.dom.LeafNodeImpl, org.apache.harmony.xml.dom.NodeImpl, org.w3c.dom.Node
    public Node getNextSibling() {
        if (this.parent == null || this.index + 1 >= this.parent.children.size()) {
            return null;
        }
        return this.parent.children.get(this.index + 1);
    }

    @Override // org.apache.harmony.xml.dom.NodeImpl, org.w3c.dom.Node
    public String getTextContent() throws DOMException {
        Node firstChild = getFirstChild();
        if (firstChild == null) {
            return "";
        }
        if (firstChild.getNextSibling() == null) {
            return hasTextContent(firstChild) ? firstChild.getTextContent() : "";
        }
        StringBuilder sb = new StringBuilder();
        getTextContent(sb);
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.apache.harmony.xml.dom.NodeImpl
    public void getTextContent(StringBuilder sb) throws DOMException {
        Node firstChild = getFirstChild();
        while (true) {
            Node node = firstChild;
            if (node == null) {
                return;
            }
            if (hasTextContent(node)) {
                ((NodeImpl) node).getTextContent(sb);
            }
            firstChild = node.getNextSibling();
        }
    }

    @Override // org.apache.harmony.xml.dom.NodeImpl, org.w3c.dom.Node
    public boolean hasChildNodes() {
        return this.children.size() != 0;
    }

    final boolean hasTextContent(Node node) {
        return (node.getNodeType() == 8 || node.getNodeType() == 7) ? false : true;
    }

    @Override // org.apache.harmony.xml.dom.NodeImpl, org.w3c.dom.Node
    public Node insertBefore(Node node, Node node2) throws DOMException {
        LeafNodeImpl leafNodeImpl = (LeafNodeImpl) node2;
        if (leafNodeImpl == null) {
            return appendChild(node);
        }
        if (leafNodeImpl.document != this.document) {
            throw new DOMException((short) 4, null);
        }
        if (leafNodeImpl.parent != this) {
            throw new DOMException((short) 3, null);
        }
        return insertChildAt(node, leafNodeImpl.index);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Node insertChildAt(Node node, int i) throws DOMException {
        if (node instanceof DocumentFragment) {
            NodeList childNodes = node.getChildNodes();
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= childNodes.getLength()) {
                    break;
                }
                insertChildAt(childNodes.item(i3), i + i3);
                i2 = i3 + 1;
            }
        } else {
            LeafNodeImpl leafNodeImpl = (LeafNodeImpl) node;
            if (leafNodeImpl.document != null && this.document != null && leafNodeImpl.document != this.document) {
                throw new DOMException((short) 4, null);
            }
            if (leafNodeImpl.isParentOf(this)) {
                throw new DOMException((short) 3, null);
            }
            if (leafNodeImpl.parent != null) {
                int i4 = leafNodeImpl.index;
                leafNodeImpl.parent.children.remove(i4);
                leafNodeImpl.parent.refreshIndices(i4);
            }
            this.children.add(i, leafNodeImpl);
            leafNodeImpl.parent = this;
            refreshIndices(i);
        }
        return node;
    }

    @Override // org.apache.harmony.xml.dom.LeafNodeImpl
    public boolean isParentOf(Node node) {
        LeafNodeImpl leafNodeImpl = (LeafNodeImpl) node;
        while (true) {
            LeafNodeImpl leafNodeImpl2 = leafNodeImpl;
            if (leafNodeImpl2 == null) {
                return false;
            }
            if (leafNodeImpl2 == this) {
                return true;
            }
            leafNodeImpl = leafNodeImpl2.parent;
        }
    }

    @Override // org.apache.harmony.xml.dom.NodeImpl, org.w3c.dom.Node
    public final void normalize() {
        Node firstChild = getFirstChild();
        while (true) {
            Node node = firstChild;
            if (node == null) {
                return;
            }
            Node nextSibling = node.getNextSibling();
            node.normalize();
            if (node.getNodeType() == 3) {
                ((TextImpl) node).minimize();
            }
            firstChild = nextSibling;
        }
    }

    @Override // org.apache.harmony.xml.dom.NodeImpl, org.w3c.dom.Node
    public Node removeChild(Node node) throws DOMException {
        LeafNodeImpl leafNodeImpl = (LeafNodeImpl) node;
        if (leafNodeImpl.document != this.document) {
            throw new DOMException((short) 4, null);
        }
        if (leafNodeImpl.parent != this) {
            throw new DOMException((short) 3, null);
        }
        int i = leafNodeImpl.index;
        this.children.remove(i);
        leafNodeImpl.parent = null;
        refreshIndices(i);
        return node;
    }

    @Override // org.apache.harmony.xml.dom.NodeImpl, org.w3c.dom.Node
    public Node replaceChild(Node node, Node node2) throws DOMException {
        int i = ((LeafNodeImpl) node2).index;
        removeChild(node2);
        insertChildAt(node, i);
        return node2;
    }
}
