package com.ss.android.downloadlib.mb.mb;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.security.MessageDigest;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/mb/mb/b.class */
public class b {
    public static byte[] mb(InputStream inputStream, String str) throws Exception {
        MessageDigest messageDigest = MessageDigest.getInstance(str);
        byte[] bArr = new byte[4096];
        while (true) {
            int read = inputStream.read(bArr);
            if (read <= 0) {
                return messageDigest.digest();
            }
            messageDigest.update(bArr, 0, read);
        }
    }

    public static byte[] mb(CharSequence charSequence, String str) throws Exception {
        return mb(charSequence.toString().getBytes(), str);
    }

    public static byte[] mb(byte[] bArr, String str) throws Exception {
        return mb(new ByteArrayInputStream(bArr), str);
    }
}
