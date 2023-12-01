package org.apache.harmony.xml.dom;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import org.apache.harmony.xml.dom.NodeImpl;
import org.w3c.dom.CharacterData;
import org.w3c.dom.Comment;
import org.w3c.dom.DOMConfiguration;
import org.w3c.dom.DOMException;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentType;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.ProcessingInstruction;
import org.w3c.dom.Text;

/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/xml/dom/DocumentImpl.class */
public final class DocumentImpl extends InnerNodeImpl implements Document {
    private String documentUri;
    private DOMConfigurationImpl domConfiguration;
    private DOMImplementation domImplementation;
    private String inputEncoding;
    private WeakHashMap<NodeImpl, Map<String, NodeImpl.UserData>> nodeToUserData;
    private boolean strictErrorChecking;
    private String xmlEncoding;
    private boolean xmlStandalone;
    private String xmlVersion;

    public DocumentImpl(DOMImplementationImpl dOMImplementationImpl, String str, String str2, DocumentType documentType, String str3) {
        super(null);
        this.xmlVersion = "1.0";
        this.xmlStandalone = false;
        this.strictErrorChecking = true;
        this.document = this;
        this.domImplementation = dOMImplementationImpl;
        this.inputEncoding = str3;
        if (documentType != null) {
            appendChild(documentType);
        }
        if (str2 != null) {
            appendChild(createElementNS(str, str2));
        }
    }

    private void changeDocumentToThis(NodeImpl nodeImpl) {
        Map<String, NodeImpl.UserData> userDataMapForRead = nodeImpl.document.getUserDataMapForRead(nodeImpl);
        if (!userDataMapForRead.isEmpty()) {
            getUserDataMap(nodeImpl).putAll(userDataMapForRead);
        }
        nodeImpl.document = this;
        NodeList childNodes = nodeImpl.getChildNodes();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= childNodes.getLength()) {
                break;
            }
            changeDocumentToThis((NodeImpl) childNodes.item(i2));
            i = i2 + 1;
        }
        if (nodeImpl.getNodeType() != 1) {
            return;
        }
        NamedNodeMap attributes = nodeImpl.getAttributes();
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= attributes.getLength()) {
                return;
            }
            changeDocumentToThis((AttrImpl) attributes.item(i4));
            i3 = i4 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isXMLIdentifier(String str) {
        if (str.length() == 0 || !isXMLIdentifierStart(str.charAt(0))) {
            return false;
        }
        int i = 1;
        while (true) {
            int i2 = i;
            if (i2 >= str.length()) {
                return true;
            }
            if (!isXMLIdentifierPart(str.charAt(i2))) {
                return false;
            }
            i = i2 + 1;
        }
    }

    private static boolean isXMLIdentifierPart(char c2) {
        if (isXMLIdentifierStart(c2)) {
            return true;
        }
        return (c2 >= '0' && c2 <= '9') || c2 == '-' || c2 == '.';
    }

    private static boolean isXMLIdentifierStart(char c2) {
        if (c2 < 'A' || c2 > 'Z') {
            return (c2 >= 'a' && c2 <= 'z') || c2 == '_';
        }
        return true;
    }

    private static void notifyUserDataHandlers(short s, Node node, NodeImpl nodeImpl) {
        if (node instanceof NodeImpl) {
            NodeImpl nodeImpl2 = (NodeImpl) node;
            if (nodeImpl2.document != null) {
                for (Map.Entry<String, NodeImpl.UserData> entry : nodeImpl2.document.getUserDataMapForRead(nodeImpl2).entrySet()) {
                    NodeImpl.UserData value = entry.getValue();
                    if (value.handler != null) {
                        value.handler.handle(s, entry.getKey(), value.value, node, nodeImpl);
                    }
                }
            }
        }
    }

    private NodeImpl shallowCopy(short s, Node node) {
        ElementImpl createElement;
        AttrImpl createAttribute;
        switch (node.getNodeType()) {
            case 1:
                ElementImpl elementImpl = (ElementImpl) node;
                if (elementImpl.namespaceAware) {
                    createElement = createElementNS(elementImpl.getNamespaceURI(), elementImpl.getLocalName());
                    createElement.setPrefix(elementImpl.getPrefix());
                } else {
                    createElement = createElement(elementImpl.getTagName());
                }
                NamedNodeMap attributes = elementImpl.getAttributes();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= attributes.getLength()) {
                        return createElement;
                    }
                    AttrImpl attrImpl = (AttrImpl) attributes.item(i2);
                    AttrImpl attrImpl2 = (AttrImpl) shallowCopy(s, attrImpl);
                    notifyUserDataHandlers(s, attrImpl, attrImpl2);
                    if (attrImpl.namespaceAware) {
                        createElement.setAttributeNodeNS(attrImpl2);
                    } else {
                        createElement.setAttributeNode(attrImpl2);
                    }
                    i = i2 + 1;
                }
            case 2:
                AttrImpl attrImpl3 = (AttrImpl) node;
                if (attrImpl3.namespaceAware) {
                    createAttribute = createAttributeNS(attrImpl3.getNamespaceURI(), attrImpl3.getLocalName());
                    createAttribute.setPrefix(attrImpl3.getPrefix());
                } else {
                    createAttribute = createAttribute(attrImpl3.getName());
                }
                createAttribute.setNodeValue(attrImpl3.getValue());
                return createAttribute;
            case 3:
                return createTextNode(((Text) node).getData());
            case 4:
                return createCDATASection(((CharacterData) node).getData());
            case 5:
                return createEntityReference(node.getNodeName());
            case 6:
            case 12:
                throw new UnsupportedOperationException();
            case 7:
                ProcessingInstruction processingInstruction = (ProcessingInstruction) node;
                return createProcessingInstruction(processingInstruction.getTarget(), processingInstruction.getData());
            case 8:
                return createComment(((Comment) node).getData());
            case 9:
            case 10:
                throw new DOMException((short) 9, "Cannot copy node of type " + ((int) node.getNodeType()));
            case 11:
                return createDocumentFragment();
            default:
                throw new DOMException((short) 9, "Unsupported node type " + ((int) node.getNodeType()));
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // org.w3c.dom.Document
    public Node adoptNode(Node node) {
        if (node instanceof NodeImpl) {
            NodeImpl nodeImpl = (NodeImpl) node;
            switch (nodeImpl.getNodeType()) {
                case 1:
                case 3:
                case 4:
                case 5:
                case 7:
                case 8:
                case 11:
                    break;
                case 2:
                    AttrImpl attrImpl = (AttrImpl) node;
                    if (attrImpl.ownerElement != null) {
                        attrImpl.ownerElement.removeAttributeNode(attrImpl);
                        break;
                    }
                    break;
                case 6:
                case 9:
                case 10:
                case 12:
                    throw new DOMException((short) 9, "Cannot adopt nodes of type " + ((int) nodeImpl.getNodeType()));
                default:
                    throw new DOMException((short) 9, "Unsupported node type " + ((int) node.getNodeType()));
            }
            Node parentNode = nodeImpl.getParentNode();
            if (parentNode != null) {
                parentNode.removeChild(nodeImpl);
            }
            changeDocumentToThis(nodeImpl);
            notifyUserDataHandlers((short) 5, node, null);
            return nodeImpl;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Node cloneOrImportNode(short s, Node node, boolean z) {
        NodeImpl shallowCopy = shallowCopy(s, node);
        if (z) {
            NodeList childNodes = node.getChildNodes();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= childNodes.getLength()) {
                    break;
                }
                shallowCopy.appendChild(cloneOrImportNode(s, childNodes.item(i2), z));
                i = i2 + 1;
            }
        }
        notifyUserDataHandlers(s, node, shallowCopy);
        return shallowCopy;
    }

    @Override // org.w3c.dom.Document
    public AttrImpl createAttribute(String str) {
        return new AttrImpl(this, str);
    }

    @Override // org.w3c.dom.Document
    public AttrImpl createAttributeNS(String str, String str2) {
        return new AttrImpl(this, str, str2);
    }

    @Override // org.w3c.dom.Document
    public CDATASectionImpl createCDATASection(String str) {
        return new CDATASectionImpl(this, str);
    }

    @Override // org.w3c.dom.Document
    public CommentImpl createComment(String str) {
        return new CommentImpl(this, str);
    }

    @Override // org.w3c.dom.Document
    public DocumentFragmentImpl createDocumentFragment() {
        return new DocumentFragmentImpl(this);
    }

    @Override // org.w3c.dom.Document
    public ElementImpl createElement(String str) {
        return new ElementImpl(this, str);
    }

    @Override // org.w3c.dom.Document
    public ElementImpl createElementNS(String str, String str2) {
        return new ElementImpl(this, str, str2);
    }

    @Override // org.w3c.dom.Document
    public EntityReferenceImpl createEntityReference(String str) {
        return new EntityReferenceImpl(this, str);
    }

    @Override // org.w3c.dom.Document
    public ProcessingInstructionImpl createProcessingInstruction(String str, String str2) {
        return new ProcessingInstructionImpl(this, str, str2);
    }

    @Override // org.w3c.dom.Document
    public TextImpl createTextNode(String str) {
        return new TextImpl(this, str);
    }

    @Override // org.w3c.dom.Document
    public DocumentType getDoctype() {
        for (LeafNodeImpl leafNodeImpl : this.children) {
            if (leafNodeImpl instanceof DocumentType) {
                return (DocumentType) leafNodeImpl;
            }
        }
        return null;
    }

    @Override // org.w3c.dom.Document
    public Element getDocumentElement() {
        for (LeafNodeImpl leafNodeImpl : this.children) {
            if (leafNodeImpl instanceof Element) {
                return (Element) leafNodeImpl;
            }
        }
        return null;
    }

    @Override // org.w3c.dom.Document
    public String getDocumentURI() {
        return this.documentUri;
    }

    @Override // org.w3c.dom.Document
    public DOMConfiguration getDomConfig() {
        if (this.domConfiguration == null) {
            this.domConfiguration = new DOMConfigurationImpl();
        }
        return this.domConfiguration;
    }

    @Override // org.w3c.dom.Document
    public Element getElementById(String str) {
        ElementImpl elementImpl = (ElementImpl) getDocumentElement();
        if (elementImpl == null) {
            return null;
        }
        return elementImpl.getElementById(str);
    }

    @Override // org.w3c.dom.Document
    public NodeList getElementsByTagName(String str) {
        NodeListImpl nodeListImpl = new NodeListImpl();
        getElementsByTagName(nodeListImpl, str);
        return nodeListImpl;
    }

    @Override // org.w3c.dom.Document
    public NodeList getElementsByTagNameNS(String str, String str2) {
        NodeListImpl nodeListImpl = new NodeListImpl();
        getElementsByTagNameNS(nodeListImpl, str, str2);
        return nodeListImpl;
    }

    @Override // org.w3c.dom.Document
    public DOMImplementation getImplementation() {
        return this.domImplementation;
    }

    @Override // org.w3c.dom.Document
    public String getInputEncoding() {
        return this.inputEncoding;
    }

    @Override // org.apache.harmony.xml.dom.NodeImpl, org.w3c.dom.Node
    public String getNodeName() {
        return "#document";
    }

    @Override // org.apache.harmony.xml.dom.NodeImpl, org.w3c.dom.Node
    public short getNodeType() {
        return (short) 9;
    }

    @Override // org.w3c.dom.Document
    public boolean getStrictErrorChecking() {
        return this.strictErrorChecking;
    }

    @Override // org.apache.harmony.xml.dom.InnerNodeImpl, org.apache.harmony.xml.dom.NodeImpl, org.w3c.dom.Node
    public String getTextContent() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Map<String, NodeImpl.UserData> getUserDataMap(NodeImpl nodeImpl) {
        if (this.nodeToUserData == null) {
            this.nodeToUserData = new WeakHashMap<>();
        }
        Map<String, NodeImpl.UserData> map = this.nodeToUserData.get(nodeImpl);
        HashMap hashMap = map;
        if (map == null) {
            hashMap = new HashMap();
            this.nodeToUserData.put(nodeImpl, hashMap);
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Map<String, NodeImpl.UserData> getUserDataMapForRead(NodeImpl nodeImpl) {
        Map<String, NodeImpl.UserData> map;
        if (this.nodeToUserData == null) {
            map = Collections.emptyMap();
        } else {
            Map<String, NodeImpl.UserData> map2 = this.nodeToUserData.get(nodeImpl);
            map = map2;
            if (map2 == null) {
                return Collections.emptyMap();
            }
        }
        return map;
    }

    @Override // org.w3c.dom.Document
    public String getXmlEncoding() {
        return this.xmlEncoding;
    }

    @Override // org.w3c.dom.Document
    public boolean getXmlStandalone() {
        return this.xmlStandalone;
    }

    @Override // org.w3c.dom.Document
    public String getXmlVersion() {
        return this.xmlVersion;
    }

    @Override // org.w3c.dom.Document
    public Node importNode(Node node, boolean z) {
        return cloneOrImportNode((short) 2, node, z);
    }

    @Override // org.apache.harmony.xml.dom.InnerNodeImpl
    public Node insertChildAt(Node node, int i) {
        if (!(node instanceof Element) || getDocumentElement() == null) {
            if (!(node instanceof DocumentType) || getDoctype() == null) {
                return super.insertChildAt(node, i);
            }
            throw new DOMException((short) 3, "Only one DOCTYPE element allowed");
        }
        throw new DOMException((short) 3, "Only one root element allowed");
    }

    @Override // org.w3c.dom.Document
    public void normalizeDocument() {
        Element documentElement = getDocumentElement();
        if (documentElement == null) {
            return;
        }
        ((DOMConfigurationImpl) getDomConfig()).normalize(documentElement);
    }

    @Override // org.w3c.dom.Document
    public Node renameNode(Node node, String str, String str2) {
        if (node.getOwnerDocument() != this) {
            throw new DOMException((short) 4, null);
        }
        setNameNS((NodeImpl) node, str, str2);
        notifyUserDataHandlers((short) 4, node, null);
        return node;
    }

    @Override // org.w3c.dom.Document
    public void setDocumentURI(String str) {
        this.documentUri = str;
    }

    @Override // org.w3c.dom.Document
    public void setStrictErrorChecking(boolean z) {
        this.strictErrorChecking = z;
    }

    @Override // org.w3c.dom.Document
    public void setXmlStandalone(boolean z) {
        this.xmlStandalone = z;
    }

    @Override // org.w3c.dom.Document
    public void setXmlVersion(String str) {
        this.xmlVersion = str;
    }
}
