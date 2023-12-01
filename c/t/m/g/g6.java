package c.t.m.g;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/g6.class */
public class g6 {
    public static String a(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes("UTF-8"));
            return a(messageDigest.digest(), "");
        } catch (Exception e) {
            return str;
        }
    }

    public static String a(byte[] bArr, String str) {
        StringBuilder sb = new StringBuilder();
        int length = bArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return sb.toString();
            }
            sb.append(Integer.toHexString(bArr[i2] & 255));
            sb.append(str);
            i = i2 + 1;
        }
    }

    public static byte[] a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream);
        try {
            deflaterOutputStream.write(bArr, 0, bArr.length);
            deflaterOutputStream.finish();
            deflaterOutputStream.flush();
            deflaterOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            return null;
        }
    }

    public static byte[] b(byte[] bArr) {
        int read;
        byte[] bArr2;
        if (bArr == null) {
            return null;
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        InflaterInputStream inflaterInputStream = new InflaterInputStream(byteArrayInputStream);
        byte[] bArr3 = new byte[0];
        byte[] bArr4 = new byte[1024];
        int i = 0;
        do {
            try {
                read = inflaterInputStream.read(bArr4);
                bArr2 = bArr3;
                int i2 = i;
                if (read > 0) {
                    i2 = i + read;
                    bArr2 = new byte[i2];
                    System.arraycopy((Object) bArr3, 0, (Object) bArr2, 0, bArr3.length);
                    System.arraycopy((Object) bArr4, 0, (Object) bArr2, bArr3.length, read);
                }
                bArr3 = bArr2;
                i = i2;
            } catch (IOException | Exception e) {
                return null;
            }
        } while (read > 0);
        byteArrayInputStream.close();
        inflaterInputStream.close();
        return bArr2;
    }
}
