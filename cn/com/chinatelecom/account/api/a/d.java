package cn.com.chinatelecom.account.api.a;

import java.nio.charset.Charset;

/* loaded from: source-8756600-dex2jar.jar:cn/com/chinatelecom/account/api/a/d.class */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static final String f4091a = d.class.getSimpleName();
    private static final Charset b = Charset.forName("UTF-8");

    /* renamed from: c  reason: collision with root package name */
    private static byte[] f4092c = {68, 64, 94, 49, 50, 83};

    public static String a(byte[] bArr) {
        try {
            int length = bArr.length;
            byte[] bArr2 = new byte[length];
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return new String(bArr2);
                }
                bArr2[i2] = bArr[i2];
                byte[] bArr3 = f4092c;
                int length2 = bArr3.length;
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 < length2) {
                        bArr2[i2] = (byte) (bArr3[i4] ^ bArr2[i2]);
                        i3 = i4 + 1;
                    }
                }
                i = i2 + 1;
            }
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }
}
