package com.ishumei.l111l1111llIl;

import android.text.TextUtils;
import java.util.Locale;
import java.util.Random;

/* loaded from: source-7994992-dex2jar.jar:com/ishumei/l111l1111llIl/l111l1111lI1l.class */
public final class l111l1111lI1l {
    public static String l1111l111111Il() {
        return String.format(Locale.CHINA, "%d-%05d", Long.valueOf(System.currentTimeMillis()), Integer.valueOf(new Random().nextInt(100000)));
    }

    private static String l1111l111111Il(int i) {
        char[] cArr = new char[i];
        Random random = new Random();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                return new String(cArr);
            }
            cArr[i3] = (char) (random.nextInt(26) + 97);
            i2 = i3 + 1;
        }
    }

    private static String l1111l111111Il(byte[] bArr) {
        int i;
        StringBuilder sb = new StringBuilder(bArr.length << 1);
        int length = bArr.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                return sb.toString();
            }
            int i4 = bArr[i3];
            while (true) {
                i = i4;
                if (i >= 0) {
                    break;
                }
                i4 = i + 256;
            }
            if (i < 16) {
                sb.append("0");
            }
            sb.append(Integer.toString(i, 16));
            i2 = i3 + 1;
        }
    }

    public static boolean l1111l111111Il(String str) {
        return str == null || str.isEmpty();
    }

    public static boolean l1111l111111Il(String str, String str2) {
        return TextUtils.equals(str, str2);
    }

    public static boolean l111l11111I1l(String str) {
        return l1111l111111Il(str == null ? null : str.trim());
    }

    public static String l111l11111Il(String str) {
        return new String(l111l11111lIl(l111l1111lIl(str)));
    }

    public static boolean l111l11111lIl(String str) {
        return !l1111l111111Il(str);
    }

    private static byte[] l111l11111lIl(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= bArr.length) {
                return bArr2;
            }
            bArr2[i2] = bArr[i2];
            i = i2 + 1;
        }
    }

    private static String l111l1111l1Il(String str) {
        if (str == null) {
            return null;
        }
        return str.trim();
    }

    private static String l111l1111lI1l(String str) {
        String str2 = str;
        if (str == null) {
            str2 = "";
        }
        return str2;
    }

    private static byte[] l111l1111lIl(String str) {
        byte[] bytes = str.getBytes();
        int length = bytes.length;
        byte[] bArr = new byte[length / 2];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return bArr;
            }
            bArr[i2 / 2] = (byte) Integer.parseInt(new String(bytes, i2, 2), 16);
            i = i2 + 2;
        }
    }

    private static boolean l111l1111llIl(String str) {
        return !l111l11111I1l(str);
    }

    private static String l11l1111lIIl(String str) {
        int i;
        byte[] l111l11111lIl = l111l11111lIl(str.getBytes());
        StringBuilder sb = new StringBuilder(l111l11111lIl.length << 1);
        int length = l111l11111lIl.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                return sb.toString();
            }
            int i4 = l111l11111lIl[i3];
            while (true) {
                i = i4;
                if (i >= 0) {
                    break;
                }
                i4 = i + 256;
            }
            if (i < 16) {
                sb.append("0");
            }
            sb.append(Integer.toString(i, 16));
            i2 = i3 + 1;
        }
    }
}
