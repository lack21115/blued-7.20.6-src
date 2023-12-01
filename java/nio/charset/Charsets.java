package java.nio.charset;

/* loaded from: source-2895416-dex2jar.jar:java/nio/charset/Charsets.class */
public final class Charsets {
    private Charsets() {
    }

    public static native void asciiBytesToChars(byte[] bArr, int i, int i2, char[] cArr);

    public static native void isoLatin1BytesToChars(byte[] bArr, int i, int i2, char[] cArr);

    public static native byte[] toAsciiBytes(char[] cArr, int i, int i2);

    public static byte[] toBigEndianUtf16Bytes(char[] cArr, int i, int i2) {
        byte[] bArr = new byte[i2 * 2];
        int i3 = 0;
        for (int i4 = i; i4 < i + i2; i4++) {
            char c = cArr[i4];
            int i5 = i3 + 1;
            bArr[i3] = (byte) (c >> '\b');
            i3 = i5 + 1;
            bArr[i5] = (byte) c;
        }
        return bArr;
    }

    public static native byte[] toIsoLatin1Bytes(char[] cArr, int i, int i2);

    public static native byte[] toUtf8Bytes(char[] cArr, int i, int i2);
}
