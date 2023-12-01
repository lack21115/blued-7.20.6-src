package c.t.m.g;

import java.io.ByteArrayOutputStream;
import java.util.Random;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/x2.class */
public class x2 {

    /* renamed from: a  reason: collision with root package name */
    public static final Random f4050a = new Random();
    public static final a b = new a();

    /* loaded from: source-8756600-dex2jar.jar:c/t/m/g/x2$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public w2 f4051a = new w2();
        public String b = "";

        /* renamed from: c  reason: collision with root package name */
        public boolean f4052c = false;

        public a() {
            a();
        }

        public void a() {
            a(l2.a("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDMi0gKCzapHg05OXTOlWf9sT20tJJ8C+h41HJZI+nGU2h4sdirRTUB7wdwRR1w604QZJmn55p4S9xBRVCZWIXX2kWmekr90vvvpQow55PYk1JyGXKz7a+yzQxmyEIsD4mtw+M7G76YQrgrjD42EcGH453xTUTdJGwjrn/eCJng6QIDAQAB"), "0000");
        }

        public void a(ByteArrayOutputStream byteArrayOutputStream, byte[] bArr, byte[] bArr2) {
            if (bArr2.length > 64) {
                throw new IllegalArgumentException("pwdAesBytes only support length [16/32/64].");
            }
            try {
                byteArrayOutputStream.write(this.b.getBytes("UTF-8"));
                this.f4051a.a(byteArrayOutputStream, bArr2);
                byteArrayOutputStream.write(u2.a(bArr, bArr2, bArr2));
            } catch (Throwable th) {
            }
        }

        public void a(byte[] bArr, String str) {
            int length = bArr.length;
            if (str.length() != 4 || m3.a(bArr)) {
                a();
                return;
            }
            this.b = str;
            this.f4051a.a(bArr);
        }

        public byte[] a(byte[] bArr, byte[] bArr2, boolean z) {
            byte[] bArr3 = bArr;
            if (z) {
                bArr3 = r2.a(bArr);
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            a(byteArrayOutputStream, bArr3, bArr2);
            return byteArrayOutputStream.toByteArray();
        }
    }

    public static void a(byte[] bArr, String str) {
        b.a(bArr, str);
    }

    public static byte[] a(int i) {
        byte[] bArr = new byte[i];
        f4050a.nextBytes(bArr);
        return bArr;
    }

    public static byte[] a(byte[] bArr, boolean z) {
        return a(bArr, a(16), z);
    }

    public static byte[] a(byte[] bArr, byte[] bArr2, boolean z) {
        return b.a(bArr, bArr2, z);
    }
}
