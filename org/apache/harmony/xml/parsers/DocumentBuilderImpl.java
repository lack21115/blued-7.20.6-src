package org.apache.harmony.xml.parsers;

import com.j256.ormlite.stmt.query.SimpleComparison;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import javax.xml.parsers.DocumentBuilder;
import libcore.io.IoUtils;
import org.apache.harmony.xml.dom.AttrImpl;
import org.apache.harmony.xml.dom.CDATASectionImpl;
import org.apache.harmony.xml.dom.DOMImplementationImpl;
import org.apache.harmony.xml.dom.DocumentImpl;
import org.apache.harmony.xml.dom.DocumentTypeImpl;
import org.apache.harmony.xml.dom.ElementImpl;
import org.apache.harmony.xml.dom.TextImpl;
import org.kxml2.io.KXmlParser;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.Text;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.LocatorImpl;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/xml/parsers/DocumentBuilderImpl.class */
class DocumentBuilderImpl extends DocumentBuilder {
    private static DOMImplementationImpl dom = DOMImplementationImpl.getInstance();
    private boolean coalescing;
    private EntityResolver entityResolver;
    private ErrorHandler errorHandler;
    private boolean ignoreComments;
    private boolean ignoreElementContentWhitespace;
    private boolean namespaceAware;

    private void appendText(DocumentImpl documentImpl, Node node, int i, String str) {
        Node lastChild;
        if (str.isEmpty()) {
            return;
        }
        if ((this.coalescing || i != 5) && (lastChild = node.getLastChild()) != null && lastChild.getNodeType() == 3) {
            ((Text) lastChild).appendData(str);
        } else {
            node.appendChild(i == 5 ? new CDATASectionImpl(documentImpl, str) : new TextImpl(documentImpl, str));
        }
    }

    private void parse(KXmlParser kXmlParser, DocumentImpl documentImpl, Node node, int i) throws XmlPullParserException, IOException {
        int eventType = kXmlParser.getEventType();
        while (true) {
            int i2 = eventType;
            if (i2 == i || i2 == 1) {
                return;
            }
            if (i2 == 8) {
                String text = kXmlParser.getText();
                int indexOf = text.indexOf(32);
                node.appendChild(documentImpl.createProcessingInstruction(indexOf != -1 ? text.substring(0, indexOf) : text, indexOf != -1 ? text.substring(indexOf + 1) : ""));
            } else if (i2 == 10) {
                documentImpl.appendChild(new DocumentTypeImpl(documentImpl, kXmlParser.getRootElementName(), kXmlParser.getPublicId(), kXmlParser.getSystemId()));
            } else if (i2 == 9) {
                if (!this.ignoreComments) {
                    node.appendChild(documentImpl.createComment(kXmlParser.getText()));
                }
            } else if (i2 == 7) {
                if (!this.ignoreElementContentWhitespace && documentImpl != node) {
                    appendText(documentImpl, node, i2, kXmlParser.getText());
                }
            } else if (i2 == 4 || i2 == 5) {
                appendText(documentImpl, node, i2, kXmlParser.getText());
            } else if (i2 == 6) {
                String name = kXmlParser.getName();
                if (this.entityResolver != null) {
                }
                String resolvePredefinedOrCharacterEntity = resolvePredefinedOrCharacterEntity(name);
                if (resolvePredefinedOrCharacterEntity != null) {
                    appendText(documentImpl, node, i2, resolvePredefinedOrCharacterEntity);
                } else {
                    node.appendChild(documentImpl.createEntityReference(name));
                }
            } else if (i2 == 2) {
                if (this.namespaceAware) {
                    String namespace = kXmlParser.getNamespace();
                    String name2 = kXmlParser.getName();
                    String prefix = kXmlParser.getPrefix();
                    String str = namespace;
                    if ("".equals(namespace)) {
                        str = null;
                    }
                    ElementImpl createElementNS = documentImpl.createElementNS(str, name2);
                    createElementNS.setPrefix(prefix);
                    node.appendChild(createElementNS);
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        if (i4 >= kXmlParser.getAttributeCount()) {
                            break;
                        }
                        String attributeNamespace = kXmlParser.getAttributeNamespace(i4);
                        String attributePrefix = kXmlParser.getAttributePrefix(i4);
                        String attributeName = kXmlParser.getAttributeName(i4);
                        String attributeValue = kXmlParser.getAttributeValue(i4);
                        String str2 = attributeNamespace;
                        if ("".equals(attributeNamespace)) {
                            str2 = null;
                        }
                        AttrImpl createAttributeNS = documentImpl.createAttributeNS(str2, attributeName);
                        createAttributeNS.setPrefix(attributePrefix);
                        createAttributeNS.setValue(attributeValue);
                        createElementNS.setAttributeNodeNS(createAttributeNS);
                        i3 = i4 + 1;
                    }
                    kXmlParser.nextToken();
                    parse(kXmlParser, documentImpl, createElementNS, 3);
                    kXmlParser.require(3, str, name2);
                } else {
                    String name3 = kXmlParser.getName();
                    ElementImpl createElement = documentImpl.createElement(name3);
                    node.appendChild(createElement);
                    int i5 = 0;
                    while (true) {
                        int i6 = i5;
                        if (i6 >= kXmlParser.getAttributeCount()) {
                            break;
                        }
                        String attributeName2 = kXmlParser.getAttributeName(i6);
                        String attributeValue2 = kXmlParser.getAttributeValue(i6);
                        AttrImpl createAttribute = documentImpl.createAttribute(attributeName2);
                        createAttribute.setValue(attributeValue2);
                        createElement.setAttributeNode(createAttribute);
                        i5 = i6 + 1;
                    }
                    kXmlParser.nextToken();
                    parse(kXmlParser, documentImpl, createElement, 3);
                    kXmlParser.require(3, "", name3);
                }
            }
            eventType = kXmlParser.nextToken();
        }
    }

    private String resolveCharacterReference(String str, int i) {
        try {
            int parseInt = Integer.parseInt(str, i);
            return Character.isBmpCodePoint(parseInt) ? String.valueOf((char) parseInt) : new String(Character.toChars(parseInt));
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private String resolvePredefinedOrCharacterEntity(String str) {
        if (str.startsWith("#x")) {
            return resolveCharacterReference(str.substring(2), 16);
        }
        if (str.startsWith("#")) {
            return resolveCharacterReference(str.substring(1), 10);
        }
        if ("lt".equals(str)) {
            return SimpleComparison.LESS_THAN_OPERATION;
        }
        if ("gt".equals(str)) {
            return SimpleComparison.GREATER_THAN_OPERATION;
        }
        if ("amp".equals(str)) {
            return "&";
        }
        if ("apos".equals(str)) {
            return "'";
        }
        if ("quot".equals(str)) {
            return "\"";
        }
        return null;
    }

    @Override // javax.xml.parsers.DocumentBuilder
    public DOMImplementation getDOMImplementation() {
        return dom;
    }

    @Override // javax.xml.parsers.DocumentBuilder
    public boolean isNamespaceAware() {
        return this.namespaceAware;
    }

    @Override // javax.xml.parsers.DocumentBuilder
    public boolean isValidating() {
        return false;
    }

    @Override // javax.xml.parsers.DocumentBuilder
    public Document newDocument() {
        return dom.createDocument(null, null, null);
    }

    @Override // javax.xml.parsers.DocumentBuilder
    public Document parse(InputSource inputSource) throws SAXException, IOException {
        if (inputSource == null) {
            throw new IllegalArgumentException("source == null");
        }
        String encoding = inputSource.getEncoding();
        String systemId = inputSource.getSystemId();
        DocumentImpl documentImpl = new DocumentImpl(dom, null, null, null, encoding);
        documentImpl.setDocumentURI(systemId);
        KXmlParser kXmlParser = new KXmlParser();
        try {
            try {
                kXmlParser.keepNamespaceAttributes();
                kXmlParser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, this.namespaceAware);
                if (inputSource.getByteStream() != null) {
                    kXmlParser.setInput(inputSource.getByteStream(), encoding);
                } else if (inputSource.getCharacterStream() != null) {
                    kXmlParser.setInput(inputSource.getCharacterStream());
                } else if (systemId == null) {
                    throw new SAXParseException("InputSource needs a stream, reader or URI", null);
                } else {
                    URLConnection openConnection = new URL(systemId).openConnection();
                    openConnection.connect();
                    kXmlParser.setInput(openConnection.getInputStream(), encoding);
                }
                if (kXmlParser.nextToken() == 1) {
                    throw new SAXParseException("Unexpected end of document", null);
                }
                parse(kXmlParser, documentImpl, documentImpl, 1);
                kXmlParser.require(1, null, null);
                return documentImpl;
            } catch (XmlPullParserException e) {
                if (e.getDetail() instanceof IOException) {
                    throw ((IOException) e.getDetail());
                }
                if (e.getDetail() instanceof RuntimeException) {
                    throw ((RuntimeException) e.getDetail());
                }
                LocatorImpl locatorImpl = new LocatorImpl();
                locatorImpl.setPublicId(inputSource.getPublicId());
                locatorImpl.setSystemId(systemId);
                locatorImpl.setLineNumber(e.getLineNumber());
                locatorImpl.setColumnNumber(e.getColumnNumber());
                SAXParseException sAXParseException = new SAXParseException(e.getMessage(), locatorImpl);
                if (this.errorHandler != null) {
                    this.errorHandler.error(sAXParseException);
                }
                throw sAXParseException;
            }
        } finally {
            IoUtils.closeQuietly(kXmlParser);
        }
    }

    @Override // javax.xml.parsers.DocumentBuilder
    public void reset() {
        this.coalescing = false;
        this.entityResolver = null;
        this.errorHandler = null;
        this.ignoreComments = false;
        this.ignoreElementContentWhitespace = false;
        this.namespaceAware = false;
    }

    public void setCoalescing(boolean z) {
        this.coalescing = z;
    }

    @Override // javax.xml.parsers.DocumentBuilder
    public void setEntityResolver(EntityResolver entityResolver) {
        this.entityResolver = entityResolver;
    }

    @Override // javax.xml.parsers.DocumentBuilder
    public void setErrorHandler(ErrorHandler errorHandler) {
        this.errorHandler = errorHandler;
    }

    public void setIgnoreComments(boolean z) {
        this.ignoreComments = z;
    }

    public void setIgnoreElementContentWhitespace(boolean z) {
        this.ignoreElementContentWhitespace = z;
    }

    public void setNamespaceAware(boolean z) {
        this.namespaceAware = z;
    }
}
