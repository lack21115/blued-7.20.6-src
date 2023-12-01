package c.t.m.g;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/o2.class */
public class o2 {
    public static String a(byte[] bArr, String str) {
        StringBuilder sb = new StringBuilder();
        int length = bArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return sb.toString();
            }
            String hexString = Integer.toHexString(bArr[i2] & 255);
            String str2 = hexString;
            if (hexString.length() != 2) {
                str2 = "0" + hexString;
            }
            sb.append(str2);
            sb.append(str);
            i = i2 + 1;
        }
    }

    public static byte[] a(int i) {
        return new byte[]{(byte) (i >>> 24), (byte) (i >>> 16), (byte) (i >>> 8), (byte) i};
    }
}
