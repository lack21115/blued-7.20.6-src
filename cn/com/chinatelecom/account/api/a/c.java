package cn.com.chinatelecom.account.api.a;

/* loaded from: source-8756600-dex2jar.jar:cn/com/chinatelecom/account/api/a/c.class */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f4090a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static String a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= bArr.length) {
                return sb.toString();
            }
            sb.append(f4090a[(bArr[i2] >> 4) & 15]);
            sb.append(f4090a[bArr[i2] & 15]);
            i = i2 + 1;
        }
    }

    public static byte[] a(String str) {
        if (str == null) {
            return null;
        }
        char[] charArray = str.toCharArray();
        int length = charArray.length / 2;
        byte[] bArr = new byte[length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return bArr;
            }
            int i3 = i2 * 2;
            int digit = Character.digit(charArray[i3 + 1], 16) | (Character.digit(charArray[i3], 16) << 4);
            int i4 = digit;
            if (digit > 127) {
                i4 = digit - 256;
            }
            bArr[i2] = (byte) i4;
            i = i2 + 1;
        }
    }
}
