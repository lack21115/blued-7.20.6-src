package org.kxml2.io;

import com.alipay.sdk.util.i;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Locale;
import javax.xml.XMLConstants;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: source-2895416-dex2jar.jar:org/kxml2/io/KXmlSerializer.class */
public class KXmlSerializer implements XmlSerializer {
    private static final int WRITE_BUFFER_SIZE = 500;
    private int auto;
    private int depth;
    private String encoding;
    private boolean pending;
    private boolean unicode;
    private BufferedWriter writer;
    private String[] elementStack = new String[12];
    private int[] nspCounts = new int[4];
    private String[] nspStack = new String[8];
    private boolean[] indent = new boolean[4];

    private final void check(boolean z) throws IOException {
        if (!this.pending) {
            return;
        }
        this.depth++;
        this.pending = false;
        if (this.indent.length <= this.depth) {
            boolean[] zArr = new boolean[this.depth + 4];
            System.arraycopy(this.indent, 0, zArr, 0, this.depth);
            this.indent = zArr;
        }
        this.indent[this.depth] = this.indent[this.depth - 1];
        int i = this.nspCounts[this.depth - 1];
        while (true) {
            int i2 = i;
            if (i2 >= this.nspCounts[this.depth]) {
                if (this.nspCounts.length <= this.depth + 1) {
                    int[] iArr = new int[this.depth + 8];
                    System.arraycopy(this.nspCounts, 0, iArr, 0, this.depth + 1);
                    this.nspCounts = iArr;
                }
                this.nspCounts[this.depth + 1] = this.nspCounts[this.depth];
                this.writer.write(z ? " />" : ">");
                return;
            }
            this.writer.write(32);
            this.writer.write(XMLConstants.XMLNS_ATTRIBUTE);
            if (!this.nspStack[i2 * 2].isEmpty()) {
                this.writer.write(58);
                this.writer.write(this.nspStack[i2 * 2]);
            } else if (getNamespace().isEmpty() && !this.nspStack[(i2 * 2) + 1].isEmpty()) {
                throw new IllegalStateException("Cannot set default namespace for elements in no namespace");
            }
            this.writer.write("=\"");
            writeEscaped(this.nspStack[(i2 * 2) + 1], 34);
            this.writer.write(34);
            i = i2 + 1;
        }
    }

    private final String getPrefix(String str, boolean z, boolean z2) throws IOException {
        String str2;
        String str3;
        int i = this.nspCounts[this.depth + 1] * 2;
        while (true) {
            int i2 = i - 2;
            if (i2 < 0) {
                if (z2) {
                    if (str.isEmpty()) {
                        str2 = "";
                    } else {
                        do {
                            StringBuilder append = new StringBuilder().append("n");
                            int i3 = this.auto;
                            this.auto = i3 + 1;
                            String sb = append.append(i3).toString();
                            int i4 = this.nspCounts[this.depth + 1] * 2;
                            while (true) {
                                int i5 = i4 - 2;
                                str2 = sb;
                                if (i5 < 0) {
                                    break;
                                } else if (sb.equals(this.nspStack[i5])) {
                                    str2 = null;
                                    break;
                                } else {
                                    i4 = i5;
                                }
                            }
                        } while (str2 == null);
                    }
                    boolean z3 = this.pending;
                    this.pending = false;
                    setPrefix(str2, str);
                    this.pending = z3;
                    return str2;
                }
                return null;
            }
            if (this.nspStack[i2 + 1].equals(str) && (z || !this.nspStack[i2].isEmpty())) {
                String str4 = this.nspStack[i2];
                int i6 = i2;
                int i7 = 2;
                while (true) {
                    int i8 = i6 + i7;
                    str3 = str4;
                    if (i8 >= this.nspCounts[this.depth + 1] * 2) {
                        break;
                    } else if (this.nspStack[i8].equals(str4)) {
                        str3 = null;
                        break;
                    } else {
                        i6 = i8;
                        i7 = 1;
                    }
                }
                if (str3 != null) {
                    return str3;
                }
            }
            i = i2;
        }
    }

    private static void reportInvalidCharacter(char c) {
        throw new IllegalArgumentException("Illegal character (U+" + Integer.toHexString(c) + ")");
    }

    private final void writeEscaped(String str, int i) throws IOException {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= str.length()) {
                return;
            }
            char charAt = str.charAt(i3);
            switch (charAt) {
                case '\t':
                case '\n':
                case '\r':
                    if (i != -1) {
                        this.writer.write("&#" + ((int) charAt) + ';');
                        break;
                    } else {
                        this.writer.write(charAt);
                        break;
                    }
                case '&':
                    this.writer.write("&amp;");
                    break;
                case '<':
                    this.writer.write("&lt;");
                    break;
                case '>':
                    this.writer.write("&gt;");
                    break;
                default:
                    if (charAt != i) {
                        if (!((charAt >= ' ' && charAt <= 55295) || (charAt >= 57344 && charAt <= 65533))) {
                            if (Character.isHighSurrogate(charAt) && i3 < str.length() - 1) {
                                writeSurrogate(charAt, str.charAt(i3 + 1));
                                i3++;
                                break;
                            } else {
                                reportInvalidCharacter(charAt);
                                break;
                            }
                        } else if (!this.unicode && charAt >= 127) {
                            this.writer.write("&#" + ((int) charAt) + i.b);
                            break;
                        } else {
                            this.writer.write(charAt);
                            break;
                        }
                    } else {
                        this.writer.write(charAt == '\"' ? "&quot;" : "&apos;");
                        break;
                    }
                    break;
            }
            i2 = i3 + 1;
        }
    }

    private void writeSurrogate(char c, char c2) throws IOException {
        if (!Character.isLowSurrogate(c2)) {
            throw new IllegalArgumentException("Bad surrogate pair (U+" + Integer.toHexString(c) + " U+" + Integer.toHexString(c2) + ")");
        }
        this.writer.write("&#" + Character.toCodePoint(c, c2) + i.b);
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public XmlSerializer attribute(String str, String str2, String str3) throws IOException {
        int i = 34;
        if (this.pending) {
            String str4 = str;
            if (str == null) {
                str4 = "";
            }
            String prefix = str4.isEmpty() ? "" : getPrefix(str4, false, true);
            this.writer.write(32);
            if (!prefix.isEmpty()) {
                this.writer.write(prefix);
                this.writer.write(58);
            }
            this.writer.write(str2);
            this.writer.write(61);
            if (str3.indexOf(34) != -1) {
                i = 39;
            }
            this.writer.write(i);
            writeEscaped(str3, i);
            this.writer.write(i);
            return this;
        }
        throw new IllegalStateException("illegal position for attribute");
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void cdsect(String str) throws IOException {
        check(false);
        String replace = str.replace("]]>", "]]]]><![CDATA[>");
        this.writer.write("<![CDATA[");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= replace.length()) {
                this.writer.write("]]>");
                return;
            }
            char charAt = replace.charAt(i2);
            if ((charAt >= ' ' && charAt <= 55295) || charAt == '\t' || charAt == '\n' || charAt == '\r' || (charAt >= 57344 && charAt <= 65533)) {
                this.writer.write(charAt);
            } else if (!Character.isHighSurrogate(charAt) || i2 >= replace.length() - 1) {
                reportInvalidCharacter(charAt);
            } else {
                this.writer.write("]]>");
                i2++;
                writeSurrogate(charAt, replace.charAt(i2));
                this.writer.write("<![CDATA[");
            }
            i = i2 + 1;
        }
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void comment(String str) throws IOException {
        check(false);
        this.writer.write("<!--");
        this.writer.write(str);
        this.writer.write("-->");
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void docdecl(String str) throws IOException {
        this.writer.write("<!DOCTYPE");
        this.writer.write(str);
        this.writer.write(">");
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void endDocument() throws IOException {
        while (this.depth > 0) {
            endTag(this.elementStack[(this.depth * 3) - 3], this.elementStack[(this.depth * 3) - 1]);
        }
        flush();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public XmlSerializer endTag(String str, String str2) throws IOException {
        if (!this.pending) {
            this.depth--;
        }
        if ((str != null || this.elementStack[this.depth * 3] == null) && ((str == null || str.equals(this.elementStack[this.depth * 3])) && this.elementStack[(this.depth * 3) + 2].equals(str2))) {
            if (this.pending) {
                check(true);
                this.depth--;
            } else {
                if (this.indent[this.depth + 1]) {
                    this.writer.write("\r\n");
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= this.depth) {
                            break;
                        }
                        this.writer.write("  ");
                        i = i2 + 1;
                    }
                }
                this.writer.write("</");
                String str3 = this.elementStack[(this.depth * 3) + 1];
                if (!str3.isEmpty()) {
                    this.writer.write(str3);
                    this.writer.write(58);
                }
                this.writer.write(str2);
                this.writer.write(62);
            }
            this.nspCounts[this.depth + 1] = this.nspCounts[this.depth];
            return this;
        }
        throw new IllegalArgumentException("</{" + str + i.d + str2 + "> does not match start");
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void entityRef(String str) throws IOException {
        check(false);
        this.writer.write(38);
        this.writer.write(str);
        this.writer.write(59);
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void flush() throws IOException {
        check(false);
        this.writer.flush();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public int getDepth() {
        return this.pending ? this.depth + 1 : this.depth;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public boolean getFeature(String str) {
        if ("http://xmlpull.org/v1/doc/features.html#indent-output".equals(str)) {
            return this.indent[this.depth];
        }
        return false;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public String getName() {
        if (getDepth() == 0) {
            return null;
        }
        return this.elementStack[(getDepth() * 3) - 1];
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public String getNamespace() {
        if (getDepth() == 0) {
            return null;
        }
        return this.elementStack[(getDepth() * 3) - 3];
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public String getPrefix(String str, boolean z) {
        try {
            return getPrefix(str, false, z);
        } catch (IOException e) {
            throw new RuntimeException(e.toString());
        }
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public Object getProperty(String str) {
        throw new RuntimeException("Unsupported property");
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void ignorableWhitespace(String str) throws IOException {
        text(str);
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void processingInstruction(String str) throws IOException {
        check(false);
        this.writer.write("<?");
        this.writer.write(str);
        this.writer.write("?>");
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void setFeature(String str, boolean z) {
        if (!"http://xmlpull.org/v1/doc/features.html#indent-output".equals(str)) {
            throw new RuntimeException("Unsupported Feature");
        }
        this.indent[this.depth] = z;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void setOutput(OutputStream outputStream, String str) throws IOException {
        if (outputStream == null) {
            throw new IllegalArgumentException("os == null");
        }
        setOutput(str == null ? new OutputStreamWriter(outputStream) : new OutputStreamWriter(outputStream, str));
        this.encoding = str;
        if (str == null || !str.toLowerCase(Locale.US).startsWith("utf")) {
            return;
        }
        this.unicode = true;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void setOutput(Writer writer) {
        if (writer instanceof BufferedWriter) {
            this.writer = (BufferedWriter) writer;
        } else {
            this.writer = new BufferedWriter(writer, 500);
        }
        this.nspCounts[0] = 2;
        this.nspCounts[1] = 2;
        this.nspStack[0] = "";
        this.nspStack[1] = "";
        this.nspStack[2] = XMLConstants.XML_NS_PREFIX;
        this.nspStack[3] = "http://www.w3.org/XML/1998/namespace";
        this.pending = false;
        this.auto = 0;
        this.depth = 0;
        this.unicode = false;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void setPrefix(String str, String str2) throws IOException {
        check(false);
        String str3 = str;
        if (str == null) {
            str3 = "";
        }
        String str4 = str2;
        if (str2 == null) {
            str4 = "";
        }
        if (str3.equals(getPrefix(str4, true, false))) {
            return;
        }
        int[] iArr = this.nspCounts;
        int i = this.depth + 1;
        int i2 = iArr[i];
        iArr[i] = i2 + 1;
        int i3 = i2 << 1;
        if (this.nspStack.length < i3 + 1) {
            String[] strArr = new String[this.nspStack.length + 16];
            System.arraycopy(this.nspStack, 0, strArr, 0, i3);
            this.nspStack = strArr;
        }
        this.nspStack[i3] = str3;
        this.nspStack[i3 + 1] = str4;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void setProperty(String str, Object obj) {
        throw new RuntimeException("Unsupported Property:" + obj);
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void startDocument(String str, Boolean bool) throws IOException {
        this.writer.write("<?xml version='1.0' ");
        if (str != null) {
            this.encoding = str;
            if (str.toLowerCase(Locale.US).startsWith("utf")) {
                this.unicode = true;
            }
        }
        if (this.encoding != null) {
            this.writer.write("encoding='");
            this.writer.write(this.encoding);
            this.writer.write("' ");
        }
        if (bool != null) {
            this.writer.write("standalone='");
            this.writer.write(bool.booleanValue() ? "yes" : "no");
            this.writer.write("' ");
        }
        this.writer.write("?>");
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public XmlSerializer startTag(String str, String str2) throws IOException {
        check(false);
        if (this.indent[this.depth]) {
            this.writer.write("\r\n");
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.depth) {
                    break;
                }
                this.writer.write("  ");
                i = i2 + 1;
            }
        }
        int i3 = this.depth * 3;
        if (this.elementStack.length < i3 + 3) {
            String[] strArr = new String[this.elementStack.length + 12];
            System.arraycopy(this.elementStack, 0, strArr, 0, i3);
            this.elementStack = strArr;
        }
        String prefix = str == null ? "" : getPrefix(str, true, true);
        if (str != null && str.isEmpty()) {
            int i4 = this.nspCounts[this.depth];
            while (true) {
                int i5 = i4;
                if (i5 >= this.nspCounts[this.depth + 1]) {
                    break;
                } else if (this.nspStack[i5 * 2].isEmpty() && !this.nspStack[(i5 * 2) + 1].isEmpty()) {
                    throw new IllegalStateException("Cannot set default namespace for elements in no namespace");
                } else {
                    i4 = i5 + 1;
                }
            }
        }
        int i6 = i3 + 1;
        this.elementStack[i3] = str;
        this.elementStack[i6] = prefix;
        this.elementStack[i6 + 1] = str2;
        this.writer.write(60);
        if (!prefix.isEmpty()) {
            this.writer.write(prefix);
            this.writer.write(58);
        }
        this.writer.write(str2);
        this.pending = true;
        return this;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public XmlSerializer text(String str) throws IOException {
        check(false);
        this.indent[this.depth] = false;
        writeEscaped(str, -1);
        return this;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public XmlSerializer text(char[] cArr, int i, int i2) throws IOException {
        text(new String(cArr, i, i2));
        return this;
    }
}
