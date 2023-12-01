package org.apache.harmony.xml;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import libcore.io.IoUtils;
import org.xml.sax.ContentHandler;
import org.xml.sax.DTDHandler;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;
import org.xml.sax.XMLReader;
import org.xml.sax.ext.LexicalHandler;

/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/xml/ExpatReader.class */
public class ExpatReader implements XMLReader {
    private static final String LEXICAL_HANDLER_PROPERTY = "http://xml.org/sax/properties/lexical-handler";
    ContentHandler contentHandler;
    DTDHandler dtdHandler;
    EntityResolver entityResolver;
    ErrorHandler errorHandler;
    LexicalHandler lexicalHandler;
    private boolean processNamespaces = true;
    private boolean processNamespacePrefixes = false;

    /* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/xml/ExpatReader$Feature.class */
    private static class Feature {
        private static final String BASE_URI = "http://xml.org/sax/features/";
        private static final String EXTERNAL_GENERAL_ENTITIES = "http://xml.org/sax/features/external-general-entities";
        private static final String EXTERNAL_PARAMETER_ENTITIES = "http://xml.org/sax/features/external-parameter-entities";
        private static final String NAMESPACES = "http://xml.org/sax/features/namespaces";
        private static final String NAMESPACE_PREFIXES = "http://xml.org/sax/features/namespace-prefixes";
        private static final String STRING_INTERNING = "http://xml.org/sax/features/string-interning";
        private static final String VALIDATION = "http://xml.org/sax/features/validation";

        private Feature() {
        }
    }

    private void parse(InputStream inputStream, String str, String str2, String str3) throws IOException, SAXException {
        new ExpatParser(str, this, this.processNamespaces, str2, str3).parseDocument(inputStream);
    }

    private void parse(Reader reader, String str, String str2) throws IOException, SAXException {
        new ExpatParser("UTF-16", this, this.processNamespaces, str, str2).parseDocument(reader);
    }

    @Override // org.xml.sax.XMLReader
    public ContentHandler getContentHandler() {
        return this.contentHandler;
    }

    @Override // org.xml.sax.XMLReader
    public DTDHandler getDTDHandler() {
        return this.dtdHandler;
    }

    @Override // org.xml.sax.XMLReader
    public EntityResolver getEntityResolver() {
        return this.entityResolver;
    }

    @Override // org.xml.sax.XMLReader
    public ErrorHandler getErrorHandler() {
        return this.errorHandler;
    }

    @Override // org.xml.sax.XMLReader
    public boolean getFeature(String str) throws SAXNotRecognizedException, SAXNotSupportedException {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        if (str.equals("http://xml.org/sax/features/validation") || str.equals("http://xml.org/sax/features/external-general-entities") || str.equals("http://xml.org/sax/features/external-parameter-entities")) {
            return false;
        }
        if (str.equals("http://xml.org/sax/features/namespaces")) {
            return this.processNamespaces;
        }
        if (str.equals("http://xml.org/sax/features/namespace-prefixes")) {
            return this.processNamespacePrefixes;
        }
        if (str.equals("http://xml.org/sax/features/string-interning")) {
            return true;
        }
        throw new SAXNotRecognizedException(str);
    }

    public LexicalHandler getLexicalHandler() {
        return this.lexicalHandler;
    }

    @Override // org.xml.sax.XMLReader
    public Object getProperty(String str) throws SAXNotRecognizedException, SAXNotSupportedException {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        if (str.equals(LEXICAL_HANDLER_PROPERTY)) {
            return this.lexicalHandler;
        }
        throw new SAXNotRecognizedException(str);
    }

    public boolean isNamespaceProcessingEnabled() {
        return this.processNamespaces;
    }

    @Override // org.xml.sax.XMLReader
    public void parse(String str) throws IOException, SAXException {
        parse(new InputSource(str));
    }

    @Override // org.xml.sax.XMLReader
    public void parse(InputSource inputSource) throws IOException, SAXException {
        if (this.processNamespacePrefixes && this.processNamespaces) {
            throw new SAXNotSupportedException("The 'namespace-prefix' feature is not supported while the 'namespaces' feature is enabled.");
        }
        Reader characterStream = inputSource.getCharacterStream();
        if (characterStream != null) {
            try {
                parse(characterStream, inputSource.getPublicId(), inputSource.getSystemId());
                return;
            } finally {
                IoUtils.closeQuietly(characterStream);
            }
        }
        InputStream byteStream = inputSource.getByteStream();
        String encoding = inputSource.getEncoding();
        if (byteStream != null) {
            try {
                parse(byteStream, encoding, inputSource.getPublicId(), inputSource.getSystemId());
                return;
            } finally {
                IoUtils.closeQuietly(byteStream);
            }
        }
        String systemId = inputSource.getSystemId();
        if (systemId == null) {
            throw new SAXException("No input specified.");
        }
        InputStream openUrl = ExpatParser.openUrl(systemId);
        try {
            parse(openUrl, encoding, inputSource.getPublicId(), systemId);
        } finally {
            IoUtils.closeQuietly(openUrl);
        }
    }

    @Override // org.xml.sax.XMLReader
    public void setContentHandler(ContentHandler contentHandler) {
        this.contentHandler = contentHandler;
    }

    @Override // org.xml.sax.XMLReader
    public void setDTDHandler(DTDHandler dTDHandler) {
        this.dtdHandler = dTDHandler;
    }

    @Override // org.xml.sax.XMLReader
    public void setEntityResolver(EntityResolver entityResolver) {
        this.entityResolver = entityResolver;
    }

    @Override // org.xml.sax.XMLReader
    public void setErrorHandler(ErrorHandler errorHandler) {
        this.errorHandler = errorHandler;
    }

    @Override // org.xml.sax.XMLReader
    public void setFeature(String str, boolean z) throws SAXNotRecognizedException, SAXNotSupportedException {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        if (str.equals("http://xml.org/sax/features/validation") || str.equals("http://xml.org/sax/features/external-general-entities") || str.equals("http://xml.org/sax/features/external-parameter-entities")) {
            if (z) {
                throw new SAXNotSupportedException("Cannot enable " + str);
            }
        } else if (str.equals("http://xml.org/sax/features/namespaces")) {
            this.processNamespaces = z;
        } else if (str.equals("http://xml.org/sax/features/namespace-prefixes")) {
            this.processNamespacePrefixes = z;
        } else if (!str.equals("http://xml.org/sax/features/string-interning")) {
            throw new SAXNotRecognizedException(str);
        } else {
            if (!z) {
                throw new SAXNotSupportedException("Cannot disable " + str);
            }
        }
    }

    public void setLexicalHandler(LexicalHandler lexicalHandler) {
        this.lexicalHandler = lexicalHandler;
    }

    public void setNamespaceProcessingEnabled(boolean z) {
        this.processNamespaces = z;
    }

    @Override // org.xml.sax.XMLReader
    public void setProperty(String str, Object obj) throws SAXNotRecognizedException, SAXNotSupportedException {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        if (!str.equals(LEXICAL_HANDLER_PROPERTY)) {
            throw new SAXNotRecognizedException(str);
        }
        if (!(obj instanceof LexicalHandler) && obj != null) {
            throw new SAXNotSupportedException("value doesn't implement org.xml.sax.ext.LexicalHandler");
        }
        this.lexicalHandler = (LexicalHandler) obj;
    }
}
