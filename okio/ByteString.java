package okio;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import okio.internal._ByteStringKt;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:okio/ByteString.class */
public class ByteString implements Serializable, Comparable<ByteString> {
    public static final Companion Companion = new Companion(null);
    public static final ByteString EMPTY = new ByteString(new byte[0]);
    private static final long serialVersionUID = 1;
    private final byte[] data;
    private transient int hashCode;
    private transient String utf8;

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:okio/ByteString$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ ByteString encodeString$default(Companion companion, String str, Charset charset, int i, Object obj) {
            if ((i & 1) != 0) {
                charset = Charsets.b;
            }
            return companion.encodeString(str, charset);
        }

        public static /* synthetic */ ByteString of$default(Companion companion, byte[] bArr, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = 0;
            }
            if ((i3 & 2) != 0) {
                i2 = bArr.length;
            }
            return companion.of(bArr, i, i2);
        }

        @Deprecated
        /* renamed from: -deprecated_decodeBase64  reason: not valid java name */
        public final ByteString m13280deprecated_decodeBase64(String string) {
            Intrinsics.e(string, "string");
            return decodeBase64(string);
        }

        @Deprecated
        /* renamed from: -deprecated_decodeHex  reason: not valid java name */
        public final ByteString m13281deprecated_decodeHex(String string) {
            Intrinsics.e(string, "string");
            return decodeHex(string);
        }

        @Deprecated
        /* renamed from: -deprecated_encodeString  reason: not valid java name */
        public final ByteString m13282deprecated_encodeString(String string, Charset charset) {
            Intrinsics.e(string, "string");
            Intrinsics.e(charset, "charset");
            return encodeString(string, charset);
        }

        @Deprecated
        /* renamed from: -deprecated_encodeUtf8  reason: not valid java name */
        public final ByteString m13283deprecated_encodeUtf8(String string) {
            Intrinsics.e(string, "string");
            return encodeUtf8(string);
        }

        @Deprecated
        /* renamed from: -deprecated_of  reason: not valid java name */
        public final ByteString m13284deprecated_of(ByteBuffer buffer) {
            Intrinsics.e(buffer, "buffer");
            return of(buffer);
        }

        @Deprecated
        /* renamed from: -deprecated_of  reason: not valid java name */
        public final ByteString m13285deprecated_of(byte[] array, int i, int i2) {
            Intrinsics.e(array, "array");
            return of(array, i, i2);
        }

        @Deprecated
        /* renamed from: -deprecated_read  reason: not valid java name */
        public final ByteString m13286deprecated_read(InputStream inputstream, int i) {
            Intrinsics.e(inputstream, "inputstream");
            return read(inputstream, i);
        }

        @JvmStatic
        public final ByteString decodeBase64(String str) {
            Intrinsics.e(str, "<this>");
            byte[] decodeBase64ToArray = _Base64Kt.decodeBase64ToArray(str);
            if (decodeBase64ToArray != null) {
                return new ByteString(decodeBase64ToArray);
            }
            return null;
        }

        @JvmStatic
        public final ByteString decodeHex(String str) {
            Intrinsics.e(str, "<this>");
            int i = 0;
            if (str.length() % 2 == 0) {
                int length = str.length() / 2;
                byte[] bArr = new byte[length];
                int i2 = length - 1;
                if (i2 >= 0) {
                    while (true) {
                        int i3 = i;
                        i = i3 + 1;
                        int i4 = i3 * 2;
                        bArr[i3] = (byte) ((_ByteStringKt.access$decodeHexDigit(str.charAt(i4)) << 4) + _ByteStringKt.access$decodeHexDigit(str.charAt(i4 + 1)));
                        if (i > i2) {
                            break;
                        }
                    }
                }
                return new ByteString(bArr);
            }
            throw new IllegalArgumentException(Intrinsics.a("Unexpected hex string: ", (Object) str).toString());
        }

        @JvmStatic
        public final ByteString encodeString(String str, Charset charset) {
            Intrinsics.e(str, "<this>");
            Intrinsics.e(charset, "charset");
            byte[] bytes = str.getBytes(charset);
            Intrinsics.c(bytes, "(this as java.lang.String).getBytes(charset)");
            return new ByteString(bytes);
        }

        @JvmStatic
        public final ByteString encodeUtf8(String str) {
            Intrinsics.e(str, "<this>");
            ByteString byteString = new ByteString(_JvmPlatformKt.asUtf8ToByteArray(str));
            byteString.setUtf8$okio(str);
            return byteString;
        }

        @JvmStatic
        public final ByteString of(ByteBuffer byteBuffer) {
            Intrinsics.e(byteBuffer, "<this>");
            byte[] bArr = new byte[byteBuffer.remaining()];
            byteBuffer.get(bArr);
            return new ByteString(bArr);
        }

        @JvmStatic
        public final ByteString of(byte... data) {
            Intrinsics.e(data, "data");
            byte[] copyOf = Arrays.copyOf(data, data.length);
            Intrinsics.c(copyOf, "java.util.Arrays.copyOf(this, size)");
            return new ByteString(copyOf);
        }

        @JvmStatic
        public final ByteString of(byte[] bArr, int i, int i2) {
            Intrinsics.e(bArr, "<this>");
            _UtilKt.checkOffsetAndCount(bArr.length, i, i2);
            return new ByteString(ArraysKt.a(bArr, i, i2 + i));
        }

        @JvmStatic
        public final ByteString read(InputStream inputStream, int i) throws IOException {
            Intrinsics.e(inputStream, "<this>");
            if (!(i >= 0)) {
                throw new IllegalArgumentException(Intrinsics.a("byteCount < 0: ", (Object) Integer.valueOf(i)).toString());
            }
            byte[] bArr = new byte[i];
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= i) {
                    return new ByteString(bArr);
                }
                int read = inputStream.read(bArr, i3, i - i3);
                if (read == -1) {
                    throw new EOFException();
                }
                i2 = i3 + read;
            }
        }
    }

    public ByteString(byte[] data) {
        Intrinsics.e(data, "data");
        this.data = data;
    }

    public static /* synthetic */ void copyInto$default(ByteString byteString, int i, byte[] bArr, int i2, int i3, int i4, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: copyInto");
        }
        if ((i4 & 1) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        byteString.copyInto(i, bArr, i2, i3);
    }

    @JvmStatic
    public static final ByteString decodeBase64(String str) {
        return Companion.decodeBase64(str);
    }

    @JvmStatic
    public static final ByteString decodeHex(String str) {
        return Companion.decodeHex(str);
    }

    @JvmStatic
    public static final ByteString encodeString(String str, Charset charset) {
        return Companion.encodeString(str, charset);
    }

    @JvmStatic
    public static final ByteString encodeUtf8(String str) {
        return Companion.encodeUtf8(str);
    }

    public static /* synthetic */ int indexOf$default(ByteString byteString, ByteString byteString2, int i, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                i = 0;
            }
            return byteString.indexOf(byteString2, i);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: indexOf");
    }

    public static /* synthetic */ int indexOf$default(ByteString byteString, byte[] bArr, int i, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                i = 0;
            }
            return byteString.indexOf(bArr, i);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: indexOf");
    }

    public static /* synthetic */ int lastIndexOf$default(ByteString byteString, ByteString byteString2, int i, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                i = _UtilKt.getDEFAULT__ByteString_size();
            }
            return byteString.lastIndexOf(byteString2, i);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lastIndexOf");
    }

    public static /* synthetic */ int lastIndexOf$default(ByteString byteString, byte[] bArr, int i, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                i = _UtilKt.getDEFAULT__ByteString_size();
            }
            return byteString.lastIndexOf(bArr, i);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lastIndexOf");
    }

    @JvmStatic
    public static final ByteString of(ByteBuffer byteBuffer) {
        return Companion.of(byteBuffer);
    }

    @JvmStatic
    public static final ByteString of(byte... bArr) {
        return Companion.of(bArr);
    }

    @JvmStatic
    public static final ByteString of(byte[] bArr, int i, int i2) {
        return Companion.of(bArr, i, i2);
    }

    @JvmStatic
    public static final ByteString read(InputStream inputStream, int i) throws IOException {
        return Companion.read(inputStream, i);
    }

    private final void readObject(ObjectInputStream objectInputStream) throws IOException {
        ByteString read = Companion.read(objectInputStream, objectInputStream.readInt());
        Field declaredField = ByteString.class.getDeclaredField("data");
        declaredField.setAccessible(true);
        declaredField.set(this, read.data);
    }

    public static /* synthetic */ ByteString substring$default(ByteString byteString, int i, int i2, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 1) != 0) {
                i = 0;
            }
            if ((i3 & 2) != 0) {
                i2 = _UtilKt.getDEFAULT__ByteString_size();
            }
            return byteString.substring(i, i2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: substring");
    }

    private final void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(this.data.length);
        objectOutputStream.write(this.data);
    }

    @Deprecated
    /* renamed from: -deprecated_getByte  reason: not valid java name */
    public final byte m13278deprecated_getByte(int i) {
        return getByte(i);
    }

    @Deprecated
    /* renamed from: -deprecated_size  reason: not valid java name */
    public final int m13279deprecated_size() {
        return size();
    }

    public ByteBuffer asByteBuffer() {
        ByteBuffer asReadOnlyBuffer = ByteBuffer.wrap(this.data).asReadOnlyBuffer();
        Intrinsics.c(asReadOnlyBuffer, "wrap(data).asReadOnlyBuffer()");
        return asReadOnlyBuffer;
    }

    public String base64() {
        return _Base64Kt.encodeBase64$default(getData$okio(), null, 1, null);
    }

    public String base64Url() {
        return _Base64Kt.encodeBase64(getData$okio(), _Base64Kt.getBASE64_URL_SAFE());
    }

    @Override // java.lang.Comparable
    public int compareTo(ByteString other) {
        Intrinsics.e(other, "other");
        int size = size();
        int size2 = other.size();
        int min = Math.min(size, size2);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= min) {
                if (size == size2) {
                    return 0;
                }
                return size < size2 ? -1 : 1;
            }
            int i3 = getByte(i2) & 255;
            int i4 = other.getByte(i2) & 255;
            if (i3 != i4) {
                return i3 < i4 ? -1 : 1;
            }
            i = i2 + 1;
        }
    }

    public void copyInto(int i, byte[] target, int i2, int i3) {
        Intrinsics.e(target, "target");
        ArraysKt.a(getData$okio(), target, i2, i, i3 + i);
    }

    public ByteString digest$okio(String algorithm) {
        Intrinsics.e(algorithm, "algorithm");
        MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
        messageDigest.update(getData$okio(), 0, size());
        byte[] digestBytes = messageDigest.digest();
        Intrinsics.c(digestBytes, "digestBytes");
        return new ByteString(digestBytes);
    }

    public final boolean endsWith(ByteString suffix) {
        Intrinsics.e(suffix, "suffix");
        return rangeEquals(size() - suffix.size(), suffix, 0, suffix.size());
    }

    public final boolean endsWith(byte[] suffix) {
        Intrinsics.e(suffix, "suffix");
        return rangeEquals(size() - suffix.length, suffix, 0, suffix.length);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            return byteString.size() == getData$okio().length && byteString.rangeEquals(0, getData$okio(), 0, getData$okio().length);
        }
        return false;
    }

    public final byte getByte(int i) {
        return internalGet$okio(i);
    }

    public final byte[] getData$okio() {
        return this.data;
    }

    public final int getHashCode$okio() {
        return this.hashCode;
    }

    public int getSize$okio() {
        return getData$okio().length;
    }

    public final String getUtf8$okio() {
        return this.utf8;
    }

    public int hashCode() {
        int hashCode$okio = getHashCode$okio();
        if (hashCode$okio != 0) {
            return hashCode$okio;
        }
        int hashCode = Arrays.hashCode(getData$okio());
        setHashCode$okio(hashCode);
        return hashCode;
    }

    public String hex() {
        char[] cArr = new char[getData$okio().length * 2];
        byte[] data$okio = getData$okio();
        int length = data$okio.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            byte b = data$okio[i];
            i++;
            int i3 = i2 + 1;
            cArr[i2] = _ByteStringKt.getHEX_DIGIT_CHARS()[(b >> 4) & 15];
            i2 = i3 + 1;
            cArr[i3] = _ByteStringKt.getHEX_DIGIT_CHARS()[b & 15];
        }
        return StringsKt.a(cArr);
    }

    public ByteString hmac$okio(String algorithm, ByteString key) {
        Intrinsics.e(algorithm, "algorithm");
        Intrinsics.e(key, "key");
        try {
            Mac mac = Mac.getInstance(algorithm);
            mac.init(new SecretKeySpec(key.toByteArray(), algorithm));
            byte[] doFinal = mac.doFinal(this.data);
            Intrinsics.c(doFinal, "mac.doFinal(data)");
            return new ByteString(doFinal);
        } catch (InvalidKeyException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public ByteString hmacSha1(ByteString key) {
        Intrinsics.e(key, "key");
        return hmac$okio("HmacSHA1", key);
    }

    public ByteString hmacSha256(ByteString key) {
        Intrinsics.e(key, "key");
        return hmac$okio("HmacSHA256", key);
    }

    public ByteString hmacSha512(ByteString key) {
        Intrinsics.e(key, "key");
        return hmac$okio("HmacSHA512", key);
    }

    public final int indexOf(ByteString other) {
        Intrinsics.e(other, "other");
        return indexOf$default(this, other, 0, 2, (Object) null);
    }

    public final int indexOf(ByteString other, int i) {
        Intrinsics.e(other, "other");
        return indexOf(other.internalArray$okio(), i);
    }

    public final int indexOf(byte[] other) {
        Intrinsics.e(other, "other");
        return indexOf$default(this, other, 0, 2, (Object) null);
    }

    public int indexOf(byte[] other, int i) {
        Intrinsics.e(other, "other");
        int length = getData$okio().length - other.length;
        int max = Math.max(i, 0);
        if (max <= length) {
            while (!_UtilKt.arrayRangeEquals(getData$okio(), max, other, 0, other.length)) {
                if (max == length) {
                    return -1;
                }
                max++;
            }
            return max;
        }
        return -1;
    }

    public byte[] internalArray$okio() {
        return getData$okio();
    }

    public byte internalGet$okio(int i) {
        return getData$okio()[i];
    }

    public final int lastIndexOf(ByteString other) {
        Intrinsics.e(other, "other");
        return lastIndexOf$default(this, other, 0, 2, (Object) null);
    }

    public final int lastIndexOf(ByteString other, int i) {
        Intrinsics.e(other, "other");
        return lastIndexOf(other.internalArray$okio(), i);
    }

    public final int lastIndexOf(byte[] other) {
        Intrinsics.e(other, "other");
        return lastIndexOf$default(this, other, 0, 2, (Object) null);
    }

    public int lastIndexOf(byte[] other, int i) {
        Intrinsics.e(other, "other");
        int min = Math.min(_UtilKt.resolveDefaultParameter(this, i), getData$okio().length - other.length);
        if (min < 0) {
            return -1;
        }
        while (true) {
            int i2 = min - 1;
            if (_UtilKt.arrayRangeEquals(getData$okio(), min, other, 0, other.length)) {
                return min;
            }
            if (i2 < 0) {
                return -1;
            }
            min = i2;
        }
    }

    public final ByteString md5() {
        return digest$okio("MD5");
    }

    public boolean rangeEquals(int i, ByteString other, int i2, int i3) {
        Intrinsics.e(other, "other");
        return other.rangeEquals(i2, getData$okio(), i, i3);
    }

    public boolean rangeEquals(int i, byte[] other, int i2, int i3) {
        Intrinsics.e(other, "other");
        return i >= 0 && i <= getData$okio().length - i3 && i2 >= 0 && i2 <= other.length - i3 && _UtilKt.arrayRangeEquals(getData$okio(), i, other, i2, i3);
    }

    public final void setHashCode$okio(int i) {
        this.hashCode = i;
    }

    public final void setUtf8$okio(String str) {
        this.utf8 = str;
    }

    public final ByteString sha1() {
        return digest$okio("SHA-1");
    }

    public final ByteString sha256() {
        return digest$okio("SHA-256");
    }

    public final ByteString sha512() {
        return digest$okio("SHA-512");
    }

    public final int size() {
        return getSize$okio();
    }

    public final boolean startsWith(ByteString prefix) {
        Intrinsics.e(prefix, "prefix");
        return rangeEquals(0, prefix, 0, prefix.size());
    }

    public final boolean startsWith(byte[] prefix) {
        Intrinsics.e(prefix, "prefix");
        return rangeEquals(0, prefix, 0, prefix.length);
    }

    public String string(Charset charset) {
        Intrinsics.e(charset, "charset");
        return new String(this.data, charset);
    }

    public final ByteString substring() {
        return substring$default(this, 0, 0, 3, null);
    }

    public final ByteString substring(int i) {
        return substring$default(this, i, 0, 2, null);
    }

    public ByteString substring(int i, int i2) {
        int resolveDefaultParameter = _UtilKt.resolveDefaultParameter(this, i2);
        if (i >= 0) {
            if (resolveDefaultParameter <= getData$okio().length) {
                if (resolveDefaultParameter - i >= 0) {
                    return (i == 0 && resolveDefaultParameter == getData$okio().length) ? this : new ByteString(ArraysKt.a(getData$okio(), i, resolveDefaultParameter));
                }
                throw new IllegalArgumentException("endIndex < beginIndex".toString());
            }
            throw new IllegalArgumentException(("endIndex > length(" + getData$okio().length + ')').toString());
        }
        throw new IllegalArgumentException("beginIndex < 0".toString());
    }

    public ByteString toAsciiLowercase() {
        byte b;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= getData$okio().length) {
                return this;
            }
            byte b2 = getData$okio()[i2];
            byte b3 = (byte) 65;
            if (b2 < b3 || b2 > (b = (byte) 90)) {
                i = i2 + 1;
            } else {
                byte[] data$okio = getData$okio();
                byte[] copyOf = Arrays.copyOf(data$okio, data$okio.length);
                Intrinsics.c(copyOf, "java.util.Arrays.copyOf(this, size)");
                copyOf[i2] = (byte) (b2 + 32);
                int i3 = i2 + 1;
                while (true) {
                    int i4 = i3;
                    if (i4 >= copyOf.length) {
                        return new ByteString(copyOf);
                    }
                    byte b4 = copyOf[i4];
                    if (b4 >= b3 && b4 <= b) {
                        copyOf[i4] = (byte) (b4 + 32);
                    }
                    i3 = i4 + 1;
                }
            }
        }
    }

    public ByteString toAsciiUppercase() {
        byte b;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= getData$okio().length) {
                return this;
            }
            byte b2 = getData$okio()[i2];
            byte b3 = (byte) 97;
            if (b2 < b3 || b2 > (b = (byte) 122)) {
                i = i2 + 1;
            } else {
                byte[] data$okio = getData$okio();
                byte[] copyOf = Arrays.copyOf(data$okio, data$okio.length);
                Intrinsics.c(copyOf, "java.util.Arrays.copyOf(this, size)");
                copyOf[i2] = (byte) (b2 - 32);
                int i3 = i2 + 1;
                while (true) {
                    int i4 = i3;
                    if (i4 >= copyOf.length) {
                        return new ByteString(copyOf);
                    }
                    byte b4 = copyOf[i4];
                    if (b4 >= b3 && b4 <= b) {
                        copyOf[i4] = (byte) (b4 - 32);
                    }
                    i3 = i4 + 1;
                }
            }
        }
    }

    public byte[] toByteArray() {
        byte[] data$okio = getData$okio();
        byte[] copyOf = Arrays.copyOf(data$okio, data$okio.length);
        Intrinsics.c(copyOf, "java.util.Arrays.copyOf(this, size)");
        return copyOf;
    }

    public String toString() {
        String str;
        if (getData$okio().length == 0) {
            str = "[size=0]";
        } else {
            int access$codePointIndexToCharIndex = _ByteStringKt.access$codePointIndexToCharIndex(getData$okio(), 64);
            if (access$codePointIndexToCharIndex != -1) {
                String utf8 = utf8();
                if (utf8 != null) {
                    String substring = utf8.substring(0, access$codePointIndexToCharIndex);
                    Intrinsics.c(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    String a2 = StringsKt.a(StringsKt.a(StringsKt.a(substring, "\\", "\\\\", false, 4, (Object) null), "\n", "\\n", false, 4, (Object) null), "\r", "\\r", false, 4, (Object) null);
                    if (access$codePointIndexToCharIndex >= utf8.length()) {
                        return "[text=" + a2 + ']';
                    }
                    return "[size=" + getData$okio().length + " text=" + a2 + "…]";
                }
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            } else if (getData$okio().length > 64) {
                StringBuilder sb = new StringBuilder();
                sb.append("[size=");
                sb.append(getData$okio().length);
                sb.append(" hex=");
                int resolveDefaultParameter = _UtilKt.resolveDefaultParameter(this, 64);
                if (resolveDefaultParameter <= getData$okio().length) {
                    if (resolveDefaultParameter + 0 >= 0) {
                        sb.append((resolveDefaultParameter == getData$okio().length ? this : new ByteString(ArraysKt.a(getData$okio(), 0, resolveDefaultParameter))).hex());
                        sb.append("…]");
                        return sb.toString();
                    }
                    throw new IllegalArgumentException("endIndex < beginIndex".toString());
                }
                throw new IllegalArgumentException(("endIndex > length(" + getData$okio().length + ')').toString());
            } else {
                str = "[hex=" + hex() + ']';
            }
        }
        return str;
    }

    public String utf8() {
        String utf8$okio = getUtf8$okio();
        String str = utf8$okio;
        if (utf8$okio == null) {
            str = _JvmPlatformKt.toUtf8String(internalArray$okio());
            setUtf8$okio(str);
        }
        return str;
    }

    public void write(OutputStream out) throws IOException {
        Intrinsics.e(out, "out");
        out.write(this.data);
    }

    public void write$okio(Buffer buffer, int i, int i2) {
        Intrinsics.e(buffer, "buffer");
        _ByteStringKt.commonWrite(this, buffer, i, i2);
    }
}
