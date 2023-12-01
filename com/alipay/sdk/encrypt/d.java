package com.alipay.sdk.encrypt;

import android.text.TextUtils;
import java.security.SecureRandom;
import javax.crypto.Cipher;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-6737240-dex2jar.jar:com/alipay/sdk/encrypt/d.class */
public class d {
    d() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] a(Cipher cipher, String str) {
        SecureRandom secureRandom = new SecureRandom();
        int blockSize = cipher.getBlockSize();
        String str2 = str;
        if (TextUtils.isEmpty(str)) {
            str2 = String.valueOf(secureRandom.nextDouble());
        }
        int i = blockSize * 2;
        byte[] bArr = new byte[i];
        byte[] bArr2 = new byte[blockSize];
        secureRandom.nextBytes(bArr2);
        int i2 = 1;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                System.arraycopy((Object) bArr, blockSize, (Object) bArr2, 0, blockSize);
                return bArr2;
            }
            bArr[i3] = (byte) (str2.codePointAt(i3 % str2.length()) & 127);
            if (i3 >= blockSize) {
                bArr[i3] = (byte) (bArr[0] & bArr[i3]);
            }
            i2 = i3 + 1;
        }
    }
}
