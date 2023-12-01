package com.kwad.sdk.api.loader;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.security.DigestInputStream;
import java.security.MessageDigest;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/api/loader/s.class */
final class s {
    private static final char[] aaD = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    private static void b(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String getFileMD5(File file) {
        DigestInputStream digestInputStream;
        DigestInputStream digestInputStream2;
        DigestInputStream digestInputStream3;
        MessageDigest messageDigest;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
            digestInputStream2 = new DigestInputStream(new FileInputStream(file), messageDigest);
            digestInputStream3 = digestInputStream2;
        } catch (Exception e) {
            e = e;
            digestInputStream2 = null;
        } catch (Throwable th) {
            th = th;
            digestInputStream = null;
            b(digestInputStream);
            throw th;
        }
        try {
            try {
                while (digestInputStream2.read(new byte[1024]) != -1) {
                }
                byte[] digest = messageDigest.digest();
                StringBuilder sb = new StringBuilder(digest.length * 2);
                int length = digest.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= length) {
                        String sb2 = sb.toString();
                        b(digestInputStream2);
                        return sb2;
                    }
                    int i3 = digest[i2] & 255;
                    if (i3 < 16) {
                        sb.append("0");
                    }
                    sb.append(Integer.toHexString(i3));
                    i = i2 + 1;
                }
            } catch (Throwable th2) {
                digestInputStream = digestInputStream3;
                th = th2;
                b(digestInputStream);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            digestInputStream3 = digestInputStream2;
            e.printStackTrace();
            b(digestInputStream2);
            return "";
        }
    }
}
