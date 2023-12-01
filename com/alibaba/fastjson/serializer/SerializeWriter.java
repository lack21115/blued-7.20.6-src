package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.util.IOUtils;
import com.android.dex.DexFormat;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.lang.ref.SoftReference;
import java.math.BigDecimal;
import java.nio.charset.Charset;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/fastjson/serializer/SerializeWriter.class */
public final class SerializeWriter extends Writer {
    private static final ThreadLocal<SoftReference<char[]>> bufLocal = new ThreadLocal<>();
    protected boolean beanToArray;
    protected boolean browserCompatible;
    protected boolean browserSecure;
    protected char[] buf;
    protected SoftReference<char[]> bufLocalRef;
    protected int count;
    protected boolean disableCheckSpecialChar;
    protected boolean disableCircularReferenceDetect;
    protected int features;
    protected boolean ignoreNonFieldGetter;
    protected char keySeperator;
    protected boolean notWriteDefaultValue;
    protected boolean notWriteRootClassName;
    protected boolean prettyFormat;
    protected boolean quoteFieldNames;
    protected boolean skipTransientField;
    protected boolean sortField;
    protected boolean useSingleQuotes;
    protected boolean writeClassName;
    protected boolean writeDirect;
    protected boolean writeEnumUsingName;
    protected boolean writeEnumUsingToString;
    protected boolean writeMapNullValue;
    protected boolean writeNonStringValueAsString;
    private final Writer writer;

    public SerializeWriter() {
        this((Writer) null);
    }

    public SerializeWriter(int i) {
        this((Writer) null, i);
    }

    public SerializeWriter(Writer writer) {
        this.writer = writer;
        this.features = JSON.DEFAULT_GENERATE_FEATURE;
        computeFeatures();
        SoftReference<char[]> softReference = bufLocal.get();
        this.bufLocalRef = softReference;
        if (softReference != null) {
            this.buf = softReference.get();
            bufLocal.set(null);
        }
        if (this.buf == null) {
            this.buf = new char[1024];
        }
    }

    public SerializeWriter(Writer writer, int i) {
        this.writer = writer;
        if (i > 0) {
            this.buf = new char[i];
            return;
        }
        throw new IllegalArgumentException("Negative initial size: " + i);
    }

    public SerializeWriter(Writer writer, int i, SerializerFeature... serializerFeatureArr) {
        this.writer = writer;
        SoftReference<char[]> softReference = bufLocal.get();
        this.bufLocalRef = softReference;
        if (softReference != null) {
            this.buf = softReference.get();
            bufLocal.set(null);
        }
        if (this.buf == null) {
            this.buf = new char[1024];
        }
        int length = serializerFeatureArr.length;
        int i2 = i;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= length) {
                this.features = i2;
                computeFeatures();
                return;
            }
            i2 |= serializerFeatureArr[i4].getMask();
            i3 = i4 + 1;
        }
    }

    public SerializeWriter(Writer writer, SerializerFeature... serializerFeatureArr) {
        this(writer, 0, serializerFeatureArr);
    }

    public SerializeWriter(SerializerFeature... serializerFeatureArr) {
        this((Writer) null, serializerFeatureArr);
    }

    static boolean isSpecial(char c, int i) {
        boolean z = false;
        if (c == ' ') {
            return false;
        }
        if (c == '/') {
            if ((SerializerFeature.WriteSlashAsSpecial.mask & i) != 0) {
                z = true;
            }
            return z;
        } else if (c <= '#' || c == '\\') {
            return c <= 31 || c == '\\' || c == '\"';
        } else {
            return false;
        }
    }

    private void writeEnumFieldValue(char c, String str, String str2) {
        if (this.useSingleQuotes) {
            writeFieldValue(c, str, str2);
        } else {
            writeFieldValueStringWithDoubleQuote(c, str, str2);
        }
    }

    private void writeEnumValue(String str, char c) {
        if (isEnabled(SerializerFeature.UseSingleQuotes)) {
            write(39);
            write(str);
            write(39);
            write(c);
            return;
        }
        write(34);
        write(str);
        write(34);
        write(c);
    }

    private void writeKeyWithSingleQuoteIfHasSpecial(String str) {
        boolean z;
        byte[] bArr = IOUtils.specicalFlags_singleQuotes;
        int length = str.length();
        int i = this.count + length + 1;
        if (i > this.buf.length) {
            if (this.writer != null) {
                if (length == 0) {
                    write(39);
                    write(39);
                    write(58);
                    return;
                }
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= length) {
                        z = false;
                        break;
                    }
                    char charAt = str.charAt(i3);
                    if (charAt < bArr.length && bArr[charAt] != 0) {
                        z = true;
                        break;
                    }
                    i2 = i3 + 1;
                }
                int i4 = 0;
                if (z) {
                    write(39);
                    i4 = 0;
                }
                while (i4 < length) {
                    char charAt2 = str.charAt(i4);
                    if (charAt2 >= bArr.length || bArr[charAt2] == 0) {
                        write(charAt2);
                    } else {
                        write(92);
                        write(IOUtils.replaceChars[charAt2]);
                    }
                    i4++;
                }
                if (z) {
                    write(39);
                }
                write(58);
                return;
            }
            expandCapacity(i);
        }
        if (length == 0) {
            int i5 = this.count;
            if (i5 + 3 > this.buf.length) {
                expandCapacity(i5 + 3);
            }
            char[] cArr = this.buf;
            int i6 = this.count;
            int i7 = i6 + 1;
            this.count = i7;
            cArr[i6] = '\'';
            int i8 = i7 + 1;
            this.count = i8;
            cArr[i7] = '\'';
            this.count = i8 + 1;
            cArr[i8] = ':';
            return;
        }
        int i9 = this.count;
        int i10 = i9 + length;
        str.getChars(0, length, this.buf, i9);
        this.count = i;
        int i11 = i9;
        boolean z2 = false;
        while (i11 < i10) {
            char[] cArr2 = this.buf;
            char c = cArr2[i11];
            int i12 = i11;
            boolean z3 = z2;
            int i13 = i;
            int i14 = i10;
            if (c < bArr.length) {
                i12 = i11;
                z3 = z2;
                i13 = i;
                i14 = i10;
                if (bArr[c] != 0) {
                    if (z2) {
                        i13 = i + 1;
                        if (i13 > cArr2.length) {
                            expandCapacity(i13);
                        }
                        this.count = i13;
                        char[] cArr3 = this.buf;
                        i12 = i11 + 1;
                        System.arraycopy((Object) cArr3, i12, (Object) cArr3, i11 + 2, i10 - i11);
                        char[] cArr4 = this.buf;
                        cArr4[i11] = '\\';
                        cArr4[i12] = IOUtils.replaceChars[c];
                        i14 = i10 + 1;
                        z3 = z2;
                    } else {
                        i13 = i + 3;
                        if (i13 > cArr2.length) {
                            expandCapacity(i13);
                        }
                        this.count = i13;
                        char[] cArr5 = this.buf;
                        int i15 = i11 + 1;
                        System.arraycopy((Object) cArr5, i15, (Object) cArr5, i11 + 3, (i10 - i11) - 1);
                        char[] cArr6 = this.buf;
                        System.arraycopy((Object) cArr6, 0, (Object) cArr6, 1, i11);
                        char[] cArr7 = this.buf;
                        cArr7[i9] = '\'';
                        cArr7[i15] = '\\';
                        i12 = i15 + 1;
                        cArr7[i12] = IOUtils.replaceChars[c];
                        i14 = i10 + 2;
                        this.buf[this.count - 2] = '\'';
                        z3 = true;
                    }
                }
            }
            i11 = i12 + 1;
            z2 = z3;
            i = i13;
            i10 = i14;
        }
        this.buf[i - 1] = ':';
    }

    @Override // java.io.Writer, java.lang.Appendable
    public SerializeWriter append(char c) {
        write(c);
        return this;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public SerializeWriter append(CharSequence charSequence) {
        String charSequence2 = charSequence == null ? "null" : charSequence.toString();
        write(charSequence2, 0, charSequence2.length());
        return this;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public SerializeWriter append(CharSequence charSequence, int i, int i2) {
        CharSequence charSequence2 = charSequence;
        if (charSequence == null) {
            charSequence2 = "null";
        }
        String charSequence3 = charSequence2.subSequence(i, i2).toString();
        write(charSequence3, 0, charSequence3.length());
        return this;
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.writer != null && this.count > 0) {
            flush();
        }
        if (this.buf.length <= 8192) {
            SoftReference<char[]> softReference = this.bufLocalRef;
            bufLocal.set((softReference == null || softReference.get() != this.buf) ? new SoftReference<>(this.buf) : this.bufLocalRef);
        }
        this.buf = null;
    }

    protected void computeFeatures() {
        boolean z;
        this.browserSecure = (this.features & SerializerFeature.BrowserSecure.mask) != 0;
        this.browserCompatible = (this.features & SerializerFeature.BrowserCompatible.mask) != 0;
        this.quoteFieldNames = (this.features & SerializerFeature.QuoteFieldNames.mask) != 0;
        this.useSingleQuotes = (this.features & SerializerFeature.UseSingleQuotes.mask) != 0;
        this.sortField = (this.features & SerializerFeature.SortField.mask) != 0;
        this.disableCircularReferenceDetect = (this.features & SerializerFeature.DisableCircularReferenceDetect.mask) != 0;
        this.beanToArray = (this.features & SerializerFeature.BeanToArray.mask) != 0;
        this.prettyFormat = (this.features & SerializerFeature.PrettyFormat.mask) != 0;
        this.writeClassName = (this.features & SerializerFeature.WriteClassName.mask) != 0;
        this.notWriteRootClassName = (this.features & SerializerFeature.NotWriteRootClassName.mask) != 0;
        this.skipTransientField = (this.features & SerializerFeature.SkipTransientField.mask) != 0;
        this.ignoreNonFieldGetter = (this.features & SerializerFeature.IgnoreNonFieldGetter.mask) != 0;
        this.writeNonStringValueAsString = (this.features & SerializerFeature.WriteNonStringValueAsString.mask) != 0;
        this.notWriteDefaultValue = (this.features & SerializerFeature.NotWriteDefaultValue.mask) != 0;
        this.writeEnumUsingName = (this.features & SerializerFeature.WriteEnumUsingName.mask) != 0;
        this.writeEnumUsingToString = (this.features & SerializerFeature.WriteEnumUsingToString.mask) != 0;
        this.writeMapNullValue = (this.features & SerializerFeature.WriteMapNullValue.mask) != 0;
        this.disableCheckSpecialChar = (this.features & SerializerFeature.DisableCheckSpecialChar.mask) != 0;
        this.writeDirect = (!this.quoteFieldNames || this.useSingleQuotes || (z = this.browserCompatible) || this.browserSecure || z || !this.writeEnumUsingName || this.writeEnumUsingToString || this.writeNonStringValueAsString || (this.features & SerializerFeature.WriteSlashAsSpecial.mask) != 0) ? false : true;
        this.keySeperator = this.useSingleQuotes ? '\'' : '\"';
    }

    public void config(SerializerFeature serializerFeature, boolean z) {
        if (z) {
            this.features |= serializerFeature.getMask();
            if (serializerFeature == SerializerFeature.WriteEnumUsingToString) {
                this.features &= SerializerFeature.WriteEnumUsingName.getMask();
            } else if (serializerFeature == SerializerFeature.WriteEnumUsingName) {
                this.features &= SerializerFeature.WriteEnumUsingToString.getMask();
            }
        } else {
            this.features = serializerFeature.getMask() & this.features;
        }
        computeFeatures();
    }

    public void expandCapacity(int i) {
        int length = ((this.buf.length * 3) / 2) + 1;
        if (length >= i) {
            i = length;
        }
        char[] cArr = new char[i];
        System.arraycopy((Object) this.buf, 0, (Object) cArr, 0, this.count);
        this.buf = cArr;
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
        Writer writer = this.writer;
        if (writer == null) {
            return;
        }
        try {
            writer.write(this.buf, 0, this.count);
            this.writer.flush();
            this.count = 0;
        } catch (IOException e) {
            throw new JSONException(e.getMessage(), e);
        }
    }

    public int getBufferLength() {
        return this.buf.length;
    }

    public boolean isEnabled(SerializerFeature serializerFeature) {
        return (serializerFeature.mask & this.features) != 0;
    }

    public boolean isIgnoreNonFieldGetter() {
        return this.ignoreNonFieldGetter;
    }

    public boolean isNotWriteDefaultValue() {
        return this.notWriteDefaultValue;
    }

    public boolean isPrettyFormat() {
        return this.prettyFormat;
    }

    public boolean isSkipTransientField() {
        return this.skipTransientField;
    }

    public boolean isSortField() {
        return this.sortField;
    }

    public boolean isWriteMapNullValue() {
        return this.writeMapNullValue;
    }

    public void reset() {
        this.count = 0;
    }

    public int size() {
        return this.count;
    }

    public byte[] toBytes(String str) {
        if (this.writer == null) {
            String str2 = str;
            if (str == null) {
                str2 = "UTF-8";
            }
            return new SerialWriterStringEncoder(Charset.forName(str2)).encode(this.buf, 0, this.count);
        }
        throw new UnsupportedOperationException("writer not null");
    }

    public char[] toCharArray() {
        if (this.writer == null) {
            int i = this.count;
            char[] cArr = new char[i];
            System.arraycopy((Object) this.buf, 0, (Object) cArr, 0, i);
            return cArr;
        }
        throw new UnsupportedOperationException("writer not null");
    }

    public String toString() {
        return new String(this.buf, 0, this.count);
    }

    @Override // java.io.Writer
    public void write(int i) {
        int i2 = 1;
        int i3 = this.count + 1;
        if (i3 > this.buf.length) {
            if (this.writer != null) {
                flush();
                this.buf[this.count] = (char) i;
                this.count = i2;
            }
            expandCapacity(i3);
        }
        i2 = i3;
        this.buf[this.count] = (char) i;
        this.count = i2;
    }

    @Override // java.io.Writer
    public void write(String str) {
        if (str == null) {
            writeNull();
        } else {
            write(str, 0, str.length());
        }
    }

    @Override // java.io.Writer
    public void write(String str, int i, int i2) {
        int i3;
        int i4;
        int i5 = this.count + i2;
        int i6 = i5;
        int i7 = i;
        int i8 = i2;
        if (i5 > this.buf.length) {
            int i9 = i;
            int i10 = i2;
            if (this.writer == null) {
                expandCapacity(i5);
                i6 = i5;
                i7 = i;
                i8 = i2;
            } else {
                while (true) {
                    char[] cArr = this.buf;
                    int length = cArr.length;
                    int i11 = this.count;
                    int i12 = length - i11;
                    i3 = i9 + i12;
                    str.getChars(i9, i3, cArr, i11);
                    this.count = this.buf.length;
                    flush();
                    i4 = i10 - i12;
                    if (i4 <= this.buf.length) {
                        break;
                    }
                    i9 = i3;
                    i10 = i4;
                }
                i6 = i4;
                i7 = i3;
                i8 = i4;
            }
        }
        str.getChars(i7, i8 + i7, this.buf, this.count);
        this.count = i6;
    }

    public void write(boolean z) {
        if (z) {
            write("true");
        } else {
            write("false");
        }
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i, int i2) {
        int i3;
        int i4;
        int i5;
        if (i < 0 || i > cArr.length || i2 < 0 || (i3 = i + i2) > cArr.length || i3 < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (i2 == 0) {
            return;
        }
        int i6 = this.count + i2;
        int i7 = i6;
        int i8 = i;
        int i9 = i2;
        if (i6 > this.buf.length) {
            int i10 = i;
            int i11 = i2;
            if (this.writer == null) {
                expandCapacity(i6);
                i7 = i6;
                i8 = i;
                i9 = i2;
            } else {
                do {
                    char[] cArr2 = this.buf;
                    int length = cArr2.length;
                    int i12 = this.count;
                    int i13 = length - i12;
                    System.arraycopy((Object) cArr, i10, (Object) cArr2, i12, i13);
                    this.count = this.buf.length;
                    flush();
                    i4 = i11 - i13;
                    i5 = i10 + i13;
                    i10 = i5;
                    i11 = i4;
                } while (i4 > this.buf.length);
                i7 = i4;
                i9 = i4;
                i8 = i5;
            }
        }
        System.arraycopy((Object) cArr, i8, (Object) this.buf, this.count, i9);
        this.count = i7;
    }

    public void writeBooleanAndChar(boolean z, char c) {
        if (z) {
            if (c == ',') {
                write("true,");
            } else if (c == ']') {
                write("true]");
            } else {
                write("true");
                write(c);
            }
        } else if (c == ',') {
            write("false,");
        } else if (c == ']') {
            write("false]");
        } else {
            write("false");
            write(c);
        }
    }

    public void writeByteArray(byte[] bArr) {
        int length = bArr.length;
        char c = this.useSingleQuotes ? '\'' : '\"';
        if (length == 0) {
            write(this.useSingleQuotes ? "''" : "\"\"");
            return;
        }
        char[] cArr = IOUtils.CA;
        int i = (length / 3) * 3;
        int i2 = length - 1;
        int i3 = i2 / 3;
        int i4 = this.count;
        int i5 = ((i3 + 1) << 2) + i4 + 2;
        if (i5 > this.buf.length) {
            if (this.writer != null) {
                write(c);
                int i6 = 0;
                while (true) {
                    int i7 = i6;
                    if (i7 >= i) {
                        break;
                    }
                    int i8 = i7 + 1;
                    int i9 = i8 + 1;
                    int i10 = ((bArr[i7] & 255) << 16) | ((bArr[i8] & 255) << 8) | (bArr[i9] & 255);
                    write(cArr[(i10 >>> 18) & 63]);
                    write(cArr[(i10 >>> 12) & 63]);
                    write(cArr[(i10 >>> 6) & 63]);
                    write(cArr[i10 & 63]);
                    i6 = i9 + 1;
                }
                int i11 = length - i;
                if (i11 > 0) {
                    byte b = bArr[i];
                    int i12 = 0;
                    if (i11 == 2) {
                        i12 = (bArr[i2] & 255) << 2;
                    }
                    int i13 = ((b & 255) << 10) | i12;
                    write(cArr[i13 >> 12]);
                    write(cArr[(i13 >>> 6) & 63]);
                    write(i11 == 2 ? cArr[i13 & 63] : '=');
                    write(61);
                }
                write(c);
                return;
            }
            expandCapacity(i5);
        }
        this.count = i5;
        int i14 = i4 + 1;
        this.buf[i4] = c;
        int i15 = 0;
        while (true) {
            int i16 = i15;
            if (i16 >= i) {
                break;
            }
            int i17 = i16 + 1;
            int i18 = i17 + 1;
            int i19 = ((bArr[i16] & 255) << 16) | ((bArr[i17] & 255) << 8) | (bArr[i18] & 255);
            char[] cArr2 = this.buf;
            int i20 = i14 + 1;
            cArr2[i14] = cArr[(i19 >>> 18) & 63];
            int i21 = i20 + 1;
            cArr2[i20] = cArr[(i19 >>> 12) & 63];
            int i22 = i21 + 1;
            cArr2[i21] = cArr[(i19 >>> 6) & 63];
            i14 = i22 + 1;
            cArr2[i22] = cArr[i19 & 63];
            i15 = i18 + 1;
        }
        int i23 = length - i;
        if (i23 > 0) {
            byte b2 = bArr[i];
            int i24 = 0;
            if (i23 == 2) {
                i24 = (bArr[i2] & 255) << 2;
            }
            int i25 = ((b2 & 255) << 10) | i24;
            char[] cArr3 = this.buf;
            cArr3[i5 - 5] = cArr[i25 >> 12];
            cArr3[i5 - 4] = cArr[(i25 >>> 6) & 63];
            cArr3[i5 - 3] = i23 == 2 ? cArr[i25 & 63] : '=';
            this.buf[i5 - 2] = '=';
        }
        this.buf[i5 - 1] = c;
    }

    public void writeCharacterAndChar(char c, char c2) {
        writeString(Character.toString(c));
        write(c2);
    }

    public void writeDoubleAndChar(double d, char c) {
        String d2 = Double.toString(d);
        String str = d2;
        if (d2.endsWith(".0")) {
            str = d2.substring(0, d2.length() - 2);
        }
        write(str);
        write(c);
    }

    public void writeEnum(Enum<?> r5, char c) {
        if (r5 == null) {
            writeNull();
            write(44);
        } else if (isEnabled(SerializerFeature.WriteEnumUsingName)) {
            writeEnumValue(r5.name(), c);
        } else if (isEnabled(SerializerFeature.WriteEnumUsingToString)) {
            writeEnumValue(r5.toString(), c);
        } else {
            writeIntAndChar(r5.ordinal(), c);
        }
    }

    public void writeFieldEmptyList(char c, String str) {
        write(c);
        writeFieldName(str);
        write("[]");
    }

    public void writeFieldName(String str) {
        writeFieldName(str, false);
    }

    public void writeFieldName(String str, boolean z) {
        if (str == null) {
            write("null:");
        } else if (this.useSingleQuotes) {
            if (!this.quoteFieldNames) {
                writeKeyWithSingleQuoteIfHasSpecial(str);
                return;
            }
            writeStringWithSingleQuote(str);
            write(58);
        } else if (this.quoteFieldNames) {
            writeStringWithDoubleQuote(str, ':');
        } else {
            boolean z2 = str.length() == 0;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= str.length()) {
                    break;
                } else if (isSpecial(str.charAt(i2), 0)) {
                    z2 = true;
                    break;
                } else {
                    i = i2 + 1;
                }
            }
            if (z2) {
                writeStringWithDoubleQuote(str, ':');
                return;
            }
            write(str);
            write(58);
        }
    }

    public void writeFieldNull(char c, String str) {
        write(c);
        writeFieldName(str);
        writeNull();
    }

    public void writeFieldNullBoolean(char c, String str) {
        write(c);
        writeFieldName(str);
        if (isEnabled(SerializerFeature.WriteNullBooleanAsFalse)) {
            write("false");
        } else {
            writeNull();
        }
    }

    public void writeFieldNullList(char c, String str) {
        write(c);
        writeFieldName(str);
        if (isEnabled(SerializerFeature.WriteNullListAsEmpty)) {
            write("[]");
        } else {
            writeNull();
        }
    }

    public void writeFieldNullNumber(char c, String str) {
        write(c);
        writeFieldName(str);
        if (isEnabled(SerializerFeature.WriteNullNumberAsZero)) {
            write(48);
        } else {
            writeNull();
        }
    }

    public void writeFieldNullString(char c, String str) {
        write(c);
        writeFieldName(str);
        if (isEnabled(SerializerFeature.WriteNullStringAsEmpty)) {
            writeString("");
        } else {
            writeNull();
        }
    }

    public void writeFieldValue(char c, String str, char c2) {
        write(c);
        writeFieldName(str);
        if (c2 == 0) {
            writeString(DexFormat.MAGIC_SUFFIX);
        } else {
            writeString(Character.toString(c2));
        }
    }

    public void writeFieldValue(char c, String str, double d) {
        write(c);
        writeFieldName(str);
        if (d == 0.0d) {
            write(48);
        } else if (Double.isNaN(d)) {
            writeNull();
        } else if (Double.isInfinite(d)) {
            writeNull();
        } else {
            String d2 = Double.toString(d);
            String str2 = d2;
            if (d2.endsWith(".0")) {
                str2 = d2.substring(0, d2.length() - 2);
            }
            write(str2);
        }
    }

    public void writeFieldValue(char c, String str, float f) {
        write(c);
        writeFieldName(str);
        if (f == 0.0f) {
            write(48);
        } else if (Float.isNaN(f)) {
            writeNull();
        } else if (Float.isInfinite(f)) {
            writeNull();
        } else {
            String f2 = Float.toString(f);
            String str2 = f2;
            if (f2.endsWith(".0")) {
                str2 = f2.substring(0, f2.length() - 2);
            }
            write(str2);
        }
    }

    public void writeFieldValue(char c, String str, int i) {
        if (i == Integer.MIN_VALUE || !this.quoteFieldNames) {
            writeFieldValue1(c, str, i);
            return;
        }
        int stringSize = i < 0 ? IOUtils.stringSize(-i) + 1 : IOUtils.stringSize(i);
        int length = str.length();
        int i2 = this.count + length + 4 + stringSize;
        if (i2 > this.buf.length) {
            if (this.writer != null) {
                writeFieldValue1(c, str, i);
                return;
            }
            expandCapacity(i2);
        }
        int i3 = this.count;
        this.count = i2;
        char[] cArr = this.buf;
        cArr[i3] = c;
        int i4 = i3 + length + 1;
        cArr[i3 + 1] = this.keySeperator;
        str.getChars(0, length, cArr, i3 + 2);
        char[] cArr2 = this.buf;
        cArr2[i4 + 1] = this.keySeperator;
        cArr2[i4 + 2] = ':';
        IOUtils.getChars(i, this.count, cArr2);
    }

    public void writeFieldValue(char c, String str, long j) {
        if (j == Long.MIN_VALUE || !this.quoteFieldNames) {
            writeFieldValue1(c, str, j);
            return;
        }
        int stringSize = j < 0 ? IOUtils.stringSize(-j) + 1 : IOUtils.stringSize(j);
        int length = str.length();
        int i = this.count + length + 4 + stringSize;
        if (i > this.buf.length) {
            if (this.writer != null) {
                write(c);
                writeFieldName(str);
                writeLong(j);
                return;
            }
            expandCapacity(i);
        }
        int i2 = this.count;
        this.count = i;
        char[] cArr = this.buf;
        cArr[i2] = c;
        int i3 = i2 + length + 1;
        cArr[i2 + 1] = this.keySeperator;
        str.getChars(0, length, cArr, i2 + 2);
        char[] cArr2 = this.buf;
        cArr2[i3 + 1] = this.keySeperator;
        cArr2[i3 + 2] = ':';
        IOUtils.getChars(j, this.count, cArr2);
    }

    public void writeFieldValue(char c, String str, Enum<?> r8) {
        if (r8 == null) {
            write(c);
            writeFieldName(str);
            writeNull();
        } else if (this.writeEnumUsingName && !this.writeEnumUsingToString) {
            writeEnumFieldValue(c, str, r8.name());
        } else if (this.writeEnumUsingToString) {
            writeEnumFieldValue(c, str, r8.toString());
        } else {
            writeFieldValue(c, str, r8.ordinal());
        }
    }

    public void writeFieldValue(char c, String str, String str2) {
        if (!this.quoteFieldNames) {
            write(c);
            writeFieldName(str);
            if (str2 == null) {
                writeNull();
            } else {
                writeString(str2);
            }
        } else if (this.useSingleQuotes) {
            write(c);
            writeFieldName(str);
            if (str2 == null) {
                writeNull();
            } else {
                writeString(str2);
            }
        } else if (this.browserSecure) {
            write(c);
            writeStringWithDoubleQuote(str, ':');
            writeStringWithDoubleQuote(str2, (char) 0);
        } else if (!this.browserCompatible) {
            writeFieldValueStringWithDoubleQuoteCheck(c, str, str2);
        } else {
            write(c);
            writeStringWithDoubleQuote(str, ':');
            writeStringWithDoubleQuote(str2, (char) 0);
        }
    }

    public void writeFieldValue(char c, String str, BigDecimal bigDecimal) {
        write(c);
        writeFieldName(str);
        if (bigDecimal == null) {
            writeNull();
        } else {
            write(bigDecimal.toString());
        }
    }

    public void writeFieldValue(char c, String str, boolean z) {
        int i = z ? 4 : 5;
        int length = str.length();
        int i2 = this.count + length + 4 + i;
        if (i2 > this.buf.length) {
            if (this.writer != null) {
                write(c);
                writeString(str);
                write(58);
                write(z);
                return;
            }
            expandCapacity(i2);
        }
        int i3 = this.count;
        this.count = i2;
        char[] cArr = this.buf;
        cArr[i3] = c;
        int i4 = i3 + length + 1;
        cArr[i3 + 1] = this.keySeperator;
        str.getChars(0, length, cArr, i3 + 2);
        this.buf[i4 + 1] = this.keySeperator;
        if (z) {
            System.arraycopy((Object) ":true".toCharArray(), 0, (Object) this.buf, i4 + 2, 5);
        } else {
            System.arraycopy((Object) ":false".toCharArray(), 0, (Object) this.buf, i4 + 2, 6);
        }
    }

    public void writeFieldValue1(char c, String str, int i) {
        write(c);
        writeFieldName(str);
        writeInt(i);
    }

    public void writeFieldValue1(char c, String str, long j) {
        write(c);
        writeFieldName(str);
        writeLong(j);
    }

    public void writeFieldValueStringWithDoubleQuote(char c, String str, String str2) {
        int length;
        int i;
        int length2 = str.length();
        int i2 = this.count;
        if (str2 == null) {
            length = 4;
            i = length2 + 8;
        } else {
            length = str2.length();
            i = length2 + length + 6;
        }
        int i3 = i2 + i;
        if (i3 > this.buf.length) {
            if (this.writer != null) {
                write(c);
                writeStringWithDoubleQuote(str, ':');
                writeStringWithDoubleQuote(str2, (char) 0);
                return;
            }
            expandCapacity(i3);
        }
        char[] cArr = this.buf;
        int i4 = this.count;
        cArr[i4] = c;
        int i5 = i4 + 2;
        int i6 = i5 + length2;
        cArr[i4 + 1] = '\"';
        str.getChars(0, length2, cArr, i5);
        this.count = i3;
        char[] cArr2 = this.buf;
        cArr2[i6] = '\"';
        int i7 = i6 + 1;
        int i8 = i7 + 1;
        cArr2[i7] = ':';
        if (str2 != null) {
            cArr2[i8] = '\"';
            str2.getChars(0, length, cArr2, i8 + 1);
            this.buf[this.count - 1] = '\"';
            return;
        }
        int i9 = i8 + 1;
        cArr2[i8] = 'n';
        int i10 = i9 + 1;
        cArr2[i9] = 'u';
        cArr2[i10] = 'l';
        cArr2[i10 + 1] = 'l';
    }

    public void writeFieldValueStringWithDoubleQuoteCheck(char c, String str, String str2) {
        int length;
        int i;
        int i2;
        char c2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int length2 = str.length();
        int i10 = this.count;
        if (str2 == null) {
            i = i10 + length2 + 8;
            length = 4;
        } else {
            length = str2.length();
            i = i10 + length2 + length + 6;
        }
        int i11 = 0;
        if (i > this.buf.length) {
            if (this.writer != null) {
                write(c);
                writeStringWithDoubleQuote(str, ':');
                writeStringWithDoubleQuote(str2, (char) 0);
                return;
            }
            expandCapacity(i);
        }
        char[] cArr = this.buf;
        int i12 = this.count;
        cArr[i12] = c;
        int i13 = i12 + 2;
        int i14 = i13 + length2;
        cArr[i12 + 1] = '\"';
        str.getChars(0, length2, cArr, i13);
        this.count = i;
        char[] cArr2 = this.buf;
        cArr2[i14] = '\"';
        int i15 = i14 + 1;
        int i16 = i15 + 1;
        cArr2[i15] = ':';
        if (str2 == null) {
            int i17 = i16 + 1;
            cArr2[i16] = 'n';
            int i18 = i17 + 1;
            cArr2[i17] = 'u';
            cArr2[i18] = 'l';
            cArr2[i18 + 1] = 'l';
            return;
        }
        int i19 = i16 + 1;
        cArr2[i16] = '\"';
        int i20 = i19 + length;
        str2.getChars(0, length, cArr2, i19);
        if (!this.disableCheckSpecialChar) {
            int i21 = i19;
            char c3 = 0;
            int i22 = -1;
            int i23 = -1;
            int i24 = i;
            while (i21 < i20) {
                char c4 = this.buf[i21];
                if (c4 >= ']') {
                    i2 = i24;
                    c2 = c3;
                    i3 = i11;
                    i4 = i22;
                    i5 = i23;
                    if (c4 >= 127) {
                        if (c4 != 8232) {
                            i2 = i24;
                            c2 = c3;
                            i3 = i11;
                            i4 = i22;
                            i5 = i23;
                            if (c4 > 160) {
                            }
                        }
                        int i25 = i22;
                        if (i22 == -1) {
                            i25 = i21;
                        }
                        i7 = i11 + 1;
                        i6 = i24 + 4;
                        i8 = i25;
                        i9 = i7;
                        i2 = i6;
                    }
                    i21++;
                    i24 = i2;
                    c3 = c2;
                    i11 = i3;
                    i22 = i4;
                    i23 = i5;
                } else {
                    i2 = i24;
                    c2 = c3;
                    i3 = i11;
                    i4 = i22;
                    i5 = i23;
                    if (isSpecial(c4, this.features)) {
                        int i26 = i11 + 1;
                        i2 = i24;
                        if (c4 < IOUtils.specicalFlags_doubleQuotes.length) {
                            i2 = i24;
                            if (IOUtils.specicalFlags_doubleQuotes[c4] == 4) {
                                i2 = i24 + 4;
                            }
                        }
                        i6 = i2;
                        i7 = i26;
                        i8 = i22;
                        if (i22 == -1) {
                            i8 = i21;
                            i9 = i26;
                        }
                        i9 = i7;
                        i2 = i6;
                    } else {
                        i21++;
                        i24 = i2;
                        c3 = c2;
                        i11 = i3;
                        i22 = i4;
                        i23 = i5;
                    }
                }
                i5 = i21;
                c2 = c4;
                i4 = i8;
                i3 = i9;
                i21++;
                i24 = i2;
                c3 = c2;
                i11 = i3;
                i22 = i4;
                i23 = i5;
            }
            if (i11 > 0) {
                int i27 = i24 + i11;
                if (i27 > this.buf.length) {
                    expandCapacity(i27);
                }
                this.count = i27;
                if (i11 == 1) {
                    if (c3 == 8232) {
                        int i28 = i23 + 1;
                        char[] cArr3 = this.buf;
                        System.arraycopy((Object) cArr3, i28, (Object) cArr3, i23 + 6, (i20 - i23) - 1);
                        char[] cArr4 = this.buf;
                        cArr4[i23] = '\\';
                        cArr4[i28] = 'u';
                        int i29 = i28 + 1;
                        cArr4[i29] = '2';
                        int i30 = i29 + 1;
                        cArr4[i30] = '0';
                        int i31 = i30 + 1;
                        cArr4[i31] = '2';
                        cArr4[i31 + 1] = '8';
                    } else if (c3 >= IOUtils.specicalFlags_doubleQuotes.length || IOUtils.specicalFlags_doubleQuotes[c3] != 4) {
                        int i32 = i23 + 1;
                        char[] cArr5 = this.buf;
                        System.arraycopy((Object) cArr5, i32, (Object) cArr5, i23 + 2, (i20 - i23) - 1);
                        char[] cArr6 = this.buf;
                        cArr6[i23] = '\\';
                        cArr6[i32] = IOUtils.replaceChars[c3];
                    } else {
                        int i33 = i23 + 1;
                        char[] cArr7 = this.buf;
                        System.arraycopy((Object) cArr7, i33, (Object) cArr7, i23 + 6, (i20 - i23) - 1);
                        char[] cArr8 = this.buf;
                        cArr8[i23] = '\\';
                        int i34 = i33 + 1;
                        cArr8[i33] = 'u';
                        int i35 = i34 + 1;
                        cArr8[i34] = IOUtils.DIGITS[(c3 >>> '\f') & 15];
                        int i36 = i35 + 1;
                        this.buf[i35] = IOUtils.DIGITS[(c3 >>> '\b') & 15];
                        this.buf[i36] = IOUtils.DIGITS[(c3 >>> 4) & 15];
                        this.buf[i36 + 1] = IOUtils.DIGITS[c3 & 15];
                    }
                } else if (i11 > 1) {
                    int i37 = i22;
                    int i38 = i22 - i19;
                    while (true) {
                        int i39 = i38;
                        if (i39 >= str2.length()) {
                            break;
                        }
                        char charAt = str2.charAt(i39);
                        if ((charAt < IOUtils.specicalFlags_doubleQuotes.length && IOUtils.specicalFlags_doubleQuotes[charAt] != 0) || (charAt == '/' && isEnabled(SerializerFeature.WriteSlashAsSpecial))) {
                            int i40 = i37 + 1;
                            this.buf[i37] = '\\';
                            if (IOUtils.specicalFlags_doubleQuotes[charAt] == 4) {
                                char[] cArr9 = this.buf;
                                int i41 = i40 + 1;
                                cArr9[i40] = 'u';
                                int i42 = i41 + 1;
                                cArr9[i41] = IOUtils.DIGITS[(charAt >>> '\f') & 15];
                                int i43 = i42 + 1;
                                this.buf[i42] = IOUtils.DIGITS[(charAt >>> '\b') & 15];
                                int i44 = i43 + 1;
                                this.buf[i43] = IOUtils.DIGITS[(charAt >>> 4) & 15];
                                i37 = i44 + 1;
                                this.buf[i44] = IOUtils.DIGITS[charAt & 15];
                            } else {
                                i37 = i40 + 1;
                                this.buf[i40] = IOUtils.replaceChars[charAt];
                            }
                        } else if (charAt == 8232) {
                            char[] cArr10 = this.buf;
                            int i45 = i37 + 1;
                            cArr10[i37] = '\\';
                            int i46 = i45 + 1;
                            cArr10[i45] = 'u';
                            int i47 = i46 + 1;
                            cArr10[i46] = IOUtils.DIGITS[(charAt >>> '\f') & 15];
                            int i48 = i47 + 1;
                            this.buf[i47] = IOUtils.DIGITS[(charAt >>> '\b') & 15];
                            int i49 = i48 + 1;
                            this.buf[i48] = IOUtils.DIGITS[(charAt >>> 4) & 15];
                            this.buf[i49] = IOUtils.DIGITS[charAt & 15];
                            i37 = i49 + 1;
                        } else {
                            this.buf[i37] = charAt;
                            i37++;
                        }
                        i38 = i39 + 1;
                    }
                }
            }
        }
        this.buf[this.count - 1] = '\"';
    }

    public void writeFloatAndChar(float f, char c) {
        String f2 = Float.toString(f);
        String str = f2;
        if (f2.endsWith(".0")) {
            str = f2.substring(0, f2.length() - 2);
        }
        write(str);
        write(c);
    }

    public void writeInt(int i) {
        if (i == Integer.MIN_VALUE) {
            write("-2147483648");
            return;
        }
        int stringSize = i < 0 ? IOUtils.stringSize(-i) + 1 : IOUtils.stringSize(i);
        int i2 = this.count + stringSize;
        if (i2 > this.buf.length) {
            if (this.writer != null) {
                char[] cArr = new char[stringSize];
                IOUtils.getChars(i, stringSize, cArr);
                write(cArr, 0, stringSize);
                return;
            }
            expandCapacity(i2);
        }
        IOUtils.getChars(i, i2, this.buf);
        this.count = i2;
    }

    public void writeIntAndChar(int i, char c) {
        if (i == Integer.MIN_VALUE) {
            write("-2147483648");
            write(c);
            return;
        }
        int stringSize = this.count + (i < 0 ? IOUtils.stringSize(-i) + 1 : IOUtils.stringSize(i));
        int i2 = stringSize + 1;
        if (i2 > this.buf.length) {
            if (this.writer != null) {
                writeInt(i);
                write(c);
                return;
            }
            expandCapacity(i2);
        }
        IOUtils.getChars(i, stringSize, this.buf);
        this.buf[stringSize] = c;
        this.count = i2;
    }

    public void writeLong(long j) {
        boolean z = this.browserCompatible && !isEnabled(SerializerFeature.WriteClassName) && (j > 9007199254740991L || j < -9007199254740991L);
        if (j == Long.MIN_VALUE) {
            if (z) {
                write("\"-9223372036854775808\"");
                return;
            } else {
                write("-9223372036854775808");
                return;
            }
        }
        int stringSize = j < 0 ? IOUtils.stringSize(-j) + 1 : IOUtils.stringSize(j);
        int i = this.count + stringSize;
        int i2 = i;
        if (z) {
            i2 = i + 2;
        }
        if (i2 > this.buf.length) {
            if (this.writer != null) {
                char[] cArr = new char[stringSize];
                IOUtils.getChars(j, stringSize, cArr);
                if (!z) {
                    write(cArr, 0, stringSize);
                    return;
                }
                write(34);
                write(cArr, 0, stringSize);
                write(34);
                return;
            }
            expandCapacity(i2);
        }
        if (z) {
            char[] cArr2 = this.buf;
            cArr2[this.count] = '\"';
            int i3 = i2 - 1;
            IOUtils.getChars(j, i3, cArr2);
            this.buf[i3] = '\"';
        } else {
            IOUtils.getChars(j, i2, this.buf);
        }
        this.count = i2;
    }

    public void writeLongAndChar(long j, char c) throws IOException {
        boolean z = this.browserCompatible && !isEnabled(SerializerFeature.WriteClassName) && (j > 9007199254740991L || j < -9007199254740991L);
        if (j == Long.MIN_VALUE) {
            if (z) {
                write("\"-9223372036854775808\"");
            } else {
                write("-9223372036854775808");
            }
            write(c);
            return;
        }
        int stringSize = this.count + (j < 0 ? IOUtils.stringSize(-j) + 1 : IOUtils.stringSize(j));
        int i = stringSize;
        if (z) {
            i = stringSize + 2;
        }
        int i2 = i + 1;
        if (i2 > this.buf.length) {
            if (this.writer != null) {
                writeLong(j);
                write(c);
                return;
            }
            expandCapacity(i2);
        }
        if (z) {
            char[] cArr = this.buf;
            cArr[this.count] = '\"';
            int i3 = i - 1;
            IOUtils.getChars(j, i3, cArr);
            this.buf[i3] = '\"';
        } else {
            IOUtils.getChars(j, i, this.buf);
        }
        this.buf[i] = c;
        this.count = i2;
    }

    public void writeNull() {
        write("null");
    }

    public void writeString(String str) {
        if (this.useSingleQuotes) {
            writeStringWithSingleQuote(str);
        } else {
            writeStringWithDoubleQuote(str, (char) 0);
        }
    }

    public void writeString(String str, char c) {
        if (!this.useSingleQuotes) {
            writeStringWithDoubleQuote(str, c);
            return;
        }
        writeStringWithSingleQuote(str);
        write(c);
    }

    public void writeStringWithDoubleQuote(String str, char c) {
        int i;
        char c2;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        if (str == null) {
            writeNull();
            if (c != 0) {
                write(c);
                return;
            }
            return;
        }
        int length = str.length();
        int i17 = this.count + length + 2;
        int i18 = i17;
        if (c != 0) {
            i18 = i17 + 1;
        }
        if (i18 > this.buf.length) {
            if (this.writer != null) {
                write(34);
                int i19 = 0;
                while (true) {
                    int i20 = i19;
                    if (i20 >= str.length()) {
                        break;
                    }
                    char charAt = str.charAt(i20);
                    if (this.browserSecure) {
                        if ((charAt < '0' || charAt > '9') && ((charAt < 'a' || charAt > 'z') && ((charAt < 'A' || charAt > 'Z') && charAt != ',' && charAt != '.' && charAt != '_'))) {
                            write(92);
                            write(117);
                            write(IOUtils.DIGITS[(charAt >>> '\f') & 15]);
                            write(IOUtils.DIGITS[(charAt >>> '\b') & 15]);
                            write(IOUtils.DIGITS[(charAt >>> 4) & 15]);
                            write(IOUtils.DIGITS[charAt & 15]);
                            i19 = i20 + 1;
                        }
                        write(charAt);
                        i19 = i20 + 1;
                    } else if (this.browserCompatible) {
                        if (charAt == '\b' || charAt == '\f' || charAt == '\n' || charAt == '\r' || charAt == '\t' || charAt == '\"' || charAt == '/' || charAt == '\\') {
                            write(92);
                            write(IOUtils.replaceChars[charAt]);
                        } else if (charAt < ' ') {
                            write(92);
                            write(117);
                            write(48);
                            write(48);
                            int i21 = charAt * 2;
                            write(IOUtils.ASCII_CHARS[i21]);
                            write(IOUtils.ASCII_CHARS[i21 + 1]);
                        } else {
                            if (charAt >= 127) {
                                write(92);
                                write(117);
                                write(IOUtils.DIGITS[(charAt >>> '\f') & 15]);
                                write(IOUtils.DIGITS[(charAt >>> '\b') & 15]);
                                write(IOUtils.DIGITS[(charAt >>> 4) & 15]);
                                write(IOUtils.DIGITS[charAt & 15]);
                            }
                            write(charAt);
                        }
                        i19 = i20 + 1;
                    } else {
                        if ((charAt < IOUtils.specicalFlags_doubleQuotes.length && IOUtils.specicalFlags_doubleQuotes[charAt] != 0) || (charAt == '/' && isEnabled(SerializerFeature.WriteSlashAsSpecial))) {
                            write(92);
                            if (IOUtils.specicalFlags_doubleQuotes[charAt] == 4) {
                                write(117);
                                write(IOUtils.DIGITS[(charAt >>> '\f') & 15]);
                                write(IOUtils.DIGITS[(charAt >>> '\b') & 15]);
                                write(IOUtils.DIGITS[(charAt >>> 4) & 15]);
                                write(IOUtils.DIGITS[charAt & 15]);
                            } else {
                                write(IOUtils.replaceChars[charAt]);
                            }
                            i19 = i20 + 1;
                        }
                        write(charAt);
                        i19 = i20 + 1;
                    }
                }
                write(34);
                if (c != 0) {
                    write(c);
                    return;
                }
                return;
            }
            expandCapacity(i18);
        }
        int i22 = this.count;
        int i23 = i22 + 1;
        int i24 = i23 + length;
        char[] cArr = this.buf;
        cArr[i22] = '\"';
        int i25 = 0;
        str.getChars(0, length, cArr, i23);
        this.count = i18;
        int i26 = -1;
        if (this.browserSecure) {
            int i27 = i23;
            int i28 = i18;
            while (i27 < i24) {
                char c3 = this.buf[i27];
                if (c3 >= '0') {
                    i15 = i28;
                    i16 = i26;
                    if (c3 <= '9') {
                        i27++;
                        i28 = i15;
                        i26 = i16;
                    }
                }
                if (c3 >= 'a') {
                    i15 = i28;
                    i16 = i26;
                    if (c3 <= 'z') {
                        i27++;
                        i28 = i15;
                        i26 = i16;
                    }
                }
                if (c3 >= 'A') {
                    i15 = i28;
                    i16 = i26;
                    if (c3 <= 'Z') {
                        i27++;
                        i28 = i15;
                        i26 = i16;
                    }
                }
                i15 = i28;
                i16 = i26;
                if (c3 != ',') {
                    i15 = i28;
                    i16 = i26;
                    if (c3 != '.') {
                        i15 = i28;
                        i16 = i26;
                        if (c3 != '_') {
                            i15 = i28 + 5;
                            i16 = i27;
                        }
                    }
                }
                i27++;
                i28 = i15;
                i26 = i16;
            }
            if (i28 > this.buf.length) {
                expandCapacity(i28);
            }
            this.count = i28;
            while (i26 >= i23) {
                char c4 = this.buf[i26];
                if (c4 >= '0') {
                    i14 = i24;
                    if (c4 <= '9') {
                        i26--;
                        i24 = i14;
                    }
                }
                if (c4 >= 'a') {
                    i14 = i24;
                    if (c4 <= 'z') {
                        i26--;
                        i24 = i14;
                    }
                }
                if (c4 >= 'A') {
                    i14 = i24;
                    if (c4 <= 'Z') {
                        i26--;
                        i24 = i14;
                    }
                }
                i14 = i24;
                if (c4 != ',') {
                    i14 = i24;
                    if (c4 != '.') {
                        i14 = i24;
                        if (c4 != '_') {
                            char[] cArr2 = this.buf;
                            int i29 = i26 + 1;
                            System.arraycopy((Object) cArr2, i29, (Object) cArr2, i26 + 6, (i24 - i26) - 1);
                            char[] cArr3 = this.buf;
                            cArr3[i26] = '\\';
                            cArr3[i29] = 'u';
                            cArr3[i26 + 2] = IOUtils.DIGITS[(c4 >>> '\f') & 15];
                            this.buf[i26 + 3] = IOUtils.DIGITS[(c4 >>> '\b') & 15];
                            this.buf[i26 + 4] = IOUtils.DIGITS[(c4 >>> 4) & 15];
                            this.buf[i26 + 5] = IOUtils.DIGITS[c4 & 15];
                            i14 = i24 + 5;
                        }
                    }
                }
                i26--;
                i24 = i14;
            }
            if (c == 0) {
                this.buf[this.count - 1] = '\"';
                return;
            }
            char[] cArr4 = this.buf;
            int i30 = this.count;
            cArr4[i30 - 2] = '\"';
            cArr4[i30 - 1] = c;
        } else if (this.browserCompatible) {
            int i31 = -1;
            int i32 = i23;
            while (i32 < i24) {
                char c5 = this.buf[i32];
                if (c5 == '\"' || c5 == '/' || c5 == '\\' || c5 == '\b' || c5 == '\f' || c5 == '\n' || c5 == '\r' || c5 == '\t') {
                    i11 = i18 + 1;
                } else {
                    if (c5 >= ' ') {
                        i13 = i18;
                        i12 = i31;
                        if (c5 < 127) {
                            i32++;
                            i18 = i13;
                            i31 = i12;
                        }
                    }
                    i11 = i18 + 5;
                }
                i12 = i32;
                i13 = i11;
                i32++;
                i18 = i13;
                i31 = i12;
            }
            if (i18 > this.buf.length) {
                expandCapacity(i18);
            }
            this.count = i18;
            while (i31 >= i23) {
                char[] cArr5 = this.buf;
                char c6 = cArr5[i31];
                if (c6 == '\b' || c6 == '\f' || c6 == '\n' || c6 == '\r' || c6 == '\t') {
                    char[] cArr6 = this.buf;
                    int i33 = i31 + 1;
                    System.arraycopy((Object) cArr6, i33, (Object) cArr6, i31 + 2, (i24 - i31) - 1);
                    char[] cArr7 = this.buf;
                    cArr7[i31] = '\\';
                    cArr7[i33] = IOUtils.replaceChars[c6];
                } else if (c6 == '\"' || c6 == '/' || c6 == '\\') {
                    char[] cArr8 = this.buf;
                    int i34 = i31 + 1;
                    System.arraycopy((Object) cArr8, i34, (Object) cArr8, i31 + 2, (i24 - i31) - 1);
                    char[] cArr9 = this.buf;
                    cArr9[i31] = '\\';
                    cArr9[i34] = c6;
                } else {
                    if (c6 < ' ') {
                        int i35 = i31 + 1;
                        System.arraycopy((Object) cArr5, i35, (Object) cArr5, i31 + 6, (i24 - i31) - 1);
                        char[] cArr10 = this.buf;
                        cArr10[i31] = '\\';
                        cArr10[i35] = 'u';
                        cArr10[i31 + 2] = '0';
                        cArr10[i31 + 3] = '0';
                        int i36 = c6 * 2;
                        cArr10[i31 + 4] = IOUtils.ASCII_CHARS[i36];
                        this.buf[i31 + 5] = IOUtils.ASCII_CHARS[i36 + 1];
                    } else {
                        i10 = i24;
                        if (c6 >= 127) {
                            int i37 = i31 + 1;
                            System.arraycopy((Object) cArr5, i37, (Object) cArr5, i31 + 6, (i24 - i31) - 1);
                            char[] cArr11 = this.buf;
                            cArr11[i31] = '\\';
                            cArr11[i37] = 'u';
                            cArr11[i31 + 2] = IOUtils.DIGITS[(c6 >>> '\f') & 15];
                            this.buf[i31 + 3] = IOUtils.DIGITS[(c6 >>> '\b') & 15];
                            this.buf[i31 + 4] = IOUtils.DIGITS[(c6 >>> 4) & 15];
                            this.buf[i31 + 5] = IOUtils.DIGITS[c6 & 15];
                        } else {
                            i31--;
                            i24 = i10;
                        }
                    }
                    i10 = i24 + 5;
                    i31--;
                    i24 = i10;
                }
                i10 = i24 + 1;
                i31--;
                i24 = i10;
            }
            if (c == 0) {
                this.buf[this.count - 1] = '\"';
                return;
            }
            char[] cArr12 = this.buf;
            int i38 = this.count;
            cArr12[i38 - 2] = '\"';
            cArr12[i38 - 1] = c;
        } else {
            int i39 = i23;
            char c7 = 0;
            int i40 = -1;
            int i41 = -1;
            while (true) {
                i = i41;
                if (i39 >= i24) {
                    break;
                }
                char c8 = this.buf[i39];
                if (c8 == 8232) {
                    int i42 = i25 + 1;
                    int i43 = i18 + 4;
                    i6 = i43;
                    i7 = i42;
                    i8 = i40;
                    if (i40 == -1) {
                        i7 = i42;
                        i6 = i43;
                        i9 = i39;
                    }
                    i9 = i8;
                } else if (c8 >= ']') {
                    c2 = c7;
                    i2 = i18;
                    i3 = i25;
                    i4 = i40;
                    i5 = i;
                    if (c8 >= 127) {
                        c2 = c7;
                        i2 = i18;
                        i3 = i25;
                        i4 = i40;
                        i5 = i;
                        if (c8 <= 160) {
                            i8 = i40;
                            if (i40 == -1) {
                                i8 = i39;
                            }
                            i7 = i25 + 1;
                            i6 = i18 + 4;
                            i9 = i8;
                        }
                    }
                    i39++;
                    c7 = c2;
                    i18 = i2;
                    i25 = i3;
                    i40 = i4;
                    i41 = i5;
                } else {
                    c2 = c7;
                    i2 = i18;
                    i3 = i25;
                    i4 = i40;
                    i5 = i;
                    if (isSpecial(c8, this.features)) {
                        int i44 = i25 + 1;
                        int i45 = i18;
                        if (c8 < IOUtils.specicalFlags_doubleQuotes.length) {
                            i45 = i18;
                            if (IOUtils.specicalFlags_doubleQuotes[c8] == 4) {
                                i45 = i18 + 4;
                            }
                        }
                        i6 = i45;
                        i7 = i44;
                        i8 = i40;
                        if (i40 == -1) {
                            i6 = i45;
                            i7 = i44;
                            i9 = i39;
                        }
                        i9 = i8;
                    } else {
                        i39++;
                        c7 = c2;
                        i18 = i2;
                        i25 = i3;
                        i40 = i4;
                        i41 = i5;
                    }
                }
                i5 = i39;
                c2 = c8;
                i2 = i6;
                i3 = i7;
                i4 = i9;
                i39++;
                c7 = c2;
                i18 = i2;
                i25 = i3;
                i40 = i4;
                i41 = i5;
            }
            if (i25 > 0) {
                int i46 = i18 + i25;
                if (i46 > this.buf.length) {
                    expandCapacity(i46);
                }
                this.count = i46;
                if (i25 == 1) {
                    if (c7 == 8232) {
                        int i47 = i + 1;
                        char[] cArr13 = this.buf;
                        System.arraycopy((Object) cArr13, i47, (Object) cArr13, i + 6, (i24 - i) - 1);
                        char[] cArr14 = this.buf;
                        cArr14[i] = '\\';
                        cArr14[i47] = 'u';
                        int i48 = i47 + 1;
                        cArr14[i48] = '2';
                        int i49 = i48 + 1;
                        cArr14[i49] = '0';
                        int i50 = i49 + 1;
                        cArr14[i50] = '2';
                        cArr14[i50 + 1] = '8';
                    } else if (c7 >= IOUtils.specicalFlags_doubleQuotes.length || IOUtils.specicalFlags_doubleQuotes[c7] != 4) {
                        int i51 = i + 1;
                        char[] cArr15 = this.buf;
                        System.arraycopy((Object) cArr15, i51, (Object) cArr15, i + 2, (i24 - i) - 1);
                        char[] cArr16 = this.buf;
                        cArr16[i] = '\\';
                        cArr16[i51] = IOUtils.replaceChars[c7];
                    } else {
                        int i52 = i + 1;
                        char[] cArr17 = this.buf;
                        System.arraycopy((Object) cArr17, i52, (Object) cArr17, i + 6, (i24 - i) - 1);
                        char[] cArr18 = this.buf;
                        cArr18[i] = '\\';
                        int i53 = i52 + 1;
                        cArr18[i52] = 'u';
                        int i54 = i53 + 1;
                        cArr18[i53] = IOUtils.DIGITS[(c7 >>> '\f') & 15];
                        int i55 = i54 + 1;
                        this.buf[i54] = IOUtils.DIGITS[(c7 >>> '\b') & 15];
                        this.buf[i55] = IOUtils.DIGITS[(c7 >>> 4) & 15];
                        this.buf[i55 + 1] = IOUtils.DIGITS[c7 & 15];
                    }
                } else if (i25 > 1) {
                    int i56 = i40;
                    int i57 = i40 - i23;
                    while (true) {
                        int i58 = i57;
                        if (i58 >= str.length()) {
                            break;
                        }
                        char charAt2 = str.charAt(i58);
                        if ((charAt2 < IOUtils.specicalFlags_doubleQuotes.length && IOUtils.specicalFlags_doubleQuotes[charAt2] != 0) || (charAt2 == '/' && isEnabled(SerializerFeature.WriteSlashAsSpecial))) {
                            int i59 = i56 + 1;
                            this.buf[i56] = '\\';
                            if (IOUtils.specicalFlags_doubleQuotes[charAt2] == 4) {
                                char[] cArr19 = this.buf;
                                int i60 = i59 + 1;
                                cArr19[i59] = 'u';
                                int i61 = i60 + 1;
                                cArr19[i60] = IOUtils.DIGITS[(charAt2 >>> '\f') & 15];
                                int i62 = i61 + 1;
                                this.buf[i61] = IOUtils.DIGITS[(charAt2 >>> '\b') & 15];
                                int i63 = i62 + 1;
                                this.buf[i62] = IOUtils.DIGITS[(charAt2 >>> 4) & 15];
                                i56 = i63 + 1;
                                this.buf[i63] = IOUtils.DIGITS[charAt2 & 15];
                            } else {
                                i56 = i59 + 1;
                                this.buf[i59] = IOUtils.replaceChars[charAt2];
                            }
                        } else if (charAt2 == 8232) {
                            char[] cArr20 = this.buf;
                            int i64 = i56 + 1;
                            cArr20[i56] = '\\';
                            int i65 = i64 + 1;
                            cArr20[i64] = 'u';
                            int i66 = i65 + 1;
                            cArr20[i65] = IOUtils.DIGITS[(charAt2 >>> '\f') & 15];
                            int i67 = i66 + 1;
                            this.buf[i66] = IOUtils.DIGITS[(charAt2 >>> '\b') & 15];
                            int i68 = i67 + 1;
                            this.buf[i67] = IOUtils.DIGITS[(charAt2 >>> 4) & 15];
                            i56 = i68 + 1;
                            this.buf[i68] = IOUtils.DIGITS[charAt2 & 15];
                        } else {
                            this.buf[i56] = charAt2;
                            i56++;
                        }
                        i57 = i58 + 1;
                    }
                }
            }
            if (c == 0) {
                this.buf[this.count - 1] = '\"';
                return;
            }
            char[] cArr21 = this.buf;
            int i69 = this.count;
            cArr21[i69 - 2] = '\"';
            cArr21[i69 - 1] = c;
        }
    }

    public void writeStringWithDoubleQuoteDirect(String str, char c) {
        int i;
        int i2;
        int i3;
        int i4;
        char c2;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        if (str == null) {
            writeNull();
            if (c != 0) {
                write(c);
                return;
            }
            return;
        }
        int length = str.length();
        int i10 = this.count + length + 2;
        int i11 = i10;
        if (c != 0) {
            i11 = i10 + 1;
        }
        if (i11 > this.buf.length) {
            if (this.writer != null) {
                write(34);
                for (int i12 = 0; i12 < str.length(); i12++) {
                    char charAt = str.charAt(i12);
                    if (charAt >= IOUtils.specicalFlags_doubleQuotes.length || IOUtils.specicalFlags_doubleQuotes[charAt] == 0) {
                        write(charAt);
                    } else {
                        write(92);
                        if (IOUtils.specicalFlags_doubleQuotes[charAt] == 4) {
                            write(117);
                            write(IOUtils.DIGITS[(charAt >>> '\f') & 15]);
                            write(IOUtils.DIGITS[(charAt >>> '\b') & 15]);
                            write(IOUtils.DIGITS[(charAt >>> 4) & 15]);
                            write(IOUtils.DIGITS[charAt & 15]);
                        } else {
                            write(IOUtils.replaceChars[charAt]);
                        }
                    }
                }
                write(34);
                if (c != 0) {
                    write(c);
                    return;
                }
                return;
            }
            expandCapacity(i11);
        }
        int i13 = this.count;
        int i14 = i13 + 1;
        int i15 = i14 + length;
        char[] cArr = this.buf;
        cArr[i13] = '\"';
        str.getChars(0, length, cArr, i14);
        this.count = i11;
        int i16 = i14;
        int i17 = 0;
        int i18 = -1;
        char c3 = 0;
        int i19 = -1;
        while (true) {
            i = i19;
            if (i16 >= i15) {
                break;
            }
            char c4 = this.buf[i16];
            if (c4 >= ']') {
                if (c4 == 8232) {
                    int i20 = i17 + 1;
                    int i21 = i11 + 4;
                    i6 = i21;
                    i7 = i20;
                    i8 = i18;
                    if (i18 == -1) {
                        i7 = i20;
                        i6 = i21;
                        i9 = i16;
                    }
                } else {
                    i2 = i11;
                    i3 = i17;
                    i4 = i18;
                    c2 = c3;
                    i5 = i;
                    if (c4 >= 127) {
                        i2 = i11;
                        i3 = i17;
                        i4 = i18;
                        c2 = c3;
                        i5 = i;
                        if (c4 <= 160) {
                            i8 = i18;
                            if (i18 == -1) {
                                i8 = i16;
                            }
                            i7 = i17 + 1;
                            i6 = i11 + 4;
                        }
                    }
                    i16++;
                    i11 = i2;
                    i17 = i3;
                    i18 = i4;
                    c3 = c2;
                    i19 = i5;
                }
                i9 = i8;
            } else {
                i2 = i11;
                i3 = i17;
                i4 = i18;
                c2 = c3;
                i5 = i;
                if (c4 <= 31 || c4 == '\\' || c4 == '\"') {
                    int i22 = i17 + 1;
                    int i23 = i11;
                    if (c4 < IOUtils.specicalFlags_doubleQuotes.length) {
                        i23 = i11;
                        if (IOUtils.specicalFlags_doubleQuotes[c4] == 4) {
                            i23 = i11 + 4;
                        }
                    }
                    i6 = i23;
                    i7 = i22;
                    i8 = i18;
                    if (i18 == -1) {
                        i6 = i23;
                        i7 = i22;
                        i9 = i16;
                    }
                    i9 = i8;
                } else {
                    i16++;
                    i11 = i2;
                    i17 = i3;
                    i18 = i4;
                    c3 = c2;
                    i19 = i5;
                }
            }
            i5 = i16;
            c2 = c4;
            i2 = i6;
            i3 = i7;
            i4 = i9;
            i16++;
            i11 = i2;
            i17 = i3;
            i18 = i4;
            c3 = c2;
            i19 = i5;
        }
        if (i17 > 0) {
            int i24 = i11 + i17;
            if (i24 > this.buf.length) {
                expandCapacity(i24);
            }
            this.count = i24;
            if (i17 == 1) {
                if (c3 == 8232) {
                    int i25 = i + 1;
                    char[] cArr2 = this.buf;
                    System.arraycopy((Object) cArr2, i25, (Object) cArr2, i + 6, (i15 - i) - 1);
                    char[] cArr3 = this.buf;
                    cArr3[i] = '\\';
                    cArr3[i25] = 'u';
                    int i26 = i25 + 1;
                    cArr3[i26] = '2';
                    int i27 = i26 + 1;
                    cArr3[i27] = '0';
                    int i28 = i27 + 1;
                    cArr3[i28] = '2';
                    cArr3[i28 + 1] = '8';
                } else if (c3 >= IOUtils.specicalFlags_doubleQuotes.length || IOUtils.specicalFlags_doubleQuotes[c3] != 4) {
                    int i29 = i + 1;
                    char[] cArr4 = this.buf;
                    System.arraycopy((Object) cArr4, i29, (Object) cArr4, i + 2, (i15 - i) - 1);
                    char[] cArr5 = this.buf;
                    cArr5[i] = '\\';
                    cArr5[i29] = IOUtils.replaceChars[c3];
                } else {
                    int i30 = i + 1;
                    char[] cArr6 = this.buf;
                    System.arraycopy((Object) cArr6, i30, (Object) cArr6, i + 6, (i15 - i) - 1);
                    char[] cArr7 = this.buf;
                    cArr7[i] = '\\';
                    int i31 = i30 + 1;
                    cArr7[i30] = 'u';
                    int i32 = i31 + 1;
                    cArr7[i31] = IOUtils.DIGITS[(c3 >>> '\f') & 15];
                    int i33 = i32 + 1;
                    this.buf[i32] = IOUtils.DIGITS[(c3 >>> '\b') & 15];
                    this.buf[i33] = IOUtils.DIGITS[(c3 >>> 4) & 15];
                    this.buf[i33 + 1] = IOUtils.DIGITS[c3 & 15];
                }
            } else if (i17 > 1) {
                int i34 = i18;
                int i35 = i18 - i14;
                while (true) {
                    int i36 = i35;
                    if (i36 >= str.length()) {
                        break;
                    }
                    char charAt2 = str.charAt(i36);
                    if ((charAt2 < IOUtils.specicalFlags_doubleQuotes.length && IOUtils.specicalFlags_doubleQuotes[charAt2] != 0) || (charAt2 == '/' && isEnabled(SerializerFeature.WriteSlashAsSpecial))) {
                        int i37 = i34 + 1;
                        this.buf[i34] = '\\';
                        if (IOUtils.specicalFlags_doubleQuotes[charAt2] == 4) {
                            char[] cArr8 = this.buf;
                            int i38 = i37 + 1;
                            cArr8[i37] = 'u';
                            int i39 = i38 + 1;
                            cArr8[i38] = IOUtils.DIGITS[(charAt2 >>> '\f') & 15];
                            int i40 = i39 + 1;
                            this.buf[i39] = IOUtils.DIGITS[(charAt2 >>> '\b') & 15];
                            int i41 = i40 + 1;
                            this.buf[i40] = IOUtils.DIGITS[(charAt2 >>> 4) & 15];
                            i34 = i41 + 1;
                            this.buf[i41] = IOUtils.DIGITS[charAt2 & 15];
                        } else {
                            i34 = i37 + 1;
                            this.buf[i37] = IOUtils.replaceChars[charAt2];
                        }
                    } else if (charAt2 == 8232) {
                        char[] cArr9 = this.buf;
                        int i42 = i34 + 1;
                        cArr9[i34] = '\\';
                        int i43 = i42 + 1;
                        cArr9[i42] = 'u';
                        int i44 = i43 + 1;
                        cArr9[i43] = IOUtils.DIGITS[(charAt2 >>> '\f') & 15];
                        int i45 = i44 + 1;
                        this.buf[i44] = IOUtils.DIGITS[(charAt2 >>> '\b') & 15];
                        int i46 = i45 + 1;
                        this.buf[i45] = IOUtils.DIGITS[(charAt2 >>> 4) & 15];
                        this.buf[i46] = IOUtils.DIGITS[charAt2 & 15];
                        i34 = i46 + 1;
                    } else {
                        this.buf[i34] = charAt2;
                        i34++;
                    }
                    i35 = i36 + 1;
                }
            }
        }
        if (c == 0) {
            this.buf[this.count - 1] = '\"';
            return;
        }
        char[] cArr10 = this.buf;
        int i47 = this.count;
        cArr10[i47 - 2] = '\"';
        cArr10[i47 - 1] = c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void writeStringWithSingleQuote(String str) {
        int i;
        int i2;
        int i3;
        char c;
        int i4 = 0;
        if (str == null) {
            int i5 = this.count + 4;
            if (i5 > this.buf.length) {
                expandCapacity(i5);
            }
            "null".getChars(0, 4, this.buf, this.count);
            this.count = i5;
            return;
        }
        int length = str.length();
        int i6 = this.count + length + 2;
        if (i6 > this.buf.length) {
            if (this.writer != null) {
                write(39);
                for (int i7 = 0; i7 < str.length(); i7++) {
                    char charAt = str.charAt(i7);
                    if (charAt <= '\r' || charAt == '\\' || charAt == '\'' || (charAt == '/' && isEnabled(SerializerFeature.WriteSlashAsSpecial))) {
                        write(92);
                        write(IOUtils.replaceChars[charAt]);
                    } else {
                        write(charAt);
                    }
                }
                write(39);
                return;
            }
            expandCapacity(i6);
        }
        int i8 = this.count;
        int i9 = i8 + 1;
        int i10 = i9 + length;
        char[] cArr = this.buf;
        cArr[i8] = '\'';
        str.getChars(0, length, cArr, i9);
        this.count = i6;
        int i11 = -1;
        int i12 = i9;
        char c2 = 0;
        while (i12 < i10) {
            char c3 = this.buf[i12];
            if (c3 > '\r' && c3 != '\\' && c3 != '\'') {
                i2 = i4;
                c = c2;
                i3 = i11;
                if (c3 == '/') {
                    i2 = i4;
                    c = c2;
                    i3 = i11;
                    if (!isEnabled(SerializerFeature.WriteSlashAsSpecial)) {
                    }
                }
                i12++;
                i4 = i2;
                c2 = c;
                i11 = i3;
            }
            i2 = i4 + 1;
            i3 = i12;
            c = c3;
            i12++;
            i4 = i2;
            c2 = c;
            i11 = i3;
        }
        int i13 = i6 + i4;
        if (i13 > this.buf.length) {
            expandCapacity(i13);
        }
        this.count = i13;
        if (i4 == 1) {
            char[] cArr2 = this.buf;
            int i14 = i11 + 1;
            System.arraycopy((Object) cArr2, i14, (Object) cArr2, i11 + 2, (i10 - i11) - 1);
            char[] cArr3 = this.buf;
            cArr3[i11] = '\\';
            cArr3[i14] = IOUtils.replaceChars[c2];
        } else if (i4 > 1) {
            char[] cArr4 = this.buf;
            int i15 = i11 + 1;
            System.arraycopy((Object) cArr4, i15, (Object) cArr4, i11 + 2, (i10 - i11) - 1);
            char[] cArr5 = this.buf;
            cArr5[i11] = '\\';
            cArr5[i15] = IOUtils.replaceChars[c2];
            int i16 = i10 + 1;
            int i17 = i15 - 2;
            while (i17 >= i9) {
                char c4 = this.buf[i17];
                if (c4 > '\r' && c4 != '\\' && c4 != '\'') {
                    i = i16;
                    if (c4 == '/') {
                        i = i16;
                        if (!isEnabled(SerializerFeature.WriteSlashAsSpecial)) {
                        }
                    }
                    i17--;
                    i16 = i;
                }
                char[] cArr6 = this.buf;
                int i18 = i17 + 1;
                System.arraycopy((Object) cArr6, i18, (Object) cArr6, i17 + 2, (i16 - i17) - 1);
                char[] cArr7 = this.buf;
                cArr7[i17] = '\\';
                cArr7[i18] = IOUtils.replaceChars[c4];
                i = i16 + 1;
                i17--;
                i16 = i;
            }
        }
        this.buf[this.count - 1] = '\'';
    }

    public void writeTo(OutputStream outputStream, String str) throws IOException {
        writeTo(outputStream, Charset.forName(str));
    }

    public void writeTo(OutputStream outputStream, Charset charset) throws IOException {
        if (this.writer != null) {
            throw new UnsupportedOperationException("writer not null");
        }
        outputStream.write(new String(this.buf, 0, this.count).getBytes(charset));
    }

    public void writeTo(Writer writer) throws IOException {
        if (this.writer != null) {
            throw new UnsupportedOperationException("writer not null");
        }
        writer.write(this.buf, 0, this.count);
    }
}
