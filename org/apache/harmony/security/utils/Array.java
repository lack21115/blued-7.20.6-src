package org.apache.harmony.security.utils;

/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/security/utils/Array.class */
public class Array {
    private Array() {
    }

    public static String getBytesAsString(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 3);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= bArr.length) {
                return sb.toString();
            }
            sb.append(Byte.toHexString(bArr[i2], false));
            sb.append(' ');
            i = i2 + 1;
        }
    }

    public static String toString(byte[] bArr, String str) {
        int i;
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        int i2 = 0;
        while (true) {
            i = i2;
            if (i >= bArr.length) {
                break;
            }
            if (i % 16 == 0) {
                sb.append(str);
                String hexString = Integer.toHexString(i);
                sb.append(new String[]{"", "000", "00", "0", ""}[hexString.length()]);
                sb.append(hexString);
                sb2.delete(0, sb2.length());
            }
            sb.append(' ');
            sb.append(Byte.toHexString(bArr[i], false));
            char c = (char) (65535 & bArr[i] & 255);
            char c2 = c;
            if (Character.isISOControl(c)) {
                c2 = '.';
            }
            sb2.append(c2);
            if ((i + 1) % 8 == 0) {
                sb.append(' ');
            }
            if ((i + 1) % 16 == 0) {
                sb.append(' ');
                sb.append(sb2.toString());
                sb.append('\n');
            }
            i2 = i + 1;
        }
        if (i % 16 != 0) {
            int i3 = 16 - (i % 16);
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 >= i3) {
                    break;
                }
                sb.append("   ");
                i4 = i5 + 1;
            }
            if (i3 > 8) {
                sb.append(' ');
            }
            sb.append("  ");
            sb.append(sb2.toString());
            sb.append('\n');
        }
        return sb.toString();
    }
}
