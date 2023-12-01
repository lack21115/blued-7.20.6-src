package org.xmlpull.v1.sax2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.DTDHandler;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* loaded from: source-2895416-dex2jar.jar:org/xmlpull/v1/sax2/Driver.class */
public class Driver implements Locator, XMLReader, Attributes {
    protected static final String APACHE_DYNAMIC_VALIDATION_FEATURE = "http://apache.org/xml/features/validation/dynamic";
    protected static final String APACHE_SCHEMA_VALIDATION_FEATURE = "http://apache.org/xml/features/validation/schema";
    protected static final String DECLARATION_HANDLER_PROPERTY = "http://xml.org/sax/properties/declaration-handler";
    protected static final String LEXICAL_HANDLER_PROPERTY = "http://xml.org/sax/properties/lexical-handler";
    protected static final String NAMESPACES_FEATURE = "http://xml.org/sax/features/namespaces";
    protected static final String NAMESPACE_PREFIXES_FEATURE = "http://xml.org/sax/features/namespace-prefixes";
    protected static final String VALIDATION_FEATURE = "http://xml.org/sax/features/validation";
    protected ContentHandler contentHandler = new DefaultHandler();
    protected ErrorHandler errorHandler = new DefaultHandler();
    protected XmlPullParser pp;
    protected String systemId;

    public Driver() throws XmlPullParserException {
        XmlPullParserFactory newInstance = XmlPullParserFactory.newInstance();
        newInstance.setNamespaceAware(true);
        this.pp = newInstance.newPullParser();
    }

    public Driver(XmlPullParser xmlPullParser) throws XmlPullParserException {
        this.pp = xmlPullParser;
    }

    @Override // org.xml.sax.Locator
    public int getColumnNumber() {
        return this.pp.getColumnNumber();
    }

    @Override // org.xml.sax.XMLReader
    public ContentHandler getContentHandler() {
        return this.contentHandler;
    }

    @Override // org.xml.sax.XMLReader
    public DTDHandler getDTDHandler() {
        return null;
    }

    @Override // org.xml.sax.XMLReader
    public EntityResolver getEntityResolver() {
        return null;
    }

    @Override // org.xml.sax.XMLReader
    public ErrorHandler getErrorHandler() {
        return this.errorHandler;
    }

    @Override // org.xml.sax.XMLReader
    public boolean getFeature(String str) throws SAXNotRecognizedException, SAXNotSupportedException {
        return NAMESPACES_FEATURE.equals(str) ? this.pp.getFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES) : NAMESPACE_PREFIXES_FEATURE.equals(str) ? this.pp.getFeature(XmlPullParser.FEATURE_REPORT_NAMESPACE_ATTRIBUTES) : VALIDATION_FEATURE.equals(str) ? this.pp.getFeature(XmlPullParser.FEATURE_VALIDATION) : this.pp.getFeature(str);
    }

    @Override // org.xml.sax.Attributes
    public int getIndex(String str) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.pp.getAttributeCount()) {
                return -1;
            }
            if (this.pp.getAttributeName(i2).equals(str)) {
                return i2;
            }
            i = i2 + 1;
        }
    }

    @Override // org.xml.sax.Attributes
    public int getIndex(String str, String str2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.pp.getAttributeCount()) {
                return -1;
            }
            if (this.pp.getAttributeNamespace(i2).equals(str) && this.pp.getAttributeName(i2).equals(str2)) {
                return i2;
            }
            i = i2 + 1;
        }
    }

    @Override // org.xml.sax.Attributes
    public int getLength() {
        return this.pp.getAttributeCount();
    }

    @Override // org.xml.sax.Locator
    public int getLineNumber() {
        return this.pp.getLineNumber();
    }

    @Override // org.xml.sax.Attributes
    public String getLocalName(int i) {
        return this.pp.getAttributeName(i);
    }

    @Override // org.xml.sax.XMLReader
    public Object getProperty(String str) throws SAXNotRecognizedException, SAXNotSupportedException {
        if (DECLARATION_HANDLER_PROPERTY.equals(str) || LEXICAL_HANDLER_PROPERTY.equals(str)) {
            return null;
        }
        return this.pp.getProperty(str);
    }

    @Override // org.xml.sax.Locator
    public String getPublicId() {
        return null;
    }

    @Override // org.xml.sax.Attributes
    public String getQName(int i) {
        String attributePrefix = this.pp.getAttributePrefix(i);
        return attributePrefix != null ? attributePrefix + ':' + this.pp.getAttributeName(i) : this.pp.getAttributeName(i);
    }

    @Override // org.xml.sax.Locator
    public String getSystemId() {
        return this.systemId;
    }

    @Override // org.xml.sax.Attributes
    public String getType(int i) {
        return this.pp.getAttributeType(i);
    }

    @Override // org.xml.sax.Attributes
    public String getType(String str) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.pp.getAttributeCount()) {
                return null;
            }
            if (this.pp.getAttributeName(i2).equals(str)) {
                return this.pp.getAttributeType(i2);
            }
            i = i2 + 1;
        }
    }

    @Override // org.xml.sax.Attributes
    public String getType(String str, String str2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.pp.getAttributeCount()) {
                return null;
            }
            if (this.pp.getAttributeNamespace(i2).equals(str) && this.pp.getAttributeName(i2).equals(str2)) {
                return this.pp.getAttributeType(i2);
            }
            i = i2 + 1;
        }
    }

    @Override // org.xml.sax.Attributes
    public String getURI(int i) {
        return this.pp.getAttributeNamespace(i);
    }

    @Override // org.xml.sax.Attributes
    public String getValue(int i) {
        return this.pp.getAttributeValue(i);
    }

    @Override // org.xml.sax.Attributes
    public String getValue(String str) {
        return this.pp.getAttributeValue(null, str);
    }

    @Override // org.xml.sax.Attributes
    public String getValue(String str, String str2) {
        return this.pp.getAttributeValue(str, str2);
    }

    @Override // org.xml.sax.XMLReader
    public void parse(String str) throws SAXException, IOException {
        parse(new InputSource(str));
    }

    @Override // org.xml.sax.XMLReader
    public void parse(InputSource inputSource) throws SAXException, IOException {
        this.systemId = inputSource.getSystemId();
        this.contentHandler.setDocumentLocator(this);
        Reader characterStream = inputSource.getCharacterStream();
        try {
            if (characterStream == null) {
                InputStream byteStream = inputSource.getByteStream();
                String encoding = inputSource.getEncoding();
                FileInputStream fileInputStream = byteStream;
                if (byteStream == null) {
                    this.systemId = inputSource.getSystemId();
                    if (this.systemId == null) {
                        this.errorHandler.fatalError(new SAXParseException("null source systemId", this));
                        return;
                    }
                    try {
                        fileInputStream = new URL(this.systemId).openStream();
                    } catch (MalformedURLException e) {
                        try {
                            fileInputStream = new FileInputStream(this.systemId);
                        } catch (FileNotFoundException e2) {
                            this.errorHandler.fatalError(new SAXParseException("could not open file with systemId " + this.systemId, this, e2));
                            return;
                        }
                    }
                }
                this.pp.setInput(fileInputStream, encoding);
            } else {
                this.pp.setInput(characterStream);
            }
            try {
                this.contentHandler.startDocument();
                this.pp.next();
                if (this.pp.getEventType() != 2) {
                    this.errorHandler.fatalError(new SAXParseException("expected start tag not" + this.pp.getPositionDescription(), this));
                    return;
                }
                parseSubTree(this.pp);
                this.contentHandler.endDocument();
            } catch (XmlPullParserException e3) {
                this.errorHandler.fatalError(new SAXParseException("parsing initialization error: " + e3, this, e3));
            }
        } catch (XmlPullParserException e4) {
            this.errorHandler.fatalError(new SAXParseException("parsing initialization error: " + e4, this, e4));
        }
    }

    public void parseSubTree(XmlPullParser xmlPullParser) throws SAXException, IOException {
        this.pp = xmlPullParser;
        boolean feature = xmlPullParser.getFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES);
        try {
            if (xmlPullParser.getEventType() != 2) {
                throw new SAXException("start tag must be read before skiping subtree" + xmlPullParser.getPositionDescription());
            }
            int[] iArr = new int[2];
            StringBuilder sb = new StringBuilder(16);
            int depth = xmlPullParser.getDepth() - 1;
            int i = 2;
            do {
                switch (i) {
                    case 1:
                        return;
                    case 2:
                        if (feature) {
                            int depth2 = xmlPullParser.getDepth() - 1;
                            int namespaceCount = xmlPullParser.getNamespaceCount(depth2 + 1);
                            for (int namespaceCount2 = depth > depth2 ? xmlPullParser.getNamespaceCount(depth2) : 0; namespaceCount2 < namespaceCount; namespaceCount2++) {
                                this.contentHandler.startPrefixMapping(xmlPullParser.getNamespacePrefix(namespaceCount2), xmlPullParser.getNamespaceUri(namespaceCount2));
                            }
                            String name = xmlPullParser.getName();
                            String prefix = xmlPullParser.getPrefix();
                            if (prefix != null) {
                                sb.setLength(0);
                                sb.append(prefix);
                                sb.append(':');
                                sb.append(name);
                            }
                            startElement(xmlPullParser.getNamespace(), name, prefix == null ? name : sb.toString());
                            break;
                        } else {
                            startElement(xmlPullParser.getNamespace(), xmlPullParser.getName(), xmlPullParser.getName());
                            break;
                        }
                    case 3:
                        if (!feature) {
                            this.contentHandler.endElement(xmlPullParser.getNamespace(), xmlPullParser.getName(), xmlPullParser.getName());
                            break;
                        } else {
                            String name2 = xmlPullParser.getName();
                            String prefix2 = xmlPullParser.getPrefix();
                            if (prefix2 != null) {
                                sb.setLength(0);
                                sb.append(prefix2);
                                sb.append(':');
                                sb.append(name2);
                            }
                            this.contentHandler.endElement(xmlPullParser.getNamespace(), name2, prefix2 != null ? name2 : sb.toString());
                            int namespaceCount3 = depth > xmlPullParser.getDepth() ? xmlPullParser.getNamespaceCount(xmlPullParser.getDepth()) : 0;
                            int namespaceCount4 = xmlPullParser.getNamespaceCount(xmlPullParser.getDepth() - 1);
                            while (true) {
                                int i2 = namespaceCount4 - 1;
                                if (i2 < namespaceCount3) {
                                    break;
                                } else {
                                    this.contentHandler.endPrefixMapping(xmlPullParser.getNamespacePrefix(i2));
                                    namespaceCount4 = i2;
                                }
                            }
                        }
                    case 4:
                        this.contentHandler.characters(xmlPullParser.getTextCharacters(iArr), iArr[0], iArr[1]);
                        break;
                }
                i = xmlPullParser.next();
            } while (xmlPullParser.getDepth() > depth);
        } catch (XmlPullParserException e) {
            SAXParseException sAXParseException = new SAXParseException("parsing error: " + e, this, e);
            e.printStackTrace();
            this.errorHandler.fatalError(sAXParseException);
        }
    }

    @Override // org.xml.sax.XMLReader
    public void setContentHandler(ContentHandler contentHandler) {
        this.contentHandler = contentHandler;
    }

    @Override // org.xml.sax.XMLReader
    public void setDTDHandler(DTDHandler dTDHandler) {
    }

    @Override // org.xml.sax.XMLReader
    public void setEntityResolver(EntityResolver entityResolver) {
    }

    @Override // org.xml.sax.XMLReader
    public void setErrorHandler(ErrorHandler errorHandler) {
        this.errorHandler = errorHandler;
    }

    @Override // org.xml.sax.XMLReader
    public void setFeature(String str, boolean z) throws SAXNotRecognizedException, SAXNotSupportedException {
        try {
            if (NAMESPACES_FEATURE.equals(str)) {
                this.pp.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, z);
            } else if (NAMESPACE_PREFIXES_FEATURE.equals(str)) {
                if (this.pp.getFeature(XmlPullParser.FEATURE_REPORT_NAMESPACE_ATTRIBUTES) != z) {
                    this.pp.setFeature(XmlPullParser.FEATURE_REPORT_NAMESPACE_ATTRIBUTES, z);
                }
            } else if (VALIDATION_FEATURE.equals(str)) {
                this.pp.setFeature(XmlPullParser.FEATURE_VALIDATION, z);
            } else {
                this.pp.setFeature(str, z);
            }
        } catch (XmlPullParserException e) {
        }
    }

    @Override // org.xml.sax.XMLReader
    public void setProperty(String str, Object obj) throws SAXNotRecognizedException, SAXNotSupportedException {
        if (DECLARATION_HANDLER_PROPERTY.equals(str)) {
            throw new SAXNotSupportedException("not supported setting property " + str);
        }
        if (LEXICAL_HANDLER_PROPERTY.equals(str)) {
            throw new SAXNotSupportedException("not supported setting property " + str);
        }
        try {
            this.pp.setProperty(str, obj);
        } catch (XmlPullParserException e) {
            throw new SAXNotSupportedException("not supported set property " + str + ": " + e);
        }
    }

    protected void startElement(String str, String str2, String str3) throws SAXException {
        this.contentHandler.startElement(str, str2, str3, this);
    }
}
