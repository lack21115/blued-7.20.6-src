package com.google.gson.stream;

import com.igexin.push.core.b;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;

/* loaded from: source-8110460-dex2jar.jar:com/google/gson/stream/JsonWriter.class */
public class JsonWriter implements Closeable, Flushable {
    private static final String[] HTML_SAFE_REPLACEMENT_CHARS;
    private static final String[] REPLACEMENT_CHARS = new String[128];
    private String deferredName;
    private boolean htmlSafe;
    private String indent;
    private boolean lenient;
    private final Writer out;
    private String separator;
    private boolean serializeNulls;
    private int[] stack = new int[32];
    private int stackSize = 0;

    static {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 > 31) {
                String[] strArr = REPLACEMENT_CHARS;
                strArr[34] = "\\\"";
                strArr[92] = "\\\\";
                strArr[9] = "\\t";
                strArr[8] = "\\b";
                strArr[10] = "\\n";
                strArr[13] = "\\r";
                strArr[12] = "\\f";
                String[] strArr2 = (String[]) strArr.clone();
                HTML_SAFE_REPLACEMENT_CHARS = strArr2;
                strArr2[60] = "\\u003c";
                strArr2[62] = "\\u003e";
                strArr2[38] = "\\u0026";
                strArr2[61] = "\\u003d";
                strArr2[39] = "\\u0027";
                return;
            }
            REPLACEMENT_CHARS[i2] = String.format("\\u%04x", Integer.valueOf(i2));
            i = i2 + 1;
        }
    }

    public JsonWriter(Writer writer) {
        push(6);
        this.separator = ":";
        this.serializeNulls = true;
        if (writer == null) {
            throw new NullPointerException("out == null");
        }
        this.out = writer;
    }

    private void beforeName() throws IOException {
        int peek = peek();
        if (peek == 5) {
            this.out.write(44);
        } else if (peek != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        newline();
        replaceTop(4);
    }

    private void beforeValue() throws IOException {
        int peek = peek();
        if (peek == 1) {
            replaceTop(2);
            newline();
        } else if (peek == 2) {
            this.out.append(',');
            newline();
        } else if (peek == 4) {
            this.out.append((CharSequence) this.separator);
            replaceTop(5);
        } else {
            if (peek != 6) {
                if (peek != 7) {
                    throw new IllegalStateException("Nesting problem.");
                }
                if (!this.lenient) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
            }
            replaceTop(7);
        }
    }

    private JsonWriter close(int i, int i2, char c2) throws IOException {
        int peek = peek();
        if (peek == i2 || peek == i) {
            if (this.deferredName != null) {
                throw new IllegalStateException("Dangling name: " + this.deferredName);
            }
            this.stackSize--;
            if (peek == i2) {
                newline();
            }
            this.out.write(c2);
            return this;
        }
        throw new IllegalStateException("Nesting problem.");
    }

    private void newline() throws IOException {
        if (this.indent == null) {
            return;
        }
        this.out.write(10);
        int i = this.stackSize;
        int i2 = 1;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                return;
            }
            this.out.write(this.indent);
            i2 = i3 + 1;
        }
    }

    private JsonWriter open(int i, char c2) throws IOException {
        beforeValue();
        push(i);
        this.out.write(c2);
        return this;
    }

    private int peek() {
        int i = this.stackSize;
        if (i != 0) {
            return this.stack[i - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    private void push(int i) {
        int i2 = this.stackSize;
        int[] iArr = this.stack;
        if (i2 == iArr.length) {
            this.stack = Arrays.copyOf(iArr, i2 * 2);
        }
        int[] iArr2 = this.stack;
        int i3 = this.stackSize;
        this.stackSize = i3 + 1;
        iArr2[i3] = i;
    }

    private void replaceTop(int i) {
        this.stack[this.stackSize - 1] = i;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0075  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void string(java.lang.String r7) throws java.io.IOException {
        /*
            r6 = this;
            r0 = r6
            boolean r0 = r0.htmlSafe
            if (r0 == 0) goto Lf
            java.lang.String[] r0 = com.google.gson.stream.JsonWriter.HTML_SAFE_REPLACEMENT_CHARS
            r14 = r0
            goto L14
        Lf:
            java.lang.String[] r0 = com.google.gson.stream.JsonWriter.REPLACEMENT_CHARS
            r14 = r0
        L14:
            r0 = r6
            java.io.Writer r0 = r0.out
            r1 = 34
            r0.write(r1)
            r0 = r7
            int r0 = r0.length()
            r11 = r0
            r0 = 0
            r8 = r0
            r0 = 0
            r9 = r0
        L27:
            r0 = r8
            r1 = r11
            if (r0 >= r1) goto L99
            r0 = r7
            r1 = r8
            char r0 = r0.charAt(r1)
            r12 = r0
            r0 = r12
            r1 = 128(0x80, float:1.794E-43)
            if (r0 >= r1) goto L52
            r0 = r14
            r1 = r12
            r0 = r0[r1]
            r15 = r0
            r0 = r15
            r13 = r0
            r0 = r15
            if (r0 != 0) goto L70
            r0 = r9
            r10 = r0
            goto L8f
        L52:
            r0 = r12
            r1 = 8232(0x2028, float:1.1535E-41)
            if (r0 != r1) goto L61
            java.lang.String r0 = "\\u2028"
            r13 = r0
            goto L70
        L61:
            r0 = r9
            r10 = r0
            r0 = r12
            r1 = 8233(0x2029, float:1.1537E-41)
            if (r0 != r1) goto L8f
            java.lang.String r0 = "\\u2029"
            r13 = r0
        L70:
            r0 = r9
            r1 = r8
            if (r0 >= r1) goto L81
            r0 = r6
            java.io.Writer r0 = r0.out
            r1 = r7
            r2 = r9
            r3 = r8
            r4 = r9
            int r3 = r3 - r4
            r0.write(r1, r2, r3)
        L81:
            r0 = r6
            java.io.Writer r0 = r0.out
            r1 = r13
            r0.write(r1)
            r0 = r8
            r1 = 1
            int r0 = r0 + r1
            r10 = r0
        L8f:
            r0 = r8
            r1 = 1
            int r0 = r0 + r1
            r8 = r0
            r0 = r10
            r9 = r0
            goto L27
        L99:
            r0 = r9
            r1 = r11
            if (r0 >= r1) goto Lac
            r0 = r6
            java.io.Writer r0 = r0.out
            r1 = r7
            r2 = r9
            r3 = r11
            r4 = r9
            int r3 = r3 - r4
            r0.write(r1, r2, r3)
        Lac:
            r0 = r6
            java.io.Writer r0 = r0.out
            r1 = 34
            r0.write(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.stream.JsonWriter.string(java.lang.String):void");
    }

    private void writeDeferredName() throws IOException {
        if (this.deferredName != null) {
            beforeName();
            string(this.deferredName);
            this.deferredName = null;
        }
    }

    public JsonWriter beginArray() throws IOException {
        writeDeferredName();
        return open(1, '[');
    }

    public JsonWriter beginObject() throws IOException {
        writeDeferredName();
        return open(3, '{');
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.out.close();
        int i = this.stackSize;
        if (i > 1 || (i == 1 && this.stack[i - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.stackSize = 0;
    }

    public JsonWriter endArray() throws IOException {
        return close(1, 2, ']');
    }

    public JsonWriter endObject() throws IOException {
        return close(3, 5, '}');
    }

    public void flush() throws IOException {
        if (this.stackSize == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.out.flush();
    }

    public final boolean getSerializeNulls() {
        return this.serializeNulls;
    }

    public final boolean isHtmlSafe() {
        return this.htmlSafe;
    }

    public boolean isLenient() {
        return this.lenient;
    }

    public JsonWriter jsonValue(String str) throws IOException {
        if (str == null) {
            return nullValue();
        }
        writeDeferredName();
        beforeValue();
        this.out.append((CharSequence) str);
        return this;
    }

    public JsonWriter name(String str) throws IOException {
        if (str != null) {
            if (this.deferredName == null) {
                if (this.stackSize != 0) {
                    this.deferredName = str;
                    return this;
                }
                throw new IllegalStateException("JsonWriter is closed.");
            }
            throw new IllegalStateException();
        }
        throw new NullPointerException("name == null");
    }

    public JsonWriter nullValue() throws IOException {
        if (this.deferredName != null) {
            if (!this.serializeNulls) {
                this.deferredName = null;
                return this;
            }
            writeDeferredName();
        }
        beforeValue();
        this.out.write(b.l);
        return this;
    }

    public final void setHtmlSafe(boolean z) {
        this.htmlSafe = z;
    }

    public final void setIndent(String str) {
        if (str.length() == 0) {
            this.indent = null;
            this.separator = ":";
            return;
        }
        this.indent = str;
        this.separator = ": ";
    }

    public final void setLenient(boolean z) {
        this.lenient = z;
    }

    public final void setSerializeNulls(boolean z) {
        this.serializeNulls = z;
    }

    public JsonWriter value(double d) throws IOException {
        writeDeferredName();
        if (this.lenient || !(Double.isNaN(d) || Double.isInfinite(d))) {
            beforeValue();
            this.out.append((CharSequence) Double.toString(d));
            return this;
        }
        throw new IllegalArgumentException("Numeric values must be finite, but was " + d);
    }

    public JsonWriter value(long j) throws IOException {
        writeDeferredName();
        beforeValue();
        this.out.write(Long.toString(j));
        return this;
    }

    public JsonWriter value(Boolean bool) throws IOException {
        if (bool == null) {
            return nullValue();
        }
        writeDeferredName();
        beforeValue();
        this.out.write(bool.booleanValue() ? "true" : "false");
        return this;
    }

    public JsonWriter value(Number number) throws IOException {
        if (number == null) {
            return nullValue();
        }
        writeDeferredName();
        String obj = number.toString();
        if (this.lenient || !(obj.equals("-Infinity") || obj.equals("Infinity") || obj.equals("NaN"))) {
            beforeValue();
            this.out.append((CharSequence) obj);
            return this;
        }
        throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
    }

    public JsonWriter value(String str) throws IOException {
        if (str == null) {
            return nullValue();
        }
        writeDeferredName();
        beforeValue();
        string(str);
        return this;
    }

    public JsonWriter value(boolean z) throws IOException {
        writeDeferredName();
        beforeValue();
        this.out.write(z ? "true" : "false");
        return this;
    }
}
