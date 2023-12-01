package libcore.icu;

import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CodingErrorAction;

/* loaded from: source-2895416-dex2jar.jar:libcore/icu/NativeConverter.class */
public final class NativeConverter {
    public static native Charset charsetForName(String str);

    public static native void closeConverter(long j);

    public static native boolean contains(String str, String str2);

    public static native int decode(long j, byte[] bArr, int i, char[] cArr, int i2, int[] iArr, boolean z);

    public static native int encode(long j, char[] cArr, int i, byte[] bArr, int i2, int[] iArr, boolean z);

    public static native String[] getAvailableCharsetNames();

    public static native float getAveBytesPerChar(long j);

    public static native float getAveCharsPerByte(long j);

    public static native int getMaxBytesPerChar(long j);

    public static native int getMinBytesPerChar(long j);

    public static native byte[] getSubstitutionBytes(long j);

    public static native long openConverter(String str);

    public static native void resetByteToChar(long j);

    public static native void resetCharToByte(long j);

    private static native void setCallbackDecode(long j, int i, int i2, String str);

    public static void setCallbackDecode(long j, CharsetDecoder charsetDecoder) {
        setCallbackDecode(j, translateCodingErrorAction(charsetDecoder.malformedInputAction()), translateCodingErrorAction(charsetDecoder.unmappableCharacterAction()), charsetDecoder.replacement());
    }

    private static native void setCallbackEncode(long j, int i, int i2, byte[] bArr);

    public static void setCallbackEncode(long j, CharsetEncoder charsetEncoder) {
        setCallbackEncode(j, translateCodingErrorAction(charsetEncoder.malformedInputAction()), translateCodingErrorAction(charsetEncoder.unmappableCharacterAction()), charsetEncoder.replacement());
    }

    private static int translateCodingErrorAction(CodingErrorAction codingErrorAction) {
        if (codingErrorAction == CodingErrorAction.REPORT) {
            return 0;
        }
        if (codingErrorAction == CodingErrorAction.IGNORE) {
            return 1;
        }
        if (codingErrorAction == CodingErrorAction.REPLACE) {
            return 2;
        }
        throw new AssertionError();
    }
}
