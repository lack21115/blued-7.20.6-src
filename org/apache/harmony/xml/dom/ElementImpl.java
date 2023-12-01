package org.apache.harmony.xml.dom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import libcore.util.Objects;
import org.w3c.dom.Attr;
import org.w3c.dom.DOMException;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.TypeInfo;

/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/xml/dom/ElementImpl.class */
public class ElementImpl extends InnerNodeImpl implements Element {
    private List<AttrImpl> attributes;
    String localName;
    boolean namespaceAware;
    String namespaceURI;
    String prefix;

    /* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/xml/dom/ElementImpl$ElementAttrNamedNodeMapImpl.class */
    public class ElementAttrNamedNodeMapImpl implements NamedNodeMap {
        public ElementAttrNamedNodeMapImpl() {
        }

        private int indexOfItem(String str) {
            return ElementImpl.this.indexOfAttribute(str);
        }

        private int indexOfItemNS(String str, String str2) {
            return ElementImpl.this.indexOfAttributeNS(str, str2);
        }

        @Override // org.w3c.dom.NamedNodeMap
        public int getLength() {
            return ElementImpl.this.attributes.size();
        }

        @Override // org.w3c.dom.NamedNodeMap
        public Node getNamedItem(String str) {
            return ElementImpl.this.getAttributeNode(str);
        }

        @Override // org.w3c.dom.NamedNodeMap
        public Node getNamedItemNS(String str, String str2) {
            return ElementImpl.this.getAttributeNodeNS(str, str2);
        }

        @Override // org.w3c.dom.NamedNodeMap
        public Node item(int i) {
            return (Node) ElementImpl.this.attributes.get(i);
        }

        @Override // org.w3c.dom.NamedNodeMap
        public Node removeNamedItem(String str) throws DOMException {
            int indexOfItem = indexOfItem(str);
            if (indexOfItem == -1) {
                throw new DOMException((short) 8, null);
            }
            return (Node) ElementImpl.this.attributes.remove(indexOfItem);
        }

        @Override // org.w3c.dom.NamedNodeMap
        public Node removeNamedItemNS(String str, String str2) throws DOMException {
            int indexOfItemNS = indexOfItemNS(str, str2);
            if (indexOfItemNS == -1) {
                throw new DOMException((short) 8, null);
            }
            return (Node) ElementImpl.this.attributes.remove(indexOfItemNS);
        }

        @Override // org.w3c.dom.NamedNodeMap
        public Node setNamedItem(Node node) throws DOMException {
            if (node instanceof Attr) {
                return ElementImpl.this.setAttributeNode((Attr) node);
            }
            throw new DOMException((short) 3, null);
        }

        @Override // org.w3c.dom.NamedNodeMap
        public Node setNamedItemNS(Node node) throws DOMException {
            if (node instanceof Attr) {
                return ElementImpl.this.setAttributeNodeNS((Attr) node);
            }
            throw new DOMException((short) 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ElementImpl(DocumentImpl documentImpl, String str) {
        super(documentImpl);
        this.attributes = new ArrayList();
        setName(this, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ElementImpl(DocumentImpl documentImpl, String str, String str2) {
        super(documentImpl);
        this.attributes = new ArrayList();
        setNameNS(this, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int indexOfAttribute(String str) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.attributes.size()) {
                return -1;
            }
            if (Objects.equal(str, this.attributes.get(i2).getNodeName())) {
                return i2;
            }
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int indexOfAttributeNS(String str, String str2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.attributes.size()) {
                return -1;
            }
            AttrImpl attrImpl = this.attributes.get(i2);
            if (Objects.equal(str, attrImpl.getNamespaceURI()) && Objects.equal(str2, attrImpl.getLocalName())) {
                return i2;
            }
            i = i2 + 1;
        }
    }

    @Override // org.w3c.dom.Element
    public String getAttribute(String str) {
        AttrImpl attributeNode = getAttributeNode(str);
        return attributeNode == null ? "" : attributeNode.getValue();
    }

    @Override // org.w3c.dom.Element
    public String getAttributeNS(String str, String str2) {
        AttrImpl attributeNodeNS = getAttributeNodeNS(str, str2);
        return attributeNodeNS == null ? "" : attributeNodeNS.getValue();
    }

    @Override // org.w3c.dom.Element
    public AttrImpl getAttributeNode(String str) {
        int indexOfAttribute = indexOfAttribute(str);
        if (indexOfAttribute == -1) {
            return null;
        }
        return this.attributes.get(indexOfAttribute);
    }

    @Override // org.w3c.dom.Element
    public AttrImpl getAttributeNodeNS(String str, String str2) {
        int indexOfAttributeNS = indexOfAttributeNS(str, str2);
        if (indexOfAttributeNS == -1) {
            return null;
        }
        return this.attributes.get(indexOfAttributeNS);
    }

    @Override // org.apache.harmony.xml.dom.NodeImpl, org.w3c.dom.Node
    public NamedNodeMap getAttributes() {
        return new ElementAttrNamedNodeMapImpl();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Element getElementById(String str) {
        Element elementById;
        Iterator<AttrImpl> it = this.attributes.iterator();
        while (true) {
            if (it.hasNext()) {
                AttrImpl next = it.next();
                if (next.isId() && str.equals(next.getValue())) {
                    break;
                }
            } else if (!str.equals(getAttribute("id"))) {
                for (LeafNodeImpl leafNodeImpl : this.children) {
                    if (leafNodeImpl.getNodeType() == 1 && (elementById = ((ElementImpl) leafNodeImpl).getElementById(str)) != null) {
                        return elementById;
                    }
                }
                return null;
            }
        }
        return this;
    }

    @Override // org.w3c.dom.Element
    public NodeList getElementsByTagName(String str) {
        NodeListImpl nodeListImpl = new NodeListImpl();
        getElementsByTagName(nodeListImpl, str);
        return nodeListImpl;
    }

    @Override // org.w3c.dom.Element
    public NodeList getElementsByTagNameNS(String str, String str2) {
        NodeListImpl nodeListImpl = new NodeListImpl();
        getElementsByTagNameNS(nodeListImpl, str, str2);
        return nodeListImpl;
    }

    @Override // org.apache.harmony.xml.dom.NodeImpl, org.w3c.dom.Node
    public String getLocalName() {
        if (this.namespaceAware) {
            return this.localName;
        }
        return null;
    }

    @Override // org.apache.harmony.xml.dom.NodeImpl, org.w3c.dom.Node
    public String getNamespaceURI() {
        return this.namespaceURI;
    }

    @Override // org.apache.harmony.xml.dom.NodeImpl, org.w3c.dom.Node
    public String getNodeName() {
        return getTagName();
    }

    @Override // org.apache.harmony.xml.dom.NodeImpl, org.w3c.dom.Node
    public short getNodeType() {
        return (short) 1;
    }

    @Override // org.apache.harmony.xml.dom.NodeImpl, org.w3c.dom.Node
    public String getPrefix() {
        return this.prefix;
    }

    @Override // org.w3c.dom.Element
    public TypeInfo getSchemaTypeInfo() {
        return NULL_TYPE_INFO;
    }

    @Override // org.w3c.dom.Element
    public String getTagName() {
        return this.prefix != null ? this.prefix + ":" + this.localName : this.localName;
    }

    @Override // org.w3c.dom.Element
    public boolean hasAttribute(String str) {
        return indexOfAttribute(str) != -1;
    }

    @Override // org.w3c.dom.Element
    public boolean hasAttributeNS(String str, String str2) {
        return indexOfAttributeNS(str, str2) != -1;
    }

    @Override // org.apache.harmony.xml.dom.NodeImpl, org.w3c.dom.Node
    public boolean hasAttributes() {
        return !this.attributes.isEmpty();
    }

    @Override // org.w3c.dom.Element
    public void removeAttribute(String str) throws DOMException {
        int indexOfAttribute = indexOfAttribute(str);
        if (indexOfAttribute != -1) {
            this.attributes.remove(indexOfAttribute);
        }
    }

    @Override // org.w3c.dom.Element
    public void removeAttributeNS(String str, String str2) throws DOMException {
        int indexOfAttributeNS = indexOfAttributeNS(str, str2);
        if (indexOfAttributeNS != -1) {
            this.attributes.remove(indexOfAttributeNS);
        }
    }

    @Override // org.w3c.dom.Element
    public Attr removeAttributeNode(Attr attr) throws DOMException {
        AttrImpl attrImpl = (AttrImpl) attr;
        if (attrImpl.getOwnerElement() != this) {
            throw new DOMException((short) 8, null);
        }
        this.attributes.remove(attrImpl);
        attrImpl.ownerElement = null;
        return attrImpl;
    }

    @Override // org.w3c.dom.Element
    public void setAttribute(String str, String str2) throws DOMException {
        AttrImpl attributeNode = getAttributeNode(str);
        AttrImpl attrImpl = attributeNode;
        if (attributeNode == null) {
            attrImpl = this.document.createAttribute(str);
            setAttributeNode(attrImpl);
        }
        attrImpl.setValue(str2);
    }

    @Override // org.w3c.dom.Element
    public void setAttributeNS(String str, String str2, String str3) throws DOMException {
        AttrImpl attributeNodeNS = getAttributeNodeNS(str, str2);
        AttrImpl attrImpl = attributeNodeNS;
        if (attributeNodeNS == null) {
            attrImpl = this.document.createAttributeNS(str, str2);
            setAttributeNodeNS(attrImpl);
        }
        attrImpl.setValue(str3);
    }

    @Override // org.w3c.dom.Element
    public Attr setAttributeNode(Attr attr) throws DOMException {
        AttrImpl attrImpl = (AttrImpl) attr;
        if (attrImpl.document != this.document) {
            throw new DOMException((short) 4, null);
        }
        if (attrImpl.getOwnerElement() != null) {
            throw new DOMException((short) 10, null);
        }
        int indexOfAttribute = indexOfAttribute(attr.getName());
        AttrImpl attrImpl2 = null;
        if (indexOfAttribute != -1) {
            attrImpl2 = this.attributes.get(indexOfAttribute);
            this.attributes.remove(indexOfAttribute);
        }
        this.attributes.add(attrImpl);
        attrImpl.ownerElement = this;
        return attrImpl2;
    }

    @Override // org.w3c.dom.Element
    public Attr setAttributeNodeNS(Attr attr) throws DOMException {
        AttrImpl attrImpl = (AttrImpl) attr;
        if (attrImpl.document != this.document) {
            throw new DOMException((short) 4, null);
        }
        if (attrImpl.getOwnerElement() != null) {
            throw new DOMException((short) 10, null);
        }
        int indexOfAttributeNS = indexOfAttributeNS(attr.getNamespaceURI(), attr.getLocalName());
        AttrImpl attrImpl2 = null;
        if (indexOfAttributeNS != -1) {
            attrImpl2 = this.attributes.get(indexOfAttributeNS);
            this.attributes.remove(indexOfAttributeNS);
        }
        this.attributes.add(attrImpl);
        attrImpl.ownerElement = this;
        return attrImpl2;
    }

    @Override // org.w3c.dom.Element
    public void setIdAttribute(String str, boolean z) throws DOMException {
        AttrImpl attributeNode = getAttributeNode(str);
        if (attributeNode == null) {
            throw new DOMException((short) 8, "No such attribute: " + str);
        }
        attributeNode.isId = z;
    }

    @Override // org.w3c.dom.Element
    public void setIdAttributeNS(String str, String str2, boolean z) throws DOMException {
        AttrImpl attributeNodeNS = getAttributeNodeNS(str, str2);
        if (attributeNodeNS == null) {
            throw new DOMException((short) 8, "No such attribute: " + str + " " + str2);
        }
        attributeNodeNS.isId = z;
    }

    @Override // org.w3c.dom.Element
    public void setIdAttributeNode(Attr attr, boolean z) throws DOMException {
        ((AttrImpl) attr).isId = z;
    }

    @Override // org.apache.harmony.xml.dom.NodeImpl, org.w3c.dom.Node
    public void setPrefix(String str) {
        this.prefix = validatePrefix(str, this.namespaceAware, this.namespaceURI);
    }
}
