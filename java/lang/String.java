package java.lang;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.Charsets;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Formatter;
import java.util.Locale;
import java.util.regex.Pattern;
import java.util.regex.Splitter;
import libcore.util.EmptyArray;
import org.apache.commons.codec.CharEncoding;

/* loaded from: source-2895416-dex2jar.jar:java/lang/String.class */
public final class String implements Serializable, Comparable<String>, CharSequence {
    private static final char REPLACEMENT_CHAR = 65533;
    private static final long serialVersionUID = -6849794470754667710L;
    private final int count;
    private int hashCode;
    private final int offset;
    private final char[] value;
    public static final Comparator<String> CASE_INSENSITIVE_ORDER = new CaseInsensitiveComparator();
    private static final char[] ASCII = new char[128];

    /* loaded from: source-2895416-dex2jar.jar:java/lang/String$CaseInsensitiveComparator.class */
    private static final class CaseInsensitiveComparator implements Comparator<String>, Serializable {
        private static final long serialVersionUID = 8575799808933029326L;

        private CaseInsensitiveComparator() {
        }

        @Override // java.util.Comparator
        public int compare(String str, String str2) {
            return str.compareToIgnoreCase(str2);
        }
    }

    static {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= ASCII.length) {
                return;
            }
            ASCII[i2] = (char) i2;
            i = i2 + 1;
        }
    }

    public String() {
        this.value = EmptyArray.CHAR;
        this.offset = 0;
        this.count = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String(int i, int i2, char[] cArr) {
        this.value = cArr;
        this.offset = i;
        this.count = i2;
    }

    public String(String str) {
        this.value = str.value.length == str.count ? str.value : Arrays.copyOfRange(str.value, str.offset, str.offset + str.length());
        this.offset = 0;
        this.count = this.value.length;
    }

    public String(StringBuffer stringBuffer) {
        this.offset = 0;
        synchronized (stringBuffer) {
            this.value = stringBuffer.shareValue();
            this.count = stringBuffer.length();
        }
    }

    public String(StringBuilder sb) {
        if (sb == null) {
            throw new NullPointerException("stringBuilder == null");
        }
        this.offset = 0;
        this.count = sb.length();
        this.value = new char[this.count];
        sb.getChars(0, this.count, this.value, 0);
    }

    @FindBugsSuppressWarnings({"DM_DEFAULT_ENCODING"})
    public String(byte[] bArr) {
        this(bArr, 0, bArr.length);
    }

    @Deprecated
    public String(byte[] bArr, int i) {
        this(bArr, i, 0, bArr.length);
    }

    public String(byte[] bArr, int i, int i2) {
        this(bArr, i, i2, Charset.defaultCharset());
    }

    @Deprecated
    public String(byte[] bArr, int i, int i2, int i3) {
        if ((i2 | i3) < 0 || i3 > bArr.length - i2) {
            throw failedBoundsCheck(bArr.length, i2, i3);
        }
        this.offset = 0;
        this.value = new char[i3];
        this.count = i3;
        int i4 = 0;
        while (i4 < this.count) {
            this.value[i4] = (char) ((bArr[i2] & 255) + (i << 8));
            i4++;
            i2++;
        }
    }

    public String(byte[] bArr, int i, int i2, String str) throws UnsupportedEncodingException {
        this(bArr, i, i2, Charset.forNameUEE(str));
    }

    public String(byte[] bArr, int i, int i2, Charset charset) {
        int i3;
        if ((i | i2) < 0 || i2 > bArr.length - i) {
            throw failedBoundsCheck(bArr.length, i, i2);
        }
        String name = charset.name();
        if (!name.equals("UTF-8")) {
            if (name.equals("ISO-8859-1")) {
                this.offset = 0;
                this.value = new char[i2];
                this.count = i2;
                Charsets.isoLatin1BytesToChars(bArr, i, i2, this.value);
                return;
            } else if (name.equals("US-ASCII")) {
                this.offset = 0;
                this.value = new char[i2];
                this.count = i2;
                Charsets.asciiBytesToChars(bArr, i, i2, this.value);
                return;
            } else {
                CharBuffer decode = charset.decode(ByteBuffer.wrap(bArr, i, i2));
                this.offset = 0;
                this.count = decode.length();
                if (this.count <= 0) {
                    this.value = EmptyArray.CHAR;
                    return;
                }
                this.value = new char[this.count];
                System.arraycopy(decode.array(), 0, this.value, 0, this.count);
                return;
            }
        }
        char[] cArr = new char[i2];
        int i4 = i + i2;
        int i5 = i;
        int i6 = 0;
        while (i5 < i4) {
            int i7 = i5 + 1;
            byte b = bArr[i5];
            if ((b & 128) == 0) {
                cArr[i6] = (char) (b & 255);
                i3 = i6 + 1;
            } else if ((b & 224) == 192 || (b & 240) == 224 || (b & 248) == 240 || (b & 252) == 248 || (b & 254) == 252) {
                int i8 = 1;
                if ((b & 240) == 224) {
                    i8 = 2;
                } else if ((b & 248) == 240) {
                    i8 = 3;
                } else if ((b & 252) == 248) {
                    i8 = 4;
                } else if ((b & 254) == 252) {
                    i8 = 5;
                }
                if (i7 + i8 > i4) {
                    cArr[i6] = 65533;
                    i6++;
                    i5 = i7;
                } else {
                    int i9 = b & (31 >> (i8 - 1));
                    int i10 = 0;
                    while (true) {
                        if (i10 < i8) {
                            int i11 = i7 + 1;
                            byte b2 = bArr[i7];
                            if ((b2 & 192) != 128) {
                                cArr[i6] = 65533;
                                i6++;
                                i5 = i11 - 1;
                                break;
                            }
                            i9 = (i9 << 6) | (b2 & 63);
                            i10++;
                            i7 = i11;
                        } else if (i8 != 2 && i9 >= 55296 && i9 <= 57343) {
                            cArr[i6] = 65533;
                            i6++;
                            i5 = i7;
                        } else if (i9 > 1114111) {
                            cArr[i6] = 65533;
                            i6++;
                            i5 = i7;
                        } else if (i9 < 65536) {
                            cArr[i6] = (char) i9;
                            i3 = i6 + 1;
                        } else {
                            int i12 = i9 & 65535;
                            int i13 = i6 + 1;
                            cArr[i6] = (char) (55296 | (((((i9 >> 16) & 31) - 1) & 65535) << 6) | (i12 >> 10));
                            cArr[i13] = (char) (56320 | (i12 & 1023));
                            i3 = i13 + 1;
                        }
                    }
                }
            } else {
                cArr[i6] = 65533;
                i3 = i6 + 1;
            }
            i6 = i3;
            i5 = i7;
        }
        if (i6 == i2) {
            this.offset = 0;
            this.value = cArr;
            this.count = i6;
            return;
        }
        this.offset = 0;
        this.value = new char[i6];
        this.count = i6;
        System.arraycopy(cArr, 0, this.value, 0, i6);
    }

    public String(byte[] bArr, String str) throws UnsupportedEncodingException {
        this(bArr, 0, bArr.length, Charset.forNameUEE(str));
    }

    public String(byte[] bArr, Charset charset) {
        this(bArr, 0, bArr.length, charset);
    }

    public String(char[] cArr) {
        this(cArr, 0, cArr.length);
    }

    public String(char[] cArr, int i, int i2) {
        if ((i | i2) < 0 || i2 > cArr.length - i) {
            throw failedBoundsCheck(cArr.length, i, i2);
        }
        this.offset = 0;
        this.value = new char[i2];
        this.count = i2;
        System.arraycopy(cArr, i, this.value, 0, this.count);
    }

    public String(int[] iArr, int i, int i2) {
        if (iArr == null) {
            throw new NullPointerException("codePoints == null");
        }
        if ((i | i2) < 0 || i2 > iArr.length - i) {
            throw failedBoundsCheck(iArr.length, i, i2);
        }
        this.offset = 0;
        this.value = new char[i2 * 2];
        int i3 = 0;
        int i4 = i;
        while (true) {
            int i5 = i4;
            if (i5 >= i + i2) {
                this.count = i3;
                return;
            } else {
                i3 += Character.toChars(iArr[i5], this.value, i3);
                i4 = i5 + 1;
            }
        }
    }

    public static String copyValueOf(char[] cArr) {
        return new String(cArr, 0, cArr.length);
    }

    public static String copyValueOf(char[] cArr, int i, int i2) {
        return new String(cArr, i, i2);
    }

    private StringIndexOutOfBoundsException failedBoundsCheck(int i, int i2, int i3) {
        throw new StringIndexOutOfBoundsException(i, i2, i3);
    }

    private native int fastIndexOf(int i, int i2);

    private char foldCase(char c) {
        if (c < 128) {
            char c2 = c;
            if ('A' <= c) {
                c2 = c;
                if (c <= 'Z') {
                    c2 = (char) (c + ' ');
                }
            }
            return c2;
        }
        return Character.toLowerCase(Character.toUpperCase(c));
    }

    public static String format(String str, Object... objArr) {
        return format(Locale.getDefault(), str, objArr);
    }

    public static String format(Locale locale, String str, Object... objArr) {
        if (str == null) {
            throw new NullPointerException("format == null");
        }
        return new Formatter(new StringBuilder(str.length() + (objArr == null ? 0 : objArr.length * 10)), locale).format(str, objArr).toString();
    }

    private StringIndexOutOfBoundsException indexAndLength(int i) {
        throw new StringIndexOutOfBoundsException(this, i);
    }

    @FindBugsSuppressWarnings({"UPM_UNCALLED_PRIVATE_METHOD"})
    private static int indexOf(String str, String str2, int i, int i2, char c) {
        char[] cArr = str.value;
        int i3 = str.offset;
        int i4 = str.count;
        char[] cArr2 = str2.value;
        int i5 = str2.offset;
        int i6 = str2.count - 1;
        int i7 = i3;
        int i8 = i6;
        while (true) {
            int i9 = i7 + i8;
            if (i9 >= i3 + i4) {
                return -1;
            }
            if (c == cArr[i9]) {
                int i10 = 0;
                while (true) {
                    int i11 = i10;
                    if (i11 >= i6) {
                        return (i9 - i6) - i3;
                    }
                    if (cArr2[i11 + i5] != cArr[(i9 + i11) - i6]) {
                        int i12 = 1;
                        if (((1 << cArr[i9]) & i) == 0) {
                            i12 = 1 + i11;
                        }
                        i7 = i9;
                        i8 = Math.max(i2, i12);
                    } else {
                        i10 = i11 + 1;
                    }
                }
            } else {
                int i13 = i9;
                if (((1 << cArr[i9]) & i) == 0) {
                    i13 = i9 + i6;
                }
                i7 = i13;
                i8 = 1;
            }
        }
    }

    private int indexOfSupplementary(int i, int i2) {
        if (Character.isSupplementaryCodePoint(i)) {
            char[] chars = Character.toChars(i);
            return indexOf(new String(0, chars.length, chars), i2);
        }
        return -1;
    }

    private int lastIndexOfSupplementary(int i, int i2) {
        if (Character.isSupplementaryCodePoint(i)) {
            char[] chars = Character.toChars(i);
            return lastIndexOf(new String(0, chars.length, chars), i2);
        }
        return -1;
    }

    private StringIndexOutOfBoundsException startEndAndLength(int i, int i2) {
        throw new StringIndexOutOfBoundsException(this, i, i2 - i);
    }

    public static String valueOf(char c) {
        String str = c < 128 ? new String(c, 1, ASCII) : new String(0, 1, new char[]{c});
        str.hashCode = c;
        return str;
    }

    public static String valueOf(double d) {
        return Double.toString(d);
    }

    public static String valueOf(float f) {
        return Float.toString(f);
    }

    public static String valueOf(int i) {
        return Integer.toString(i);
    }

    public static String valueOf(long j) {
        return Long.toString(j);
    }

    public static String valueOf(Object obj) {
        return obj != null ? obj.toString() : "null";
    }

    public static String valueOf(boolean z) {
        return z ? "true" : "false";
    }

    public static String valueOf(char[] cArr) {
        return new String(cArr, 0, cArr.length);
    }

    public static String valueOf(char[] cArr, int i, int i2) {
        return new String(cArr, i, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void _getChars(int i, int i2, char[] cArr, int i3) {
        System.arraycopy(this.value, this.offset + i, cArr, i3, i2 - i);
    }

    @Override // java.lang.CharSequence
    public char charAt(int i) {
        if (i < 0 || i >= this.count) {
            throw indexAndLength(i);
        }
        return this.value[this.offset + i];
    }

    public int codePointAt(int i) {
        if (i < 0 || i >= this.count) {
            throw indexAndLength(i);
        }
        return Character.codePointAt(this.value, this.offset + i, this.offset + this.count);
    }

    public int codePointBefore(int i) {
        if (i < 1 || i > this.count) {
            throw indexAndLength(i);
        }
        return Character.codePointBefore(this.value, this.offset + i, this.offset);
    }

    public int codePointCount(int i, int i2) {
        if (i < 0 || i2 > this.count || i > i2) {
            throw startEndAndLength(i, i2);
        }
        return Character.codePointCount(this.value, this.offset + i, i2 - i);
    }

    @Override // java.lang.Comparable
    public native int compareTo(String str);

    public int compareToIgnoreCase(String str) {
        int i = this.offset;
        int i2 = str.offset;
        int i3 = this.offset;
        int i4 = this.count < str.count ? this.count : str.count;
        char[] cArr = str.value;
        while (i < i3 + i4) {
            int i5 = i + 1;
            char c = this.value[i];
            int i6 = i2 + 1;
            char c2 = cArr[i2];
            if (c == c2) {
                i2 = i6;
                i = i5;
            } else {
                int foldCase = foldCase(c) - foldCase(c2);
                if (foldCase != 0) {
                    return foldCase;
                }
                i2 = i6;
                i = i5;
            }
        }
        return this.count - str.count;
    }

    public String concat(String str) {
        if (str.count > 0 && this.count > 0) {
            char[] cArr = new char[this.count + str.count];
            System.arraycopy(this.value, this.offset, cArr, 0, this.count);
            System.arraycopy(str.value, str.offset, cArr, this.count, str.count);
            str = new String(0, cArr.length, cArr);
        } else if (this.count != 0) {
            return this;
        }
        return str;
    }

    public boolean contains(CharSequence charSequence) {
        if (charSequence == null) {
            throw new NullPointerException("cs == null");
        }
        return indexOf(charSequence.toString()) >= 0;
    }

    public boolean contentEquals(CharSequence charSequence) {
        if (charSequence == null) {
            throw new NullPointerException("cs == null");
        }
        int length = charSequence.length();
        if (length != this.count) {
            return false;
        }
        if (length == 0 && this.count == 0) {
            return true;
        }
        return regionMatches(0, charSequence.toString(), 0, length);
    }

    public boolean contentEquals(StringBuffer stringBuffer) {
        synchronized (stringBuffer) {
            int length = stringBuffer.length();
            if (this.count != length) {
                return false;
            }
            return regionMatches(0, new String(0, length, stringBuffer.getValue()), 0, length);
        }
    }

    public boolean endsWith(String str) {
        return regionMatches(this.count - str.count, str, 0, str.count);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            int i = this.count;
            if (str.count == i && hashCode() == str.hashCode()) {
                char[] cArr = this.value;
                int i2 = this.offset;
                char[] cArr2 = str.value;
                int i3 = str.offset;
                int i4 = i2;
                while (i4 < i2 + i) {
                    if (cArr[i4] != cArr2[i3]) {
                        return false;
                    }
                    i4++;
                    i3++;
                }
                return true;
            }
            return false;
        }
        return false;
    }

    @FindBugsSuppressWarnings({"ES_COMPARING_PARAMETER_STRING_WITH_EQ"})
    public boolean equalsIgnoreCase(String str) {
        if (str == this) {
            return true;
        }
        if (str == null || this.count != str.count) {
            return false;
        }
        int i = str.offset;
        int i2 = this.offset;
        int i3 = this.count;
        char[] cArr = str.value;
        for (int i4 = this.offset; i4 < i2 + i3; i4++) {
            char c = this.value[i4];
            char c2 = cArr[i];
            if (c != c2 && foldCase(c) != foldCase(c2)) {
                return false;
            }
            i++;
        }
        return true;
    }

    @Deprecated
    public void getBytes(int i, int i2, byte[] bArr, int i3) {
        if (i < 0 || i > i2 || i2 > this.count) {
            throw startEndAndLength(i, i2);
        }
        int i4 = i2 + this.offset;
        int i5 = i3;
        try {
            int i6 = i3;
            int i7 = this.offset + i;
            while (i7 < i4) {
                int i8 = i6 + 1;
                i5 = i8;
                bArr[i6] = (byte) this.value[i7];
                i7++;
                i6 = i8;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            throw failedBoundsCheck(bArr.length, i5, i4 - i);
        }
    }

    public byte[] getBytes() {
        return getBytes(Charset.defaultCharset());
    }

    public byte[] getBytes(String str) throws UnsupportedEncodingException {
        return getBytes(Charset.forNameUEE(str));
    }

    public byte[] getBytes(Charset charset) {
        String name = charset.name();
        if (name.equals("UTF-8")) {
            return Charsets.toUtf8Bytes(this.value, this.offset, this.count);
        }
        if (name.equals("ISO-8859-1")) {
            return Charsets.toIsoLatin1Bytes(this.value, this.offset, this.count);
        }
        if (name.equals("US-ASCII")) {
            return Charsets.toAsciiBytes(this.value, this.offset, this.count);
        }
        if (name.equals(CharEncoding.UTF_16BE)) {
            return Charsets.toBigEndianUtf16Bytes(this.value, this.offset, this.count);
        }
        ByteBuffer encode = charset.encode(CharBuffer.wrap(this.value, this.offset, this.count).asReadOnlyBuffer());
        byte[] bArr = new byte[encode.limit()];
        encode.get(bArr);
        return bArr;
    }

    public void getChars(int i, int i2, char[] cArr, int i3) {
        if (i < 0 || i > i2 || i2 > this.count) {
            throw startEndAndLength(i, i2);
        }
        System.arraycopy(this.value, this.offset + i, cArr, i3, i2 - i);
    }

    public int hashCode() {
        int i = this.hashCode;
        int i2 = i;
        if (i == 0) {
            if (this.count == 0) {
                return 0;
            }
            int i3 = this.count;
            int i4 = this.offset;
            char[] cArr = this.value;
            int i5 = this.offset;
            while (true) {
                int i6 = i5;
                if (i6 >= i3 + i4) {
                    break;
                }
                i = (i * 31) + cArr[i6];
                i5 = i6 + 1;
            }
            this.hashCode = i;
            i2 = i;
        }
        return i2;
    }

    public int indexOf(int i) {
        return i > 65535 ? indexOfSupplementary(i, 0) : fastIndexOf(i, 0);
    }

    public int indexOf(int i, int i2) {
        return i > 65535 ? indexOfSupplementary(i, i2) : fastIndexOf(i, i2);
    }

    public int indexOf(String str) {
        int i;
        int i2;
        int i3;
        int i4 = 0;
        int i5 = str.count;
        int i6 = this.count;
        if (i5 <= 0) {
            int i7 = i6;
            if (i6 < 0) {
                i7 = 0;
            }
            return i7;
        }
        if (i5 <= i6) {
            char[] cArr = str.value;
            int i8 = str.offset;
            char c = cArr[i8];
            int i9 = i8 + i5;
            while (true) {
                int indexOf = indexOf(c, i4);
                if (indexOf != -1 && i5 + indexOf <= i6) {
                    int i10 = this.offset + indexOf;
                    int i11 = i8;
                    char[] cArr2 = this.value;
                    do {
                        i = i11 + 1;
                        if (i >= i9) {
                            break;
                        }
                        i3 = i10 + 1;
                        i10 = i3;
                        i11 = i;
                    } while (cArr2[i3] == cArr[i]);
                    i2 = indexOf;
                    if (i == i9) {
                        break;
                    }
                    i4 = indexOf + 1;
                } else {
                    return -1;
                }
            }
        } else {
            i2 = -1;
        }
        return i2;
    }

    public int indexOf(String str, int i) {
        int i2;
        int i3;
        int i4;
        int i5 = i;
        if (i < 0) {
            i5 = 0;
        }
        int i6 = str.count;
        int i7 = this.count;
        if (i6 <= 0) {
            int i8 = i7;
            if (i5 < i7) {
                i8 = i5;
            }
            return i8;
        }
        if (i6 + i5 <= i7) {
            char[] cArr = str.value;
            int i9 = str.offset;
            char c = cArr[i9];
            int i10 = i9 + i6;
            while (true) {
                int indexOf = indexOf(c, i5);
                if (indexOf != -1 && i6 + indexOf <= i7) {
                    int i11 = this.offset + indexOf;
                    int i12 = i9;
                    char[] cArr2 = this.value;
                    do {
                        i2 = i12 + 1;
                        if (i2 >= i10) {
                            break;
                        }
                        i4 = i11 + 1;
                        i11 = i4;
                        i12 = i2;
                    } while (cArr2[i4] == cArr[i2]);
                    i3 = indexOf;
                    if (i2 == i10) {
                        break;
                    }
                    i5 = indexOf + 1;
                } else {
                    return -1;
                }
            }
        } else {
            i3 = -1;
        }
        return i3;
    }

    public native String intern();

    public boolean isEmpty() {
        return this.count == 0;
    }

    public int lastIndexOf(int i) {
        if (i > 65535) {
            return lastIndexOfSupplementary(i, Integer.MAX_VALUE);
        }
        int i2 = this.count;
        int i3 = this.offset;
        char[] cArr = this.value;
        int i4 = i3 + i2;
        while (true) {
            int i5 = i4 - 1;
            if (i5 < i3) {
                return -1;
            }
            if (cArr[i5] == i) {
                return i5 - i3;
            }
            i4 = i5;
        }
    }

    public int lastIndexOf(int i, int i2) {
        if (i > 65535) {
            return lastIndexOfSupplementary(i, i2);
        }
        int i3 = this.count;
        int i4 = this.offset;
        char[] cArr = this.value;
        if (i2 < 0) {
            return -1;
        }
        int i5 = i2;
        if (i2 >= i3) {
            i5 = i3 - 1;
        }
        int i6 = i4 + i5;
        while (true) {
            int i7 = i6;
            if (i7 < i4) {
                return -1;
            }
            if (cArr[i7] == i) {
                return i7 - i4;
            }
            i6 = i7 - 1;
        }
    }

    public int lastIndexOf(String str) {
        return lastIndexOf(str, this.count);
    }

    public int lastIndexOf(String str, int i) {
        int i2;
        int i3;
        int i4;
        int i5 = str.count;
        if (i5 > this.count || i < 0) {
            return -1;
        }
        if (i5 <= 0) {
            if (i >= this.count) {
                i = this.count;
            }
            return i;
        }
        int i6 = i;
        if (i > this.count - i5) {
            i6 = this.count - i5;
        }
        char[] cArr = str.value;
        int i7 = str.offset;
        char c = cArr[i7];
        int i8 = i7 + i5;
        while (true) {
            int lastIndexOf = lastIndexOf(c, i6);
            if (lastIndexOf != -1) {
                int i9 = this.offset + lastIndexOf;
                int i10 = i7;
                do {
                    i3 = i10 + 1;
                    if (i3 >= i8) {
                        break;
                    }
                    i4 = i9 + 1;
                    i9 = i4;
                    i10 = i3;
                } while (this.value[i4] == cArr[i3]);
                i2 = lastIndexOf;
                if (i3 == i8) {
                    break;
                }
                i6 = lastIndexOf - 1;
            } else {
                i2 = -1;
                break;
            }
        }
        return i2;
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.count;
    }

    public boolean matches(String str) {
        return Pattern.matches(str, this);
    }

    public int offsetByCodePoints(int i, int i2) {
        return Character.offsetByCodePoints(this.value, this.offset, this.count, i + this.offset, i2) - this.offset;
    }

    public boolean regionMatches(int i, String str, int i2, int i3) {
        boolean z;
        if (str == null) {
            throw new NullPointerException("string == null");
        }
        if (i2 < 0 || str.count - i2 < i3) {
            z = false;
        } else if (i < 0 || this.count - i < i3) {
            return false;
        } else {
            z = true;
            if (i3 > 0) {
                int i4 = this.offset;
                int i5 = str.offset;
                char[] cArr = this.value;
                char[] cArr2 = str.value;
                int i6 = 0;
                while (true) {
                    int i7 = i6;
                    z = true;
                    if (i7 >= i3) {
                        break;
                    } else if (cArr[i4 + i + i7] != cArr2[i5 + i2 + i7]) {
                        return false;
                    } else {
                        i6 = i7 + 1;
                    }
                }
            }
        }
        return z;
    }

    public boolean regionMatches(boolean z, int i, String str, int i2, int i3) {
        boolean z2;
        if (!z) {
            z2 = regionMatches(i, str, i2, i3);
        } else if (str == null) {
            throw new NullPointerException("string == null");
        } else {
            z2 = false;
            if (i >= 0) {
                z2 = false;
                if (i3 <= this.count - i) {
                    z2 = false;
                    if (i2 >= 0) {
                        z2 = false;
                        if (i3 <= str.count - i2) {
                            int i4 = i + this.offset;
                            int i5 = str.offset;
                            char[] cArr = str.value;
                            int i6 = i2 + i5;
                            int i7 = i4;
                            while (true) {
                                int i8 = i7;
                                if (i8 >= i4 + i3) {
                                    return true;
                                }
                                char c = this.value[i8];
                                char c2 = cArr[i6];
                                if (c != c2) {
                                    z2 = false;
                                    if (foldCase(c) != foldCase(c2)) {
                                        break;
                                    }
                                }
                                i6++;
                                i7 = i8 + 1;
                            }
                        }
                    }
                }
            }
        }
        return z2;
    }

    public String replace(char c, char c2) {
        char[] cArr = this.value;
        int i = this.offset;
        int i2 = this.count;
        int i3 = i;
        int i4 = i + i2;
        boolean z = false;
        while (i3 < i4) {
            char[] cArr2 = cArr;
            boolean z2 = z;
            int i5 = i3;
            int i6 = i4;
            if (cArr[i3] == c) {
                cArr2 = cArr;
                z2 = z;
                i5 = i3;
                i6 = i4;
                if (!z) {
                    cArr2 = new char[i2];
                    System.arraycopy(cArr, i, cArr2, 0, i2);
                    i5 = i3 - i;
                    i6 = i4 - i;
                    z2 = true;
                }
                cArr2[i5] = c2;
            }
            i3 = i5 + 1;
            cArr = cArr2;
            z = z2;
            i4 = i6;
        }
        String str = this;
        if (z) {
            str = new String(0, this.count, cArr);
        }
        return str;
    }

    public String replace(CharSequence charSequence, CharSequence charSequence2) {
        int i;
        int indexOf;
        if (charSequence == null) {
            throw new NullPointerException("target == null");
        }
        if (charSequence2 == null) {
            throw new NullPointerException("replacement == null");
        }
        String charSequence3 = charSequence.toString();
        int indexOf2 = indexOf(charSequence3, 0);
        if (indexOf2 == -1) {
            return this;
        }
        String charSequence4 = charSequence2.toString();
        int length = charSequence3.length();
        if (length != 0) {
            StringBuilder sb = new StringBuilder(this.count);
            int i2 = 0;
            do {
                sb.append(this.value, this.offset + i2, indexOf2 - i2);
                sb.append(charSequence4);
                i = indexOf2 + length;
                indexOf = indexOf(charSequence3, i);
                indexOf2 = indexOf;
                i2 = i;
            } while (indexOf != -1);
            sb.append(this.value, this.offset + i, this.count - i);
            return sb.toString();
        }
        StringBuilder sb2 = new StringBuilder(this.count + ((this.count + 1) * charSequence4.length()));
        sb2.append(charSequence4);
        int i3 = this.offset;
        int i4 = this.count;
        int i5 = this.offset;
        while (true) {
            int i6 = i5;
            if (i6 == i3 + i4) {
                return sb2.toString();
            }
            sb2.append(this.value[i6]);
            sb2.append(charSequence4);
            i5 = i6 + 1;
        }
    }

    public String replaceAll(String str, String str2) {
        return Pattern.compile(str).matcher(this).replaceAll(str2);
    }

    public String replaceFirst(String str, String str2) {
        return Pattern.compile(str).matcher(this).replaceFirst(str2);
    }

    public String[] split(String str) {
        return split(str, 0);
    }

    public String[] split(String str, int i) {
        String[] fastSplit = Splitter.fastSplit(str, this, i);
        return fastSplit != null ? fastSplit : Pattern.compile(str).split(this, i);
    }

    public boolean startsWith(String str) {
        return startsWith(str, 0);
    }

    public boolean startsWith(String str, int i) {
        return regionMatches(i, str, 0, str.count);
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i, int i2) {
        return substring(i, i2);
    }

    public String substring(int i) {
        if (i == 0) {
            return this;
        }
        if (i < 0 || i > this.count) {
            throw indexAndLength(i);
        }
        return new String(this.offset + i, this.count - i, this.value);
    }

    public String substring(int i, int i2) {
        if (i == 0 && i2 == this.count) {
            return this;
        }
        if (i < 0 || i > i2 || i2 > this.count) {
            throw startEndAndLength(i, i2);
        }
        return new String(this.offset + i, i2 - i, this.value);
    }

    public char[] toCharArray() {
        char[] cArr = new char[this.count];
        System.arraycopy(this.value, this.offset, cArr, 0, this.count);
        return cArr;
    }

    public String toLowerCase() {
        return CaseMapper.toLowerCase(Locale.getDefault(), this, this.value, this.offset, this.count);
    }

    public String toLowerCase(Locale locale) {
        return CaseMapper.toLowerCase(locale, this, this.value, this.offset, this.count);
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return this;
    }

    public String toUpperCase() {
        return CaseMapper.toUpperCase(Locale.getDefault(), this, this.value, this.offset, this.count);
    }

    public String toUpperCase(Locale locale) {
        return CaseMapper.toUpperCase(locale, this, this.value, this.offset, this.count);
    }

    public String trim() {
        int i;
        int i2 = this.offset;
        int i3 = (this.offset + this.count) - 1;
        while (true) {
            i = i3;
            if (i2 > i3) {
                break;
            }
            i = i3;
            if (this.value[i2] > ' ') {
                break;
            }
            i2++;
        }
        while (i >= i2 && this.value[i] <= ' ') {
            i--;
        }
        return (i2 == this.offset && i == i3) ? this : new String(i2, (i - i2) + 1, this.value);
    }
}
