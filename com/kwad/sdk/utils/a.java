package com.kwad.sdk.utils;

import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/utils/a.class */
public final class a {
    public static byte[] es(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return getFileMD5Digest(new File(str));
    }

    public static String getFileMD5(File file) {
        try {
            byte[] fileMD5Digest = getFileMD5Digest(file);
            if (fileMD5Digest == null || fileMD5Digest.length == 0) {
                return null;
            }
            return ad.toHexString(fileMD5Digest, 0, fileMD5Digest.length);
        } catch (IOException e) {
            com.kwad.sdk.core.d.b.e("FileMD5Utils", "cannot calculate md5 of file", e);
            return null;
        }
    }

    public static byte[] getFileMD5Digest(File file) {
        if (file == null) {
            return null;
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read == -1) {
                        return messageDigest.digest();
                    }
                    messageDigest.update(bArr, 0, read);
                }
            } catch (Exception e) {
                com.kwad.sdk.core.d.b.e("FileMD5Utils", "getting file md5 digest error.", e);
                com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream);
                return null;
            }
        } finally {
            com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream);
        }
    }
}
