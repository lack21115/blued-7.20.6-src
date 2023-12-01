package com.tencent.cos.xml.s3;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/s3/CodecUtils.class */
public enum CodecUtils {
    ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int sanitize(String str, byte[] bArr) {
        int length = bArr.length;
        char[] charArray = str.toCharArray();
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i >= length) {
                return i3;
            }
            char c2 = charArray[i];
            int i4 = i3;
            if (c2 != '\r') {
                i4 = i3;
                if (c2 == '\n') {
                    continue;
                } else if (c2 == ' ') {
                    i4 = i3;
                } else if (c2 > 127) {
                    throw new IllegalArgumentException("Invalid character found at position " + i + " for " + str);
                } else {
                    bArr[i3] = (byte) c2;
                    i4 = i3 + 1;
                }
            }
            i++;
            i2 = i4;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void sanityCheckLastPos(int i, int i2) {
        if ((i & i2) != 0) {
            throw new IllegalArgumentException("Invalid last non-pad character detected");
        }
    }

    public static byte[] toBytesDirect(String str) {
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        byte[] bArr = new byte[length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return bArr;
            }
            char c2 = charArray[i2];
            if (c2 > 127) {
                throw new IllegalArgumentException("Invalid character found at position " + i2 + " for " + str);
            }
            bArr[i2] = (byte) c2;
            i = i2 + 1;
        }
    }

    public static String toStringDirect(byte[] bArr) {
        char[] cArr = new char[bArr.length];
        int length = bArr.length;
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i >= length) {
                return new String(cArr);
            }
            cArr[i3] = (char) bArr[i];
            i++;
            i2 = i3 + 1;
        }
    }
}
