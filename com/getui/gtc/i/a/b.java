package com.getui.gtc.i.a;

import com.getui.gtc.base.crypt.CryptTools;
import javax.crypto.spec.IvParameterSpec;

/* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/i/a/b.class */
public final class b {
    public static byte[] a(byte[] bArr, String str) {
        return a(bArr, str.getBytes());
    }

    private static byte[] a(byte[] bArr, byte[] bArr2) {
        int length = bArr2.length;
        boolean z = false;
        if (length > 0) {
            z = false;
            if (length <= 256) {
                int i = 0;
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i >= length) {
                        z = true;
                        break;
                    }
                    int i4 = i3;
                    if ((bArr2[i] & 255) == 14) {
                        i4 = i3 + 1;
                        z = false;
                        if (i4 > 3) {
                            break;
                        }
                    }
                    i++;
                    i2 = i4;
                }
            }
        }
        if (z) {
            if (bArr.length > 0) {
                try {
                    return CryptTools.encrypt("RC4", CryptTools.wrapperKey("RC4", bArr2), (IvParameterSpec) null, bArr);
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            }
            throw new IllegalArgumentException("data is fail!");
        }
        throw new IllegalArgumentException("key is fail!");
    }
}
