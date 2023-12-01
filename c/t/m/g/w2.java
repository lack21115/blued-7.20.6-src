package c.t.m.g;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/w2.class */
public class w2 {

    /* renamed from: a  reason: collision with root package name */
    public byte[] f3988a = new byte[0];
    public PublicKey b;

    public static String a(String str) {
        String str2 = str;
        if (str.contains("-----")) {
            str2 = str.split("-----")[2];
        }
        return str2.replaceAll("\n", "");
    }

    public final void a(ByteArrayOutputStream byteArrayOutputStream, Cipher cipher, byte[] bArr, int i, int i2, int i3) throws BadPaddingException, IllegalBlockSizeException, IOException {
        synchronized (this.f3988a) {
            while (i2 > 0) {
                int min = Math.min(i2, i3);
                byteArrayOutputStream.write(cipher.doFinal(bArr, i, min));
                i += min;
                i2 -= min;
            }
        }
    }

    public void a(ByteArrayOutputStream byteArrayOutputStream, byte[] bArr) {
        a(byteArrayOutputStream, bArr, 0, bArr.length);
    }

    public void a(ByteArrayOutputStream byteArrayOutputStream, byte[] bArr, int i, int i2) {
        synchronized (this.f3988a) {
            try {
                Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
                cipher.init(1, this.b);
                a(byteArrayOutputStream, cipher, bArr, i, i2, 117);
            } catch (Throwable th) {
            }
        }
    }

    public void a(byte[] bArr) {
        synchronized (this.f3988a) {
            try {
                this.b = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(bArr));
            } catch (Throwable th) {
            }
        }
    }
}
