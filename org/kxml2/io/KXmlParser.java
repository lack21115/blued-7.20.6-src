package org.kxml2.io;

import com.alipay.sdk.sys.a;
import com.alipay.sdk.util.i;
import com.android.internal.telephony.SmsConstants;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;
import javax.xml.XMLConstants;
import javax.xml.transform.OutputKeys;
import libcore.internal.StringPool;
import org.apache.commons.codec.CharEncoding;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: source-2895416-dex2jar.jar:org/kxml2/io/KXmlParser.class */
public class KXmlParser implements XmlPullParser, Closeable {
    private static final char[] ANY;
    private static final int ATTLISTDECL = 13;
    private static final char[] COMMENT_DOUBLE_DASH;
    private static final Map<String, String> DEFAULT_ENTITIES = new HashMap();
    private static final char[] DOUBLE_QUOTE;
    private static final int ELEMENTDECL = 11;
    private static final char[] EMPTY;
    private static final char[] END_CDATA;
    private static final char[] END_COMMENT;
    private static final char[] END_PROCESSING_INSTRUCTION;
    private static final int ENTITYDECL = 12;
    private static final String FEATURE_RELAXED = "http://xmlpull.org/v1/doc/features.html#relaxed";
    private static final char[] FIXED;
    private static final String ILLEGAL_TYPE = "Wrong event type";
    private static final char[] IMPLIED;
    private static final char[] NDATA;
    private static final char[] NOTATION;
    private static final int NOTATIONDECL = 14;
    private static final int PARAMETER_ENTITY_REF = 15;
    private static final String PROPERTY_LOCATION = "http://xmlpull.org/v1/doc/properties.html#location";
    private static final String PROPERTY_XMLDECL_STANDALONE = "http://xmlpull.org/v1/doc/properties.html#xmldecl-standalone";
    private static final String PROPERTY_XMLDECL_VERSION = "http://xmlpull.org/v1/doc/properties.html#xmldecl-version";
    private static final char[] PUBLIC;
    private static final char[] REQUIRED;
    private static final char[] SINGLE_QUOTE;
    private static final char[] START_ATTLIST;
    private static final char[] START_CDATA;
    private static final char[] START_COMMENT;
    private static final char[] START_DOCTYPE;
    private static final char[] START_ELEMENT;
    private static final char[] START_ENTITY;
    private static final char[] START_NOTATION;
    private static final char[] START_PROCESSING_INSTRUCTION;
    private static final char[] SYSTEM;
    private static final String UNEXPECTED_EOF = "Unexpected EOF";
    private static final int XML_DECLARATION = 998;
    private int attributeCount;
    private StringBuilder bufferCapture;
    private int bufferStartColumn;
    private int bufferStartLine;
    private Map<String, Map<String, String>> defaultAttributes;
    private boolean degenerated;
    private int depth;
    private Map<String, char[]> documentEntities;
    private String encoding;
    private String error;
    private boolean isWhitespace;
    private boolean keepNamespaceAttributes;
    private String location;
    private String name;
    private String namespace;
    private ContentSource nextContentSource;
    private boolean parsedTopLevelStartTag;
    private String prefix;
    private boolean processDocDecl;
    private boolean processNsp;
    private String publicId;
    private Reader reader;
    private boolean relaxed;
    private String rootElementName;
    private Boolean standalone;
    private String systemId;
    private String text;
    private int type;
    private boolean unresolved;
    private String version;
    private String[] elementStack = new String[16];
    private String[] nspStack = new String[8];
    private int[] nspCounts = new int[4];
    private char[] buffer = new char[8192];
    private int position = 0;
    private int limit = 0;
    private String[] attributes = new String[16];
    public final StringPool stringPool = new StringPool();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-2895416-dex2jar.jar:org/kxml2/io/KXmlParser$ContentSource.class */
    public static class ContentSource {
        private final char[] buffer;
        private final int limit;
        private final ContentSource next;
        private final int position;

        ContentSource(ContentSource contentSource, char[] cArr, int i, int i2) {
            this.next = contentSource;
            this.buffer = cArr;
            this.position = i;
            this.limit = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-2895416-dex2jar.jar:org/kxml2/io/KXmlParser$ValueContext.class */
    public enum ValueContext {
        ATTRIBUTE,
        TEXT,
        ENTITY_DECLARATION
    }

    static {
        DEFAULT_ENTITIES.put("lt", "<");
        DEFAULT_ENTITIES.put("gt", ">");
        DEFAULT_ENTITIES.put("amp", a.b);
        DEFAULT_ENTITIES.put("apos", "'");
        DEFAULT_ENTITIES.put("quot", "\"");
        START_COMMENT = new char[]{'<', '!', '-', '-'};
        END_COMMENT = new char[]{'-', '-', '>'};
        COMMENT_DOUBLE_DASH = new char[]{'-', '-'};
        START_CDATA = new char[]{'<', '!', '[', 'C', 'D', 'A', 'T', 'A', '['};
        END_CDATA = new char[]{']', ']', '>'};
        START_PROCESSING_INSTRUCTION = new char[]{'<', '?'};
        END_PROCESSING_INSTRUCTION = new char[]{'?', '>'};
        START_DOCTYPE = new char[]{'<', '!', 'D', 'O', 'C', 'T', 'Y', 'P', 'E'};
        SYSTEM = new char[]{'S', 'Y', 'S', 'T', 'E', 'M'};
        PUBLIC = new char[]{'P', 'U', 'B', 'L', 'I', 'C'};
        START_ELEMENT = new char[]{'<', '!', 'E', 'L', 'E', 'M', 'E', 'N', 'T'};
        START_ATTLIST = new char[]{'<', '!', 'A', 'T', 'T', 'L', 'I', 'S', 'T'};
        START_ENTITY = new char[]{'<', '!', 'E', 'N', 'T', 'I', 'T', 'Y'};
        START_NOTATION = new char[]{'<', '!', 'N', 'O', 'T', 'A', 'T', 'I', 'O', 'N'};
        EMPTY = new char[]{'E', 'M', 'P', 'T', 'Y'};
        ANY = new char[]{'A', 'N', 'Y'};
        NDATA = new char[]{'N', 'D', 'A', 'T', 'A'};
        NOTATION = new char[]{'N', 'O', 'T', 'A', 'T', 'I', 'O', 'N'};
        REQUIRED = new char[]{'R', 'E', 'Q', 'U', 'I', 'R', 'E', 'D'};
        IMPLIED = new char[]{'I', 'M', 'P', 'L', 'I', 'E', 'D'};
        FIXED = new char[]{'F', 'I', 'X', 'E', 'D'};
        SINGLE_QUOTE = new char[]{'\''};
        DOUBLE_QUOTE = new char[]{'\"'};
    }

    private boolean adjustNsp() throws XmlPullParserException {
        boolean z;
        int i;
        String str;
        String str2;
        boolean z2 = false;
        int i2 = 0;
        while (i2 < (this.attributeCount << 2)) {
            String str3 = this.attributes[i2 + 2];
            int indexOf = str3.indexOf(58);
            if (indexOf != -1) {
                str = str3.substring(0, indexOf);
                str2 = str3.substring(indexOf + 1);
            } else {
                z = z2;
                i = i2;
                if (str3.equals(XMLConstants.XMLNS_ATTRIBUTE)) {
                    str = str3;
                    str2 = null;
                } else {
                    i2 = i + 4;
                    z2 = z;
                }
            }
            if (str.equals(XMLConstants.XMLNS_ATTRIBUTE)) {
                int[] iArr = this.nspCounts;
                int i3 = this.depth;
                int i4 = iArr[i3];
                iArr[i3] = i4 + 1;
                int i5 = i4 << 1;
                this.nspStack = ensureCapacity(this.nspStack, i5 + 2);
                this.nspStack[i5] = str2;
                this.nspStack[i5 + 1] = this.attributes[i2 + 3];
                if (str2 != null && this.attributes[i2 + 3].isEmpty()) {
                    checkRelaxed("illegal empty namespace");
                }
                if (this.keepNamespaceAttributes) {
                    this.attributes[i2] = XMLConstants.XMLNS_ATTRIBUTE_NS_URI;
                    z = true;
                    i = i2;
                } else {
                    String[] strArr = this.attributes;
                    String[] strArr2 = this.attributes;
                    int i6 = this.attributeCount - 1;
                    this.attributeCount = i6;
                    System.arraycopy(strArr, i2 + 4, strArr2, i2, (i6 << 2) - i2);
                    i = i2 - 4;
                    z = z2;
                }
            } else {
                z = true;
                i = i2;
            }
            i2 = i + 4;
            z2 = z;
        }
        if (z2) {
            int i7 = this.attributeCount << 2;
            while (true) {
                int i8 = i7 - 4;
                if (i8 < 0) {
                    break;
                }
                String str4 = this.attributes[i8 + 2];
                int indexOf2 = str4.indexOf(58);
                if (indexOf2 == 0 && !this.relaxed) {
                    throw new RuntimeException("illegal attribute name: " + str4 + " at " + this);
                }
                if (indexOf2 != -1) {
                    String substring = str4.substring(0, indexOf2);
                    String substring2 = str4.substring(indexOf2 + 1);
                    String namespace = getNamespace(substring);
                    if (namespace == null && !this.relaxed) {
                        throw new RuntimeException("Undefined Prefix: " + substring + " in " + this);
                    }
                    this.attributes[i8] = namespace;
                    this.attributes[i8 + 1] = substring;
                    this.attributes[i8 + 2] = substring2;
                }
                i7 = i8;
            }
        }
        int indexOf3 = this.name.indexOf(58);
        if (indexOf3 == 0) {
            checkRelaxed("illegal tag name: " + this.name);
        }
        if (indexOf3 != -1) {
            this.prefix = this.name.substring(0, indexOf3);
            this.name = this.name.substring(indexOf3 + 1);
        }
        this.namespace = getNamespace(this.prefix);
        if (this.namespace == null) {
            if (this.prefix != null) {
                checkRelaxed("undefined prefix: " + this.prefix);
            }
            this.namespace = "";
        }
        return z2;
    }

    private void checkRelaxed(String str) throws XmlPullParserException {
        if (!this.relaxed) {
            throw new XmlPullParserException(str, this, null);
        }
        if (this.error == null) {
            this.error = "Error: " + str;
        }
    }

    private void defineAttributeDefault(String str, String str2, String str3) {
        if (this.defaultAttributes == null) {
            this.defaultAttributes = new HashMap();
        }
        Map<String, String> map = this.defaultAttributes.get(str);
        HashMap hashMap = map;
        if (map == null) {
            hashMap = new HashMap();
            this.defaultAttributes.put(str, hashMap);
        }
        hashMap.put(str2, str3);
    }

    private String[] ensureCapacity(String[] strArr, int i) {
        if (strArr.length >= i) {
            return strArr;
        }
        String[] strArr2 = new String[i + 16];
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        return strArr2;
    }

    private boolean fillBuffer(int i) throws IOException, XmlPullParserException {
        while (this.nextContentSource != null) {
            if (this.position < this.limit) {
                throw new XmlPullParserException("Unbalanced entity!", this, null);
            }
            popContentSource();
            if (this.limit - this.position >= i) {
                return true;
            }
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.position) {
                break;
            }
            if (this.buffer[i3] == '\n') {
                this.bufferStartLine++;
                this.bufferStartColumn = 0;
            } else {
                this.bufferStartColumn++;
            }
            i2 = i3 + 1;
        }
        if (this.bufferCapture != null) {
            this.bufferCapture.append(this.buffer, 0, this.position);
        }
        if (this.limit != this.position) {
            this.limit -= this.position;
            System.arraycopy(this.buffer, this.position, this.buffer, 0, this.limit);
        } else {
            this.limit = 0;
        }
        this.position = 0;
        do {
            int read = this.reader.read(this.buffer, this.limit, this.buffer.length - this.limit);
            if (read == -1) {
                return false;
            }
            this.limit += read;
        } while (this.limit < i);
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x018b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int next(boolean r8) throws java.io.IOException, org.xmlpull.v1.XmlPullParserException {
        /*
            Method dump skipped, instructions count: 567
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.kxml2.io.KXmlParser.next(boolean):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x007c, code lost:
        r0 = r8.depth;
        r8.depth = r0 + 1;
        r0 = r0 * 4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0095, code lost:
        if (r8.depth != 1) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0098, code lost:
        r8.parsedTopLevelStartTag = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x009d, code lost:
        r8.elementStack = ensureCapacity(r8.elementStack, r0 + 4);
        r8.elementStack[r0 + 3] = r8.name;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00c3, code lost:
        if (r8.depth < r8.nspCounts.length) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00c6, code lost:
        r0 = new int[r8.depth + 4];
        java.lang.System.arraycopy(r8.nspCounts, 0, r0, 0, r8.nspCounts.length);
        r8.nspCounts = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00e6, code lost:
        r8.nspCounts[r8.depth] = r8.nspCounts[r8.depth - 1];
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00fe, code lost:
        if (r8.processNsp == false) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0101, code lost:
        adjustNsp();
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x010a, code lost:
        if (r8.defaultAttributes == null) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x010d, code lost:
        r0 = r8.defaultAttributes.get(r8.name);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0121, code lost:
        if (r0 == null) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0124, code lost:
        r0 = r0.entrySet().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0139, code lost:
        if (r0.hasNext() == false) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x013c, code lost:
        r0 = r0.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0157, code lost:
        if (getAttributeValue(null, r0.getKey()) != null) goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x015a, code lost:
        r0 = r8.attributeCount;
        r8.attributeCount = r0 + 1;
        r0 = r0 * 4;
        r8.attributes = ensureCapacity(r8.attributes, r0 + 4);
        r8.attributes[r0] = "";
        r8.attributes[r0 + 1] = null;
        r8.attributes[r0 + 2] = r0.getKey();
        r8.attributes[r0 + 3] = r0.getValue();
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0310, code lost:
        r8.namespace = "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x031a, code lost:
        r8.elementStack[r0] = r8.namespace;
        r8.elementStack[r0 + 1] = r8.prefix;
        r8.elementStack[r0 + 2] = r8.name;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x033f, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void parseStartTag(boolean r9, boolean r10) throws java.io.IOException, org.xmlpull.v1.XmlPullParserException {
        /*
            Method dump skipped, instructions count: 832
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.kxml2.io.KXmlParser.parseStartTag(boolean, boolean):void");
    }

    private int peekCharacter() throws IOException, XmlPullParserException {
        if (this.position < this.limit || fillBuffer(1)) {
            return this.buffer[this.position];
        }
        return -1;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private int peekType(boolean z) throws IOException, XmlPullParserException {
        int i = 4;
        if (this.position < this.limit || fillBuffer(1)) {
            switch (this.buffer[this.position]) {
                case '%':
                    if (z) {
                        return 15;
                    }
                    break;
                case '&':
                    return 6;
                case '<':
                    if (this.position + 3 < this.limit || fillBuffer(4)) {
                        switch (this.buffer[this.position + 1]) {
                            case '!':
                                switch (this.buffer[this.position + 2]) {
                                    case '-':
                                        return 9;
                                    case 'A':
                                        return 13;
                                    case 'D':
                                        return 10;
                                    case 'E':
                                        switch (this.buffer[this.position + 3]) {
                                            case 'L':
                                                return 11;
                                            case 'N':
                                                return 12;
                                        }
                                    case 'N':
                                        return 14;
                                    case '[':
                                        return 5;
                                }
                                throw new XmlPullParserException("Unexpected <!", this, null);
                            case '/':
                                return 3;
                            case '?':
                                if (this.position + 5 < this.limit || fillBuffer(6)) {
                                    if (this.buffer[this.position + 2] == 'x' || this.buffer[this.position + 2] == 'X') {
                                        if (this.buffer[this.position + 3] == 'm' || this.buffer[this.position + 3] == 'M') {
                                            if ((this.buffer[this.position + 4] == 'l' || this.buffer[this.position + 4] == 'L') && this.buffer[this.position + 5] == ' ') {
                                                return XML_DECLARATION;
                                            }
                                            return 8;
                                        }
                                        return 8;
                                    }
                                    return 8;
                                }
                                return 8;
                            default:
                                return 2;
                        }
                    }
                    throw new XmlPullParserException("Dangling <", this, null);
                default:
                    return 4;
            }
        } else {
            i = 1;
        }
        return i;
    }

    private void popContentSource() {
        this.buffer = this.nextContentSource.buffer;
        this.position = this.nextContentSource.position;
        this.limit = this.nextContentSource.limit;
        this.nextContentSource = this.nextContentSource.next;
    }

    private void pushContentSource(char[] cArr) {
        this.nextContentSource = new ContentSource(this.nextContentSource, this.buffer, this.position, this.limit);
        this.buffer = cArr;
        this.position = 0;
        this.limit = cArr.length;
    }

    private void read(char c) throws IOException, XmlPullParserException {
        int peekCharacter = peekCharacter();
        if (peekCharacter != c) {
            checkRelaxed("expected: '" + c + "' actual: '" + ((char) peekCharacter) + "'");
            if (peekCharacter == -1) {
                return;
            }
        }
        this.position++;
    }

    private void read(char[] cArr) throws IOException, XmlPullParserException {
        if (this.position + cArr.length > this.limit && !fillBuffer(cArr.length)) {
            checkRelaxed("expected: '" + new String(cArr) + "' but was EOF");
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= cArr.length) {
                this.position += cArr.length;
                return;
            }
            if (this.buffer[this.position + i2] != cArr[i2]) {
                checkRelaxed("expected: \"" + new String(cArr) + "\" but was \"" + new String(this.buffer, this.position, cArr.length) + "...\"");
            }
            i = i2 + 1;
        }
    }

    private void readAttributeListDeclaration() throws IOException, XmlPullParserException {
        read(START_ATTLIST);
        skip();
        String readName = readName();
        while (true) {
            skip();
            if (peekCharacter() == 62) {
                this.position++;
                return;
            }
            String readName2 = readName();
            skip();
            if (this.position + 1 >= this.limit && !fillBuffer(2)) {
                throw new XmlPullParserException("Malformed attribute list", this, null);
            }
            if (this.buffer[this.position] == NOTATION[0] && this.buffer[this.position + 1] == NOTATION[1]) {
                read(NOTATION);
                skip();
            }
            if (peekCharacter() == 40) {
                this.position++;
                while (true) {
                    skip();
                    readName();
                    skip();
                    int peekCharacter = peekCharacter();
                    if (peekCharacter == 41) {
                        this.position++;
                        break;
                    } else if (peekCharacter != 124) {
                        throw new XmlPullParserException("Malformed attribute type", this, null);
                    } else {
                        this.position++;
                    }
                }
            } else {
                readName();
            }
            skip();
            int peekCharacter2 = peekCharacter();
            int i = peekCharacter2;
            if (peekCharacter2 == 35) {
                this.position++;
                int peekCharacter3 = peekCharacter();
                if (peekCharacter3 == 82) {
                    read(REQUIRED);
                } else if (peekCharacter3 == 73) {
                    read(IMPLIED);
                } else if (peekCharacter3 != 70) {
                    throw new XmlPullParserException("Malformed attribute type", this, null);
                } else {
                    read(FIXED);
                }
                skip();
                i = peekCharacter();
            }
            if (i == 34 || i == 39) {
                this.position++;
                String readValue = readValue((char) i, true, true, ValueContext.ATTRIBUTE);
                if (peekCharacter() == i) {
                    this.position++;
                }
                defineAttributeDefault(readName, readName2, readValue);
            }
        }
    }

    private String readComment(boolean z) throws IOException, XmlPullParserException {
        read(START_COMMENT);
        if (this.relaxed) {
            return readUntil(END_COMMENT, z);
        }
        String readUntil = readUntil(COMMENT_DOUBLE_DASH, z);
        if (peekCharacter() != 62) {
            throw new XmlPullParserException("Comments may not contain --", this, null);
        }
        this.position++;
        return readUntil;
    }

    private void readContentSpec() throws IOException, XmlPullParserException {
        int i;
        int peekCharacter;
        skip();
        int peekCharacter2 = peekCharacter();
        if (peekCharacter2 != 40) {
            if (peekCharacter2 == EMPTY[0]) {
                read(EMPTY);
                return;
            } else if (peekCharacter2 != ANY[0]) {
                throw new XmlPullParserException("Expected element content spec", this, null);
            } else {
                read(ANY);
                return;
            }
        }
        int i2 = 0;
        do {
            if (peekCharacter2 == 40) {
                i = i2 + 1;
            } else if (peekCharacter2 == 41) {
                i = i2 - 1;
            } else {
                i = i2;
                if (peekCharacter2 == -1) {
                    throw new XmlPullParserException("Unterminated element content spec", this, null);
                }
            }
            this.position++;
            peekCharacter = peekCharacter();
            peekCharacter2 = peekCharacter;
            i2 = i;
        } while (i > 0);
        if (peekCharacter == 42 || peekCharacter == 63 || peekCharacter == 43) {
            this.position++;
        }
    }

    private void readDoctype(boolean z) throws IOException, XmlPullParserException {
        read(START_DOCTYPE);
        int i = -1;
        if (z) {
            this.bufferCapture = new StringBuilder();
            i = this.position;
        }
        try {
            skip();
            this.rootElementName = readName();
            readExternalId(true, true);
            skip();
            if (peekCharacter() == 91) {
                readInternalSubset();
            }
            skip();
            if (z) {
                this.bufferCapture.append(this.buffer, 0, this.position);
                this.bufferCapture.delete(0, i);
                this.text = this.bufferCapture.toString();
                this.bufferCapture = null;
            }
            read('>');
        } catch (Throwable th) {
            if (z) {
                this.bufferCapture.append(this.buffer, 0, this.position);
                this.bufferCapture.delete(0, i);
                this.text = this.bufferCapture.toString();
                this.bufferCapture = null;
            }
            throw th;
        }
    }

    private void readElementDeclaration() throws IOException, XmlPullParserException {
        read(START_ELEMENT);
        skip();
        readName();
        readContentSpec();
        skip();
        read('>');
    }

    private void readEndTag() throws IOException, XmlPullParserException {
        read('<');
        read('/');
        this.name = readName();
        skip();
        read('>');
        int i = (this.depth - 1) * 4;
        if (this.depth == 0) {
            checkRelaxed("read end tag " + this.name + " with no tags open");
            this.type = 9;
        } else if (!this.name.equals(this.elementStack[i + 3])) {
            if (!this.relaxed) {
                throw new XmlPullParserException("expected: /" + this.elementStack[i + 3] + " read: " + this.name, this, null);
            }
        } else {
            this.namespace = this.elementStack[i];
            this.prefix = this.elementStack[i + 1];
            this.name = this.elementStack[i + 2];
        }
    }

    private void readEntity(StringBuilder sb, boolean z, boolean z2, ValueContext valueContext) throws IOException, XmlPullParserException {
        char[] cArr;
        int length = sb.length();
        char[] cArr2 = this.buffer;
        int i = this.position;
        this.position = i + 1;
        if (cArr2[i] != '&') {
            throw new AssertionError();
        }
        sb.append('&');
        while (true) {
            int peekCharacter = peekCharacter();
            if (peekCharacter == 59) {
                sb.append(';');
                this.position++;
                String substring = sb.substring(length + 1, sb.length() - 1);
                if (z) {
                    this.name = substring;
                }
                if (substring.startsWith("#")) {
                    try {
                        int parseInt = substring.startsWith("#x") ? Integer.parseInt(substring.substring(2), 16) : Integer.parseInt(substring.substring(1));
                        sb.delete(length, sb.length());
                        sb.appendCodePoint(parseInt);
                        this.unresolved = false;
                        return;
                    } catch (NumberFormatException e) {
                        throw new XmlPullParserException("Invalid character reference: &" + substring);
                    } catch (IllegalArgumentException e2) {
                        throw new XmlPullParserException("Invalid character reference: &" + substring);
                    }
                } else if (valueContext != ValueContext.ENTITY_DECLARATION) {
                    String str = DEFAULT_ENTITIES.get(substring);
                    if (str != null) {
                        sb.delete(length, sb.length());
                        this.unresolved = false;
                        sb.append(str);
                        return;
                    } else if (this.documentEntities != null && (cArr = this.documentEntities.get(substring)) != null) {
                        sb.delete(length, sb.length());
                        this.unresolved = false;
                        if (this.processDocDecl) {
                            pushContentSource(cArr);
                            return;
                        } else {
                            sb.append(cArr);
                            return;
                        }
                    } else if (this.systemId != null) {
                        sb.delete(length, sb.length());
                        return;
                    } else {
                        this.unresolved = true;
                        if (z2) {
                            checkRelaxed("unresolved: &" + substring + i.b);
                            return;
                        }
                        return;
                    }
                } else {
                    return;
                }
            } else if (peekCharacter < 128 && ((peekCharacter < 48 || peekCharacter > 57) && ((peekCharacter < 97 || peekCharacter > 122) && ((peekCharacter < 65 || peekCharacter > 90) && peekCharacter != 95 && peekCharacter != 45 && peekCharacter != 35)))) {
                if (!this.relaxed) {
                    throw new XmlPullParserException("unterminated entity ref", this, null);
                }
                return;
            } else {
                this.position++;
                sb.append((char) peekCharacter);
            }
        }
    }

    private void readEntityDeclaration() throws IOException, XmlPullParserException {
        String str;
        read(START_ENTITY);
        boolean z = true;
        skip();
        if (peekCharacter() == 37) {
            z = false;
            this.position++;
            skip();
        }
        String readName = readName();
        skip();
        int peekCharacter = peekCharacter();
        if (peekCharacter == 34 || peekCharacter == 39) {
            this.position++;
            String readValue = readValue((char) peekCharacter, true, false, ValueContext.ENTITY_DECLARATION);
            str = readValue;
            if (peekCharacter() == peekCharacter) {
                this.position++;
                str = readValue;
            }
        } else if (!readExternalId(true, false)) {
            throw new XmlPullParserException("Expected entity value or external ID", this, null);
        } else {
            skip();
            str = "";
            if (peekCharacter() == NDATA[0]) {
                read(NDATA);
                skip();
                readName();
                str = "";
            }
        }
        if (z && this.processDocDecl) {
            if (this.documentEntities == null) {
                this.documentEntities = new HashMap();
            }
            this.documentEntities.put(readName, str.toCharArray());
        }
        skip();
        read('>');
    }

    private boolean readExternalId(boolean z, boolean z2) throws IOException, XmlPullParserException {
        int peekCharacter;
        boolean z3 = false;
        skip();
        int peekCharacter2 = peekCharacter();
        if (peekCharacter2 != 83) {
            if (peekCharacter2 == 80) {
                read(PUBLIC);
                skip();
                if (z2) {
                    this.publicId = readQuotedId(true);
                } else {
                    readQuotedId(false);
                }
            }
            return z3;
        }
        read(SYSTEM);
        skip();
        if (!z && (peekCharacter = peekCharacter()) != 34 && peekCharacter != 39) {
            z3 = true;
            return z3;
        } else if (z2) {
            this.systemId = readQuotedId(true);
            return true;
        } else {
            readQuotedId(false);
            return true;
        }
    }

    private void readInternalSubset() throws IOException, XmlPullParserException {
        read('[');
        while (true) {
            skip();
            if (peekCharacter() == 93) {
                this.position++;
                return;
            }
            switch (peekType(true)) {
                case 8:
                    read(START_PROCESSING_INSTRUCTION);
                    readUntil(END_PROCESSING_INSTRUCTION, false);
                    break;
                case 9:
                    readComment(false);
                    break;
                case 10:
                default:
                    throw new XmlPullParserException("Unexpected token", this, null);
                case 11:
                    readElementDeclaration();
                    break;
                case 12:
                    readEntityDeclaration();
                    break;
                case 13:
                    readAttributeListDeclaration();
                    break;
                case 14:
                    readNotationDeclaration();
                    break;
                case 15:
                    throw new XmlPullParserException("Parameter entity references are not supported", this, null);
            }
        }
    }

    private String readName() throws IOException, XmlPullParserException {
        if (this.position >= this.limit && !fillBuffer(1)) {
            checkRelaxed("name expected");
            return "";
        }
        int i = this.position;
        StringBuilder sb = null;
        char c = this.buffer[this.position];
        if ((c < 'a' || c > 'z') && !((c >= 'A' && c <= 'Z') || c == '_' || c == ':' || c >= 192 || this.relaxed)) {
            checkRelaxed("name expected");
            return "";
        }
        this.position++;
        while (true) {
            StringBuilder sb2 = sb;
            int i2 = i;
            if (this.position >= this.limit) {
                sb2 = sb;
                if (sb == null) {
                    sb2 = new StringBuilder();
                }
                sb2.append(this.buffer, i, this.position - i);
                if (!fillBuffer(1)) {
                    return sb2.toString();
                }
                i2 = this.position;
            }
            char c2 = this.buffer[this.position];
            if ((c2 < 'a' || c2 > 'z') && ((c2 < 'A' || c2 > 'Z') && !((c2 >= '0' && c2 <= '9') || c2 == '_' || c2 == '-' || c2 == ':' || c2 == '.' || c2 >= 183))) {
                if (sb2 == null) {
                    return this.stringPool.get(this.buffer, i2, this.position - i2);
                }
                sb2.append(this.buffer, i2, this.position - i2);
                return sb2.toString();
            }
            this.position++;
            sb = sb2;
            i = i2;
        }
    }

    private void readNotationDeclaration() throws IOException, XmlPullParserException {
        read(START_NOTATION);
        skip();
        readName();
        if (!readExternalId(false, false)) {
            throw new XmlPullParserException("Expected external ID or public ID for notation", this, null);
        }
        skip();
        read('>');
    }

    private String readQuotedId(boolean z) throws IOException, XmlPullParserException {
        char[] cArr;
        int peekCharacter = peekCharacter();
        if (peekCharacter == 34) {
            cArr = DOUBLE_QUOTE;
        } else if (peekCharacter != 39) {
            throw new XmlPullParserException("Expected a quoted string", this, null);
        } else {
            cArr = SINGLE_QUOTE;
        }
        this.position++;
        return readUntil(cArr, z);
    }

    private String readUntil(char[] cArr, boolean z) throws IOException, XmlPullParserException {
        int i = this.position;
        StringBuilder sb = null;
        int i2 = i;
        if (z) {
            sb = null;
            i2 = i;
            if (this.text != null) {
                sb = new StringBuilder();
                sb.append(this.text);
                i2 = i;
            }
        }
        while (true) {
            StringBuilder sb2 = sb;
            int i3 = i2;
            if (this.position + cArr.length > this.limit) {
                sb2 = sb;
                if (i2 < this.position) {
                    sb2 = sb;
                    if (z) {
                        sb2 = sb;
                        if (sb == null) {
                            sb2 = new StringBuilder();
                        }
                        sb2.append(this.buffer, i2, this.position - i2);
                    }
                }
                if (!fillBuffer(cArr.length)) {
                    checkRelaxed(UNEXPECTED_EOF);
                    this.type = 9;
                    return null;
                }
                i3 = this.position;
            }
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 >= cArr.length) {
                    int i6 = this.position;
                    this.position += cArr.length;
                    if (z) {
                        if (sb2 == null) {
                            return this.stringPool.get(this.buffer, i3, i6 - i3);
                        }
                        sb2.append(this.buffer, i3, i6 - i3);
                        return sb2.toString();
                    }
                    return null;
                } else if (this.buffer[this.position + i5] != cArr[i5]) {
                    break;
                } else {
                    i4 = i5 + 1;
                }
            }
            this.position++;
            sb = sb2;
            i2 = i3;
        }
    }

    private String readValue(char c, boolean z, boolean z2, ValueContext valueContext) throws IOException, XmlPullParserException {
        StringBuilder sb;
        int i;
        int i2 = this.position;
        StringBuilder sb2 = null;
        int i3 = i2;
        if (valueContext == ValueContext.TEXT) {
            sb2 = null;
            i3 = i2;
            if (this.text != null) {
                sb2 = new StringBuilder();
                sb2.append(this.text);
                i3 = i2;
            }
        }
        while (true) {
            sb = sb2;
            i = i3;
            if (this.position >= this.limit) {
                sb = sb2;
                if (i3 < this.position) {
                    sb = sb2;
                    if (sb2 == null) {
                        sb = new StringBuilder();
                    }
                    sb.append(this.buffer, i3, this.position - i3);
                }
                if (!fillBuffer(1)) {
                    return sb != null ? sb.toString() : "";
                }
                i = this.position;
            }
            char c2 = this.buffer[this.position];
            if (c2 == c || ((c == ' ' && (c2 <= ' ' || c2 == '>')) || (c2 == '&' && !z))) {
                break;
            } else if (c2 == '\r' || ((c2 == '\n' && valueContext == ValueContext.ATTRIBUTE) || c2 == '&' || c2 == '<' || ((c2 == ']' && valueContext == ValueContext.TEXT) || (c2 == '%' && valueContext == ValueContext.ENTITY_DECLARATION)))) {
                sb2 = sb;
                if (sb == null) {
                    sb2 = new StringBuilder();
                }
                sb2.append(this.buffer, i, this.position - i);
                if (c2 == '\r') {
                    if ((this.position + 1 < this.limit || fillBuffer(2)) && this.buffer[this.position + 1] == '\n') {
                        this.position++;
                    }
                    c2 = valueContext == ValueContext.ATTRIBUTE ? ' ' : '\n';
                } else if (c2 == '\n') {
                    c2 = ' ';
                } else if (c2 == '&') {
                    this.isWhitespace = false;
                    readEntity(sb2, false, z2, valueContext);
                    i3 = this.position;
                } else if (c2 == '<') {
                    if (valueContext == ValueContext.ATTRIBUTE) {
                        checkRelaxed("Illegal: \"<\" inside attribute value");
                    }
                    this.isWhitespace = false;
                } else if (c2 != ']') {
                    if (c2 == '%') {
                        throw new XmlPullParserException("This parser doesn't support parameter entities", this, null);
                    }
                    throw new AssertionError();
                } else {
                    if ((this.position + 2 < this.limit || fillBuffer(3)) && this.buffer[this.position + 1] == ']' && this.buffer[this.position + 2] == '>') {
                        checkRelaxed("Illegal: \"]]>\" outside CDATA section");
                    }
                    this.isWhitespace = false;
                }
                this.position++;
                sb2.append(c2);
                i3 = this.position;
            } else {
                this.isWhitespace = (c2 <= ' ') & this.isWhitespace;
                this.position++;
                sb2 = sb;
                i3 = i;
            }
        }
        if (sb == null) {
            return this.stringPool.get(this.buffer, i, this.position - i);
        }
        sb.append(this.buffer, i, this.position - i);
        return sb.toString();
    }

    private void readXmlDeclaration() throws IOException, XmlPullParserException {
        if (this.bufferStartLine != 0 || this.bufferStartColumn != 0 || this.position != 0) {
            checkRelaxed("processing instructions must not start with xml");
        }
        read(START_PROCESSING_INSTRUCTION);
        parseStartTag(true, true);
        if (this.attributeCount < 1 || !OutputKeys.VERSION.equals(this.attributes[2])) {
            checkRelaxed("version expected");
        }
        this.version = this.attributes[3];
        int i = 1;
        if (1 < this.attributeCount) {
            i = 1;
            if (OutputKeys.ENCODING.equals(this.attributes[6])) {
                this.encoding = this.attributes[7];
                i = 1 + 1;
            }
        }
        int i2 = i;
        if (i < this.attributeCount) {
            i2 = i;
            if (OutputKeys.STANDALONE.equals(this.attributes[(i * 4) + 2])) {
                String str = this.attributes[(i * 4) + 3];
                if ("yes".equals(str)) {
                    this.standalone = Boolean.TRUE;
                } else if ("no".equals(str)) {
                    this.standalone = Boolean.FALSE;
                } else {
                    checkRelaxed("illegal standalone value: " + str);
                }
                i2 = i + 1;
            }
        }
        if (i2 != this.attributeCount) {
            checkRelaxed("unexpected attributes in XML declaration");
        }
        this.isWhitespace = true;
        this.text = null;
    }

    private void skip() throws IOException, XmlPullParserException {
        while (true) {
            if ((this.position >= this.limit && !fillBuffer(1)) || this.buffer[this.position] > ' ') {
                return;
            }
            this.position++;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.reader != null) {
            this.reader.close();
        }
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public void defineEntityReplacementText(String str, String str2) throws XmlPullParserException {
        if (this.processDocDecl) {
            throw new IllegalStateException("Entity replacement text may not be defined with DOCTYPE processing enabled.");
        }
        if (this.reader == null) {
            throw new IllegalStateException("Entity replacement text must be defined after setInput()");
        }
        if (this.documentEntities == null) {
            this.documentEntities = new HashMap();
        }
        this.documentEntities.put(str, str2.toCharArray());
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public int getAttributeCount() {
        return this.attributeCount;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public String getAttributeName(int i) {
        if (i >= this.attributeCount) {
            throw new IndexOutOfBoundsException();
        }
        return this.attributes[(i * 4) + 2];
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public String getAttributeNamespace(int i) {
        if (i >= this.attributeCount) {
            throw new IndexOutOfBoundsException();
        }
        return this.attributes[i * 4];
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public String getAttributePrefix(int i) {
        if (i >= this.attributeCount) {
            throw new IndexOutOfBoundsException();
        }
        return this.attributes[(i * 4) + 1];
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public String getAttributeType(int i) {
        return "CDATA";
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public String getAttributeValue(int i) {
        if (i >= this.attributeCount) {
            throw new IndexOutOfBoundsException();
        }
        return this.attributes[(i * 4) + 3];
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public String getAttributeValue(String str, String str2) {
        int i;
        int i2 = this.attributeCount * 4;
        while (true) {
            i = i2 - 4;
            if (i < 0) {
                return null;
            }
            if (!this.attributes[i + 2].equals(str2) || (str != null && !this.attributes[i].equals(str))) {
                i2 = i;
            }
        }
        return this.attributes[i + 3];
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public int getColumnNumber() {
        int i = this.bufferStartColumn;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.position) {
                return i + 1;
            }
            i = this.buffer[i3] == '\n' ? 0 : i + 1;
            i2 = i3 + 1;
        }
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public int getDepth() {
        return this.depth;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public int getEventType() throws XmlPullParserException {
        return this.type;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public boolean getFeature(String str) {
        if (XmlPullParser.FEATURE_PROCESS_NAMESPACES.equals(str)) {
            return this.processNsp;
        }
        if (FEATURE_RELAXED.equals(str)) {
            return this.relaxed;
        }
        if (XmlPullParser.FEATURE_PROCESS_DOCDECL.equals(str)) {
            return this.processDocDecl;
        }
        return false;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public String getInputEncoding() {
        return this.encoding;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public int getLineNumber() {
        int i = this.bufferStartLine;
        int i2 = 0;
        while (i2 < this.position) {
            int i3 = i;
            if (this.buffer[i2] == '\n') {
                i3 = i + 1;
            }
            i2++;
            i = i3;
        }
        return i + 1;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public String getName() {
        return this.name;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public String getNamespace() {
        return this.namespace;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public String getNamespace(String str) {
        if (XMLConstants.XML_NS_PREFIX.equals(str)) {
            return "http://www.w3.org/XML/1998/namespace";
        }
        if (XMLConstants.XMLNS_ATTRIBUTE.equals(str)) {
            return XMLConstants.XMLNS_ATTRIBUTE_NS_URI;
        }
        int namespaceCount = getNamespaceCount(this.depth) << 1;
        while (true) {
            int i = namespaceCount - 2;
            if (i < 0) {
                return null;
            }
            if (str == null) {
                if (this.nspStack[i] == null) {
                    return this.nspStack[i + 1];
                }
            } else if (str.equals(this.nspStack[i])) {
                return this.nspStack[i + 1];
            }
            namespaceCount = i;
        }
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public int getNamespaceCount(int i) {
        if (i > this.depth) {
            throw new IndexOutOfBoundsException();
        }
        return this.nspCounts[i];
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public String getNamespacePrefix(int i) {
        return this.nspStack[i * 2];
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public String getNamespaceUri(int i) {
        return this.nspStack[(i * 2) + 1];
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public String getPositionDescription() {
        StringBuilder sb = new StringBuilder(this.type < TYPES.length ? TYPES[this.type] : SmsConstants.FORMAT_UNKNOWN);
        sb.append(' ');
        if (this.type == 2 || this.type == 3) {
            if (this.degenerated) {
                sb.append("(empty) ");
            }
            sb.append('<');
            if (this.type == 3) {
                sb.append('/');
            }
            if (this.prefix != null) {
                sb.append("{" + this.namespace + i.d + this.prefix + ":");
            }
            sb.append(this.name);
            int i = this.attributeCount;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= i * 4) {
                    break;
                }
                sb.append(' ');
                if (this.attributes[i3 + 1] != null) {
                    sb.append("{" + this.attributes[i3] + i.d + this.attributes[i3 + 1] + ":");
                }
                sb.append(this.attributes[i3 + 2] + "='" + this.attributes[i3 + 3] + "'");
                i2 = i3 + 4;
            }
            sb.append('>');
        } else if (this.type != 7) {
            if (this.type != 4) {
                sb.append(getText());
            } else if (this.isWhitespace) {
                sb.append("(whitespace)");
            } else {
                String text = getText();
                String str = text;
                if (text.length() > 16) {
                    str = text.substring(0, 16) + "...";
                }
                sb.append(str);
            }
        }
        sb.append("@" + getLineNumber() + ":" + getColumnNumber());
        if (this.location != null) {
            sb.append(" in ");
            sb.append(this.location);
        } else if (this.reader != null) {
            sb.append(" in ");
            sb.append(this.reader.toString());
        }
        return sb.toString();
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public String getPrefix() {
        return this.prefix;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public Object getProperty(String str) {
        if (str.equals(PROPERTY_XMLDECL_VERSION)) {
            return this.version;
        }
        if (str.equals(PROPERTY_XMLDECL_STANDALONE)) {
            return this.standalone;
        }
        if (str.equals(PROPERTY_LOCATION)) {
            return this.location != null ? this.location : this.reader.toString();
        }
        return null;
    }

    public String getPublicId() {
        return this.publicId;
    }

    public String getRootElementName() {
        return this.rootElementName;
    }

    public String getSystemId() {
        return this.systemId;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public String getText() {
        if (this.type >= 4) {
            if (this.type == 6 && this.unresolved) {
                return null;
            }
            return this.text == null ? "" : this.text;
        }
        return null;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public char[] getTextCharacters(int[] iArr) {
        String text = getText();
        if (text == null) {
            iArr[0] = -1;
            iArr[1] = -1;
            return null;
        }
        char[] charArray = text.toCharArray();
        iArr[0] = 0;
        iArr[1] = charArray.length;
        return charArray;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public boolean isAttributeDefault(int i) {
        return false;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public boolean isEmptyElementTag() throws XmlPullParserException {
        if (this.type != 2) {
            throw new XmlPullParserException(ILLEGAL_TYPE, this, null);
        }
        return this.degenerated;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public boolean isWhitespace() throws XmlPullParserException {
        if (this.type == 4 || this.type == 7 || this.type == 5) {
            return this.isWhitespace;
        }
        throw new XmlPullParserException(ILLEGAL_TYPE, this, null);
    }

    public void keepNamespaceAttributes() {
        this.keepNamespaceAttributes = true;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public int next() throws XmlPullParserException, IOException {
        return next(false);
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public int nextTag() throws XmlPullParserException, IOException {
        next();
        if (this.type == 4 && this.isWhitespace) {
            next();
        }
        if (this.type == 3 || this.type == 2) {
            return this.type;
        }
        throw new XmlPullParserException("unexpected type", this, null);
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public String nextText() throws XmlPullParserException, IOException {
        String str;
        if (this.type != 2) {
            throw new XmlPullParserException("precondition: START_TAG", this, null);
        }
        next();
        if (this.type == 4) {
            str = getText();
            next();
        } else {
            str = "";
        }
        if (this.type != 3) {
            throw new XmlPullParserException("END_TAG expected", this, null);
        }
        return str;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public int nextToken() throws XmlPullParserException, IOException {
        return next(true);
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public void require(int i, String str, String str2) throws XmlPullParserException, IOException {
        if (i != this.type || ((str != null && !str.equals(getNamespace())) || (str2 != null && !str2.equals(getName())))) {
            throw new XmlPullParserException("expected: " + TYPES[i] + " {" + str + i.d + str2, this, null);
        }
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public void setFeature(String str, boolean z) throws XmlPullParserException {
        if (XmlPullParser.FEATURE_PROCESS_NAMESPACES.equals(str)) {
            this.processNsp = z;
        } else if (XmlPullParser.FEATURE_PROCESS_DOCDECL.equals(str)) {
            this.processDocDecl = z;
        } else if (!FEATURE_RELAXED.equals(str)) {
            throw new XmlPullParserException("unsupported feature: " + str, this, null);
        } else {
            this.relaxed = z;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // org.xmlpull.v1.XmlPullParser
    public void setInput(InputStream inputStream, String str) throws XmlPullParserException {
        this.position = 0;
        this.limit = 0;
        boolean z = str == null;
        if (inputStream == null) {
            throw new IllegalArgumentException("is == null");
        }
        String str2 = str;
        if (z) {
            int i = 0;
            while (this.limit < 4) {
                try {
                    int read = inputStream.read();
                    if (read == -1) {
                        break;
                    }
                    i = (i << 8) | read;
                    char[] cArr = this.buffer;
                    int i2 = this.limit;
                    this.limit = i2 + 1;
                    cArr[i2] = (char) read;
                } catch (Exception e) {
                    throw new XmlPullParserException("Invalid stream or encoding: " + e, this, e);
                }
            }
            str2 = str;
            if (this.limit == 4) {
                switch (i) {
                    case -131072:
                        str2 = "UTF-32LE";
                        this.limit = 0;
                        break;
                    case 60:
                        str2 = "UTF-32BE";
                        this.buffer[0] = '<';
                        this.limit = 1;
                        break;
                    case 65279:
                        str2 = "UTF-32BE";
                        this.limit = 0;
                        break;
                    case 3932223:
                        str2 = CharEncoding.UTF_16BE;
                        this.buffer[0] = '<';
                        this.buffer[1] = '?';
                        this.limit = 2;
                        break;
                    case 1006632960:
                        str2 = "UTF-32LE";
                        this.buffer[0] = '<';
                        this.limit = 1;
                        break;
                    case 1006649088:
                        str2 = CharEncoding.UTF_16LE;
                        this.buffer[0] = '<';
                        this.buffer[1] = '?';
                        this.limit = 2;
                        break;
                    case 1010792557:
                        while (true) {
                            int read2 = inputStream.read();
                            str2 = str;
                            if (read2 == -1) {
                                break;
                            } else {
                                char[] cArr2 = this.buffer;
                                int i3 = this.limit;
                                this.limit = i3 + 1;
                                cArr2[i3] = (char) read2;
                                if (read2 == 62) {
                                    String str3 = new String(this.buffer, 0, this.limit);
                                    int indexOf = str3.indexOf(OutputKeys.ENCODING);
                                    str2 = str;
                                    if (indexOf != -1) {
                                        while (str3.charAt(indexOf) != '\"' && str3.charAt(indexOf) != '\'') {
                                            indexOf++;
                                        }
                                        int i4 = indexOf + 1;
                                        str2 = str3.substring(i4, str3.indexOf(str3.charAt(indexOf), i4));
                                        break;
                                    }
                                }
                            }
                        }
                        break;
                    default:
                        if (((-65536) & i) != -16842752) {
                            if (((-65536) & i) != -131072) {
                                str2 = str;
                                if ((i & (-256)) == -272908544) {
                                    str2 = "UTF-8";
                                    this.buffer[0] = this.buffer[3];
                                    this.limit = 1;
                                    break;
                                }
                            } else {
                                str2 = CharEncoding.UTF_16LE;
                                this.buffer[0] = (char) ((this.buffer[3] << '\b') | this.buffer[2]);
                                this.limit = 1;
                                break;
                            }
                        } else {
                            str2 = CharEncoding.UTF_16BE;
                            this.buffer[0] = (char) ((this.buffer[2] << '\b') | this.buffer[3]);
                            this.limit = 1;
                            break;
                        }
                        break;
                }
            }
        }
        String str4 = str2;
        if (str2 == null) {
            str4 = "UTF-8";
        }
        int i5 = this.limit;
        setInput(new InputStreamReader(inputStream, str4));
        this.encoding = str4;
        this.limit = i5;
        if (z || peekCharacter() != 65279) {
            return;
        }
        this.limit--;
        System.arraycopy(this.buffer, 1, this.buffer, 0, this.limit);
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public void setInput(Reader reader) throws XmlPullParserException {
        this.reader = reader;
        this.type = 0;
        this.name = null;
        this.namespace = null;
        this.degenerated = false;
        this.attributeCount = -1;
        this.encoding = null;
        this.version = null;
        this.standalone = null;
        if (reader == null) {
            return;
        }
        this.position = 0;
        this.limit = 0;
        this.bufferStartLine = 0;
        this.bufferStartColumn = 0;
        this.depth = 0;
        this.documentEntities = null;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public void setProperty(String str, Object obj) throws XmlPullParserException {
        if (!str.equals(PROPERTY_LOCATION)) {
            throw new XmlPullParserException("unsupported property: " + str);
        }
        this.location = String.valueOf(obj);
    }
}
