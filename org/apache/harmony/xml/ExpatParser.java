package org.apache.harmony.xml;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import libcore.io.IoUtils;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.DTDHandler;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.ext.LexicalHandler;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/xml/ExpatParser.class */
public class ExpatParser {
    private static final int BUFFER_SIZE = 8096;
    static final String CHARACTER_ENCODING = "UTF-16";
    private static final String DEFAULT_ENCODING = "UTF-8";
    private static final String OUTSIDE_START_ELEMENT = "Attributes can only be used within the scope of startElement().";
    private static final int TIMEOUT = 20000;
    private int attributeCount;
    private long attributePointer;
    private final ExpatAttributes attributes;
    private final String encoding;
    private boolean inStartElement;
    private final Locator locator;
    private long pointer;
    private final String publicId;
    private final String systemId;
    private final ExpatReader xmlReader;

    /* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/xml/ExpatParser$ClonedAttributes.class */
    private static class ClonedAttributes extends ExpatAttributes {
        private static final Attributes EMPTY = new ClonedAttributes(0, 0, 0);
        private final int length;
        private final long parserPointer;
        private long pointer;

        private ClonedAttributes(long j, long j2, int i) {
            this.parserPointer = j;
            this.pointer = j2;
            this.length = i;
        }

        protected void finalize() throws Throwable {
            synchronized (this) {
                if (this.pointer != 0) {
                    freeAttributes(this.pointer);
                    this.pointer = 0L;
                }
                super.finalize();
            }
        }

        @Override // org.apache.harmony.xml.ExpatAttributes, org.xml.sax.Attributes
        public int getLength() {
            return this.length;
        }

        @Override // org.apache.harmony.xml.ExpatAttributes
        public long getParserPointer() {
            return this.parserPointer;
        }

        @Override // org.apache.harmony.xml.ExpatAttributes
        public long getPointer() {
            return this.pointer;
        }
    }

    /* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/xml/ExpatParser$CurrentAttributes.class */
    private class CurrentAttributes extends ExpatAttributes {
        private CurrentAttributes() {
        }

        @Override // org.apache.harmony.xml.ExpatAttributes, org.xml.sax.Attributes
        public int getLength() {
            if (ExpatParser.this.inStartElement) {
                return ExpatParser.this.attributeCount;
            }
            throw new IllegalStateException(ExpatParser.OUTSIDE_START_ELEMENT);
        }

        @Override // org.apache.harmony.xml.ExpatAttributes
        public long getParserPointer() {
            return ExpatParser.this.pointer;
        }

        @Override // org.apache.harmony.xml.ExpatAttributes
        public long getPointer() {
            if (ExpatParser.this.inStartElement) {
                return ExpatParser.this.attributePointer;
            }
            throw new IllegalStateException(ExpatParser.OUTSIDE_START_ELEMENT);
        }
    }

    /* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/xml/ExpatParser$EntityParser.class */
    private static class EntityParser extends ExpatParser {
        private int depth;

        private EntityParser(String str, ExpatReader expatReader, long j, String str2, String str3) {
            super(str, expatReader, j, str2, str3);
            this.depth = 0;
        }

        @Override // org.apache.harmony.xml.ExpatParser
        void endElement(String str, String str2, String str3) throws SAXException {
            int i = this.depth - 1;
            this.depth = i;
            if (i > 0) {
                super.endElement(str, str2, str3);
            }
        }

        @Override // org.apache.harmony.xml.ExpatParser
        protected void finalize() throws Throwable {
            synchronized (this) {
            }
        }

        @Override // org.apache.harmony.xml.ExpatParser
        void startElement(String str, String str2, String str3, long j, int i) throws SAXException {
            int i2 = this.depth;
            this.depth = i2 + 1;
            if (i2 > 0) {
                super.startElement(str, str2, str3, j, i);
            }
        }
    }

    /* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/xml/ExpatParser$ExpatLocator.class */
    private class ExpatLocator implements Locator {
        private ExpatLocator() {
        }

        @Override // org.xml.sax.Locator
        public int getColumnNumber() {
            return ExpatParser.this.column();
        }

        @Override // org.xml.sax.Locator
        public int getLineNumber() {
            return ExpatParser.this.line();
        }

        @Override // org.xml.sax.Locator
        public String getPublicId() {
            return ExpatParser.this.publicId;
        }

        @Override // org.xml.sax.Locator
        public String getSystemId() {
            return ExpatParser.this.systemId;
        }

        public String toString() {
            return "Locator[publicId: " + ExpatParser.this.publicId + ", systemId: " + ExpatParser.this.systemId + ", line: " + getLineNumber() + ", column: " + getColumnNumber() + "]";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/xml/ExpatParser$ParseException.class */
    public static class ParseException extends SAXParseException {
        private ParseException(String str, Locator locator) {
            super(makeMessage(str, locator), locator);
        }

        private static String makeMessage(String str, int i, int i2) {
            return "At line " + i + ", column " + i2 + ": " + str;
        }

        private static String makeMessage(String str, Locator locator) {
            return makeMessage(str, locator.getLineNumber(), locator.getColumnNumber());
        }
    }

    static {
        staticInitialize("");
    }

    private ExpatParser(String str, ExpatReader expatReader, long j, String str2, String str3) {
        this.inStartElement = false;
        this.attributeCount = -1;
        this.attributePointer = 0L;
        this.locator = new ExpatLocator();
        this.attributes = new CurrentAttributes();
        this.encoding = str;
        this.xmlReader = expatReader;
        this.pointer = j;
        this.systemId = str3;
        this.publicId = str2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ExpatParser(String str, ExpatReader expatReader, boolean z, String str2, String str3) {
        this.inStartElement = false;
        this.attributeCount = -1;
        this.attributePointer = 0L;
        this.locator = new ExpatLocator();
        this.attributes = new CurrentAttributes();
        this.publicId = str2;
        this.systemId = str3;
        this.xmlReader = expatReader;
        this.encoding = str == null ? "UTF-8" : str;
        this.pointer = initialize(this.encoding, z);
    }

    private native void appendBytes(long j, byte[] bArr, int i, int i2) throws SAXException, ExpatException;

    private native void appendChars(long j, char[] cArr, int i, int i2) throws SAXException, ExpatException;

    private native void appendString(long j, String str, boolean z) throws SAXException, ExpatException;

    private static native long cloneAttributes(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    public int column() {
        return column(this.pointer);
    }

    private static native int column(long j);

    private static native long createEntityParser(long j, String str);

    private void endDocument() throws SAXException {
        ContentHandler contentHandler = this.xmlReader.contentHandler;
        if (contentHandler != null) {
            contentHandler.endDocument();
        }
    }

    private native long initialize(String str, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    public int line() {
        return line(this.pointer);
    }

    private static native int line(long j);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static InputStream openUrl(String str) throws IOException {
        try {
            URLConnection openConnection = new URL(str).openConnection();
            openConnection.setConnectTimeout(20000);
            openConnection.setReadTimeout(20000);
            openConnection.setDoInput(true);
            openConnection.setDoOutput(false);
            return openConnection.getInputStream();
        } catch (Exception e) {
            IOException iOException = new IOException("Couldn't open " + str);
            iOException.initCause(e);
            throw iOException;
        }
    }

    private void parseExternalEntity(ExpatParser expatParser, InputSource inputSource) throws IOException, SAXException {
        Reader characterStream = inputSource.getCharacterStream();
        if (characterStream != null) {
            try {
                expatParser.append("<externalEntity>");
                expatParser.parseFragment(characterStream);
                expatParser.append("</externalEntity>");
                return;
            } finally {
                IoUtils.closeQuietly(characterStream);
            }
        }
        InputStream byteStream = inputSource.getByteStream();
        if (byteStream != null) {
            try {
                expatParser.append("<externalEntity>".getBytes(expatParser.encoding));
                expatParser.parseFragment(byteStream);
                expatParser.append("</externalEntity>".getBytes(expatParser.encoding));
                return;
            } finally {
                IoUtils.closeQuietly(byteStream);
            }
        }
        String systemId = inputSource.getSystemId();
        if (systemId == null) {
            throw new ParseException("No input specified.", this.locator);
        }
        InputStream openUrl = openUrl(systemId);
        try {
            expatParser.append("<externalEntity>".getBytes(expatParser.encoding));
            expatParser.parseFragment(openUrl);
            expatParser.append("</externalEntity>".getBytes(expatParser.encoding));
        } finally {
            IoUtils.closeQuietly(openUrl);
        }
    }

    private void parseFragment(InputStream inputStream) throws IOException, SAXException {
        byte[] bArr = new byte[BUFFER_SIZE];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return;
            }
            try {
                appendBytes(this.pointer, bArr, 0, read);
            } catch (ExpatException e) {
                throw new ParseException(e.getMessage(), this.locator);
            }
        }
    }

    private void parseFragment(Reader reader) throws IOException, SAXException {
        char[] cArr = new char[4048];
        while (true) {
            int read = reader.read(cArr);
            if (read == -1) {
                return;
            }
            try {
                appendChars(this.pointer, cArr, 0, read);
            } catch (ExpatException e) {
                throw new ParseException(e.getMessage(), this.locator);
            }
        }
    }

    private String pickEncoding(InputSource inputSource) {
        String str;
        if (inputSource.getCharacterStream() != null) {
            str = "UTF-16";
        } else {
            String encoding = inputSource.getEncoding();
            str = encoding;
            if (encoding == null) {
                return "UTF-8";
            }
        }
        return str;
    }

    private native void release(long j);

    private static native void releaseParser(long j);

    private void startDocument() throws SAXException {
        ContentHandler contentHandler = this.xmlReader.contentHandler;
        if (contentHandler != null) {
            contentHandler.setDocumentLocator(this.locator);
            contentHandler.startDocument();
        }
    }

    private static native void staticInitialize(String str);

    void append(String str) throws SAXException {
        try {
            appendString(this.pointer, str, false);
        } catch (ExpatException e) {
            throw new ParseException(e.getMessage(), this.locator);
        }
    }

    void append(byte[] bArr) throws SAXException {
        append(bArr, 0, bArr.length);
    }

    void append(byte[] bArr, int i, int i2) throws SAXException {
        try {
            appendBytes(this.pointer, bArr, i, i2);
        } catch (ExpatException e) {
            throw new ParseException(e.getMessage(), this.locator);
        }
    }

    void append(char[] cArr, int i, int i2) throws SAXException {
        try {
            appendChars(this.pointer, cArr, i, i2);
        } catch (ExpatException e) {
            throw new ParseException(e.getMessage(), this.locator);
        }
    }

    Attributes cloneAttributes() {
        if (this.inStartElement) {
            if (this.attributeCount == 0) {
                return ClonedAttributes.EMPTY;
            }
            return new ClonedAttributes(this.pointer, cloneAttributes(this.attributePointer, this.attributeCount), this.attributeCount);
        }
        throw new IllegalStateException(OUTSIDE_START_ELEMENT);
    }

    void comment(char[] cArr, int i) throws SAXException {
        LexicalHandler lexicalHandler = this.xmlReader.lexicalHandler;
        if (lexicalHandler != null) {
            lexicalHandler.comment(cArr, 0, i);
        }
    }

    void endCdata() throws SAXException {
        LexicalHandler lexicalHandler = this.xmlReader.lexicalHandler;
        if (lexicalHandler != null) {
            lexicalHandler.endCDATA();
        }
    }

    void endDtd() throws SAXException {
        LexicalHandler lexicalHandler = this.xmlReader.lexicalHandler;
        if (lexicalHandler != null) {
            lexicalHandler.endDTD();
        }
    }

    void endElement(String str, String str2, String str3) throws SAXException {
        ContentHandler contentHandler = this.xmlReader.contentHandler;
        if (contentHandler != null) {
            contentHandler.endElement(str, str2, str3);
        }
    }

    void endNamespace(String str) throws SAXException {
        ContentHandler contentHandler = this.xmlReader.contentHandler;
        if (contentHandler != null) {
            contentHandler.endPrefixMapping(str);
        }
    }

    protected void finalize() throws Throwable {
        synchronized (this) {
            if (this.pointer != 0) {
                release(this.pointer);
                this.pointer = 0L;
            }
            super.finalize();
        }
    }

    void finish() throws SAXException {
        try {
            appendString(this.pointer, "", true);
        } catch (ExpatException e) {
            throw new ParseException(e.getMessage(), this.locator);
        }
    }

    void handleExternalEntity(String str, String str2, String str3) throws SAXException, IOException {
        EntityResolver entityResolver = this.xmlReader.entityResolver;
        if (entityResolver == null) {
            return;
        }
        String str4 = str3;
        if (this.systemId != null) {
            try {
                URI uri = new URI(str3);
                str4 = str3;
                if (!uri.isAbsolute()) {
                    str4 = str3;
                    if (!uri.isOpaque()) {
                        str4 = new URI(this.systemId).resolve(uri).toString();
                    }
                }
            } catch (Exception e) {
                System.logI("Could not resolve '" + str3 + "' relative to '" + this.systemId + "' at " + this.locator, e);
                str4 = str3;
            }
        }
        InputSource resolveEntity = entityResolver.resolveEntity(str2, str4);
        if (resolveEntity != null) {
            String pickEncoding = pickEncoding(resolveEntity);
            long createEntityParser = createEntityParser(this.pointer, str);
            try {
                parseExternalEntity(new EntityParser(pickEncoding, this.xmlReader, createEntityParser, resolveEntity.getPublicId(), resolveEntity.getSystemId()), resolveEntity);
            } finally {
                releaseParser(createEntityParser);
            }
        }
    }

    void notationDecl(String str, String str2, String str3) throws SAXException {
        DTDHandler dTDHandler = this.xmlReader.dtdHandler;
        if (dTDHandler != null) {
            dTDHandler.notationDecl(str, str2, str3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void parseDocument(InputStream inputStream) throws IOException, SAXException {
        startDocument();
        parseFragment(inputStream);
        finish();
        endDocument();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void parseDocument(Reader reader) throws IOException, SAXException {
        startDocument();
        parseFragment(reader);
        finish();
        endDocument();
    }

    void processingInstruction(String str, String str2) throws SAXException {
        ContentHandler contentHandler = this.xmlReader.contentHandler;
        if (contentHandler != null) {
            contentHandler.processingInstruction(str, str2);
        }
    }

    void startCdata() throws SAXException {
        LexicalHandler lexicalHandler = this.xmlReader.lexicalHandler;
        if (lexicalHandler != null) {
            lexicalHandler.startCDATA();
        }
    }

    void startDtd(String str, String str2, String str3) throws SAXException {
        LexicalHandler lexicalHandler = this.xmlReader.lexicalHandler;
        if (lexicalHandler != null) {
            lexicalHandler.startDTD(str, str2, str3);
        }
    }

    void startElement(String str, String str2, String str3, long j, int i) throws SAXException {
        ContentHandler contentHandler = this.xmlReader.contentHandler;
        if (contentHandler == null) {
            return;
        }
        try {
            this.inStartElement = true;
            this.attributePointer = j;
            this.attributeCount = i;
            contentHandler.startElement(str, str2, str3, this.attributes);
        } finally {
            this.inStartElement = false;
            this.attributeCount = -1;
            this.attributePointer = 0L;
        }
    }

    void startNamespace(String str, String str2) throws SAXException {
        ContentHandler contentHandler = this.xmlReader.contentHandler;
        if (contentHandler != null) {
            contentHandler.startPrefixMapping(str, str2);
        }
    }

    void text(char[] cArr, int i) throws SAXException {
        ContentHandler contentHandler = this.xmlReader.contentHandler;
        if (contentHandler != null) {
            contentHandler.characters(cArr, 0, i);
        }
    }

    void unparsedEntityDecl(String str, String str2, String str3, String str4) throws SAXException {
        DTDHandler dTDHandler = this.xmlReader.dtdHandler;
        if (dTDHandler != null) {
            dTDHandler.unparsedEntityDecl(str, str2, str3, str4);
        }
    }
}
