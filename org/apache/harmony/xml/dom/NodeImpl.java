package org.apache.harmony.xml.dom;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.xml.XMLConstants;
import org.w3c.dom.Attr;
import org.w3c.dom.CharacterData;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.ProcessingInstruction;
import org.w3c.dom.TypeInfo;
import org.w3c.dom.UserDataHandler;

/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/xml/dom/NodeImpl.class */
public abstract class NodeImpl implements Node {
    private static final NodeList EMPTY_LIST = new NodeListImpl();
    static final TypeInfo NULL_TYPE_INFO = new TypeInfo() { // from class: org.apache.harmony.xml.dom.NodeImpl.1
        @Override // org.w3c.dom.TypeInfo
        public String getTypeName() {
            return null;
        }

        @Override // org.w3c.dom.TypeInfo
        public String getTypeNamespace() {
            return null;
        }

        @Override // org.w3c.dom.TypeInfo
        public boolean isDerivedFrom(String str, String str2, int i) {
            return false;
        }
    };
    DocumentImpl document;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/xml/dom/NodeImpl$UserData.class */
    public static class UserData {
        final UserDataHandler handler;
        final Object value;

        UserData(Object obj, UserDataHandler userDataHandler) {
            this.value = obj;
            this.handler = userDataHandler;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public NodeImpl(DocumentImpl documentImpl) {
        this.document = documentImpl;
    }

    private static List<Object> createEqualityKey(Node node) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(Short.valueOf(node.getNodeType()));
        arrayList.add(node.getNodeName());
        arrayList.add(node.getLocalName());
        arrayList.add(node.getNamespaceURI());
        arrayList.add(node.getPrefix());
        arrayList.add(node.getNodeValue());
        Node firstChild = node.getFirstChild();
        while (true) {
            Node node2 = firstChild;
            if (node2 == null) {
                break;
            }
            arrayList.add(node2);
            firstChild = node2.getNextSibling();
        }
        switch (node.getNodeType()) {
            case 1:
                arrayList.add(((Element) node).getAttributes());
                return arrayList;
            case 10:
                DocumentTypeImpl documentTypeImpl = (DocumentTypeImpl) node;
                arrayList.add(documentTypeImpl.getPublicId());
                arrayList.add(documentTypeImpl.getSystemId());
                arrayList.add(documentTypeImpl.getInternalSubset());
                arrayList.add(documentTypeImpl.getEntities());
                arrayList.add(documentTypeImpl.getNotations());
                return arrayList;
            default:
                return arrayList;
        }
    }

    private NodeImpl getContainingElement() {
        Node parentNode = getParentNode();
        while (true) {
            Node node = parentNode;
            if (node == null) {
                return null;
            }
            if (node.getNodeType() == 1) {
                return (NodeImpl) node;
            }
            parentNode = node.getParentNode();
        }
    }

    private NodeImpl getNamespacingElement() {
        switch (getNodeType()) {
            case 1:
                return this;
            case 2:
                return (NodeImpl) ((Attr) this).getOwnerElement();
            case 3:
            case 4:
            case 5:
            case 7:
            case 8:
                return getContainingElement();
            case 6:
            case 10:
            case 11:
            case 12:
                return null;
            case 9:
                return (NodeImpl) ((Document) this).getDocumentElement();
            default:
                throw new DOMException((short) 9, "Unsupported node type " + ((int) getNodeType()));
        }
    }

    private String getParentBaseUri() {
        Node parentNode = getParentNode();
        if (parentNode != null) {
            return parentNode.getBaseURI();
        }
        return null;
    }

    private boolean namedNodeMapsEqual(NamedNodeMap namedNodeMap, NamedNodeMap namedNodeMap2) {
        if (namedNodeMap.getLength() != namedNodeMap2.getLength()) {
            return false;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= namedNodeMap.getLength()) {
                return true;
            }
            Node item = namedNodeMap.item(i2);
            Node namedItem = item.getLocalName() == null ? namedNodeMap2.getNamedItem(item.getNodeName()) : namedNodeMap2.getNamedItemNS(item.getNamespaceURI(), item.getLocalName());
            if (namedItem == null || !item.isEqualNode(namedItem)) {
                return false;
            }
            i = i2 + 1;
        }
    }

    private String sanitizeUri(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        try {
            return new URI(str).toString();
        } catch (URISyntaxException e) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setName(NodeImpl nodeImpl, String str) {
        int lastIndexOf = str.lastIndexOf(":");
        if (lastIndexOf != -1) {
            String substring = str.substring(0, lastIndexOf);
            String substring2 = str.substring(lastIndexOf + 1);
            if (!DocumentImpl.isXMLIdentifier(substring) || !DocumentImpl.isXMLIdentifier(substring2)) {
                throw new DOMException((short) 5, str);
            }
        } else if (!DocumentImpl.isXMLIdentifier(str)) {
            throw new DOMException((short) 5, str);
        }
        switch (nodeImpl.getNodeType()) {
            case 1:
                ElementImpl elementImpl = (ElementImpl) nodeImpl;
                elementImpl.namespaceAware = false;
                elementImpl.localName = str;
                return;
            case 2:
                AttrImpl attrImpl = (AttrImpl) nodeImpl;
                attrImpl.namespaceAware = false;
                attrImpl.localName = str;
                return;
            default:
                throw new DOMException((short) 9, "Cannot rename nodes of type " + ((int) nodeImpl.getNodeType()));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setNameNS(NodeImpl nodeImpl, String str, String str2) {
        if (str2 == null) {
            throw new DOMException((short) 14, str2);
        }
        String str3 = null;
        int lastIndexOf = str2.lastIndexOf(":");
        String str4 = str2;
        if (lastIndexOf != -1) {
            str3 = validatePrefix(str2.substring(0, lastIndexOf), true, str);
            str4 = str2.substring(lastIndexOf + 1);
        }
        if (!DocumentImpl.isXMLIdentifier(str4)) {
            throw new DOMException((short) 5, str4);
        }
        switch (nodeImpl.getNodeType()) {
            case 1:
                ElementImpl elementImpl = (ElementImpl) nodeImpl;
                elementImpl.namespaceAware = true;
                elementImpl.namespaceURI = str;
                elementImpl.prefix = str3;
                elementImpl.localName = str4;
                return;
            case 2:
                if (XMLConstants.XMLNS_ATTRIBUTE.equals(str4) && !XMLConstants.XMLNS_ATTRIBUTE_NS_URI.equals(str)) {
                    throw new DOMException((short) 14, str4);
                }
                AttrImpl attrImpl = (AttrImpl) nodeImpl;
                attrImpl.namespaceAware = true;
                attrImpl.namespaceURI = str;
                attrImpl.prefix = str3;
                attrImpl.localName = str4;
                return;
            default:
                throw new DOMException((short) 9, "Cannot rename nodes of type " + ((int) nodeImpl.getNodeType()));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String validatePrefix(String str, boolean z, String str2) {
        if (z) {
            if (str == null || (str2 != null && DocumentImpl.isXMLIdentifier(str) && ((!XMLConstants.XML_NS_PREFIX.equals(str) || "http://www.w3.org/XML/1998/namespace".equals(str2)) && (!XMLConstants.XMLNS_ATTRIBUTE.equals(str) || XMLConstants.XMLNS_ATTRIBUTE_NS_URI.equals(str2))))) {
                return str;
            }
            throw new DOMException((short) 14, str);
        }
        throw new DOMException((short) 14, str);
    }

    @Override // org.w3c.dom.Node
    public Node appendChild(Node node) throws DOMException {
        throw new DOMException((short) 3, null);
    }

    @Override // org.w3c.dom.Node
    public final Node cloneNode(boolean z) {
        return this.document.cloneOrImportNode((short) 1, this, z);
    }

    @Override // org.w3c.dom.Node
    public short compareDocumentPosition(Node node) throws DOMException {
        throw new UnsupportedOperationException();
    }

    @Override // org.w3c.dom.Node
    public NamedNodeMap getAttributes() {
        return null;
    }

    @Override // org.w3c.dom.Node
    public final String getBaseURI() {
        String str;
        switch (getNodeType()) {
            case 1:
                String attributeNS = ((Element) this).getAttributeNS("http://www.w3.org/XML/1998/namespace", "base");
                if (attributeNS != null) {
                    try {
                        if (!attributeNS.isEmpty()) {
                            str = attributeNS;
                            if (!new URI(attributeNS).isAbsolute()) {
                                String parentBaseUri = getParentBaseUri();
                                if (parentBaseUri == null) {
                                    return null;
                                }
                                return new URI(parentBaseUri).resolve(attributeNS).toString();
                            }
                        }
                    } catch (URISyntaxException e) {
                        return null;
                    }
                }
                return getParentBaseUri();
            case 2:
            case 3:
            case 4:
            case 8:
            case 10:
            case 11:
                return null;
            case 5:
                return null;
            case 6:
            case 12:
                return null;
            case 7:
                return getParentBaseUri();
            case 9:
                str = sanitizeUri(((Document) this).getDocumentURI());
                break;
            default:
                throw new DOMException((short) 9, "Unsupported node type " + ((int) getNodeType()));
        }
        return str;
    }

    @Override // org.w3c.dom.Node
    public NodeList getChildNodes() {
        return EMPTY_LIST;
    }

    @Override // org.w3c.dom.Node
    public final Object getFeature(String str, String str2) {
        if (isSupported(str, str2)) {
            return this;
        }
        return null;
    }

    @Override // org.w3c.dom.Node
    public Node getFirstChild() {
        return null;
    }

    @Override // org.w3c.dom.Node
    public Node getLastChild() {
        return null;
    }

    @Override // org.w3c.dom.Node
    public String getLocalName() {
        return null;
    }

    @Override // org.w3c.dom.Node
    public String getNamespaceURI() {
        return null;
    }

    @Override // org.w3c.dom.Node
    public Node getNextSibling() {
        return null;
    }

    @Override // org.w3c.dom.Node
    public String getNodeName() {
        return null;
    }

    @Override // org.w3c.dom.Node
    public abstract short getNodeType();

    @Override // org.w3c.dom.Node
    public String getNodeValue() throws DOMException {
        return null;
    }

    @Override // org.w3c.dom.Node
    public final Document getOwnerDocument() {
        if (this.document == this) {
            return null;
        }
        return this.document;
    }

    @Override // org.w3c.dom.Node
    public Node getParentNode() {
        return null;
    }

    @Override // org.w3c.dom.Node
    public String getPrefix() {
        return null;
    }

    @Override // org.w3c.dom.Node
    public Node getPreviousSibling() {
        return null;
    }

    @Override // org.w3c.dom.Node
    public String getTextContent() throws DOMException {
        return getNodeValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void getTextContent(StringBuilder sb) throws DOMException {
        String nodeValue = getNodeValue();
        if (nodeValue != null) {
            sb.append(nodeValue);
        }
    }

    @Override // org.w3c.dom.Node
    public final Object getUserData(String str) {
        if (str == null) {
            throw new NullPointerException("key == null");
        }
        UserData userData = this.document.getUserDataMapForRead(this).get(str);
        if (userData != null) {
            return userData.value;
        }
        return null;
    }

    @Override // org.w3c.dom.Node
    public boolean hasAttributes() {
        return false;
    }

    @Override // org.w3c.dom.Node
    public boolean hasChildNodes() {
        return false;
    }

    @Override // org.w3c.dom.Node
    public Node insertBefore(Node node, Node node2) throws DOMException {
        throw new DOMException((short) 3, null);
    }

    @Override // org.w3c.dom.Node
    public final boolean isDefaultNamespace(String str) {
        String lookupNamespaceURI = lookupNamespaceURI(null);
        return str == null ? lookupNamespaceURI == null : str.equals(lookupNamespaceURI);
    }

    @Override // org.w3c.dom.Node
    public final boolean isEqualNode(Node node) {
        if (node == this) {
            return true;
        }
        List<Object> createEqualityKey = createEqualityKey(this);
        List<Object> createEqualityKey2 = createEqualityKey(node);
        if (createEqualityKey.size() != createEqualityKey2.size()) {
            return false;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= createEqualityKey.size()) {
                return true;
            }
            Object obj = createEqualityKey.get(i2);
            Object obj2 = createEqualityKey2.get(i2);
            if (obj != obj2) {
                if (obj == null || obj2 == null) {
                    return false;
                }
                if ((obj instanceof String) || (obj instanceof Short)) {
                    if (!obj.equals(obj2)) {
                        return false;
                    }
                } else if (obj instanceof NamedNodeMap) {
                    if (!(obj2 instanceof NamedNodeMap) || !namedNodeMapsEqual((NamedNodeMap) obj, (NamedNodeMap) obj2)) {
                        return false;
                    }
                } else if (!(obj instanceof Node)) {
                    throw new AssertionError();
                } else {
                    if (!(obj2 instanceof Node) || !((Node) obj).isEqualNode((Node) obj2)) {
                        return false;
                    }
                }
            }
            i = i2 + 1;
        }
    }

    boolean isPrefixMappedToUri(String str, String str2) {
        if (str == null) {
            return false;
        }
        return str2.equals(lookupNamespaceURI(str));
    }

    @Override // org.w3c.dom.Node
    public boolean isSameNode(Node node) {
        return this == node;
    }

    @Override // org.w3c.dom.Node
    public boolean isSupported(String str, String str2) {
        return DOMImplementationImpl.getInstance().hasFeature(str, str2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0023, code lost:
        r4 = r7.getNamespaceURI();
     */
    @Override // org.w3c.dom.Node
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String lookupNamespaceURI(java.lang.String r4) {
        /*
            r3 = this;
            r0 = r3
            org.apache.harmony.xml.dom.NodeImpl r0 = r0.getNamespacingElement()
            r7 = r0
        L6:
            r0 = r7
            if (r0 == 0) goto Lc5
            r0 = r7
            java.lang.String r0 = r0.getPrefix()
            r8 = r0
            r0 = r7
            java.lang.String r0 = r0.getNamespaceURI()
            if (r0 == 0) goto L34
            r0 = r4
            if (r0 != 0) goto L2b
            r0 = r8
            if (r0 != 0) goto L34
        L23:
            r0 = r7
            java.lang.String r0 = r0.getNamespaceURI()
            r4 = r0
        L29:
            r0 = r4
            return r0
        L2b:
            r0 = r4
            r1 = r8
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L23
        L34:
            r0 = r7
            boolean r0 = r0.hasAttributes()
            if (r0 != 0) goto L46
        L3c:
            r0 = r7
            org.apache.harmony.xml.dom.NodeImpl r0 = r0.getContainingElement()
            r7 = r0
            goto L6
        L46:
            r0 = r7
            org.w3c.dom.NamedNodeMap r0 = r0.getAttributes()
            r8 = r0
            r0 = 0
            r5 = r0
            r0 = r8
            int r0 = r0.getLength()
            r6 = r0
        L57:
            r0 = r5
            r1 = r6
            if (r0 >= r1) goto L3c
            r0 = r8
            r1 = r5
            org.w3c.dom.Node r0 = r0.item(r1)
            r9 = r0
            java.lang.String r0 = "http://www.w3.org/2000/xmlns/"
            r1 = r9
            java.lang.String r1 = r1.getNamespaceURI()
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L7c
        L75:
            r0 = r5
            r1 = 1
            int r0 = r0 + r1
            r5 = r0
            goto L57
        L7c:
            r0 = r4
            if (r0 != 0) goto La5
            java.lang.String r0 = "xmlns"
            r1 = r9
            java.lang.String r1 = r1.getNodeName()
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L75
        L8f:
            r0 = r9
            java.lang.String r0 = r0.getNodeValue()
            r7 = r0
            r0 = r7
            r4 = r0
            r0 = r7
            int r0 = r0.length()
            if (r0 > 0) goto L29
            r0 = 0
            return r0
        La5:
            java.lang.String r0 = "xmlns"
            r1 = r9
            java.lang.String r1 = r1.getPrefix()
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L75
            r0 = r4
            r1 = r9
            java.lang.String r1 = r1.getLocalName()
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L75
            goto L8f
        Lc5:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.harmony.xml.dom.NodeImpl.lookupNamespaceURI(java.lang.String):java.lang.String");
    }

    @Override // org.w3c.dom.Node
    public final String lookupPrefix(String str) {
        if (str == null) {
            return null;
        }
        NodeImpl namespacingElement = getNamespacingElement();
        NodeImpl nodeImpl = namespacingElement;
        while (true) {
            NodeImpl nodeImpl2 = nodeImpl;
            if (nodeImpl2 == null) {
                return null;
            }
            if (str.equals(nodeImpl2.getNamespaceURI()) && namespacingElement.isPrefixMappedToUri(nodeImpl2.getPrefix(), str)) {
                return nodeImpl2.getPrefix();
            }
            if (nodeImpl2.hasAttributes()) {
                NamedNodeMap attributes = nodeImpl2.getAttributes();
                int length = attributes.getLength();
                for (int i = 0; i < length; i++) {
                    Node item = attributes.item(i);
                    if (XMLConstants.XMLNS_ATTRIBUTE_NS_URI.equals(item.getNamespaceURI()) && XMLConstants.XMLNS_ATTRIBUTE.equals(item.getPrefix()) && str.equals(item.getNodeValue()) && namespacingElement.isPrefixMappedToUri(item.getLocalName(), str)) {
                        return item.getLocalName();
                    }
                }
                continue;
            }
            nodeImpl = nodeImpl2.getContainingElement();
        }
    }

    @Override // org.w3c.dom.Node
    public void normalize() {
    }

    @Override // org.w3c.dom.Node
    public Node removeChild(Node node) throws DOMException {
        throw new DOMException((short) 3, null);
    }

    @Override // org.w3c.dom.Node
    public Node replaceChild(Node node, Node node2) throws DOMException {
        throw new DOMException((short) 3, null);
    }

    @Override // org.w3c.dom.Node
    public final void setNodeValue(String str) throws DOMException {
        switch (getNodeType()) {
            case 1:
            case 5:
            case 6:
            case 9:
            case 10:
            case 11:
            case 12:
                return;
            case 2:
                ((Attr) this).setValue(str);
                return;
            case 3:
            case 4:
            case 8:
                ((CharacterData) this).setData(str);
                return;
            case 7:
                ((ProcessingInstruction) this).setData(str);
                return;
            default:
                throw new DOMException((short) 9, "Unsupported node type " + ((int) getNodeType()));
        }
    }

    @Override // org.w3c.dom.Node
    public void setPrefix(String str) throws DOMException {
    }

    @Override // org.w3c.dom.Node
    public final void setTextContent(String str) throws DOMException {
        switch (getNodeType()) {
            case 1:
            case 5:
            case 6:
            case 11:
                break;
            case 2:
            case 3:
            case 4:
            case 7:
            case 8:
            case 12:
                setNodeValue(str);
                return;
            case 9:
            case 10:
                return;
            default:
                throw new DOMException((short) 9, "Unsupported node type " + ((int) getNodeType()));
        }
        while (true) {
            Node firstChild = getFirstChild();
            if (firstChild == null) {
                if (str == null || str.length() == 0) {
                    return;
                }
                appendChild(this.document.createTextNode(str));
                return;
            }
            removeChild(firstChild);
        }
    }

    @Override // org.w3c.dom.Node
    public final Object setUserData(String str, Object obj, UserDataHandler userDataHandler) {
        if (str == null) {
            throw new NullPointerException("key == null");
        }
        Map<String, UserData> userDataMap = this.document.getUserDataMap(this);
        UserData remove = obj == null ? userDataMap.remove(str) : userDataMap.put(str, new UserData(obj, userDataHandler));
        if (remove != null) {
            return remove.value;
        }
        return null;
    }
}
